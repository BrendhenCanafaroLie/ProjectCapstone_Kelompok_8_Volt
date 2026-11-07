package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Kasir extends Karyawan {
    private String statusSetoran;
    private LocalDate tanggalSetor; // null bila belum setor

    public Kasir(int id, String nama, String noTelepon, String username, String statusSetoran) {
        this(id, nama, noTelepon, username, statusSetoran, null);
    }

    public Kasir(int id, String nama, String noTelepon, String username, String statusSetoran, LocalDate tanggalSetor) {
        super(id, nama, noTelepon, username);
        this.statusSetoran = statusSetoran;
        this.tanggalSetor = tanggalSetor;
    }
    public String getStatusSetoran() { return statusSetoran; }
    public void setStatusSetoran(String s) { this.statusSetoran = s; }
    public LocalDate getTanggalSetor() { return tanggalSetor; }
    public void setTanggalSetor(LocalDate t) { this.tanggalSetor = t; }
    @Override public String toString() { return getNama() + " (ID " + getId() + ")"; }
    @Override public String getPeran() { return "Kasir"; }
    @Override public String getDetail() {
        return "Setoran: " + statusSetoran
                + (tanggalSetor == null ? "" : " (" + tanggalSetor.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + ")");
    }
}
