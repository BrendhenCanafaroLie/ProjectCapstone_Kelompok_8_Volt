package view.kasir;

import view.BasePanel;
import view.DialogRincian;
import view.Ui;

import util.AppException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import controller.KasirController;
import model.Pembayaran;
import util.Fmt;

/**
 * Flowchart Kasir "Melihat Riwayat Transaksi".
 * JPanel Form NetBeans: desain visual ada di PanelRiwayatKasir.form (buka tab "Design").
 * Kode di dalam blok GEN-BEGIN/GEN-END dibuat otomatis oleh NetBeans, jangan diedit manual.
 */
public class PanelRiwayatKasir extends BasePanel {

    private KasirController ctrl;
    private final DefaultTableModel model;
    private List<Pembayaran> data = new ArrayList<>();

    public PanelRiwayatKasir(KasirController ctrl) { this(); this.ctrl = ctrl; }

    public void setController(KasirController ctrl) { this.ctrl = ctrl; }

    /** Konstruktor tanpa argumen: dipakai GUI Builder agar panel tampil di Design; controller dipasang lewat setController. */
    public PanelRiwayatKasir() {
        initComponents();
        model = (DefaultTableModel) tblRiwayat.getModel();
        Ui.gayaPesan(lblPesan);
        Ui.siapkanTabel(tblRiwayat);
        Ui.pasangPencarian(tblRiwayat, txtCari, lblJumlah, "Cari no. struk, pelanggan, periode, metode...");
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
        tblRiwayat = new javax.swing.JTable();
        pnlTombol = new javax.swing.JPanel();
        btnStruk = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(980, 560));
        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createCompoundBorder());
        setLayout(new java.awt.BorderLayout(10, 10));

        pnlAtas.setLayout(new java.awt.BorderLayout());

        lblJudul.setBackground(new java.awt.Color(224, 236, 255));
        lblJudul.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        lblJudul.setForeground(new java.awt.Color(11, 31, 75));
        lblJudul.setText("Riwayat Transaksi Saya");
        lblJudul.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 12, 8, 12));
        lblJudul.setOpaque(true);
        pnlAtas.add(lblJudul, java.awt.BorderLayout.NORTH);

        pnlCari.setOpaque(false);
        pnlCari.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlCari.setLayout(new java.awt.BorderLayout(10, 0));

        lblPesan.setText(" ");
        pnlCari.add(lblPesan, java.awt.BorderLayout.NORTH);

        lblCari.setText("    Cari");
        pnlCari.add(lblCari, java.awt.BorderLayout.WEST);

        txtCari.setToolTipText("Cari no. struk, pelanggan, periode, metode...");
        pnlCari.add(txtCari, java.awt.BorderLayout.CENTER);

        lblJumlah.setText(" ");
        pnlCari.add(lblJumlah, java.awt.BorderLayout.EAST);

        pnlAtas.add(pnlCari, java.awt.BorderLayout.SOUTH);

        add(pnlAtas, java.awt.BorderLayout.NORTH);

        tblRiwayat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Struk", "Tanggal", "Pelanggan", "Periode", "Jumlah", "Metode"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrTabel.setViewportView(tblRiwayat);

        add(scrTabel, java.awt.BorderLayout.CENTER);

        pnlTombol.setPreferredSize(new java.awt.Dimension(100, 44));
        pnlTombol.setBackground(new java.awt.Color(246, 249, 255));
        pnlTombol.setLayout(null);

        btnStruk.setBackground(new java.awt.Color(29, 78, 216));
        btnStruk.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnStruk.setForeground(new java.awt.Color(255, 255, 255));
        btnStruk.setText("Cetak Ulang Bukti");
        btnStruk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStrukActionPerformed(evt);
            }
        });
        pnlTombol.add(btnStruk);
        btnStruk.setBounds(1060, 10, 170, 32);

        add(pnlTombol, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void btnStrukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStrukActionPerformed
        cetakUlang();
    }//GEN-LAST:event_btnStrukActionPerformed

    private void cetakUlang() {
        int i = Ui.terpilih(tblRiwayat);
        if (i < 0) Ui.error(this, "Pilih transaksi pada tabel terlebih dahulu.");
        else DialogRincian.bukti(this, data.get(i));
    }

    @Override public void muat() {
        jalankan(() -> {
            data = ctrl.riwayat();
            model.setRowCount(0);
            for (Pembayaran b : data) {
                model.addRow(new Object[]{b.getNoStruk(), Fmt.waktu(b.getTanggalBayar()), b.getNamaPelanggan(),
                        b.getPeriode(), Fmt.rupiah(b.getJumlah()), b.getMetode()});
            }
            lblPesan.setText(data.isEmpty() ? "Tidak Ada Data Tagihan" : " ");
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStruk;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblPesan;
    private javax.swing.JPanel pnlAtas;
    private javax.swing.JPanel pnlCari;
    private javax.swing.JPanel pnlTombol;
    private javax.swing.JScrollPane scrTabel;
    private javax.swing.JTable tblRiwayat;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
