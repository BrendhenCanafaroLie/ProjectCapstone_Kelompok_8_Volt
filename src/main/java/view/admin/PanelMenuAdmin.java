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

        setBackground(new java.awt.Color(234, 241, 251));
        setLayout(new java.awt.BorderLayout());

        pnlSidebar.setBackground(new java.awt.Color(11, 37, 69));
        pnlSidebar.setPreferredSize(new java.awt.Dimension(230, 0));
        pnlSidebar.setLayout(new java.awt.BorderLayout());

        pnlMerek.setBackground(new java.awt.Color(0, 14, 48));
        pnlMerek.setPreferredSize(new java.awt.Dimension(230, 92));
        pnlMerek.setLayout(null);

        lblLogo.setFont(new java.awt.Font("Lucida Console", 1, 48)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(245, 158, 11));
        lblLogo.setText("VOLT");
        pnlMerek.add(lblLogo);
        lblLogo.setBounds(20, 12, 180, 50);

        lblPeran.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPeran.setForeground(new java.awt.Color(191, 219, 254));
        lblPeran.setText("PANEL ADMIN");
        pnlMerek.add(lblPeran);
        lblPeran.setBounds(24, 60, 190, 20);

        pnlGarisMerek.setBackground(new java.awt.Color(245, 158, 11));
        pnlGarisMerek.setLayout(null);
        pnlMerek.add(pnlGarisMerek);
        pnlGarisMerek.setBounds(24, 84, 46, 3);

        pnlSidebar.add(pnlMerek, java.awt.BorderLayout.NORTH);

        pnlMenu.setBackground(new java.awt.Color(0, 19, 66));
        pnlMenu.setLayout(null);

        grRingkas.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        grRingkas.setForeground(new java.awt.Color(127, 166, 224));
        grRingkas.setText("RINGKASAN");
        pnlMenu.add(grRingkas);
        grRingkas.setBounds(22, 12, 190, 20);

        btnNavDashboard.setBackground(new java.awt.Color(0, 46, 104));
        grpNav.add(btnNavDashboard);
        btnNavDashboard.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnNavDashboard.setForeground(new java.awt.Color(255, 255, 255));
        btnNavDashboard.setText("Dashboard Statistik");
        btnNavDashboard.setBorderPainted(false);
        btnNavDashboard.setFocusPainted(false);
        btnNavDashboard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavDashboardActionPerformed(evt);
            }
        });
        pnlMenu.add(btnNavDashboard);
        btnNavDashboard.setBounds(14, 36, 202, 40);

        grMaster.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        grMaster.setForeground(new java.awt.Color(127, 166, 224));
        grMaster.setText("DATA MASTER");
        pnlMenu.add(grMaster);
        grMaster.setBounds(22, 90, 190, 20);

        btnNavPetugas.setBackground(new java.awt.Color(0, 46, 104));
        grpNav.add(btnNavPetugas);
        btnNavPetugas.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnNavPetugas.setForeground(new java.awt.Color(255, 255, 255));
        btnNavPetugas.setText("Data Petugas");
        btnNavPetugas.setBorderPainted(false);
        btnNavPetugas.setFocusPainted(false);
        btnNavPetugas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavPetugasActionPerformed(evt);
            }
        });
        pnlMenu.add(btnNavPetugas);
        btnNavPetugas.setBounds(14, 114, 202, 40);

        btnNavGolongan.setBackground(new java.awt.Color(0, 46, 104));
        grpNav.add(btnNavGolongan);
        btnNavGolongan.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnNavGolongan.setForeground(new java.awt.Color(255, 255, 255));
        btnNavGolongan.setText("Golongan Tarif");
        btnNavGolongan.setBorderPainted(false);
        btnNavGolongan.setFocusPainted(false);
        btnNavGolongan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavGolongan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavGolonganActionPerformed(evt);
            }
        });
        pnlMenu.add(btnNavGolongan);
        btnNavGolongan.setBounds(14, 160, 202, 40);

        grOps.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        grOps.setForeground(new java.awt.Color(127, 166, 224));
        grOps.setText("OPERASIONAL");
        pnlMenu.add(grOps);
        grOps.setBounds(22, 214, 190, 20);

        btnNavRegistrasi.setBackground(new java.awt.Color(0, 46, 104));
        grpNav.add(btnNavRegistrasi);
        btnNavRegistrasi.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnNavRegistrasi.setForeground(new java.awt.Color(255, 255, 255));
        btnNavRegistrasi.setText("Registrasi Pengguna");
        btnNavRegistrasi.setBorderPainted(false);
        btnNavRegistrasi.setFocusPainted(false);
        btnNavRegistrasi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavRegistrasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavRegistrasiActionPerformed(evt);
            }
        });
        pnlMenu.add(btnNavRegistrasi);
        btnNavRegistrasi.setBounds(14, 238, 202, 40);

        btnNavPembayaran.setBackground(new java.awt.Color(0, 46, 104));
        grpNav.add(btnNavPembayaran);
        btnNavPembayaran.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnNavPembayaran.setForeground(new java.awt.Color(255, 255, 255));
        btnNavPembayaran.setText("Riwayat Pembayaran");
        btnNavPembayaran.setBorderPainted(false);
        btnNavPembayaran.setFocusPainted(false);
        btnNavPembayaran.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavPembayaranActionPerformed(evt);
            }
        });
        pnlMenu.add(btnNavPembayaran);
        btnNavPembayaran.setBounds(14, 284, 202, 40);

        btnNavPengaduan.setBackground(new java.awt.Color(0, 46, 104));
        grpNav.add(btnNavPengaduan);
        btnNavPengaduan.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnNavPengaduan.setForeground(new java.awt.Color(255, 255, 255));
        btnNavPengaduan.setText("Laporan Pengaduan");
        btnNavPengaduan.setBorderPainted(false);
        btnNavPengaduan.setFocusPainted(false);
        btnNavPengaduan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavPengaduan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavPengaduanActionPerformed(evt);
            }
        });
        pnlMenu.add(btnNavPengaduan);
        btnNavPengaduan.setBounds(14, 330, 202, 40);

        grAkun.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        grAkun.setForeground(new java.awt.Color(127, 166, 224));
        grAkun.setText("AKUN");
        pnlMenu.add(grAkun);
        grAkun.setBounds(22, 384, 190, 20);

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
        btnNavProfil.setBounds(14, 408, 202, 40);

        pnlSidebar.add(pnlMenu, java.awt.BorderLayout.CENTER);

        pnlAkun.setBackground(new java.awt.Color(0, 14, 48));
        pnlAkun.setPreferredSize(new java.awt.Dimension(230, 118));
        pnlAkun.setLayout(null);

        lblNama.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblNama.setForeground(new java.awt.Color(255, 255, 255));
        lblNama.setText("Andi Pratama");
        pnlAkun.add(lblNama);
        lblNama.setBounds(18, 12, 196, 22);

        lblDetail.setForeground(new java.awt.Color(191, 219, 254));
        lblDetail.setText("Admin");
        pnlAkun.add(lblDetail);
        lblDetail.setBounds(18, 34, 196, 20);

        btnKeluar.setBackground(new java.awt.Color(220, 38, 38));
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
        pnlTeksJudul.setForeground(new java.awt.Color(255, 255, 255));
        pnlTeksJudul.setPreferredSize(new java.awt.Dimension(620, 70));
        pnlTeksJudul.setLayout(null);

        lblJudulHal.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblJudulHal.setForeground(new java.awt.Color(245, 158, 11));
        lblJudulHal.setText("Dashboard Statistik");
        pnlTeksJudul.add(lblJudulHal);
        lblJudulHal.setBounds(0, 10, 290, 32);

        lblKetHal.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblKetHal.setForeground(new java.awt.Color(100, 116, 139));
        lblKetHal.setText("Statistik Pelanggan, Tagihan, dan Pengaduan");
        pnlTeksJudul.add(lblKetHal);
        lblKetHal.setBounds(0, 40, 290, 22);

        pnlJudul.add(pnlTeksJudul, java.awt.BorderLayout.WEST);

        pnlTeksSapa.setBackground(new java.awt.Color(0, 14, 48));
        pnlTeksSapa.setPreferredSize(new java.awt.Dimension(320, 70));
        pnlTeksSapa.setLayout(null);

        lblSapa.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblSapa.setForeground(new java.awt.Color(255, 255, 255));
        lblSapa.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSapa.setText("Selamat siang, Andi");
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
        pnlIsi.add(pgDashboard, "Dashboard statistik");
        pnlIsi.add(pgPetugas, "Data petugas");
        pnlIsi.add(pgGolongan, "Golongan tarif");
        pnlIsi.add(pgRegistrasi, "Registrasi pengguna");
        pnlIsi.add(pgPembayaran, "Riwayat pembayaran");
        pnlIsi.add(pgPengaduan, "Laporan pengaduan");
        pnlIsi.add(pgProfil, "Profil saya");

        pnlKonten.add(pnlIsi, java.awt.BorderLayout.CENTER);

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
