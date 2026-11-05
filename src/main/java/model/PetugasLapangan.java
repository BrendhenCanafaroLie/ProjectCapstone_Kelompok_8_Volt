package model;

public class PetugasLapangan extends Karyawan {
    private String wilayahTugas;
    private String spesialis;

    public PetugasLapangan(int id, String nama, String noTelepon, String username,
                           String wilayahTugas, String spesialis) {
        super(id, nama, noTelepon, username);
        this.wilayahTugas = wilayahTugas; this.spesialis = spesialis;
    }
    public String getWilayahTugas() { return wilayahTugas; }
    public void setWilayahTugas(String w) { this.wilayahTugas = w; }
    public String getSpesialis() { return spesialis; }
    public void setSpesialis(String s) { this.spesialis = s; }
    @Override public String getPeran() { return "Petugas Lapangan"; }
    @Override public String getDetail() { return wilayahTugas + " / " + spesialis; }
}
