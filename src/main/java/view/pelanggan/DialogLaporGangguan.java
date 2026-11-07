package view.pelanggan;

import view.Ui;

import controller.PelangganController;
import util.AppException;
import util.Lokasi;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import java.awt.Component;

/**
 * Dialog "Buat Laporan Baru" pada menu Lapor gangguan (pelanggan).
 * JDialog Form NetBeans: desain visual ada di DialogLaporGangguan.form (buka tab "Design").
 * Kode di dalam blok GEN-BEGIN/GEN-END dibuat otomatis oleh NetBeans, jangan diedit manual.
 * Lintang/bujur diambil otomatis dari lokasi pengguna saat dialog dibuka (tombol "Ambil Lokasi" untuk mengulang)
 * dan dapat dikoreksi manual; keduanya wajib terisi (kolom database NOT NULL).
 */
public class DialogLaporGangguan extends javax.swing.JDialog {

    private final PelangganController ctrl;
    private boolean terkirim;

    public DialogLaporGangguan(Component induk, PelangganController ctrl) {
        super(SwingUtilities.getWindowAncestor(induk));
        this.ctrl = ctrl;
        initComponents();
        // Layout null tidak punya ukuran sendiri: tanpa ini jendela menciut jadi hanya batang judul (terutama dengan FlatLaf).
        getContentPane().setPreferredSize(new java.awt.Dimension(660, 372));
        pack();
        setLocationRelativeTo(induk);
        txtLokasi.setText(ctrl.profil().getAlamat());
        ambilLokasi();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLokasi = new javax.swing.JLabel();
        txtLokasi = new javax.swing.JTextField();
        lblDeskripsi = new javax.swing.JLabel();
        scrDeskripsi = new javax.swing.JScrollPane();
        txtDeskripsi = new javax.swing.JTextArea();
        lblLintang = new javax.swing.JLabel();
        txtLintang = new javax.swing.JTextField();
        lblBujur = new javax.swing.JLabel();
        txtBujur = new javax.swing.JTextField();
        btnLokasi = new javax.swing.JButton();
        btnPeta = new javax.swing.JButton();
        lblInfo = new javax.swing.JLabel();
        btnBatal = new javax.swing.JButton();
        btnKirim = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buat Laporan Gangguan");
        setModal(true);
        setPreferredSize(new java.awt.Dimension(670, 410));
        setResizable(false);
        getContentPane().setLayout(null);

        lblLokasi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLokasi.setForeground(new java.awt.Color(30, 41, 59));
        lblLokasi.setText("Lokasi Gangguan");
        getContentPane().add(lblLokasi);
        lblLokasi.setBounds(20, 22, 140, 22);

        txtLokasi.setBackground(new java.awt.Color(243, 247, 255));
        txtLokasi.setForeground(new java.awt.Color(30, 41, 59));
        getContentPane().add(txtLokasi);
        txtLokasi.setBounds(165, 20, 470, 28);

        lblDeskripsi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDeskripsi.setForeground(new java.awt.Color(30, 41, 59));
        lblDeskripsi.setText("Deskripsi");
        getContentPane().add(lblDeskripsi);
        lblDeskripsi.setBounds(20, 62, 140, 22);

        txtDeskripsi.setRows(6);
        txtDeskripsi.setColumns(40);
        txtDeskripsi.setLineWrap(true);
        txtDeskripsi.setWrapStyleWord(true);
        txtDeskripsi.setBackground(new java.awt.Color(243, 247, 255));
        txtDeskripsi.setForeground(new java.awt.Color(30, 41, 59));
        scrDeskripsi.setViewportView(txtDeskripsi);

        getContentPane().add(scrDeskripsi);
        scrDeskripsi.setBounds(165, 60, 470, 130);

        lblLintang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLintang.setForeground(new java.awt.Color(30, 41, 59));
        lblLintang.setText("Lintang *");
        getContentPane().add(lblLintang);
        lblLintang.setBounds(20, 206, 140, 22);

        txtLintang.setBackground(new java.awt.Color(243, 247, 255));
        txtLintang.setForeground(new java.awt.Color(30, 41, 59));
        getContentPane().add(txtLintang);
        txtLintang.setBounds(165, 204, 150, 28);

        lblBujur.setText("Bujur *");
        lblBujur.setForeground(new java.awt.Color(30, 41, 59));
        getContentPane().add(lblBujur);
        lblBujur.setBounds(335, 206, 60, 22);

        txtBujur.setBackground(new java.awt.Color(243, 247, 255));
        txtBujur.setForeground(new java.awt.Color(30, 41, 59));
        getContentPane().add(txtBujur);
        txtBujur.setBounds(400, 204, 235, 28);

        btnLokasi.setText("Lokasi Saya");
        btnLokasi.setBackground(new java.awt.Color(29, 78, 216));
        btnLokasi.setForeground(new java.awt.Color(255, 255, 255));
        btnLokasi.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnLokasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLokasiActionPerformed(evt);
            }
        });
        getContentPane().add(btnLokasi);
        btnLokasi.setBounds(165, 244, 130, 30);

        btnPeta.setText("Pilih di Peta");
        btnPeta.setBackground(new java.awt.Color(13, 148, 136));
        btnPeta.setForeground(new java.awt.Color(255, 255, 255));
        btnPeta.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnPeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPetaActionPerformed(evt);
            }
        });
        getContentPane().add(btnPeta);
        btnPeta.setBounds(305, 244, 130, 30);

        lblInfo.setText(" ");
        lblInfo.setForeground(new java.awt.Color(100, 116, 139));
        getContentPane().add(lblInfo);
        lblInfo.setBounds(165, 278, 470, 22);

        btnBatal.setText("Batal");
        btnBatal.setBackground(new java.awt.Color(71, 85, 105));
        btnBatal.setForeground(new java.awt.Color(255, 255, 255));
        btnBatal.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        getContentPane().add(btnBatal);
        btnBatal.setBounds(385, 316, 120, 34);

        btnKirim.setText("Kirim Laporan");
        btnKirim.setBackground(new java.awt.Color(22, 163, 74));
        btnKirim.setForeground(new java.awt.Color(255, 255, 255));
        btnKirim.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnKirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKirimActionPerformed(evt);
            }
        });
        getContentPane().add(btnKirim);
        btnKirim.setBounds(515, 316, 120, 34);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 670, 370);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLokasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLokasiActionPerformed
        ambilLokasi();
    }//GEN-LAST:event_btnLokasiActionPerformed

    private void btnPetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPetaActionPerformed
        pilihDiPeta();
    }//GEN-LAST:event_btnPetaActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        dispose();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnKirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKirimActionPerformed
        kirim();
    }//GEN-LAST:event_btnKirimActionPerformed

    /** Buka peta; titik awal = koordinat yang sudah terisi (bila ada). */
    private void pilihDiPeta() {
        Double la = null, lo = null;
        try { la = angka(txtLintang.getText(), "Lintang"); lo = angka(txtBujur.getText(), "Bujur"); } catch (AppException e) { la = lo = null; }
        double[] k = DialogPilihPeta.pilih(this, la, lo);
        if (k == null) return;
        txtLintang.setText(String.format(java.util.Locale.US, "%.6f", k[0]));
        txtBujur.setText(String.format(java.util.Locale.US, "%.6f", k[1]));
        lblInfo.setText("Koordinat dipilih dari peta.");
    }

    /** Ambil koordinat di thread latar agar jendela tidak membeku. */
    private void ambilLokasi() {
        btnLokasi.setEnabled(false);
        lblInfo.setText("Mengambil lokasi...");
        new SwingWorker<double[], Void>() {
            @Override protected double[] doInBackground() { return Lokasi.ambil(); }
            @Override protected void done() {
                try {
                    double[] k = get();
                    txtLintang.setText(String.format(java.util.Locale.US, "%.6f", k[0]));
                    txtBujur.setText(String.format(java.util.Locale.US, "%.6f", k[1]));
                    lblInfo.setText("Koordinat terisi dari lokasi Anda (perkiraan).");
                } catch (Exception e) {
                    Throwable c = e.getCause() == null ? e : e.getCause();
                    lblInfo.setText(c.getMessage());
                } finally {
                    btnLokasi.setEnabled(true);
                }
            }
        }.execute();
    }

    private static Double angka(String t, String nama) {
        String v = t.trim().replace(',', '.');
        if (v.isEmpty()) return null;
        try { return Double.parseDouble(v); }
        catch (NumberFormatException e) { throw new AppException(nama + " harus berupa angka."); }
    }

    private void kirim() {
        try {
            ctrl.laporGangguan(txtLokasi.getText(), txtDeskripsi.getText(), angka(txtLintang.getText(), "Lintang"), angka(txtBujur.getText(), "Bujur"));
            terkirim = true;
            Ui.info(this, "Terima Kasih Atas Masukan, Akan Kami Proses Secepatnya");
            dispose();
        } catch (AppException e) {
            Ui.error(this, e.getMessage());
        } catch (RuntimeException e) {
            e.printStackTrace();
            Ui.error(this, "Terjadi kesalahan: " + e.getMessage());
        }
    }

    /** @return true bila laporan berhasil dikirim. */
    public boolean tampil() {
        setVisible(true);
        return terkirim;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnKirim;
    private javax.swing.JButton btnLokasi;
    private javax.swing.JButton btnPeta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBujur;
    private javax.swing.JLabel lblDeskripsi;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblLintang;
    private javax.swing.JLabel lblLokasi;
    private javax.swing.JScrollPane scrDeskripsi;
    private javax.swing.JTextField txtBujur;
    private javax.swing.JTextArea txtDeskripsi;
    private javax.swing.JTextField txtLintang;
    private javax.swing.JTextField txtLokasi;
    // End of variables declaration//GEN-END:variables
}
