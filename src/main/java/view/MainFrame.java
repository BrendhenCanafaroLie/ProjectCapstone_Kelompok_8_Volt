package view;

import controller.AuthController;
import model.*;
import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Satu-satunya JFrame aplikasi (JFrame Form NetBeans: MainFrame.form).
 * Layar masuk dan keempat menu peran (admin, kasir, petugas, pelanggan) sudah terpasang sebagai kartu
 * di form, sehingga seluruh tampilan aplikasi terlihat di tab Design.
 */
public class MainFrame extends javax.swing.JFrame implements Navigator {
    private static final String JUDUL = "VOLT - Sistem Tagihan Listrik";

    private final CardLayout kartu;
    private final AuthController auth = new AuthController();
    private BaseMenuPanel menuAktif;

    public MainFrame() {
        initComponents();
        kartu = (CardLayout) wadah.getLayout();
        setLocationRelativeTo(null);
        pgMasuk.hubungkan(auth, this);
        addWindowListener(new WindowAdapter() {
            @Override public void windowClosing(WindowEvent e) { keluarAplikasi(); }
        });
        tampilMenuUtama();
    }

    private void masukLayar(String nama) {
        setTitle(JUDUL);
        pgMasuk.tampil(nama);
        kartu.show(wadah, "masuk");
    }

    @Override public void tampilMenuUtama() { masukLayar("menu"); }
    @Override public void tampilLogin() { masukLayar("login"); }
    @Override public void tampilDaftar() { masukLayar("daftar"); }

    @Override public void masuk(Pengguna pengguna) {
        BaseMenuPanel menu;
        String nama;
        if (pengguna instanceof Admin) { menu = pgAdmin; nama = "admin"; }
        else if (pengguna instanceof Kasir) { menu = pgKasir; nama = "kasir"; }
        else if (pengguna instanceof PetugasLapangan) { menu = pgPetugas; nama = "petugas"; }
        else if (pengguna instanceof Pelanggan) { menu = pgPelanggan; nama = "pelanggan"; }
        else throw new IllegalArgumentException("Peran tidak dikenal: " + pengguna.getPeran());
        try {
            menu.mulai(pengguna, this);
            menuAktif = menu;
            setTitle("VOLT - " + pengguna.getRingkasan());
            kartu.show(wadah, nama);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            Ui.error(this, "Login berhasil, tetapi menu gagal dibuka:\n" + ex.getMessage());
        }
    }

    @Override public void keluarAkun() {
        if (!Ui.konfirmasi(this, "Keluar dari akun dan kembali ke Menu Utama?")) return;
        menuAktif = null;
        tampilMenuUtama();
    }

    @Override public void keluarAplikasi() {
        if (Ui.konfirmasi(this, "Keluar dari aplikasi?")) System.exit(0);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wadah = new javax.swing.JPanel();
        pgMasuk = new view.auth.LayarMasuk();
        pgAdmin = new view.admin.PanelMenuAdmin();
        pgKasir = new view.kasir.PanelMenuKasir();
        pgPetugas = new view.petugas.PanelMenuPetugas();
        pgPelanggan = new view.pelanggan.PanelMenuPelanggan();

        setTitle("VOLT - Sistem Tagihan Listrik");
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1120, 680));

        wadah.setBackground(new java.awt.Color(255, 255, 255));
        wadah.setLayout(new java.awt.CardLayout());
        wadah.add(pgMasuk, "masuk");
        wadah.add(pgAdmin, "admin");
        wadah.add(pgKasir, "kasir");
        wadah.add(pgPetugas, "petugas");
        wadah.add(pgPelanggan, "pelanggan");

        getContentPane().add(wadah, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.admin.PanelMenuAdmin pgAdmin;
    private view.kasir.PanelMenuKasir pgKasir;
    private view.auth.LayarMasuk pgMasuk;
    private view.pelanggan.PanelMenuPelanggan pgPelanggan;
    private view.petugas.PanelMenuPetugas pgPetugas;
    private javax.swing.JPanel wadah;
    // End of variables declaration//GEN-END:variables
}
