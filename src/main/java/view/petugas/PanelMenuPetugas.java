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
        lblPeran = new javax.swing.JLabel();
        pnlGarisMerek = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
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
        pgProfil = new view.PanelProfilKaryawan();
        pgTagihan = new view.petugas.PanelBuatTagihan();
        pgPengaduan = new view.petugas.PanelUpdatePengaduan();

        setBackground(new java.awt.Color(234, 241, 251));
        setLayout(new java.awt.BorderLayout());

        pnlSidebar.setBackground(new java.awt.Color(11, 37, 69));
        pnlSidebar.setPreferredSize(new java.awt.Dimension(230, 0));
        pnlSidebar.setLayout(new java.awt.BorderLayout());

        pnlMerek.setBackground(new java.awt.Color(0, 14, 48));
        pnlMerek.setPreferredSize(new java.awt.Dimension(230, 92));
        pnlMerek.setLayout(null);

        lblPeran.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPeran.setForeground(new java.awt.Color(191, 219, 254));
        lblPeran.setText("PANEL PETUGAS LAPANGAN");
        pnlMerek.add(lblPeran);
        lblPeran.setBounds(24, 60, 190, 20);

        pnlGarisMerek.setBackground(new java.awt.Color(245, 158, 11));
        pnlGarisMerek.setLayout(null);
        pnlMerek.add(pnlGarisMerek);
        pnlGarisMerek.setBounds(24, 84, 46, 3);

        lblLogo.setFont(new java.awt.Font("Lucida Console", 1, 48)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(245, 158, 11));
        lblLogo.setText("VOLT");
        pnlMerek.add(lblLogo);
        lblLogo.setBounds(20, 12, 180, 50);

        pnlSidebar.add(pnlMerek, java.awt.BorderLayout.NORTH);

        pnlMenu.setBackground(new java.awt.Color(0, 19, 66));
        pnlMenu.setLayout(null);

        grLap.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        grLap.setForeground(new java.awt.Color(127, 166, 224));
        grLap.setText("PEKERJAAN LAPANGAN");
        pnlMenu.add(grLap);
        grLap.setBounds(20, 20, 190, 20);

        btnNavPengaduan.setBackground(new java.awt.Color(0, 46, 104));
        grpNav.add(btnNavPengaduan);
        btnNavPengaduan.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnNavPengaduan.setForeground(new java.awt.Color(255, 255, 255));
        btnNavPengaduan.setText("Status Pengaduan");
        btnNavPengaduan.setBorderPainted(false);
        btnNavPengaduan.setFocusPainted(false);
        btnNavPengaduan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavPengaduan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavPengaduanActionPerformed(evt);
            }
        });
        pnlMenu.add(btnNavPengaduan);
        btnNavPengaduan.setBounds(20, 40, 190, 40);

        grAkun.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        grAkun.setForeground(new java.awt.Color(127, 166, 224));
        grAkun.setText("AKUN");
        pnlMenu.add(grAkun);
        grAkun.setBounds(20, 180, 190, 20);

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
        btnNavProfil.setBounds(20, 200, 190, 40);

        grCatat.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        grCatat.setForeground(new java.awt.Color(127, 166, 224));
        grCatat.setText("KHUSUS CATAT METER");
        pnlMenu.add(grCatat);
        grCatat.setBounds(20, 100, 190, 20);

        btnNavTagihan.setBackground(new java.awt.Color(0, 46, 104));
        grpNav.add(btnNavTagihan);
        btnNavTagihan.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnNavTagihan.setForeground(new java.awt.Color(255, 255, 255));
        btnNavTagihan.setText("Membuat Tagihan");
        btnNavTagihan.setBorderPainted(false);
        btnNavTagihan.setFocusPainted(false);
        btnNavTagihan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavTagihan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavTagihanActionPerformed(evt);
            }
        });
        pnlMenu.add(btnNavTagihan);
        btnNavTagihan.setBounds(20, 120, 190, 40);

        pnlSidebar.add(pnlMenu, java.awt.BorderLayout.CENTER);

        pnlAkun.setBackground(new java.awt.Color(0, 14, 48));
        pnlAkun.setPreferredSize(new java.awt.Dimension(230, 118));
        pnlAkun.setLayout(null);

        lblNama.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblNama.setForeground(new java.awt.Color(255, 255, 255));
        lblNama.setText("Agus Salim");
        pnlAkun.add(lblNama);
        lblNama.setBounds(18, 12, 196, 22);

        lblDetail.setForeground(new java.awt.Color(191, 219, 254));
        lblDetail.setText("Samarinda Kota / Keduanya");
        pnlAkun.add(lblDetail);
        lblDetail.setBounds(18, 34, 196, 20);

        btnKeluar.setBackground(new java.awt.Color(220, 38, 38));
        btnKeluar.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
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

        lblJudulHal.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblJudulHal.setForeground(new java.awt.Color(245, 158, 11));
        lblJudulHal.setText("Status pengaduan");
        pnlTeksJudul.add(lblJudulHal);
        lblJudulHal.setBounds(0, 10, 620, 32);

        lblKetHal.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblKetHal.setForeground(new java.awt.Color(191, 219, 254));
        lblKetHal.setText("Perbarui Status Penanganan Gangguan Listrik");
        pnlTeksJudul.add(lblKetHal);
        lblKetHal.setBounds(0, 44, 620, 22);

        pnlJudul.add(pnlTeksJudul, java.awt.BorderLayout.WEST);

        pnlTeksSapa.setBackground(new java.awt.Color(0, 14, 48));
        pnlTeksSapa.setPreferredSize(new java.awt.Dimension(320, 70));
        pnlTeksSapa.setLayout(null);

        lblSapa.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblSapa.setForeground(new java.awt.Color(255, 255, 255));
        lblSapa.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSapa.setText("Selamat siang, Agus");
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
        pnlIsi.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 24, 24, 24));
        pnlIsi.setLayout(new java.awt.CardLayout());
        pnlIsi.add(pgProfil, "Profil saya");
        pnlIsi.add(pgTagihan, "Membuat tagihan");
        pnlIsi.add(pgPengaduan, "Status pengaduan");

        pnlKonten.add(pnlIsi, java.awt.BorderLayout.CENTER);

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
