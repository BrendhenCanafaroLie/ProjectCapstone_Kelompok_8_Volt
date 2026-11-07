package view.petugas;

import view.BasePanel;
import view.DialogRincian;
import view.Ui;

import util.AppException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import controller.PetugasController;
import model.Pengaduan;
import util.Fmt;
import util.Konstanta;

/**
 * Flowchart Petugas "Memperbarui Status Gangguan" (tampilan disamakan dengan Laporan Pengaduan admin).
 * JPanel Form NetBeans: desain visual ada di PanelUpdatePengaduan.form (buka tab "Design").
 * Kode di dalam blok GEN-BEGIN/GEN-END dibuat otomatis oleh NetBeans, jangan diedit manual.
 */
public class PanelUpdatePengaduan extends BasePanel {

    private PetugasController ctrl;
    private final DefaultTableModel model;
    private List<Pengaduan> data = new ArrayList<>();

    public PanelUpdatePengaduan(PetugasController ctrl) { this(); this.ctrl = ctrl; }

    public void setController(PetugasController ctrl) { this.ctrl = ctrl; }

    /** Konstruktor tanpa argumen: dipakai GUI Builder agar panel tampil di Design; controller dipasang lewat setController. */
    public PanelUpdatePengaduan() {
        initComponents();
        model = (DefaultTableModel) tblPengaduan.getModel();
        Ui.gayaPesan(lblPesan);
        Ui.siapkanTabel(tblPengaduan);
        Ui.pasangPencarian(tblPengaduan, txtCari, lblJumlah, "Cari pelanggan, lokasi, status, petugas...");
        tblPengaduan.getSelectionModel().addListSelectionListener(e -> {
            if (e.getValueIsAdjusting()) return;
            int i = Ui.terpilih(tblPengaduan);
            if (i >= 0 && i < data.size()) cmbStatus.setSelectedItem(data.get(i).getStatus());
        });
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
        pnlTombol = new javax.swing.JPanel();
        btnDetail = new javax.swing.JButton();
        btnMuat = new javax.swing.JButton();
        lblStatusBaru = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox();
        btnPerbarui = new javax.swing.JButton();
        scrTabel = new javax.swing.JScrollPane();
        tblPengaduan = new javax.swing.JTable();

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
        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });
        pnlCari.add(txtCari, java.awt.BorderLayout.CENTER);

        lblJumlah.setText(" ");
        pnlCari.add(lblJumlah, java.awt.BorderLayout.EAST);

        pnlTombol.setPreferredSize(new java.awt.Dimension(100, 44));
        pnlTombol.setBackground(new java.awt.Color(246, 249, 255));
        pnlTombol.setLayout(null);

        btnDetail.setBackground(new java.awt.Color(245, 158, 11));
        btnDetail.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnDetail.setForeground(new java.awt.Color(255, 255, 255));
        btnDetail.setText("Lihat Detail Pengaduan");
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });
        pnlTombol.add(btnDetail);
        btnDetail.setBounds(10, 10, 200, 32);

        btnMuat.setBackground(new java.awt.Color(29, 78, 216));
        btnMuat.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnMuat.setForeground(new java.awt.Color(255, 255, 255));
        btnMuat.setText("Muat Ulang");
        btnMuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuatActionPerformed(evt);
            }
        });
        pnlTombol.add(btnMuat);
        btnMuat.setBounds(220, 10, 120, 32);

        lblStatusBaru.setText("Status baru:");
        lblStatusBaru.setForeground(new java.awt.Color(30, 41, 59));
        pnlTombol.add(lblStatusBaru);
        lblStatusBaru.setBounds(370, 11, 80, 22);

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dilaporkan", "Diproses", "Selesai" }));
        cmbStatus.setBackground(new java.awt.Color(243, 247, 255));
        cmbStatus.setForeground(new java.awt.Color(30, 41, 59));
        pnlTombol.add(cmbStatus);
        cmbStatus.setBounds(455, 8, 150, 28);

        btnPerbarui.setBackground(new java.awt.Color(22, 163, 74));
        btnPerbarui.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnPerbarui.setForeground(new java.awt.Color(255, 255, 255));
        btnPerbarui.setText("Perbarui Status");
        btnPerbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerbaruiActionPerformed(evt);
            }
        });
        pnlTombol.add(btnPerbarui);
        btnPerbarui.setBounds(620, 10, 150, 32);

        pnlCari.add(pnlTombol, java.awt.BorderLayout.PAGE_END);

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
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        lihatDetail();
    }//GEN-LAST:event_btnDetailActionPerformed

    private void btnMuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuatActionPerformed
        muat();
    }//GEN-LAST:event_btnMuatActionPerformed

    private void btnPerbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerbaruiActionPerformed
        jalankan(this::perbarui);
    }//GEN-LAST:event_btnPerbaruiActionPerformed

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void perbarui() {
        int i = Ui.terpilih(tblPengaduan);
        if (i < 0) throw new AppException("Pilih pengaduan pada tabel terlebih dahulu.");
        ctrl.perbaruiStatus(data.get(i), (String) cmbStatus.getSelectedItem());
        Ui.info(this, "Status Pengaduan Berhasil Diperbarui");
        muat();
    }

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
    private javax.swing.JButton btnPerbarui;
    private javax.swing.JComboBox cmbStatus;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblPesan;
    private javax.swing.JLabel lblStatusBaru;
    private javax.swing.JPanel pnlAtas;
    private javax.swing.JPanel pnlCari;
    private javax.swing.JPanel pnlTombol;
    private javax.swing.JScrollPane scrTabel;
    private javax.swing.JTable tblPengaduan;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
