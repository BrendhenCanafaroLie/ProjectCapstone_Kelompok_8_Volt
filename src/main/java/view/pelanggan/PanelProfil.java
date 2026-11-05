package view.pelanggan;

import view.BasePanel;
import view.Ui;

import controller.PelangganController;
import model.Pelanggan;

/**
 * Flowchart Pelanggan "Melihat Profil" + ubah alamat / telepon / password.
 * JPanel Form NetBeans: desain visual ada di PanelProfil.form (buka tab "Design").
 * Kode di dalam blok GEN-BEGIN/GEN-END dibuat otomatis oleh NetBeans, jangan diedit manual.
 */
public class PanelProfil extends BasePanel {

    private PelangganController ctrl;

    public PanelProfil(PelangganController ctrl) { this(); this.ctrl = ctrl; }

    public void setController(PelangganController ctrl) { this.ctrl = ctrl; }

    /** Konstruktor tanpa argumen: dipakai GUI Builder agar panel tampil di Design; controller dipasang lewat setController. */
    public PanelProfil() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJudul = new javax.swing.JLabel();
        pnlForm = new javax.swing.JPanel();
        lblMeter = new javax.swing.JLabel();
        txtMeter = new javax.swing.JTextField();
        lblNama = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblJenis = new javax.swing.JLabel();
        txtJenis = new javax.swing.JTextField();
        lblGolongan = new javax.swing.JLabel();
        txtGolongan = new javax.swing.JTextField();
        lblKhusus = new javax.swing.JLabel();
        txtKhusus = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        lblAlamat = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        lblTelepon = new javax.swing.JLabel();
        txtTelepon = new javax.swing.JTextField();
        lblPasswordBaru = new javax.swing.JLabel();
        txtPasswordBaru = new javax.swing.JPasswordField();
        btnSimpan = new javax.swing.JButton();
        lblCatatan = new javax.swing.JLabel();

