package view.admin;

import view.BasePanel;
import view.Ui;

import util.AppException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import controller.AdminController;
import model.Golongan;
import util.Fmt;

/**
 * Flowchart "Admin - Golongan Tarif": tambah, ubah, hapus golongan.
 * JPanel Form NetBeans: desain visual ada di PanelGolongan.form (buka tab "Design").
 * Kode di dalam blok GEN-BEGIN/GEN-END dibuat otomatis oleh NetBeans, jangan diedit manual.
 */
public class PanelGolongan extends BasePanel {

    private AdminController ctrl;
    private final DefaultTableModel model;
    private List<Golongan> data = new ArrayList<>();

    public PanelGolongan(AdminController ctrl) { this(); this.ctrl = ctrl; }

    public void setController(AdminController ctrl) { this.ctrl = ctrl; }

    /** Konstruktor tanpa argumen: dipakai GUI Builder agar panel tampil di Design; controller dipasang lewat setController. */
    public PanelGolongan() {
        initComponents();
        model = (DefaultTableModel) tblGolongan.getModel();
        Ui.gayaPesan(lblPesan);
        Ui.siapkanTabel(tblGolongan);
        Ui.pasangPencarian(tblGolongan, txtCari, lblJumlah, "Cari kode, daya, tarif...");
        tblGolongan.getSelectionModel().addListSelectionListener(e -> { if (!e.getValueIsAdjusting()) isiForm(); });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJudul = new javax.swing.JLabel();
        pnlForm = new javax.swing.JPanel();
        lblKode = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        lblDaya = new javax.swing.JLabel();
        txtDaya = new javax.swing.JTextField();
        lblTarif = new javax.swing.JLabel();
        txtTarif = new javax.swing.JTextField();
        lblBeban = new javax.swing.JLabel();
        txtBeban = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBersihkan = new javax.swing.JButton();
        pnlTengah = new javax.swing.JPanel();
        lblPesan = new javax.swing.JLabel();
        pnlCari = new javax.swing.JPanel();
        lblCari = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        lblJumlah = new javax.swing.JLabel();
        scrTabel = new javax.swing.JScrollPane();
        tblGolongan = new javax.swing.JTable();

        lblJudul.setText("Kelola Golongan Tarif");
        lblJudul.setOpaque(true);
        lblJudul.setBackground(new java.awt.Color(224, 236, 255));
        lblJudul.setForeground(new java.awt.Color(11, 31, 75));
        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 17));
        lblJudul.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 12, 8, 12));
        lblKode.setText("Kode");
        lblKode.setForeground(new java.awt.Color(30, 41, 59));
        txtKode.setBackground(new java.awt.Color(243, 247, 255));
        txtKode.setForeground(new java.awt.Color(30, 41, 59));
        lblDaya.setText("Daya (VA)");
        lblDaya.setForeground(new java.awt.Color(30, 41, 59));
        txtDaya.setBackground(new java.awt.Color(243, 247, 255));
        txtDaya.setForeground(new java.awt.Color(30, 41, 59));
        lblTarif.setText("Tarif/kWh (Rp)");
        lblTarif.setForeground(new java.awt.Color(30, 41, 59));
        txtTarif.setBackground(new java.awt.Color(243, 247, 255));
        txtTarif.setForeground(new java.awt.Color(30, 41, 59));
        lblBeban.setText("Beban (Rp)");
        lblBeban.setForeground(new java.awt.Color(30, 41, 59));
        txtBeban.setBackground(new java.awt.Color(243, 247, 255));
        txtBeban.setForeground(new java.awt.Color(30, 41, 59));
        btnTambah.setText("Tambah");
        btnTambah.setBackground(new java.awt.Color(22, 163, 74));
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        btnUbah.setText("Ubah");
        btnUbah.setBackground(new java.awt.Color(29, 78, 216));
        btnUbah.setForeground(new java.awt.Color(255, 255, 255));
        btnUbah.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        btnHapus.setText("Hapus");
        btnHapus.setBackground(new java.awt.Color(220, 38, 38));
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        btnBersihkan.setText("Bersihkan");
        btnBersihkan.setBackground(new java.awt.Color(71, 85, 105));
        btnBersihkan.setForeground(new java.awt.Color(255, 255, 255));
        btnBersihkan.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnBersihkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBersihkanActionPerformed(evt);
            }
        });
        pnlForm.setPreferredSize(new java.awt.Dimension(100, 92));
        pnlForm.setBackground(new java.awt.Color(246, 249, 255));
        pnlForm.setLayout(null);
        pnlForm.add(lblKode);
        lblKode.setBounds(10, 12, 105, 22);
        pnlForm.add(txtKode);
        txtKode.setBounds(118, 10, 115, 26);
        pnlForm.add(lblDaya);
        lblDaya.setBounds(245, 12, 105, 22);
        pnlForm.add(txtDaya);
        txtDaya.setBounds(353, 10, 115, 26);
        pnlForm.add(lblTarif);
        lblTarif.setBounds(480, 12, 105, 22);
        pnlForm.add(txtTarif);
        txtTarif.setBounds(588, 10, 115, 26);
        pnlForm.add(lblBeban);
        lblBeban.setBounds(715, 12, 105, 22);
        pnlForm.add(txtBeban);
        txtBeban.setBounds(823, 10, 115, 26);
        pnlForm.add(btnTambah);
        btnTambah.setBounds(10, 48, 150, 30);
        pnlForm.add(btnUbah);
        btnUbah.setBounds(170, 48, 150, 30);
        pnlForm.add(btnHapus);
        btnHapus.setBounds(330, 48, 150, 30);
        pnlForm.add(btnBersihkan);
        btnBersihkan.setBounds(490, 48, 150, 30);
        lblPesan.setText(" ");
        tblGolongan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Kode", "Daya (VA)", "Tarif / kWh", "Biaya Beban"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrTabel.setViewportView(tblGolongan);
        pnlTengah.setLayout(new java.awt.BorderLayout(4, 4));
        pnlCari.setOpaque(false);
        pnlCari.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlCari.setLayout(new java.awt.BorderLayout(10, 0));
        lblCari.setText("Cari");
        txtCari.setToolTipText("Cari kode, daya, tarif...");
        lblJumlah.setText(" ");
        pnlCari.add(lblPesan, java.awt.BorderLayout.NORTH);
        pnlCari.add(lblCari, java.awt.BorderLayout.WEST);
        pnlCari.add(txtCari, java.awt.BorderLayout.CENTER);
        pnlCari.add(lblJumlah, java.awt.BorderLayout.EAST);
        pnlTengah.add(pnlCari, java.awt.BorderLayout.NORTH);
        pnlTengah.add(scrTabel, java.awt.BorderLayout.CENTER);
        setPreferredSize(new java.awt.Dimension(980, 560));
        setOpaque(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 235)), javax.swing.BorderFactory.createEmptyBorder(14, 16, 14, 16)));
        setLayout(new java.awt.BorderLayout(10, 10));
        add(lblJudul, java.awt.BorderLayout.NORTH);
        add(pnlForm, java.awt.BorderLayout.SOUTH);
        add(pnlTengah, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        jalankan(this::tambah);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        jalankan(this::ubah);
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        jalankan(this::hapus);
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBersihkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBersihkanActionPerformed
        bersih();
    }//GEN-LAST:event_btnBersihkanActionPerformed

    private Golongan dipilih() {
        int i = Ui.terpilih(tblGolongan);
        if (i < 0) throw new AppException("Pilih golongan pada tabel terlebih dahulu.");
        return data.get(i);
    }

    private void tambah() {
        ctrl.tambahGolongan(txtKode.getText(), txtDaya.getText(), txtTarif.getText(), txtBeban.getText());
        Ui.info(this, "Golongan Berhasil Dibuat");
        muat();
    }

    private void ubah() {
        ctrl.ubahGolongan(dipilih().getId(), txtKode.getText(), txtDaya.getText(), txtTarif.getText(), txtBeban.getText());
        Ui.info(this, "Data Golongan Diperbarui");
        muat();
    }

    private void hapus() {
        Golongan g = dipilih();
        if (Ui.konfirmasi(this, "Hapus Golongan Tarif " + g.getKode() + "?")) {
            ctrl.hapusGolongan(g.getId());
            Ui.info(this, "Data Golongan Berhasil Dihapus");
            muat();
        }
    }

    private void isiForm() {
        int i = Ui.terpilih(tblGolongan);
        if (i < 0 || i >= data.size()) return;
        Golongan g = data.get(i);
        txtKode.setText(g.getKode());
        txtDaya.setText(String.valueOf(g.getDayaVa()));
        txtTarif.setText(g.getTarifPerKwh().toPlainString());
        txtBeban.setText(g.getBiayaBeban().toPlainString());
    }

    private void bersih() {
        tblGolongan.clearSelection();
        txtKode.setText(""); txtDaya.setText(""); txtTarif.setText(""); txtBeban.setText("");
    }

    @Override public void muat() {
        jalankan(() -> {
            data = ctrl.daftarGolongan();
            model.setRowCount(0);
            for (Golongan g : data) {
                model.addRow(new Object[]{g.getId(), g.getKode(), g.getDayaVa(),
                        Fmt.rupiah(g.getTarifPerKwh()), Fmt.rupiah(g.getBiayaBeban())});
            }
            lblPesan.setText(data.isEmpty() ? "Tidak Ada Data Golongan Tarif" : " ");
            bersih();
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBersihkan;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel lblBeban;
    private javax.swing.JLabel lblDaya;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblKode;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblPesan;
    private javax.swing.JPanel pnlCari;
    private javax.swing.JTextField txtCari;
    private javax.swing.JLabel lblTarif;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JPanel pnlTengah;
    private javax.swing.JScrollPane scrTabel;
    private javax.swing.JTable tblGolongan;
    private javax.swing.JTextField txtBeban;
    private javax.swing.JTextField txtDaya;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtTarif;
    // End of variables declaration//GEN-END:variables
}
