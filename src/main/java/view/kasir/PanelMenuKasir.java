package view.kasir;

import view.BaseMenuPanel;
import view.PanelProfilKaryawan;

import controller.KasirController;
import controller.ProfilKaryawanController;
import model.Karyawan;

/**
 * Menu Kasir: transaksi pembayaran dan riwayatnya.
 * JPanel Form NetBeans: sidebar/navbar, tombol menu, DAN semua halamannya sudah terpasang di PanelMenuKasir.form,
 * sehingga tampilan di tab Design sama dengan tampilan saat program berjalan.
 * Kode di dalam blok GEN-BEGIN/GEN-END dibuat otomatis oleh NetBeans, jangan diedit manual.
 */
public class PanelMenuKasir extends BaseMenuPanel {

    public PanelMenuKasir() {
        initComponents();
    }

    @Override protected javax.swing.JPanel wadahIsi() { return pnlIsi; }
    @Override protected javax.swing.JLabel labelJudul() { return lblJudulHal; }
    @Override protected javax.swing.JLabel labelKet() { return lblKetHal; }
    @Override protected javax.swing.JLabel labelPeran() { return lblPeran; }
    @Override protected javax.swing.JLabel labelNama() { return lblNama; }
    @Override protected javax.swing.JLabel labelDetail() { return lblDetail; }
    @Override protected javax.swing.JLabel labelSapa() { return lblSapa; }
    @Override protected javax.swing.JLabel labelTanggal() { return lblTanggal; }

