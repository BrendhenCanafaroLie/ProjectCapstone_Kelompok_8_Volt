package model;

import util.Konstanta;

public class PelangganRumahTangga extends Pelanggan {
    private String nik;
    private String kategoriSubsidi;

    public PelangganRumahTangga(int id, String nama, String noTelepon, String username, String nomorMeter,
                                String alamat, String statusAkun, int idGolongan, String kodeGolongan,
                                String nik, String kategoriSubsidi) {
        super(id, nama, noTelepon, username, nomorMeter, alamat, statusAkun, idGolongan, kodeGolongan);
        this.nik = nik; this.kategoriSubsidi = kategoriSubsidi;
    }
    public String getNik() { return nik; }
    public void setNik(String nik) { this.nik = nik; }
    public String getKategoriSubsidi() { return kategoriSubsidi; }
    public void setKategoriSubsidi(String k) { this.kategoriSubsidi = k; }
    @Override public String getJenis() { return Konstanta.JENIS_RT; }
    @Override public String getDataKhusus() { return atauStrip(nik); }
    @Override public String getKeterangan() { return atauStrip(kategoriSubsidi); }
    @Override public String getInfoKhusus() { return "NIK " + nik + " | Subsidi: " + kategoriSubsidi; }
}
