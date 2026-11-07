package view.pelanggan;

import view.BaseMenuPanel;

import controller.PelangganController;
import model.Pelanggan;

/**
 * Portal pelanggan: navigasi di atas (Beranda, Tagihan, Lapor gangguan, Status, Profil).
 * JPanel Form NetBeans: sidebar/navbar, tombol menu, DAN semua halamannya sudah terpasang di PanelMenuPelanggan.form,
 * sehingga tampilan di tab Design sama dengan tampilan saat program berjalan.
 * Kode di dalam blok GEN-BEGIN/GEN-END dibuat otomatis oleh NetBeans, jangan diedit manual.
 */
public class PanelMenuPelanggan extends BaseMenuPanel {

    public PanelMenuPelanggan() {
        initComponents();
    }

    @Override protected javax.swing.JPanel wadahIsi() { return pnlIsi; }
    @Override protected javax.swing.JLabel labelJudul() { return null; }
    @Override protected javax.swing.JLabel labelKet() { return null; }
    @Override protected javax.swing.JLabel labelPeran() { return null; }
    @Override protected javax.swing.JLabel labelNama() { return lblNama; }
    @Override protected javax.swing.JLabel labelDetail() { return null; }
    @Override protected javax.swing.JLabel labelSapa() { return null; }
    @Override protected javax.swing.JLabel labelTanggal() { return null; }