        lblJudul.setText("Profil Saya");
        lblJudul.setOpaque(true);
        lblJudul.setBackground(new java.awt.Color(224, 236, 255));
        lblJudul.setForeground(new java.awt.Color(11, 31, 75));
        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 17));
        lblJudul.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 12, 8, 12));
        lblMeter.setText("Nomor Meter");
        lblMeter.setForeground(new java.awt.Color(30, 41, 59));
        txtMeter.setEditable(false);
        txtMeter.setBackground(new java.awt.Color(243, 247, 255));
        txtMeter.setForeground(new java.awt.Color(30, 41, 59));
        lblNama.setText("Nama");
        lblNama.setForeground(new java.awt.Color(30, 41, 59));
        txtNama.setEditable(false);
        txtNama.setBackground(new java.awt.Color(243, 247, 255));
        txtNama.setForeground(new java.awt.Color(30, 41, 59));
        lblUsername.setText("Username");
        lblUsername.setForeground(new java.awt.Color(30, 41, 59));
        txtUsername.setEditable(false);
        txtUsername.setBackground(new java.awt.Color(243, 247, 255));
        txtUsername.setForeground(new java.awt.Color(30, 41, 59));
        lblJenis.setText("Jenis Pelanggan");
        lblJenis.setForeground(new java.awt.Color(30, 41, 59));
        txtJenis.setEditable(false);
        txtJenis.setBackground(new java.awt.Color(243, 247, 255));
        txtJenis.setForeground(new java.awt.Color(30, 41, 59));
        lblGolongan.setText("Golongan");
        lblGolongan.setForeground(new java.awt.Color(30, 41, 59));
        txtGolongan.setEditable(false);
        txtGolongan.setBackground(new java.awt.Color(243, 247, 255));
        txtGolongan.setForeground(new java.awt.Color(30, 41, 59));
        lblKhusus.setText("Data Khusus");
        lblKhusus.setForeground(new java.awt.Color(30, 41, 59));
        txtKhusus.setEditable(false);
        txtKhusus.setBackground(new java.awt.Color(243, 247, 255));
        txtKhusus.setForeground(new java.awt.Color(30, 41, 59));
        lblStatus.setText("Status Akun");
        lblStatus.setForeground(new java.awt.Color(30, 41, 59));
        txtStatus.setEditable(false);
        txtStatus.setBackground(new java.awt.Color(243, 247, 255));
        txtStatus.setForeground(new java.awt.Color(30, 41, 59));
        lblAlamat.setText("Alamat");
        lblAlamat.setForeground(new java.awt.Color(30, 41, 59));
        txtAlamat.setBackground(new java.awt.Color(243, 247, 255));
        txtAlamat.setForeground(new java.awt.Color(30, 41, 59));
        lblTelepon.setText("No. Telepon");
        lblTelepon.setForeground(new java.awt.Color(30, 41, 59));
        txtTelepon.setBackground(new java.awt.Color(243, 247, 255));
        txtTelepon.setForeground(new java.awt.Color(30, 41, 59));
        lblPasswordBaru.setText("Password Baru");
        lblPasswordBaru.setForeground(new java.awt.Color(30, 41, 59));
        txtPasswordBaru.setBackground(new java.awt.Color(243, 247, 255));
        txtPasswordBaru.setForeground(new java.awt.Color(30, 41, 59));
        btnSimpan.setText("Simpan Perubahan");
        btnSimpan.setBackground(new java.awt.Color(22, 163, 74));
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        lblCatatan.setText("Password baru kosong = tidak diganti");
        lblCatatan.setForeground(new java.awt.Color(100, 116, 139));
        pnlForm.setBackground(new java.awt.Color(246, 249, 255));
        pnlForm.setLayout(null);
        pnlForm.add(lblMeter);
        lblMeter.setBounds(20, 17, 150, 22);
        pnlForm.add(txtMeter);
        txtMeter.setBounds(180, 15, 380, 26);
        pnlForm.add(lblNama);
        lblNama.setBounds(20, 53, 150, 22);
        pnlForm.add(txtNama);
        txtNama.setBounds(180, 51, 380, 26);
        pnlForm.add(lblUsername);
        lblUsername.setBounds(20, 89, 150, 22);
        pnlForm.add(txtUsername);
        txtUsername.setBounds(180, 87, 380, 26);
        pnlForm.add(lblJenis);
        lblJenis.setBounds(20, 125, 150, 22);
        pnlForm.add(txtJenis);
        txtJenis.setBounds(180, 123, 380, 26);
        pnlForm.add(lblGolongan);
        lblGolongan.setBounds(20, 161, 150, 22);
        pnlForm.add(txtGolongan);
        txtGolongan.setBounds(180, 159, 380, 26);
        pnlForm.add(lblKhusus);
        lblKhusus.setBounds(20, 197, 150, 22);
        pnlForm.add(txtKhusus);
        txtKhusus.setBounds(180, 195, 380, 26);
        pnlForm.add(lblStatus);
        lblStatus.setBounds(20, 233, 150, 22);
        pnlForm.add(txtStatus);
        txtStatus.setBounds(180, 231, 380, 26);
        pnlForm.add(lblAlamat);
        lblAlamat.setBounds(20, 269, 150, 22);
        pnlForm.add(txtAlamat);
        txtAlamat.setBounds(180, 267, 380, 26);
        pnlForm.add(lblTelepon);
        lblTelepon.setBounds(20, 305, 150, 22);
        pnlForm.add(txtTelepon);
        txtTelepon.setBounds(180, 303, 380, 26);
        pnlForm.add(lblPasswordBaru);
        lblPasswordBaru.setBounds(20, 341, 150, 22);
        pnlForm.add(txtPasswordBaru);
        txtPasswordBaru.setBounds(180, 339, 380, 26);
        pnlForm.add(btnSimpan);
        btnSimpan.setBounds(180, 381, 200, 34);
        pnlForm.add(lblCatatan);
        lblCatatan.setBounds(180, 423, 380, 22);
        setPreferredSize(new java.awt.Dimension(700, 560));
        setOpaque(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 235)), javax.swing.BorderFactory.createEmptyBorder(14, 16, 14, 16)));
        setLayout(new java.awt.BorderLayout(10, 10));
        add(lblJudul, java.awt.BorderLayout.NORTH);
        add(pnlForm, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        jalankan(this::simpan);
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void simpan() {
        ctrl.perbaruiProfil(txtAlamat.getText(), txtTelepon.getText(), new String(txtPasswordBaru.getPassword()));
        Ui.info(this, "Profil Berhasil Diperbarui");
        muat();
    }

    @Override public void muat() {
        Pelanggan p = ctrl.profil();
        txtMeter.setText(p.getNomorMeter());
        txtNama.setText(p.getNama());
        txtUsername.setText(p.getUsername());
        txtJenis.setText(p.getJenis());
        txtGolongan.setText(p.getKodeGolongan());
        txtKhusus.setText(p.getInfoKhusus());
        txtStatus.setText(p.getStatusAkun());
        txtAlamat.setText(p.getAlamat());
        txtTelepon.setText(p.getNoTelepon());
        txtPasswordBaru.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel lblAlamat;
    private javax.swing.JLabel lblCatatan;
    private javax.swing.JLabel lblGolongan;
    private javax.swing.JLabel lblJenis;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblKhusus;
    private javax.swing.JLabel lblMeter;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblPasswordBaru;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTelepon;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtGolongan;
    private javax.swing.JTextField txtJenis;
    private javax.swing.JTextField txtKhusus;
    private javax.swing.JTextField txtMeter;
    private javax.swing.JTextField txtNama;
    private javax.swing.JPasswordField txtPasswordBaru;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtTelepon;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
