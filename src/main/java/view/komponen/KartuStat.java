package view.komponen;

import java.awt.Color;

/**
 * Kartu ringkasan: judul kecil, angka besar, dan keterangan. Properti judul & aksen bisa diatur dari Designer.
 * JPanel Form NetBeans: desain visual (warna, posisi, ukuran) ada di KartuStat.form (tab "Design").
 */
public class KartuStat extends javax.swing.JPanel {

    public KartuStat() {
        initComponents();
    }

    public String getJudul() { return lblJudul.getText(); }
    public void setJudul(String judul) { lblJudul.setText(judul); }
    public Color getAksen() { return pnlAksen.getBackground(); }
    public void setAksen(Color warna) { pnlAksen.setBackground(warna); }

    public void set(String nilai, String keterangan, Color warna) {
        lblNilai.setText(nilai);
        lblKet.setText(keterangan == null || keterangan.isBlank() ? " " : keterangan);
        lblKet.setForeground(warna);
    }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAksen = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        lblNilai = new javax.swing.JLabel();
        lblKet = new javax.swing.JLabel();

        pnlAksen.setBackground(new java.awt.Color(29, 78, 216));
        pnlAksen.setLayout(null);
        lblJudul.setText("Judul");
        lblJudul.setForeground(new java.awt.Color(100, 116, 139));
        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 11));
        lblNilai.setText("-");
        lblNilai.setForeground(new java.awt.Color(11, 31, 75));
        lblNilai.setFont(new java.awt.Font("Segoe UI", 1, 22));
        lblKet.setText(" ");
        lblKet.setForeground(new java.awt.Color(100, 116, 139));
        lblKet.setFont(new java.awt.Font("Segoe UI", 0, 11));
        setPreferredSize(new java.awt.Dimension(236, 100));
        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 235)));
        setLayout(null);
        add(pnlAksen);
        pnlAksen.setBounds(0, 0, 6, 98);
        add(lblJudul);
        lblJudul.setBounds(18, 10, 206, 18);
        add(lblNilai);
        lblNilai.setBounds(18, 30, 206, 34);
        add(lblKet);
        lblKet.setBounds(18, 68, 206, 20);
    }// </editor-fold>//GEN-END:initComponents

        // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblKet;
    private javax.swing.JLabel lblNilai;
    private javax.swing.JPanel pnlAksen;
    // End of variables declaration//GEN-END:variables
}