    @Override protected void hubungkan() {
        PelangganController ctrl = new PelangganController((Pelanggan) pengguna);
        pgBeranda.setKontrol(ctrl, this::buka);
        pgTagihan.setController(ctrl);
        pgLapor.setController(ctrl);
        pgProfil.setController(ctrl);
        tambah("Beranda", null, pgBeranda, btnNavBeranda);
        tambah("Tagihan & riwayat kWh", null, pgTagihan, btnNavTagihan);
        tambah("Lapor gangguan", null, pgLapor, btnNavLapor);
        tambah("Profil", null, pgProfil, btnNavProfil);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpNav = new javax.swing.ButtonGroup();
        pnlNavbar = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        pnlMenu = new javax.swing.JPanel();
        btnNavBeranda = new javax.swing.JToggleButton();
        btnNavTagihan = new javax.swing.JToggleButton();
        btnNavLapor = new javax.swing.JToggleButton();
        btnNavProfil = new javax.swing.JToggleButton();
        pnlAkun = new javax.swing.JPanel();
        lblNama = new javax.swing.JLabel();
        btnKeluar = new javax.swing.JButton();
        pnlIsi = new javax.swing.JPanel();
        pgBeranda = new view.pelanggan.PanelBeranda();
        pgTagihan = new view.pelanggan.PanelTagihanSaya();
        pgLapor = new view.pelanggan.PanelLaporGangguan();
        pgProfil = new view.pelanggan.PanelProfil();

        setBackground(new java.awt.Color(234, 241, 251));
        setLayout(new java.awt.BorderLayout());

        pnlNavbar.setBackground(new java.awt.Color(11, 37, 69));
        pnlNavbar.setPreferredSize(new java.awt.Dimension(100, 66));
        pnlNavbar.setLayout(new java.awt.BorderLayout(8, 0));

        lblLogo.setFont(new java.awt.Font("Lucida Console", 1, 32)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(245, 158, 11));
        lblLogo.setText("VOLT");
        lblLogo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 24, 0, 24));
        lblLogo.setPreferredSize(new java.awt.Dimension(130, 60));
        pnlNavbar.add(lblLogo, java.awt.BorderLayout.WEST);

        pnlMenu.setBackground(new java.awt.Color(11, 37, 69));
        pnlMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 0, 12, 0));
        pnlMenu.setLayout(new java.awt.GridLayout(1, 4, 4, 0));

        btnNavBeranda.setBackground(new java.awt.Color(18, 55, 102));
        grpNav.add(btnNavBeranda);
        btnNavBeranda.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnNavBeranda.setForeground(new java.awt.Color(255, 255, 255));
        btnNavBeranda.setText("Beranda");
        btnNavBeranda.setBorderPainted(false);
        btnNavBeranda.setFocusPainted(false);
        btnNavBeranda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavBerandaActionPerformed(evt);
            }
        });
        pnlMenu.add(btnNavBeranda);

        btnNavTagihan.setBackground(new java.awt.Color(18, 55, 102));
        grpNav.add(btnNavTagihan);
        btnNavTagihan.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnNavTagihan.setForeground(new java.awt.Color(255, 255, 255));
        btnNavTagihan.setText("Tagihan & Riwayat kWh");
        btnNavTagihan.setBorderPainted(false);
        btnNavTagihan.setFocusPainted(false);
        btnNavTagihan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavTagihanActionPerformed(evt);
            }
        });
        pnlMenu.add(btnNavTagihan);

        btnNavLapor.setBackground(new java.awt.Color(18, 55, 102));
        grpNav.add(btnNavLapor);
        btnNavLapor.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnNavLapor.setForeground(new java.awt.Color(255, 255, 255));
        btnNavLapor.setText("Lapor Gangguan");
        btnNavLapor.setBorderPainted(false);
        btnNavLapor.setFocusPainted(false);
        btnNavLapor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavLaporActionPerformed(evt);
            }
        });
        pnlMenu.add(btnNavLapor);

        btnNavProfil.setBackground(new java.awt.Color(18, 55, 102));
        grpNav.add(btnNavProfil);
        btnNavProfil.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnNavProfil.setForeground(new java.awt.Color(255, 255, 255));
        btnNavProfil.setText("Profil");
        btnNavProfil.setBorderPainted(false);
        btnNavProfil.setFocusPainted(false);
        btnNavProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavProfilActionPerformed(evt);
            }
        });
        pnlMenu.add(btnNavProfil);

        pnlNavbar.add(pnlMenu, java.awt.BorderLayout.CENTER);

        pnlAkun.setBackground(new java.awt.Color(11, 37, 69));
        pnlAkun.setPreferredSize(new java.awt.Dimension(250, 60));
        pnlAkun.setLayout(null);

        lblNama.setText("Nama Pelanggan");
        lblNama.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblNama.setForeground(new java.awt.Color(255, 255, 255));
        lblNama.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pnlAkun.add(lblNama);
        lblNama.setBounds(0, 20, 140, 22);

        btnKeluar.setBackground(new java.awt.Color(176, 47, 47));
        btnKeluar.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnKeluar.setForeground(new java.awt.Color(255, 255, 255));
        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });
        pnlAkun.add(btnKeluar);
        btnKeluar.setBounds(150, 14, 90, 32);

        pnlNavbar.add(pnlAkun, java.awt.BorderLayout.EAST);

        add(pnlNavbar, java.awt.BorderLayout.NORTH);

        pnlIsi.setBackground(new java.awt.Color(234, 241, 251));
        pnlIsi.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 24, 20, 24));
        pnlIsi.setLayout(new java.awt.CardLayout());
        pnlIsi.add(pgBeranda, "Beranda");
        pnlIsi.add(pgTagihan, "Tagihan & riwayat kWh");
        pnlIsi.add(pgLapor, "Lapor gangguan");
        pnlIsi.add(pgProfil, "Profil");

        add(pnlIsi, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNavBerandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavBerandaActionPerformed
        pilih(btnNavBeranda);
    }//GEN-LAST:event_btnNavBerandaActionPerformed

    private void btnNavTagihanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavTagihanActionPerformed
        pilih(btnNavTagihan);
    }//GEN-LAST:event_btnNavTagihanActionPerformed

    private void btnNavLaporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavLaporActionPerformed
        pilih(btnNavLapor);
    }//GEN-LAST:event_btnNavLaporActionPerformed

    private void btnNavProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavProfilActionPerformed
        pilih(btnNavProfil);
    }//GEN-LAST:event_btnNavProfilActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        keluar();
    }//GEN-LAST:event_btnKeluarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKeluar;
    private javax.swing.JToggleButton btnNavBeranda;
    private javax.swing.JToggleButton btnNavLapor;
    private javax.swing.JToggleButton btnNavProfil;
    private javax.swing.JToggleButton btnNavTagihan;
    private javax.swing.ButtonGroup grpNav;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNama;
    private view.pelanggan.PanelBeranda pgBeranda;
    private view.pelanggan.PanelLaporGangguan pgLapor;
    private view.pelanggan.PanelProfil pgProfil;
    private view.pelanggan.PanelTagihanSaya pgTagihan;
    private javax.swing.JPanel pnlAkun;
    private javax.swing.JPanel pnlIsi;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlNavbar;
    // End of variables declaration//GEN-END:variables
}
