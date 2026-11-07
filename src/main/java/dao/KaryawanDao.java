package dao;

import model.*;
import util.AppException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/** CRUD untuk karyawan berjabatan Kasir / Petugas Lapangan + login semua karyawan. */
public class KaryawanDao extends BaseDao implements CrudDao<Karyawan, Integer> {

    /** Login karyawan; mengembalikan subclass sesuai jabatan (POLIMORFISME). */
    public Karyawan login(String username, String hash) {
        String sql = "SELECT id_karyawan,nama,no_telepon,username FROM karyawan WHERE username=? AND password = BINARY ?";
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, hash);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;
                return tentukanJabatan(c, rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (SQLException e) { throw gagal("Gagal login", e); }
    }

    private static java.time.LocalDate tglDari(Date d) { return d == null ? null : d.toLocalDate(); }

    private Karyawan tentukanJabatan(Connection c, int id, String nama, String telp, String user) throws SQLException {
        try (PreparedStatement ps = c.prepareStatement("SELECT email FROM admin WHERE id_karyawan=?")) {
            ps.setInt(1, id);
            try (ResultSet r = ps.executeQuery()) { if (r.next()) return new Admin(id, nama, telp, user, r.getString(1)); }
        }
        try (PreparedStatement ps = c.prepareStatement("SELECT status_setoran,tanggal_setor FROM kasir WHERE id_karyawan=?")) {
            ps.setInt(1, id);
            try (ResultSet r = ps.executeQuery()) {
                if (r.next()) return new Kasir(id, nama, telp, user, r.getString(1), tglDari(r.getDate(2)));
            }
        }
        try (PreparedStatement ps = c.prepareStatement("SELECT wilayah_tugas,spesialis FROM petugas_lapangan WHERE id_karyawan=?")) {
            ps.setInt(1, id);
            try (ResultSet r = ps.executeQuery()) {
                if (r.next()) return new PetugasLapangan(id, nama, telp, user, r.getString(1), r.getString(2));
            }
        }
        throw new AppException("Akun karyawan ini belum memiliki jabatan.");
    }

    /** Muat ulang akun karyawan (semua jabatan, termasuk Admin) berdasarkan id; dipakai halaman profil sendiri. */
    public Karyawan muatProfil(int id) {
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(
                "SELECT nama,no_telepon,username FROM karyawan WHERE id_karyawan=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) throw new AppException("Akun tidak ditemukan.");
                return tentukanJabatan(c, id, rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) { throw gagal("Gagal memuat profil", e); }
    }

    /** Hanya mengubah atribut khusus Admin (email); atribut supertype (karyawan) tidak disentuh. */
    public void updateEmailAdmin(int idAdmin, String email) {
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement("UPDATE admin SET email=? WHERE id_karyawan=?")) {
            ps.setString(1, email);
            ps.setInt(2, idAdmin);
            if (ps.executeUpdate() == 0) throw new AppException("Data admin tidak ditemukan.");
        } catch (SQLException e) { throw gagal("Gagal memperbarui email", e); }
    }

