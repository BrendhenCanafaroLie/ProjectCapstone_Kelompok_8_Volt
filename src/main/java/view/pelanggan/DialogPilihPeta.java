package view.pelanggan;

import view.Tampilan;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Dialog "Pilih Lokasi di Peta": peta OpenStreetMap (tanpa library tambahan) yang bisa digeser (seret),
 * di-zoom (roda mouse / tombol +/-), dicari alamatnya, lalu diklik untuk menentukan titik gangguan.
 * Dibuat lewat kode (bukan Form NetBeans) karena isinya berupa kanvas peta kustom. Butuh koneksi internet.
 */
public final class DialogPilihPeta extends JDialog {
    private static final Color TEKS = new Color(30, 41, 59);
    private static final Color REDUP = new Color(0x6B7280);

    private final Peta peta;
    private final JLabel lblKoordinat = new JLabel("Klik pada peta untuk menandai lokasi gangguan.");
    private final JButton btnPakai = new JButton("Gunakan Lokasi Ini");
    private double[] hasil;

    private DialogPilihPeta(Component induk, Double lintang, Double bujur) {
        super(induk == null ? null : SwingUtilities.getWindowAncestor(induk));
        setTitle("Pilih Lokasi di Peta");
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        boolean ada = lintang != null && bujur != null;
        peta = new Peta(ada ? lintang : -0.502106, ada ? bujur : 117.153709, ada ? 16 : 13);
        if (ada) peta.tandai(lintang, bujur);
        peta.setOnPilih((la, lo) -> {
            lblKoordinat.setText(String.format(Locale.US, "Titik terpilih:  %.6f, %.6f", la, lo));
            btnPakai.setEnabled(true);
        });

        // kepala
        JPanel kepala = new JPanel(new BorderLayout());
        kepala.setBackground(Tampilan.NAVY);
        kepala.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 3, 0, Tampilan.AMBER), new EmptyBorder(14, 22, 12, 22)));
        JLabel merek = new JLabel("VOLT");
        merek.setFont(new Font("SansSerif", Font.BOLD, 11));
        merek.setForeground(Tampilan.AMBER);
        JLabel jdl = new JLabel("Pilih Lokasi Gangguan");
        jdl.setFont(new Font("SansSerif", Font.BOLD, 20));
        jdl.setForeground(Color.WHITE);
        JLabel sub = new JLabel("Cari alamat, geser peta, lalu klik titik tempat gangguan terjadi.");
        sub.setFont(new Font("SansSerif", Font.PLAIN, 12));
        sub.setForeground(new Color(180, 198, 235));
        JPanel teks = new JPanel();
        teks.setOpaque(false);
        teks.setLayout(new BoxLayout(teks, BoxLayout.Y_AXIS));
        teks.add(merek); teks.add(jdl); teks.add(sub);
        kepala.add(teks, BorderLayout.CENTER);

        // pencarian alamat
        JTextField txtCari = new JTextField();
        txtCari.putClientProperty("JTextField.placeholderText", "Cari alamat / nama tempat (mis. Jl. Pahlawan Samarinda)");
        JButton btnCari = new JButton("Cari");
        btnCari.setBackground(Tampilan.BIRU);
        btnCari.setForeground(Color.WHITE);
        btnCari.setFont(new Font("SansSerif", Font.BOLD, 12));
        JPanel cari = new JPanel(new BorderLayout(8, 0));
        cari.setBorder(new EmptyBorder(10, 22, 10, 22));
        cari.setBackground(Color.WHITE);
        cari.add(txtCari, BorderLayout.CENTER);
        cari.add(btnCari, BorderLayout.EAST);
        ActionListener lakukanCari = e -> cariAlamat(txtCari.getText(), btnCari);
        btnCari.addActionListener(lakukanCari);
        txtCari.addActionListener(lakukanCari);

        JPanel atas = new JPanel(new BorderLayout());
        atas.add(kepala, BorderLayout.NORTH);
        atas.add(cari, BorderLayout.SOUTH);

        // kaki
        lblKoordinat.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblKoordinat.setForeground(TEKS);
        JButton btnBatal = new JButton("Batal");
        btnBatal.setBackground(new Color(71, 85, 105));
        btnBatal.setForeground(Color.WHITE);
        btnBatal.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnBatal.setPreferredSize(new Dimension(100, 34));
        btnBatal.addActionListener(e -> dispose());
        btnPakai.setBackground(new Color(22, 163, 74));
        btnPakai.setForeground(Color.WHITE);
        btnPakai.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnPakai.setPreferredSize(new Dimension(170, 34));
        btnPakai.setEnabled(ada);
        btnPakai.addActionListener(e -> {
            hasil = peta.titik();
            dispose();
        });
        JPanel tombol = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        tombol.setOpaque(false);
        tombol.add(btnBatal);
        tombol.add(btnPakai);
        JPanel kaki = new JPanel(new BorderLayout());
        kaki.setBackground(new Color(246, 249, 255));
        kaki.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(226, 232, 244)), new EmptyBorder(12, 22, 12, 22)));
        kaki.add(lblKoordinat, BorderLayout.CENTER);
        kaki.add(tombol, BorderLayout.EAST);

        JPanel akar = new JPanel(new BorderLayout());
        akar.add(atas, BorderLayout.NORTH);
        akar.add(peta, BorderLayout.CENTER);
        akar.add(kaki, BorderLayout.SOUTH);
        akar.setPreferredSize(new Dimension(820, 640));
        setContentPane(akar);
        getRootPane().registerKeyboardAction(e -> dispose(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);
        pack();
        setLocationRelativeTo(induk);
    }

    /** Tampilkan dialog; mengembalikan {lintang, bujur} atau null bila dibatalkan. */
    public static double[] pilih(Component induk, Double lintang, Double bujur) {
        DialogPilihPeta d = new DialogPilihPeta(induk, lintang, bujur);
        d.setVisible(true);
        return d.hasil;
    }

    // ---------- Pencarian alamat (Nominatim / OpenStreetMap)
    private static final Pattern LAT = Pattern.compile("\"lat\"\\s*:\\s*\"(-?\\d+(?:\\.\\d+)?)\"");
    private static final Pattern LON = Pattern.compile("\"lon\"\\s*:\\s*\"(-?\\d+(?:\\.\\d+)?)\"");

    private void cariAlamat(String kata, JButton tombol) {
        if (kata == null || kata.isBlank()) return;
        tombol.setEnabled(false);
        lblKoordinat.setText("Mencari alamat...");
        new SwingWorker<double[], Void>() {
            @Override protected double[] doInBackground() throws Exception {
                HttpClient http = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(6)).build();
                HttpRequest req = HttpRequest.newBuilder(URI.create("https://nominatim.openstreetmap.org/search?format=json&limit=1&q="
                                + URLEncoder.encode(kata.trim(), StandardCharsets.UTF_8)))
                        .header("User-Agent", "VoltApp/1.0 (aplikasi pengaduan listrik)")
                        .timeout(Duration.ofSeconds(10)).GET().build();
                String body = http.send(req, HttpResponse.BodyHandlers.ofString()).body();
                Matcher a = LAT.matcher(body), b = LON.matcher(body);
                return a.find() && b.find() ? new double[]{Double.parseDouble(a.group(1)), Double.parseDouble(b.group(1))} : null;
            }
            @Override protected void done() {
                tombol.setEnabled(true);
                try {
                    double[] k = get();
                    if (k == null) { lblKoordinat.setText("Alamat tidak ditemukan. Coba kata kunci lain."); return; }
                    peta.pusatkan(k[0], k[1], 17);
                    lblKoordinat.setText("Alamat ditemukan. Klik pada peta untuk menandai titik yang tepat.");
                } catch (Exception e) {
                    lblKoordinat.setText("Gagal mencari (periksa koneksi internet).");
                }
            }
        }.execute();
    }

    // ---------- Kanvas peta
    private interface Pilih { void pada(double lintang, double bujur); }

    private static final class Peta extends JPanel {
        private static final int UBIN = 256, Z_MIN = 3, Z_MAX = 19;
        private static final ExecutorService POOL = Executors.newFixedThreadPool(4, r -> {
            Thread t = new Thread(r, "ubin-peta");
            t.setDaemon(true);
            return t;
        });
        private static final BufferedImage KOSONG = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        /** Server ubin: dicoba berurutan; bila satu diblokir / gagal, pindah ke berikutnya. */
        private static final String[] SERVER = {
            "https://tile.openstreetmap.org/%d/%d/%d.png",
            "https://a.basemaps.cartocdn.com/rastertiles/voyager/%d/%d/%d.png",
            "https://b.basemaps.cartocdn.com/rastertiles/voyager/%d/%d/%d.png"
        };
        private static final String UA = "Mozilla/5.0 (VoltApp/1.0; aplikasi pengaduan listrik desktop)";
        private final Map<String, BufferedImage> cache = new ConcurrentHashMap<>();
        private final Map<String, Long> gagal = new ConcurrentHashMap<>();   // kunci ubin -> waktu gagal
        private volatile String galat;                                          // pesan kegagalan terakhir
        private final javax.swing.Timer ulang = new javax.swing.Timer(4000, e -> { if (!gagal.isEmpty()) repaint(); });

        private int zoom;
        private double cx, cy;               // pusat tampilan dalam piksel dunia pada zoom saat ini
        private Double tLat, tLon;           // titik terpilih
        private Pilih pilih;
        private Point seret;
        private boolean bergeser;

        Peta(double lat, double lon, int zoom) {
            this.zoom = zoom;
            cx = px(lon, zoom);
            cy = py(lat, zoom);
            setBackground(new Color(226, 232, 240));
            setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
            MouseAdapter m = new MouseAdapter() {
                @Override public void mousePressed(MouseEvent e) { seret = e.getPoint(); bergeser = false; }
                @Override public void mouseDragged(MouseEvent e) {
                    if (seret == null) return;
                    int dx = e.getX() - seret.x, dy = e.getY() - seret.y;
                    if (!bergeser && Math.abs(dx) + Math.abs(dy) < 4) return;
                    bergeser = true;
                    cx -= dx; cy -= dy;
                    seret = e.getPoint();
                    repaint();
                }
                @Override public void mouseReleased(MouseEvent e) {
                    if (!bergeser && SwingUtilities.isLeftMouseButton(e)) {
                        double wx = cx - getWidth() / 2.0 + e.getX(), wy = cy - getHeight() / 2.0 + e.getY();
                        tandai(lat(wy, Peta.this.zoom), lon(wx, Peta.this.zoom));
                        if (pilih != null) pilih.pada(tLat, tLon);
                    }
                    seret = null;
                }
                @Override public void mouseWheelMoved(MouseWheelEvent e) { ubahZoom(e.getWheelRotation() < 0 ? 1 : -1, e.getPoint()); }
            };
            addMouseListener(m);
            addMouseMotionListener(m);
            addMouseWheelListener(m);
            ulang.start();
            setLayout(null);
            JButton plus = tombolZoom("+", 1), minus = tombolZoom("−", -1);
            add(plus); add(minus);
            addComponentListener(new ComponentAdapter() {
                @Override public void componentResized(ComponentEvent e) {
                    plus.setBounds(getWidth() - 50, 14, 36, 36);
                    minus.setBounds(getWidth() - 50, 54, 36, 36);
                }
            });
        }

        private JButton tombolZoom(String t, int arah) {
            JButton b = new JButton(t);
            b.setFont(new Font("SansSerif", Font.BOLD, 18));
            b.setBackground(Color.WHITE);
            b.setForeground(Tampilan.NAVY);
            b.setFocusable(false);
            b.setMargin(new Insets(0, 0, 0, 0));
            b.addActionListener(e -> ubahZoom(arah, new Point(getWidth() / 2, getHeight() / 2)));
            return b;
        }

        void setOnPilih(Pilih p) { this.pilih = p; }
        void tandai(double lat, double lon) { tLat = lat; tLon = lon; repaint(); }
        double[] titik() { return tLat == null ? null : new double[]{tLat, tLon}; }

        void pusatkan(double lat, double lon, int z) {
            zoom = Math.max(Z_MIN, Math.min(Z_MAX, z));
            cx = px(lon, zoom);
            cy = py(lat, zoom);
            repaint();
        }

        private void ubahZoom(int arah, Point jangkar) {
            int z = zoom + arah;
            if (z < Z_MIN || z > Z_MAX) return;
            // titik di bawah kursor tetap di tempatnya
            double wx = cx - getWidth() / 2.0 + jangkar.x, wy = cy - getHeight() / 2.0 + jangkar.y;
            double lat = lat(wy, zoom), lon = lon(wx, zoom);
            zoom = z;
            cx = px(lon, z) - jangkar.x + getWidth() / 2.0;
            cy = py(lat, z) - jangkar.y + getHeight() / 2.0;
            repaint();
        }

        private static double px(double lon, int z) { return (lon + 180) / 360 * UBIN * (1L << z); }
        private static double py(double lat, int z) {
            double r = Math.toRadians(lat);
            return (1 - Math.log(Math.tan(r) + 1 / Math.cos(r)) / Math.PI) / 2 * UBIN * (1L << z);
        }
        private static double lon(double x, int z) { return x / (UBIN * (double) (1L << z)) * 360 - 180; }
        private static double lat(double y, int z) {
            double n = Math.PI - 2 * Math.PI * y / (UBIN * (double) (1L << z));
            return Math.toDegrees(Math.atan(Math.sinh(n)));
        }

        private BufferedImage ubin(int z, int x, int y) {
            String kunci = z + "/" + x + "/" + y;
            BufferedImage ada = cache.get(kunci);
            if (ada != null) return ada == KOSONG ? null : ada;
            Long t = gagal.get(kunci);
            if (t != null && System.currentTimeMillis() - t < 4000) return null;   // tunggu sebelum coba lagi
            gagal.remove(kunci);
            if (cache.size() > 400) cache.clear();
            cache.put(kunci, KOSONG);   // tandai sedang dimuat
            POOL.execute(() -> {
                String sebab = "tidak ada respons";
                for (String pola : SERVER) {
                    try {
                        HttpURLConnection c = (HttpURLConnection) new URL(String.format(pola, z, x, y)).openConnection();
                        c.setRequestProperty("User-Agent", UA);
                        c.setRequestProperty("Referer", "https://volt.local/");
                        c.setConnectTimeout(6000);
                        c.setReadTimeout(8000);
                        int kode = c.getResponseCode();
                        if (kode != 200) { sebab = "server menjawab HTTP " + kode; continue; }
                        BufferedImage img = ImageIO.read(c.getInputStream());
                        if (img == null) { sebab = "gambar ubin tidak valid"; continue; }
                        cache.put(kunci, img);
                        galat = null;
                        SwingUtilities.invokeLater(this::repaint);
                        return;
                    } catch (Exception e) {
                        sebab = e.getClass().getSimpleName() + (e.getMessage() == null ? "" : ": " + e.getMessage());
                    }
                }
                galat = sebab;
                cache.remove(kunci);
                gagal.put(kunci, System.currentTimeMillis());
                SwingUtilities.invokeLater(this::repaint);
            });
            return null;
        }

        @Override protected void paintComponent(Graphics g0) {
            super.paintComponent(g0);
            Graphics2D g = (Graphics2D) g0.create();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int w = getWidth(), h = getHeight();
            double kiri = cx - w / 2.0, atas = cy - h / 2.0;
            int n = 1 << zoom;
            for (int tx = (int) Math.floor(kiri / UBIN); tx <= (int) Math.floor((kiri + w) / UBIN); tx++) {
                for (int ty = (int) Math.floor(atas / UBIN); ty <= (int) Math.floor((atas + h) / UBIN); ty++) {
                    if (ty < 0 || ty >= n) continue;
                    int dx = (int) Math.round(tx * UBIN - kiri), dy = (int) Math.round(ty * UBIN - atas);
                    BufferedImage img = ubin(zoom, ((tx % n) + n) % n, ty);
                    if (img != null) g.drawImage(img, dx, dy, UBIN, UBIN, null);
                    else {
                        g.setColor(new Color(236, 240, 246));
                        g.fillRect(dx, dy, UBIN, UBIN);
                        g.setColor(new Color(214, 221, 232));
                        g.drawRect(dx, dy, UBIN, UBIN);
                    }
                }
            }
            if (tLat != null) {
                int mx = (int) Math.round(px(tLon, zoom) - kiri), my = (int) Math.round(py(tLat, zoom) - atas);
                g.setColor(new Color(0, 0, 0, 60));
                g.fillOval(mx - 7, my - 3, 14, 6);
                Polygon jarum = new Polygon(new int[]{mx - 9, mx + 9, mx}, new int[]{my - 22, my - 22, my}, 3);
                g.setColor(new Color(220, 38, 38));
                g.fillOval(mx - 13, my - 40, 26, 26);
                g.fillPolygon(jarum);
                g.setColor(Color.WHITE);
                g.fillOval(mx - 5, my - 32, 10, 10);
            }
            if (galat != null) {
                String m = "Peta belum dapat dimuat - periksa koneksi internet. Mencoba lagi otomatis...";
                System.err.println("[Peta] " + galat);
                g.setFont(new Font("SansSerif", Font.BOLD, 12));
                g.setColor(new Color(254, 226, 226));
                g.fillRect(0, h - 44, w, 26);
                g.setColor(new Color(153, 27, 27));
                g.drawString(m, 10, h - 26);
            }
            String hak = "© OpenStreetMap contributors © CARTO";
            g.setFont(new Font("SansSerif", Font.PLAIN, 11));
            int lb = g.getFontMetrics().stringWidth(hak) + 12;
            g.setColor(new Color(255, 255, 255, 200));
            g.fillRect(w - lb, h - 18, lb, 18);
            g.setColor(REDUP);
            g.drawString(hak, w - lb + 6, h - 5);
            g.dispose();
        }
    }
}
