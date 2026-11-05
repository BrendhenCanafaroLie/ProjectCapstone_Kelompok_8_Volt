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
        lblLogo = new javax.swing.JLabel();
        lblPeran = new javax.swing.JLabel();
        pnlGarisMerek = new javax.swing.JPanel();
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

        lblLogo.setText("VOLT");
        lblLogo.setFont(new java.awt.Font("Segoe UI", 1, 32));
        lblLogo.setForeground(new java.awt.Color(245, 158, 11));
        lblPeran.setText("Panel kasir");
        lblPeran.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblPeran.setForeground(new java.awt.Color(191, 219, 254));
        pnlGarisMerek.setBackground(new java.awt.Color(245, 158, 11));
        pnlGarisMerek.setLayout(null);
        pnlMerek.setBackground(new java.awt.Color(11, 37, 69));
        pnlMerek.setPreferredSize(new java.awt.Dimension(230, 92));
        pnlMerek.setLayout(null);
        pnlMerek.add(lblLogo);
        lblLogo.setBounds(22, 18, 180, 42);
        pnlMerek.add(lblPeran);
        lblPeran.setBounds(24, 60, 190, 20);
        pnlMerek.add(pnlGarisMerek);
        pnlGarisMerek.setBounds(24, 84, 46, 3);
        grTrans.setText("TRANSAKSI");
        grTrans.setFont(new java.awt.Font("Segoe UI", 1, 11));
        grTrans.setForeground(new java.awt.Color(127, 166, 224));
        btnNavTransaksi.setText("Transaksi pembayaran");
        btnNavTransaksi.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnNavTransaksi.setBackground(new java.awt.Color(18, 55, 102));
        btnNavTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        btnNavTransaksi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavTransaksi.setFocusPainted(false);
        btnNavTransaksi.setBorderPainted(false);
        grpNav.add(btnNavTransaksi);
        btnNavTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavTransaksiActionPerformed(evt);
            }
        });
        btnNavRiwayat.setText("Riwayat transaksi");
        btnNavRiwayat.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnNavRiwayat.setBackground(new java.awt.Color(18, 55, 102));
        btnNavRiwayat.setForeground(new java.awt.Color(255, 255, 255));
        btnNavRiwayat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavRiwayat.setFocusPainted(false);
        btnNavRiwayat.setBorderPainted(false);
        grpNav.add(btnNavRiwayat);
        btnNavRiwayat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavRiwayatActionPerformed(evt);
            }
        });
        grAkun.setText("AKUN");
        grAkun.setFont(new java.awt.Font("Segoe UI", 1, 11));
        grAkun.setForeground(new java.awt.Color(127, 166, 224));
        btnNavProfil.setText("Profil saya");
        btnNavProfil.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnNavProfil.setBackground(new java.awt.Color(18, 55, 102));
        btnNavProfil.setForeground(new java.awt.Color(255, 255, 255));
        btnNavProfil.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavProfil.setFocusPainted(false);
        btnNavProfil.setBorderPainted(false);
        grpNav.add(btnNavProfil);
        btnNavProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavProfilActionPerformed(evt);
            }
        });
        pnlMenu.setBackground(new java.awt.Color(11, 37, 69));
        pnlMenu.setLayout(null);
        pnlMenu.add(grTrans);
        grTrans.setBounds(22, 12, 190, 20);
        pnlMenu.add(btnNavTransaksi);
        btnNavTransaksi.setBounds(14, 36, 202, 40);
        pnlMenu.add(btnNavRiwayat);
        btnNavRiwayat.setBounds(14, 82, 202, 40);
        pnlMenu.add(grAkun);
        grAkun.setBounds(22, 136, 190, 20);
        pnlMenu.add(btnNavProfil);
        btnNavProfil.setBounds(14, 160, 202, 40);
        lblNama.setText("Budi Setiawan");
        lblNama.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblNama.setForeground(new java.awt.Color(255, 255, 255));
        lblDetail.setText("Setoran: Sudah Setor");
        lblDetail.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblDetail.setForeground(new java.awt.Color(191, 219, 254));
        btnKeluar.setText("Keluar");
        btnKeluar.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnKeluar.setBackground(new java.awt.Color(220, 38, 38));
        btnKeluar.setForeground(new java.awt.Color(255, 255, 255));
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });
        pnlAkun.setBackground(new java.awt.Color(15, 47, 88));
        pnlAkun.setPreferredSize(new java.awt.Dimension(230, 118));
        pnlAkun.setLayout(null);
        pnlAkun.add(lblNama);
        lblNama.setBounds(18, 12, 196, 22);
        pnlAkun.add(lblDetail);
        lblDetail.setBounds(18, 34, 196, 20);
        pnlAkun.add(btnKeluar);
        btnKeluar.setBounds(18, 66, 194, 36);
        pnlSidebar.setBackground(new java.awt.Color(11, 37, 69));
        pnlSidebar.setPreferredSize(new java.awt.Dimension(230, 0));
        pnlSidebar.setLayout(new java.awt.BorderLayout());
        pnlSidebar.add(pnlMerek, java.awt.BorderLayout.NORTH);
        pnlSidebar.add(pnlMenu, java.awt.BorderLayout.CENTER);
        pnlSidebar.add(pnlAkun, java.awt.BorderLayout.SOUTH);
        lblJudulHal.setText("Transaksi pembayaran");
        lblJudulHal.setFont(new java.awt.Font("Segoe UI", 1, 22));
        lblJudulHal.setForeground(new java.awt.Color(11, 37, 69));
        lblKetHal.setText("Cari tagihan pelanggan lalu proses pembayarannya");
        lblKetHal.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblKetHal.setForeground(new java.awt.Color(100, 116, 139));
        pnlTeksJudul.setBackground(new java.awt.Color(255, 255, 255));
        pnlTeksJudul.setPreferredSize(new java.awt.Dimension(620, 70));
        pnlTeksJudul.setLayout(null);
        pnlTeksJudul.add(lblJudulHal);
        lblJudulHal.setBounds(0, 10, 620, 32);
        pnlTeksJudul.add(lblKetHal);
        lblKetHal.setBounds(0, 44, 620, 22);
        lblSapa.setText("Selamat siang, Budi");
        lblSapa.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblSapa.setForeground(new java.awt.Color(29, 78, 216));
        lblSapa.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTanggal.setText("Kamis, 5 November 2026");
        lblTanggal.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblTanggal.setForeground(new java.awt.Color(100, 116, 139));
        lblTanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pnlTeksSapa.setBackground(new java.awt.Color(255, 255, 255));
        pnlTeksSapa.setPreferredSize(new java.awt.Dimension(320, 70));
        pnlTeksSapa.setLayout(null);
        pnlTeksSapa.add(lblSapa);
        lblSapa.setBounds(0, 14, 320, 24);
        pnlTeksSapa.add(lblTanggal);
        lblTanggal.setBounds(0, 42, 320, 20);
        pnlJudul.setBackground(new java.awt.Color(255, 255, 255));
        pnlJudul.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 24, 0, 24));
        pnlJudul.setPreferredSize(new java.awt.Dimension(100, 78));
        pnlJudul.setLayout(new java.awt.BorderLayout());
        pnlJudul.add(pnlTeksJudul, java.awt.BorderLayout.WEST);
        pnlJudul.add(pnlTeksSapa, java.awt.BorderLayout.EAST);
        pnlIsi.setBackground(new java.awt.Color(234, 241, 251));
        pnlIsi.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 24, 24, 24));
        pnlIsi.setLayout(new java.awt.CardLayout());
        pnlIsi.add(pgTransaksi, "Transaksi pembayaran");
        pnlIsi.add(pgRiwayat, "Riwayat transaksi");
        pnlIsi.add(pgProfil, "Profil saya");
        pnlKonten.setBackground(new java.awt.Color(234, 241, 251));
        pnlKonten.setLayout(new java.awt.BorderLayout());
        pnlKonten.add(pnlJudul, java.awt.BorderLayout.NORTH);
        pnlKonten.add(pnlIsi, java.awt.BorderLayout.CENTER);
        setBackground(new java.awt.Color(234, 241, 251));
        setLayout(new java.awt.BorderLayout());
        add(pnlSidebar, java.awt.BorderLayout.WEST);
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
