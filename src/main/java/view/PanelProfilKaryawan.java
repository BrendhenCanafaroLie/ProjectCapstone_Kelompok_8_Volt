package view;

import controller.ProfilKaryawanController;
import model.*;

/**
 * Profil akun sendiri untuk Admin, Kasir, dan Petugas Lapangan. Semua data hanya-baca, kecuali email Admin.
 * JPanel Form NetBeans: desain visual (warna, posisi, ukuran) ada di PanelProfilKaryawan.form (tab "Design").
 */
public class PanelProfilKaryawan extends BasePanel {

    private ProfilKaryawanController ctrl;
    /** Tombol "Simpan Email" hanya untuk Admin: dibuat lewat kode agar tidak tampil di Design / menu petugas & kasir. */
    private javax.swing.JButton btnSimpan;

    public PanelProfilKaryawan(ProfilKaryawanController ctrl) { this(); this.ctrl = ctrl; }

    public void setController(ProfilKaryawanController ctrl) { this.ctrl = ctrl; }

    /** Konstruktor tanpa argumen: dipakai GUI Builder agar panel tampil di Design; controller dipasang lewat setController. */
    public PanelProfilKaryawan() {
        initComponents();
    }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJudul = new javax.swing.JLabel();
        pnlForm = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblJabatan = new javax.swing.JLabel();
        txtJabatan = new javax.swing.JTextField();
        lblNama = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblTelepon = new javax.swing.JLabel();
        txtTelepon = new javax.swing.JTextField();
        lblEkstra1 = new javax.swing.JLabel();
        txtEkstra1 = new javax.swing.JTextField();
        lblEkstra2 = new javax.swing.JLabel();
        txtEkstra2 = new javax.swing.JTextField();
        lblCatatan = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(980, 520));
        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createCompoundBorder());
        setLayout(new java.awt.BorderLayout(10, 10));

        lblJudul.setText("Profil Saya");
        lblJudul.setForeground(new java.awt.Color(11, 31, 75));
        lblJudul.setOpaque(true);
        lblJudul.setBackground(new java.awt.Color(224, 236, 255));
        lblJudul.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        lblJudul.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 12, 8, 12));
        add(lblJudul, java.awt.BorderLayout.NORTH);

        pnlForm.setBackground(new java.awt.Color(246, 249, 255));
        pnlForm.setLayout(null);

        lblId.setText("ID Karyawan");
        lblId.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(lblId);
        lblId.setBounds(20, 23, 130, 22);

        txtId.setEditable(false);
        txtId.setBackground(new java.awt.Color(243, 247, 255));
        txtId.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(txtId);
        txtId.setBounds(160, 20, 340, 28);

        lblJabatan.setText("Jabatan");
        lblJabatan.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(lblJabatan);
        lblJabatan.setBounds(20, 67, 130, 22);

        txtJabatan.setEditable(false);
        txtJabatan.setBackground(new java.awt.Color(243, 247, 255));
        txtJabatan.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(txtJabatan);
        txtJabatan.setBounds(160, 64, 340, 28);

        lblNama.setText("Nama");
        lblNama.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(lblNama);
        lblNama.setBounds(20, 111, 130, 22);

        txtNama.setEditable(false);
        txtNama.setBackground(new java.awt.Color(243, 247, 255));
        txtNama.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(txtNama);
        txtNama.setBounds(160, 108, 340, 28);

        lblUsername.setText("Username");
        lblUsername.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(lblUsername);
        lblUsername.setBounds(20, 155, 130, 22);

        txtUsername.setEditable(false);
        txtUsername.setBackground(new java.awt.Color(243, 247, 255));
        txtUsername.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(txtUsername);
        txtUsername.setBounds(160, 152, 340, 28);

        lblTelepon.setText("No. Telepon");
        lblTelepon.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(lblTelepon);
        lblTelepon.setBounds(20, 199, 130, 22);

        txtTelepon.setEditable(false);
        txtTelepon.setBackground(new java.awt.Color(243, 247, 255));
        txtTelepon.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(txtTelepon);
        txtTelepon.setBounds(160, 196, 340, 28);

        lblEkstra1.setText("Ekstra 1");
        lblEkstra1.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(lblEkstra1);
        lblEkstra1.setBounds(20, 243, 130, 22);

        txtEkstra1.setBackground(new java.awt.Color(243, 247, 255));
        txtEkstra1.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(txtEkstra1);
        txtEkstra1.setBounds(160, 240, 340, 28);

        lblEkstra2.setText("Ekstra 2");
        lblEkstra2.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(lblEkstra2);
        lblEkstra2.setBounds(20, 287, 130, 22);

        txtEkstra2.setEditable(false);
        txtEkstra2.setBackground(new java.awt.Color(243, 247, 255));
        txtEkstra2.setForeground(new java.awt.Color(30, 41, 59));
        pnlForm.add(txtEkstra2);
        txtEkstra2.setBounds(160, 284, 340, 28);

        lblCatatan.setText(" ");
        lblCatatan.setForeground(new java.awt.Color(100, 116, 139));
        pnlForm.add(lblCatatan);
        lblCatatan.setBounds(160, 382, 560, 22);

        add(pnlForm, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private javax.swing.JButton tombolSimpan() {
        if (btnSimpan == null) {
            btnSimpan = new javax.swing.JButton("Simpan Email");
            btnSimpan.setBackground(new java.awt.Color(22, 163, 74));
            btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
            btnSimpan.setFont(new java.awt.Font("SansSerif", 1, 12));
            btnSimpan.addActionListener(e -> jalankan(this::simpan));
            pnlForm.add(btnSimpan);
            btnSimpan.setBounds(160, 336, 160, 34);
        }
        return btnSimpan;
    }

    private void simpan() {
        ctrl.ubahEmail(txtEkstra1.getText());
        Ui.info(this, "Email Berhasil Diperbarui");
        muat();
    }

    private void ekstra(int no, String label, String nilai, boolean boleh) {
        javax.swing.JLabel l = no == 1 ? lblEkstra1 : lblEkstra2;
        javax.swing.JTextField t = no == 1 ? txtEkstra1 : txtEkstra2;
        l.setVisible(label != null);
        t.setVisible(label != null);
        if (label == null) return;
        l.setText(label);
        t.setText(nilai == null ? "" : nilai);
        t.setEditable(boleh);
    }

    @Override public void muat() {
        Karyawan k = ctrl.profil();
        txtId.setText(String.valueOf(k.getId()));
        txtJabatan.setText(k.getPeran());
        txtNama.setText(k.getNama());
        txtUsername.setText(k.getUsername());
        txtTelepon.setText(k.getNoTelepon());
        ekstra(1, null, null, false);
        ekstra(2, null, null, false);
        if (btnSimpan != null) btnSimpan.setVisible(k instanceof Admin);
        if (k instanceof Admin a) {
            tombolSimpan().setVisible(true);
            ekstra(1, "Email", a.getEmail(), true);
            lblCatatan.setText("Admin hanya dapat mengubah email akunnya sendiri.");
        } else {
            if (k instanceof Kasir ks) {
                ekstra(1, "Status Setoran", ks.getStatusSetoran(), false);
                ekstra(2, "Tanggal Setor", ks.getTanggalSetor() == null ? "-" : ks.getTanggalSetor().toString(), false);
            }
            else if (k instanceof PetugasLapangan p) {
                ekstra(1, "Wilayah Tugas", p.getWilayahTugas(), false);
                ekstra(2, "Spesialis", p.getSpesialis(), false);
            }
            lblCatatan.setText("Data akun hanya dapat dilihat. Hubungi Admin bila ada yang perlu diperbaiki.");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblCatatan;
    private javax.swing.JLabel lblEkstra1;
    private javax.swing.JLabel lblEkstra2;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblJabatan;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblTelepon;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JTextField txtEkstra1;
    private javax.swing.JTextField txtEkstra2;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtJabatan;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtTelepon;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
