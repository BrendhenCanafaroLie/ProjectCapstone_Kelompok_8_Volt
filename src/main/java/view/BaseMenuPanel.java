package view;

import view.admin.PanelMenuAdmin;
import view.kasir.PanelMenuKasir;
import view.pelanggan.PanelMenuPelanggan;
import view.petugas.PanelMenuPetugas;

import model.Karyawan;
import model.Pengguna;
import javax.swing.AbstractButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * ABSTRAKSI + POLIMORFISME (Template Method): logika umum halaman menu semua peran.
 * Seluruh tampilan (sidebar / navbar, tombol menu, dan halaman-halamannya) sudah dipasang langsung di form
 * PanelMenuAdmin / PanelMenuKasir / PanelMenuPetugas / PanelMenuPelanggan, jadi terlihat utuh di tab Design.
 * Kelas ini hanya mengisi teks, memasang controller, dan memindahkan halaman saat tombol menu ditekan.
 */
public abstract class BaseMenuPanel extends BasePanel {
    private record Halaman(String judul, String keterangan, Refreshable isi, AbstractButton tombol) { }

    protected Pengguna pengguna;
    private Navigator nav;
    private final List<Halaman> halaman = new ArrayList<>();
    private int aktif = 0;

    // komponen hasil desain form milik subclass (null bila tata letak tidak memilikinya)
    protected abstract JPanel wadahIsi();
    protected abstract JLabel labelJudul();
    protected abstract JLabel labelKet();
    protected abstract JLabel labelPeran();
    protected abstract JLabel labelNama();
    protected abstract JLabel labelDetail();
    protected abstract JLabel labelSapa();
    protected abstract JLabel labelTanggal();

    /** Subclass memasang controller ke halaman-halamannya dan mendaftarkannya lewat tambah(...). */
    protected abstract void hubungkan();

    /** Mendaftarkan halaman yang sudah ada di form: judul = nama kartu di CardLayout. */
    protected final void tambah(String judul, String keterangan, Refreshable isi, AbstractButton tombol) {
        halaman.add(new Halaman(judul, keterangan, isi, tombol));
    }

    /** Dipanggil MainFrame setelah login berhasil. */
    public final void mulai(Pengguna pengguna, Navigator nav) {
        this.pengguna = pengguna;
        this.nav = nav;
        halaman.clear();
        hubungkan();
        if (halaman.isEmpty()) throw new IllegalStateException("Menu tidak memiliki halaman.");
        labelNama().setText(pengguna.getNama());
        if (labelPeran() != null) labelPeran().setText("Panel " + pengguna.getPeran().toLowerCase());
        if (labelDetail() != null) {
            String detail = pengguna instanceof Karyawan k ? k.getDetail() : pengguna.getPeran();
            labelDetail().setText(detail == null ? pengguna.getPeran() : detail);
        }
        if (labelSapa() != null) labelSapa().setText(Tampilan.sapaan() + ", " + Tampilan.namaDepan(pengguna));
        if (labelTanggal() != null) labelTanggal().setText(LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy", new Locale("id", "ID"))));
        pilih(0);
    }

    /** Pindah ke halaman berdasarkan judulnya (dipakai tombol pintasan di Beranda). */
    public final void buka(String judul) {
        for (int i = 0; i < halaman.size(); i++) if (halaman.get(i).judul().equals(judul)) { pilih(i); return; }
    }

    protected final void pilih(AbstractButton tombol) {
        for (int i = 0; i < halaman.size(); i++) if (halaman.get(i).tombol() == tombol) { pilih(i); return; }
    }

    private void pilih(int indeks) {
        aktif = indeks;
        Halaman h = halaman.get(indeks);
        ((CardLayout) wadahIsi().getLayout()).show(wadahIsi(), h.judul());
        h.tombol().setSelected(true);
        if (labelJudul() != null) labelJudul().setText(h.judul());
        if (labelKet() != null) labelKet().setText(h.keterangan() == null ? " " : h.keterangan());
        h.isi().muat();
    }

    protected final void keluar() { nav.keluarAkun(); }

    @Override public void muat() {
        if (!halaman.isEmpty()) halaman.get(aktif).isi().muat();
    }
}
