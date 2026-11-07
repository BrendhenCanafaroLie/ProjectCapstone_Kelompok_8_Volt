package controller;

import dao.GolonganDao;
import dao.KaryawanDao;
import dao.PelangganDao;
import model.*;
import util.AppException;
import util.Konstanta;
import util.PasswordUtil;
import java.util.List;

/** Alur "Menu Utama": Login / Daftar. */
public class AuthController extends BaseController {
    private final KaryawanDao karyawanDao = new KaryawanDao();
    private final PelangganDao pelangganDao = new PelangganDao();
    private final GolonganDao golonganDao = new GolonganDao();

    /** Cek username+password -> cek jabatan (Admin/Petugas/Kasir) -> cek pelanggan & status akun. */
    public Pengguna login(String username, String password) {
        if (username == null || username.isBlank() || password == null || password.isEmpty()) {
            throw new AppException("Username dan password wajib diisi.");
        }
        String hash = password;
        Karyawan k = karyawanDao.login(username.trim(), hash);
        if (k != null) return k;

        Pelanggan p = pelangganDao.login(username.trim(), hash);
        if (p == null) throw new AppException("Username atau password salah.");
        if (Konstanta.AKUN_MENUNGGU.equals(p.getStatusAkun())) {
            throw new AppException("Akun Masih Menunggu Validasi, Harap Tunggu");
        }
        if (!Konstanta.AKUN_AKTIF.equals(p.getStatusAkun())) {
            throw new AppException("Akun Anda Tidak Aktif. Silakan hubungi admin.");
        }
        return p;
    }

    public List<Golongan> daftarGolongan() { return golonganDao.findAll(); }

    public void daftarRumahTangga(String meter, String nama, String alamat, String telp, String username,
                                  String password, Golongan gol, String nik, String subsidi) {
        validasiUmum(meter, nama, alamat, telp, username, password, gol);
        isi(nik, "NIK"); hanyaAngka(nik.trim(), "NIK", 16);
        isi(subsidi, "Kategori subsidi");
        if (!Konstanta.SUBSIDI.equals(subsidi) && !Konstanta.NON_SUBSIDI.equals(subsidi)) {
            throw new AppException("Kategori subsidi tidak valid.");
        }
        Pelanggan p = new PelangganRumahTangga(0, nama.trim(), telp.trim(), username.trim(), meter.trim(),
                alamat.trim(), Konstanta.AKUN_MENUNGGU, gol.getId(), gol.getKode(), nik.trim(), subsidi.trim());
        p.setPasswordHash(password);
        pelangganDao.daftar(p);
    }

    public void daftarUsaha(String meter, String nama, String alamat, String telp, String username,
                            String password, Golongan gol, String npwp, String namaUsaha) {
        validasiUmum(meter, nama, alamat, telp, username, password, gol);
        isi(npwp, "NPWP"); isi(namaUsaha, "Nama usaha");
        Pelanggan p = new PelangganUsaha(0, nama.trim(), telp.trim(), username.trim(), meter.trim(),
                alamat.trim(), Konstanta.AKUN_MENUNGGU, gol.getId(), gol.getKode(), npwp.trim(), namaUsaha.trim());
        p.setPasswordHash(password);
        pelangganDao.daftar(p);
    }

    private void validasiUmum(String meter, String nama, String alamat, String telp, String username,
                              String password, Golongan gol) {
        isi(meter, "Nomor meter"); isi(nama, "Nama"); isi(alamat, "Alamat");
        isi(telp, "No. telepon"); telepon(telp.trim());
        isi(username, "Username"); isi(password, "Password");
        PasswordUtil.validasi(password);
        PasswordUtil.validasiUsername(username);
        if (gol == null) throw new AppException("Golongan tarif wajib dipilih.");
        if (pelangganDao.usernameAda(username.trim()) || karyawanDao.usernameAda(username.trim())) {
            throw new AppException("Username sudah dipakai.");
        }
        if (pelangganDao.nomorMeterAda(meter.trim())) throw new AppException("Nomor meter sudah terdaftar.");
    }
}
