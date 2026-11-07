package view;

import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableRowSorter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Pengurut (sorting) tabel yang dipakai semua JTable di aplikasi.
 * <p>
 * Semua kolom pada DefaultTableModel bertipe Object, sehingga bawaan Swing mengurutkannya sebagai teks
 * ("10" tampil sebelum "2", "Rp1.000" sebelum "Rp200", "05-01-2026" sebelum "20-12-2025").
 * Di sini nilai sel dikenali dulu menurut isinya:
 * <ul>
 *   <li>angka (Integer, BigDecimal, "12.5", "1,5") -> diurutkan sebagai angka;</li>
 *   <li>rupiah ("Rp135.200", "Rp376.901,30", "-Rp5.000") -> diurutkan menurut nilainya;</li>
 *   <li>tanggal/waktu (LocalDate, LocalDateTime, "dd-MM-yyyy HH:mm", "yyyy-MM-dd", "d MMM yyyy") -> menurut kalender;</li>
 *   <li>periode "MM/yyyy" -> tahun dahulu, baru bulan;</li>
 *   <li>teks -> tidak membedakan huruf besar/kecil, angka di dalam teks dibaca sebagai angka (MTR-2 sebelum MTR-10);</li>
 *   <li>kosong / "-" -> dianggap paling kecil.</li>
 * </ul>
 * Angka selalu di depan teks pada kolom yang bercampur, sehingga urutannya konsisten.
 */
public final class PengurutTabel {
    private PengurutTabel() { }

    /** Pembanding umum untuk semua kolom tabel. */
    public static final Comparator<Object> URUTAN = PengurutTabel::banding;

    // ---------- Pemasangan

    /** Pasang pembanding ke pengurut JTable (dipanggil setelah setAutoCreateRowSorter(true)). */
    public static void pasang(JTable t) {
        terapkan(t.getRowSorter(), t.getModel().getColumnCount());
        // Jumlah/judul kolom berubah -> pengurut baru dibuat Swing; pasang ulang pembanding.
        t.getModel().addTableModelListener(e -> {
            if (e.getFirstRow() == TableModelEvent.HEADER_ROW) {
                SwingUtilities.invokeLater(() -> terapkan(t.getRowSorter(), t.getModel().getColumnCount()));
            }
        });
    }

    /** Pasang pembanding ke setiap kolom pengurut tabel. */
    public static void terapkan(javax.swing.RowSorter<?> rs, int jumlahKolom) {
        if (rs instanceof TableRowSorter<?> s) {
            for (int c = 0; c < jumlahKolom; c++) s.setComparator(c, URUTAN);
        }
    }

    // ---------- Pembanding

    private static int banding(Object a, Object b) {
        Object x = kunci(a), y = kunci(b);
        if (x == null || y == null) return x == y ? 0 : x == null ? -1 : 1;
        boolean nx = x instanceof BigDecimal, ny = y instanceof BigDecimal;
        if (nx && ny) return ((BigDecimal) x).compareTo((BigDecimal) y);
        if (nx) return -1;
        if (ny) return 1;
        return alami((String) x, (String) y);
    }

    /** BigDecimal untuk nilai angka/tanggal, String (huruf kecil) untuk teks, null untuk kosong. */
    private static Object kunci(Object v) {
        if (v == null) return null;
        if (v instanceof BigDecimal d) return d;
        if (v instanceof Integer || v instanceof Long || v instanceof Short || v instanceof Byte) {
            return BigDecimal.valueOf(((Number) v).longValue());
        }
        if (v instanceof BigInteger bi) return new BigDecimal(bi);
        if (v instanceof Number n) {
            try { return new BigDecimal(n.toString()); } catch (NumberFormatException e) { return n.toString(); }
        }
        if (v instanceof Boolean bo) return BigDecimal.valueOf(bo ? 1 : 0);
        if (v instanceof LocalDateTime ldt) return menit(ldt);
        if (v instanceof LocalDate ld) return menit(ld.atStartOfDay());
        if (v instanceof java.sql.Timestamp ts) return menit(ts.toLocalDateTime());
        if (v instanceof java.sql.Date sd) return menit(sd.toLocalDate().atStartOfDay());
        return teks(v.toString());
    }

    private static final Pattern TGL_ID = Pattern.compile("^(\\d{1,2})-(\\d{1,2})-(\\d{4})(?:\\s+(\\d{1,2}):(\\d{2}))?$");
    private static final Pattern TGL_ISO = Pattern.compile("^(\\d{4})-(\\d{1,2})-(\\d{1,2})(?:[ T](\\d{1,2}):(\\d{2}))?.*$");
    private static final Pattern TGL_PENDEK = Pattern.compile("^(\\d{1,2})\\s+(\\p{L}{3,9})\\.?\\s+(\\d{4})$");
    private static final Pattern PERIODE = Pattern.compile("^(\\d{1,2})/(\\d{4})$");
    private static final Pattern RUPIAH = Pattern.compile("^(-?)Rp(-?)(\\d[\\d.,]*)$");
    private static final Pattern ANGKA = Pattern.compile("^[-+]?\\d+(?:[.,]\\d+)*$");

