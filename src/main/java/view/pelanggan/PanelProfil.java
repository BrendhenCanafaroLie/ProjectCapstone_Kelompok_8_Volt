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

        setPreferredSize(new java.awt.Dimension(700, 560));
        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createCompoundBorder());
        setLayout(new java.awt.BorderLayout(10, 10));

        lblJudul.setText("Profil Saya");
        lblJudul.setOpaque(true);
        lblJudul.setBackground(new java.awt.Color(224, 236, 255));
        lblJudul.setForeground(new java.awt.Color(11, 31, 75));
        lblJudul.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        lblJudul.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 12, 8, 12));
        add(lblJudul, java.awt.BorderLayout.NORTH);

        pnlForm.setBackground(new java.awt.Color(246, 249, 255));
        pnlForm.setLayout(null);

        lblMeter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMeter.setForeground(new java.awt.Color(30, 41, 59));
        lblMeter.setText("Nomor Meter");
        pnlForm.add(lblMeter);
        lblMeter.setBounds(20, 17, 150, 22);

        txtMeter.setEditable(false);
        txtMeter.setBackground(new java.awt.Color(243, 247, 255));
        txtMeter.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(txtMeter);
        txtMeter.setBounds(180, 15, 380, 26);

        lblNama.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNama.setForeground(new java.awt.Color(30, 41, 59));
        lblNama.setText("Nama");
        pnlForm.add(lblNama);
        lblNama.setBounds(20, 53, 150, 22);

        txtNama.setEditable(false);
        txtNama.setBackground(new java.awt.Color(243, 247, 255));
        txtNama.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(txtNama);
        txtNama.setBounds(180, 51, 380, 26);

        lblUsername.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(30, 41, 59));
        lblUsername.setText("Username");
        pnlForm.add(lblUsername);
        lblUsername.setBounds(20, 89, 150, 22);

        txtUsername.setBackground(new java.awt.Color(243, 247, 255));
        txtUsername.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(txtUsername);
        txtUsername.setBounds(180, 87, 380, 26);

        lblJenis.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblJenis.setForeground(new java.awt.Color(30, 41, 59));
        lblJenis.setText("Jenis Pelanggan");
        pnlForm.add(lblJenis);
        lblJenis.setBounds(20, 125, 150, 22);

        txtJenis.setEditable(false);
        txtJenis.setBackground(new java.awt.Color(243, 247, 255));
        txtJenis.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(txtJenis);
        txtJenis.setBounds(180, 123, 380, 26);

        lblGolongan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGolongan.setForeground(new java.awt.Color(30, 41, 59));
        lblGolongan.setText("Golongan");
        pnlForm.add(lblGolongan);
        lblGolongan.setBounds(20, 161, 150, 20);

        txtGolongan.setEditable(false);
        txtGolongan.setBackground(new java.awt.Color(243, 247, 255));
        txtGolongan.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(txtGolongan);
        txtGolongan.setBounds(180, 159, 380, 26);

        lblKhusus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblKhusus.setForeground(new java.awt.Color(30, 41, 59));
        lblKhusus.setText("Data Khusus");
        pnlForm.add(lblKhusus);
        lblKhusus.setBounds(20, 197, 150, 22);

        txtKhusus.setEditable(false);
        txtKhusus.setBackground(new java.awt.Color(243, 247, 255));
        txtKhusus.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(txtKhusus);
        txtKhusus.setBounds(180, 195, 380, 26);

        lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(30, 41, 59));
        lblStatus.setText("Status Akun");
        pnlForm.add(lblStatus);
        lblStatus.setBounds(20, 233, 150, 22);

        txtStatus.setEditable(false);
        txtStatus.setBackground(new java.awt.Color(243, 247, 255));
        txtStatus.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(txtStatus);
        txtStatus.setBounds(180, 231, 380, 26);

        lblAlamat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAlamat.setForeground(new java.awt.Color(30, 41, 59));
        lblAlamat.setText("Alamat");
        pnlForm.add(lblAlamat);
        lblAlamat.setBounds(20, 269, 150, 22);

        txtAlamat.setBackground(new java.awt.Color(243, 247, 255));
        txtAlamat.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(txtAlamat);
        txtAlamat.setBounds(180, 267, 380, 26);

        lblTelepon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTelepon.setForeground(new java.awt.Color(30, 41, 59));
        lblTelepon.setText("No. Telepon");
        pnlForm.add(lblTelepon);
        lblTelepon.setBounds(20, 305, 150, 22);

        txtTelepon.setBackground(new java.awt.Color(243, 247, 255));
        txtTelepon.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(txtTelepon);
        txtTelepon.setBounds(180, 303, 380, 26);

        lblPasswordBaru.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPasswordBaru.setForeground(new java.awt.Color(30, 41, 59));
        lblPasswordBaru.setText("Password Baru");
        pnlForm.add(lblPasswordBaru);
        lblPasswordBaru.setBounds(20, 341, 150, 22);

        txtPasswordBaru.setBackground(new java.awt.Color(243, 247, 255));
        txtPasswordBaru.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(txtPasswordBaru);
        txtPasswordBaru.setBounds(180, 339, 380, 26);

        btnSimpan.setBackground(new java.awt.Color(22, 163, 74));
        btnSimpan.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("Simpan Perubahan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        pnlForm.add(btnSimpan);
        btnSimpan.setBounds(180, 381, 200, 34);

        add(pnlForm, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        jalankan(this::simpan);
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void simpan() {
        ctrl.perbaruiProfil(txtUsername.getText(), txtAlamat.getText(), txtTelepon.getText(), new String(txtPasswordBaru.getPassword()));
        Ui.info(this, "Profil Berhasil Diperbarui");
        muat();
        // Judul jendela memuat username, jadi ikut diperbarui.
        if (javax.swing.SwingUtilities.getWindowAncestor(this) instanceof javax.swing.JFrame f) {
            f.setTitle("VOLT - " + ctrl.profil().getRingkasan());
        }
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
