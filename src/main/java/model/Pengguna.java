package model;

/** ABSTRAKSI + ENKAPSULASI: induk semua akun yang bisa login. */
public abstract class Pengguna {
    private int id;
    private String nama;
    private String noTelepon;
    private String username;

    protected Pengguna(int id, String nama, String noTelepon, String username) {
        this.id = id; this.nama = nama; this.noTelepon = noTelepon; this.username = username;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getNoTelepon() { return noTelepon; }
    public void setNoTelepon(String noTelepon) { this.noTelepon = noTelepon; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    /** POLIMORFISME: tiap subclass menyebut perannya sendiri. */
    public abstract String getPeran();

    public String getRingkasan() { return getPeran() + " | " + nama + " (" + username + ")"; }
}
