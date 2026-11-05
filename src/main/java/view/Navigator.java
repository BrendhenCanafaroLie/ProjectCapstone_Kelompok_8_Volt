package view;

import model.Pengguna;

/** Kontrak navigasi antar halaman (diimplementasi MainFrame). Panel tidak perlu tahu cara berpindah halaman. */
public interface Navigator {
    void tampilMenuUtama();
    void tampilLogin();
    void tampilDaftar();
    /** Dipanggil setelah login berhasil: buka menu sesuai peran. */
    void masuk(Pengguna pengguna);
    /** Logout: kembali ke Menu Utama. */
    void keluarAkun();
    void keluarAplikasi();
}
