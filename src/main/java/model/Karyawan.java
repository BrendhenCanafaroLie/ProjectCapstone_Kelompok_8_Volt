package model;

/** INHERITANCE: Karyawan turunan Pengguna; induk Admin, Kasir, PetugasLapangan. */
public abstract class Karyawan extends Pengguna {
    private String passwordHash; // hanya diisi saat simpan/ubah password

    protected Karyawan(int id, String nama, String noTelepon, String username) {
        super(id, nama, noTelepon, username);
    }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    /** Info khas jabatan untuk ditampilkan di tabel. */
    public abstract String getDetail();
}
