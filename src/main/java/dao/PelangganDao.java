package dao;

import model.*;
import util.Konstanta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PelangganDao extends BaseDao {

    private static final String SELECT =
            "SELECT p.*, g.kode_golongan, rt.nik, rt.kategori_subsidi, u.npwp, u.nama_usaha "
          + "FROM pelanggan p JOIN golongan g ON g.id_golongan=p.id_golongan "
          + "LEFT JOIN rumah_tangga rt ON rt.id_pelanggan=p.id_pelanggan "
          + "LEFT JOIN usaha u ON u.id_pelanggan=p.id_pelanggan ";

    /** POLIMORFISME: baris DB dipetakan ke subclass yang sesuai jenisnya. */
    private Pelanggan map(ResultSet rs) throws SQLException {
        int id = rs.getInt("id_pelanggan");
        if (Konstanta.JENIS_USAHA.equals(rs.getString("jenis_pelanggan"))) {
            return new PelangganUsaha(id, rs.getString("nama"), rs.getString("no_telepon"), rs.getString("username"),
                    rs.getString("nomor_meter"), rs.getString("alamat"), rs.getString("status_akun"),
                    rs.getInt("id_golongan"), rs.getString("kode_golongan"),
                    rs.getString("npwp"), rs.getString("nama_usaha"));
        }
        return new PelangganRumahTangga(id, rs.getString("nama"), rs.getString("no_telepon"), rs.getString("username"),
                rs.getString("nomor_meter"), rs.getString("alamat"), rs.getString("status_akun"),
                rs.getInt("id_golongan"), rs.getString("kode_golongan"),
                rs.getString("nik"), rs.getString("kategori_subsidi"));
    }

    public Pelanggan login(String username, String hash) {
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(SELECT + "WHERE p.username=? AND p.password = BINARY ?")) {
            ps.setString(1, username);
            ps.setString(2, hash);
            try (ResultSet rs = ps.executeQuery()) { return rs.next() ? map(rs) : null; }
        } catch (SQLException e) { throw gagal("Gagal login", e); }
    }

    public Pelanggan findById(int id) {
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(SELECT + "WHERE p.id_pelanggan=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) { return rs.next() ? map(rs) : null; }
        } catch (SQLException e) { throw gagal("Gagal membaca pelanggan", e); }
    }

    public List<Pelanggan> findByStatus(String status) {
        List<Pelanggan> list = new ArrayList<>();
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(SELECT + "WHERE p.status_akun=? ORDER BY p.id_pelanggan")) {
            ps.setString(1, status);
            try (ResultSet rs = ps.executeQuery()) { while (rs.next()) list.add(map(rs)); }
            return list;
        } catch (SQLException e) { throw gagal("Gagal membaca pelanggan", e); }
    }

    /** Semua pelanggan; yang berstatus Menunggu ditampilkan lebih dulu. */
    public List<Pelanggan> findAll() {
        List<Pelanggan> list = new ArrayList<>();
        String sql = SELECT + "ORDER BY FIELD(p.status_akun,'" + Konstanta.AKUN_MENUNGGU + "','" + Konstanta.AKUN_AKTIF
                + "','" + Konstanta.AKUN_TIDAK_AKTIF + "'), p.id_pelanggan";
        try (Connection c = conn(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) list.add(map(rs));
            return list;
        } catch (SQLException e) { throw gagal("Gagal membaca pelanggan", e); }
    }

    public boolean usernameAda(String username) { return ada("username", username); }
    public boolean nomorMeterAda(String meter) { return ada("nomor_meter", meter); }

    private boolean ada(String kolom, String nilai) {
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement("SELECT 1 FROM pelanggan WHERE " + kolom + "=?")) {
            ps.setString(1, nilai);
            try (ResultSet rs = ps.executeQuery()) { return rs.next(); }
        } catch (SQLException e) { throw gagal("Gagal validasi data", e); }
    }

    /** Simpan pelanggan baru (status 'tidak aktif' -> masuk antrian validasi admin). Transaksi 2 tabel. */
    public int daftar(Pelanggan p) {
        String sql = "INSERT INTO pelanggan(nomor_meter,nama,alamat,no_telepon,jenis_pelanggan,username,password,status_akun,id_golongan)"
                   + " VALUES(?,?,?,?,?,?,?,?,?)";
        try (Connection c = conn()) {
            c.setAutoCommit(false);
            try {
                int id;
                try (PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                    ps.setString(1, p.getNomorMeter());
                    ps.setString(2, p.getNama());
                    ps.setString(3, p.getAlamat());
                    ps.setString(4, p.getNoTelepon());
                    ps.setString(5, p.getJenis());
                    ps.setString(6, p.getUsername());
                    ps.setString(7, p.getPasswordHash());
                    ps.setString(8, Konstanta.AKUN_MENUNGGU);
                    ps.setInt(9, p.getIdGolongan());
                    ps.executeUpdate();
                    try (ResultSet rs = ps.getGeneratedKeys()) { rs.next(); id = rs.getInt(1); }
                }
                if (p instanceof PelangganRumahTangga rt) {
                    try (PreparedStatement ps = c.prepareStatement(
                            "INSERT INTO rumah_tangga(id_pelanggan,nik,kategori_subsidi) VALUES(?,?,?)")) {
                        ps.setInt(1, id); ps.setString(2, rt.getNik()); ps.setString(3, rt.getKategoriSubsidi());
                        ps.executeUpdate();
                    }
                } else if (p instanceof PelangganUsaha u) {
                    try (PreparedStatement ps = c.prepareStatement(
                            "INSERT INTO usaha(id_pelanggan,npwp,nama_usaha) VALUES(?,?,?)")) {
                        ps.setInt(1, id); ps.setString(2, u.getNpwp()); ps.setString(3, u.getNamaUsaha());
                        ps.executeUpdate();
                    }
                }
                c.commit();
                return id;
            } catch (SQLException | RuntimeException e) {
                c.rollback();
                throw e;
            }
        } catch (SQLException e) { throw gagal("Pendaftaran gagal", e); }
    }

    public void updateProfil(int id, String username, String alamat, String telp, String hashBaru) {
        String sql = "UPDATE pelanggan SET username=?,alamat=?,no_telepon=?" + (hashBaru != null ? ",password=?" : "") + " WHERE id_pelanggan=?";
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(sql)) {
            int i = 1;
            ps.setString(i++, username);
            ps.setString(i++, alamat);
            ps.setString(i++, telp);
            if (hashBaru != null) ps.setString(i++, hashBaru);
            ps.setInt(i, id);
            ps.executeUpdate();
        } catch (SQLException e) { throw gagal("Gagal memperbarui profil", e); }
    }

    public void updateStatus(int id, String status) {
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement("UPDATE pelanggan SET status_akun=? WHERE id_pelanggan=?")) {
            ps.setString(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) { throw gagal("Gagal memperbarui status akun", e); }
    }
}
