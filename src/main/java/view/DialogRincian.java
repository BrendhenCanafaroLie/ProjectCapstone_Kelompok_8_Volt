package view;

import model.Pembayaran;
import model.Pelanggan;
import model.Pengaduan;
import model.Tagihan;
import util.Fmt;
import util.Lokasi;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Dialog rincian bergaya kartu untuk bukti pembayaran dan detail pengaduan
 * (pengganti tampilan teks polos {@link DialogTeks} pada dua layar itu).
 * Dibuat lewat kode (bukan Form NetBeans) karena isinya dibangun dari data; warna mengikuti {@link Tampilan}.
 */
public final class DialogRincian extends JDialog {
    private static final int LEBAR = 500;
    private static final Color TEKS = new Color(30, 41, 59);
    private static final Color REDUP = new Color(0x6B7280);
    private static final Color GARIS = new Color(226, 232, 244);
    private static final Color KOTAK = new Color(243, 247, 255);
    private static final Font BIASA = new Font("SansSerif", Font.PLAIN, 13);
    private static final Font TEBAL = new Font("SansSerif", Font.BOLD, 13);

    private DialogRincian(Component induk, String judul, JComponent isi) {
        super(induk == null ? null : SwingUtilities.getWindowAncestor(induk));
        setTitle(judul);
        setModal(true);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JButton ok = new JButton("Tutup");
        ok.setBackground(Tampilan.BIRU);
        ok.setForeground(Color.WHITE);
        ok.setFont(new Font("SansSerif", Font.BOLD, 12));
        ok.setPreferredSize(new Dimension(110, 34));
        ok.addActionListener(e -> dispose());

        JPanel kaki = new JPanel(new FlowLayout(FlowLayout.RIGHT, 24, 12));
        kaki.setBackground(new Color(246, 249, 255));
        kaki.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, GARIS));
        kaki.add(ok);

        JPanel akar = new JPanel(new BorderLayout()) {
            @Override public Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                d.width = LEBAR;
                return d;
            }
        };
        akar.add(isi, BorderLayout.CENTER);
        akar.add(kaki, BorderLayout.SOUTH);
        setContentPane(akar);
        getRootPane().setDefaultButton(ok);
        getRootPane().registerKeyboardAction(e -> dispose(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);
        pack();
        setLocationRelativeTo(induk);
    }

    // ---------- Pintu masuk

    public static void bukti(Component induk, Pembayaran b) {
        new DialogRincian(induk, "Bukti Pembayaran", isiBukti(b)).setVisible(true);
    }

    /** {@code catatan} (boleh null) tampil sebagai kotak pesan di bagian bawah. */
    public static void pengaduan(Component induk, Pengaduan a, String catatan) {
        new DialogRincian(induk, "Detail Pengaduan", isiPengaduan(a, catatan)).setVisible(true);
    }

    /** Rincian satu tagihan (mis. tagihan yang baru dibuat petugas). */
    public static void tagihan(Component induk, Tagihan t, String judul) {
        new DialogRincian(induk, judul, isiTagihan(t, judul)).setVisible(true);
    }

    /** Seluruh tagihan satu pelanggan: ringkasan di atas, daftar periode di bawah. */
    public static void tagihanPelanggan(Component induk, Pelanggan p, List<Tagihan> daftar) {
        new DialogRincian(induk, "Detail Tagihan Pelanggan", isiTagihanPelanggan(p, daftar)).setVisible(true);
    }

    static JComponent isiTagihan(Tagihan t, String judul) {
        JPanel badan = badan();
        Kotak jumlah = new Kotak(KOTAK, GARIS);
        jumlah.setLayout(new BoxLayout(jumlah, BoxLayout.Y_AXIS));
        jumlah.setBorder(new EmptyBorder(14, 16, 14, 16));
        JLabel cap = teks("Total tagihan", new Font("SansSerif", Font.PLAIN, 12), REDUP);
        JLabel nilai = teks(Fmt.rupiah(t.getTotal()), new Font("SansSerif", Font.BOLD, 30), Tampilan.NAVY);
        cap.setAlignmentX(Component.CENTER_ALIGNMENT);
        nilai.setAlignmentX(Component.CENTER_ALIGNMENT);
        jumlah.add(cap);
        jumlah.add(Box.createVerticalStrut(2));
        jumlah.add(nilai);
        tambah(badan, jumlah, 0);
        tambah(badan, baris(
                "Pelanggan", nz(t.getNamaPelanggan()),
                "No. Meter", nz(t.getNomorMeter()),
                "Periode", t.getPeriode(),
                "Meter", t.getMeterAwal() + "  \u2192  " + t.getMeterAkhir(),
                "Pemakaian", t.getKwh() + " kWh",
                "Jatuh Tempo", t.getJatuhTempo() == null ? "-" : t.getJatuhTempo().toString(),
                "Kasir PJ", t.getNamaKasir() == null ? "-" : t.getNamaKasir()), 10);
        String st = t.getStatus();
        String teksSt = Ui.teksStatus(st) != null ? Ui.teksStatus(st) : nz(st);
        Color warna = Ui.warnaStatus(st) != null ? Ui.warnaStatus(st) : Ui.REDUP;
        return susun(kepala(judul, "Periode " + t.getPeriode(), teksSt, warna), badan);
    }

    static JComponent isiTagihanPelanggan(Pelanggan p, List<Tagihan> daftar) {
        JPanel badan = badan();
        java.math.BigDecimal sisa = java.math.BigDecimal.ZERO;
        int belum = 0;
        for (Tagihan t : daftar) {
            if (util.Konstanta.belumLunas(t.getStatus())) {
                belum++;
                if (t.getTotal() != null) sisa = sisa.add(t.getTotal());
            }
        }
        tambah(badan, baris(
                "Pelanggan", nz(p.getNama()),
                "No. Meter", nz(p.getNomorMeter()),
                "Golongan", nz(p.getKodeGolongan()),
                "Belum Lunas", belum == 0 ? "Tidak ada" : belum + " tagihan  (" + Fmt.rupiah(sisa) + ")"), 0);
        tambah(badan, teks("Riwayat Tagihan", TEBAL, REDUP), 10);
        if (daftar.isEmpty()) {
            Kotak kosong = new Kotak(KOTAK, GARIS);
            kosong.setLayout(new BorderLayout());
            kosong.setBorder(new EmptyBorder(16, 14, 16, 14));
            JLabel l = teks("Pelanggan ini belum memiliki tagihan.", BIASA, REDUP);
            l.setHorizontalAlignment(SwingConstants.CENTER);
            kosong.add(l, BorderLayout.CENTER);
            tambah(badan, kosong, 6);
        } else {
            javax.swing.table.DefaultTableModel m = Ui.modelTabel("Periode", "Pemakaian", "Total", "Jatuh Tempo", "Status");
            for (Tagihan t : daftar) {
                m.addRow(new Object[]{t.getPeriode(), t.getKwh() + " kWh", Fmt.rupiah(t.getTotal()),
                        t.getJatuhTempo() == null ? "-" : t.getJatuhTempo().toString(), t.getStatus()});
            }
            JTable tb = Ui.tabel(m);
            tb.setRowHeight(28);
            JScrollPane sp = new JScrollPane(tb);
            sp.setBorder(BorderFactory.createLineBorder(GARIS));
            sp.setPreferredSize(new Dimension(LEBAR - 48, Math.min(230, 34 + 28 * daftar.size())));
            tambah(badan, sp, 6);
        }
        return susun(kepala("Detail Tagihan", daftar.size() + " tagihan tercatat", belum == 0 ? "LUNAS" : belum + " BELUM LUNAS",
                belum == 0 ? Ui.OK : Ui.PERINGATAN), badan);
    }

    /** Konfirmasi pembayaran bergaya kartu (pengganti kotak Ya/Tidak polos). @return true bila pelanggan memilih Bayar. */
    public static boolean konfirmasiBayar(Component induk, Tagihan t) {
        boolean[] ya = {false};
        JDialog d = new JDialog(induk == null ? null : SwingUtilities.getWindowAncestor(induk));
        d.setTitle("Konfirmasi Pembayaran");
        d.setModal(true);
        d.setResizable(false);
        d.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel badan = badan();
        Kotak jumlah = new Kotak(KOTAK, GARIS);
        jumlah.setLayout(new BoxLayout(jumlah, BoxLayout.Y_AXIS));
        jumlah.setBorder(new EmptyBorder(14, 16, 14, 16));
        JLabel cap = teks("Total yang akan dibayar", new Font("SansSerif", Font.PLAIN, 12), REDUP);
        JLabel nilai = teks(Fmt.rupiah(t.getTotal()), new Font("SansSerif", Font.BOLD, 30), Tampilan.NAVY);
        cap.setAlignmentX(Component.CENTER_ALIGNMENT);
        nilai.setAlignmentX(Component.CENTER_ALIGNMENT);
        jumlah.add(cap);
        jumlah.add(Box.createVerticalStrut(2));
        jumlah.add(nilai);
        tambah(badan, jumlah, 0);
        tambah(badan, baris(
                "Periode", t.getPeriode(),
                "Pemakaian", (t.getKwh() == null ? "0" : t.getKwh().stripTrailingZeros().toPlainString()) + " kWh",
                "Jatuh tempo", t.getJatuhTempo() == null ? "-" : t.getJatuhTempo().toString(),
                "Metode", "Pembayaran Online (Digital)"), 10);
        Kotak cat = new Kotak(new Color(255, 247, 230), new Color(253, 226, 167));
        cat.setLayout(new BorderLayout());
        cat.setBorder(new EmptyBorder(10, 14, 10, 14));
        cat.add(html("Pembayaran dilakukan sekali dan harus lunas (tidak bisa dicicil).", LEBAR - 48 - 28 - 4, TEBAL, new Color(0x92400E)), BorderLayout.CENTER);
        tambah(badan, cat, 10);

        JButton batal = new JButton("Batal");
        batal.setBackground(new Color(71, 85, 105));
        batal.setForeground(Color.WHITE);
        batal.setFont(new Font("SansSerif", Font.BOLD, 12));
        batal.setPreferredSize(new Dimension(110, 34));
        batal.addActionListener(e -> d.dispose());
        JButton bayar = new JButton("Bayar Sekarang");
        bayar.setBackground(new Color(22, 163, 74));
        bayar.setForeground(Color.WHITE);
        bayar.setFont(new Font("SansSerif", Font.BOLD, 12));
        bayar.setPreferredSize(new Dimension(160, 34));
        bayar.addActionListener(e -> { ya[0] = true; d.dispose(); });
        JPanel kaki = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 12));
        kaki.setBackground(new Color(246, 249, 255));
        kaki.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, GARIS), new EmptyBorder(0, 14, 0, 14)));
        kaki.add(batal);
        kaki.add(bayar);

        JPanel akar = new JPanel(new BorderLayout()) {
            @Override public Dimension getPreferredSize() {
                Dimension dm = super.getPreferredSize();
                dm.width = LEBAR;
                return dm;
            }
        };
        akar.add(susun(kepala("Konfirmasi Pembayaran", "Tagihan periode " + t.getPeriode(), "BELUM LUNAS", Ui.PERINGATAN), badan), BorderLayout.CENTER);
        akar.add(kaki, BorderLayout.SOUTH);
        d.setContentPane(akar);
        d.getRootPane().setDefaultButton(bayar);
        d.getRootPane().registerKeyboardAction(e -> d.dispose(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
        d.pack();
        d.setLocationRelativeTo(induk);
        d.setVisible(true);
        return ya[0];
    }

    // ---------- Isi

    static JComponent isiBukti(Pembayaran b) {
        JPanel badan = badan();
        Kotak jumlah = new Kotak(KOTAK, GARIS);
        jumlah.setLayout(new BoxLayout(jumlah, BoxLayout.Y_AXIS));
        jumlah.setBorder(new EmptyBorder(14, 16, 14, 16));
        JLabel cap = teks("Jumlah dibayar", new Font("SansSerif", Font.PLAIN, 12), REDUP);
        JLabel nilai = teks(Fmt.rupiah(b.getJumlah()), new Font("SansSerif", Font.BOLD, 30), Tampilan.NAVY);
        cap.setAlignmentX(Component.CENTER_ALIGNMENT);
        nilai.setAlignmentX(Component.CENTER_ALIGNMENT);
        jumlah.add(cap);
        jumlah.add(Box.createVerticalStrut(2));
        jumlah.add(nilai);
        tambah(badan, jumlah, 0);
        tambah(badan, garisPutus(), 12);
        tambah(badan, baris(
                "Tanggal", Fmt.waktu(b.getTanggalBayar()),
                "Pelanggan", b.getNamaPelanggan(),
                "Periode", b.getPeriode(),
                "Metode", b.getMetode(),
                "Kasir", b.getNamaKasir() == null ? "Pembayaran Online" : b.getNamaKasir()), 0);
        tambah(badan, garisPutus(), 4);
        JLabel terima = teks("Terima kasih atas pembayaran Anda.", new Font("SansSerif", Font.PLAIN, 12), REDUP);
        terima.setHorizontalAlignment(SwingConstants.CENTER);
        tambah(badan, terima, 6);

        return susun(kepala("Bukti Pembayaran", "No. Struk " + nz(b.getNoStruk()), "LUNAS", Ui.OK), badan);
    }

    static JComponent isiPengaduan(Pengaduan a, String catatan) {
        JPanel badan = badan();
        tambah(badan, baris(
                "Pelapor", a.getNamaPelanggan(),
                "Lokasi", a.getLokasi(),
                "Koordinat", Lokasi.format(a.getLintang(), a.getBujur()),
                "Tanggal Lapor", Fmt.waktu(a.getTanggalLapor()),
                "Tanggal Selesai", Fmt.waktu(a.getTanggalSelesai()),
                "Petugas", a.getNamaPetugas() == null ? "-" : a.getNamaPetugas()), 0);

        tambah(badan, teks("Deskripsi", TEBAL, REDUP), 10);
        Kotak desk = new Kotak(KOTAK, GARIS);
        desk.setLayout(new BorderLayout());
        desk.setBorder(new EmptyBorder(10, 14, 10, 14));
        desk.add(html(nz(a.getDeskripsi()), LEBAR - 48 - 28 - 4, BIASA, TEKS), BorderLayout.CENTER);
        tambah(badan, desk, 6);

        if (catatan != null && !catatan.isBlank()) {
            Kotak cat = new Kotak(new Color(255, 247, 230), new Color(253, 226, 167));
            cat.setLayout(new BorderLayout());
            cat.setBorder(new EmptyBorder(10, 14, 10, 14));
            cat.add(html(catatan, LEBAR - 48 - 28 - 4, TEBAL, new Color(0x92400E)), BorderLayout.CENTER);
            tambah(badan, cat, 12);
        }

        String status = a.getStatus();
        String teksStatus = Ui.teksStatus(status) != null ? Ui.teksStatus(status) : nz(status);
        Color warna = Ui.warnaStatus(status) != null ? Ui.warnaStatus(status) : Ui.REDUP;
        return susun(kepala("Detail Pengaduan", "Laporan #" + a.getId(), teksStatus, warna), badan);
    }

    // ---------- Potongan tampilan

    private static JComponent susun(JComponent kepala, JComponent badan) {
        JPanel p = new JPanel(new BorderLayout());
        p.add(kepala, BorderLayout.NORTH);
        p.add(badan, BorderLayout.CENTER);
        return p;
    }

    private static JPanel kepala(String judul, String sub, String chip, Color warnaChip) {
        JPanel k = new JPanel(new BorderLayout(12, 0));
        k.setBackground(Tampilan.NAVY);
        k.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 3, 0, Tampilan.AMBER),
                new EmptyBorder(16, 24, 14, 24)));
        JPanel kiri = new JPanel();
        kiri.setOpaque(false);
        kiri.setLayout(new BoxLayout(kiri, BoxLayout.Y_AXIS));
        JLabel merek = teks("VOLT", new Font("SansSerif", Font.BOLD, 11), Tampilan.AMBER);
        JLabel jdl = teks(judul, new Font("SansSerif", Font.BOLD, 20), Color.WHITE);
        JLabel sb = teks(sub, new Font("SansSerif", Font.PLAIN, 12), new Color(180, 198, 235));
        kiri.add(merek);
        kiri.add(jdl);
        kiri.add(sb);
        k.add(kiri, BorderLayout.CENTER);
        JPanel kanan = new JPanel(new GridBagLayout());   // pusatkan chip secara vertikal
        kanan.setOpaque(false);
        kanan.add(new Chip(chip, warnaChip));
        k.add(kanan, BorderLayout.EAST);
        return k;
    }

    private static JPanel badan() {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBackground(Color.WHITE);
        p.setBorder(new EmptyBorder(20, 24, 18, 24));
        return p;
    }

    private static void tambah(JPanel p, Component c, int jarakAtas) {
        GridBagConstraints g = new GridBagConstraints();
        g.gridx = 0;
        g.gridy = p.getComponentCount();
        g.weightx = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.NORTH;
        g.insets = new Insets(jarakAtas, 0, 0, 0);
        p.add(c, g);
    }

    /** Pasangan label-nilai berurutan: baris("Label", "nilai", "Label2", "nilai2", ...). */
    private static JPanel baris(String... pasangan) {
        JPanel p = new JPanel(new GridBagLayout());
        p.setOpaque(false);
        int y = 0;
        for (int i = 0; i + 1 < pasangan.length; i += 2) {
            GridBagConstraints l = new GridBagConstraints();
            l.gridx = 0; l.gridy = y; l.anchor = GridBagConstraints.NORTHWEST; l.insets = new Insets(7, 0, 7, 16);
            JLabel lbl = teks(pasangan[i], BIASA, REDUP);
            lbl.setPreferredSize(new Dimension(116, lbl.getPreferredSize().height));
            p.add(lbl, l);
            GridBagConstraints v = new GridBagConstraints();
            v.gridx = 1; v.gridy = y; v.weightx = 1; v.fill = GridBagConstraints.HORIZONTAL;
            v.anchor = GridBagConstraints.NORTHWEST; v.insets = new Insets(7, 0, 7, 0);
            p.add(html(nz(pasangan[i + 1]), LEBAR - 48 - 116 - 16 - 2, TEBAL, TEKS), v);
            y++;
            if (i + 2 < pasangan.length) {
                GridBagConstraints s = new GridBagConstraints();
                s.gridx = 0; s.gridy = y++; s.gridwidth = 2; s.fill = GridBagConstraints.HORIZONTAL;
                JPanel garis = new JPanel();
                garis.setBackground(GARIS);
                garis.setPreferredSize(new Dimension(1, 1));
                garis.setMinimumSize(new Dimension(1, 1));
                p.add(garis, s);
            }
        }
        return p;
    }

    private static JLabel teks(String t, Font f, Color c) {
        JLabel l = new JLabel(t);
        l.setFont(f);
        l.setForeground(c);
        return l;
    }

    /** Teks yang membungkus pada lebar tetap; tingginya dihitung dari lebar itu (tidak bergantung pada layout). */
    private static JComponent html(String t, int lebar, Font f, Color c) {
        return new Bungkus(t, lebar, f, c);
    }

    private static final class Bungkus extends JTextArea {
        private final int lebar;
        Bungkus(String t, int lebar, Font f, Color c) {
            super(t);
            this.lebar = lebar;
            setLineWrap(true);
            setWrapStyleWord(true);
            setEditable(false);
            setFocusable(false);
            setOpaque(false);
            setBorder(null);
            setMargin(new Insets(0, 0, 0, 0));
            setFont(f);
            setForeground(c);
        }
        @Override public Dimension getPreferredSize() {
            setSize(lebar, Short.MAX_VALUE);
            return new Dimension(lebar, super.getPreferredSize().height);
        }
        @Override public Dimension getMinimumSize() { return getPreferredSize(); }
    }

    private static String nz(String s) { return s == null || s.isBlank() ? "-" : s; }

    private static JComponent garisPutus() {
        JComponent c = new JComponent() {
            @Override protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setColor(new Color(190, 201, 222));
                g2.setStroke(new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10f, new float[]{5f, 4f}, 0f));
                g2.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
                g2.dispose();
            }
        };
        c.setPreferredSize(new Dimension(10, 14));
        c.setMinimumSize(new Dimension(10, 14));
        return c;
    }

    /** Label berbentuk pil berwarna (status). */
    private static final class Chip extends JLabel {
        private final Color warna;
        Chip(String t, Color warna) {
            super(t, SwingConstants.CENTER);
            this.warna = warna;
            setForeground(Color.WHITE);
            setFont(new Font("SansSerif", Font.BOLD, 12));
            setBorder(new EmptyBorder(5, 16, 5, 16));
            setOpaque(false);
        }
        @Override protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(warna);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), getHeight(), getHeight());
            g2.dispose();
            super.paintComponent(g);
        }
    }

    /** Panel dengan sudut membulat dan garis tepi tipis. */
    private static final class Kotak extends JPanel {
        private final Color isi, garis;
        Kotak(Color isi, Color garis) {
            this.isi = isi;
            this.garis = garis;
            setOpaque(false);
        }
        @Override protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(isi);
            g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 14, 14);
            g2.setColor(garis);
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 14, 14);
            g2.dispose();
            super.paintComponent(g);
        }
    }
}
