package view.admin;

import view.BasePanel;
import view.Ui;

import controller.AdminController;
import dao.DataTabel;
import dao.StatistikDao;
import javax.swing.JTable;

/**
 * Flowchart "Admin - Dashboard": rincian statistik pelanggan, petugas, tagihan, pengaduan.
 * JPanel Form NetBeans: keempat tab beserta tabelnya sudah terpasang di PanelDashboard.form (buka tab "Design").
 */
public class PanelDashboard extends BasePanel {

    private StatistikDao dao;

    public PanelDashboard() {
        initComponents();
    }

    public void setController(AdminController ctrl) { dao = ctrl.statistik(); }


    private void btnMuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuatActionPerformed
        muat();
    }//GEN-LAST:event_btnMuatActionPerformed

    private static void isiTabel(JTable t, DataTabel d) {
        var m = Ui.modelTabel(d.kolom());
        for (Object[] r : d.baris()) m.addRow(r);
        Ui.siapkanTabel(t, m);
    }

    @Override public void muat() {
        jalankan(() -> {
            isiTabel(tblPelStatus, dao.pelangganPerStatus());
            isiTabel(tblRasio, dao.rasioJenis());
            isiTabel(tblGolongan, dao.pelangganPerGolongan());
            isiTabel(tblSpesialis, dao.petugasPerSpesialis());
            isiTabel(tblPerPetugas, dao.pengaduanPerPetugas());
            isiTabel(tblRataWaktu, dao.rataWaktuSelesai());
            isiTabel(tblPendapatan, dao.totalPendapatan());
            isiTabel(tblStatusTagihan, dao.pendapatanPerStatus());
            isiTabel(tblKwhBulan, dao.kwhBulanan());
            isiTabel(tblMetode, dao.metodeTerbanyak());
            isiTabel(tblAduanStatus, dao.pengaduanPerStatus());
            isiTabel(tblLokasi, dao.lokasiTerbanyak());
            isiTabel(tblTren, dao.trenBulanan());
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAtas = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        btnMuat = new javax.swing.JButton();
        tabSub = new javax.swing.JTabbedPane();
        pnlTabPelanggan = new javax.swing.JPanel();
        pnlPelStatus = new javax.swing.JPanel();
        lblPelStatus = new javax.swing.JLabel();
        scrPelStatus = new javax.swing.JScrollPane();
        tblPelStatus = new javax.swing.JTable();
        pnlRasio = new javax.swing.JPanel();
        lblRasio = new javax.swing.JLabel();
        scrRasio = new javax.swing.JScrollPane();
        tblRasio = new javax.swing.JTable();
        pnlGolongan = new javax.swing.JPanel();
        lblGolongan = new javax.swing.JLabel();
        scrGolongan = new javax.swing.JScrollPane();
        tblGolongan = new javax.swing.JTable();
        pnlTabPetugas = new javax.swing.JPanel();
        pnlSpesialis = new javax.swing.JPanel();
        lblSpesialis = new javax.swing.JLabel();
        scrSpesialis = new javax.swing.JScrollPane();
        tblSpesialis = new javax.swing.JTable();
        pnlPerPetugas = new javax.swing.JPanel();
        lblPerPetugas = new javax.swing.JLabel();
        scrPerPetugas = new javax.swing.JScrollPane();
        tblPerPetugas = new javax.swing.JTable();
        pnlRataWaktu = new javax.swing.JPanel();
        lblRataWaktu = new javax.swing.JLabel();
        scrRataWaktu = new javax.swing.JScrollPane();
        tblRataWaktu = new javax.swing.JTable();
        pnlTabTagihan = new javax.swing.JPanel();
        pnlPendapatan = new javax.swing.JPanel();
        lblPendapatan = new javax.swing.JLabel();
        scrPendapatan = new javax.swing.JScrollPane();
        tblPendapatan = new javax.swing.JTable();
        pnlStatusTagihan = new javax.swing.JPanel();
        lblStatusTagihan = new javax.swing.JLabel();
        scrStatusTagihan = new javax.swing.JScrollPane();
        tblStatusTagihan = new javax.swing.JTable();
        pnlKwhBulan = new javax.swing.JPanel();
        lblKwhBulan = new javax.swing.JLabel();
        scrKwhBulan = new javax.swing.JScrollPane();
        tblKwhBulan = new javax.swing.JTable();
        pnlMetode = new javax.swing.JPanel();
        lblMetode = new javax.swing.JLabel();
        scrMetode = new javax.swing.JScrollPane();
        tblMetode = new javax.swing.JTable();
        pnlTabPengaduan = new javax.swing.JPanel();
        pnlAduanStatus = new javax.swing.JPanel();
        lblAduanStatus = new javax.swing.JLabel();
        scrAduanStatus = new javax.swing.JScrollPane();
        tblAduanStatus = new javax.swing.JTable();
        pnlLokasi = new javax.swing.JPanel();
        lblLokasi = new javax.swing.JLabel();
        scrLokasi = new javax.swing.JScrollPane();
        tblLokasi = new javax.swing.JTable();
        pnlTren = new javax.swing.JPanel();
        lblTren = new javax.swing.JLabel();
        scrTren = new javax.swing.JScrollPane();
        tblTren = new javax.swing.JTable();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1000, 520));
        setLayout(new java.awt.BorderLayout(0, 10));

        pnlAtas.setBackground(new java.awt.Color(255, 255, 255));
        pnlAtas.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 16, 8, 16));
        pnlAtas.setPreferredSize(new java.awt.Dimension(100, 52));
        pnlAtas.setLayout(new java.awt.BorderLayout());

        lblJudul.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblJudul.setForeground(new java.awt.Color(11, 37, 69));
        lblJudul.setText("Rincian Statistik");
        pnlAtas.add(lblJudul, java.awt.BorderLayout.WEST);

        btnMuat.setText("Muat Ulang");
        btnMuat.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnMuat.setBackground(new java.awt.Color(8, 145, 178));
        btnMuat.setForeground(new java.awt.Color(255, 255, 255));
        btnMuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuatActionPerformed(evt);
            }
        });
        pnlAtas.add(btnMuat, java.awt.BorderLayout.EAST);

        add(pnlAtas, java.awt.BorderLayout.NORTH);

        tabSub.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N

        pnlTabPelanggan.setBackground(new java.awt.Color(255, 255, 255));
        pnlTabPelanggan.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        pnlTabPelanggan.setLayout(new java.awt.GridLayout(3, 1, 0, 10));

        pnlPelStatus.setBackground(new java.awt.Color(255, 255, 255));
        pnlPelStatus.setLayout(new java.awt.BorderLayout(0, 6));

        lblPelStatus.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblPelStatus.setForeground(new java.awt.Color(11, 37, 69));
        lblPelStatus.setText("Total Pelanggan (Aktif / Non-Aktif)");
        lblPelStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        pnlPelStatus.add(lblPelStatus, java.awt.BorderLayout.NORTH);

        tblPelStatus.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        scrPelStatus.setViewportView(tblPelStatus);

        pnlPelStatus.add(scrPelStatus, java.awt.BorderLayout.CENTER);

        pnlTabPelanggan.add(pnlPelStatus);

        pnlRasio.setBackground(new java.awt.Color(255, 255, 255));
        pnlRasio.setLayout(new java.awt.BorderLayout(0, 6));

        lblRasio.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblRasio.setForeground(new java.awt.Color(11, 37, 69));
        lblRasio.setText("Rasio Rumah Tangga vs Usaha");
        lblRasio.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        pnlRasio.add(lblRasio, java.awt.BorderLayout.NORTH);

        tblRasio.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        scrRasio.setViewportView(tblRasio);

        pnlRasio.add(scrRasio, java.awt.BorderLayout.CENTER);

        pnlTabPelanggan.add(pnlRasio);

        pnlGolongan.setBackground(new java.awt.Color(255, 255, 255));
        pnlGolongan.setLayout(new java.awt.BorderLayout(0, 6));

        lblGolongan.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblGolongan.setForeground(new java.awt.Color(11, 37, 69));
        lblGolongan.setText("Jumlah Pelanggan per Golongan Daya");
        lblGolongan.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        pnlGolongan.add(lblGolongan, java.awt.BorderLayout.NORTH);

        tblGolongan.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        scrGolongan.setViewportView(tblGolongan);

        pnlGolongan.add(scrGolongan, java.awt.BorderLayout.CENTER);

        pnlTabPelanggan.add(pnlGolongan);

        tabSub.addTab("Pelanggan", pnlTabPelanggan);

        pnlTabPetugas.setBackground(new java.awt.Color(255, 255, 255));
        pnlTabPetugas.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        pnlTabPetugas.setLayout(new java.awt.GridLayout(3, 1, 0, 10));

        pnlSpesialis.setBackground(new java.awt.Color(255, 255, 255));
        pnlSpesialis.setLayout(new java.awt.BorderLayout(0, 6));

        lblSpesialis.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblSpesialis.setForeground(new java.awt.Color(11, 37, 69));
        lblSpesialis.setText("Jumlah Petugas per Spesialis");
        lblSpesialis.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        pnlSpesialis.add(lblSpesialis, java.awt.BorderLayout.NORTH);

        tblSpesialis.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        scrSpesialis.setViewportView(tblSpesialis);

        pnlSpesialis.add(scrSpesialis, java.awt.BorderLayout.CENTER);

        pnlTabPetugas.add(pnlSpesialis);

        pnlPerPetugas.setBackground(new java.awt.Color(255, 255, 255));
        pnlPerPetugas.setLayout(new java.awt.BorderLayout(0, 6));

        lblPerPetugas.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblPerPetugas.setForeground(new java.awt.Color(11, 37, 69));
        lblPerPetugas.setText("Pengaduan yang Ditangani per Petugas");
        lblPerPetugas.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        pnlPerPetugas.add(lblPerPetugas, java.awt.BorderLayout.NORTH);

        tblPerPetugas.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        scrPerPetugas.setViewportView(tblPerPetugas);

        pnlPerPetugas.add(scrPerPetugas, java.awt.BorderLayout.CENTER);

        pnlTabPetugas.add(pnlPerPetugas);

        pnlRataWaktu.setBackground(new java.awt.Color(255, 255, 255));
        pnlRataWaktu.setLayout(new java.awt.BorderLayout(0, 6));

        lblRataWaktu.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblRataWaktu.setForeground(new java.awt.Color(11, 37, 69));
        lblRataWaktu.setText("Rata-rata Waktu Penyelesaian Laporan");
        lblRataWaktu.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        pnlRataWaktu.add(lblRataWaktu, java.awt.BorderLayout.NORTH);

        tblRataWaktu.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        scrRataWaktu.setViewportView(tblRataWaktu);

        pnlRataWaktu.add(scrRataWaktu, java.awt.BorderLayout.CENTER);

        pnlTabPetugas.add(pnlRataWaktu);

        tabSub.addTab("Petugas", pnlTabPetugas);

        pnlTabTagihan.setBackground(new java.awt.Color(255, 255, 255));
        pnlTabTagihan.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        pnlTabTagihan.setLayout(new java.awt.GridLayout(4, 1, 0, 10));

        pnlPendapatan.setBackground(new java.awt.Color(255, 255, 255));
        pnlPendapatan.setLayout(new java.awt.BorderLayout(0, 6));

        lblPendapatan.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblPendapatan.setForeground(new java.awt.Color(11, 37, 69));
        lblPendapatan.setText("Total Pendapatan (pembayaran masuk)");
        lblPendapatan.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        pnlPendapatan.add(lblPendapatan, java.awt.BorderLayout.NORTH);

        tblPendapatan.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        scrPendapatan.setViewportView(tblPendapatan);

        pnlPendapatan.add(scrPendapatan, java.awt.BorderLayout.CENTER);

        pnlTabTagihan.add(pnlPendapatan);

        pnlStatusTagihan.setBackground(new java.awt.Color(255, 255, 255));
        pnlStatusTagihan.setLayout(new java.awt.BorderLayout(0, 6));

        lblStatusTagihan.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblStatusTagihan.setForeground(new java.awt.Color(11, 37, 69));
        lblStatusTagihan.setText("Status Tagihan (Lunas / Terlambat / Belum Lunas)");
        lblStatusTagihan.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        pnlStatusTagihan.add(lblStatusTagihan, java.awt.BorderLayout.NORTH);

        tblStatusTagihan.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        scrStatusTagihan.setViewportView(tblStatusTagihan);

        pnlStatusTagihan.add(scrStatusTagihan, java.awt.BorderLayout.CENTER);

        pnlTabTagihan.add(pnlStatusTagihan);

        pnlKwhBulan.setBackground(new java.awt.Color(255, 255, 255));
        pnlKwhBulan.setLayout(new java.awt.BorderLayout(0, 6));

        lblKwhBulan.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblKwhBulan.setForeground(new java.awt.Color(11, 37, 69));
        lblKwhBulan.setText("Akumulasi Pemakaian kWh Bulanan");
        lblKwhBulan.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        pnlKwhBulan.add(lblKwhBulan, java.awt.BorderLayout.NORTH);

        tblKwhBulan.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        scrKwhBulan.setViewportView(tblKwhBulan);

        pnlKwhBulan.add(scrKwhBulan, java.awt.BorderLayout.CENTER);

        pnlTabTagihan.add(pnlKwhBulan);

        pnlMetode.setBackground(new java.awt.Color(255, 255, 255));
        pnlMetode.setLayout(new java.awt.BorderLayout(0, 6));

        lblMetode.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblMetode.setForeground(new java.awt.Color(11, 37, 69));
        lblMetode.setText("Metode Pembayaran Terbanyak");
        lblMetode.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        pnlMetode.add(lblMetode, java.awt.BorderLayout.NORTH);

        tblMetode.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        scrMetode.setViewportView(tblMetode);

        pnlMetode.add(scrMetode, java.awt.BorderLayout.CENTER);

        pnlTabTagihan.add(pnlMetode);

        tabSub.addTab("Tagihan", pnlTabTagihan);

        pnlTabPengaduan.setBackground(new java.awt.Color(255, 255, 255));
        pnlTabPengaduan.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        pnlTabPengaduan.setLayout(new java.awt.GridLayout(3, 1, 0, 10));

        pnlAduanStatus.setBackground(new java.awt.Color(255, 255, 255));
        pnlAduanStatus.setLayout(new java.awt.BorderLayout(0, 6));

        lblAduanStatus.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblAduanStatus.setForeground(new java.awt.Color(11, 37, 69));
        lblAduanStatus.setText("Jumlah Pengaduan per Status");
        lblAduanStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        pnlAduanStatus.add(lblAduanStatus, java.awt.BorderLayout.NORTH);

        tblAduanStatus.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        scrAduanStatus.setViewportView(tblAduanStatus);

        pnlAduanStatus.add(scrAduanStatus, java.awt.BorderLayout.CENTER);

        pnlTabPengaduan.add(pnlAduanStatus);

        pnlLokasi.setBackground(new java.awt.Color(255, 255, 255));
        pnlLokasi.setLayout(new java.awt.BorderLayout(0, 6));

        lblLokasi.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblLokasi.setForeground(new java.awt.Color(11, 37, 69));
        lblLokasi.setText("Lokasi Paling Sering Gangguan");
        lblLokasi.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        pnlLokasi.add(lblLokasi, java.awt.BorderLayout.NORTH);

        tblLokasi.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        scrLokasi.setViewportView(tblLokasi);

        pnlLokasi.add(scrLokasi, java.awt.BorderLayout.CENTER);

        pnlTabPengaduan.add(pnlLokasi);

        pnlTren.setBackground(new java.awt.Color(255, 255, 255));
        pnlTren.setLayout(new java.awt.BorderLayout(0, 6));

        lblTren.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblTren.setForeground(new java.awt.Color(11, 37, 69));
        lblTren.setText("Tren Pengaduan Bulanan");
        lblTren.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        pnlTren.add(lblTren, java.awt.BorderLayout.NORTH);

        tblTren.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        scrTren.setViewportView(tblTren);

        pnlTren.add(scrTren, java.awt.BorderLayout.CENTER);

        pnlTabPengaduan.add(pnlTren);

        tabSub.addTab("Pengaduan", pnlTabPengaduan);

        add(tabSub, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMuat;
    private javax.swing.JLabel lblAduanStatus;
    private javax.swing.JLabel lblGolongan;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblKwhBulan;
    private javax.swing.JLabel lblLokasi;
    private javax.swing.JLabel lblMetode;
    private javax.swing.JLabel lblPelStatus;
    private javax.swing.JLabel lblPendapatan;
    private javax.swing.JLabel lblPerPetugas;
    private javax.swing.JLabel lblRasio;
    private javax.swing.JLabel lblRataWaktu;
    private javax.swing.JLabel lblSpesialis;
    private javax.swing.JLabel lblStatusTagihan;
    private javax.swing.JLabel lblTren;
    private javax.swing.JPanel pnlAduanStatus;
    private javax.swing.JPanel pnlAtas;
    private javax.swing.JPanel pnlGolongan;
    private javax.swing.JPanel pnlKwhBulan;
    private javax.swing.JPanel pnlLokasi;
    private javax.swing.JPanel pnlMetode;
    private javax.swing.JPanel pnlPelStatus;
    private javax.swing.JPanel pnlPendapatan;
    private javax.swing.JPanel pnlPerPetugas;
    private javax.swing.JPanel pnlRasio;
    private javax.swing.JPanel pnlRataWaktu;
    private javax.swing.JPanel pnlSpesialis;
    private javax.swing.JPanel pnlStatusTagihan;
    private javax.swing.JPanel pnlTabPelanggan;
    private javax.swing.JPanel pnlTabPengaduan;
    private javax.swing.JPanel pnlTabPetugas;
    private javax.swing.JPanel pnlTabTagihan;
    private javax.swing.JPanel pnlTren;
    private javax.swing.JScrollPane scrAduanStatus;
    private javax.swing.JScrollPane scrGolongan;
    private javax.swing.JScrollPane scrKwhBulan;
    private javax.swing.JScrollPane scrLokasi;
    private javax.swing.JScrollPane scrMetode;
    private javax.swing.JScrollPane scrPelStatus;
    private javax.swing.JScrollPane scrPendapatan;
    private javax.swing.JScrollPane scrPerPetugas;
    private javax.swing.JScrollPane scrRasio;
    private javax.swing.JScrollPane scrRataWaktu;
    private javax.swing.JScrollPane scrSpesialis;
    private javax.swing.JScrollPane scrStatusTagihan;
    private javax.swing.JScrollPane scrTren;
    private javax.swing.JTabbedPane tabSub;
    private javax.swing.JTable tblAduanStatus;
    private javax.swing.JTable tblGolongan;
    private javax.swing.JTable tblKwhBulan;
    private javax.swing.JTable tblLokasi;
    private javax.swing.JTable tblMetode;
    private javax.swing.JTable tblPelStatus;
    private javax.swing.JTable tblPendapatan;
    private javax.swing.JTable tblPerPetugas;
    private javax.swing.JTable tblRasio;
    private javax.swing.JTable tblRataWaktu;
    private javax.swing.JTable tblSpesialis;
    private javax.swing.JTable tblStatusTagihan;
    private javax.swing.JTable tblTren;
    // End of variables declaration//GEN-END:variables
}
