package model;

public class Admin extends Karyawan {
    private String email;

    public Admin(int id, String nama, String noTelepon, String username, String email) {
        super(id, nama, noTelepon, username);
        this.email = email;
    }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    @Override public String getPeran() { return "Admin"; }
    @Override public String getDetail() { return email; }
}
