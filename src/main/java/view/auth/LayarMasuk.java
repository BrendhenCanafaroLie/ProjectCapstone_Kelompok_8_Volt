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

        pnlKanan = new javax.swing.JPanel();
        pnlMasuk = new javax.swing.JPanel();
        pgLogin = new view.auth.PanelLogin();
        pnlDaftar = new javax.swing.JPanel();
        pgDaftar = new view.auth.PanelDaftar();
        pnlMenuUtama = new javax.swing.JPanel();
        pgMenu = new view.auth.PanelMenuUtama();
        pnlMerek = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        pnlGaris = new javax.swing.JPanel();
        pnlGaris1 = new javax.swing.JPanel();
        pnlGaris2 = new javax.swing.JPanel();
        pnlGaris3 = new javax.swing.JPanel();
        pnlGaris4 = new javax.swing.JPanel();
        pnlGaris5 = new javax.swing.JPanel();
        pnlGaris6 = new javax.swing.JPanel();
        pnlGaris7 = new javax.swing.JPanel();
        pnlGaris8 = new javax.swing.JPanel();
        pnlGaris9 = new javax.swing.JPanel();
        pnlGaris10 = new javax.swing.JPanel();
        pnlGaris11 = new javax.swing.JPanel();
        pnlGaris12 = new javax.swing.JPanel();
        pnlGaris13 = new javax.swing.JPanel();
        pnlGaris14 = new javax.swing.JPanel();
        pnlGaris15 = new javax.swing.JPanel();
        pnlGaris16 = new javax.swing.JPanel();
        pnlGaris17 = new javax.swing.JPanel();
        pnlGaris18 = new javax.swing.JPanel();
        pnlGaris19 = new javax.swing.JPanel();
        pnlGaris20 = new javax.swing.JPanel();
        pnlGaris21 = new javax.swing.JPanel();
        pnlGaris22 = new javax.swing.JPanel();
        pnlGaris23 = new javax.swing.JPanel();
        pnlGaris24 = new javax.swing.JPanel();
        pnlGaris25 = new javax.swing.JPanel();
        pnlGaris26 = new javax.swing.JPanel();
        pnlGaris27 = new javax.swing.JPanel();
        pnlGaris28 = new javax.swing.JPanel();
        pnlGaris29 = new javax.swing.JPanel();
        pnlGaris30 = new javax.swing.JPanel();
        pnlGaris31 = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        pnlKanan.setBackground(new java.awt.Color(234, 241, 251));
        pnlKanan.setLayout(new java.awt.CardLayout());

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

        pnlMenuUtama.setBackground(new java.awt.Color(234, 241, 251));
        pnlMenuUtama.setLayout(new java.awt.GridBagLayout());

        pgMenu.setForeground(new java.awt.Color(255, 255, 255));
        pnlMenuUtama.add(pgMenu, new java.awt.GridBagConstraints());

        pnlKanan.add(pnlMenuUtama, "menu");

        add(pnlKanan, java.awt.BorderLayout.CENTER);

        pnlMerek.setBackground(new java.awt.Color(11, 37, 69));
        pnlMerek.setPreferredSize(new java.awt.Dimension(400, 0));
        pnlMerek.setLayout(null);

        lblLogo.setFont(new java.awt.Font("Lucida Console", 1, 54)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(255, 160, 0));
        lblLogo.setText("VOLT");
        pnlMerek.add(lblLogo);
        lblLogo.setBounds(120, 120, 140, 50);

        pnlGaris.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris.setLayout(null);

        pnlGaris1.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris1.setLayout(null);
        pnlGaris.add(pnlGaris1);
        pnlGaris1.setBounds(50, 140, 130, 10);

        pnlGaris2.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris2.setLayout(null);

        pnlGaris3.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris3.setLayout(null);
        pnlGaris2.add(pnlGaris3);
        pnlGaris3.setBounds(50, 140, 130, 10);

        pnlGaris.add(pnlGaris2);
        pnlGaris2.setBounds(50, 140, 130, 10);

        pnlGaris4.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris4.setLayout(null);

        pnlGaris5.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris5.setLayout(null);
        pnlGaris4.add(pnlGaris5);
        pnlGaris5.setBounds(50, 140, 130, 10);

        pnlGaris6.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris6.setLayout(null);

        pnlGaris7.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris7.setLayout(null);
        pnlGaris6.add(pnlGaris7);
        pnlGaris7.setBounds(50, 140, 130, 10);

        pnlGaris4.add(pnlGaris6);
        pnlGaris6.setBounds(50, 140, 130, 10);

        pnlGaris.add(pnlGaris4);
        pnlGaris4.setBounds(50, 140, 130, 10);

        pnlGaris8.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris8.setLayout(null);

        pnlGaris9.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris9.setLayout(null);
        pnlGaris8.add(pnlGaris9);
        pnlGaris9.setBounds(50, 140, 130, 10);

        pnlGaris10.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris10.setLayout(null);

        pnlGaris11.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris11.setLayout(null);
        pnlGaris10.add(pnlGaris11);
        pnlGaris11.setBounds(50, 140, 130, 10);

        pnlGaris8.add(pnlGaris10);
        pnlGaris10.setBounds(50, 140, 130, 10);

        pnlGaris12.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris12.setLayout(null);

        pnlGaris13.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris13.setLayout(null);
        pnlGaris12.add(pnlGaris13);
        pnlGaris13.setBounds(50, 140, 130, 10);

        pnlGaris14.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris14.setLayout(null);

        pnlGaris15.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris15.setLayout(null);
        pnlGaris14.add(pnlGaris15);
        pnlGaris15.setBounds(50, 140, 130, 10);

        pnlGaris12.add(pnlGaris14);
        pnlGaris14.setBounds(50, 140, 130, 10);

        pnlGaris8.add(pnlGaris12);
        pnlGaris12.setBounds(50, 140, 130, 10);

        pnlGaris.add(pnlGaris8);
        pnlGaris8.setBounds(50, 140, 130, 10);

        pnlGaris16.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris16.setLayout(null);

        pnlGaris17.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris17.setLayout(null);
        pnlGaris16.add(pnlGaris17);
        pnlGaris17.setBounds(50, 140, 130, 10);

        pnlGaris18.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris18.setLayout(null);

        pnlGaris19.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris19.setLayout(null);
        pnlGaris18.add(pnlGaris19);
        pnlGaris19.setBounds(50, 140, 130, 10);

        pnlGaris16.add(pnlGaris18);
        pnlGaris18.setBounds(50, 140, 130, 10);

        pnlGaris20.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris20.setLayout(null);

        pnlGaris21.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris21.setLayout(null);
        pnlGaris20.add(pnlGaris21);
        pnlGaris21.setBounds(50, 140, 130, 10);

        pnlGaris22.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris22.setLayout(null);

        pnlGaris23.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris23.setLayout(null);
        pnlGaris22.add(pnlGaris23);
        pnlGaris23.setBounds(50, 140, 130, 10);

        pnlGaris20.add(pnlGaris22);
        pnlGaris22.setBounds(50, 140, 130, 10);

        pnlGaris16.add(pnlGaris20);
        pnlGaris20.setBounds(50, 140, 130, 10);

        pnlGaris24.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris24.setLayout(null);

        pnlGaris25.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris25.setLayout(null);
        pnlGaris24.add(pnlGaris25);
        pnlGaris25.setBounds(50, 140, 130, 10);

        pnlGaris26.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris26.setLayout(null);

        pnlGaris27.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris27.setLayout(null);
        pnlGaris26.add(pnlGaris27);
        pnlGaris27.setBounds(50, 140, 130, 10);

        pnlGaris24.add(pnlGaris26);
        pnlGaris26.setBounds(50, 140, 130, 10);

        pnlGaris28.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris28.setLayout(null);

        pnlGaris29.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris29.setLayout(null);
        pnlGaris28.add(pnlGaris29);
        pnlGaris29.setBounds(50, 140, 130, 10);

        pnlGaris30.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris30.setLayout(null);

        pnlGaris31.setBackground(new java.awt.Color(245, 158, 11));
        pnlGaris31.setLayout(null);
        pnlGaris30.add(pnlGaris31);
        pnlGaris31.setBounds(50, 140, 130, 10);

        pnlGaris28.add(pnlGaris30);
        pnlGaris30.setBounds(50, 140, 130, 10);

        pnlGaris24.add(pnlGaris28);
        pnlGaris28.setBounds(50, 140, 130, 10);

        pnlGaris16.add(pnlGaris24);
        pnlGaris24.setBounds(50, 140, 130, 10);

        pnlGaris.add(pnlGaris16);
        pnlGaris16.setBounds(100, 140, 130, 10);

        pnlMerek.add(pnlGaris);
        pnlGaris.setBounds(0, 170, 670, 10);

        lblJudul.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblJudul.setForeground(new java.awt.Color(255, 255, 255));
        lblJudul.setText("<html>Sistem Tagihan<br>Listrik Samarinda</html>");
        pnlMerek.add(lblJudul);
        lblJudul.setBounds(10, 490, 320, 90);

        jPanel2.setBackground(new java.awt.Color(234, 241, 251));
        pnlMerek.add(jPanel2);
        jPanel2.setBounds(0, 590, 330, 10);

        jLabel2.setIcon(new javax.swing.ImageIcon("E:\\NetBeansProjects\\volt-app\\src\\main\\java\\view\\auth\\Logo Volt.png")); // NOI18N
        jLabel2.setText("jLabel2");
        pnlMerek.add(jLabel2);
        jLabel2.setBounds(0, 60, 140, 120);

        jLabel1.setIcon(new javax.swing.ImageIcon("E:\\NetBeansProjects\\volt-app\\src\\main\\java\\view\\auth\\Tiang Listrik.png")); // NOI18N
        pnlMerek.add(jLabel1);
        jLabel1.setBounds(0, -10, 400, 750);

        add(pnlMerek, java.awt.BorderLayout.WEST);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblLogo;
    private view.auth.PanelDaftar pgDaftar;
    private view.auth.PanelLogin pgLogin;
    private view.auth.PanelMenuUtama pgMenu;
    private javax.swing.JPanel pnlDaftar;
    private javax.swing.JPanel pnlGaris;
    private javax.swing.JPanel pnlGaris1;
    private javax.swing.JPanel pnlGaris10;
    private javax.swing.JPanel pnlGaris11;
    private javax.swing.JPanel pnlGaris12;
    private javax.swing.JPanel pnlGaris13;
    private javax.swing.JPanel pnlGaris14;
    private javax.swing.JPanel pnlGaris15;
    private javax.swing.JPanel pnlGaris16;
    private javax.swing.JPanel pnlGaris17;
    private javax.swing.JPanel pnlGaris18;
    private javax.swing.JPanel pnlGaris19;
    private javax.swing.JPanel pnlGaris2;
    private javax.swing.JPanel pnlGaris20;
    private javax.swing.JPanel pnlGaris21;
    private javax.swing.JPanel pnlGaris22;
    private javax.swing.JPanel pnlGaris23;
    private javax.swing.JPanel pnlGaris24;
    private javax.swing.JPanel pnlGaris25;
    private javax.swing.JPanel pnlGaris26;
    private javax.swing.JPanel pnlGaris27;
    private javax.swing.JPanel pnlGaris28;
    private javax.swing.JPanel pnlGaris29;
    private javax.swing.JPanel pnlGaris3;
    private javax.swing.JPanel pnlGaris30;
    private javax.swing.JPanel pnlGaris31;
    private javax.swing.JPanel pnlGaris4;
    private javax.swing.JPanel pnlGaris5;
    private javax.swing.JPanel pnlGaris6;
    private javax.swing.JPanel pnlGaris7;
    private javax.swing.JPanel pnlGaris8;
    private javax.swing.JPanel pnlGaris9;
    private javax.swing.JPanel pnlKanan;
    private javax.swing.JPanel pnlMasuk;
    private javax.swing.JPanel pnlMenuUtama;
    private javax.swing.JPanel pnlMerek;
    // End of variables declaration//GEN-END:variables
}
