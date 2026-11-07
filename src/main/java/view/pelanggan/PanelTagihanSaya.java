package view.pelanggan;

import view.BasePanel;
import view.DialogRincian;
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
        pnlCari = new javax.swing.JPanel();
        lblPesan = new javax.swing.JLabel();
        lblCari = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        lblJumlah = new javax.swing.JLabel();
        scrTabel = new javax.swing.JScrollPane();
        tblTagihan = new javax.swing.JTable();
        pnlTombol = new javax.swing.JPanel();
        btnBayar = new javax.swing.JButton();
        btnMuat = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(980, 560));
        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createCompoundBorder());
        setLayout(new java.awt.BorderLayout(10, 10));

        pnlAtas.setLayout(new java.awt.BorderLayout());

        lblJudul.setText("Tagihan & Riwayat Pemakaian kWh");
        lblJudul.setOpaque(true);
        lblJudul.setBackground(new java.awt.Color(224, 236, 255));
        lblJudul.setForeground(new java.awt.Color(11, 31, 75));
        lblJudul.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        lblJudul.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 12, 8, 12));
        pnlAtas.add(lblJudul, java.awt.BorderLayout.NORTH);

        pnlCari.setOpaque(false);
        pnlCari.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlCari.setLayout(new java.awt.BorderLayout(10, 0));

        lblPesan.setText(" ");
        pnlCari.add(lblPesan, java.awt.BorderLayout.NORTH);

        lblCari.setText("Cari");
        pnlCari.add(lblCari, java.awt.BorderLayout.WEST);

        txtCari.setToolTipText("Cari periode, status, jatuh tempo...");
        pnlCari.add(txtCari, java.awt.BorderLayout.CENTER);

        lblJumlah.setText(" ");
        pnlCari.add(lblJumlah, java.awt.BorderLayout.EAST);

        pnlAtas.add(pnlCari, java.awt.BorderLayout.SOUTH);

        add(pnlAtas, java.awt.BorderLayout.NORTH);

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

        add(scrTabel, java.awt.BorderLayout.CENTER);

        pnlTombol.setPreferredSize(new java.awt.Dimension(100, 52));
        pnlTombol.setBackground(new java.awt.Color(246, 249, 255));
        pnlTombol.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 10));

        btnBayar.setBackground(new java.awt.Color(22, 163, 74));
        btnBayar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnBayar.setForeground(new java.awt.Color(255, 255, 255));
        btnBayar.setText("Bayar Tagihan Terpilih (Digital)");
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });
        btnBayar.setPreferredSize(new java.awt.Dimension(260, 34));
        pnlTombol.add(btnMuat);
        pnlTombol.add(btnBayar);

        btnMuat.setBackground(new java.awt.Color(29, 78, 216));
        btnMuat.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnMuat.setForeground(new java.awt.Color(255, 255, 255));
        btnMuat.setText("Muat Ulang");
        btnMuat.setPreferredSize(new java.awt.Dimension(130, 34));
        btnMuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuatActionPerformed(evt);
            }
        });

        add(pnlTombol, java.awt.BorderLayout.PAGE_END);
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
        if (!DialogRincian.konfirmasiBayar(this, t)) return;
        Pembayaran b = ctrl.bayarOnline(t);
        DialogRincian.bukti(this, b);
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
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblPesan;
    private javax.swing.JPanel pnlAtas;
    private javax.swing.JPanel pnlCari;
    private javax.swing.JPanel pnlTombol;
    private javax.swing.JScrollPane scrTabel;
    private javax.swing.JTable tblTagihan;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
