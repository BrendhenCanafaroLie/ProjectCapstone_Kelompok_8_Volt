package view.pelanggan;

import view.BasePanel;
import view.Tampilan;
import view.Ui;

import controller.PelangganController;
import model.Pelanggan;
import model.Pengaduan;
import model.Tagihan;
import util.Fmt;
import util.Konstanta;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.List;
import java.util.function.Consumer;

/**
 * Beranda pelanggan: ringkasan tagihan, riwayat pemakaian, dan pintasan ke halaman lain.
 * JPanel Form NetBeans: desain visual (warna, posisi, ukuran) ada di PanelBeranda.form (tab "Design").
 */
public class PanelBeranda extends BasePanel {
    private static final Locale ID = new Locale("id", "ID");
    private static final DateTimeFormatter TGL = DateTimeFormatter.ofPattern("d MMM yyyy", ID);

    private PelangganController ctrl;
    private Consumer<String> navigasi;
    private final DefaultTableModel modelPakai;
    private final DefaultTableModel modelTagihan;

    public PanelBeranda(PelangganController ctrl, Consumer<String> navigasi) { this(); setKontrol(ctrl, navigasi); }

    public void setKontrol(PelangganController ctrl, Consumer<String> navigasi) { this.ctrl = ctrl; this.navigasi = navigasi; }

