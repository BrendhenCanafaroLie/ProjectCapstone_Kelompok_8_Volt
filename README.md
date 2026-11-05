# VOLT - Sistem Tagihan Listrik (Java Swing + MySQL, MVC)

## Cara menjalankan
1. Impor `sql/volt.sql` ke MySQL (database `volt`). Skema terbaru sudah lengkap (termasuk `pengaduan.lintang/bujur`, `kasir.tanggal_setor`), jadi tidak ada file patch lagi.
2. Sesuaikan `src/main/resources/db.properties` (url / user / password MySQL).
3. JDK 17+ dan Maven (dependensi FlatLaf diunduh otomatis oleh Maven, butuh internet saat build pertama):
   - `mvn compile exec:java -Dexec.mainClass=Main`
   - atau `mvn package` lalu `java -jar target/volt-app-1.0.jar`
   - NetBeans/IntelliJ/Eclipse: buka sebagai Maven project, run `Main`.

## Akun uji (dari volt.sql)
| Peran | Username | Password |
|---|---|---|
| Admin | andi.pratama | admin01 |
| Admin | budi.setiawan | admin03 |
| Kasir | dewi.lestari | kasir04 |
| Petugas - Catat Meter | rizal.hakim | lapang07 |
| Petugas - Teknisi | bayu.saputra | lapang11 |
| Petugas - Keduanya | galih.pratama | lapang17 |
| Pelanggan Rumah Tangga | suparman01 | pass01 |
| Pelanggan Usaha | dedi16 | pass16 |
| (status Menunggu) | rendi46 | pass46 |
| (status Tidak Aktif) | hermanto20 | pass20 |

## Penyesuaian terhadap skema database `volt`
- Password disimpan **teks biasa** (`varchar(10)`), jadi login membandingkan teks persis (huruf besar/kecil dibedakan).
- Tidak ada trigger: kWh dan `total_biaya` dihitung di `PetugasController` = kWh x tarif + biaya beban golongan.
- `tagihan.id_kasir` wajib terisi di database, jadi saat petugas membuat tagihan, **kasir penanggung jawab dipilih otomatis**: kasir dengan tagihan `Belum Lunas` paling sedikit. Kasir yang menerima uang tetap tercatat di `pembayaran.id_kasir` (NULL untuk pembayaran online).
- Status tagihan (nilai di database): `Belum Lunas` -> `Lunas`, atau `Terlambat` bila lunas setelah jatuh tempo. Kolom `tagihan.bulan` berisi nama bulan (mis. `Oktober`); aplikasi menulis nama bulan dan tetap bisa membaca angka (`util/Bulan.java`).
- Pembayaran **sekali bayar, langsung lunas** (tanpa cicilan): nominal otomatis = total tagihan dan tidak bisa diubah; status langsung berubah saat dibayar. Digital (online) memakai `id_kasir = NULL`.
- Registrasi baru berstatus `Menunggu`; admin menyetujui (`Aktif`) atau menolak (`Tidak Aktif`, data tidak dihapus).
- Menu petugas: **semua** petugas lapangan dapat memperbarui status pengaduan pelanggan; tab Membuat Tagihan hanya untuk Catat Meter / Keduanya.
- Tidak ada ON DELETE CASCADE: hapus kasir/petugas menghapus baris jabatan lebih dulu (satu transaksi).
- Nilai enum/status semuanya ada di `util/Konstanta.java`.

## Struktur package
Package langsung di bawah `src/main/java` (tanpa awalan `com.volt`):

| Package | Isi |
|---|---|
| `controller` | logika alur & validasi |
| `dao` | akses database (JDBC) |
| `model` | entitas |
| `util` | Database, Konstanta, Fmt, dll. |
| `view` | panel, `MainFrame`, `Navigator` |
| `view.komponen` | `KartuStat` (form kartu angka) |
| *(default package)* | `Main` (titik masuk program) |

## Struktur View (JPanel Form - NetBeans, 100% Designer)
Seluruh tampilan sekarang dibuat lewat **GUI Designer NetBeans** (pasangan `Nama.java` + `Nama.form`): posisi, ukuran, teks,
**warna latar/huruf, font, dan border** semuanya properti komponen di tab **Design**, bukan kode. Kelas Java hanya berisi logika
(controller, tabel, validasi, event handler).

