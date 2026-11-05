package view.admin;

import view.BaseMenuPanel;
import view.PanelProfilKaryawan;

import controller.AdminController;
import controller.ProfilKaryawanController;
import model.Karyawan;

/**
 * Menu Admin: dashboard, data master, validasi registrasi, pembayaran, pengaduan.
 * JPanel Form NetBeans: sidebar/navbar, tombol menu, DAN semua halamannya sudah terpasang di PanelMenuAdmin.form,
 * sehingga tampilan di tab Design sama dengan tampilan saat program berjalan.
 * Kode di dalam blok GEN-BEGIN/GEN-END dibuat otomatis oleh NetBeans, jangan diedit manual.
 */
public class PanelMenuAdmin extends BaseMenuPanel {

    public PanelMenuAdmin() {
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
        AdminController ctrl = new AdminController();
        pgDashboard.setController(ctrl);
        pgPetugas.setController(ctrl);
        pgGolongan.setController(ctrl);
        pgRegistrasi.setController(ctrl);
        pgPembayaran.setController(ctrl);
        pgPengaduan.setController(ctrl);
        pgProfil.setController(new ProfilKaryawanController((Karyawan) pengguna));
        tambah("Dashboard statistik", "Statistik pelanggan, tagihan, dan pengaduan", pgDashboard, btnNavDashboard);
        tambah("Data petugas", "Kelola akun petugas lapangan dan kasir", pgPetugas, btnNavPetugas);
        tambah("Golongan tarif", "Atur daya, tarif per kWh, dan biaya beban", pgGolongan, btnNavGolongan);
        tambah("Registrasi pengguna", "Validasi pendaftaran pelanggan baru", pgRegistrasi, btnNavRegistrasi);
        tambah("Riwayat pembayaran", "Semua transaksi pembayaran yang masuk", pgPembayaran, btnNavPembayaran);
        tambah("Laporan pengaduan", "Laporan gangguan listrik dari pelanggan", pgPengaduan, btnNavPengaduan);
        tambah("Profil saya", "Lihat akun Anda dan ubah email Admin", pgProfil, btnNavProfil);
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
        grRingkas = new javax.swing.JLabel();
        btnNavDashboard = new javax.swing.JToggleButton();
        grMaster = new javax.swing.JLabel();
        btnNavPetugas = new javax.swing.JToggleButton();
        btnNavGolongan = new javax.swing.JToggleButton();
        grOps = new javax.swing.JLabel();
        btnNavRegistrasi = new javax.swing.JToggleButton();
        btnNavPembayaran = new javax.swing.JToggleButton();
        btnNavPengaduan = new javax.swing.JToggleButton();
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
        pgDashboard = new view.admin.PanelDashboardAdmin();
        pgPetugas = new view.admin.PanelPetugas();
        pgGolongan = new view.admin.PanelGolongan();
        pgRegistrasi = new view.admin.PanelRegistrasi();
        pgPembayaran = new view.admin.PanelPembayaranAdmin();
        pgPengaduan = new view.admin.PanelPengaduanAdmin();
        pgProfil = new view.PanelProfilKaryawan();

        lblLogo.setText("VOLT");
        lblLogo.setFont(new java.awt.Font("Segoe UI", 1, 32));
        lblLogo.setForeground(new java.awt.Color(245, 158, 11));
        lblPeran.setText("Panel admin");
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
        grRingkas.setText("RINGKASAN");
        grRingkas.setFont(new java.awt.Font("Segoe UI", 1, 11));
        grRingkas.setForeground(new java.awt.Color(127, 166, 224));
        btnNavDashboard.setText("Dashboard statistik");
        btnNavDashboard.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnNavDashboard.setBackground(new java.awt.Color(18, 55, 102));
        btnNavDashboard.setForeground(new java.awt.Color(255, 255, 255));
        btnNavDashboard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavDashboard.setFocusPainted(false);
        btnNavDashboard.setBorderPainted(false);
        grpNav.add(btnNavDashboard);
        btnNavDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavDashboardActionPerformed(evt);
            }
        });
        grMaster.setText("DATA MASTER");
        grMaster.setFont(new java.awt.Font("Segoe UI", 1, 11));
        grMaster.setForeground(new java.awt.Color(127, 166, 224));
        btnNavPetugas.setText("Data petugas");
        btnNavPetugas.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnNavPetugas.setBackground(new java.awt.Color(18, 55, 102));
        btnNavPetugas.setForeground(new java.awt.Color(255, 255, 255));
        btnNavPetugas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavPetugas.setFocusPainted(false);
        btnNavPetugas.setBorderPainted(false);
        grpNav.add(btnNavPetugas);
        btnNavPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavPetugasActionPerformed(evt);
            }
        });
        btnNavGolongan.setText("Golongan tarif");
        btnNavGolongan.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnNavGolongan.setBackground(new java.awt.Color(18, 55, 102));
        btnNavGolongan.setForeground(new java.awt.Color(255, 255, 255));
        btnNavGolongan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavGolongan.setFocusPainted(false);
        btnNavGolongan.setBorderPainted(false);
        grpNav.add(btnNavGolongan);
        btnNavGolongan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavGolonganActionPerformed(evt);
            }
        });
        grOps.setText("OPERASIONAL");
        grOps.setFont(new java.awt.Font("Segoe UI", 1, 11));
        grOps.setForeground(new java.awt.Color(127, 166, 224));
        btnNavRegistrasi.setText("Registrasi pengguna");
        btnNavRegistrasi.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnNavRegistrasi.setBackground(new java.awt.Color(18, 55, 102));
        btnNavRegistrasi.setForeground(new java.awt.Color(255, 255, 255));
        btnNavRegistrasi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavRegistrasi.setFocusPainted(false);
        btnNavRegistrasi.setBorderPainted(false);
        grpNav.add(btnNavRegistrasi);
        btnNavRegistrasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavRegistrasiActionPerformed(evt);
            }
        });
        btnNavPembayaran.setText("Riwayat pembayaran");
        btnNavPembayaran.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnNavPembayaran.setBackground(new java.awt.Color(18, 55, 102));
        btnNavPembayaran.setForeground(new java.awt.Color(255, 255, 255));
        btnNavPembayaran.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavPembayaran.setFocusPainted(false);
        btnNavPembayaran.setBorderPainted(false);
        grpNav.add(btnNavPembayaran);
        btnNavPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavPembayaranActionPerformed(evt);
            }
        });
        btnNavPengaduan.setText("Laporan pengaduan");
        btnNavPengaduan.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnNavPengaduan.setBackground(new java.awt.Color(18, 55, 102));
        btnNavPengaduan.setForeground(new java.awt.Color(255, 255, 255));
        btnNavPengaduan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavPengaduan.setFocusPainted(false);
        btnNavPengaduan.setBorderPainted(false);
        grpNav.add(btnNavPengaduan);
        btnNavPengaduan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavPengaduanActionPerformed(evt);
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
        pnlMenu.add(grRingkas);
        grRingkas.setBounds(22, 12, 190, 20);
        pnlMenu.add(btnNavDashboard);
        btnNavDashboard.setBounds(14, 36, 202, 40);
        pnlMenu.add(grMaster);
        grMaster.setBounds(22, 90, 190, 20);
        pnlMenu.add(btnNavPetugas);
        btnNavPetugas.setBounds(14, 114, 202, 40);
        pnlMenu.add(btnNavGolongan);
        btnNavGolongan.setBounds(14, 160, 202, 40);
        pnlMenu.add(grOps);
        grOps.setBounds(22, 214, 190, 20);
        pnlMenu.add(btnNavRegistrasi);
        btnNavRegistrasi.setBounds(14, 238, 202, 40);
        pnlMenu.add(btnNavPembayaran);
        btnNavPembayaran.setBounds(14, 284, 202, 40);
        pnlMenu.add(btnNavPengaduan);
        btnNavPengaduan.setBounds(14, 330, 202, 40);
        pnlMenu.add(grAkun);
        grAkun.setBounds(22, 384, 190, 20);
        pnlMenu.add(btnNavProfil);
        btnNavProfil.setBounds(14, 408, 202, 40);
        lblNama.setText("Andi Pratama");
        lblNama.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblNama.setForeground(new java.awt.Color(255, 255, 255));
        lblDetail.setText("Admin");
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
        lblJudulHal.setText("Dashboard statistik");
        lblJudulHal.setFont(new java.awt.Font("Segoe UI", 1, 22));
        lblJudulHal.setForeground(new java.awt.Color(11, 37, 69));
        lblKetHal.setText("Statistik pelanggan, tagihan, dan pengaduan");
        lblKetHal.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblKetHal.setForeground(new java.awt.Color(100, 116, 139));
        pnlTeksJudul.setBackground(new java.awt.Color(255, 255, 255));
        pnlTeksJudul.setPreferredSize(new java.awt.Dimension(620, 70));
        pnlTeksJudul.setLayout(null);
        pnlTeksJudul.add(lblJudulHal);
        lblJudulHal.setBounds(0, 10, 620, 32);
        pnlTeksJudul.add(lblKetHal);
        lblKetHal.setBounds(0, 44, 620, 22);
        lblSapa.setText("Selamat siang, Andi");
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
        pnlIsi.add(pgDashboard, "Dashboard statistik");
        pnlIsi.add(pgPetugas, "Data petugas");
        pnlIsi.add(pgGolongan, "Golongan tarif");
        pnlIsi.add(pgRegistrasi, "Registrasi pengguna");
        pnlIsi.add(pgPembayaran, "Riwayat pembayaran");
        pnlIsi.add(pgPengaduan, "Laporan pengaduan");
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

    private void btnNavDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavDashboardActionPerformed
        pilih(btnNavDashboard);
    }//GEN-LAST:event_btnNavDashboardActionPerformed

    private void btnNavPetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavPetugasActionPerformed
        pilih(btnNavPetugas);
    }//GEN-LAST:event_btnNavPetugasActionPerformed

    private void btnNavGolonganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavGolonganActionPerformed
        pilih(btnNavGolongan);
    }//GEN-LAST:event_btnNavGolonganActionPerformed

    private void btnNavRegistrasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavRegistrasiActionPerformed
        pilih(btnNavRegistrasi);
    }//GEN-LAST:event_btnNavRegistrasiActionPerformed

    private void btnNavPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavPembayaranActionPerformed
        pilih(btnNavPembayaran);
    }//GEN-LAST:event_btnNavPembayaranActionPerformed

    private void btnNavPengaduanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavPengaduanActionPerformed
        pilih(btnNavPengaduan);
    }//GEN-LAST:event_btnNavPengaduanActionPerformed

    private void btnNavProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavProfilActionPerformed
        pilih(btnNavProfil);
    }//GEN-LAST:event_btnNavProfilActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        keluar();
    }//GEN-LAST:event_btnKeluarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKeluar;
    private javax.swing.JToggleButton btnNavDashboard;
    private javax.swing.JToggleButton btnNavGolongan;
    private javax.swing.JToggleButton btnNavPembayaran;
    private javax.swing.JToggleButton btnNavPengaduan;
    private javax.swing.JToggleButton btnNavPetugas;
    private javax.swing.JToggleButton btnNavProfil;
    private javax.swing.JToggleButton btnNavRegistrasi;
    private javax.swing.JLabel grAkun;
    private javax.swing.JLabel grMaster;
    private javax.swing.JLabel grOps;
    private javax.swing.JLabel grRingkas;
    private javax.swing.ButtonGroup grpNav;
    private javax.swing.JLabel lblDetail;
    private javax.swing.JLabel lblJudulHal;
    private javax.swing.JLabel lblKetHal;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblPeran;
    private javax.swing.JLabel lblSapa;
    private javax.swing.JLabel lblTanggal;
    private view.admin.PanelDashboardAdmin pgDashboard;
    private view.admin.PanelGolongan pgGolongan;
    private view.admin.PanelPembayaranAdmin pgPembayaran;
    private view.admin.PanelPengaduanAdmin pgPengaduan;
    private view.admin.PanelPetugas pgPetugas;
    private view.PanelProfilKaryawan pgProfil;
    private view.admin.PanelRegistrasi pgRegistrasi;
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
