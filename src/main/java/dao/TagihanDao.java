package dao;

import model.Tagihan;
import util.Konstanta;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TagihanDao extends BaseDao {

    private static final String SELECT =
            "SELECT t.*, p.nama AS nama_pelanggan, p.nomor_meter, k.nama AS nama_kasir "
          + "FROM tagihan t JOIN pelanggan p ON p.id_pelanggan=t.id_pelanggan "
          + "LEFT JOIN karyawan k ON k.id_karyawan=t.id_kasir ";

    private Tagihan map(ResultSet rs) throws SQLException {
        Tagihan t = new Tagihan();
        t.setId(rs.getInt("id_tagihan"));
        t.setBulan(util.Bulan.angka(rs.getString("bulan")));
        t.setTahun(Integer.parseInt(rs.getString("tahun").trim()));
        t.setMeterAwal(rs.getBigDecimal("meter_awal"));
        t.setMeterAkhir(rs.getBigDecimal("meter_akhir"));
        t.setKwh(rs.getBigDecimal("jumlah_pemakaian_kwh"));
        t.setTotal(rs.getBigDecimal("total_biaya"));
        t.setJatuhTempo(rs.getDate("jatuh_tempo").toLocalDate());
        t.setStatus(rs.getString("status"));
        t.setIdPelanggan(rs.getInt("id_pelanggan"));
        t.setIdPetugas(rs.getInt("id_petugas_lapangan"));
        int kasir = rs.getInt("id_kasir");
        t.setIdKasir(rs.wasNull() ? null : kasir);
        t.setNamaKasir(rs.getString("nama_kasir"));
        t.setNamaPelanggan(rs.getString("nama_pelanggan"));
        t.setNomorMeter(rs.getString("nomor_meter"));
        return t;
    }

    /** Database tidak punya trigger: kWh dan total_biaya sudah dihitung controller. */
    public int insert(Tagihan t) {
        String sql = "INSERT INTO tagihan(id_pelanggan,bulan,tahun,meter_awal,meter_akhir,jumlah_pemakaian_kwh,"
                   + "total_biaya,jatuh_tempo,status,id_petugas_lapangan,id_kasir) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, t.getIdPelanggan());
            ps.setString(2, util.Bulan.nama(t.getBulan()));
            ps.setString(3, String.valueOf(t.getTahun()));
            ps.setBigDecimal(4, t.getMeterAwal());
            ps.setBigDecimal(5, t.getMeterAkhir());
            ps.setBigDecimal(6, t.getKwh());
            ps.setBigDecimal(7, t.getTotal());
            ps.setDate(8, Date.valueOf(t.getJatuhTempo()));
            ps.setString(9, Konstanta.TAGIHAN_BELUM);
            ps.setInt(10, t.getIdPetugas());
            if (t.getIdKasir() == null) ps.setNull(11, Types.INTEGER); else ps.setInt(11, t.getIdKasir());
            ps.executeUpdate();
            try (ResultSet k = ps.getGeneratedKeys()) { k.next(); return k.getInt(1); }
        } catch (SQLException e) { throw gagal("Gagal menyimpan tagihan", e); }
    }

    /**
     * Kasir penanggung jawab (tagihan.id_kasir wajib terisi di database): dipilih otomatis,
     * yaitu kasir dengan jumlah tagihan belum lunas paling sedikit (seri -> id terkecil).
     */
    public Integer kasirBebanTerendah() {
        String sql = "SELECT ks.id_karyawan FROM kasir ks "
                   + "LEFT JOIN tagihan t ON t.id_kasir=ks.id_karyawan AND REPLACE(UPPER(t.status),' ','_')=? "
                   + "GROUP BY ks.id_karyawan ORDER BY COUNT(t.id_tagihan), ks.id_karyawan LIMIT 1";
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, Konstanta.normStatus(Konstanta.TAGIHAN_BELUM));
            try (ResultSet rs = ps.executeQuery()) { return rs.next() ? rs.getInt(1) : null; }
        } catch (SQLException e) { throw gagal("Gagal menentukan kasir penanggung jawab", e); }
    }

    public boolean periodeAda(int idPelanggan, int bulan, int tahun) {
        String sql = "SELECT 1 FROM tagihan WHERE id_pelanggan=? AND "+util.Bulan.sql("bulan")+"=? AND CAST(tahun AS UNSIGNED)=?";
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, idPelanggan); ps.setInt(2, bulan); ps.setInt(3, tahun);
            try (ResultSet rs = ps.executeQuery()) { return rs.next(); }
        } catch (SQLException e) { throw gagal("Gagal cek periode", e); }
    }

    /** Meter akhir tagihan terakhir pelanggan (saran untuk meter awal), atau null. */
    public BigDecimal meterAkhirTerakhir(int idPelanggan) {
        String sql = "SELECT meter_akhir FROM tagihan WHERE id_pelanggan=? "
                   + "ORDER BY CAST(tahun AS UNSIGNED) DESC, " + util.Bulan.sql("bulan") + " DESC LIMIT 1";
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, idPelanggan);
            try (ResultSet rs = ps.executeQuery()) { return rs.next() ? rs.getBigDecimal(1) : null; }
        } catch (SQLException e) { throw gagal("Gagal membaca meter", e); }
    }

    public Tagihan findById(int id) {
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(SELECT + "WHERE t.id_tagihan=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) { return rs.next() ? map(rs) : null; }
        } catch (SQLException e) { throw gagal("Gagal membaca tagihan", e); }
    }

    public List<Tagihan> findByPelanggan(int idPelanggan) {
        List<Tagihan> list = new ArrayList<>();
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(
                SELECT + "WHERE t.id_pelanggan=? ORDER BY CAST(t.tahun AS UNSIGNED) DESC, " + util.Bulan.sql("t.bulan") + " DESC")) {
            ps.setInt(1, idPelanggan);
            try (ResultSet rs = ps.executeQuery()) { while (rs.next()) list.add(map(rs)); }
            return list;
        } catch (SQLException e) { throw gagal("Gagal membaca tagihan", e); }
    }

    /** Tagihan yang belum lunas (cari berdasarkan nama atau nomor meter). */
    public List<Tagihan> findBelumLunas(String kata) {
        List<Tagihan> list = new ArrayList<>();
        String sql = SELECT + "WHERE REPLACE(UPPER(t.status),' ','_')=? AND (p.nama LIKE ? OR p.nomor_meter LIKE ?) ORDER BY t.jatuh_tempo";
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(sql)) {
            String like = "%" + (kata == null ? "" : kata.trim()) + "%";
            ps.setString(1, Konstanta.normStatus(Konstanta.TAGIHAN_BELUM)); ps.setString(2, like); ps.setString(3, like);
            try (ResultSet rs = ps.executeQuery()) { while (rs.next()) list.add(map(rs)); }
            return list;
        } catch (SQLException e) { throw gagal("Gagal membaca tagihan", e); }
    }
}