| Kelompok | Form (JPanel/JFrame Form) |
|---|---|
| Jendela | `MainFrame` (JFrame Form, CardLayout `wadah`): kartu `masuk`, `admin`, `kasir`, `petugas`, `pelanggan`, masing-masing berisi panel di bawah |
| Sebelum login | `LayarMasuk` (panel merek + kartu `menu` / `login` / `daftar`) berisi `PanelMenuUtama`, `PanelLogin`, `PanelDaftar` |
| Menu per peran | `PanelMenuAdmin`, `PanelMenuKasir`, `PanelMenuPetugas` (sidebar), `PanelMenuPelanggan` (navbar atas); tombol menu **dan semua halamannya** terpasang langsung di form |
| Admin | `PanelDashboardAdmin` (kartu angka + `PanelDashboard` berisi 4 tab tabel), `PanelPetugas`, `PanelGolongan`, `PanelRegistrasi`, `PanelPembayaranAdmin`, `PanelPengaduanAdmin` |
| Petugas Lapangan | `PanelBuatTagihan`, `PanelUpdatePengaduan` |
| Kasir | `PanelTransaksi`, `PanelRiwayatKasir` |
| Semua karyawan | `PanelProfilKaryawan` |
| Pelanggan | `PanelBeranda`, `PanelProfil`, `PanelTagihanSaya`, `PanelLaporGangguan` (+ `DialogLaporGangguan`, `DialogTeks`) |
| Komponen | `view.komponen.KartuStat` (kartu angka berwarna; properti `judul` & `aksen` dapat diubah di Designer) |

**Design = tampilan saat program jalan.** Tidak ada lagi panel/tombol/tab yang dirakit lewat kode saat program berjalan.
Halaman-halaman ditanam sebagai komponen di form (`pgPetugas`, `pgDashboard`, dst.) dan setiap panel punya konstruktor tanpa argumen,
sehingga NetBeans bisa menampilkannya di tab Design. Controller dan data pengguna baru dipasang saat login
(`setController(...)`, `BaseMenuPanel.mulai(pengguna, nav)`); data database hanya dimuat lewat `muat()`, bukan di konstruktor.

Kelas non-form di package `view`: `BaseMenuPanel` (logika navigasi: isi teks, pasang controller, pindah halaman),
`Navigator`, `BasePanel`, `Ui`, `Tampilan`.

Tips di NetBeans:
- Agar Design memakai tema yang sama dengan program: *Tools > Options > Java > GUI Builder > Look and Feel*, pilih **FlatLaf Light** (FlatLaf sudah ada di dependensi Maven; jalankan Clean and Build dulu).
- Buka file `.java` -> tab **Design**. Jalankan **Clean and Build** dulu bila Design belum muncul.
- Warna diubah lewat jendela **Properties** (background / foreground / font / border) pada komponen yang dipilih.
- Nama komponen memakai awalan: `lbl` label, `txt` kolom teks, `btn` tombol, `cmb` combo box, `tbl` tabel, `scr` scroll pane, `pnl` panel, `spn` spinner, `rad` radio button, `k` kartu statistik.
- Jangan menghapus/mengganti nama komponen yang dipakai kode (mis. `tblPetugas`, `txtNama`). Menambah komponen baru bebas.
- Dua hal tetap diisi dari kode karena bergantung pada data/peran saat berjalan: isi combo box & model tabel, serta tombol menu
  sidebar (jumlahnya berbeda per peran) dan tab rincian di `PanelDashboard`.

## Tampilan & warna
Palet: biru tua `#0B1F4B` (sidebar, header tabel), biru `#1D4ED8` (aksi utama), kuning `#F59E0B` (aksen), hijau (tambah/simpan/bayar),
merah (hapus/tolak/keluar), latar halaman biru muda `#EEF3FB`.
- Tema dasar FlatLaf + warna tabel/tab/menu diatur di `view/Tampilan.java` (`UIManager`, satu tempat).
- Warna tombol, judul (pita biru muda), kolom isian, panel, dan kartu diatur per komponen di file `.form`.
- Kartu statistik: aksen warna berbeda per kartu (`KartuStat.aksen`).
- Tidak ada gambar/ikon/grafik buatan kode.

