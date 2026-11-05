package model;

import util.Fmt;
import java.time.LocalDateTime;

public class Pengaduan implements Cetakable {
    private int id, idPelanggan;
    private String lokasi, deskripsi, status, namaPelanggan, namaPetugas;
    private LocalDateTime tanggalLapor, tanggalSelesai;
    private Integer idPetugas;
    private Double lintang, bujur;

    public int getId() { return id; }
    public void setId(int v) { id = v; }
    public int getIdPelanggan() { return idPelanggan; }
    public void setIdPelanggan(int v) { idPelanggan = v; }
    public String getLokasi() { return lokasi; }
    public void setLokasi(String v) { lokasi = v; }
    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String v) { deskripsi = v; }
    public String getStatus() { return status; }
    public void setStatus(String v) { status = v; }
    public String getNamaPelanggan() { return namaPelanggan; }
    public void setNamaPelanggan(String v) { namaPelanggan = v; }
    public String getNamaPetugas() { return namaPetugas; }
    public void setNamaPetugas(String v) { namaPetugas = v; }
    public LocalDateTime getTanggalLapor() { return tanggalLapor; }
    public void setTanggalLapor(LocalDateTime v) { tanggalLapor = v; }
    public LocalDateTime getTanggalSelesai() { return tanggalSelesai; }
    public void setTanggalSelesai(LocalDateTime v) { tanggalSelesai = v; }
    public Integer getIdPetugas() { return idPetugas; }
    public void setIdPetugas(Integer v) { idPetugas = v; }

    public Double getLintang() { return lintang; }
    public void setLintang(Double v) { lintang = v; }
    public Double getBujur() { return bujur; }
    public void setBujur(Double v) { bujur = v; }

    @Override public String cetak() {
        return "Pelapor        : " + namaPelanggan + "\n"
             + "Lokasi         : " + lokasi + "\n"
             + "Koordinat      : " + util.Lokasi.format(lintang, bujur) + "\n"
             + "Tanggal Lapor  : " + Fmt.waktu(tanggalLapor) + "\n"
             + "Tanggal Selesai: " + Fmt.waktu(tanggalSelesai) + "\n"
             + "Status         : " + status + "\n"
             + "Petugas        : " + (namaPetugas == null ? "-" : namaPetugas) + "\n\n"
             + "Deskripsi:\n" + deskripsi;
    }
}
