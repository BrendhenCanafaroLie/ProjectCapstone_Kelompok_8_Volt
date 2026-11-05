package util;

/** Validasi password & username. Password disimpan sebagai teks biasa di kolom varchar(10); username varchar(30). */
public final class PasswordUtil {
    private PasswordUtil() { }

    /** Aturan panjang: minimal 6, maksimal 10 karakter (sesuai kolom varchar(10)). */
    public static void validasi(String password) {
        if (password == null || password.length() < 6) throw new AppException("Password minimal 6 karakter.");
        if (password.length() > 10) throw new AppException("Password maksimal 10 karakter.");
    }

    /** Username maksimal 30 karakter (sesuai kolom varchar(30)). */
    public static void validasiUsername(String username) {
        if (username != null && username.trim().length() > 30) throw new AppException("Username maksimal 30 karakter.");
    }
}
