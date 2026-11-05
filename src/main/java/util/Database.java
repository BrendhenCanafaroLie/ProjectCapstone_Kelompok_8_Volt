package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/** Penyedia koneksi JDBC. Konfigurasi dibaca dari db.properties. */
public final class Database {
    private static String url = "jdbc:mysql://localhost:3306/volt?useSSL=false&allowPublicKeyRetrieval=true&connectionTimeZone=LOCAL";
    private static String user = "root";
    private static String password = "";

    static {
        try (InputStream in = Database.class.getResourceAsStream("/db.properties")) {
            if (in != null) {
                Properties p = new Properties();
                p.load(in);
                url = p.getProperty("db.url", url);
                user = p.getProperty("db.user", user);
                password = p.getProperty("db.password", password);
            }
        } catch (IOException ignored) { }
    }

    private Database() { }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /** Dipakai saat startup untuk memastikan database dapat dihubungi. */
    public static void tes() throws SQLException {
        try (Connection c = getConnection()) { c.isValid(2); }
    }
}
