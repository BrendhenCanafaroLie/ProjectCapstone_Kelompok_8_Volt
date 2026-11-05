package util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public final class Fmt {
    private static final NumberFormat RP = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
    private static final DateTimeFormatter TGL = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    private Fmt() { }

    static { RP.setMinimumFractionDigits(0);
        RP.setMaximumFractionDigits(2); }

    /** Tanpa desimal bila bulat (Rp135.200), 2 desimal bila ada pecahan (Rp376.901,30). */
    public static String rupiah(BigDecimal v) {
        if (v == null) return "-";
        NumberFormat f = (NumberFormat) RP.clone();
        int d = v.stripTrailingZeros().scale() > 0 ? 2 : 0;
        f.setMinimumFractionDigits(d);
        f.setMaximumFractionDigits(d);
        return f.format(v);
    }
    public static String waktu(LocalDateTime t) { return t == null ? "-" : TGL.format(t); }
}
