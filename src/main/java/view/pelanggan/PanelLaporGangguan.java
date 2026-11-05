package view.pelanggan;

import view.BasePanel;
import view.Ui;

import util.AppException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import controller.PelangganController;
import model.Pengaduan;
import util.Fmt;

/**
 * Flowchart Pelanggan "Lapor Gangguan" + "Lihat Status Pengaduan" (digabung dalam satu tabel).
 * JPanel Form NetBeans: desain visual ada di PanelLaporGangguan.form (buka tab "Design").
 * Kode di dalam blok GEN-BEGIN/GEN-END dibuat otomatis oleh NetBeans, jangan diedit manual.
 */
public class PanelLaporGangguan extends BasePanel {

    private PelangganController ctrl;
    private final DefaultTableModel model;
    private List<Pengaduan> data = new ArrayList<>();

    public PanelLaporGangguan(PelangganController ctrl) { this(); this.ctrl = ctrl; }

    public void setController(PelangganController ctrl) { this.ctrl = ctrl; }

    /** Konstruktor tanpa argumen: dipakai GUI Builder agar panel tampil di Design; controller dipasang lewat setController. */
    public PanelLaporGangguan() {
        initComponents();
        model = (DefaultTableModel) tblPengaduan.getModel();
        Ui.gayaPesan(lblPesan);
        Ui.siapkanTabel(tblPengaduan);
        Ui.pasangPencarian(tblPengaduan, txtCari, lblJumlah, "Cari lokasi, status, tanggal, petugas...");
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
        tblPengaduan = new javax.swing.JTable();
        pnlTombol = new javax.swing.JPanel();
        btnDetail = new javax.swing.JButton();
        btnMuat = new javax.swing.JButton();
        btnBaru = new javax.swing.JButton();

        lblJudul.setText("Lapor Gangguan");
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
        txtCari.setToolTipText("Cari lokasi, status, tanggal, petugas...");
        lblJumlah.setText(" ");
        pnlCari.add(lblPesan, java.awt.BorderLayout.NORTH);
        pnlCari.add(lblCari, java.awt.BorderLayout.WEST);
        pnlCari.add(txtCari, java.awt.BorderLayout.CENTER);
        pnlCari.add(lblJumlah, java.awt.BorderLayout.EAST);
        pnlAtas.add(pnlCari, java.awt.BorderLayout.SOUTH);
        tblPengaduan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Lokasi", "Koordinat", "Tanggal Lapor", "Tanggal Selesai", "Status", "Petugas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrTabel.setViewportView(tblPengaduan);
        btnBaru.setText("Buat Laporan Baru");
        btnBaru.setBackground(new java.awt.Color(22, 163, 74));
        btnBaru.setForeground(new java.awt.Color(255, 255, 255));
        btnBaru.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaruActionPerformed(evt);
            }
        });
        btnDetail.setText("Lihat Detail Pengaduan");
        btnDetail.setBackground(new java.awt.Color(245, 158, 11));
        btnDetail.setForeground(new java.awt.Color(11, 31, 75));
        btnDetail.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
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
        pnlTombol.add(btnBaru);
        btnBaru.setBounds(5, 5, 170, 32);
        pnlTombol.add(btnDetail);
        btnDetail.setBounds(185, 5, 200, 32);
        pnlTombol.add(btnMuat);
        btnMuat.setBounds(395, 5, 120, 32);
        setPreferredSize(new java.awt.Dimension(980, 560));
        setOpaque(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 235)), javax.swing.BorderFactory.createEmptyBorder(14, 16, 14, 16)));
        setLayout(new java.awt.BorderLayout(10, 10));
        add(pnlAtas, java.awt.BorderLayout.NORTH);
        add(scrTabel, java.awt.BorderLayout.CENTER);
        add(pnlTombol, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        lihatDetail();
    }//GEN-LAST:event_btnDetailActionPerformed

    private void btnMuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuatActionPerformed
        muat();
    }//GEN-LAST:event_btnMuatActionPerformed

    private void btnBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaruActionPerformed
        if (new DialogLaporGangguan(this, ctrl).tampil()) muat();
    }//GEN-LAST:event_btnBaruActionPerformed

    private void lihatDetail() {
        int i = Ui.terpilih(tblPengaduan);
        if (i < 0) Ui.error(this, "Pilih pengaduan pada tabel terlebih dahulu.");
        else {
            Pengaduan a = data.get(i);
            Ui.tampilkanTeks(this, "Detail Pengaduan", a.cetak() + "\n\n>> " + ctrl.pesanStatus(a));
        }
    }

    @Override public void muat() {
        jalankan(() -> {
            data = ctrl.pengaduanSaya();
            model.setRowCount(0);
            for (Pengaduan a : data) {
                model.addRow(new Object[]{a.getId(), a.getLokasi(), util.Lokasi.format(a.getLintang(), a.getBujur()),
                        Fmt.waktu(a.getTanggalLapor()), Fmt.waktu(a.getTanggalSelesai()), a.getStatus(), a.getNamaPetugas() == null ? "-" : a.getNamaPetugas()});
            }
            lblPesan.setText(data.isEmpty() ? "Belum Ada Laporan Gangguan" : " ");
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaru;
    private javax.swing.JButton btnMuat;
    private javax.swing.JButton btnDetail;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblPesan;
    private javax.swing.JPanel pnlCari;
    private javax.swing.JTextField txtCari;
    private javax.swing.JPanel pnlAtas;
    private javax.swing.JPanel pnlTombol;
    private javax.swing.JScrollPane scrTabel;
    private javax.swing.JTable tblPengaduan;
    // End of variables declaration//GEN-END:variables
}
