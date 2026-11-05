package view.admin;

import view.BasePanel;
import view.Ui;

import controller.AdminController;
import dao.DataTabel;
import dao.StatistikDao;
import util.Fmt;
import util.Konstanta;
import java.math.BigDecimal;

/**
 * Halaman Dashboard admin: empat kartu angka berwarna + rincian statistik (PanelDashboard).
 * JPanel Form NetBeans: desain visual (warna, posisi, ukuran) ada di PanelDashboardAdmin.form (tab "Design").
 */
public class PanelDashboardAdmin extends BasePanel {
    private StatistikDao dao;

    public PanelDashboardAdmin() {
        initComponents();
    }

    public PanelDashboardAdmin(AdminController ctrl) { this(); setController(ctrl); }

    public void setController(AdminController ctrl) {
        this.dao = ctrl.statistik();
        pgRincian.setController(ctrl);
    }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlKartu = new javax.swing.JPanel();
        kPelanggan = new view.komponen.KartuStat();
        kPendapatan = new view.komponen.KartuStat();
        kTagihan = new view.komponen.KartuStat();
        kAduan = new view.komponen.KartuStat();
        pnlRincian = new javax.swing.JPanel();
        pgRincian = new view.admin.PanelDashboard();

        kPelanggan.setJudul("Pelanggan aktif");
        kPelanggan.setAksen(new java.awt.Color(29, 78, 216));
        kPendapatan.setJudul("Pendapatan masuk");
        kPendapatan.setAksen(new java.awt.Color(22, 163, 74));
        kTagihan.setJudul("Tagihan belum lunas");
        kTagihan.setAksen(new java.awt.Color(245, 158, 11));
        kAduan.setJudul("Pengaduan berjalan");
        kAduan.setAksen(new java.awt.Color(220, 38, 38));
        pnlKartu.setPreferredSize(new java.awt.Dimension(100, 100));
        pnlKartu.setOpaque(false);
        pnlKartu.setLayout(new java.awt.GridLayout(1, 4, 16, 0));
        pnlKartu.add(kPelanggan);
        pnlKartu.add(kPendapatan);
        pnlKartu.add(kTagihan);
        pnlKartu.add(kAduan);
        pnlRincian.setOpaque(false);
        pnlRincian.setLayout(new java.awt.BorderLayout());
        pnlRincian.add(pgRincian, java.awt.BorderLayout.CENTER);
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1000, 640));
        setLayout(new java.awt.BorderLayout(0, 18));
        add(pnlKartu, java.awt.BorderLayout.NORTH);
        add(pnlRincian, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private static long jumlah(DataTabel d, String kunci, int kolom) {
        long total = 0;
        for (Object[] r : d.baris()) if (kunci == null || kunci.equalsIgnoreCase(String.valueOf(r[0]))) total += ((Number) r[kolom]).longValue();
        return total;
    }

    @Override public void muat() {
        pgRincian.muat();
        jalankan(() -> {
            DataTabel pel = dao.pelangganPerStatus();
            long aktif = jumlah(pel, "Aktif", 1), menunggu = jumlah(pel, "Menunggu", 1);
            kPelanggan.set(String.valueOf(aktif), menunggu > 0 ? menunggu + " menunggu validasi" : "Semua pendaftar sudah divalidasi",
                    menunggu > 0 ? Ui.PERINGATAN : Ui.REDUP);

            DataTabel dp = dao.totalPendapatan();
            if (dp.kosong()) kPendapatan.set(Fmt.rupiah(BigDecimal.ZERO), "Belum ada pembayaran", Ui.REDUP);
            else kPendapatan.set(Fmt.rupiah(new BigDecimal(String.valueOf(dp.baris().get(0)[1]))), dp.baris().get(0)[0] + " transaksi", Ui.REDUP);

            long belum = 0;
            BigDecimal nilai = BigDecimal.ZERO;
            for (Object[] r : dao.pendapatanPerStatus().baris()) {
                if (Konstanta.belumLunas(String.valueOf(r[0]))) {
                    belum = ((Number) r[1]).longValue();
                    nilai = new BigDecimal(String.valueOf(r[2]));
                }
            }
            kTagihan.set(String.valueOf(belum), belum > 0 ? "Senilai " + Fmt.rupiah(nilai) : "Semua tagihan lunas", belum > 0 ? Ui.PERINGATAN : Ui.OK);

            DataTabel ad = dao.pengaduanPerStatus();
            long berjalan = jumlah(ad, Konstanta.ADUAN_DIAJUKAN, 1) + jumlah(ad, Konstanta.ADUAN_DIPROSES, 1);
            kAduan.set(String.valueOf(berjalan), berjalan > 0 ? "Perlu ditangani petugas" : "Tidak ada laporan aktif", berjalan > 0 ? Ui.INFO : Ui.REDUP);
        });
    }

        // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.komponen.KartuStat kAduan;
    private view.komponen.KartuStat kPelanggan;
    private view.komponen.KartuStat kPendapatan;
    private view.komponen.KartuStat kTagihan;
    private view.admin.PanelDashboard pgRincian;
    private javax.swing.JPanel pnlKartu;
    private javax.swing.JPanel pnlRincian;
    // End of variables declaration//GEN-END:variables
}