    public boolean usernameAda(String username) {
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement("SELECT 1 FROM karyawan WHERE username=?")) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) { return rs.next(); }
        } catch (SQLException e) { throw gagal("Gagal cek username", e); }
    }

    @Override public int insert(Karyawan k) {
        try (Connection c = conn()) {
            c.setAutoCommit(false);
            try {
                int id;
                try (PreparedStatement ps = c.prepareStatement(
                        "INSERT INTO karyawan(nama,no_telepon,username,password) VALUES(?,?,?,?)",
                        Statement.RETURN_GENERATED_KEYS)) {
                    ps.setString(1, k.getNama());
                    ps.setString(2, k.getNoTelepon());
                    ps.setString(3, k.getUsername());
                    ps.setString(4, k.getPasswordHash());
                    ps.executeUpdate();
                    try (ResultSet rs = ps.getGeneratedKeys()) { rs.next(); id = rs.getInt(1); }
                }
                if (k instanceof PetugasLapangan p) {
                    try (PreparedStatement ps = c.prepareStatement(
                            "INSERT INTO petugas_lapangan(id_karyawan,wilayah_tugas,spesialis) VALUES(?,?,?)")) {
                        ps.setInt(1, id);
                        ps.setString(2, p.getWilayahTugas());
                        ps.setString(3, p.getSpesialis());
                        ps.executeUpdate();
                    }
                } else if (k instanceof Kasir ks) {
                    try (PreparedStatement ps = c.prepareStatement(
                            "INSERT INTO kasir(id_karyawan,status_setoran,tanggal_setor) VALUES(?,?,?)")) {
                        ps.setInt(1, id);
                        ps.setString(2, ks.getStatusSetoran());
                        ps.setDate(3, ks.getTanggalSetor() == null ? null : Date.valueOf(ks.getTanggalSetor()));
                        ps.executeUpdate();
                    }
                } else {
                    throw new AppException("Jabatan tidak didukung.");
                }
                c.commit();
                return id;
            } catch (SQLException | RuntimeException e) {
                c.rollback();
                throw e;
            }
        } catch (SQLException e) { throw gagal("Gagal membuat akun", e); }
    }

    @Override public void update(Karyawan k) {
        try (Connection c = conn()) {
            c.setAutoCommit(false);
            try {
                boolean gantiPass = k.getPasswordHash() != null;
                String sql = "UPDATE karyawan SET nama=?,no_telepon=?" + (gantiPass ? ",password=?" : "") + " WHERE id_karyawan=?";
                try (PreparedStatement ps = c.prepareStatement(sql)) {
                    int i = 1;
                    ps.setString(i++, k.getNama());
                    ps.setString(i++, k.getNoTelepon());
                    if (gantiPass) ps.setString(i++, k.getPasswordHash());
                    ps.setInt(i, k.getId());
                    ps.executeUpdate();
                }
                if (k instanceof PetugasLapangan p) {
                    try (PreparedStatement ps = c.prepareStatement(
                            "UPDATE petugas_lapangan SET wilayah_tugas=?,spesialis=? WHERE id_karyawan=?")) {
                        ps.setString(1, p.getWilayahTugas());
                        ps.setString(2, p.getSpesialis());
                        ps.setInt(3, p.getId());
                        ps.executeUpdate();
                    }
                } else if (k instanceof Kasir ks) {
                    // status setor + tanggal setor: hanya diubah lewat menu Data Petugas milik Admin
                    try (PreparedStatement ps = c.prepareStatement(
                            "UPDATE kasir SET status_setoran=?,tanggal_setor=? WHERE id_karyawan=?")) {
                        ps.setString(1, ks.getStatusSetoran());
                        ps.setDate(2, ks.getTanggalSetor() == null ? null : Date.valueOf(ks.getTanggalSetor()));
                        ps.setInt(3, ks.getId());
                        ps.executeUpdate();
                    }
                }
                c.commit();
            } catch (SQLException | RuntimeException e) {
                c.rollback();
                throw e;
            }
        } catch (SQLException e) { throw gagal("Gagal memperbarui akun", e); }
    }

    /** Tidak ada ON DELETE CASCADE: baris jabatan dihapus dulu, baru karyawan (satu transaksi). */
    @Override public void delete(Integer id) {
        try (Connection c = conn()) {
            c.setAutoCommit(false);
            try {
                for (String tabel : new String[]{"kasir", "petugas_lapangan"}) {
                    try (PreparedStatement ps = c.prepareStatement("DELETE FROM " + tabel + " WHERE id_karyawan=?")) {
                        ps.setInt(1, id);
                        ps.executeUpdate();
                    }
                }
                try (PreparedStatement ps = c.prepareStatement("DELETE FROM karyawan WHERE id_karyawan=?")) {
                    ps.setInt(1, id);
                    ps.executeUpdate();
                }
                c.commit();
            } catch (SQLException | RuntimeException e) {
                c.rollback();
                throw e;
            }
        } catch (SQLException e) {
            throw gagal("Gagal menghapus akun (kemungkinan sudah tercatat di tagihan/pembayaran/pengaduan)", e);
        }
    }

    @Override public Karyawan findById(Integer id) {
        return findAll().stream().filter(k -> k.getId() == id).findFirst().orElse(null);
    }

    /** Hanya Kasir dan Petugas Lapangan (Admin tidak dikelola lewat CRUD ini). */
    @Override public List<Karyawan> findAll() {
        String sql = "SELECT k.id_karyawan,k.nama,k.no_telepon,k.username,kas.id_karyawan AS kid,kas.status_setoran,kas.tanggal_setor,"
                + "p.id_karyawan AS pid,p.wilayah_tugas,p.spesialis "
                + "FROM karyawan k LEFT JOIN kasir kas ON kas.id_karyawan=k.id_karyawan "
                + "LEFT JOIN petugas_lapangan p ON p.id_karyawan=k.id_karyawan "
                + "WHERE kas.id_karyawan IS NOT NULL OR p.id_karyawan IS NOT NULL ORDER BY k.id_karyawan";
        List<Karyawan> list = new ArrayList<>();
        try (Connection c = conn(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id_karyawan");
                if (rs.getObject("kid") != null) {
                    list.add(new Kasir(id, rs.getString("nama"), rs.getString("no_telepon"),
                            rs.getString("username"), rs.getString("status_setoran"), tglDari(rs.getDate("tanggal_setor"))));
                } else {
                    list.add(new PetugasLapangan(id, rs.getString("nama"), rs.getString("no_telepon"),
                            rs.getString("username"), rs.getString("wilayah_tugas"), rs.getString("spesialis")));
                }
            }
            return list;
        } catch (SQLException e) { throw gagal("Gagal membaca data petugas", e); }
    }
}