    private static Object teks(String mentah) {
        String s = mentah.replace('\u00A0', ' ').trim();
        if (s.isEmpty() || s.equals("-") || s.equals("\u2014")) return null;
        try {
            Matcher m;
            if ((m = TGL_ID.matcher(s)).matches()) {
                return menit(LocalDateTime.of(i(m, 3), i(m, 2), i(m, 1), m.group(4) == null ? 0 : i(m, 4), m.group(5) == null ? 0 : i(m, 5)));
            }
            if ((m = TGL_ISO.matcher(s)).matches()) {
                return menit(LocalDateTime.of(i(m, 1), i(m, 2), i(m, 3), m.group(4) == null ? 0 : i(m, 4), m.group(5) == null ? 0 : i(m, 5)));
            }
            if ((m = PERIODE.matcher(s)).matches()) {
                return menit(LocalDateTime.of(i(m, 2), i(m, 1), 1, 0, 0));
            }
            if ((m = TGL_PENDEK.matcher(s)).matches()) {
                int bulan = bulanDariNama(m.group(2));
                if (bulan > 0) return menit(LocalDateTime.of(i(m, 3), bulan, i(m, 1), 0, 0));
            }
            String rapat = s.replaceAll("\\s+", "");
            if ((m = RUPIAH.matcher(rapat)).matches()) {
                BigDecimal n = new BigDecimal(m.group(3).replace(".", "").replace(',', '.'));
                return (m.group(1).isEmpty() && m.group(2).isEmpty()) ? n : n.negate();
            }
            if (ANGKA.matcher(rapat).matches() && !rapat.matches("^[-+]?0\\d+$")) {   // "0812..." (nomor) tetap teks
                return new BigDecimal(normalisasiAngka(rapat));
            }
        } catch (RuntimeException e) {
            // tanggal tidak valid / angka tidak terbaca -> perlakukan sebagai teks biasa
        }
        return s.toLowerCase(Locale.ROOT).replace('_', ' ');   // BELUM_LUNAS dan "Belum lunas" setara
    }

    private static int i(Matcher m, int g) { return Integer.parseInt(m.group(g)); }

    private static BigDecimal menit(LocalDateTime t) {
        return BigDecimal.valueOf(t.toLocalDate().toEpochDay() * 1440L + t.getHour() * 60L + t.getMinute());
    }

    /** "1.234,5" -> 1234.5 ; "1,5" -> 1.5 ; "12.5" -> 12.5 ; "1.234.567" -> 1234567 ; "+3" -> 3. */
    private static String normalisasiAngka(String s) {
        if (s.startsWith("+")) s = s.substring(1);
        boolean titik = s.contains("."), koma = s.contains(",");
        if (titik && koma) return s.replace(".", "").replace(',', '.');
        if (koma) return count(s, ',') > 1 ? s.replace(",", "") : s.replace(',', '.');
        if (titik && count(s, '.') > 1) return s.replace(".", "");
        return s;
    }

    private static int count(String s, char c) {
        int n = 0;
        for (int k = 0; k < s.length(); k++) if (s.charAt(k) == c) n++;
        return n;
    }

    private static int bulanDariNama(String nama) {
        String n = nama.toLowerCase(Locale.ROOT);
        String[] penuh = {"januari", "februari", "maret", "april", "mei", "juni", "juli", "agustus", "september", "oktober", "november", "desember"};
        String[] inggris = {"january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"};
        for (int k = 0; k < 12; k++) {
            if (n.equals(penuh[k]) || n.equals(inggris[k]) || (n.length() >= 3 && penuh[k].startsWith(n))
                    || (n.length() >= 3 && inggris[k].startsWith(n))) return k + 1;
        }
        return n.equals("agt") || n.equals("ags") ? 8 : 0;
    }

    /** Perbandingan teks dengan angka di dalamnya dibaca sebagai angka (urutan alami). Masukan sudah huruf kecil. */
    private static int alami(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            char x = a.charAt(i), y = b.charAt(j);
            if (Character.isDigit(x) && Character.isDigit(y)) {
                int si = i, sj = j;
                while (i < a.length() && Character.isDigit(a.charAt(i))) i++;
                while (j < b.length() && Character.isDigit(b.charAt(j))) j++;
                String p = tanpaNol(a.substring(si, i)), q = tanpaNol(b.substring(sj, j));
                if (p.length() != q.length()) return p.length() < q.length() ? -1 : 1;
                int c = p.compareTo(q);
                if (c != 0) return c;
            } else {
                if (x != y) return x < y ? -1 : 1;
                i++;
                j++;
            }
        }
        int sisaA = a.length() - i, sisaB = b.length() - j;
        return Integer.compare(sisaA, sisaB);
    }

    private static String tanpaNol(String s) {
        int k = 0;
        while (k < s.length() - 1 && s.charAt(k) == '0') k++;
        return s.substring(k);
    }
}
