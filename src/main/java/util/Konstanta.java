package util;

/** Nilai-nilai ENUM / status yang dipakai di database `volt`. Ubah di sini bila skema berubah. */
public final class Konstanta {
    private Konstanta() { }

    // pelanggan.status_akun
    public static final String AKUN_MENUNGGU = "Menunggu";
    public static final String AKUN_AKTIF = "Aktif";
    public static final String AKUN_TIDAK_AKTIF = "Tidak Aktif";

    // pelanggan.jenis_pelanggan
    public static final String JENIS_RT = "Rumah Tangga";
    public static final String JENIS_USAHA = "Usaha";

    // rumah_tangga.kategori_subsidi
    public static final String SUBSIDI = "Subsidi";
    public static final String NON_SUBSIDI = "Non-Subsidi";

    // tagihan.status (varchar)
    // Nilai ini sama dengan isi kolom tagihan.status di database ("Belum Lunas", "Lunas", "Terlambat").
    // Pembacaan tetap toleran terhadap penulisan lama (BELUM_LUNAS, dst.) lewat normStatus().
    public static final String TAGIHAN_BELUM = "Belum Lunas";
    public static final String TAGIHAN_LUNAS = "Lunas";
    public static final String TAGIHAN_TERLAMBAT = "Terlambat"; // dibayar setelah jatuh tempo

    /** Normalisasi status: "Belum Lunas", "belum_lunas", "BELUM LUNAS" -> "BELUM_LUNAS". */
    public static String normStatus(String s) {
        return s == null ? "" : s.trim().toUpperCase().replace(' ', '_');
    }

    /** true bila tagihan masih harus dibayar (apa pun penulisan statusnya). */
    public static boolean belumLunas(String status) {
        return normStatus(TAGIHAN_BELUM).equals(normStatus(status));
    }

    // pembayaran.metode
    public static final String METODE_TUNAI = "Tunai";
    public static final String METODE_DIGITAL = "Digital";

    // pengaduan.status
    public static final String ADUAN_DIAJUKAN = "Dilaporkan";
    public static final String ADUAN_DIPROSES = "Diproses";
    public static final String ADUAN_SELESAI = "Selesai";

    // jabatan (bukan kolom, hanya pilihan di form)
    public static final String JABATAN_PETUGAS = "Petugas Lapangan";
    public static final String JABATAN_KASIR = "Kasir";

    // kasir.status_setoran
    public static final String SETORAN_BELUM = "Belum Setor";
    public static final String SETORAN_SUDAH = "Sudah Setor";

    // petugas_lapangan.spesialis
    public static final String SPES_TEKNISI = "Teknisi";
    public static final String SPES_CATAT = "Catat Meter";
    public static final String SPES_KEDUANYA = "Keduanya";
}
