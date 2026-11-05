package view.auth;

import view.BasePanel;
import view.Navigator;

import controller.AuthController;
import model.Pengguna;

/**
 * Flowchart "Login": cek username/password -> cek jabatan -> buka menu sesuai peran.
 * JPanel Form NetBeans: desain visual ada di PanelLogin.form (buka tab "Design").
 * Kode di dalam blok GEN-BEGIN/GEN-END dibuat otomatis oleh NetBeans, jangan diedit manual.
 */
public class PanelLogin extends BasePanel {

    private AuthController auth;
    private Navigator nav;

    public PanelLogin() {
        initComponents();
        lblJudul.setText("Masuk ke akun Anda");
        txtUsername.addActionListener(e -> txtPassword.requestFocusInWindow());
        txtPassword.addActionListener(e -> jalankan(this::masuk));
    }

    public void hubungkan(AuthController auth, Navigator nav) { this.auth = auth; this.nav = nav; }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJudul = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnMasuk = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();

        lblJudul.setText("LOGIN");
        lblJudul.setOpaque(true);
        lblJudul.setBackground(new java.awt.Color(224, 236, 255));
        lblJudul.setForeground(new java.awt.Color(11, 31, 75));
        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 17));
        lblJudul.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12));
        lblUsername.setText("Username");
        lblUsername.setForeground(new java.awt.Color(30, 41, 59));
        txtUsername.setBackground(new java.awt.Color(243, 247, 255));
        txtUsername.setForeground(new java.awt.Color(30, 41, 59));
        lblPassword.setText("Password");
        lblPassword.setForeground(new java.awt.Color(30, 41, 59));
        txtPassword.setBackground(new java.awt.Color(243, 247, 255));
        txtPassword.setForeground(new java.awt.Color(30, 41, 59));
        btnMasuk.setText("Masuk");
        btnMasuk.setBackground(new java.awt.Color(29, 78, 216));
        btnMasuk.setForeground(new java.awt.Color(255, 255, 255));
        btnMasuk.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasukActionPerformed(evt);
            }
        });
        btnKembali.setText("Kembali");
        btnKembali.setBackground(new java.awt.Color(71, 85, 105));
        btnKembali.setForeground(new java.awt.Color(255, 255, 255));
        btnKembali.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });
        setPreferredSize(new java.awt.Dimension(380, 230));
        setOpaque(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 235)));
        setLayout(null);
        add(lblJudul);
        lblJudul.setBounds(20, 15, 340, 28);
        add(lblUsername);
        lblUsername.setBounds(30, 65, 90, 22);
        add(txtUsername);
        txtUsername.setBounds(125, 63, 220, 26);
        add(lblPassword);
        lblPassword.setBounds(30, 105, 90, 22);
        add(txtPassword);
        txtPassword.setBounds(125, 103, 220, 26);
        add(btnMasuk);
        btnMasuk.setBounds(125, 150, 105, 32);
        add(btnKembali);
        btnKembali.setBounds(240, 150, 105, 32);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasukActionPerformed
        jalankan(this::masuk);
    }//GEN-LAST:event_btnMasukActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        nav.tampilMenuUtama();
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void masuk() {
        Pengguna p = auth.login(txtUsername.getText(), new String(txtPassword.getPassword()));
        txtPassword.setText("");
        nav.masuk(p);
    }

    @Override public void muat() {
        txtUsername.setText("");
        txtPassword.setText("");
        txtUsername.requestFocusInWindow();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnMasuk;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
