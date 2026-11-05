package util;

/** Exception khusus aplikasi: pesannya langsung aman ditampilkan ke pengguna. */
public class AppException extends RuntimeException {
    public AppException(String message) { super(message); }
    public AppException(String message, Throwable cause) { super(message, cause); }
}