    /** Konstruktor tanpa argumen: dipakai GUI Builder agar panel tampil di Design. */
    public PanelBeranda() {
        initComponents();
        modelTagihan = (DefaultTableModel) tblTagihan.getModel();
        modelPakai = (DefaultTableModel) tblPakai.getModel();
        Ui.siapkanTabel(tblPakai);
        Ui.siapkanTabel(tblTagihan);
        tblPakai.setRowSelectionAllowed(false);
        tblTagihan.setRowSelectionAllowed(false);
        for (javax.swing.JTable t : new javax.swing.JTable[]{tblPakai, tblTagihan}) {
            t.setRowHeight(32);
            t.setShowVerticalLines(false);
            t.getTableHeader().setPreferredSize(new java.awt.Dimension(100, 34));
            t.setFont(t.getFont().deriveFont(13.5f));
        }
    }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAtas = new javax.swing.JPanel();
        pnlProfil = new javax.swing.JPanel();
        pnlAksen = new javax.swing.JPanel();
        pnlIsiProfil = new javax.swing.JPanel();
        lblSapa = new javax.swing.JLabel();
        pnlBaris = new javax.swing.JPanel();
        pnlInfo = new javax.swing.JPanel();
        pnlInfo1 = new javax.swing.JPanel();
        lblKetMeter = new javax.swing.JLabel();
        lblMeter = new javax.swing.JLabel();
        pnlInfo2 = new javax.swing.JPanel();
        lblKetGolongan = new javax.swing.JLabel();
        lblGolongan = new javax.swing.JLabel();
        pnlInfo3 = new javax.swing.JPanel();
        lblKetJenis = new javax.swing.JLabel();
        lblJenis = new javax.swing.JLabel();
        pnlInfo4 = new javax.swing.JPanel();
        lblKetStatus = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        pnlTombolProfil = new javax.swing.JPanel();
        btnLapor = new javax.swing.JButton();
        btnBayar = new javax.swing.JButton();
        pnlStat = new javax.swing.JPanel();
        kSisa = new view.komponen.KartuStat();
        kTempo = new view.komponen.KartuStat();
        kKwh = new view.komponen.KartuStat();
        kAduan = new view.komponen.KartuStat();
        pnlBawah = new javax.swing.JPanel();
        pnlPakai = new javax.swing.JPanel();
        lblPakai = new javax.swing.JLabel();
        scrPakai = new javax.swing.JScrollPane();
        tblPakai = new javax.swing.JTable();
        pnlTagihan = new javax.swing.JPanel();
        pnlKepala = new javax.swing.JPanel();
        lblTagihan = new javax.swing.JLabel();
        btnSemua = new javax.swing.JButton();
        scrTagihan = new javax.swing.JScrollPane();
        tblTagihan = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1072, 640));
        setOpaque(false);
        setLayout(new java.awt.BorderLayout(0, 16));

        pnlAtas.setOpaque(false);
        pnlAtas.setLayout(new java.awt.BorderLayout(0, 16));

        pnlProfil.setBackground(new java.awt.Color(255, 255, 255));
        pnlProfil.setPreferredSize(new java.awt.Dimension(100, 150));
        pnlProfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 235)));
        pnlProfil.setLayout(new java.awt.BorderLayout(0, 0));

        pnlAksen.setBackground(new java.awt.Color(29, 78, 216));
        pnlAksen.setPreferredSize(new java.awt.Dimension(6, 10));
        pnlProfil.add(pnlAksen, java.awt.BorderLayout.WEST);

        pnlIsiProfil.setOpaque(false);
        pnlIsiProfil.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 24, 14, 24));
        pnlIsiProfil.setLayout(new java.awt.BorderLayout(0, 10));

        lblSapa.setText("Sapaan");
        lblSapa.setForeground(new java.awt.Color(11, 31, 75));
        lblSapa.setFont(new java.awt.Font("SansSerif", 1, 28)); // NOI18N
        pnlIsiProfil.add(lblSapa, java.awt.BorderLayout.NORTH);

        pnlBaris.setOpaque(false);
        pnlBaris.setLayout(new java.awt.BorderLayout(20, 0));

        pnlInfo.setOpaque(false);
        pnlInfo.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        pnlInfo1.setOpaque(false);
        pnlInfo1.setLayout(new java.awt.GridLayout(2, 1, 0, 2));

        lblKetMeter.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lblKetMeter.setForeground(new java.awt.Color(100, 116, 139));
        lblKetMeter.setText("No. Meter");
        pnlInfo1.add(lblKetMeter);

        lblMeter.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblMeter.setForeground(new java.awt.Color(30, 41, 59));
        lblMeter.setText("-");
        pnlInfo1.add(lblMeter);

        pnlInfo.add(pnlInfo1);

        pnlInfo2.setOpaque(false);
        pnlInfo2.setLayout(new java.awt.GridLayout(2, 1, 0, 2));

        lblKetGolongan.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lblKetGolongan.setForeground(new java.awt.Color(100, 116, 139));
        lblKetGolongan.setText("Golongan");
        pnlInfo2.add(lblKetGolongan);

        lblGolongan.setText("-");
        lblGolongan.setForeground(new java.awt.Color(30, 41, 59));
        lblGolongan.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        pnlInfo2.add(lblGolongan);

        pnlInfo.add(pnlInfo2);

        pnlInfo3.setOpaque(false);
        pnlInfo3.setLayout(new java.awt.GridLayout(2, 1, 0, 2));

        lblKetJenis.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lblKetJenis.setForeground(new java.awt.Color(100, 116, 139));
        lblKetJenis.setText("Jenis Pelanggan");
        pnlInfo3.add(lblKetJenis);

        lblJenis.setText("-");
        lblJenis.setForeground(new java.awt.Color(30, 41, 59));
        lblJenis.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        pnlInfo3.add(lblJenis);

        pnlInfo.add(pnlInfo3);

        pnlInfo4.setOpaque(false);
        pnlInfo4.setLayout(new java.awt.GridLayout(2, 1, 0, 2));

        lblKetStatus.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lblKetStatus.setForeground(new java.awt.Color(100, 116, 139));
        lblKetStatus.setText("Status Akun");
        pnlInfo4.add(lblKetStatus);

        lblStatus.setText("-");
        lblStatus.setForeground(new java.awt.Color(30, 41, 59));
        lblStatus.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        pnlInfo4.add(lblStatus);

        pnlInfo.add(pnlInfo4);

        pnlBaris.add(pnlInfo, java.awt.BorderLayout.CENTER);

        pnlTombolProfil.setOpaque(false);
        pnlTombolProfil.setPreferredSize(new java.awt.Dimension(380, 48));
        pnlTombolProfil.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 0, 0, 0));
        pnlTombolProfil.setLayout(new java.awt.GridLayout(1, 2, 12, 0));

        btnLapor.setBackground(new java.awt.Color(71, 85, 105));
        btnLapor.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        btnLapor.setForeground(new java.awt.Color(255, 255, 255));
        btnLapor.setText("Lapor Gangguan");
        btnLapor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaporActionPerformed(evt);
            }
        });
        pnlTombolProfil.add(btnLapor);

        btnBayar.setBackground(new java.awt.Color(78, 108, 192));
        btnBayar.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        btnBayar.setForeground(new java.awt.Color(255, 255, 255));
        btnBayar.setText("Bayar Tagihan");
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });
        pnlTombolProfil.add(btnBayar);

        pnlBaris.add(pnlTombolProfil, java.awt.BorderLayout.EAST);

        pnlIsiProfil.add(pnlBaris, java.awt.BorderLayout.CENTER);

        pnlProfil.add(pnlIsiProfil, java.awt.BorderLayout.CENTER);

        pnlAtas.add(pnlProfil, java.awt.BorderLayout.NORTH);

        pnlStat.setPreferredSize(new java.awt.Dimension(100, 110));
        pnlStat.setOpaque(false);
        pnlStat.setLayout(new java.awt.GridLayout(1, 4, 14, 0));

        kSisa.setAksen(new java.awt.Color(245, 158, 11));
        kSisa.setJudul("Tagihan belum dibayar");
        pnlStat.add(kSisa);

        kTempo.setAksen(new java.awt.Color(220, 38, 38));
        kTempo.setJudul("Jatuh tempo terdekat");
        pnlStat.add(kTempo);

        kKwh.setAksen(new java.awt.Color(13, 148, 136));
        kKwh.setJudul("Pemakaian terakhir");
        pnlStat.add(kKwh);

        kAduan.setJudul("Pengaduan berjalan");
        pnlStat.add(kAduan);

        pnlAtas.add(pnlStat, java.awt.BorderLayout.CENTER);

        add(pnlAtas, java.awt.BorderLayout.NORTH);

        pnlBawah.setOpaque(false);
        pnlBawah.setLayout(new java.awt.GridLayout(1, 2, 16, 0));

        pnlPakai.setBackground(new java.awt.Color(255, 255, 255));
        pnlPakai.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        pnlPakai.setLayout(new java.awt.BorderLayout(0, 8));

        lblPakai.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        lblPakai.setForeground(new java.awt.Color(11, 31, 75));
        lblPakai.setText("    Riwayat Pemakaian Listrik  ");
        pnlPakai.add(lblPakai, java.awt.BorderLayout.NORTH);

        tblPakai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Periode", "Pemakaian (kWh)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrPakai.setViewportView(tblPakai);

        pnlPakai.add(scrPakai, java.awt.BorderLayout.CENTER);

        pnlBawah.add(pnlPakai);

        pnlTagihan.setBackground(new java.awt.Color(255, 255, 255));
        pnlTagihan.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        pnlTagihan.setLayout(new java.awt.BorderLayout(0, 8));

        pnlKepala.setOpaque(false);
        pnlKepala.setLayout(new java.awt.BorderLayout());

        lblTagihan.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        lblTagihan.setForeground(new java.awt.Color(11, 31, 75));
        lblTagihan.setText("     Tagihan Terbaru");
        pnlKepala.add(lblTagihan, java.awt.BorderLayout.WEST);

        btnSemua.setBackground(new java.awt.Color(255, 255, 255));
        btnSemua.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnSemua.setForeground(new java.awt.Color(29, 78, 216));
        btnSemua.setText("Lihat semua");
        btnSemua.setBorderPainted(false);
        btnSemua.setContentAreaFilled(false);
        btnSemua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSemuaActionPerformed(evt);
            }
        });
        pnlKepala.add(btnSemua, java.awt.BorderLayout.EAST);

        pnlTagihan.add(pnlKepala, java.awt.BorderLayout.NORTH);

        tblTagihan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Periode", "Jatuh tempo", "Total", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrTagihan.setViewportView(tblTagihan);

        pnlTagihan.add(scrTagihan, java.awt.BorderLayout.CENTER);

        pnlBawah.add(pnlTagihan);

        add(pnlBawah, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLaporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaporActionPerformed
        navigasi.accept("Lapor gangguan");
    }//GEN-LAST:event_btnLaporActionPerformed

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
        navigasi.accept("Tagihan & riwayat kWh");
    }//GEN-LAST:event_btnBayarActionPerformed

    private void btnSemuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSemuaActionPerformed
        navigasi.accept("Tagihan & riwayat kWh");
    }//GEN-LAST:event_btnSemuaActionPerformed

    private static String angka(BigDecimal v) { return v == null ? "0" : v.stripTrailingZeros().toPlainString(); }

    @Override public void muat() {
        jalankan(() -> {
            Pelanggan p = ctrl.profil();
            lblSapa.setText(Tampilan.sapaan() + ", " + p.getNama());
            lblMeter.setText(p.getNomorMeter());
            lblGolongan.setText(p.getKodeGolongan());
            lblJenis.setText(p.getJenis());
            String status = p.getStatusAkun();
            lblStatus.setText(Ui.teksStatus(status) == null ? String.valueOf(status) : Ui.teksStatus(status));
            lblStatus.setForeground(Ui.warnaStatus(status) == null ? lblMeter.getForeground() : Ui.warnaStatus(status));

            List<Tagihan> semua = new ArrayList<>(ctrl.tagihanSaya());
            semua.sort(Comparator.comparingInt((Tagihan t) -> t.getTahun() * 100 + t.getBulan()).reversed());
            List<Pengaduan> aduan = ctrl.pengaduanSaya();

            List<Tagihan> belum = new ArrayList<>();
            for (Tagihan t : semua) if (Konstanta.belumLunas(t.getStatus())) belum.add(t);
            BigDecimal sisa = BigDecimal.ZERO;
            for (Tagihan t : belum) if (t.getTotal() != null) sisa = sisa.add(t.getTotal());
            if (belum.isEmpty()) kSisa.set(Fmt.rupiah(BigDecimal.ZERO), "Semua tagihan sudah lunas", Ui.OK);
            else kSisa.set(Fmt.rupiah(sisa), belum.size() + " tagihan belum lunas", Ui.PERINGATAN);

            belum.stream().filter(t -> t.getJatuhTempo() != null).min(Comparator.comparing(Tagihan::getJatuhTempo)).ifPresentOrElse(t -> {
                long hari = ChronoUnit.DAYS.between(LocalDate.now(), t.getJatuhTempo());
                String ket = hari > 0 ? hari + " hari lagi" : hari == 0 ? "Jatuh tempo hari ini" : "Terlambat " + (-hari) + " hari";
                kTempo.set(TGL.format(t.getJatuhTempo()), ket + ", periode " + t.getPeriode(), hari < 0 ? Ui.BAHAYA : hari <= 5 ? Ui.PERINGATAN : Ui.REDUP);
            }, () -> kTempo.set("-", "Tidak ada tagihan berjalan", Ui.REDUP));

            if (semua.isEmpty()) kKwh.set("-", "Belum ada data pemakaian", Ui.REDUP);
            else kKwh.set(angka(semua.get(0).getKwh()) + " kWh", "Periode " + semua.get(0).getPeriode(), Ui.REDUP);

            long berjalan = aduan.stream().filter(a -> !Konstanta.ADUAN_SELESAI.equals(a.getStatus())).count();
            if (berjalan == 0) kAduan.set("0", "Tidak ada laporan aktif", Ui.REDUP);
            else kAduan.set(String.valueOf(berjalan), "Sedang ditangani petugas", Ui.INFO);

            modelPakai.setRowCount(0);
            for (Tagihan t : semua.subList(0, Math.min(6, semua.size()))) modelPakai.addRow(new Object[]{t.getPeriode(), angka(t.getKwh())});

            modelTagihan.setRowCount(0);
            for (Tagihan t : semua.subList(0, Math.min(4, semua.size()))) {
                modelTagihan.addRow(new Object[]{t.getPeriode(), t.getJatuhTempo() == null ? "-" : TGL.format(t.getJatuhTempo()),
                        Fmt.rupiah(t.getTotal()), t.getStatus()});
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBayar;
    private javax.swing.JButton btnLapor;
    private javax.swing.JButton btnSemua;
    private view.komponen.KartuStat kAduan;
    private view.komponen.KartuStat kKwh;
    private view.komponen.KartuStat kSisa;
    private view.komponen.KartuStat kTempo;
    private javax.swing.JLabel lblGolongan;
    private javax.swing.JLabel lblJenis;
    private javax.swing.JLabel lblKetGolongan;
    private javax.swing.JLabel lblKetJenis;
    private javax.swing.JLabel lblKetMeter;
    private javax.swing.JLabel lblKetStatus;
    private javax.swing.JLabel lblMeter;
    private javax.swing.JLabel lblPakai;
    private javax.swing.JLabel lblSapa;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTagihan;
    private javax.swing.JPanel pnlAksen;
    private javax.swing.JPanel pnlAtas;
    private javax.swing.JPanel pnlBaris;
    private javax.swing.JPanel pnlBawah;
    private javax.swing.JPanel pnlInfo;
    private javax.swing.JPanel pnlInfo1;
    private javax.swing.JPanel pnlInfo2;
    private javax.swing.JPanel pnlInfo3;
    private javax.swing.JPanel pnlInfo4;
    private javax.swing.JPanel pnlIsiProfil;
    private javax.swing.JPanel pnlKepala;
    private javax.swing.JPanel pnlPakai;
    private javax.swing.JPanel pnlProfil;
    private javax.swing.JPanel pnlStat;
    private javax.swing.JPanel pnlTagihan;
    private javax.swing.JPanel pnlTombolProfil;
    private javax.swing.JScrollPane scrPakai;
    private javax.swing.JScrollPane scrTagihan;
    private javax.swing.JTable tblPakai;
    private javax.swing.JTable tblTagihan;
    // End of variables declaration//GEN-END:variables
}