    @Override protected void hubungkan() {
        KasirController ctrl = new KasirController(pengguna);
        pgTransaksi.setController(ctrl);
        pgRiwayat.setController(ctrl);
        pgProfil.setController(new ProfilKaryawanController((Karyawan) pengguna));
        tambah("Transaksi pembayaran", "Cari tagihan pelanggan lalu proses pembayarannya", pgTransaksi, btnNavTransaksi);
        tambah("Riwayat transaksi", "Pembayaran yang sudah Anda proses", pgRiwayat, btnNavRiwayat);
        tambah("Profil saya", "Lihat data akun Anda", pgProfil, btnNavProfil);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpNav = new javax.swing.ButtonGroup();
        pnlSidebar = new javax.swing.JPanel();
        pnlMerek = new javax.swing.JPanel();
        pnlGarisMerek = new javax.swing.JPanel();
        lblPeran = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        pnlMenu = new javax.swing.JPanel();
        grTrans = new javax.swing.JLabel();
        btnNavTransaksi = new javax.swing.JToggleButton();
        btnNavRiwayat = new javax.swing.JToggleButton();
        grAkun = new javax.swing.JLabel();
        btnNavProfil = new javax.swing.JToggleButton();
        pnlAkun = new javax.swing.JPanel();
        lblNama = new javax.swing.JLabel();
        lblDetail = new javax.swing.JLabel();
        btnKeluar = new javax.swing.JButton();
        pnlKonten = new javax.swing.JPanel();
        pnlJudul = new javax.swing.JPanel();
        pnlTeksJudul = new javax.swing.JPanel();
        lblJudulHal = new javax.swing.JLabel();
        lblKetHal = new javax.swing.JLabel();
        pnlTeksSapa = new javax.swing.JPanel();
        lblSapa = new javax.swing.JLabel();
        lblTanggal = new javax.swing.JLabel();
        pnlIsi = new javax.swing.JPanel();
        pgTransaksi = new view.kasir.PanelTransaksi();
        pgRiwayat = new view.kasir.PanelRiwayatKasir();
        pgProfil = new view.PanelProfilKaryawan();

        setBackground(new java.awt.Color(234, 241, 251));
        setLayout(new java.awt.BorderLayout());

        pnlSidebar.setBackground(new java.awt.Color(11, 37, 69));
        pnlSidebar.setPreferredSize(new java.awt.Dimension(230, 0));
        pnlSidebar.setLayout(new java.awt.BorderLayout());

        pnlMerek.setBackground(new java.awt.Color(0, 14, 48));
        pnlMerek.setPreferredSize(new java.awt.Dimension(230, 92));
        pnlMerek.setLayout(null);

        pnlGarisMerek.setBackground(new java.awt.Color(245, 158, 11));
        pnlGarisMerek.setLayout(null);
        pnlMerek.add(pnlGarisMerek);
        pnlGarisMerek.setBounds(24, 84, 46, 3);

        lblPeran.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPeran.setForeground(new java.awt.Color(191, 219, 254));
        lblPeran.setText("PANEL KASIR");
        pnlMerek.add(lblPeran);
        lblPeran.setBounds(24, 60, 190, 20);

        lblLogo.setFont(new java.awt.Font("Lucida Console", 1, 48)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(245, 158, 11));
        lblLogo.setText("VOLT");
        pnlMerek.add(lblLogo);
        lblLogo.setBounds(20, 12, 180, 50);

        pnlSidebar.add(pnlMerek, java.awt.BorderLayout.NORTH);

        pnlMenu.setBackground(new java.awt.Color(0, 19, 66));
        pnlMenu.setLayout(null);

        grTrans.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        grTrans.setForeground(new java.awt.Color(127, 166, 224));
        grTrans.setText("TRANSAKSI");
        pnlMenu.add(grTrans);
        grTrans.setBounds(22, 12, 190, 20);

        btnNavTransaksi.setBackground(new java.awt.Color(0, 46, 104));
        grpNav.add(btnNavTransaksi);
        btnNavTransaksi.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnNavTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        btnNavTransaksi.setText("Transaksi Pembayaran");
        btnNavTransaksi.setBorderPainted(false);
        btnNavTransaksi.setFocusPainted(false);
        btnNavTransaksi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavTransaksiActionPerformed(evt);
            }
        });
        pnlMenu.add(btnNavTransaksi);
        btnNavTransaksi.setBounds(14, 36, 202, 40);

        btnNavRiwayat.setBackground(new java.awt.Color(0, 46, 104));
        grpNav.add(btnNavRiwayat);
        btnNavRiwayat.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnNavRiwayat.setForeground(new java.awt.Color(255, 255, 255));
        btnNavRiwayat.setText("Riwayat Transaksi");
        btnNavRiwayat.setBorderPainted(false);
        btnNavRiwayat.setFocusPainted(false);
        btnNavRiwayat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavRiwayat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavRiwayatActionPerformed(evt);
            }
        });
        pnlMenu.add(btnNavRiwayat);
        btnNavRiwayat.setBounds(14, 82, 202, 40);

        grAkun.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        grAkun.setForeground(new java.awt.Color(127, 166, 224));
        grAkun.setText("AKUN");
        pnlMenu.add(grAkun);
        grAkun.setBounds(22, 136, 190, 20);

        btnNavProfil.setBackground(new java.awt.Color(0, 46, 104));
        grpNav.add(btnNavProfil);
        btnNavProfil.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnNavProfil.setForeground(new java.awt.Color(255, 255, 255));
        btnNavProfil.setText("Profil Saya");
        btnNavProfil.setBorderPainted(false);
        btnNavProfil.setFocusPainted(false);
        btnNavProfil.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavProfilActionPerformed(evt);
            }
        });
        pnlMenu.add(btnNavProfil);
        btnNavProfil.setBounds(14, 160, 202, 40);

        pnlSidebar.add(pnlMenu, java.awt.BorderLayout.CENTER);

        pnlAkun.setBackground(new java.awt.Color(0, 14, 48));
        pnlAkun.setPreferredSize(new java.awt.Dimension(230, 118));
        pnlAkun.setLayout(null);

        lblNama.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblNama.setForeground(new java.awt.Color(255, 255, 255));
        lblNama.setText("Budi Setiawan");
        pnlAkun.add(lblNama);
        lblNama.setBounds(18, 12, 196, 22);

        lblDetail.setForeground(new java.awt.Color(191, 219, 254));
        lblDetail.setText("Setoran: Sudah Setor");
        pnlAkun.add(lblDetail);
        lblDetail.setBounds(18, 34, 196, 20);

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
        btnKeluar.setBounds(18, 66, 194, 36);

        pnlSidebar.add(pnlAkun, java.awt.BorderLayout.SOUTH);

        add(pnlSidebar, java.awt.BorderLayout.WEST);

        pnlKonten.setBackground(new java.awt.Color(234, 241, 251));
        pnlKonten.setLayout(new java.awt.BorderLayout());

        pnlJudul.setBackground(new java.awt.Color(0, 14, 48));
        pnlJudul.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 24, 0, 24));
        pnlJudul.setPreferredSize(new java.awt.Dimension(100, 78));
        pnlJudul.setLayout(new java.awt.BorderLayout());

        pnlTeksJudul.setBackground(new java.awt.Color(0, 14, 48));
        pnlTeksJudul.setPreferredSize(new java.awt.Dimension(620, 70));
        pnlTeksJudul.setLayout(null);

        lblJudulHal.setBackground(new java.awt.Color(245, 158, 11));
        lblJudulHal.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblJudulHal.setForeground(new java.awt.Color(245, 158, 11));
        lblJudulHal.setText("Transaksi pembayaran");
        pnlTeksJudul.add(lblJudulHal);
        lblJudulHal.setBounds(0, 10, 620, 32);

        lblKetHal.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblKetHal.setForeground(new java.awt.Color(191, 219, 254));
        lblKetHal.setText("Cari Tagihan Pelanggan Lalu Proses Pembayarannya");
        pnlTeksJudul.add(lblKetHal);
        lblKetHal.setBounds(0, 44, 620, 22);

        pnlJudul.add(pnlTeksJudul, java.awt.BorderLayout.WEST);

        pnlTeksSapa.setBackground(new java.awt.Color(0, 14, 48));
        pnlTeksSapa.setPreferredSize(new java.awt.Dimension(320, 70));
        pnlTeksSapa.setLayout(null);

        lblSapa.setBackground(new java.awt.Color(255, 255, 255));
        lblSapa.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblSapa.setForeground(new java.awt.Color(255, 255, 255));
        lblSapa.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSapa.setText("Selamat siang, Budi");
        pnlTeksSapa.add(lblSapa);
        lblSapa.setBounds(0, 14, 320, 24);

        lblTanggal.setForeground(new java.awt.Color(191, 219, 254));
        lblTanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTanggal.setText("Kamis, 5 November 2026");
        pnlTeksSapa.add(lblTanggal);
        lblTanggal.setBounds(0, 42, 320, 20);

        pnlJudul.add(pnlTeksSapa, java.awt.BorderLayout.EAST);

        pnlKonten.add(pnlJudul, java.awt.BorderLayout.NORTH);

        pnlIsi.setBackground(new java.awt.Color(234, 241, 251));
        pnlIsi.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 24, 24, 24));
        pnlIsi.setLayout(new java.awt.CardLayout());
        pnlIsi.add(pgTransaksi, "Transaksi pembayaran");
        pnlIsi.add(pgRiwayat, "Riwayat transaksi");
        pnlIsi.add(pgProfil, "Profil saya");

        pnlKonten.add(pnlIsi, java.awt.BorderLayout.CENTER);

        add(pnlKonten, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNavTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavTransaksiActionPerformed
        pilih(btnNavTransaksi);
    }//GEN-LAST:event_btnNavTransaksiActionPerformed

    private void btnNavRiwayatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavRiwayatActionPerformed
        pilih(btnNavRiwayat);
    }//GEN-LAST:event_btnNavRiwayatActionPerformed

    private void btnNavProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavProfilActionPerformed
        pilih(btnNavProfil);
    }//GEN-LAST:event_btnNavProfilActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        keluar();
    }//GEN-LAST:event_btnKeluarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKeluar;
    private javax.swing.JToggleButton btnNavProfil;
    private javax.swing.JToggleButton btnNavRiwayat;
    private javax.swing.JToggleButton btnNavTransaksi;
    private javax.swing.JLabel grAkun;
    private javax.swing.JLabel grTrans;
    private javax.swing.ButtonGroup grpNav;
    private javax.swing.JLabel lblDetail;
    private javax.swing.JLabel lblJudulHal;
    private javax.swing.JLabel lblKetHal;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblPeran;
    private javax.swing.JLabel lblSapa;
    private javax.swing.JLabel lblTanggal;
    private view.PanelProfilKaryawan pgProfil;
    private view.kasir.PanelRiwayatKasir pgRiwayat;
    private view.kasir.PanelTransaksi pgTransaksi;
    private javax.swing.JPanel pnlAkun;
    private javax.swing.JPanel pnlGarisMerek;
    private javax.swing.JPanel pnlIsi;
    private javax.swing.JPanel pnlJudul;
    private javax.swing.JPanel pnlKonten;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlMerek;
    private javax.swing.JPanel pnlSidebar;
    private javax.swing.JPanel pnlTeksJudul;
    private javax.swing.JPanel pnlTeksSapa;
    // End of variables declaration//GEN-END:variables
}
