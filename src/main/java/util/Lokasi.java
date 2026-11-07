package util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Mengambil titik koordinat (lintang, bujur) lokasi pengguna.
 * Aplikasi desktop tidak punya GPS, jadi lokasi diperkirakan dari alamat IP (layanan ipwho.is).
 * Hasilnya perkiraan; pengguna tetap bisa mengoreksinya secara manual di form.
 */
public final class Lokasi {
    private Lokasi() { }

    private static final Pattern LAT = Pattern.compile("\"latitude\"\\s*:\\s*(-?\\d+(?:\\.\\d+)?)");
    private static final Pattern LON = Pattern.compile("\"longitude\"\\s*:\\s*(-?\\d+(?:\\.\\d+)?)");

    /** @return {lintang, bujur}; melempar AppException bila gagal (tidak ada internet, dll). */
    public static double[] ambil() {
        try {
            HttpClient http = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();
            HttpRequest req = HttpRequest.newBuilder(URI.create("https://ipwho.is/"))
                    .timeout(Duration.ofSeconds(8)).GET().build();
            String body = http.send(req, HttpResponse.BodyHandlers.ofString()).body();
            Matcher a = LAT.matcher(body), b = LON.matcher(body);
            if (a.find() && b.find()) return new double[]{Double.parseDouble(a.group(1)), Double.parseDouble(b.group(1))};
            throw new AppException("Lokasi tidak dapat ditentukan.");
        } catch (AppException e) {
            throw e;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AppException("Pengambilan lokasi dibatalkan.");
        } catch (Exception e) {
            throw new AppException("Gagal mengambil lokasi (periksa koneksi internet). Isi koordinat secara manual bila perlu.");
        }
    }

    public static String format(Double lintang, Double bujur) {
        return lintang == null || bujur == null ? "-" : String.format(java.util.Locale.US, "%.6f, %.6f", lintang, bujur);
    }
}
