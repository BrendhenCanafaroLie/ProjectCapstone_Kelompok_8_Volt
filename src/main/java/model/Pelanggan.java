package model;

public abstract class Pelanggan extends Pengguna {
    private String nomorMeter;
    private String alamat;
    private String statusAkun;
    private int idGolongan;
    private String kodeGolongan;
    private String passwordHash;

    protected Pelanggan(int id, String nama, String noTelepon, String username, String nomorMeter,
                        String alamat, String statusAkun, int idGolongan, String kodeGolongan) {
        super(id, nama, noTelepon, username);
        this.nomorMeter = nomorMeter; this.alamat = alamat; this.statusAkun = statusAkun;
        this.idGolongan = idGolongan; this.kodeGolongan = kodeGolongan;
    }

    public String getNomorMeter() { return nomorMeter; }
    public void setNomorMeter(String v) { this.nomorMeter = v; }
    public String getAlamat() { return alamat; }
    public void setAlamat(String v) { this.alamat = v; }
    public String getStatusAkun() { return statusAkun; }
    public void setStatusAkun(String v) { this.statusAkun = v; }
    public int getIdGolongan() { return idGolongan; }
    public void setIdGolongan(int v) { this.idGolongan = v; }
    public String getKodeGolongan() { return kodeGolongan; }
    public void setKodeGolongan(String v) { this.kodeGolongan = v; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String v) { this.passwordHash = v; }

    @Override public String getPeran() { return "Pelanggan"; }

    /** POLIMORFISME: nilai yang disimpan di kolom jenis_pelanggan. */
    public abstract String getJenis();
    /** POLIMORFISME: ringkasan data khusus (NIK / NPWP). */
    public abstract String getInfoKhusus();
    /** POLIMORFISME: nomor identitas saja, tanpa label (NIK untuk rumah tangga, NPWP untuk usaha). */
    public abstract String getDataKhusus();
    /** POLIMORFISME: keterangan tambahan (kategori subsidi untuk rumah tangga, nama usaha untuk usaha). */
    public abstract String getKeterangan();

    protected static String atauStrip(String v) { return v == null || v.isBlank() ? "-" : v; }
}
