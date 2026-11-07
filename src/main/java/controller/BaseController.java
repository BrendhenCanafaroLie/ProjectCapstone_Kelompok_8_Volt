package controller;

import util.AppException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/** INHERITANCE: validasi umum yang dipakai semua controller. */
public abstract class BaseController {

    protected static String isi(String nilai, String label) {
        if (nilai == null || nilai.trim().isEmpty()) throw new AppException(label + " wajib diisi.");
        return nilai.trim();
    }

    protected static BigDecimal angka(String nilai, String label) {
        try {
            return new BigDecimal(isi(nilai, label).replace(",", "."));
        } catch (NumberFormatException e) {
            throw new AppException(label + " harus berupa angka.");
        }
    }

    /** Nominal uang: menerima "135200", "135.200", "Rp 135.200", "135.200,00". */
    protected static BigDecimal uang(String nilai, String label) {
        String s = isi(nilai, label).replaceAll("(?i)rp|\\s", "");
        if (s.contains(".") && s.contains(",")) s = s.replace(".", "").replace(",", ".");
        else if (s.matches("\\d{1,3}(\\.\\d{3})+")) s = s.replace(".", "");
        else if (s.matches("\\d{1,3}(,\\d{3})+")) s = s.replace(",", "");
        else s = s.replace(",", ".");
        try {
            return new BigDecimal(s);
        } catch (NumberFormatException e) {
            throw new AppException(label + " harus berupa angka.");
        }
    }

    protected static int bilangan(String nilai, String label) {
        try {
            return Integer.parseInt(isi(nilai, label));
        } catch (NumberFormatException e) {
            throw new AppException(label + " harus berupa bilangan bulat.");
        }
    }

    protected static LocalDate tanggal(String nilai, String label) {
        try {
            return LocalDate.parse(isi(nilai, label));
        } catch (DateTimeParseException e) {
            throw new AppException(label + " harus berformat yyyy-MM-dd (contoh 2026-11-20).");
        }
    }

    protected static void hanyaAngka(String nilai, String label, int panjang) {
        if (!nilai.matches("\\d{" + panjang + "}")) throw new AppException(label + " harus " + panjang + " digit angka.");
    }

    protected static void telepon(String nilai) {
        if (!nilai.matches("\\d{8,15}")) throw new AppException("No. telepon harus 8-15 digit angka.");
    }
}
