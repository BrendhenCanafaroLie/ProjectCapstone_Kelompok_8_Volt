package view.admin;

import view.BasePanel;
import view.Ui;

import util.AppException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import controller.AdminController;
import model.Pelanggan;
import util.Konstanta;

/**
 * Flowchart "Melihat Daftar Registrasi Pengguna" + "Memperbarui Status Akun".
 * JPanel Form NetBeans: desain visual ada di PanelRegistrasi.form (buka tab "Design").
 * Kode di dalam blok GEN-BEGIN/GEN-END dibuat otomatis oleh NetBeans, jangan diedit manual.
 */
public class PanelRegistrasi extends BasePanel {

    private AdminController ctrl;
    private final DefaultTableModel model;
    private List<Pelanggan> data = new ArrayList<>();

    public PanelRegistrasi(AdminController ctrl) { this(); this.ctrl = ctrl; }

    public void setController(AdminController ctrl) { this.ctrl = ctrl; }

    /** Konstruktor tanpa argumen: dipakai GUI Builder agar panel tampil di Design; controller dipasang lewat setController. */
    public PanelRegistrasi() {
        initComponents();
        model = (DefaultTableModel) tblRegistrasi.getModel();
        Ui.siapkanTabel(tblRegistrasi);
        Ui.pasangPencarian(tblRegistrasi, txtCari, lblJumlah, "Cari nama, nomor meter, jenis, NIK/NPWP, keterangan...");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAtas = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        pnlCari = new javax.swing.JPanel();
        lblCari = new javax.swing.JLabel();
        lblJumlah = new javax.swing.JLabel();
        pnlTombol = new javax.swing.JPanel();
        btnSetujui = new javax.swing.JButton();
        btnTolak = new javax.swing.JButton();
        btnMuat = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        scrTabel = new javax.swing.JScrollPane();
        tblRegistrasi = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createCompoundBorder());
        setPreferredSize(new java.awt.Dimension(980, 570));
        setLayout(new java.awt.BorderLayout(10, 10));

        pnlAtas.setLayout(new java.awt.BorderLayout());

        lblJudul.setText("Registrasi Pengguna");
        lblJudul.setOpaque(true);
        lblJudul.setBackground(new java.awt.Color(224, 236, 255));
        lblJudul.setForeground(new java.awt.Color(11, 31, 75));
        lblJudul.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        lblJudul.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 12, 8, 12));
        pnlAtas.add(lblJudul, java.awt.BorderLayout.NORTH);

        pnlCari.setOpaque(false);
        pnlCari.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 8, 0));
        pnlCari.setLayout(new java.awt.BorderLayout(10, 0));

        lblCari.setText("Cari");
        pnlCari.add(lblCari, java.awt.BorderLayout.LINE_START);

        lblJumlah.setText(" ");
        pnlCari.add(lblJumlah, java.awt.BorderLayout.EAST);

        pnlTombol.setPreferredSize(new java.awt.Dimension(100, 44));
        pnlTombol.setBackground(new java.awt.Color(246, 249, 255));
        pnlTombol.setLayout(null);

        btnSetujui.setBackground(new java.awt.Color(22, 163, 74));
        btnSetujui.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnSetujui.setForeground(new java.awt.Color(255, 255, 255));
        btnSetujui.setText("Setujui (Aktifkan Akun)");
        btnSetujui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetujuiActionPerformed(evt);
            }
        });
        pnlTombol.add(btnSetujui);
        btnSetujui.setBounds(10, 10, 210, 32);

        btnTolak.setBackground(new java.awt.Color(220, 38, 38));
        btnTolak.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnTolak.setForeground(new java.awt.Color(255, 255, 255));
        btnTolak.setText("Tolak (Nonaktifkan Akun)");
        btnTolak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTolakActionPerformed(evt);
            }
        });
        pnlTombol.add(btnTolak);
        btnTolak.setBounds(230, 10, 210, 32);

        btnMuat.setBackground(new java.awt.Color(29, 78, 216));
        btnMuat.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnMuat.setForeground(new java.awt.Color(255, 255, 255));
        btnMuat.setText("Muat Ulang");
        btnMuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuatActionPerformed(evt);
            }
        });
        pnlTombol.add(btnMuat);
        btnMuat.setBounds(450, 10, 120, 32);

        pnlCari.add(pnlTombol, java.awt.BorderLayout.PAGE_END);

        txtCari.setToolTipText("Cari nama, nomor meter, username, jenis...");
        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });
        pnlCari.add(txtCari, java.awt.BorderLayout.CENTER);

        pnlAtas.add(pnlCari, java.awt.BorderLayout.SOUTH);

        add(pnlAtas, java.awt.BorderLayout.NORTH);

        tblRegistrasi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "Status", "No. Meter", "Jenis", "Golongan", "Telepon", "Alamat", "Data Khusus", "Keterangan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrTabel.setViewportView(tblRegistrasi);

        add(scrTabel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSetujuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetujuiActionPerformed
        jalankan(this::setujui);
    }//GEN-LAST:event_btnSetujuiActionPerformed

    private void btnTolakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTolakActionPerformed
        jalankan(this::tolak);
    }//GEN-LAST:event_btnTolakActionPerformed

    private void btnMuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuatActionPerformed
        muat();
    }//GEN-LAST:event_btnMuatActionPerformed

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private Pelanggan dipilih() {
        int i = Ui.terpilih(tblRegistrasi);
        if (i < 0) throw new AppException("Pilih akun pengguna pada tabel terlebih dahulu.");
        return data.get(i);
    }

    private void setujui() {
        Pelanggan p = dipilih();
        if (Konstanta.AKUN_AKTIF.equals(p.getStatusAkun())) throw new AppException("Akun ini sudah berstatus Aktif.");
        ctrl.setujui(p);
        Ui.info(this, "Status Akun Diperbarui");
        muat(p.getId());
    }

    private void tolak() {
        Pelanggan p = dipilih();
        if (Konstanta.AKUN_TIDAK_AKTIF.equals(p.getStatusAkun())) throw new AppException("Akun ini sudah berstatus Tidak Aktif.");
        if (Ui.konfirmasi(this, "Tolak pendaftaran " + p.getNama() + "? Akun akan berstatus Tidak Aktif.")) {
            ctrl.tolak(p);
            muat(p.getId());
        }
    }

    @Override public void muat() { muat(-1); }

    /** Semua pendaftar tetap tampil (Menunggu, Aktif, Tidak Aktif); baris {@code pilihId} dipilih lagi setelah dimuat ulang. */
    private void muat(int pilihId) {
        jalankan(() -> {
            data = ctrl.daftarRegistrasi();
            model.setRowCount(0);
            int indeks = -1;
            for (int n = 0; n < data.size(); n++) {
                Pelanggan p = data.get(n);
                if (p.getId() == pilihId) indeks = n;
                model.addRow(new Object[]{p.getId(), p.getNama(), p.getStatusAkun(), p.getNomorMeter(), p.getJenis(),
                        p.getKodeGolongan(), p.getNoTelepon(), p.getAlamat(), p.getDataKhusus(), p.getKeterangan()});
            }
            if (indeks >= 0) {
                int v = tblRegistrasi.convertRowIndexToView(indeks);
                if (v >= 0) tblRegistrasi.setRowSelectionInterval(v, v);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMuat;
    private javax.swing.JButton btnSetujui;
    private javax.swing.JButton btnTolak;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JPanel pnlAtas;
    private javax.swing.JPanel pnlCari;
    private javax.swing.JPanel pnlTombol;
    private javax.swing.JScrollPane scrTabel;
    private javax.swing.JTable tblRegistrasi;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
