package dao;

import model.Pengaduan;
import util.AppException;
import util.Konstanta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PengaduanDao extends BaseDao {

    private static final String SELECT =
            "SELECT a.*, p.nama AS nama_pelanggan, k.nama AS nama_petugas FROM pengaduan a "
          + "JOIN pelanggan p ON p.id_pelanggan=a.id_pelanggan "
          + "LEFT JOIN karyawan k ON k.id_karyawan=a.id_petugas_lapangan ";

    private Pengaduan map(ResultSet rs) throws SQLException {
        Pengaduan a = new Pengaduan();
        a.setId(rs.getInt("id_pengaduan"));
        a.setLokasi(rs.getString("lokasi"));
        a.setTanggalLapor(waktu(rs.getTimestamp("tanggal_lapor")));
        a.setTanggalSelesai(waktu(rs.getTimestamp("tanggal_selesai")));
        a.setDeskripsi(rs.getString("deskripsi"));
        a.setStatus(rs.getString("status"));
        a.setIdPelanggan(rs.getInt("id_pelanggan"));
        int pt = rs.getInt("id_petugas_lapangan");
        a.setIdPetugas(rs.wasNull() ? null : pt);
        double la = rs.getDouble("lintang");
        a.setLintang(rs.wasNull() ? null : la);
        double lo = rs.getDouble("bujur");
        a.setBujur(rs.wasNull() ? null : lo);
        a.setNamaPelanggan(rs.getString("nama_pelanggan"));
        a.setNamaPetugas(rs.getString("nama_petugas"));
        return a;
    }

    public int insert(Pengaduan a) {
        String sql = "INSERT INTO pengaduan(lokasi,tanggal_lapor,deskripsi,status,id_pelanggan,lintang,bujur) VALUES(?,?,?,?,?,?,?)";
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, a.getLokasi());
            ps.setTimestamp(2, Timestamp.valueOf(java.time.LocalDateTime.now()));
            ps.setString(3, a.getDeskripsi());
            ps.setString(4, Konstanta.ADUAN_DIAJUKAN);
            ps.setInt(5, a.getIdPelanggan());
            ps.setBigDecimal(6, java.math.BigDecimal.valueOf(a.getLintang()).setScale(6, java.math.RoundingMode.HALF_UP));
            ps.setBigDecimal(7, java.math.BigDecimal.valueOf(a.getBujur()).setScale(6, java.math.RoundingMode.HALF_UP));
            ps.executeUpdate();
            try (ResultSet k = ps.getGeneratedKeys()) { k.next(); return k.getInt(1); }
        } catch (SQLException e) { throw gagal("Gagal mengirim pengaduan", e); }
    }

    public List<Pengaduan> findAll() { return query(SELECT + "ORDER BY a.tanggal_lapor DESC", null); }

    public List<Pengaduan> findByPelanggan(int idPelanggan) {
        return query(SELECT + "WHERE a.id_pelanggan=? ORDER BY a.tanggal_lapor DESC", idPelanggan);
    }

    private List<Pengaduan> query(String sql, Integer param) {
        List<Pengaduan> list = new ArrayList<>();
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(sql)) {
            if (param != null) ps.setInt(1, param);
            try (ResultSet rs = ps.executeQuery()) { while (rs.next()) list.add(map(rs)); }
            return list;
        } catch (SQLException e) { throw gagal("Gagal membaca pengaduan", e); }
    }

    /** Status 'selesai' otomatis mengisi tanggal_selesai; petugas pencatat disimpan di id_petugas_lapangan. */
    public void updateStatus(int idPengaduan, String status, int idPetugas) {
        boolean selesai = Konstanta.ADUAN_SELESAI.equals(status);
        // Selesai: isi tanggal_selesai bila masih kosong; status lain: kosongkan kembali.
        String sql = "UPDATE pengaduan SET status=?, id_petugas_lapangan=?, tanggal_selesai="
                   + (selesai ? "COALESCE(tanggal_selesai, ?)" : "NULL") + " WHERE id_pengaduan=?";
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(sql)) {
            int i = 1;
            ps.setString(i++, status);
            ps.setInt(i++, idPetugas);
            if (selesai) ps.setTimestamp(i++, Timestamp.valueOf(java.time.LocalDateTime.now()));
            ps.setInt(i, idPengaduan);
            if (ps.executeUpdate() == 0) throw new AppException("Pengaduan tidak ditemukan (mungkin sudah dihapus).");
        } catch (SQLException e) { throw gagal("Gagal memperbarui status pengaduan", e); }
    }
}
