package util;

/** Kolom tagihan.bulan di database berisi nama bulan Indonesia ("Oktober"); kode memakai angka 1-12. */
public final class Bulan {
    private Bulan() { }

    public static final String[] NAMA = {"Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"};

    public static String nama(int bulan) { return NAMA[bulan - 1]; }

    /** Menerima nama bulan ("Oktober") maupun angka ("10" / "7"). */
    public static int angka(String s) {
        String v = s == null ? "" : s.trim();
        for (int i = 0; i < NAMA.length; i++) if (NAMA[i].equalsIgnoreCase(v)) return i + 1;
        try {
            int n = Integer.parseInt(v);
            if (n >= 1 && n <= 12) return n;
        } catch (NumberFormatException ignored) { }
        throw new AppException("Nilai bulan pada database tidak dikenal: " + s);
    }

    /** Ekspresi SQL: kolom bulan (nama atau angka) menjadi angka 1-12. */
    public static String sql(String kolom) {
        return "(CASE WHEN " + kolom + " REGEXP '^[0-9]+$' THEN CAST(" + kolom + " AS UNSIGNED) ELSE FIELD(" + kolom
                + ",'Januari','Februari','Maret','April','Mei','Juni','Juli','Agustus','September','Oktober','November','Desember') END)";
    }
}
