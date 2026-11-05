package view.pelanggan;

import view.BasePanel;
import view.Ui;

import util.AppException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import controller.PelangganController;
import model.Pembayaran;
import model.Tagihan;
import util.Fmt;
import util.Konstanta;

/**
 * Flowchart Pelanggan "Melihat Tagihan dan Riwayat Pemakaian kWh" + bayar online (digital).
 * JPanel Form NetBeans: desain visual ada di PanelTagihanSaya.form (buka tab "Design").
 * Kode di dalam blok GEN-BEGIN/GEN-END dibuat otomatis oleh NetBeans, jangan diedit manual.
 */
public class PanelTagihanSaya extends BasePanel {

    private PelangganController ctrl;
    private final DefaultTableModel model;
    private List<Tagihan> data = new ArrayList<>();

    public PanelTagihanSaya(PelangganController ctrl) { this(); this.ctrl = ctrl; }

    public void setController(PelangganController ctrl) { this.ctrl = ctrl; }

    /** Konstruktor tanpa argumen: dipakai GUI Builder agar panel tampil di Design; controller dipasang lewat setController. */
    public PanelTagihanSaya() {
        initComponents();
        model = (DefaultTableModel) tblTagihan.getModel();
        Ui.gayaPesan(lblPesan);
        Ui.siapkanTabel(tblTagihan);
        Ui.pasangPencarian(tblTagihan, txtCari, lblJumlah, "Cari periode, status, jatuh tempo...");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAtas = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        lblPesan = new javax.swing.JLabel();
        pnlCari = new javax.swing.JPanel();
        lblCari = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        lblJumlah = new javax.swing.JLabel();
        scrTabel = new javax.swing.JScrollPane();
        tblTagihan = new javax.swing.JTable();
        pnlTombol = new javax.swing.JPanel();
        btnBayar = new javax.swing.JButton();
        btnMuat = new javax.swing.JButton();

        lblJudul.setText("Tagihan & Riwayat Pemakaian kWh");
        lblJudul.setOpaque(true);
        lblJudul.setBackground(new java.awt.Color(224, 236, 255));
        lblJudul.setForeground(new java.awt.Color(11, 31, 75));
        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 17));
        lblJudul.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 12, 8, 12));
        lblPesan.setText(" ");
        pnlAtas.setLayout(new java.awt.BorderLayout());
        pnlAtas.add(lblJudul, java.awt.BorderLayout.NORTH);
        pnlCari.setOpaque(false);
        pnlCari.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlCari.setLayout(new java.awt.BorderLayout(10, 0));
        lblCari.setText("Cari");
        txtCari.setToolTipText("Cari periode, status, jatuh tempo...");
        lblJumlah.setText(" ");
        pnlCari.add(lblPesan, java.awt.BorderLayout.NORTH);
        pnlCari.add(lblCari, java.awt.BorderLayout.WEST);
        pnlCari.add(txtCari, java.awt.BorderLayout.CENTER);
        pnlCari.add(lblJumlah, java.awt.BorderLayout.EAST);
        pnlAtas.add(pnlCari, java.awt.BorderLayout.SOUTH);
        tblTagihan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Periode", "Meter Awal", "Meter Akhir", "Pemakaian (kWh)", "Total", "Jatuh Tempo", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrTabel.setViewportView(tblTagihan);
        btnBayar.setText("Bayar Tagihan Terpilih (Digital)");
        btnBayar.setBackground(new java.awt.Color(22, 163, 74));
        btnBayar.setForeground(new java.awt.Color(255, 255, 255));
        btnBayar.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });
        btnMuat.setText("Muat Ulang");
        btnMuat.setBackground(new java.awt.Color(29, 78, 216));
        btnMuat.setForeground(new java.awt.Color(255, 255, 255));
        btnMuat.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnMuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuatActionPerformed(evt);
            }
        });
        pnlTombol.setPreferredSize(new java.awt.Dimension(100, 44));
        pnlTombol.setBackground(new java.awt.Color(246, 249, 255));
        pnlTombol.setLayout(null);
        pnlTombol.add(btnBayar);
        btnBayar.setBounds(5, 5, 260, 32);
        pnlTombol.add(btnMuat);
        btnMuat.setBounds(275, 5, 120, 32);
        setPreferredSize(new java.awt.Dimension(980, 560));
        setOpaque(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 235)), javax.swing.BorderFactory.createEmptyBorder(14, 16, 14, 16)));
        setLayout(new java.awt.BorderLayout(10, 10));
        add(pnlAtas, java.awt.BorderLayout.NORTH);
        add(scrTabel, java.awt.BorderLayout.CENTER);
        add(pnlTombol, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
        jalankan(this::bayar);
    }//GEN-LAST:event_btnBayarActionPerformed

    private void btnMuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuatActionPerformed
        muat();
    }//GEN-LAST:event_btnMuatActionPerformed

    private void bayar() {
        int i = Ui.terpilih(tblTagihan);
        if (i < 0) throw new AppException("Pilih tagihan yang ingin dibayar.");
        Tagihan t = data.get(i);
        if (!Konstanta.belumLunas(t.getStatus())) throw new AppException("Tagihan Sudah Lunas");
        if (!Ui.konfirmasi(this, "Bayar tagihan periode " + t.getPeriode() + " secara digital\nsebesar "
                + Fmt.rupiah(t.getTotal()) + "?\n\nPembayaran dilakukan sekali dan harus lunas (tidak bisa dicicil).")) return;
        Pembayaran b = ctrl.bayarOnline(t);
        Ui.tampilkanTeks(this, "Bukti Pembayaran", b.cetak());
        muat();
    }

    @Override public void muat() {
        jalankan(() -> {
            data = ctrl.tagihanSaya();
            model.setRowCount(0);
            for (Tagihan t : data) {
                model.addRow(new Object[]{t.getPeriode(), t.getMeterAwal(), t.getMeterAkhir(), t.getKwh(),
                        Fmt.rupiah(t.getTotal()), t.getJatuhTempo(), t.getStatus()});
            }
            lblPesan.setText(data.isEmpty() ? "Tidak Ada Data Riwayat dan Tagihan" : " ");
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBayar;
    private javax.swing.JButton btnMuat;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblPesan;
    private javax.swing.JPanel pnlCari;
    private javax.swing.JTextField txtCari;
    private javax.swing.JPanel pnlAtas;
    private javax.swing.JPanel pnlTombol;
    private javax.swing.JScrollPane scrTabel;
    private javax.swing.JTable tblTagihan;
    // End of variables declaration//GEN-END:variables
}
