package view.petugas;

import view.BaseMenuPanel;
import view.PanelProfilKaryawan;

import controller.PetugasController;
import controller.ProfilKaryawanController;
import model.Karyawan;
import model.PetugasLapangan;
import util.Konstanta;

/**
 * Menu Petugas Lapangan: semua petugas memperbarui pengaduan; membuat tagihan hanya Catat Meter / Keduanya.
 * JPanel Form NetBeans: sidebar/navbar, tombol menu, DAN semua halamannya sudah terpasang di PanelMenuPetugas.form,
 * sehingga tampilan di tab Design sama dengan tampilan saat program berjalan.
 * Kode di dalam blok GEN-BEGIN/GEN-END dibuat otomatis oleh NetBeans, jangan diedit manual.
 */
public class PanelMenuPetugas extends BaseMenuPanel {

    public PanelMenuPetugas() {
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
        PetugasController ctrl = new PetugasController(pengguna);
        String spes = pengguna instanceof PetugasLapangan pl ? pl.getSpesialis() : Konstanta.SPES_KEDUANYA;
        boolean catat = !Konstanta.SPES_TEKNISI.equals(spes);   // Teknisi tidak membuat tagihan
        grCatat.setVisible(catat);
        btnNavTagihan.setVisible(catat);
        pgPengaduan.setController(ctrl);
        pgTagihan.setController(ctrl);
        pgProfil.setController(new ProfilKaryawanController((Karyawan) pengguna));
        tambah("Status pengaduan", "Perbarui status penanganan gangguan listrik", pgPengaduan, btnNavPengaduan);
        tambah("Profil saya", "Lihat data akun Anda", pgProfil, btnNavProfil);
        if (catat) tambah("Membuat tagihan", "Catat meter pelanggan dan terbitkan tagihan bulanan", pgTagihan, btnNavTagihan);
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
        grLap = new javax.swing.JLabel();
        btnNavPengaduan = new javax.swing.JToggleButton();
        grAkun = new javax.swing.JLabel();
        btnNavProfil = new javax.swing.JToggleButton();
        grCatat = new javax.swing.JLabel();
        btnNavTagihan = new javax.swing.JToggleButton();
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
        pgPengaduan = new view.petugas.PanelUpdatePengaduan();
        pgProfil = new view.PanelProfilKaryawan();
        pgTagihan = new view.petugas.PanelBuatTagihan();

        lblLogo.setText("VOLT");
        lblLogo.setFont(new java.awt.Font("Segoe UI", 1, 32));
        lblLogo.setForeground(new java.awt.Color(245, 158, 11));
        lblPeran.setText("Panel petugas lapangan");
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
        grLap.setText("PEKERJAAN LAPANGAN");
        grLap.setFont(new java.awt.Font("Segoe UI", 1, 11));
        grLap.setForeground(new java.awt.Color(127, 166, 224));
        btnNavPengaduan.setText("Status pengaduan");
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
        grCatat.setText("KHUSUS CATAT METER");
        grCatat.setFont(new java.awt.Font("Segoe UI", 1, 11));
        grCatat.setForeground(new java.awt.Color(127, 166, 224));
        btnNavTagihan.setText("Membuat tagihan");
        btnNavTagihan.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnNavTagihan.setBackground(new java.awt.Color(18, 55, 102));
        btnNavTagihan.setForeground(new java.awt.Color(255, 255, 255));
        btnNavTagihan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavTagihan.setFocusPainted(false);
        btnNavTagihan.setBorderPainted(false);
        grpNav.add(btnNavTagihan);
        btnNavTagihan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavTagihanActionPerformed(evt);
            }
        });
        pnlMenu.setBackground(new java.awt.Color(11, 37, 69));
        pnlMenu.setLayout(null);
        pnlMenu.add(grLap);
        grLap.setBounds(22, 12, 190, 20);
        pnlMenu.add(btnNavPengaduan);
        btnNavPengaduan.setBounds(14, 36, 202, 40);
        pnlMenu.add(grAkun);
        grAkun.setBounds(22, 90, 190, 20);
        pnlMenu.add(btnNavProfil);
        btnNavProfil.setBounds(14, 114, 202, 40);
        pnlMenu.add(grCatat);
        grCatat.setBounds(22, 168, 190, 20);
        pnlMenu.add(btnNavTagihan);
        btnNavTagihan.setBounds(14, 192, 202, 40);
        lblNama.setText("Agus Salim");
        lblNama.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblNama.setForeground(new java.awt.Color(255, 255, 255));
        lblDetail.setText("Samarinda Kota / Keduanya");
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
        lblJudulHal.setText("Status pengaduan");
        lblJudulHal.setFont(new java.awt.Font("Segoe UI", 1, 22));
        lblJudulHal.setForeground(new java.awt.Color(11, 37, 69));
        lblKetHal.setText("Perbarui status penanganan gangguan listrik");
        lblKetHal.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblKetHal.setForeground(new java.awt.Color(100, 116, 139));
        pnlTeksJudul.setBackground(new java.awt.Color(255, 255, 255));
        pnlTeksJudul.setPreferredSize(new java.awt.Dimension(620, 70));
        pnlTeksJudul.setLayout(null);
        pnlTeksJudul.add(lblJudulHal);
        lblJudulHal.setBounds(0, 10, 620, 32);
        pnlTeksJudul.add(lblKetHal);
        lblKetHal.setBounds(0, 44, 620, 22);
        lblSapa.setText("Selamat siang, Agus");
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
        pnlIsi.add(pgPengaduan, "Status pengaduan");
        pnlIsi.add(pgProfil, "Profil saya");
        pnlIsi.add(pgTagihan, "Membuat tagihan");
        pnlKonten.setBackground(new java.awt.Color(234, 241, 251));
        pnlKonten.setLayout(new java.awt.BorderLayout());
        pnlKonten.add(pnlJudul, java.awt.BorderLayout.NORTH);
        pnlKonten.add(pnlIsi, java.awt.BorderLayout.CENTER);
        setBackground(new java.awt.Color(234, 241, 251));
        setLayout(new java.awt.BorderLayout());
        add(pnlSidebar, java.awt.BorderLayout.WEST);
        add(pnlKonten, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNavPengaduanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavPengaduanActionPerformed
        pilih(btnNavPengaduan);
    }//GEN-LAST:event_btnNavPengaduanActionPerformed

    private void btnNavProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavProfilActionPerformed
        pilih(btnNavProfil);
    }//GEN-LAST:event_btnNavProfilActionPerformed

    private void btnNavTagihanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavTagihanActionPerformed
        pilih(btnNavTagihan);
    }//GEN-LAST:event_btnNavTagihanActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        keluar();
    }//GEN-LAST:event_btnKeluarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKeluar;
    private javax.swing.JToggleButton btnNavPengaduan;
    private javax.swing.JToggleButton btnNavProfil;
    private javax.swing.JToggleButton btnNavTagihan;
    private javax.swing.JLabel grAkun;
    private javax.swing.JLabel grCatat;
    private javax.swing.JLabel grLap;
    private javax.swing.ButtonGroup grpNav;
    private javax.swing.JLabel lblDetail;
    private javax.swing.JLabel lblJudulHal;
    private javax.swing.JLabel lblKetHal;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblPeran;
    private javax.swing.JLabel lblSapa;
    private javax.swing.JLabel lblTanggal;
    private view.petugas.PanelUpdatePengaduan pgPengaduan;
    private view.PanelProfilKaryawan pgProfil;
    private view.petugas.PanelBuatTagihan pgTagihan;
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
