package controller;

import dao.KaryawanDao;
import model.Admin;
import model.Karyawan;
import util.AppException;

/**
 * Profil milik akun yang sedang login (Admin / Kasir / Petugas Lapangan).
 * Semua karyawan hanya dapat MELIHAT akunnya sendiri; hanya Admin yang dapat mengubah
 * atribut khusus miliknya (email). Atribut supertype (nama, telepon, username, password) tidak dapat diubah di sini.
 */
public class ProfilKaryawanController extends BaseController {
    private final KaryawanDao dao = new KaryawanDao();
    private Karyawan akun;

    public ProfilKaryawanController(Karyawan akun) { this.akun = akun; }

    /** Data terbaru akun sendiri (selalu berdasarkan id akun yang login, bukan akun lain). */
    public Karyawan profil() {
        akun = dao.muatProfil(akun.getId());
        return akun;
    }

    public boolean bisaUbahAtributKhusus() { return akun instanceof Admin; }

    public void ubahEmail(String email) {
        if (!(akun instanceof Admin a)) throw new AppException("Hanya Admin yang dapat mengubah atribut khususnya.");
        String e = isi(email, "Email");
        if (e.length() > 100) throw new AppException("Email maksimal 100 karakter.");
        if (!e.matches("^[\\w.+-]+@[\\w-]+(\\.[\\w-]+)+$")) throw new AppException("Format email tidak valid.");
        dao.updateEmailAdmin(a.getId(), e);
        a.setEmail(e);
    }
}
