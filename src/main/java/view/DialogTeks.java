package view;

import java.awt.Component;
import javax.swing.SwingUtilities;

/**
 * Dialog menampilkan teks (detail pengaduan, bukti pembayaran, ringkasan tagihan).
 * JDialog Form NetBeans: desain visual ada di DialogTeks.form (buka tab "Design").
 * Kode di dalam blok GEN-BEGIN/GEN-END dibuat otomatis oleh NetBeans, jangan diedit manual.
 */
public class DialogTeks extends javax.swing.JDialog {

    public DialogTeks(Component induk, String judul, String teks) {
        super(induk == null ? null : SwingUtilities.getWindowAncestor(induk));
        initComponents();
        getContentPane().setPreferredSize(new java.awt.Dimension(640, 388));
        pack();
        setTitle(judul);
        txtTeks.setText(teks);
        txtTeks.setCaretPosition(0);
        setLocationRelativeTo(induk);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrTeks = new javax.swing.JScrollPane();
        txtTeks = new javax.swing.JTextArea();
        btnOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detail");
        setModal(true);
        setResizable(false);
        setPreferredSize(new java.awt.Dimension(656, 430));
        getContentPane().setLayout(null);
        txtTeks.setRows(12);
        txtTeks.setColumns(46);
        txtTeks.setEditable(false);
        txtTeks.setLineWrap(true);
        txtTeks.setWrapStyleWord(true);
        txtTeks.setBackground(new java.awt.Color(243, 247, 255));
        txtTeks.setForeground(new java.awt.Color(30, 41, 59));
        txtTeks.setFont(new java.awt.Font("Monospaced", 0, 13));
        txtTeks.setMargin(new java.awt.Insets(8, 10, 8, 10));
        btnOk.setText("OK");
        btnOk.setBackground(new java.awt.Color(29, 78, 216));
        btnOk.setForeground(new java.awt.Color(255, 255, 255));
        btnOk.setFont(new java.awt.Font("SansSerif", 1, 12));
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        scrTeks.setViewportView(txtTeks);
        getContentPane().add(scrTeks);
        scrTeks.setBounds(12, 12, 616, 320);
        getContentPane().add(btnOk);
        btnOk.setBounds(528, 344, 100, 32);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        dispose();
    }//GEN-LAST:event_btnOkActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JScrollPane scrTeks;
    private javax.swing.JTextArea txtTeks;
    // End of variables declaration//GEN-END:variables
}
