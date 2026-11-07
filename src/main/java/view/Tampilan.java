package view;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import model.Pengguna;
import javax.swing.*;
import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.time.LocalTime;
import java.util.Collections;

/** Pengaturan Look and Feel FlatLaf dan beberapa teks tampilan yang dipakai bersama. */
public final class Tampilan {
    /** Latar halaman kerja (biru sangat muda); kartu dan form berlatar putih. */
    public static final Color LATAR = new Color(238, 243, 251);
    public static final Color NAVY = new Color(11, 31, 75);
    public static final Color BIRU = new Color(29, 78, 216);
    public static final Color AMBER = new Color(245, 158, 11);

    private Tampilan() { }

    /** Hanya pengaturan tema global; warna dan tata letak tiap layar diatur di Designer (file .form). */
    public static void pasang() {
        FlatLaf.setGlobalExtraDefaults(Collections.singletonMap("@accentColor", "#1D4ED8"));
        FlatLightLaf.setup();
        UIManager.put("Panel.background", Color.WHITE);
        UIManager.put("Button.arc", 10);
        UIManager.put("Component.arc", 10);
        UIManager.put("TextComponent.arc", 10);
        UIManager.put("Component.focusColor", AMBER);
        UIManager.put("ScrollBar.showButtons", false);
        UIManager.put("Table.rowHeight", 30);
        UIManager.put("Table.showHorizontalLines", true);
        UIManager.put("Table.gridColor", new Color(222, 230, 244));
        UIManager.put("Table.alternateRowColor", new Color(245, 249, 255));
        UIManager.put("Table.selectionBackground", new Color(191, 213, 255));
        UIManager.put("Table.selectionForeground", NAVY);
        UIManager.put("TableHeader.background", NAVY);
        UIManager.put("TableHeader.foreground", Color.WHITE);
        UIManager.put("TableHeader.bottomSeparatorColor", AMBER);
        UIManager.put("TableHeader.separatorColor", new Color(40, 62, 120));
        UIManager.put("TabbedPane.showTabSeparators", true);
        UIManager.put("TabbedPane.underlineColor", AMBER);
        UIManager.put("TabbedPane.selectedForeground", BIRU);
        UIManager.put("ToggleButton.toolbar.selectedBackground", BIRU);
        UIManager.put("ToggleButton.toolbar.pressedBackground", new Color(37, 80, 190));
        UIManager.put("ToggleButton.selectedForeground", Color.WHITE);
        UIManager.put("OptionPane.yesButtonText", "Ya");
        UIManager.put("OptionPane.noButtonText", "Tidak");
        UIManager.put("OptionPane.cancelButtonText", "Batal");
        matikanHoverTombol();
    }

    /**
     * Menghilangkan efek hover (perubahan warna saat kursor melintas) pada semua tombol dan tab navigasi.
     * Tombol yang tampil di jendela atau dialog mana pun otomatis dimatikan rollover-nya, jadi tidak perlu
     * mengubah tiap panel atau Designer. Efek tekan (saat diklik) tetap ada sebagai umpan balik.
     */
    private static void matikanHoverTombol() {
        Toolkit.getDefaultToolkit().addAWTEventListener(e -> {
            if (e.getSource() instanceof AbstractButton b && b.isRolloverEnabled()) b.setRolloverEnabled(false);
        }, AWTEvent.HIERARCHY_EVENT_MASK);

        // lapis kedua: warna hover disamakan dengan warna normal
        for (String jenis : new String[]{"Button", "Button.default", "ToggleButton"}) {
            Color latar = UIManager.getColor(jenis + ".background");
            if (latar != null) UIManager.put(jenis + ".hoverBackground", latar);
            Color garis = UIManager.getColor(jenis + ".borderColor");
            if (garis != null) UIManager.put(jenis + ".hoverBorderColor", garis);
        }
        Color latarTab = UIManager.getColor("TabbedPane.background");
        UIManager.put("TabbedPane.hoverColor", latarTab != null ? latarTab : Color.WHITE);
    }

    public static String sapaan() {
        int jam = LocalTime.now().getHour();
        if (jam < 11) return "Selamat pagi";
        if (jam < 15) return "Selamat siang";
        if (jam < 18) return "Selamat sore";
        return "Selamat malam";
    }

    public static String namaDepan(Pengguna p) {
        String nama = p.getNama();
        if (nama == null || nama.isBlank()) return "";
        return nama.trim().split("\\s+")[0];
    }
}
