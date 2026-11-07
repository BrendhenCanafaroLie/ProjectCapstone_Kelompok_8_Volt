package view.admin;

import view.BasePanel;
import view.DialogRincian;
import view.Ui;

import util.AppException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import controller.AdminController;
import model.Pengaduan;
import util.Fmt;

/**
 * Flowchart "Melihat Laporan Pengaduan" (admin): daftar -> pilih -> detail.
 * JPanel Form NetBeans: desain visual ada di PanelPengaduanAdmin.form (buka tab "Design").
 * Kode di dalam blok GEN-BEGIN/GEN-END dibuat otomatis oleh NetBeans, jangan diedit manual.
 */
public class PanelPengaduanAdmin extends BasePanel {

    private AdminController ctrl;
    private final DefaultTableModel model;
    private List<Pengaduan> data = new ArrayList<>();

    public PanelPengaduanAdmin(AdminController ctrl) { this(); this.ctrl = ctrl; }

    public void setController(AdminController ctrl) { this.ctrl = ctrl; }

    /** Konstruktor tanpa argumen: dipakai GUI Builder agar panel tampil di Design; controller dipasang lewat setController. */
    public PanelPengaduanAdmin() {
        initComponents();
        model = (DefaultTableModel) tblPengaduan.getModel();
        Ui.gayaPesan(lblPesan);
        Ui.siapkanTabel(tblPengaduan);
        Ui.pasangPencarian(tblPengaduan, txtCari, lblJumlah, "Cari pelanggan, lokasi, status, petugas...");
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
        tblPengaduan = new javax.swing.JTable();
        pnlTombol = new javax.swing.JPanel();
        btnDetail = new javax.swing.JButton();
        btnMuat = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(980, 560));
        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createCompoundBorder());
        setLayout(new java.awt.BorderLayout(10, 10));

        pnlAtas.setLayout(new java.awt.BorderLayout());

        lblJudul.setText("Laporan Pengaduan Pelanggan");
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

        txtCari.setToolTipText("Cari pelanggan, lokasi, status, petugas...");
        pnlCari.add(txtCari, java.awt.BorderLayout.CENTER);

        lblJumlah.setText(" ");
        pnlCari.add(lblJumlah, java.awt.BorderLayout.EAST);

        pnlAtas.add(pnlCari, java.awt.BorderLayout.SOUTH);

        add(pnlAtas, java.awt.BorderLayout.NORTH);

        tblPengaduan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Pelapor", "Lokasi", "Tanggal Lapor", "Status", "Petugas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrTabel.setViewportView(tblPengaduan);

        add(scrTabel, java.awt.BorderLayout.CENTER);

        pnlTombol.setPreferredSize(new java.awt.Dimension(100, 44));
        pnlTombol.setBackground(new java.awt.Color(246, 249, 255));
        pnlTombol.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 5));

        btnDetail.setBackground(new java.awt.Color(245, 158, 11));
        btnDetail.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnDetail.setForeground(new java.awt.Color(255, 255, 255));
        btnDetail.setText("Lihat Detail Pengaduan");
        btnDetail.setPreferredSize(new java.awt.Dimension(200, 32));
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });
        pnlTombol.add(btnDetail);

        btnMuat.setPreferredSize(new java.awt.Dimension(120, 32));
        btnMuat.setText("Muat Ulang");
        btnMuat.setBackground(new java.awt.Color(29, 78, 216));
        btnMuat.setForeground(new java.awt.Color(255, 255, 255));
        btnMuat.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnMuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuatActionPerformed(evt);
            }
        });
        pnlTombol.add(btnMuat);

        add(pnlTombol, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        lihatDetail();
    }//GEN-LAST:event_btnDetailActionPerformed

    private void btnMuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuatActionPerformed
        muat();
    }//GEN-LAST:event_btnMuatActionPerformed

    private void lihatDetail() {
        int i = Ui.terpilih(tblPengaduan);
        if (i < 0) Ui.error(this, "Pilih pengaduan pada tabel terlebih dahulu.");
        else DialogRincian.pengaduan(this, data.get(i), null);
    }

    @Override public void muat() {
        jalankan(() -> {
            data = ctrl.daftarPengaduan();
            model.setRowCount(0);
            for (Pengaduan a : data) {
                model.addRow(new Object[]{a.getId(), a.getNamaPelanggan(), a.getLokasi(), Fmt.waktu(a.getTanggalLapor()),
                        a.getStatus(), a.getNamaPetugas() == null ? "-" : a.getNamaPetugas()});
            }
            lblPesan.setText(data.isEmpty() ? "Tidak Ada Data Pengaduan" : " ");
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetail;
    private javax.swing.JButton btnMuat;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblPesan;
    private javax.swing.JPanel pnlAtas;
    private javax.swing.JPanel pnlCari;
    private javax.swing.JPanel pnlTombol;
    private javax.swing.JScrollPane scrTabel;
    private javax.swing.JTable tblPengaduan;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
