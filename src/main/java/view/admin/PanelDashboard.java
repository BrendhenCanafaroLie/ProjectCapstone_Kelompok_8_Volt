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

        lblJudul.setText("Rincian Statistik");
        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblJudul.setForeground(new java.awt.Color(11, 37, 69));
        btnMuat.setText("Muat Ulang");
        btnMuat.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnMuat.setBackground(new java.awt.Color(8, 145, 178));
        btnMuat.setForeground(new java.awt.Color(255, 255, 255));
        btnMuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuatActionPerformed(evt);
            }
        });
        pnlAtas.setBackground(new java.awt.Color(255, 255, 255));
        pnlAtas.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 16, 8, 16));
        pnlAtas.setPreferredSize(new java.awt.Dimension(100, 52));
        pnlAtas.setLayout(new java.awt.BorderLayout());
        pnlAtas.add(lblJudul, java.awt.BorderLayout.WEST);
        pnlAtas.add(btnMuat, java.awt.BorderLayout.EAST);
        lblPelStatus.setText("Total Pelanggan (Aktif / Non-Aktif)");
        lblPelStatus.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblPelStatus.setForeground(new java.awt.Color(29, 78, 216));
        lblPelStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        tblPelStatus.setFont(new java.awt.Font("Segoe UI", 0, 13));
        scrPelStatus.setViewportView(tblPelStatus);
        pnlPelStatus.setBackground(new java.awt.Color(255, 255, 255));
        pnlPelStatus.setLayout(new java.awt.BorderLayout(0, 6));
        pnlPelStatus.add(lblPelStatus, java.awt.BorderLayout.NORTH);
        pnlPelStatus.add(scrPelStatus, java.awt.BorderLayout.CENTER);
        lblRasio.setText("Rasio Rumah Tangga vs Usaha");
        lblRasio.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblRasio.setForeground(new java.awt.Color(29, 78, 216));
        lblRasio.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        tblRasio.setFont(new java.awt.Font("Segoe UI", 0, 13));
        scrRasio.setViewportView(tblRasio);
        pnlRasio.setBackground(new java.awt.Color(255, 255, 255));
        pnlRasio.setLayout(new java.awt.BorderLayout(0, 6));
        pnlRasio.add(lblRasio, java.awt.BorderLayout.NORTH);
        pnlRasio.add(scrRasio, java.awt.BorderLayout.CENTER);
        lblGolongan.setText("Jumlah Pelanggan per Golongan Daya");
        lblGolongan.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblGolongan.setForeground(new java.awt.Color(29, 78, 216));
        lblGolongan.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        tblGolongan.setFont(new java.awt.Font("Segoe UI", 0, 13));
        scrGolongan.setViewportView(tblGolongan);
        pnlGolongan.setBackground(new java.awt.Color(255, 255, 255));
        pnlGolongan.setLayout(new java.awt.BorderLayout(0, 6));
        pnlGolongan.add(lblGolongan, java.awt.BorderLayout.NORTH);
        pnlGolongan.add(scrGolongan, java.awt.BorderLayout.CENTER);
        pnlTabPelanggan.setBackground(new java.awt.Color(255, 255, 255));
        pnlTabPelanggan.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        pnlTabPelanggan.setLayout(new java.awt.GridLayout(3, 1, 0, 10));
        pnlTabPelanggan.add(pnlPelStatus);
        pnlTabPelanggan.add(pnlRasio);
        pnlTabPelanggan.add(pnlGolongan);
        lblSpesialis.setText("Jumlah Petugas per Spesialis");
        lblSpesialis.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblSpesialis.setForeground(new java.awt.Color(29, 78, 216));
        lblSpesialis.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        tblSpesialis.setFont(new java.awt.Font("Segoe UI", 0, 13));
        scrSpesialis.setViewportView(tblSpesialis);
        pnlSpesialis.setBackground(new java.awt.Color(255, 255, 255));
        pnlSpesialis.setLayout(new java.awt.BorderLayout(0, 6));
        pnlSpesialis.add(lblSpesialis, java.awt.BorderLayout.NORTH);
        pnlSpesialis.add(scrSpesialis, java.awt.BorderLayout.CENTER);
        lblPerPetugas.setText("Pengaduan yang Ditangani per Petugas");
        lblPerPetugas.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblPerPetugas.setForeground(new java.awt.Color(29, 78, 216));
        lblPerPetugas.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        tblPerPetugas.setFont(new java.awt.Font("Segoe UI", 0, 13));
        scrPerPetugas.setViewportView(tblPerPetugas);
        pnlPerPetugas.setBackground(new java.awt.Color(255, 255, 255));
        pnlPerPetugas.setLayout(new java.awt.BorderLayout(0, 6));
        pnlPerPetugas.add(lblPerPetugas, java.awt.BorderLayout.NORTH);
        pnlPerPetugas.add(scrPerPetugas, java.awt.BorderLayout.CENTER);
        lblRataWaktu.setText("Rata-rata Waktu Penyelesaian Laporan");
        lblRataWaktu.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblRataWaktu.setForeground(new java.awt.Color(29, 78, 216));
        lblRataWaktu.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        tblRataWaktu.setFont(new java.awt.Font("Segoe UI", 0, 13));
        scrRataWaktu.setViewportView(tblRataWaktu);
        pnlRataWaktu.setBackground(new java.awt.Color(255, 255, 255));
        pnlRataWaktu.setLayout(new java.awt.BorderLayout(0, 6));
        pnlRataWaktu.add(lblRataWaktu, java.awt.BorderLayout.NORTH);
        pnlRataWaktu.add(scrRataWaktu, java.awt.BorderLayout.CENTER);
        pnlTabPetugas.setBackground(new java.awt.Color(255, 255, 255));
        pnlTabPetugas.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        pnlTabPetugas.setLayout(new java.awt.GridLayout(3, 1, 0, 10));
        pnlTabPetugas.add(pnlSpesialis);
        pnlTabPetugas.add(pnlPerPetugas);
        pnlTabPetugas.add(pnlRataWaktu);
        lblPendapatan.setText("Total Pendapatan (pembayaran masuk)");
        lblPendapatan.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblPendapatan.setForeground(new java.awt.Color(29, 78, 216));
        lblPendapatan.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        tblPendapatan.setFont(new java.awt.Font("Segoe UI", 0, 13));
        scrPendapatan.setViewportView(tblPendapatan);
        pnlPendapatan.setBackground(new java.awt.Color(255, 255, 255));
        pnlPendapatan.setLayout(new java.awt.BorderLayout(0, 6));
        pnlPendapatan.add(lblPendapatan, java.awt.BorderLayout.NORTH);
        pnlPendapatan.add(scrPendapatan, java.awt.BorderLayout.CENTER);
        lblStatusTagihan.setText("Status Tagihan (Lunas / Terlambat / Belum Lunas)");
        lblStatusTagihan.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblStatusTagihan.setForeground(new java.awt.Color(29, 78, 216));
        lblStatusTagihan.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        tblStatusTagihan.setFont(new java.awt.Font("Segoe UI", 0, 13));
        scrStatusTagihan.setViewportView(tblStatusTagihan);
        pnlStatusTagihan.setBackground(new java.awt.Color(255, 255, 255));
        pnlStatusTagihan.setLayout(new java.awt.BorderLayout(0, 6));
        pnlStatusTagihan.add(lblStatusTagihan, java.awt.BorderLayout.NORTH);
        pnlStatusTagihan.add(scrStatusTagihan, java.awt.BorderLayout.CENTER);
        lblKwhBulan.setText("Akumulasi Pemakaian kWh Bulanan");
        lblKwhBulan.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblKwhBulan.setForeground(new java.awt.Color(29, 78, 216));
        lblKwhBulan.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        tblKwhBulan.setFont(new java.awt.Font("Segoe UI", 0, 13));
        scrKwhBulan.setViewportView(tblKwhBulan);
        pnlKwhBulan.setBackground(new java.awt.Color(255, 255, 255));
        pnlKwhBulan.setLayout(new java.awt.BorderLayout(0, 6));
        pnlKwhBulan.add(lblKwhBulan, java.awt.BorderLayout.NORTH);
        pnlKwhBulan.add(scrKwhBulan, java.awt.BorderLayout.CENTER);
        lblMetode.setText("Metode Pembayaran Terbanyak");
        lblMetode.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblMetode.setForeground(new java.awt.Color(29, 78, 216));
        lblMetode.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        tblMetode.setFont(new java.awt.Font("Segoe UI", 0, 13));
        scrMetode.setViewportView(tblMetode);
        pnlMetode.setBackground(new java.awt.Color(255, 255, 255));
        pnlMetode.setLayout(new java.awt.BorderLayout(0, 6));
        pnlMetode.add(lblMetode, java.awt.BorderLayout.NORTH);
        pnlMetode.add(scrMetode, java.awt.BorderLayout.CENTER);
        pnlTabTagihan.setBackground(new java.awt.Color(255, 255, 255));
        pnlTabTagihan.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        pnlTabTagihan.setLayout(new java.awt.GridLayout(4, 1, 0, 10));
        pnlTabTagihan.add(pnlPendapatan);
        pnlTabTagihan.add(pnlStatusTagihan);
        pnlTabTagihan.add(pnlKwhBulan);
        pnlTabTagihan.add(pnlMetode);
        lblAduanStatus.setText("Jumlah Pengaduan per Status");
        lblAduanStatus.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblAduanStatus.setForeground(new java.awt.Color(29, 78, 216));
        lblAduanStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        tblAduanStatus.setFont(new java.awt.Font("Segoe UI", 0, 13));
        scrAduanStatus.setViewportView(tblAduanStatus);
        pnlAduanStatus.setBackground(new java.awt.Color(255, 255, 255));
        pnlAduanStatus.setLayout(new java.awt.BorderLayout(0, 6));
        pnlAduanStatus.add(lblAduanStatus, java.awt.BorderLayout.NORTH);
        pnlAduanStatus.add(scrAduanStatus, java.awt.BorderLayout.CENTER);
        lblLokasi.setText("Lokasi Paling Sering Gangguan");
        lblLokasi.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblLokasi.setForeground(new java.awt.Color(29, 78, 216));
        lblLokasi.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        tblLokasi.setFont(new java.awt.Font("Segoe UI", 0, 13));
        scrLokasi.setViewportView(tblLokasi);
        pnlLokasi.setBackground(new java.awt.Color(255, 255, 255));
        pnlLokasi.setLayout(new java.awt.BorderLayout(0, 6));
        pnlLokasi.add(lblLokasi, java.awt.BorderLayout.NORTH);
        pnlLokasi.add(scrLokasi, java.awt.BorderLayout.CENTER);
        lblTren.setText("Tren Pengaduan Bulanan");
        lblTren.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblTren.setForeground(new java.awt.Color(29, 78, 216));
        lblTren.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        tblTren.setFont(new java.awt.Font("Segoe UI", 0, 13));
        scrTren.setViewportView(tblTren);
        pnlTren.setBackground(new java.awt.Color(255, 255, 255));
        pnlTren.setLayout(new java.awt.BorderLayout(0, 6));
        pnlTren.add(lblTren, java.awt.BorderLayout.NORTH);
        pnlTren.add(scrTren, java.awt.BorderLayout.CENTER);
        pnlTabPengaduan.setBackground(new java.awt.Color(255, 255, 255));
        pnlTabPengaduan.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        pnlTabPengaduan.setLayout(new java.awt.GridLayout(3, 1, 0, 10));
        pnlTabPengaduan.add(pnlAduanStatus);
        pnlTabPengaduan.add(pnlLokasi);
        pnlTabPengaduan.add(pnlTren);
        tabSub.setFont(new java.awt.Font("Segoe UI", 1, 13));
        tabSub.addTab("Pelanggan", pnlTabPelanggan);
        tabSub.addTab("Petugas", pnlTabPetugas);
        tabSub.addTab("Tagihan", pnlTabTagihan);
        tabSub.addTab("Pengaduan", pnlTabPengaduan);
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1000, 520));
        setLayout(new java.awt.BorderLayout(0, 10));
        add(pnlAtas, java.awt.BorderLayout.NORTH);
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
