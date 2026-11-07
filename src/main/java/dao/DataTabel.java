package dao;

import java.util.List;

/** Hasil query generik (untuk dashboard statistik). */
public record DataTabel(String[] kolom, List<Object[]> baris) {
    public boolean kosong() { return baris.isEmpty(); }
}
