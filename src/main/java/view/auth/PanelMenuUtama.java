package view.auth;

import view.BasePanel;
import view.Navigator;


/**
 * Flowchart "Menu Utama": 1. Login, 2. Daftar, 3. Keluar.
 * JPanel Form NetBeans: desain visual ada di PanelMenuUtama.form (buka tab "Design").
 * Kode di dalam blok GEN-BEGIN/GEN-END dibuat otomatis oleh NetBeans, jangan diedit manual.
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

        setPreferredSize(new java.awt.Dimension(420, 380));
        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 235)));
        setLayout(null);

        lblJudul.setText("VOLT");
        lblJudul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJudul.setForeground(new java.awt.Color(11, 31, 75));
        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        add(lblJudul);
        lblJudul.setBounds(0, 30, 420, 60);

        lblSub.setText("Sistem Tagihan Listrik");
        lblSub.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSub.setForeground(new java.awt.Color(100, 116, 139));
        add(lblSub);
        lblSub.setBounds(0, 95, 420, 24);

        btnLogin.setText("1. Login");
        btnLogin.setBackground(new java.awt.Color(29, 78, 216));
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        add(btnLogin);
        btnLogin.setBounds(80, 150, 260, 48);

        btnDaftar.setText("2. Daftar");
        btnDaftar.setBackground(new java.awt.Color(22, 163, 74));
        btnDaftar.setForeground(new java.awt.Color(255, 255, 255));
        btnDaftar.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnDaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaftarActionPerformed(evt);
            }
        });
        add(btnDaftar);
        btnDaftar.setBounds(80, 214, 260, 48);

        btnKeluar.setText("3. Keluar");
        btnKeluar.setBackground(new java.awt.Color(220, 38, 38));
        btnKeluar.setForeground(new java.awt.Color(255, 255, 255));
        btnKeluar.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });
        add(btnKeluar);
        btnKeluar.setBounds(80, 278, 260, 48);
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
