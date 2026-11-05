package view.petugas;

import view.BasePanel;
import view.Ui;

import util.AppException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import controller.PetugasController;
import model.Pelanggan;
import model.Tagihan;
import java.time.LocalDate;

/**
 * Flowchart Petugas "Membuat Tagihan": pilih pelanggan -> cek periode -> validasi meter -> hitung kWh & total -> simpan.
 * JPanel Form NetBeans: desain visual ada di PanelBuatTagihan.form (buka tab "Design").
 * Kode di dalam blok GEN-BEGIN/GEN-END dibuat otomatis oleh NetBeans, jangan diedit manual.
 */
public class PanelBuatTagihan extends BasePanel {

    private PetugasController ctrl;
    private final DefaultTableModel model;
    private List<Pelanggan> data = new ArrayList<>();

    public PanelBuatTagihan(PetugasController ctrl) { this(); this.ctrl = ctrl; }

    public void setController(PetugasController ctrl) { this.ctrl = ctrl; }

    /** Konstruktor tanpa argumen: dipakai GUI Builder agar panel tampil di Design; controller dipasang lewat setController. */
    public PanelBuatTagihan() {
        initComponents();
        model = (DefaultTableModel) tblPelanggan.getModel();
        Ui.gayaPesan(lblPesan);
        Ui.siapkanTabel(tblPelanggan);
        Ui.pasangPencarian(tblPelanggan, txtCari, lblJumlah, "Cari nama, nomor meter, alamat, golongan...");
        txtBulan.setText(String.valueOf(LocalDate.now().getMonthValue()));
        txtTahun.setText(String.valueOf(LocalDate.now().getYear()));
        txtJatuhTempo.setText(LocalDate.now().plusDays(20).toString());
        tblPelanggan.getSelectionModel().addListSelectionListener(e -> {
            if (e.getValueIsAdjusting()) return;
            int i = Ui.terpilih(tblPelanggan);
            if (i >= 0 && i < data.size()) jalankan(() -> txtMeterAwal.setText(ctrl.saranMeterAwal(data.get(i)).toPlainString()));
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJudul = new javax.swing.JLabel();
        pnlTengah = new javax.swing.JPanel();
        lblPesan = new javax.swing.JLabel();
        pnlCari = new javax.swing.JPanel();
        lblCari = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        lblJumlah = new javax.swing.JLabel();
        scrTabel = new javax.swing.JScrollPane();
        tblPelanggan = new javax.swing.JTable();
        pnlForm = new javax.swing.JPanel();
        lblBulan = new javax.swing.JLabel();
        txtBulan = new javax.swing.JTextField();
        lblTahun = new javax.swing.JLabel();
        txtTahun = new javax.swing.JTextField();
        lblMeterAwal = new javax.swing.JLabel();
        txtMeterAwal = new javax.swing.JTextField();
        lblMeterAkhir = new javax.swing.JLabel();
        txtMeterAkhir = new javax.swing.JTextField();
        lblJatuhTempo = new javax.swing.JLabel();
        txtJatuhTempo = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        lblCatatan1 = new javax.swing.JLabel();
        lblCatatan2 = new javax.swing.JLabel();

        lblJudul.setText("Membuat Tagihan Pelanggan");
        lblJudul.setOpaque(true);
        lblJudul.setBackground(new java.awt.Color(224, 236, 255));
        lblJudul.setForeground(new java.awt.Color(11, 31, 75));
        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 17));
        lblJudul.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 12, 8, 12));
        lblPesan.setText(" ");
        tblPelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "No. Meter", "Nama", "Golongan", "Alamat"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrTabel.setViewportView(tblPelanggan);
        pnlTengah.setLayout(new java.awt.BorderLayout(4, 4));
        pnlCari.setOpaque(false);
        pnlCari.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlCari.setLayout(new java.awt.BorderLayout(10, 0));
        lblCari.setText("Cari");
        txtCari.setToolTipText("Cari nama, nomor meter, alamat, golongan...");
        lblJumlah.setText(" ");
        pnlCari.add(lblPesan, java.awt.BorderLayout.NORTH);
        pnlCari.add(lblCari, java.awt.BorderLayout.WEST);
        pnlCari.add(txtCari, java.awt.BorderLayout.CENTER);
        pnlCari.add(lblJumlah, java.awt.BorderLayout.EAST);
        pnlTengah.add(pnlCari, java.awt.BorderLayout.NORTH);
        pnlTengah.add(scrTabel, java.awt.BorderLayout.CENTER);
        lblBulan.setText("Bulan");
        lblBulan.setForeground(new java.awt.Color(30, 41, 59));
        txtBulan.setBackground(new java.awt.Color(243, 247, 255));
        txtBulan.setForeground(new java.awt.Color(30, 41, 59));
        lblTahun.setText("Tahun");
        lblTahun.setForeground(new java.awt.Color(30, 41, 59));
        txtTahun.setBackground(new java.awt.Color(243, 247, 255));
        txtTahun.setForeground(new java.awt.Color(30, 41, 59));
        lblMeterAwal.setText("Meter Awal");
        lblMeterAwal.setForeground(new java.awt.Color(30, 41, 59));
        txtMeterAwal.setBackground(new java.awt.Color(243, 247, 255));
        txtMeterAwal.setForeground(new java.awt.Color(30, 41, 59));
        lblMeterAkhir.setText("Meter Akhir");
        lblMeterAkhir.setForeground(new java.awt.Color(30, 41, 59));
        txtMeterAkhir.setBackground(new java.awt.Color(243, 247, 255));
        txtMeterAkhir.setForeground(new java.awt.Color(30, 41, 59));
        lblJatuhTempo.setText("Jatuh Tempo");
        lblJatuhTempo.setForeground(new java.awt.Color(30, 41, 59));
        txtJatuhTempo.setBackground(new java.awt.Color(243, 247, 255));
        txtJatuhTempo.setForeground(new java.awt.Color(30, 41, 59));
        btnSimpan.setText("Simpan Tagihan");
        btnSimpan.setBackground(new java.awt.Color(22, 163, 74));
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        lblCatatan1.setText("Pilih pelanggan di tabel lebih dulu.");
        lblCatatan1.setForeground(new java.awt.Color(100, 116, 139));
        lblCatatan2.setText("Tanggal: yyyy-MM-dd. Total = kWh x tarif + beban");
        lblCatatan2.setForeground(new java.awt.Color(100, 116, 139));
        pnlForm.setPreferredSize(new java.awt.Dimension(100, 132));
        pnlForm.setBackground(new java.awt.Color(246, 249, 255));
        pnlForm.setLayout(null);
        pnlForm.add(lblBulan);
        lblBulan.setBounds(10, 12, 78, 22);
        pnlForm.add(txtBulan);
        txtBulan.setBounds(90, 10, 142, 26);
        pnlForm.add(lblTahun);
        lblTahun.setBounds(240, 12, 78, 22);
        pnlForm.add(txtTahun);
        txtTahun.setBounds(320, 10, 142, 26);
        pnlForm.add(lblMeterAwal);
        lblMeterAwal.setBounds(470, 12, 78, 22);
        pnlForm.add(txtMeterAwal);
        txtMeterAwal.setBounds(550, 10, 142, 26);
        pnlForm.add(lblMeterAkhir);
        lblMeterAkhir.setBounds(700, 12, 78, 22);
        pnlForm.add(txtMeterAkhir);
        txtMeterAkhir.setBounds(780, 10, 142, 26);
        pnlForm.add(lblJatuhTempo);
        lblJatuhTempo.setBounds(10, 48, 78, 22);
        pnlForm.add(txtJatuhTempo);
        txtJatuhTempo.setBounds(90, 46, 142, 26);
        pnlForm.add(btnSimpan);
        btnSimpan.setBounds(240, 44, 222, 32);
        pnlForm.add(lblCatatan1);
        lblCatatan1.setBounds(10, 86, 900, 20);
        pnlForm.add(lblCatatan2);
        lblCatatan2.setBounds(10, 106, 900, 20);
        setPreferredSize(new java.awt.Dimension(980, 560));
        setOpaque(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 235)), javax.swing.BorderFactory.createEmptyBorder(14, 16, 14, 16)));
        setLayout(new java.awt.BorderLayout(10, 10));
        add(lblJudul, java.awt.BorderLayout.NORTH);
        add(pnlTengah, java.awt.BorderLayout.CENTER);
        add(pnlForm, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        jalankan(this::simpan);
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void simpan() {
        int i = Ui.terpilih(tblPelanggan);
        if (i < 0) throw new AppException("Pilih pelanggan pada tabel terlebih dahulu.");
        Tagihan t = ctrl.buatTagihan(data.get(i), txtBulan.getText(), txtTahun.getText(),
                txtMeterAwal.getText(), txtMeterAkhir.getText(), txtJatuhTempo.getText());
        Ui.tampilkanTeks(this, "Tagihan Berhasil Dibuat", t.cetak());
        txtMeterAkhir.setText("");
        txtMeterAwal.setText(t.getMeterAkhir().toPlainString());
    }

    @Override public void muat() {
        jalankan(() -> {
            data = ctrl.daftarPelanggan();
            model.setRowCount(0);
            for (Pelanggan p : data) {
                model.addRow(new Object[]{p.getId(), p.getNomorMeter(), p.getNama(), p.getKodeGolongan(), p.getAlamat()});
            }
            lblPesan.setText(data.isEmpty() ? "Tidak Ada Data Pelanggan" : " ");
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel lblBulan;
    private javax.swing.JLabel lblCatatan1;
    private javax.swing.JLabel lblCatatan2;
    private javax.swing.JLabel lblJatuhTempo;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblMeterAkhir;
    private javax.swing.JLabel lblMeterAwal;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblPesan;
    private javax.swing.JPanel pnlCari;
    private javax.swing.JTextField txtCari;
    private javax.swing.JLabel lblTahun;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JPanel pnlTengah;
    private javax.swing.JScrollPane scrTabel;
    private javax.swing.JTable tblPelanggan;
    private javax.swing.JTextField txtBulan;
    private javax.swing.JTextField txtJatuhTempo;
    private javax.swing.JTextField txtMeterAkhir;
    private javax.swing.JTextField txtMeterAwal;
    private javax.swing.JTextField txtTahun;
    // End of variables declaration//GEN-END:variables
}
