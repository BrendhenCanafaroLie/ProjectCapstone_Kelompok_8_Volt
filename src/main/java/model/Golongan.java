package model;

import java.math.BigDecimal;

public class Golongan {
    private int id;
    private String kode;
    private int dayaVa;
    private BigDecimal tarifPerKwh;
    private BigDecimal biayaBeban;

    public Golongan(int id, String kode, int dayaVa, BigDecimal tarifPerKwh, BigDecimal biayaBeban) {
        this.id = id; this.kode = kode; this.dayaVa = dayaVa;
        this.tarifPerKwh = tarifPerKwh; this.biayaBeban = biayaBeban;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getKode() { return kode; }
    public void setKode(String kode) { this.kode = kode; }
    public int getDayaVa() { return dayaVa; }
    public void setDayaVa(int dayaVa) { this.dayaVa = dayaVa; }
    public BigDecimal getTarifPerKwh() { return tarifPerKwh; }
    public void setTarifPerKwh(BigDecimal t) { this.tarifPerKwh = t; }
    public BigDecimal getBiayaBeban() { return biayaBeban; }
    public void setBiayaBeban(BigDecimal b) { this.biayaBeban = b; }

    @Override public String toString() { return kode + " - " + dayaVa + " VA - Rp" + tarifPerKwh.stripTrailingZeros().toPlainString() + "/kWh"; }
}
