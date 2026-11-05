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
    }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAtas = new javax.swing.JPanel();
        pnlProfil = new javax.swing.JPanel();
        pnlAksen = new javax.swing.JPanel();
        lblSapa = new javax.swing.JLabel();
        lblKetMeter = new javax.swing.JLabel();
        lblMeter = new javax.swing.JLabel();
        lblKetGolongan = new javax.swing.JLabel();
        lblGolongan = new javax.swing.JLabel();
        lblKetJenis = new javax.swing.JLabel();
        lblJenis = new javax.swing.JLabel();
        lblKetStatus = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
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

        pnlAksen.setBackground(new java.awt.Color(29, 78, 216));
        pnlAksen.setLayout(null);
        lblSapa.setText("Sapaan");
        lblSapa.setForeground(new java.awt.Color(11, 31, 75));
        lblSapa.setFont(new java.awt.Font("Segoe UI", 1, 20));
        lblKetMeter.setText("No. meter");
        lblKetMeter.setForeground(new java.awt.Color(100, 116, 139));
        lblKetMeter.setFont(new java.awt.Font("Segoe UI", 0, 11));
        lblMeter.setText("-");
        lblMeter.setForeground(new java.awt.Color(30, 41, 59));
        lblMeter.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblKetGolongan.setText("Golongan");
        lblKetGolongan.setForeground(new java.awt.Color(100, 116, 139));
        lblKetGolongan.setFont(new java.awt.Font("Segoe UI", 0, 11));
        lblGolongan.setText("-");
        lblGolongan.setForeground(new java.awt.Color(30, 41, 59));
        lblGolongan.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblKetJenis.setText("Jenis pelanggan");
        lblKetJenis.setForeground(new java.awt.Color(100, 116, 139));
        lblKetJenis.setFont(new java.awt.Font("Segoe UI", 0, 11));
        lblJenis.setText("-");
        lblJenis.setForeground(new java.awt.Color(30, 41, 59));
        lblJenis.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblKetStatus.setText("Status akun");
        lblKetStatus.setForeground(new java.awt.Color(100, 116, 139));
        lblKetStatus.setFont(new java.awt.Font("Segoe UI", 0, 11));
        lblStatus.setText("-");
        lblStatus.setForeground(new java.awt.Color(30, 41, 59));
        lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnLapor.setText("Lapor gangguan");
        btnLapor.setBackground(new java.awt.Color(71, 85, 105));
        btnLapor.setForeground(new java.awt.Color(255, 255, 255));
        btnLapor.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnLapor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaporActionPerformed(evt);
            }
        });
        btnBayar.setText("Bayar tagihan");
        btnBayar.setBackground(new java.awt.Color(29, 78, 216));
        btnBayar.setForeground(new java.awt.Color(255, 255, 255));
        btnBayar.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });
        pnlProfil.setBackground(new java.awt.Color(255, 255, 255));
        pnlProfil.setPreferredSize(new java.awt.Dimension(100, 120));
        pnlProfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 235)));
        pnlProfil.setLayout(null);
        pnlProfil.add(pnlAksen);
        pnlAksen.setBounds(0, 0, 6, 118);
        pnlProfil.add(lblSapa);
        lblSapa.setBounds(26, 12, 640, 30);
        pnlProfil.add(lblKetMeter);
        lblKetMeter.setBounds(26, 58, 160, 16);
        pnlProfil.add(lblMeter);
        lblMeter.setBounds(26, 76, 160, 24);
        pnlProfil.add(lblKetGolongan);
        lblKetGolongan.setBounds(196, 58, 160, 16);
        pnlProfil.add(lblGolongan);
        lblGolongan.setBounds(196, 76, 160, 24);
        pnlProfil.add(lblKetJenis);
        lblKetJenis.setBounds(366, 58, 160, 16);
        pnlProfil.add(lblJenis);
        lblJenis.setBounds(366, 76, 160, 24);
        pnlProfil.add(lblKetStatus);
        lblKetStatus.setBounds(536, 58, 160, 16);
        pnlProfil.add(lblStatus);
        lblStatus.setBounds(536, 76, 160, 24);
        pnlProfil.add(btnLapor);
        btnLapor.setBounds(730, 66, 150, 36);
        pnlProfil.add(btnBayar);
        btnBayar.setBounds(890, 66, 150, 36);
        kSisa.setJudul("Tagihan belum dibayar");
        kSisa.setAksen(new java.awt.Color(245, 158, 11));
        kTempo.setJudul("Jatuh tempo terdekat");
        kTempo.setAksen(new java.awt.Color(220, 38, 38));
        kKwh.setJudul("Pemakaian terakhir");
        kKwh.setAksen(new java.awt.Color(13, 148, 136));
        kAduan.setJudul("Pengaduan berjalan");
        kAduan.setAksen(new java.awt.Color(29, 78, 216));
        pnlStat.setPreferredSize(new java.awt.Dimension(100, 100));
        pnlStat.setOpaque(false);
        pnlStat.setLayout(new java.awt.GridLayout(1, 4, 14, 0));
        pnlStat.add(kSisa);
        pnlStat.add(kTempo);
        pnlStat.add(kKwh);
        pnlStat.add(kAduan);
        pnlAtas.setOpaque(false);
        pnlAtas.setLayout(new java.awt.BorderLayout(0, 16));
        pnlAtas.add(pnlProfil, java.awt.BorderLayout.NORTH);
        pnlAtas.add(pnlStat, java.awt.BorderLayout.CENTER);
        lblPakai.setText("Riwayat pemakaian listrik");
        lblPakai.setForeground(new java.awt.Color(11, 31, 75));
        lblPakai.setFont(new java.awt.Font("Segoe UI", 1, 15));
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
        pnlPakai.setBackground(new java.awt.Color(255, 255, 255));
        pnlPakai.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 235)), javax.swing.BorderFactory.createEmptyBorder(14, 16, 14, 16)));
        pnlPakai.setLayout(new java.awt.BorderLayout(0, 8));
        pnlPakai.add(lblPakai, java.awt.BorderLayout.NORTH);
        pnlPakai.add(scrPakai, java.awt.BorderLayout.CENTER);
        lblTagihan.setText("Tagihan terbaru");
        lblTagihan.setForeground(new java.awt.Color(11, 31, 75));
        lblTagihan.setFont(new java.awt.Font("Segoe UI", 1, 15));
        btnSemua.setText("Lihat semua");
        btnSemua.setBackground(new java.awt.Color(255, 255, 255));
        btnSemua.setForeground(new java.awt.Color(29, 78, 216));
        btnSemua.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnSemua.setBorderPainted(false);
        btnSemua.setContentAreaFilled(false);
        btnSemua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSemuaActionPerformed(evt);
            }
        });
        pnlKepala.setOpaque(false);
        pnlKepala.setLayout(new java.awt.BorderLayout());
        pnlKepala.add(lblTagihan, java.awt.BorderLayout.WEST);
        pnlKepala.add(btnSemua, java.awt.BorderLayout.EAST);
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
        pnlTagihan.setBackground(new java.awt.Color(255, 255, 255));
        pnlTagihan.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 235)), javax.swing.BorderFactory.createEmptyBorder(14, 16, 14, 16)));
        pnlTagihan.setLayout(new java.awt.BorderLayout(0, 8));
        pnlTagihan.add(pnlKepala, java.awt.BorderLayout.NORTH);
        pnlTagihan.add(scrTagihan, java.awt.BorderLayout.CENTER);
        pnlBawah.setOpaque(false);
        pnlBawah.setLayout(new java.awt.GridLayout(1, 2, 16, 0));
        pnlBawah.add(pnlPakai);
        pnlBawah.add(pnlTagihan);
        setPreferredSize(new java.awt.Dimension(1072, 640));
        setOpaque(false);
        setLayout(new java.awt.BorderLayout(0, 16));
        add(pnlAtas, java.awt.BorderLayout.NORTH);
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
    private javax.swing.JPanel pnlBawah;
    private javax.swing.JPanel pnlKepala;
    private javax.swing.JPanel pnlPakai;
    private javax.swing.JPanel pnlProfil;
    private javax.swing.JPanel pnlStat;
    private javax.swing.JPanel pnlTagihan;
    private javax.swing.JScrollPane scrPakai;
    private javax.swing.JScrollPane scrTagihan;
    private javax.swing.JTable tblPakai;
    private javax.swing.JTable tblTagihan;
    // End of variables declaration//GEN-END:variables
}
