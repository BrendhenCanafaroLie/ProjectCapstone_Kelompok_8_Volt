package view.auth;

import view.BasePanel;
import view.Navigator;
import view.Ui;

import controller.AuthController;
import model.Golongan;
import util.Konstanta;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

/**
 * Flowchart "Daftar": data umum -> jenis pelanggan -> NIK+subsidi / NPWP+nama usaha -> antrian validasi admin.
 * JPanel Form NetBeans: desain visual ada di PanelDaftar.form (buka tab "Design").
 * Kode di dalam blok GEN-BEGIN/GEN-END dibuat otomatis oleh NetBeans, jangan diedit manual.
 */
public class PanelDaftar extends BasePanel {

    private AuthController auth;
    private Navigator nav;
    private final ButtonGroup grupJenis = new ButtonGroup();

    public PanelDaftar() {
        initComponents();
        grupJenis.add(radRumahTangga);
        grupJenis.add(radUsaha);
        aturJenis();
    }

    public void hubungkan(AuthController auth, Navigator nav) { this.auth = auth; this.nav = nav; }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJudul = new javax.swing.JLabel();
        lblNomorMeter = new javax.swing.JLabel();
        txtNomorMeter = new javax.swing.JTextField();
        lblNama = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        lblAlamat = new javax.swing.JLabel();
        scrAlamat = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        lblTelepon = new javax.swing.JLabel();
        txtTelepon = new javax.swing.JTextField();
        lblGolongan = new javax.swing.JLabel();
        cmbGolongan = new javax.swing.JComboBox<>();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblJenis = new javax.swing.JLabel();
        radRumahTangga = new javax.swing.JRadioButton();
        radUsaha = new javax.swing.JRadioButton();
        lblNik = new javax.swing.JLabel();
        txtNik = new javax.swing.JTextField();
        lblSubsidi = new javax.swing.JLabel();
        cmbSubsidi = new javax.swing.JComboBox();
        lblNpwp = new javax.swing.JLabel();
        txtNpwp = new javax.swing.JTextField();
        lblNamaUsaha = new javax.swing.JLabel();
        txtNamaUsaha = new javax.swing.JTextField();
        btnDaftar = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(500, 530));
        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 235)));
        setLayout(null);

        lblJudul.setBackground(new java.awt.Color(224, 236, 255));
        lblJudul.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        lblJudul.setForeground(new java.awt.Color(11, 31, 75));
        lblJudul.setText("DAFTAR PELANGGAN BARU");
        lblJudul.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12));
        lblJudul.setOpaque(true);
        add(lblJudul);
        lblJudul.setBounds(150, 10, 250, 28);

        lblNomorMeter.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblNomorMeter.setForeground(new java.awt.Color(30, 41, 59));
        lblNomorMeter.setText("Nomor Meter");
        add(lblNomorMeter);
        lblNomorMeter.setBounds(25, 57, 150, 22);

        txtNomorMeter.setBackground(new java.awt.Color(243, 247, 255));
        txtNomorMeter.setForeground(new java.awt.Color(30, 41, 59));
        add(txtNomorMeter);
        txtNomorMeter.setBounds(180, 55, 290, 26);

        lblNama.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblNama.setForeground(new java.awt.Color(30, 41, 59));
        lblNama.setText("Nama");
        add(lblNama);
        lblNama.setBounds(25, 93, 150, 22);

        txtNama.setBackground(new java.awt.Color(243, 247, 255));
        txtNama.setForeground(new java.awt.Color(30, 41, 59));
        add(txtNama);
        txtNama.setBounds(180, 91, 290, 26);

        lblAlamat.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblAlamat.setForeground(new java.awt.Color(30, 41, 59));
        lblAlamat.setText("Alamat");
        add(lblAlamat);
        lblAlamat.setBounds(25, 129, 150, 22);

        txtAlamat.setRows(3);
        txtAlamat.setColumns(20);
        txtAlamat.setLineWrap(true);
        txtAlamat.setWrapStyleWord(true);
        txtAlamat.setBackground(new java.awt.Color(243, 247, 255));
        txtAlamat.setForeground(new java.awt.Color(30, 41, 59));
        scrAlamat.setViewportView(txtAlamat);

        add(scrAlamat);
        scrAlamat.setBounds(180, 127, 290, 60);

        lblTelepon.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblTelepon.setForeground(new java.awt.Color(0, 0, 0));
        lblTelepon.setText("No. Telepon");
        add(lblTelepon);
        lblTelepon.setBounds(25, 197, 150, 22);

        txtTelepon.setBackground(new java.awt.Color(243, 247, 255));
        txtTelepon.setForeground(new java.awt.Color(30, 41, 59));
        add(txtTelepon);
        txtTelepon.setBounds(180, 195, 290, 26);

        lblGolongan.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblGolongan.setForeground(new java.awt.Color(30, 41, 59));
        lblGolongan.setText("Golongan Tarif");
        add(lblGolongan);
        lblGolongan.setBounds(25, 233, 150, 22);

        cmbGolongan.setBackground(new java.awt.Color(243, 247, 255));
        cmbGolongan.setForeground(new java.awt.Color(30, 41, 59));
        add(cmbGolongan);
        cmbGolongan.setBounds(180, 231, 290, 26);

        lblUsername.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(30, 41, 59));
        lblUsername.setText("Username");
        add(lblUsername);
        lblUsername.setBounds(25, 269, 150, 22);

        txtUsername.setBackground(new java.awt.Color(243, 247, 255));
        txtUsername.setForeground(new java.awt.Color(30, 41, 59));
        add(txtUsername);
        txtUsername.setBounds(180, 267, 290, 26);

        lblPassword.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(30, 41, 59));
        lblPassword.setText("Password (6-10)");
        add(lblPassword);
        lblPassword.setBounds(25, 305, 150, 22);

        txtPassword.setBackground(new java.awt.Color(243, 247, 255));
        txtPassword.setForeground(new java.awt.Color(30, 41, 59));
        add(txtPassword);
        txtPassword.setBounds(180, 303, 290, 26);

        lblJenis.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblJenis.setForeground(new java.awt.Color(30, 41, 59));
        lblJenis.setText("Jenis Pelanggan");
        add(lblJenis);
        lblJenis.setBounds(25, 345, 150, 22);

        radRumahTangga.setForeground(new java.awt.Color(30, 41, 59));
        radRumahTangga.setSelected(true);
        radRumahTangga.setText("Rumah Tangga");
        radRumahTangga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radRumahTanggaActionPerformed(evt);
            }
        });
        add(radRumahTangga);
        radRumahTangga.setBounds(180, 343, 140, 24);

        radUsaha.setForeground(new java.awt.Color(30, 41, 59));
        radUsaha.setText("Usaha");
        radUsaha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radUsahaActionPerformed(evt);
            }
        });
        add(radUsaha);
        radUsaha.setBounds(325, 343, 100, 24);

        lblNik.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblNik.setForeground(new java.awt.Color(30, 41, 59));
        lblNik.setText("NIK (16 digit)");
        add(lblNik);
        lblNik.setBounds(30, 380, 150, 22);

        txtNik.setBackground(new java.awt.Color(243, 247, 255));
        txtNik.setForeground(new java.awt.Color(30, 41, 59));
        add(txtNik);
        txtNik.setBounds(180, 380, 290, 26);

        lblSubsidi.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblSubsidi.setForeground(new java.awt.Color(30, 41, 59));
        lblSubsidi.setText("Kategori Subsidi");
        add(lblSubsidi);
        lblSubsidi.setBounds(30, 420, 150, 22);

        cmbSubsidi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Subsidi", "Non-Subsidi" }));
        cmbSubsidi.setBackground(new java.awt.Color(243, 247, 255));
        cmbSubsidi.setForeground(new java.awt.Color(30, 41, 59));
        add(cmbSubsidi);
        cmbSubsidi.setBounds(180, 416, 290, 26);

        lblNpwp.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblNpwp.setForeground(new java.awt.Color(30, 41, 59));
        lblNpwp.setText("NPWP");
        add(lblNpwp);
        lblNpwp.setBounds(30, 380, 150, 22);

        txtNpwp.setBackground(new java.awt.Color(243, 247, 255));
        txtNpwp.setForeground(new java.awt.Color(30, 41, 59));
        add(txtNpwp);
        txtNpwp.setBounds(180, 380, 290, 26);

        lblNamaUsaha.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblNamaUsaha.setForeground(new java.awt.Color(30, 41, 59));
        lblNamaUsaha.setText("Nama Usaha");
        add(lblNamaUsaha);
        lblNamaUsaha.setBounds(25, 418, 150, 22);

        txtNamaUsaha.setBackground(new java.awt.Color(243, 247, 255));
        txtNamaUsaha.setForeground(new java.awt.Color(30, 41, 59));
        add(txtNamaUsaha);
        txtNamaUsaha.setBounds(180, 416, 290, 26);

        btnDaftar.setBackground(new java.awt.Color(45, 165, 89));
        btnDaftar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnDaftar.setForeground(new java.awt.Color(255, 255, 255));
        btnDaftar.setText("Daftar");
        btnDaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaftarActionPerformed(evt);
            }
        });
        add(btnDaftar);
        btnDaftar.setBounds(180, 470, 140, 34);

        btnKembali.setBackground(new java.awt.Color(71, 85, 105));
        btnKembali.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnKembali.setForeground(new java.awt.Color(255, 255, 255));
        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });
        add(btnKembali);
        btnKembali.setBounds(330, 470, 140, 34);
    }// </editor-fold>//GEN-END:initComponents

    private void radRumahTanggaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radRumahTanggaActionPerformed
        aturJenis();
    }//GEN-LAST:event_radRumahTanggaActionPerformed

    private void radUsahaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radUsahaActionPerformed
        aturJenis();
    }//GEN-LAST:event_radUsahaActionPerformed

    private void btnDaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaftarActionPerformed
        jalankan(this::daftar);
    }//GEN-LAST:event_btnDaftarActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        nav.tampilMenuUtama();
    }//GEN-LAST:event_btnKembaliActionPerformed

    /** Tampilkan field NIK/Subsidi (rumah tangga) atau NPWP/Nama Usaha (usaha). */
    private void aturJenis() {
        boolean rt = radRumahTangga.isSelected();
        lblNik.setVisible(rt); txtNik.setVisible(rt);
        lblSubsidi.setVisible(rt); cmbSubsidi.setVisible(rt);
        lblNpwp.setVisible(!rt); txtNpwp.setVisible(!rt);
        lblNamaUsaha.setVisible(!rt); txtNamaUsaha.setVisible(!rt);
    }

    private void daftar() {
        Golongan g = (Golongan) cmbGolongan.getSelectedItem();
        String pass = new String(txtPassword.getPassword());
        if (radRumahTangga.isSelected()) {
            auth.daftarRumahTangga(txtNomorMeter.getText(), txtNama.getText(), txtAlamat.getText(), txtTelepon.getText(),
                    txtUsername.getText(), pass, g, txtNik.getText(), String.valueOf(cmbSubsidi.getSelectedItem()));
        } else {
            auth.daftarUsaha(txtNomorMeter.getText(), txtNama.getText(), txtAlamat.getText(), txtTelepon.getText(),
                    txtUsername.getText(), pass, g, txtNpwp.getText(), txtNamaUsaha.getText());
        }
        Ui.info(this, "Pendaftaran berhasil dikirim.\nAkun masuk antrian validasi admin.\n"
                + "Silakan login setelah akun disetujui.");
        bersih();
        nav.tampilMenuUtama();
    }

    private void bersih() {
        for (javax.swing.text.JTextComponent t : new javax.swing.text.JTextComponent[]{txtNomorMeter, txtNama, txtAlamat,
                txtTelepon, txtUsername, txtPassword, txtNik, txtNpwp, txtNamaUsaha}) {
            t.setText("");
        }
        radRumahTangga.setSelected(true);
        aturJenis();
    }

    @Override public void muat() {
        jalankan(() -> {
            cmbGolongan.removeAllItems();
            for (Golongan g : auth.daftarGolongan()) cmbGolongan.addItem(g);
        });
        bersih();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDaftar;
    private javax.swing.JButton btnKembali;
    private javax.swing.JComboBox<model.Golongan> cmbGolongan;
    private javax.swing.JComboBox cmbSubsidi;
    private javax.swing.JLabel lblAlamat;
    private javax.swing.JLabel lblGolongan;
    private javax.swing.JLabel lblJenis;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNamaUsaha;
    private javax.swing.JLabel lblNik;
    private javax.swing.JLabel lblNomorMeter;
    private javax.swing.JLabel lblNpwp;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSubsidi;
    private javax.swing.JLabel lblTelepon;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JRadioButton radRumahTangga;
    private javax.swing.JRadioButton radUsaha;
    private javax.swing.JScrollPane scrAlamat;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNamaUsaha;
    private javax.swing.JTextField txtNik;
    private javax.swing.JTextField txtNomorMeter;
    private javax.swing.JTextField txtNpwp;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtTelepon;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
