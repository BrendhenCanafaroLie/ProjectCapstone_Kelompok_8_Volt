package view.auth;

import view.MainFrame;
import view.Navigator;
import view.Refreshable;

import controller.AuthController;
import java.awt.CardLayout;

/**
 * Bingkai layar sebelum login: panel nama aplikasi (kiri) dan kartu berisi Menu Utama / Login / Daftar (kanan).
 * JPanel Form NetBeans: ketiga halaman sudah terpasang di LayarMasuk.form (kartu "menu", "login", "daftar").
 */
public class LayarMasuk extends javax.swing.JPanel {

    public LayarMasuk() {
        initComponents();
    }

    /** Dipanggil MainFrame: memasang controller dan navigasi ke ketiga halaman. */
    public void hubungkan(AuthController auth, Navigator nav) {
        pgMenu.setNavigator(nav);
        pgLogin.hubungkan(auth, nav);
        pgDaftar.hubungkan(auth, nav);
    }

    public void tampil(String nama) {
        Refreshable r = switch (nama) { case "login" -> pgLogin; case "daftar" -> pgDaftar; default -> pgMenu; };
        r.muat();
        ((CardLayout) pnlKanan.getLayout()).show(pnlKanan, nama);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlMerek = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        pnlGaris = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        lblUraian = new javax.swing.JLabel();
        pnlKaki = new javax.swing.JPanel();
        pnlKanan = new javax.swing.JPanel();
        pnlMenuUtama = new javax.swing.JPanel();
        pgMenu = new view.auth.PanelMenuUtama();
        pnlMasuk = new javax.swing.JPanel();
        pgLogin = new view.auth.PanelLogin();
        pnlDaftar = new javax.swing.JPanel();
        pgDaftar = new view.auth.PanelDaftar();

        setLayout(new java.awt.BorderLayout());

        pnlMerek.setBackground(new java.awt.Color(11, 37, 69));
        pnlMerek.setPreferredSize(new java.awt.Dimension(400, 0));
        pnlMerek.setLayout(null);

        lblLogo.setText("VOLT");
        lblLogo.setFont(new java.awt.Font("Segoe UI", 1, 54)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(245, 158, 11));
        pnlMerek.add(lblLogo);
        lblLogo.setBounds(44, 70, 300, 70);

        pnlGaris.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris.setLayout(null);
        pnlMerek.add(pnlGaris);
        pnlGaris.setBounds(46, 146, 70, 5);

        lblJudul.setText("<html>Sistem Tagihan<br>Listrik Samarinda</html>");
        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        lblJudul.setForeground(new java.awt.Color(255, 255, 255));
        pnlMerek.add(lblJudul);
        lblJudul.setBounds(44, 170, 320, 90);

        lblUraian.setText("<html>Pelanggan memantau tagihan dan melaporkan gangguan. Admin, kasir, dan petugas lapangan bekerja dari satu sistem.</html>");
        lblUraian.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUraian.setForeground(new java.awt.Color(191, 219, 254));
        pnlMerek.add(lblUraian);
        lblUraian.setBounds(44, 275, 310, 90);

        pnlKaki.setBackground(new java.awt.Color(29, 78, 216));
        pnlKaki.setLayout(null);
        pnlMerek.add(pnlKaki);
        pnlKaki.setBounds(0, 600, 400, 8);

        add(pnlMerek, java.awt.BorderLayout.WEST);

        pnlKanan.setBackground(new java.awt.Color(234, 241, 251));
        pnlKanan.setLayout(new java.awt.CardLayout());

        pnlMenuUtama.setBackground(new java.awt.Color(234, 241, 251));
        pnlMenuUtama.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pnlMenuUtama.add(pgMenu, gridBagConstraints);

        pnlKanan.add(pnlMenuUtama, "menu");

        pnlMasuk.setBackground(new java.awt.Color(234, 241, 251));
        pnlMasuk.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pnlMasuk.add(pgLogin, gridBagConstraints);

        pnlKanan.add(pnlMasuk, "login");

        pnlDaftar.setBackground(new java.awt.Color(234, 241, 251));
        pnlDaftar.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pnlDaftar.add(pgDaftar, gridBagConstraints);

        pnlKanan.add(pnlDaftar, "daftar");

        add(pnlKanan, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblUraian;
    private view.auth.PanelDaftar pgDaftar;
    private view.auth.PanelLogin pgLogin;
    private view.auth.PanelMenuUtama pgMenu;
    private javax.swing.JPanel pnlDaftar;
    private javax.swing.JPanel pnlGaris;
    private javax.swing.JPanel pnlKaki;
    private javax.swing.JPanel pnlKanan;
    private javax.swing.JPanel pnlMasuk;
    private javax.swing.JPanel pnlMenuUtama;
    private javax.swing.JPanel pnlMerek;
    // End of variables declaration//GEN-END:variables
}
