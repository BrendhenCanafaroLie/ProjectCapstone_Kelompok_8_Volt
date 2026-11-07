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
        lblJudul.setText("MASUK AKUN");
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

        setPreferredSize(new java.awt.Dimension(380, 230));
        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 235)));
        setLayout(null);

        lblJudul.setBackground(new java.awt.Color(224, 236, 255));
        lblJudul.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        lblJudul.setForeground(new java.awt.Color(11, 31, 75));
        lblJudul.setText("MASUK AKUN");
        lblJudul.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12));
        lblJudul.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblJudul.setOpaque(true);
        add(lblJudul);
        lblJudul.setBounds(130, 20, 140, 28);

        lblUsername.setBackground(new java.awt.Color(0, 0, 0));
        lblUsername.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(0, 0, 0));
        lblUsername.setText("USERNAME");
        add(lblUsername);
        lblUsername.setBounds(30, 65, 90, 22);

        txtUsername.setBackground(new java.awt.Color(243, 247, 255));
        txtUsername.setForeground(new java.awt.Color(30, 41, 59));
        add(txtUsername);
        txtUsername.setBounds(125, 63, 220, 26);

        lblPassword.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(0, 0, 0));
        lblPassword.setText("PASSWORD");
        add(lblPassword);
        lblPassword.setBounds(30, 105, 90, 22);

        txtPassword.setBackground(new java.awt.Color(243, 247, 255));
        txtPassword.setForeground(new java.awt.Color(30, 41, 59));
        add(txtPassword);
        txtPassword.setBounds(125, 103, 220, 26);

        btnMasuk.setBackground(new java.awt.Color(78, 108, 192));
        btnMasuk.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnMasuk.setForeground(new java.awt.Color(255, 255, 255));
        btnMasuk.setText("Masuk");
        btnMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasukActionPerformed(evt);
            }
        });
        add(btnMasuk);
        btnMasuk.setBounds(125, 150, 105, 32);

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
