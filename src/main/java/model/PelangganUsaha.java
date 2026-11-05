package model;

import util.Konstanta;

public class PelangganUsaha extends Pelanggan {
    private String npwp;
    private String namaUsaha;

    public PelangganUsaha(int id, String nama, String noTelepon, String username, String nomorMeter,
                          String alamat, String statusAkun, int idGolongan, String kodeGolongan,
                          String npwp, String namaUsaha) {
        super(id, nama, noTelepon, username, nomorMeter, alamat, statusAkun, idGolongan, kodeGolongan);
        this.npwp = npwp; this.namaUsaha = namaUsaha;
    }
    public String getNpwp() { return npwp; }
    public void setNpwp(String npwp) { this.npwp = npwp; }
    public String getNamaUsaha() { return namaUsaha; }
    public void setNamaUsaha(String n) { this.namaUsaha = n; }
    @Override public String getJenis() { return Konstanta.JENIS_USAHA; }
    @Override public String getInfoKhusus() { return "NPWP " + npwp + " | Usaha: " + namaUsaha; }
}
