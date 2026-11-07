package view.admin;

import view.BasePanel;
import view.Ui;

import util.AppException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import controller.AdminController;
import model.Karyawan;
import model.Kasir;
import model.PetugasLapangan;
import util.Konstanta;

/**
 * Flowchart "Admin - CRUD Petugas": tambah, ubah, hapus akun Kasir / Petugas Lapangan.
 * JPanel Form NetBeans: desain visual ada di PanelPetugas.form (buka tab "Design").
 * Kode di dalam blok GEN-BEGIN/GEN-END dibuat otomatis oleh NetBeans, jangan diedit manual.
 */
public class PanelPetugas extends BasePanel {

    private AdminController ctrl;
    private final DefaultTableModel model;
    private List<Karyawan> data = new ArrayList<>();

    public PanelPetugas(AdminController ctrl) { this(); this.ctrl = ctrl; }

    public void setController(AdminController ctrl) { this.ctrl = ctrl; }

    /** Konstruktor tanpa argumen: dipakai GUI Builder agar panel tampil di Design; controller dipasang lewat setController. */
    public PanelPetugas() {
        initComponents();
        model = (DefaultTableModel) tblPetugas.getModel();
        Ui.gayaPesan(lblPesan);
        Ui.siapkanTabel(tblPetugas);
        Ui.pasangPencarian(tblPetugas, txtCari, lblJumlah, "Cari nama, username, jabatan, wilayah...");
        cmbSetoran.addActionListener(e -> {
            // memilih Sudah Setor tanpa tanggal: isi hari ini; Belum Setor: kosongkan tanggal
            if (!cmbSetoran.isEnabled()) return;
            boolean sudah = Konstanta.SETORAN_SUDAH.equals(cmbSetoran.getSelectedItem());
            if (sudah && txtTglSetor.getText().isBlank()) txtTglSetor.setText(java.time.LocalDate.now().toString());
            if (!sudah) txtTglSetor.setText("");
            txtTglSetor.setEnabled(sudah);
        });
        tblPetugas.getSelectionModel().addListSelectionListener(e -> { if (!e.getValueIsAdjusting()) isiForm(); });
        Ui.abuAbu(txtNama, txtTelepon, txtUsername, txtPassword, cmbJabatan, cmbWilayah, cmbSpesialis, cmbSetoran, txtTglSetor);
        aturField();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJudul = new javax.swing.JLabel();
        pnlTengah = new javax.swing.JPanel();
        pnlCari = new javax.swing.JPanel();
        lblCari = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        lblJumlah = new javax.swing.JLabel();
        pnlForm = new javax.swing.JPanel();
        lblJabatan = new javax.swing.JLabel();
        cmbJabatan = new javax.swing.JComboBox();
        lblNama = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        lblTelepon = new javax.swing.JLabel();
        txtTelepon = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblWilayah = new javax.swing.JLabel();
        cmbWilayah = new javax.swing.JComboBox();
        lblSpesialis = new javax.swing.JLabel();
        cmbSpesialis = new javax.swing.JComboBox();
        lblSetoran = new javax.swing.JLabel();
        cmbSetoran = new javax.swing.JComboBox();
        lblTglSetor = new javax.swing.JLabel();
        txtTglSetor = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBersihkan = new javax.swing.JButton();
        lblCatatan = new javax.swing.JLabel();
        scrTabel = new javax.swing.JScrollPane();
        tblPetugas = new javax.swing.JTable();
        lblPesan = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(980, 560));
        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createCompoundBorder());
        setLayout(new java.awt.BorderLayout(10, 10));

        lblJudul.setText("Kelola Data Petugas");
        lblJudul.setOpaque(true);
        lblJudul.setBackground(new java.awt.Color(224, 236, 255));
        lblJudul.setForeground(new java.awt.Color(11, 31, 75));
        lblJudul.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        lblJudul.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 12, 8, 12));
        add(lblJudul, java.awt.BorderLayout.NORTH);

        pnlTengah.setLayout(new java.awt.BorderLayout(4, 4));

        pnlCari.setOpaque(false);
        pnlCari.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlCari.setLayout(new java.awt.BorderLayout(10, 0));

        lblCari.setText("Cari");
        pnlCari.add(lblCari, java.awt.BorderLayout.WEST);

        txtCari.setToolTipText("Cari nama, username, jabatan, wilayah...");
        pnlCari.add(txtCari, java.awt.BorderLayout.CENTER);

        lblJumlah.setText(" ");
        pnlCari.add(lblJumlah, java.awt.BorderLayout.EAST);

        pnlForm.setPreferredSize(new java.awt.Dimension(100, 152));
        pnlForm.setBackground(new java.awt.Color(246, 249, 255));
        pnlForm.setLayout(null);

        lblJabatan.setText("Jabatan");
        lblJabatan.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(lblJabatan);
        lblJabatan.setBounds(10, 12, 78, 22);

        cmbJabatan.setBackground(new java.awt.Color(243, 247, 255));
        cmbJabatan.setForeground(new java.awt.Color(30, 41, 59));
        cmbJabatan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Petugas Lapangan", "Kasir" }));
        cmbJabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbJabatanActionPerformed(evt);
            }
        });
        pnlForm.add(cmbJabatan);
        cmbJabatan.setBounds(90, 10, 142, 26);

        lblNama.setText("Nama");
        lblNama.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(lblNama);
        lblNama.setBounds(240, 12, 78, 22);

        txtNama.setBackground(new java.awt.Color(243, 247, 255));
        txtNama.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(txtNama);
        txtNama.setBounds(320, 10, 142, 26);

        lblTelepon.setText("Telepon");
        lblTelepon.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(lblTelepon);
        lblTelepon.setBounds(470, 12, 78, 22);

        txtTelepon.setBackground(new java.awt.Color(243, 247, 255));
        txtTelepon.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(txtTelepon);
        txtTelepon.setBounds(550, 10, 142, 26);

        lblUsername.setText("Username");
        lblUsername.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(lblUsername);
        lblUsername.setBounds(700, 12, 78, 22);

        txtUsername.setBackground(new java.awt.Color(243, 247, 255));
        txtUsername.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(txtUsername);
        txtUsername.setBounds(780, 10, 142, 26);

        lblPassword.setText("Password");
        lblPassword.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(lblPassword);
        lblPassword.setBounds(10, 48, 78, 22);

        txtPassword.setBackground(new java.awt.Color(243, 247, 255));
        txtPassword.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(txtPassword);
        txtPassword.setBounds(90, 46, 142, 26);

        lblWilayah.setText("Wilayah");
        lblWilayah.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(lblWilayah);
        lblWilayah.setBounds(240, 48, 78, 22);

        cmbWilayah.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bugis", "Loa Bakung", "Loa Janan Ilir", "Mangkupalas", "Palaran", "Sambutan", "Samarinda Ilir", "Samarinda Kota", "Samarinda Seberang", "Samarinda Ulu", "Samarinda Utara", "Sungai Kapih", "Sungai Kunjang", "Sungai Pinang" }));
        cmbWilayah.setBackground(new java.awt.Color(243, 247, 255));
        cmbWilayah.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(cmbWilayah);
        cmbWilayah.setBounds(320, 46, 142, 26);

        lblSpesialis.setText("Spesialis");
        lblSpesialis.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(lblSpesialis);
        lblSpesialis.setBounds(470, 48, 78, 22);

        cmbSpesialis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Teknisi", "Catat Meter", "Keduanya" }));
        cmbSpesialis.setBackground(new java.awt.Color(243, 247, 255));
        cmbSpesialis.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(cmbSpesialis);
        cmbSpesialis.setBounds(550, 46, 142, 26);

        lblSetoran.setText("Setoran");
        lblSetoran.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(lblSetoran);
        lblSetoran.setBounds(700, 48, 78, 22);

        cmbSetoran.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Belum Setor", "Sudah Setor" }));
        cmbSetoran.setBackground(new java.awt.Color(243, 247, 255));
        cmbSetoran.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(cmbSetoran);
        cmbSetoran.setBounds(780, 46, 142, 26);

        lblTglSetor.setText("Tgl Setor");
        lblTglSetor.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(lblTglSetor);
        lblTglSetor.setBounds(10, 84, 78, 22);

        txtTglSetor.setBackground(new java.awt.Color(243, 247, 255));
        txtTglSetor.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(txtTglSetor);
        txtTglSetor.setBounds(90, 82, 142, 26);

        btnTambah.setText("Tambah");
        btnTambah.setBackground(new java.awt.Color(22, 163, 74));
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        pnlForm.add(btnTambah);
        btnTambah.setBounds(240, 80, 100, 30);

        btnUbah.setText("Ubah");
        btnUbah.setBackground(new java.awt.Color(29, 78, 216));
        btnUbah.setForeground(new java.awt.Color(255, 255, 255));
        btnUbah.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        pnlForm.add(btnUbah);
        btnUbah.setBounds(350, 80, 100, 30);

        btnHapus.setText("Hapus");
        btnHapus.setBackground(new java.awt.Color(220, 38, 38));
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        pnlForm.add(btnHapus);
        btnHapus.setBounds(460, 80, 100, 30);

        btnBersihkan.setText("Bersihkan");
        btnBersihkan.setBackground(new java.awt.Color(71, 85, 105));
        btnBersihkan.setForeground(new java.awt.Color(255, 255, 255));
        btnBersihkan.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnBersihkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBersihkanActionPerformed(evt);
            }
        });
        pnlForm.add(btnBersihkan);
        btnBersihkan.setBounds(570, 80, 100, 30);

        lblCatatan.setText("Ubah: password kosong = tidak diganti. Setoran dan Tgl Setor (yyyy-MM-dd) khusus Kasir; hanya Admin yang dapat mengubah.");
        lblCatatan.setForeground(new java.awt.Color(100, 116, 139));
        pnlForm.add(lblCatatan);
        lblCatatan.setBounds(10, 118, 900, 22);

        pnlCari.add(pnlForm, java.awt.BorderLayout.PAGE_END);

        pnlTengah.add(pnlCari, java.awt.BorderLayout.NORTH);

        tblPetugas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "Telepon", "Username", "Jabatan", "Detail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrTabel.setViewportView(tblPetugas);

        pnlTengah.add(scrTabel, java.awt.BorderLayout.CENTER);

        add(pnlTengah, java.awt.BorderLayout.CENTER);

        lblPesan.setText(" ");
        add(lblPesan, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbJabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbJabatanActionPerformed
        aturField();
    }//GEN-LAST:event_cmbJabatanActionPerformed

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

    private void aturField() {
        boolean petugas = Konstanta.JABATAN_PETUGAS.equals(cmbJabatan.getSelectedItem());
        cmbWilayah.setEnabled(petugas);
        cmbSpesialis.setEnabled(petugas);
        // status & tanggal setor: hanya untuk Kasir yang sedang dipilih di tabel (akun baru otomatis Belum Setor)
        boolean kasirDipilih = Konstanta.JABATAN_KASIR.equals(cmbJabatan.getSelectedItem()) && Ui.terpilih(tblPetugas) >= 0;
        cmbSetoran.setEnabled(kasirDipilih);
        txtTglSetor.setEnabled(kasirDipilih && Konstanta.SETORAN_SUDAH.equals(cmbSetoran.getSelectedItem()));
    }

    /** Pilih wilayah pada dropdown; null/kosong = belum dipilih. Nilai lama di luar daftar tetap ditampilkan. */
    private void pilihWilayah(String nilai) {
        if (nilai == null || nilai.isBlank()) { cmbWilayah.setSelectedIndex(-1); return; }
        javax.swing.DefaultComboBoxModel m = (javax.swing.DefaultComboBoxModel) cmbWilayah.getModel();
        if (m.getIndexOf(nilai) < 0) m.addElement(nilai);
        cmbWilayah.setSelectedItem(nilai);
    }

    private Karyawan dipilih() {
        int i = Ui.terpilih(tblPetugas);
        if (i < 0) throw new AppException("Pilih akun petugas pada tabel terlebih dahulu.");
        return data.get(i);
    }

    private void tambah() {
        ctrl.buatPetugas(txtNama.getText(), txtTelepon.getText(), txtUsername.getText(), new String(txtPassword.getPassword()),
                (String) cmbJabatan.getSelectedItem(), (String) cmbWilayah.getSelectedItem(), (String) cmbSpesialis.getSelectedItem());
        Ui.info(this, "Akun Berhasil Dibuat");
        muat();
    }

    private void ubah() {
        ctrl.ubahPetugas(dipilih(), txtNama.getText(), txtTelepon.getText(), new String(txtPassword.getPassword()),
                (String) cmbWilayah.getSelectedItem(), (String) cmbSpesialis.getSelectedItem(),
                (String) cmbSetoran.getSelectedItem(), txtTglSetor.getText());
        Ui.info(this, "Data Akun Diperbarui");
        muat();
    }

    private void hapus() {
        Karyawan k = dipilih();
        if (Ui.konfirmasi(this, "Apakah Anda Yakin menghapus akun " + k.getNama() + "?")) {
            ctrl.hapusPetugas(k);
            Ui.info(this, "Akun Berhasil Dihapus");
            muat();
        }
    }

    private void isiForm() {
        int i = Ui.terpilih(tblPetugas);
        if (i < 0 || i >= data.size()) return;
        Karyawan k = data.get(i);
        cmbJabatan.setSelectedItem(k.getPeran());
        cmbJabatan.setEnabled(false);
        txtNama.setText(k.getNama());
        txtTelepon.setText(k.getNoTelepon());
        txtUsername.setText(k.getUsername());
        txtUsername.setEnabled(false);
        txtPassword.setText("");
        if (k instanceof PetugasLapangan p) {
            pilihWilayah(p.getWilayahTugas());
            cmbSpesialis.setSelectedItem(p.getSpesialis());
        } else {
            pilihWilayah(null);
        }
        if (k instanceof Kasir ks) {
            cmbSetoran.setSelectedItem(ks.getStatusSetoran());
            txtTglSetor.setText(ks.getTanggalSetor() == null ? "" : ks.getTanggalSetor().toString());
        } else {
            cmbSetoran.setSelectedItem(Konstanta.SETORAN_BELUM);
            txtTglSetor.setText("");
        }
        aturField();
    }

    private void bersih() {
        tblPetugas.clearSelection();
        txtNama.setText(""); txtTelepon.setText(""); txtUsername.setText(""); pilihWilayah(null);
        txtPassword.setText("");
        cmbSetoran.setSelectedItem(Konstanta.SETORAN_BELUM);
        txtTglSetor.setText("");
        cmbJabatan.setEnabled(true);
        txtUsername.setEnabled(true);
        aturField();
    }

    @Override public void muat() {
        jalankan(() -> {
            data = ctrl.daftarPetugas();
            model.setRowCount(0);
            for (Karyawan k : data) {
                model.addRow(new Object[]{k.getId(), k.getNama(), k.getNoTelepon(), k.getUsername(), k.getPeran(), k.getDetail()});
            }
            lblPesan.setText(data.isEmpty() ? "Tidak Ada Data Petugas" : " ");
            bersih();
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBersihkan;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox cmbJabatan;
    private javax.swing.JComboBox cmbSetoran;
    private javax.swing.JComboBox cmbSpesialis;
    private javax.swing.JComboBox cmbWilayah;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblCatatan;
    private javax.swing.JLabel lblJabatan;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPesan;
    private javax.swing.JLabel lblSetoran;
    private javax.swing.JLabel lblSpesialis;
    private javax.swing.JLabel lblTelepon;
    private javax.swing.JLabel lblTglSetor;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblWilayah;
    private javax.swing.JPanel pnlCari;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JPanel pnlTengah;
    private javax.swing.JScrollPane scrTabel;
    private javax.swing.JTable tblPetugas;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtNama;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtTelepon;
    private javax.swing.JTextField txtTglSetor;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
