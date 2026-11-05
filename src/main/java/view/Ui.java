package view;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import java.util.Locale;

/**
 * Utilitas tampilan yang dipakai ulang di semua panel.
 * Gaya komponen diserahkan ke FlatLaf (lihat Tampilan.pasang); di sini hanya properti klien FlatLaf
 * dan beberapa pengaturan tabel.
 */
public final class Ui {
    private Ui() { }

    // ---------- Dialog
    public static void info(Component p, String pesan) {
        JOptionPane.showMessageDialog(p, pesan, "Informasi", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void error(Component p, String pesan) {
        JOptionPane.showMessageDialog(p, pesan, "Perhatian", JOptionPane.WARNING_MESSAGE);
    }

    public static boolean konfirmasi(Component p, String pesan) {
        return JOptionPane.showConfirmDialog(p, pesan, "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION;
    }

    // ---------- Warna status
    public static final Color OK = new Color(0x1B7F3B);
    public static final Color PERINGATAN = new Color(0xB45309);
    public static final Color BAHAYA = new Color(0xC62828);
    public static final Color INFO = new Color(0x1565C0);
    public static final Color REDUP = new Color(0x6B7280);

    /** Teks tampilan untuk nilai status di database, atau null bila bukan nilai status. */
    public static String teksStatus(String nilai) {
        if (nilai == null) return null;
        return switch (nilai.trim().toUpperCase().replace('_', ' ')) {
            case "LUNAS" -> "Lunas";
            case "BELUM LUNAS" -> "Belum lunas";
            case "TERLAMBAT" -> "Terlambat";
            case "AKTIF" -> "Aktif";
            case "MENUNGGU" -> "Menunggu";
            case "TIDAK AKTIF" -> "Tidak aktif";
            case "DILAPORKAN" -> "Dilaporkan";
            case "DIPROSES" -> "Diproses";
            case "SELESAI" -> "Selesai";
            case "SUDAH SETOR" -> "Sudah setor";
            case "BELUM SETOR" -> "Belum setor";
            default -> null;
        };
    }

    public static Color warnaStatus(String nilai) {
        String t = teksStatus(nilai);
        if (t == null) return null;
        return switch (t) {
            case "Lunas", "Aktif", "Selesai", "Sudah setor" -> OK;
            case "Belum lunas", "Menunggu", "Dilaporkan", "Belum setor" -> PERINGATAN;
            case "Terlambat" -> BAHAYA;
            case "Diproses" -> INFO;
            default -> REDUP;
        };
    }

    // ---------- Teks
    public static void gayaJudul(JLabel l) {
        l.putClientProperty(FlatClientProperties.STYLE_CLASS, "h3");
    }

    public static JLabel judul(String teks) {
        JLabel l = new JLabel(teks);
        gayaJudul(l);
        return l;
    }

    public static JLabel subjudul(String teks) {
        JLabel l = new JLabel(teks);
        l.putClientProperty(FlatClientProperties.STYLE_CLASS, "semibold");
        return l;
    }

    /** Teks bantu berwarna redup. Boleh memakai &lt;br&gt;. */
    public static JLabel catatan(String teks) {
        JLabel l = new JLabel("<html>" + teks + "</html>");
        gayaCatatan(l);
        return l;
    }

    public static void gayaCatatan(JLabel l) {
        l.putClientProperty(FlatClientProperties.STYLE, "font:-1;foreground:#6B7280");
    }

    /** Label pesan di bawah judul panel ("Tidak ada data ..."). */
    public static void gayaPesan(JLabel l) {
        l.setForeground(REDUP);
    }

    public static void monospaced(JTextArea a) {
        a.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        a.setMargin(new Insets(8, 10, 8, 10));
    }

    public static JTextArea areaTeks(int baris, int kolom) {
        JTextArea a = new JTextArea(baris, kolom);
        a.setEditable(false);
        a.setLineWrap(true);
        a.setWrapStyleWord(true);
        monospaced(a);
        return a;
    }

    public static void tampilkanTeks(Component parent, String judul, String teks) {
        new DialogTeks(parent, judul, teks).setVisible(true);
    }

    public static JScrollPane scroll(JComponent c) {
        JScrollPane sp = new JScrollPane(c);
        sp.getVerticalScrollBar().setUnitIncrement(16);
        return sp;
    }

    // ---------- Tabel
    public static DefaultTableModel modelTabel(String... kolom) {
        String[] judul = new String[kolom.length];
        for (int i = 0; i < kolom.length; i++) judul[i] = kolom[i].replace('_', ' ');
        return new DefaultTableModel(judul, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
    }

    public static JTable tabel(DefaultTableModel m) {
        JTable t = new JTable(m);
        gayaTabel(t);
        pasangAutofit(t);
        return t;
    }

    /** Pasang model ke JTable hasil desain NetBeans + pengaturan standar (satu baris, bisa diurutkan, tampilan seragam). */
    public static void siapkanTabel(JTable t, DefaultTableModel m) {
        t.setModel(m);
        siapkanTabel(t);
    }

    /** Model & judul kolom sudah didesain di NetBeans (properti "model" JTable); di sini hanya gaya standar. */
    public static void siapkanTabel(JTable t) {
        gayaTabel(t);
        pasangAutofit(t);
    }

    // ---------- Pencarian tabel
    /**
     * Sambungkan kolom pencarian (txtCari + lblJumlah, didesain di NetBeans) ke tabel; dipanggil di konstruktor panel setelah {@link #siapkanTabel}.
     * Pencarian berjalan langsung saat mengetik, tidak membedakan huruf besar/kecil, memeriksa SEMUA kolom,
     * dan beberapa kata dipisah spasi harus cocok semuanya (mis. "kasir belum" ).
     * Hanya menyaring tampilan; data di database dan indeks baris ke model ({@link #terpilih}) tidak berubah.
     */
    public static JTextField pasangPencarian(JTable t, JTextField kolom, JLabel jumlah, String petunjuk) {
        TableModel model = t.getModel();
        TableRowSorter<TableModel> sorter;
        if (t.getRowSorter() instanceof TableRowSorter<?> rs) {
            @SuppressWarnings("unchecked") TableRowSorter<TableModel> x = (TableRowSorter<TableModel>) rs;
            sorter = x;
        } else {
            sorter = new TableRowSorter<>(model);
            t.setRowSorter(sorter);
        }

        kolom.setToolTipText(petunjuk);
        kolom.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, petunjuk);
        kolom.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
        gayaCatatan(jumlah);

        Runnable perbarui = () -> {
            int tampil = t.getRowCount(), total = model.getRowCount();
            boolean aktif = !kolom.getText().isBlank();
            jumlah.setText(aktif ? tampil + " dari " + total + " data" : " ");
        };
        Runnable saring = () -> {
            String[] kata = kolom.getText().trim().toLowerCase(Locale.ROOT).split("\\s+");
            if (kolom.getText().isBlank()) {
                sorter.setRowFilter(null);
            } else {
                sorter.setRowFilter(new RowFilter<TableModel, Integer>() {
                    @Override public boolean include(Entry<? extends TableModel, ? extends Integer> e) {
                        for (String k : kata) {
                            boolean ada = false;
                            for (int c = 0; c < e.getValueCount() && !ada; c++) {
                                Object v = e.getValue(c);
                                ada = v != null && String.valueOf(v).toLowerCase(Locale.ROOT).contains(k);
                            }
                            if (!ada) return false;
                        }
                        return true;
                    }
                });
            }
            perbarui.run();
        };
        kolom.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override public void insertUpdate(javax.swing.event.DocumentEvent e) { saring.run(); }
            @Override public void removeUpdate(javax.swing.event.DocumentEvent e) { saring.run(); }
            @Override public void changedUpdate(javax.swing.event.DocumentEvent e) { saring.run(); }
        });
        kolom.getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"), "hapusCari");
        kolom.getActionMap().put("hapusCari", new AbstractAction() {
            @Override public void actionPerformed(java.awt.event.ActionEvent e) { kolom.setText(""); }
        });
        // data dimuat ulang / baris berubah -> hitungan ikut diperbarui
        model.addTableModelListener(e -> SwingUtilities.invokeLater(perbarui));
        perbarui.run();

        return kolom;
    }


    /** Indeks baris terpilih pada model (aman terhadap sorting), atau -1. */
    public static int terpilih(JTable t) {
        int r = t.getSelectedRow();
        return r < 0 ? -1 : t.convertRowIndexToModel(r);
    }

    private static void gayaTabel(JTable t) {
        t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        t.setAutoCreateRowSorter(true);
        t.setFillsViewportHeight(true);
        t.getTableHeader().setReorderingAllowed(false);
        // Judul kolom rata tengah: membungkus renderer bawaan (agar ikon urutan FlatLaf tetap ada)
        javax.swing.table.TableCellRenderer asli = t.getTableHeader().getDefaultRenderer();
        t.getTableHeader().setDefaultRenderer((tbl, v, sel, fokus, r, c) -> {
            Component k = asli.getTableCellRendererComponent(tbl, v, sel, fokus, r, c);
            if (k instanceof JLabel jl) jl.setHorizontalAlignment(SwingConstants.CENTER);
            return k;
        });
        SelRenderer r = new SelRenderer();
        t.setDefaultRenderer(Object.class, r);
        t.setDefaultRenderer(Number.class, r);
    }

    // ---------- Lebar kolom otomatis
    /** Lebar kolom mengikuti isi tiap kali data berubah; bila total melebihi lebar tampilan, tabel bisa digulir mendatar. */
    private static void pasangAutofit(JTable t) {
        t.getModel().addTableModelListener(e -> SwingUtilities.invokeLater(() -> autofit(t)));
        t.addHierarchyListener(e -> {
            if (t.getParent() instanceof JViewport vp && t.getClientProperty("autofitVp") == null) {
                t.putClientProperty("autofitVp", Boolean.TRUE);
                vp.addComponentListener(new ComponentAdapter() {
                    @Override public void componentResized(ComponentEvent ev) { aturMode(t); }
                });
                autofit(t);
            }
        });
    }

    private static void autofit(JTable t) {
        int n = t.getColumnCount();
        if (n == 0) return;
        int baris = Math.min(t.getRowCount(), 80);
        for (int c = 0; c < n; c++) {
            TableColumn kol = t.getColumnModel().getColumn(c);
            Component h = t.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(t, kol.getHeaderValue(), false, false, -1, c);
            int w = h.getPreferredSize().width + 24;   // ruang untuk panah urutan
            for (int r = 0; r < baris; r++) {
                Component k = t.prepareRenderer(t.getCellRenderer(r, c), r, c);
                w = Math.max(w, k.getPreferredSize().width);
            }
            kol.setPreferredWidth(Math.max(60, Math.min(340, w + 6)));
        }
        aturMode(t);
    }

    private static void aturMode(JTable t) {
        if (!(t.getParent() instanceof JViewport vp) || vp.getWidth() == 0) return;
        int total = 0;
        for (int c = 0; c < t.getColumnCount(); c++) total += t.getColumnModel().getColumn(c).getPreferredWidth();
        if (total > vp.getWidth()) {
            t.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            for (int c = 0; c < t.getColumnCount(); c++) {
                TableColumn kol = t.getColumnModel().getColumn(c);
                kol.setWidth(kol.getPreferredWidth());
            }
        } else {
            t.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        }
        t.revalidate();
        t.repaint();
    }

    /** Nilai numerik (angka, rupiah, atau teks berisi angka saja) ditampilkan di tengah sel. */
    private static boolean numerik(Object v) {
        if (v instanceof Number) return true;
        if (v instanceof String s) return s.startsWith("Rp") || s.startsWith("-Rp") || s.matches("-?[\\d.,]+");
        return false;
    }

    /** Sel tabel: nilai status diberi warna teks; semua isi sel rata tengah. */
    private static final class SelRenderer extends DefaultTableCellRenderer {
        @Override public Component getTableCellRendererComponent(JTable t, Object v, boolean sel, boolean fokus, int r, int c) {
            setForeground(null);   // hapus warna status dari sel sebelumnya
            JLabel l = (JLabel) super.getTableCellRendererComponent(t, v, sel, false, r, c);
            String status = v instanceof String s ? teksStatus(s) : null;
            if (status != null) {
                l.setText(status);
                if (!sel) l.setForeground(warnaStatus(status));
            }
            l.setHorizontalAlignment(SwingConstants.CENTER);
            boolean terpotong = status == null && v != null
                    && t.getFontMetrics(t.getFont()).stringWidth(v.toString()) + 20 > t.getColumnModel().getColumn(c).getWidth();
            l.setToolTipText(terpotong ? v.toString() : null);
            return l;
        }
    }
}
