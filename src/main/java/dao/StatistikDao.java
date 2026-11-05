package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/** Query agregasi untuk Dashboard Statistik admin. */
public class StatistikDao extends BaseDao {

    private DataTabel jalankan(String sql) {
        try (Connection c = conn(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            ResultSetMetaData md = rs.getMetaData();
            int n = md.getColumnCount();
            String[] kolom = new String[n];
            for (int i = 0; i < n; i++) kolom[i] = md.getColumnLabel(i + 1);
            List<Object[]> baris = new ArrayList<>();
            while (rs.next()) {
                Object[] r = new Object[n];
                for (int i = 0; i < n; i++) r[i] = rs.getObject(i + 1);
                baris.add(r);
            }
            return new DataTabel(kolom, baris);
        } catch (SQLException e) { throw gagal("Gagal menghitung statistik", e); }
    }

    // ---- Pelanggan
    public DataTabel pelangganPerStatus() {
        return jalankan("SELECT status_akun AS Status, COUNT(*) AS Jumlah FROM pelanggan GROUP BY status_akun");
    }
    public DataTabel rasioJenis() {
        return jalankan("SELECT jenis_pelanggan AS Jenis, COUNT(*) AS Jumlah FROM pelanggan GROUP BY jenis_pelanggan");
    }
    public DataTabel pelangganPerGolongan() {
        return jalankan("SELECT CONCAT(g.kode_golongan,' ',g.daya_va,' VA') AS Golongan, COUNT(p.id_pelanggan) AS Jumlah FROM golongan g "
                + "LEFT JOIN pelanggan p ON p.id_golongan=g.id_golongan GROUP BY g.id_golongan, g.kode_golongan, g.daya_va ORDER BY g.id_golongan");
    }

    // ---- Petugas
    public DataTabel petugasPerSpesialis() {
        return jalankan("SELECT spesialis AS Jabatan_Spesialis, COUNT(*) AS Jumlah FROM petugas_lapangan GROUP BY spesialis");
    }
    public DataTabel pengaduanPerPetugas() {
        return jalankan("SELECT k.nama AS Petugas, COUNT(*) AS Pengaduan_Ditangani FROM pengaduan a "
                + "JOIN karyawan k ON k.id_karyawan=a.id_petugas_lapangan GROUP BY k.id_karyawan, k.nama");
    }
    public DataTabel rataWaktuSelesai() {
        return jalankan("SELECT ROUND(AVG(TIMESTAMPDIFF(HOUR,tanggal_lapor,tanggal_selesai)),1) AS Rata2_Jam_Penyelesaian "
                + "FROM pengaduan WHERE tanggal_selesai IS NOT NULL HAVING COUNT(*)>0");
    }

    // ---- Tagihan
    public DataTabel totalPendapatan() {
        return jalankan("SELECT COUNT(*) AS Jumlah_Transaksi, SUM(jumlah_bayar) AS Total_Pendapatan_Rp FROM pembayaran HAVING COUNT(*)>0");
    }
    public DataTabel pendapatanPerStatus() {
        return jalankan("SELECT status AS Status, COUNT(*) AS Jumlah_Tagihan, SUM(total_biaya) AS Nilai_Tagihan_Rp FROM tagihan GROUP BY status");
    }
    public DataTabel kwhBulanan() {
        return jalankan("SELECT CONCAT(tahun,'-',LPAD("+util.Bulan.sql("bulan")+",2,'0')) AS Periode, SUM(jumlah_pemakaian_kwh) AS Total_kWh "
                + "FROM tagihan GROUP BY tahun, bulan ORDER BY CAST(tahun AS UNSIGNED), "+util.Bulan.sql("bulan"));
    }
    public DataTabel metodeTerbanyak() {
        return jalankan("SELECT metode AS Metode, COUNT(*) AS Jumlah FROM pembayaran GROUP BY metode ORDER BY COUNT(*) DESC");
    }

    // ---- Pengaduan
    public DataTabel pengaduanPerStatus() {
        return jalankan("SELECT status AS Status, COUNT(*) AS Jumlah FROM pengaduan GROUP BY status");
    }
    public DataTabel lokasiTerbanyak() {
        return jalankan("SELECT lokasi AS Lokasi, COUNT(*) AS Jumlah FROM pengaduan GROUP BY lokasi ORDER BY COUNT(*) DESC LIMIT 5");
    }
    public DataTabel trenBulanan() {
        return jalankan("SELECT DATE_FORMAT(tanggal_lapor,'%Y-%m') AS Bulan, COUNT(*) AS Jumlah FROM pengaduan "
                + "GROUP BY DATE_FORMAT(tanggal_lapor,'%Y-%m') ORDER BY 1");
    }
}