## Struktur MVC & 4 pilar OOP
- `model`, `dao`, `controller`, `view`, `util`.
- Enkapsulasi: field private + getter/setter.
- Pewarisan: Pengguna -> Karyawan -> Admin/Kasir/PetugasLapangan; Pengguna -> Pelanggan -> RumahTangga/Usaha; BasePanel, BaseDao, BaseController.
- Polimorfisme: getPeran(), getDetail(), getJenis(), cetak(); MainFrame memilih menu per tipe akun (instanceof).
- Abstraksi: kelas abstrak (Pengguna, Karyawan, Pelanggan, BaseMenuFrame) dan interface (CrudDao, Cetakable, Refreshable).

## Pencarian tabel
Semua tabel data (kecuali Transaksi kasir, yang sudah punya pencarian ke database) memiliki kolom **Cari** di atasnya:
- Menyaring langsung saat mengetik; tidak membedakan huruf besar/kecil; memeriksa semua kolom.
- Beberapa kata dipisah spasi harus cocok semuanya (mis. `kasir belum` ).
- Tombol **Hapus** atau tombol Esc mengosongkan pencarian; di kanan tampil jumlah hasil ("2 dari 18 data").
- Diimplementasi sekali di `Ui.pasangPencarian(tabel, petunjuk)` dan dipanggil di konstruktor tiap panel setelah `Ui.siapkanTabel(...)`.
  Hanya menyaring tampilan (RowFilter); `Ui.terpilih()` tetap memberi indeks model yang benar, jadi tombol ubah/hapus/bayar tidak salah sasaran.


## Catatan perbaikan
- Bug "Tagihan Sudah Lunas" padahal belum: nilai status di DB `BELUM_LUNAS`, kode membandingkan dengan "Belum Lunas". Sudah diseragamkan (`Konstanta.belumLunas()`).
- Cicilan dihapus (masukan pengguna): satu tagihan dibayar satu kali sebesar total, status langsung LUNAS/TERLAMBAT. Kolom "Sisa" dan input nominal sudah dihapus dari tampilan kasir & pelanggan.
- Password disimpan teks biasa (tanpa hash), panjang 6-10 karakter.
- Tampilan avatar bulat (inisial) di header dan sidebar sudah dihapus.
- Revisi tampilan 1: gambar buatan kode dihapus dan UI dialihkan ke FlatLaf.
- Revisi tampilan 2: semua layar dipindah ke form Designer (tanpa UI hasil kode), ditambah palet warna (lihat "Tampilan & warna"); kelas lama `DaftarDialog`, `LoginDialog`, `*Frame`, `FrameFactory`, `PanelMerek`, `PanelRingkasanAdmin`, `Kartu` dihapus/digabung.

## Efek hover tombol
Efek hover (perubahan warna saat kursor melintas) pada tombol dan tab navigasi dimatikan di `Tampilan.matikanHoverTombol()`
(dipanggil dari `Tampilan.pasang()`). Efek tekan saat tombol diklik tetap ada. Untuk mengaktifkannya lagi, hapus pemanggilan itu.

## Pembaruan terbaru (Admin)
- **Data petugas dan Golongan tarif**: tampilan disamakan dengan Registrasi pengguna (judul di atas, tabel penuh di tengah, form dan tombol di bawah).
- **Laporan pengaduan**: tabel detail di bawah dihapus; diganti tombol **Lihat Detail Pengaduan** dan **Muat Ulang** seperti Riwayat pembayaran.
- **Profil saya**: jarak antara data akun dan atribut khusus (Email / Status Setoran / Wilayah) diperlebar.
- **Status setor Kasir**: kolom baru `kasir.tanggal_setor`. Di menu *Data Petugas*, pilih akun Kasir lalu ubah **Setoran** (Belum Setor / Sudah Setor) dan **Tgl Setor** (yyyy-MM-dd; kosong = hari ini; Belum Setor mengosongkan tanggal). Hanya Admin yang dapat mengubahnya; Kasir hanya melihat di Profil saya.
- **Registrasi pengguna**: semua pendaftar tetap tampil dengan kolom **Status** (Menunggu, Aktif, Tidak Aktif); data tidak hilang setelah disetujui atau ditolak. Yang Menunggu ditampilkan paling atas.

## Pembaruan (Petugas)
- Membuat Tagihan: Bulan & Tahun kini kolom isian biasa (seragam dengan Meter Awal/Akhir/Jatuh Tempo), terisi otomatis bulan/tahun sekarang; validasi tahun 2000-2100.
- Tata letak mengikuti Registrasi Pengguna: judul di atas, tabel penuh di tengah, form + tombol di bawah.

