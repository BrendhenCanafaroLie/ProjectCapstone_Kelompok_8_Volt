package dao;

import model.Pembayaran;
import util.AppException;
import util.Konstanta;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PembayaranDao extends BaseDao {

    private static final String SELECT =
            "SELECT b.*, p.nama AS nama_pelanggan, t.bulan, t.tahun, k.nama AS nama_kasir "
          + "FROM pembayaran b JOIN tagihan t ON t.id_tagihan=b.id_tagihan "
          + "JOIN pelanggan p ON p.id_pelanggan=t.id_pelanggan "
          + "LEFT JOIN karyawan k ON k.id_karyawan=b.id_kasir ";

    private Pembayaran map(ResultSet rs) throws SQLException {
        Pembayaran b = new Pembayaran();
        b.setId(rs.getInt("id_pembayaran"));
        b.setNoStruk(rs.getString("no_struk"));
        b.setTanggalBayar(waktu(rs.getTimestamp("tanggal_bayar")));
        b.setJumlah(rs.getBigDecimal("jumlah_bayar"));
        b.setMetode(rs.getString("metode"));
        b.setIdTagihan(rs.getInt("id_tagihan"));
        int k = rs.getInt("id_kasir");
        b.setIdKasir(rs.wasNull() ? null : k);
        b.setNamaPelanggan(rs.getString("nama_pelanggan"));
        b.setPeriode(String.format("%02d/%s", util.Bulan.angka(rs.getString("bulan")), rs.getString("tahun")));
        b.setNamaKasir(rs.getString("nama_kasir"));
        return b;
    }

    /**
     * Transaksi pembayaran SEKALI LUNAS (tanpa cicilan): cek tagihan belum lunas -> insert satu pembayaran
     * sebesar total tagihan -> status tagihan langsung menjadi LUNAS (atau TERLAMBAT bila melewati
     * jatuh tempo). idKasir = null untuk pembayaran online. Nominal ditentukan sistem, bukan input pengguna.
     */
    public Pembayaran bayar(int idTagihan, Integer idKasir, String metode) {
        int idBayar;
        try (Connection c = conn()) {
            c.setAutoCommit(false);
            try {
                String status;
                BigDecimal total;
                LocalDate jatuhTempo;
                try (PreparedStatement ps = c.prepareStatement(
                        "SELECT status,total_biaya,jatuh_tempo FROM tagihan WHERE id_tagihan=? FOR UPDATE")) {
                    ps.setInt(1, idTagihan);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next()) throw new AppException("Tagihan tidak ditemukan.");
                        status = rs.getString(1);
                        total = rs.getBigDecimal(2);
                        jatuhTempo = rs.getDate(3).toLocalDate();
                    }
                }
                if (!Konstanta.belumLunas(status)) throw new AppException("Tagihan Sudah Lunas");

                // Pembayaran hanya satu kali dan harus sebesar total tagihan.
                BigDecimal sudah;
                try (PreparedStatement ps = c.prepareStatement(
                        "SELECT COALESCE(SUM(jumlah_bayar),0) FROM pembayaran WHERE id_tagihan=?")) {
                    ps.setInt(1, idTagihan);
                    try (ResultSet rs = ps.executeQuery()) { rs.next(); sudah = rs.getBigDecimal(1); }
                }
                // sudah > 0 hanya mungkin dari data lama (era cicilan): lunasi sisanya sekaligus.
                BigDecimal jumlah = total.subtract(sudah);
                if (jumlah.signum() <= 0) throw new AppException("Tagihan Sudah Lunas");

                int urut;
                try (Statement st = c.createStatement(); ResultSet rs = st.executeQuery(
                        "SELECT COALESCE(MAX(id_pembayaran),0)+1 FROM pembayaran")) { rs.next(); urut = rs.getInt(1); }
                LocalDateTime sekarang = LocalDateTime.now();
                String struk = "STR-" + DateTimeFormatter.ofPattern("yyyyMM").format(sekarang) + "-" + String.format("%04d", urut);

                try (PreparedStatement ps = c.prepareStatement(
                        "INSERT INTO pembayaran(no_struk,tanggal_bayar,jumlah_bayar,metode,id_tagihan,id_kasir) VALUES(?,?,?,?,?,?)",
                        Statement.RETURN_GENERATED_KEYS)) {
                    ps.setString(1, struk);
                    ps.setTimestamp(2, Timestamp.valueOf(sekarang));
                    ps.setBigDecimal(3, jumlah);
                    ps.setString(4, metode);
                    ps.setInt(5, idTagihan);
                    if (idKasir == null) ps.setNull(6, Types.INTEGER); else ps.setInt(6, idKasir);
                    ps.executeUpdate();
                    try (ResultSet rs = ps.getGeneratedKeys()) { rs.next(); idBayar = rs.getInt(1); }
                }
                String baru = LocalDate.now().isAfter(jatuhTempo) ? Konstanta.TAGIHAN_TERLAMBAT : Konstanta.TAGIHAN_LUNAS;
                try (PreparedStatement ps = c.prepareStatement("UPDATE tagihan SET status=? WHERE id_tagihan=?")) {
                    ps.setString(1, baru);
                    ps.setInt(2, idTagihan);
                    ps.executeUpdate();
                }
                c.commit();
            } catch (SQLException | RuntimeException e) {
                c.rollback();
                throw e;
            }
        } catch (SQLException e) { throw gagal("Pembayaran gagal", e); }
        return findById(idBayar);
    }

    public Pembayaran findById(int id) {
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(SELECT + "WHERE b.id_pembayaran=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) { return rs.next() ? map(rs) : null; }
        } catch (SQLException e) { throw gagal("Gagal membaca pembayaran", e); }
    }

    public List<Pembayaran> findAll() { return query(SELECT + "ORDER BY b.tanggal_bayar DESC", null); }

    public List<Pembayaran> findByKasir(int idKasir) {
        return query(SELECT + "WHERE b.id_kasir=? ORDER BY b.tanggal_bayar DESC", idKasir);
    }

    private List<Pembayaran> query(String sql, Integer param) {
        List<Pembayaran> list = new ArrayList<>();
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(sql)) {
            if (param != null) ps.setInt(1, param);
            try (ResultSet rs = ps.executeQuery()) { while (rs.next()) list.add(map(rs)); }
            return list;
        } catch (SQLException e) { throw gagal("Gagal membaca pembayaran", e); }
    }
}
