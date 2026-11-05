package controller;

import dao.*;
import model.*;
import util.AppException;
import util.Konstanta;
import util.PasswordUtil;
import java.math.BigDecimal;
import java.util.List;

public class AdminController extends BaseController {
    private final KaryawanDao karyawanDao = new KaryawanDao();
    private final GolonganDao golonganDao = new GolonganDao();
    private final PelangganDao pelangganDao = new PelangganDao();
    private final PembayaranDao pembayaranDao = new PembayaranDao();
    private final PengaduanDao pengaduanDao = new PengaduanDao();
    private final StatistikDao statistikDao = new StatistikDao();

    // ---------- CRUD Petugas ----------
    public List<Karyawan> daftarPetugas() { return karyawanDao.findAll(); }

    public void buatPetugas(String nama, String telp, String username, String password,
                            String jabatan, String wilayah, String spesialis) {
        isi(nama, "Nama"); isi(telp, "No. telepon"); telepon(telp.trim());
        isi(username, "Username"); isi(password, "Password");
        PasswordUtil.validasi(password);
        PasswordUtil.validasiUsername(username);
        if (karyawanDao.usernameAda(username.trim()) || pelangganDao.usernameAda(username.trim())) {
            throw new AppException("Username sudah dipakai.");
        }
        Karyawan k;
        if (Konstanta.JABATAN_KASIR.equals(jabatan)) {
            k = new Kasir(0, nama.trim(), telp.trim(), username.trim(), Konstanta.SETORAN_BELUM);
        } else if (Konstanta.JABATAN_PETUGAS.equals(jabatan)) {
            k = new PetugasLapangan(0, nama.trim(), telp.trim(), username.trim(),
                    isi(wilayah, "Wilayah tugas"), cekSpesialis(spesialis));
        } else {
            throw new AppException("Jenis jabatan tidak valid.");
        }
        k.setPasswordHash(password);
        karyawanDao.insert(k);
    }

    public void ubahPetugas(Karyawan k, String nama, String telp, String passwordBaru, String wilayah, String spesialis) {
        ubahPetugas(k, nama, telp, passwordBaru, wilayah, spesialis, null, null);
    }

    /**
     * Ubah akun Kasir / Petugas. Khusus Kasir: status setor dan tanggal setor hanya dapat diubah di sini (Admin).
     * Sudah Setor -> tanggal wajib (kosong = hari ini, format yyyy-MM-dd, tidak boleh di masa depan).
     * Belum Setor -> tanggal dikosongkan.
     */
    public void ubahPetugas(Karyawan k, String nama, String telp, String passwordBaru, String wilayah, String spesialis,
                            String statusSetoran, String tanggalSetor) {
        isi(nama, "Nama"); isi(telp, "No. telepon"); telepon(telp.trim());
        if (k instanceof Kasir ks) {
            if (!Konstanta.SETORAN_BELUM.equals(statusSetoran) && !Konstanta.SETORAN_SUDAH.equals(statusSetoran)) {
                throw new AppException("Status setoran tidak valid.");
            }
            if (Konstanta.SETORAN_SUDAH.equals(statusSetoran)) {
                java.time.LocalDate t = (tanggalSetor == null || tanggalSetor.isBlank())
                        ? java.time.LocalDate.now() : tanggal(tanggalSetor, "Tanggal setor");
                if (t.isAfter(java.time.LocalDate.now())) throw new AppException("Tanggal setor tidak boleh di masa depan.");
                ks.setStatusSetoran(statusSetoran);
                ks.setTanggalSetor(t);
            } else {
                ks.setStatusSetoran(statusSetoran);
                ks.setTanggalSetor(null);
            }
        }
        k.setNama(nama.trim());
        k.setNoTelepon(telp.trim());
        if (k instanceof PetugasLapangan p) {
            p.setWilayahTugas(isi(wilayah, "Wilayah tugas"));
            p.setSpesialis(cekSpesialis(spesialis));
        }
        if (passwordBaru != null && !passwordBaru.isEmpty()) {
            PasswordUtil.validasi(passwordBaru);
            k.setPasswordHash(passwordBaru);
        } else {
            k.setPasswordHash(null);
        }
        karyawanDao.update(k);
    }

    private String cekSpesialis(String s) {
        if (!Konstanta.SPES_TEKNISI.equals(s) && !Konstanta.SPES_CATAT.equals(s) && !Konstanta.SPES_KEDUANYA.equals(s)) {
            throw new AppException("Spesialis tidak valid.");
        }
        return s;
    }

    public void hapusPetugas(Karyawan k) { karyawanDao.delete(k.getId()); }

    // ---------- CRUD Golongan Tarif ----------
    public List<Golongan> daftarGolongan() { return golonganDao.findAll(); }

    public void tambahGolongan(String kode, String daya, String tarif, String beban) {
        golonganDao.insert(bentukGolongan(0, kode, daya, tarif, beban));
    }

    public void ubahGolongan(int id, String kode, String daya, String tarif, String beban) {
        golonganDao.update(bentukGolongan(id, kode, daya, tarif, beban));
    }

    public void hapusGolongan(int id) { golonganDao.delete(id); }

    private Golongan bentukGolongan(int id, String kode, String daya, String tarif, String beban) {
        isi(kode, "Kode golongan");
        int d = bilangan(daya, "Daya (VA)");
        BigDecimal t = angka(tarif, "Tarif per kWh");
        BigDecimal b = (beban == null || beban.isBlank()) ? BigDecimal.ZERO : angka(beban, "Biaya beban");
        if (d <= 0 || t.signum() <= 0 || b.signum() < 0) throw new AppException("Daya dan tarif harus lebih dari 0, biaya beban tidak boleh negatif.");
        return new Golongan(id, kode.trim(), d, t, b);
    }

    // ---------- Registrasi pengguna ----------
    public List<Pelanggan> antrianRegistrasi() { return pelangganDao.findByStatus(Konstanta.AKUN_MENUNGGU); }

    /** Semua pendaftar (Menunggu, Aktif, Tidak Aktif): data tidak hilang setelah disetujui atau ditolak. */
    public List<Pelanggan> daftarRegistrasi() { return pelangganDao.findAll(); }

    public void setujui(Pelanggan p) { pelangganDao.updateStatus(p.getId(), Konstanta.AKUN_AKTIF); }

    /** Ditolak: akun dinonaktifkan (data tidak dihapus). */
    public void tolak(Pelanggan p) { pelangganDao.updateStatus(p.getId(), Konstanta.AKUN_TIDAK_AKTIF); }

    // ---------- Laporan ----------
    public List<Pembayaran> riwayatPembayaran() { return pembayaranDao.findAll(); }
    public List<Pengaduan> daftarPengaduan() { return pengaduanDao.findAll(); }

    // ---------- Dashboard ----------
    public StatistikDao statistik() { return statistikDao; }
}