## Pembaruan terbaru (9-12)
- **Petugas lapangan - Status pengaduan**: tampilan disamakan dengan Laporan pengaduan admin (tabel penuh + tombol **Lihat Detail Pengaduan** / **Muat Ulang**); detail tampil di dialog. Pembaruan status tetap ada di baris tombol (**Status baru** + **Perbarui Status**).
- **Pengaduan**: atribut baru `lintang` dan `bujur` (tipe `decimal(9,6)`, titik koordinat lokasi pelapor). Diambil otomatis saat membuat laporan dari lokasi pengguna (perkiraan berbasis IP lewat ipwho.is, butuh internet); dapat dikoreksi manual, boleh kosong bila gagal.
- **Pelanggan - Lapor gangguan**: menu *Lapor gangguan* dan *Status pengaduan* digabung menjadi satu menu **Lapor gangguan**: tabel laporan + tombol **Buat Laporan Baru** (dialog form), **Lihat Detail Pengaduan**, **Muat Ulang** (gaya sama seperti Registrasi pengguna admin).
- **Kasir**: tombol **Proses Pembayaran** dan **Cetak Ulang Bukti** diubah menjadi biru agar konsisten.

## Penyesuaian skema `volt` terbaru
- `pengaduan.lintang` & `pengaduan.bujur` (`decimal(9,6)`) kini **NOT NULL**: pelanggan wajib mengisi koordinat saat melapor (otomatis dari lokasi, bisa dikoreksi manual).
- `karyawan/pelanggan`: username maksimal 30 karakter, password maksimal 10 karakter (6-10 divalidasi di aplikasi); `pelanggan.no_telepon` wajib.
- `kasir.tanggal_setor` bertipe `datetime`; admin 3 (Budi Setiawan) kini Admin, kasir adalah id 4-6, petugas lapangan id 7-20.

## Tampilan tabel
Semua tabel: judul kolom rata tengah; isi numerik (angka, rupiah) rata tengah (`Ui.gayaTabel`).

## Komponen dari Palette NetBeans (bukan kode)
- **Tabel**: kolom/judul setiap `JTable` kini didefinisikan di Designer (properti `model` -> Table Model), bukan lagi lewat `Ui.modelTabel(...)` di kode. Mengubah judul kolom = ubah di Design view. Kode hanya mengisi baris (`model.addRow`) dan memasang gaya standar `Ui.siapkanTabel(tbl)`. Pengecualian: tabel di *Dashboard statistik* kolomnya mengikuti hasil query sehingga tetap dibuat dari kode.
- **Kolom pencarian**: `pnlCari` berisi `lblCari`, `txtCari`, `lblJumlah` (komponen Palette, bisa dipindah/diubah di Design view). `Ui.pasangPencarian(tbl, txtCari, lblJumlah, petunjuk)` hanya menyambungkan logika penyaringan.
- **Pilihan ComboBox tetap** (jabatan, spesialis, setoran, metode bayar, status pengaduan, subsidi) diisi lewat properti `model` di Designer. Combo yang isinya dari database (mis. golongan) tetap diisi dari kode.
- **Dialog**: `DialogLaporGangguan` (form Buat Laporan Baru) dan `DialogTeks` (detail/bukti) kini JDialog Form NetBeans (`.form`), bukan dibangun dengan kode.

## Struktur paket view (dipisah per peran)
- `view/auth/`      : LayarMasuk, PanelMenuUtama (Login/Daftar/Keluar), PanelLogin, PanelDaftar
- `view/admin/`     : PanelMenuAdmin, PanelDashboard(Admin), PanelPetugas, PanelGolongan, PanelRegistrasi, PanelPembayaranAdmin, PanelPengaduanAdmin
- `view/pelanggan/` : PanelMenuPelanggan, PanelBeranda, PanelTagihanSaya, PanelLaporGangguan, DialogLaporGangguan, PanelProfil
- `view/petugas/`   : PanelMenuPetugas, PanelBuatTagihan, PanelUpdatePengaduan
- `view/kasir/`     : PanelMenuKasir, PanelTransaksi, PanelRiwayatKasir
- `view/` (bersama) : MainFrame, Tampilan, Navigator, Refreshable, Ui, BasePanel, BaseMenuPanel, DialogTeks, PanelProfilKaryawan (dipakai Admin/Kasir/Petugas), komponen/
Pasangan .java dan .form selalu berada di folder yang sama.
