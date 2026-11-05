package model;

import util.Fmt;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Tagihan implements Cetakable {
    private int id, bulan, tahun, idPelanggan, idPetugas;
    private Integer idKasir;
    private BigDecimal meterAwal, meterAkhir, kwh, total;
    private LocalDate jatuhTempo;
    private String status, namaPelanggan, nomorMeter, namaKasir;

    public int getId() { return id; }
    public void setId(int v) { id = v; }
    public int getBulan() { return bulan; }
    public void setBulan(int v) { bulan = v; }
    public int getTahun() { return tahun; }
    public void setTahun(int v) { tahun = v; }
    public int getIdPelanggan() { return idPelanggan; }
    public void setIdPelanggan(int v) { idPelanggan = v; }
    public int getIdPetugas() { return idPetugas; }
    public void setIdPetugas(int v) { idPetugas = v; }
    public Integer getIdKasir() { return idKasir; }
    public void setIdKasir(Integer v) { idKasir = v; }
    public String getNamaKasir() { return namaKasir; }
    public void setNamaKasir(String v) { namaKasir = v; }
    public BigDecimal getMeterAwal() { return meterAwal; }
    public void setMeterAwal(BigDecimal v) { meterAwal = v; }
    public BigDecimal getMeterAkhir() { return meterAkhir; }
    public void setMeterAkhir(BigDecimal v) { meterAkhir = v; }
    public BigDecimal getKwh() { return kwh; }
    public void setKwh(BigDecimal v) { kwh = v; }
    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal v) { total = v; }
    public LocalDate getJatuhTempo() { return jatuhTempo; }
    public void setJatuhTempo(LocalDate v) { jatuhTempo = v; }
    public String getStatus() { return status; }
    public void setStatus(String v) { status = v; }
    public String getNamaPelanggan() { return namaPelanggan; }
    public void setNamaPelanggan(String v) { namaPelanggan = v; }
    public String getNomorMeter() { return nomorMeter; }
    public void setNomorMeter(String v) { nomorMeter = v; }

    public String getPeriode() { return String.format("%02d/%d", bulan, tahun); }

    @Override public String cetak() {
        return "Pelanggan   : " + namaPelanggan + " (" + nomorMeter + ")\n"
             + "Periode     : " + getPeriode() + "\n"
             + "Meter       : " + meterAwal + " -> " + meterAkhir + "\n"
             + "Pemakaian   : " + kwh + " kWh\n"
             + "Total Biaya : " + Fmt.rupiah(total) + "\n"
             + "Jatuh Tempo : " + jatuhTempo + "\n"
             + "Kasir PJ    : " + (namaKasir == null ? "-" : namaKasir) + "\n"
             + "Status      : " + status;
    }
}
