package view.auth;

import view.BasePanel;
import view.Navigator;


/**
 * Flowchart "Menu Utama": 1. Login, 2. Daftar, 3. Keluar.
 * JPanel Form NetBeans: desain visual ada di PanelMenuUtama.form (buka tab "Design").
 */
public class PanelMenuUtama extends BasePanel {

    private Navigator nav;

    public PanelMenuUtama() {
        initComponents();
        lblJudul.setText("Selamat datang");
        lblSub.setText("Masuk atau daftar untuk melanjutkan.");
    }

    public void setNavigator(Navigator nav) { this.nav = nav; }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJudul = new javax.swing.JLabel();
        lblSub = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnDaftar = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setForeground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(420, 380));
        setLayout(null);

        lblJudul.setFont(new java.awt.Font("SansSerif", 1, 28)); // NOI18N
        lblJudul.setForeground(new java.awt.Color(11, 31, 75));
        lblJudul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJudul.setText("Selamat Datang");
        add(lblJudul);
        lblJudul.setBounds(-10, 30, 420, 60);

        lblSub.setForeground(new java.awt.Color(100, 116, 139));
        lblSub.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSub.setText("Masuk atau daftar untuk melanjutkan.");
        add(lblSub);
        lblSub.setBounds(0, 100, 420, 24);

        btnLogin.setBackground(new java.awt.Color(78, 108, 192));
        btnLogin.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        add(btnLogin);
        btnLogin.setBounds(70, 140, 260, 48);

        btnDaftar.setBackground(new java.awt.Color(16, 142, 62));
        btnDaftar.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        btnDaftar.setForeground(new java.awt.Color(255, 255, 255));
        btnDaftar.setText("Daftar");
        btnDaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaftarActionPerformed(evt);
            }
        });
        add(btnDaftar);
        btnDaftar.setBounds(70, 200, 260, 48);

        btnKeluar.setBackground(new java.awt.Color(176, 47, 47));
        btnKeluar.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        btnKeluar.setForeground(new java.awt.Color(255, 255, 255));
        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });
        add(btnKeluar);
        btnKeluar.setBounds(70, 300, 260, 48);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        nav.tampilLogin();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnDaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaftarActionPerformed
        nav.tampilDaftar();
    }//GEN-LAST:event_btnDaftarActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        nav.keluarAplikasi();
    }//GEN-LAST:event_btnKeluarActionPerformed

    @Override public void muat() { }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDaftar;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblSub;
    // End of variables declaration//GEN-END:variables
}
