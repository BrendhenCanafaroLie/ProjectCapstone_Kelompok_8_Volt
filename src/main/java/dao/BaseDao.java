package dao;

import util.AppException;
import util.Database;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/** INHERITANCE: fungsi umum untuk semua DAO. */
public abstract class BaseDao {
    protected Connection conn() throws SQLException { return Database.getConnection(); }

    protected static LocalDateTime waktu(Timestamp ts) { return ts == null ? null : ts.toLocalDateTime(); }

    protected AppException gagal(String aksi, SQLException e) {
        if (e instanceof SQLIntegrityConstraintViolationException) {
            return new AppException(aksi + ": database menolak data (duplikat / relasi / kolom tidak boleh kosong).\nDetail: " + e.getMessage(), e);
        }
        return new AppException(aksi + ": " + e.getMessage(), e);
    }
}
