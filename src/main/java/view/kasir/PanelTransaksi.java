package view.kasir;

import view.BasePanel;
import view.Ui;

import util.AppException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import controller.KasirController;
import model.Pembayaran;
import model.Tagihan;
import util.Fmt;
import util.Konstanta;

/**
 * Flowchart Kasir "Melakukan Transaksi Pembayaran" (offline): pilih tagihan -> metode -> bayar lunas -> struk.
 * JPanel Form NetBeans: desain visual ada di PanelTransaksi.form (buka tab "Design").
 * Kode di dalam blok GEN-BEGIN/GEN-END dibuat otomatis oleh NetBeans, jangan diedit manual.
 */
public class PanelTransaksi extends BasePanel {

    private KasirController ctrl;
    private final DefaultTableModel model;
    private List<Tagihan> data = new ArrayList<>();

    public PanelTransaksi(KasirController ctrl) { this(); this.ctrl = ctrl; }

    public void setController(KasirController ctrl) { this.ctrl = ctrl; }

    /** Konstruktor tanpa argumen: dipakai GUI Builder agar panel tampil di Design; controller dipasang lewat setController. */
    public PanelTransaksi() {
        initComponents();
        model = (DefaultTableModel) tblTagihan.getModel();
        Ui.gayaPesan(lblPesan);
        Ui.monospaced(txtDetail);
        Ui.siapkanTabel(tblTagihan);
        txtNominal.setEditable(false); // nominal tidak bisa diubah: harus lunas sekali bayar
        tblTagihan.getSelectionModel().addListSelectionListener(e -> {
            if (e.getValueIsAdjusting()) return;
            int i = Ui.terpilih(tblTagihan);
            if (i >= 0 && i < data.size()) {
                txtDetail.setText(data.get(i).cetak());
                txtNominal.setText(Fmt.rupiah(data.get(i).getTotal()));
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAtas = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        pnlCari = new javax.swing.JPanel();
        lblCari = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        lblPesan = new javax.swing.JLabel();
        scrTabel = new javax.swing.JScrollPane();
        tblTagihan = new javax.swing.JTable();
        pnlKanan = new javax.swing.JPanel();
        scrDetail = new javax.swing.JScrollPane();
        txtDetail = new javax.swing.JTextArea();
        pnlBayar = new javax.swing.JPanel();
        lblMetode = new javax.swing.JLabel();
        cmbMetode = new javax.swing.JComboBox<>();
        lblNominal = new javax.swing.JLabel();
        txtNominal = new javax.swing.JTextField();
        btnBayar = new javax.swing.JButton();

        lblJudul.setText("Transaksi Pembayaran - Tagihan Belum Lunas");
        lblJudul.setOpaque(true);
        lblJudul.setBackground(new java.awt.Color(224, 236, 255));
        lblJudul.setForeground(new java.awt.Color(11, 31, 75));
        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 17));
        lblJudul.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 12, 8, 12));
        lblCari.setText("Nama / No. Meter:");
        lblCari.setForeground(new java.awt.Color(30, 41, 59));
        txtCari.setBackground(new java.awt.Color(243, 247, 255));
        txtCari.setForeground(new java.awt.Color(30, 41, 59));
        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });
        btnCari.setText("Cari");
        btnCari.setBackground(new java.awt.Color(29, 78, 216));
        btnCari.setForeground(new java.awt.Color(255, 255, 255));
        btnCari.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });
        pnlCari.setPreferredSize(new java.awt.Dimension(100, 40));
        pnlCari.setBackground(new java.awt.Color(246, 249, 255));
        pnlCari.setLayout(null);
        pnlCari.add(lblCari);
        lblCari.setBounds(5, 9, 130, 22);
        pnlCari.add(txtCari);
        txtCari.setBounds(140, 6, 230, 28);
        pnlCari.add(btnCari);
        btnCari.setBounds(380, 5, 90, 30);
        lblPesan.setText(" ");
        pnlAtas.setLayout(new java.awt.BorderLayout());
        pnlAtas.add(lblJudul, java.awt.BorderLayout.NORTH);
        pnlAtas.add(pnlCari, java.awt.BorderLayout.CENTER);
        pnlAtas.add(lblPesan, java.awt.BorderLayout.SOUTH);
        tblTagihan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Pelanggan", "No. Meter", "Periode", "kWh", "Total", "Jatuh Tempo"
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
        txtDetail.setRows(7);
        txtDetail.setColumns(30);
        txtDetail.setEditable(false);
        txtDetail.setLineWrap(true);
        txtDetail.setWrapStyleWord(true);
        txtDetail.setBackground(new java.awt.Color(243, 247, 255));
        txtDetail.setForeground(new java.awt.Color(30, 41, 59));
        scrDetail.setViewportView(txtDetail);
        lblMetode.setText("Metode Bayar");
        lblMetode.setForeground(new java.awt.Color(30, 41, 59));
        cmbMetode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tunai", "Digital" }));
        cmbMetode.setBackground(new java.awt.Color(243, 247, 255));
        cmbMetode.setForeground(new java.awt.Color(30, 41, 59));
        lblNominal.setText("Total Bayar (Lunas)");
        lblNominal.setForeground(new java.awt.Color(30, 41, 59));
        txtNominal.setEditable(false);
        txtNominal.setBackground(new java.awt.Color(243, 247, 255));
        txtNominal.setForeground(new java.awt.Color(30, 41, 59));
        btnBayar.setText("Proses Pembayaran");
        btnBayar.setBackground(new java.awt.Color(29, 78, 216));
        btnBayar.setForeground(new java.awt.Color(255, 255, 255));
        btnBayar.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });
        pnlBayar.setPreferredSize(new java.awt.Dimension(350, 140));
        pnlBayar.setBackground(new java.awt.Color(246, 249, 255));
        pnlBayar.setLayout(null);
        pnlBayar.add(lblMetode);
        lblMetode.setBounds(10, 12, 120, 22);
        pnlBayar.add(cmbMetode);
        cmbMetode.setBounds(135, 10, 200, 28);
        pnlBayar.add(lblNominal);
        lblNominal.setBounds(10, 50, 125, 22);
        pnlBayar.add(txtNominal);
        txtNominal.setBounds(135, 48, 200, 28);
        pnlBayar.add(btnBayar);
        btnBayar.setBounds(10, 92, 325, 36);
        pnlKanan.setPreferredSize(new java.awt.Dimension(350, 100));
        pnlKanan.setLayout(new java.awt.BorderLayout(6, 6));
        pnlKanan.add(scrDetail, java.awt.BorderLayout.CENTER);
        pnlKanan.add(pnlBayar, java.awt.BorderLayout.SOUTH);
        setPreferredSize(new java.awt.Dimension(980, 560));
        setOpaque(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 235)), javax.swing.BorderFactory.createEmptyBorder(14, 16, 14, 16)));
        setLayout(new java.awt.BorderLayout(10, 10));
        add(pnlAtas, java.awt.BorderLayout.NORTH);
        add(scrTabel, java.awt.BorderLayout.CENTER);
        add(pnlKanan, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        muat();
    }//GEN-LAST:event_txtCariActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        muat();
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
        jalankan(this::bayar);
    }//GEN-LAST:event_btnBayarActionPerformed

    private void bayar() {
        int i = Ui.terpilih(tblTagihan);
        if (i < 0) throw new AppException("Pilih tagihan pada tabel terlebih dahulu.");
        Tagihan t = data.get(i);
        if (!Ui.konfirmasi(this, "Proses pembayaran " + t.getNamaPelanggan() + " periode " + t.getPeriode()
                + "\nsebesar " + Fmt.rupiah(t.getTotal()) + " (dibayar sekali, langsung lunas) ?")) return;
        Pembayaran b = ctrl.bayar(t, (String) cmbMetode.getSelectedItem());
        Ui.tampilkanTeks(this, "Bukti Pembayaran", b.cetak());
        txtNominal.setText("");
        muat();
    }

    @Override public void muat() {
        jalankan(() -> {
            data = ctrl.tagihanBelumLunas(txtCari.getText());
            model.setRowCount(0);
            for (Tagihan t : data) {
                model.addRow(new Object[]{t.getId(), t.getNamaPelanggan(), t.getNomorMeter(), t.getPeriode(),
                        t.getKwh(), Fmt.rupiah(t.getTotal()), t.getJatuhTempo()});
            }
            txtDetail.setText("");
            txtNominal.setText("");
            lblPesan.setText(data.isEmpty() ? "Tidak Ada Data Tagihan" : " ");
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBayar;
    private javax.swing.JButton btnCari;
    private javax.swing.JComboBox<String> cmbMetode;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblMetode;
    private javax.swing.JLabel lblNominal;
    private javax.swing.JLabel lblPesan;
    private javax.swing.JPanel pnlAtas;
    private javax.swing.JPanel pnlBayar;
    private javax.swing.JPanel pnlCari;
    private javax.swing.JPanel pnlKanan;
    private javax.swing.JScrollPane scrDetail;
    private javax.swing.JScrollPane scrTabel;
    private javax.swing.JTable tblTagihan;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextArea txtDetail;
    private javax.swing.JTextField txtNominal;
    // End of variables declaration//GEN-END:variables
}
