package model;

import util.Fmt;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pembayaran implements Cetakable {
    private int id, idTagihan;
    private String noStruk, metode, namaPelanggan, periode, namaKasir;
    private LocalDateTime tanggalBayar;
    private BigDecimal jumlah;
    private Integer idKasir;

    public int getId() { return id; }
    public void setId(int v) { id = v; }
    public int getIdTagihan() { return idTagihan; }
    public void setIdTagihan(int v) { idTagihan = v; }
    public String getNoStruk() { return noStruk; }
    public void setNoStruk(String v) { noStruk = v; }
    public String getMetode() { return metode; }
    public void setMetode(String v) { metode = v; }
    public String getNamaPelanggan() { return namaPelanggan; }
    public void setNamaPelanggan(String v) { namaPelanggan = v; }
    public String getPeriode() { return periode; }
    public void setPeriode(String v) { periode = v; }
    public String getNamaKasir() { return namaKasir; }
    public void setNamaKasir(String v) { namaKasir = v; }
    public LocalDateTime getTanggalBayar() { return tanggalBayar; }
    public void setTanggalBayar(LocalDateTime v) { tanggalBayar = v; }
    public BigDecimal getJumlah() { return jumlah; }
    public void setJumlah(BigDecimal v) { jumlah = v; }
    public Integer getIdKasir() { return idKasir; }
    public void setIdKasir(Integer v) { idKasir = v; }

    @Override public String cetak() {
        return "========= VOLT - BUKTI PEMBAYARAN =========\n"
             + "No. Struk : " + noStruk + "\n"
             + "Tanggal   : " + Fmt.waktu(tanggalBayar) + "\n"
             + "Pelanggan : " + namaPelanggan + "\n"
             + "Periode   : " + periode + "\n"
             + "Metode    : " + metode + "\n"
             + "Kasir     : " + (namaKasir == null ? "Pembayaran Online" : namaKasir) + "\n"
             + "-------------------------------------------\n"
             + "JUMLAH    : " + Fmt.rupiah(jumlah) + "\n"
             + "STATUS    : LUNAS\n"
             + "===========================================";
    }
}
