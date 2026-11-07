# VOLT — Sistem Tagihan Listrik & Pengaduan Gangguan

> Aplikasi desktop berbasis **Java Swing + MySQL** dengan arsitektur **MVC** untuk mengelola tagihan listrik, pembayaran, dan pengaduan gangguan pelanggan.

---

## Daftar Isi
1. [Nama Program](#1-nama-program)
2. [Deskripsi Singkat](#2-deskripsi-singkat)
3. [Fitur Utama Program](#3-fitur-utama-program)
4. [Tech Stack](#4-tech-stack)
5. [Perancangan Sistem](#5-perancangan-sistem)
6. [Struktur Folder / Package](#6-struktur-folder--package)
7. [Penerapan 4 Pilar OOP](#7-penerapan-4-pilar-oop)
8. [Cara Penggunaan Program](#8-cara-penggunaan-program)
9. [Kontributor](#9-kontributor)

---

## 1. Nama Program

**VOLT** — Sistem Tagihan Listrik & Pengaduan Gangguan (Samarinda).

---

## 2. Deskripsi Singkat

VOLT membantu penyedia layanan listrik mengelola proses dari ujung ke ujung dalam satu aplikasi:
petugas lapangan mencatat meter dan membuat tagihan, pelanggan melihat dan membayar tagihan, kasir memproses pembayaran tunai,
dan admin mengelola data master serta memantau statistik. Pelanggan juga dapat melaporkan gangguan listrik (lengkap dengan koordinat lokasi
yang bisa dipilih di peta), lalu petugas lapangan memperbarui status penanganannya.

Aplikasi memiliki **4 peran**: **Admin**, **Kasir**, **Petugas Lapangan**, dan **Pelanggan** (Rumah Tangga / Usaha). Menu yang tampil mengikuti peran akun yang login.

---

## 3. Fitur Utama Program

| Peran | Fitur |
|---|---|
| **Umum** | Login berbasis peran • Pendaftaran pelanggan baru (status *Menunggu* sampai disetujui admin) • Pencarian langsung di semua tabel • Profil akun |
| **Admin** | Dashboard statistik (kartu angka + tabel rincian) • CRUD data petugas (Kasir / Petugas Lapangan) & status setoran kasir • CRUD golongan tarif • Persetujuan / penolakan registrasi pelanggan • Riwayat pembayaran • Laporan pengaduan |
| **Petugas Lapangan** | Membuat tagihan (kWh & total biaya dihitung otomatis dari tarif + biaya beban golongan) • Melihat detail seluruh tagihan seorang pelanggan • Memperbarui status pengaduan (*Dilaporkan → Diproses → Selesai*) |
| **Kasir** | Mencari tagihan belum lunas • Memproses pembayaran tunai • Mencetak ulang bukti pembayaran • Riwayat transaksi |
| **Pelanggan** | Beranda ringkasan (pemakaian & tagihan) • Tagihan & riwayat kWh • Pembayaran online (sekali bayar, langsung lunas) • Lapor gangguan dengan **pemilih lokasi di peta (OpenStreetMap)** • Memantau status pengaduan • Ubah profil |

**Aturan bisnis penting**
- Pembayaran **sekali bayar, langsung lunas** (tanpa cicilan); status menjadi `Lunas`, atau `Terlambat` bila dibayar setelah jatuh tempo.
- `total_biaya = kWh × tarif per kWh + biaya beban` golongan pelanggan.
- Registrasi baru berstatus `Menunggu` → admin menyetujui (`Aktif`) atau menolak (`Tidak Aktif`).
- Pembayaran digital (online) dicatat dengan `id_kasir = NULL`.

---

## 4. Tech Stack

| Kategori | Teknologi |
|---|---|
| Bahasa | **Java 17** |
| Antarmuka (GUI) | **Java Swing** — dirancang dengan *GUI Builder* **Apache NetBeans** (pasangan `.java` + `.form`) |
| Look & Feel | **FlatLaf 3.4.1** |
| Database | **MySQL 8** |
| Konektor DB | **MySQL Connector/J 8.4.0** (JDBC, `PreparedStatement`) |
| Build tool | **Apache Maven** (`maven-shade-plugin` untuk *fat jar*) |
| Arsitektur | **MVC** + pola **DAO** |
| Layanan eksternal | OpenStreetMap (peta & ubin), Nominatim (pencarian alamat), ipwho.is (perkiraan lokasi) — membutuhkan internet |

---

## 5. Perancangan Sistem

> Diagram ditulis dengan **Mermaid**, sehingga tampil otomatis di GitHub. Jika dosen meminta gambar, ekspor lewat <https://mermaid.live> lalu simpan ke `docs/diagram/`.

### 5.1 Flowchart

**a) Alur umum aplikasi**

```mermaid
flowchart TD
    A([Mulai]) --> B["Jalankan Main<br/>pasang FlatLaf"]
    B --> C{"Koneksi database<br/>berhasil?"}
    C -- Tidak --> D["Tampilkan pesan error<br/>& keluar"]
    C -- Ya --> E["Layar Masuk<br/>(Login / Daftar / Keluar)"]
    E --> F{"Pilihan"}
    F -- Daftar --> G["Isi form pendaftaran<br/>status = Menunggu"]
    G --> E
    F -- Login --> H["Masukkan username & password"]
    H --> I{"Akun valid &<br/>status Aktif?"}
    I -- Tidak --> J["Tampilkan pesan gagal"]
    J --> E
    I -- Ya --> K{"Peran akun?"}
    K -- Admin --> L["Menu Admin"]
    K -- Kasir --> M["Menu Kasir"]
    K -- Petugas Lapangan --> N["Menu Petugas"]
    K -- Pelanggan --> O["Menu Pelanggan"]
    L --> P["Keluar"]
    M --> P
    N --> P
    O --> P
    P --> E
```

**b) Alur tagihan dan pembayaran**

```mermaid
flowchart TD
    A([Petugas pilih pelanggan]) --> B["Isi bulan, tahun,<br/>meter awal & akhir, jatuh tempo"]
    B --> C{"Input valid?<br/>meter akhir ≥ awal"}
    C -- Tidak --> B
    C -- Ya --> D["Hitung kWh dan<br/>total = kWh × tarif + biaya beban"]
    D --> E["Simpan tagihan<br/>status: Belum Lunas<br/>kasir PJ dipilih otomatis"]
    E --> F{"Cara pembayaran"}
    F -- "Tunai di kasir" --> G["Kasir cari tagihan<br/>& proses pembayaran"]
    F -- "Online oleh pelanggan" --> H["Pelanggan konfirmasi<br/>pembayaran"]
    G --> I{"Dibayar setelah<br/>jatuh tempo?"}
    H --> I
    I -- Tidak --> J["Status: Lunas"]
    I -- Ya --> K["Status: Terlambat"]
    J --> L["Cetak / lihat bukti pembayaran"]
    K --> L
    L --> M([Selesai])
```

**c) Alur pengaduan gangguan**

```mermaid
flowchart TD
    A([Pelanggan buka Lapor Gangguan]) --> B["Buat Laporan Baru"]
    B --> C["Isi lokasi & deskripsi"]
    C --> D{"Tentukan koordinat"}
    D -- "Lokasi Saya" --> E["Perkiraan lokasi via IP"]
    D -- "Pilih di Peta" --> F["Cari alamat / klik titik di peta"]
    D -- Manual --> G["Ketik lintang & bujur"]
    E --> H["Kirim Laporan<br/>status: Dilaporkan"]
    F --> H
    G --> H
    H --> I["Petugas lapangan melihat laporan"]
    I --> J["Perbarui status:<br/>Diproses"]
    J --> K["Perbarui status:<br/>Selesai + tanggal selesai"]
    K --> L["Pelanggan memantau status"]
    L --> M([Selesai])
```

### 5.2 Use Case Diagram

```mermaid
flowchart LR
    USR(["👥 Pengguna Terdaftar"])
    PEL(["👤 Pelanggan"])
    PTG(["👷 Petugas Lapangan"])
    KSR(["💳 Kasir"])
    ADM(["🛠️ Admin"])

    PEL -. "generalisasi" .-> USR
    PTG -. "generalisasi" .-> USR
    KSR -. "generalisasi" .-> USR
    ADM -. "generalisasi" .-> USR

    subgraph SISTEM["Sistem VOLT"]
        UCU1(["Login / Logout"])
        UCU2(["Mengelola profil"])

        UCP1(["Registrasi akun"])
        UCP2(["Melihat tagihan & riwayat kWh"])
        UCP3(["Membayar tagihan online"])
        UCP4(["Melaporkan gangguan"])
        UCP5(["Memilih lokasi di peta"])
        UCP6(["Memantau status pengaduan"])

        UCT1(["Membuat tagihan"])
        UCT2(["Melihat detail tagihan pelanggan"])
        UCT3(["Memperbarui status pengaduan"])

        UCK1(["Memproses pembayaran tunai"])
        UCK2(["Mencetak ulang bukti"])
        UCK3(["Melihat riwayat transaksi"])

        UCA1(["Mengelola data petugas"])
        UCA2(["Mengelola golongan tarif"])
        UCA3(["Menyetujui / menolak registrasi"])
        UCA4(["Melihat dashboard, pembayaran & pengaduan"])
    end

    USR --- UCU1
    USR --- UCU2
    PEL --- UCP1
    PEL --- UCP2
    PEL --- UCP3
    PEL --- UCP4
    PEL --- UCP6
    UCP4 -. "include" .-> UCP5
    PTG --- UCT1
    PTG --- UCT2
    PTG --- UCT3
    KSR --- UCK1
    KSR --- UCK2
    KSR --- UCK3
    ADM --- UCA1
    ADM --- UCA2
    ADM --- UCA3
    ADM --- UCA4
```

### 5.3 ERD (Entity Relationship Diagram)

Skema lengkap ada di [`sql/volt.sql`](sql/volt.sql). Hierarki akun memakai pola *tabel induk + tabel anak* (`karyawan` → `admin`/`kasir`/`petugas_lapangan`, `pelanggan` → `rumah_tangga`/`usaha`).

```mermaid
erDiagram
    KARYAWAN ||--o| ADMIN : "adalah"
    KARYAWAN ||--o| KASIR : "adalah"
    KARYAWAN ||--o| PETUGAS_LAPANGAN : "adalah"
    GOLONGAN ||--o{ PELANGGAN : "tarif"
    PELANGGAN ||--o| RUMAH_TANGGA : "jenis"
    PELANGGAN ||--o| USAHA : "jenis"
    PELANGGAN ||--o{ TAGIHAN : "memiliki"
    PELANGGAN ||--o{ PENGADUAN : "melaporkan"
    PETUGAS_LAPANGAN ||--o{ TAGIHAN : "membuat"
    PETUGAS_LAPANGAN ||--o{ PENGADUAN : "menangani"
    KASIR ||--o{ TAGIHAN : "penanggung jawab"
    KASIR ||--o{ PEMBAYARAN : "menerima"
    TAGIHAN ||--o{ PEMBAYARAN : "dibayar lewat"

    KARYAWAN {
        int id_karyawan PK
        varchar nama
        varchar no_telepon
        varchar username UK
        varchar password
    }
    ADMIN {
        int id_karyawan PK, FK
        varchar email UK
    }
    KASIR {
        int id_karyawan PK, FK
        enum status_setoran
        datetime tanggal_setor
    }
    PETUGAS_LAPANGAN {
        int id_karyawan PK, FK
        varchar wilayah_tugas
        enum spesialis
    }
    GOLONGAN {
        int id_golongan PK
        varchar kode_golongan
        int daya_va
        decimal tarif_per_kwh
        decimal biaya_beban
    }
    PELANGGAN {
        int id_pelanggan PK
        varchar nomor_meter
        varchar nama
        text alamat
        varchar no_telepon
        enum jenis_pelanggan
        varchar username UK
        varchar password
        enum status_akun
        int id_golongan FK
    }
    RUMAH_TANGGA {
        int id_pelanggan PK, FK
        char nik UK
        enum kategori_subsidi
    }
    USAHA {
        int id_pelanggan PK, FK
        varchar npwp UK
        varchar nama_usaha
    }
    TAGIHAN {
        int id_tagihan PK
        int id_pelanggan FK
        varchar bulan
        varchar tahun
        decimal meter_awal
        decimal meter_akhir
        decimal jumlah_pemakaian_kwh
        decimal total_biaya
        date jatuh_tempo
        varchar status
        int id_petugas_lapangan FK
        int id_kasir FK
    }
    PEMBAYARAN {
        int id_pembayaran PK
        varchar no_struk UK
        datetime tanggal_bayar
        decimal jumlah_bayar
        enum metode
        int id_tagihan FK
        int id_kasir FK
    }
    PENGADUAN {
        int id_pengaduan PK
        varchar lokasi
        decimal lintang
        decimal bujur
        datetime tanggal_lapor
        datetime tanggal_selesai
        text deskripsi
        enum status
        int id_petugas_lapangan FK
        int id_pelanggan FK
    }
```

---

## 6. Struktur Folder / Package

```text
volt-app/
├── pom.xml                         # konfigurasi Maven (dependensi & build)
├── sql/
│   └── volt.sql                    # skema + data uji database
├── docs/
│   ├── screenshots/                # screenshot GUI untuk README
│   └── CATATAN_PENGEMBANGAN.md     # catatan teknis & riwayat perubahan
└── src/main/
    ├── resources/
    │   └── db.properties           # konfigurasi koneksi MySQL
    └── java/
        ├── Main.java               # titik masuk program
        ├── model/                  # entitas / kelas domain (Pengguna, Karyawan, Pelanggan, Tagihan, ...)
        ├── dao/                    # akses data JDBC (BaseDao, CrudDao, TagihanDao, ...)
        ├── controller/             # logika alur & validasi (BaseController, AdminController, ...)
        ├── util/                   # Database, Konstanta, Fmt, Bulan, AppException, Lokasi, ...
        └── view/                   # seluruh tampilan Swing (+ pasangan .form NetBeans)
            ├── auth/               # LayarMasuk, PanelMenuUtama, PanelLogin, PanelDaftar
            ├── admin/              # PanelMenuAdmin, PanelDashboard, PanelPetugas, PanelGolongan, ...
            ├── kasir/              # PanelMenuKasir, PanelTransaksi, PanelRiwayatKasir
            ├── petugas/            # PanelMenuPetugas, PanelBuatTagihan, PanelUpdatePengaduan
            ├── pelanggan/          # PanelMenuPelanggan, PanelBeranda, PanelTagihanSaya, DialogPilihPeta, ...
            └── komponen/           # KartuStat (komponen kartu angka)
```

| Package | Tanggung jawab (MVC) |
|---|---|
| `model` | **Model** — entitas dan aturan domain |
| `view` | **View** — panel/dialog Swing, tanpa logika bisnis |
| `controller` | **Controller** — validasi input & alur proses, menghubungkan View ↔ DAO |
| `dao` | Akses database (JDBC) |
| `util` | Pembantu: koneksi DB, konstanta, format, pengecualian aplikasi |

---

## 7. Penerapan 4 Pilar OOP

### Hierarki kelas utama

```mermaid
classDiagram
    class Pengguna {
        <<abstract>>
        -int id
        -String nama
        -String noTelepon
        -String username
        +getPeran()* String
        +getRingkasan() String
    }
    class Karyawan {
        <<abstract>>
        +getDetail()* String
    }
    class Pelanggan {
        <<abstract>>
        +getJenis()* String
        +getKeterangan()* String
    }
    class Admin
    class Kasir
    class PetugasLapangan
    class PelangganRumahTangga
    class PelangganUsaha
    class Cetakable {
        <<interface>>
        +cetak() String
    }
    class Tagihan
    class Pembayaran
    class Pengaduan

    Pengguna <|-- Karyawan
    Pengguna <|-- Pelanggan
    Karyawan <|-- Admin
    Karyawan <|-- Kasir
    Karyawan <|-- PetugasLapangan
    Pelanggan <|-- PelangganRumahTangga
    Pelanggan <|-- PelangganUsaha
    Cetakable <|.. Tagihan
    Cetakable <|.. Pembayaran
    Cetakable <|.. Pengaduan
```

### 7.1 Enkapsulasi (Encapsulation)
Atribut dideklarasikan `private` dan hanya diakses lewat *getter/setter*; data tidak diubah langsung dari luar kelas.
Validasi input dipusatkan di controller, bukan di View.

```java
// model/Pengguna.java
public abstract class Pengguna {
    private int id;
    private String nama;
    private String noTelepon;
    private String username;
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    // ...
}
```

### 7.2 Pewarisan (Inheritance)
Kelas turunan memakai ulang atribut dan perilaku induknya.

- **Model:** `Pengguna → Karyawan → Admin / Kasir / PetugasLapangan` dan `Pengguna → Pelanggan → PelangganRumahTangga / PelangganUsaha`.
- **Lapisan lain:** `BaseDao` (koneksi & penanganan error JDBC) diwarisi semua DAO; `BaseController` (validasi umum: `isi`, `angka`, `uang`, `tanggal`, `telepon`) diwarisi semua controller; `BasePanel → BaseMenuPanel` diwarisi semua panel menu.

```java
public abstract class Karyawan extends Pengguna { ... }
public class Admin extends Karyawan { ... }
public class AdminController extends BaseController { ... }
public class TagihanDao extends BaseDao { ... }
```

### 7.3 Polimorfisme (Polymorphism)
Satu pemanggilan metode menghasilkan perilaku berbeda sesuai tipe objeknya.

```java
// Tiap subclass menyebut perannya sendiri
@Override public String getPeran() { return "Admin"; }              // Admin
@Override public String getPeran() { return "Petugas Lapangan"; }   // PetugasLapangan

// view/MainFrame.java — menu dipilih berdasarkan tipe akun yang login
if (pengguna instanceof Admin)                 menu = pgAdmin;
else if (pengguna instanceof Kasir)            menu = pgKasir;
else if (pengguna instanceof PetugasLapangan)  menu = pgPetugas;
else if (pengguna instanceof Pelanggan)        menu = pgPelanggan;

// dao/PelangganDao.java — baris database dipetakan ke subclass yang sesuai
if (JENIS_USAHA.equals(rs.getString("jenis_pelanggan"))) return new PelangganUsaha(...);
return new PelangganRumahTangga(...);
```

Contoh lain: `getJenis()`, `getKeterangan()`, `getDetail()` dan `cetak()` yang diimplementasi berbeda di tiap kelas.

### 7.4 Abstraksi (Abstraction)
Detail disembunyikan di balik **kelas abstrak** dan **interface** yang hanya mendefinisikan kontrak.

| Jenis | Nama | Fungsi |
|---|---|---|
| Kelas abstrak | `Pengguna`, `Karyawan`, `Pelanggan` | Kerangka akun; memaksa subclass mengimplementasi `getPeran()`, `getDetail()`, `getJenis()` |
| Kelas abstrak | `BaseDao`, `BaseController`, `BasePanel`, `BaseMenuPanel` | Fungsi umum + metode abstrak untuk dilengkapi subclass |
| Interface | `CrudDao<T, ID>` | Kontrak CRUD generik (`insert`, `update`, `delete`, `findById`, `findAll`) |
| Interface | `Cetakable` | Kontrak objek yang bisa dicetak sebagai teks (`Tagihan`, `Pembayaran`, `Pengaduan`) |
| Interface | `Refreshable` | Kontrak panel yang dapat memuat ulang data (`muat()`) |

```java
public interface CrudDao<T, ID> {
    int insert(T obj);
    void update(T obj);
    void delete(ID id);
    T findById(ID id);
    List<T> findAll();
}
public class GolonganDao extends BaseDao implements CrudDao<Golongan, Integer> { ... }
```

---

## 8. Cara Penggunaan Program

### 8.1 Instalasi & menjalankan

**Prasyarat:** JDK 17+, Maven 3.8+, MySQL 8 (mis. via XAMPP/Laragon/MySQL Server), koneksi internet (unduh dependensi & fitur peta).

```bash
# 1. Clone repository
git clone <URL-REPOSITORY-ANDA>.git
cd volt-app
```

1. **Buat database** `volt`, lalu impor skema & data uji:
   ```bash
   mysql -u root -p -e "CREATE DATABASE IF NOT EXISTS volt;"
   mysql -u root -p volt < sql/volt.sql
   ```
2. **Atur koneksi** di `src/main/resources/db.properties`:
   ```properties
   db.url=jdbc:mysql://localhost:3306/volt?useSSL=false&allowPublicKeyRetrieval=true&connectionTimeZone=LOCAL
   db.user=root
   db.password=
   ```
3. **Jalankan program** (pilih salah satu):
   ```bash
   mvn compile exec:java -Dexec.mainClass=Main        # langsung dari Maven
   # atau
   mvn package && java -jar target/volt-app-1.0.jar   # lewat fat jar
   ```
   Di **NetBeans**: *File → Open Project* → pilih folder ini → *Clean and Build* → klik kanan `Main.java` → *Run File*.

### 8.2 Akun uji

| Peran | Username | Password |
|---|---|---|
| Admin | `andi.pratama` | `admin01` |
| Kasir | `dewi.lestari` | `kasir04` |
| Petugas — Catat Meter | `rizal.hakim` | `lapang07` |
| Petugas — Teknisi | `bayu.saputra` | `lapang11` |
| Petugas — Keduanya | `galih.pratama` | `lapang17` |
| Pelanggan Rumah Tangga | `suparman01` | `pass01` |
| Pelanggan Usaha | `dedi16` | `pass16` |

### 8.3 Panduan & screenshot GUI

#### Halaman awal
| Menu Utama | Login | Daftar |
|---|---|---|
| ![Menu Utama](docs/screenshots/01-menu-utama.png) | ![Login](docs/screenshots/02-login.png) | ![Daftar](docs/screenshots/03-daftar.png) |

Pilih **Login**, masukkan username & password. Pelanggan baru memilih **Daftar**; akun berstatus *Menunggu* sampai disetujui admin.

#### Admin
1. **Dashboard** — kartu angka ringkasan dan tab tabel rincian.
2. **Data Petugas** — tambah/ubah/hapus kasir & petugas lapangan, atur status setoran kasir.
3. **Golongan Tarif** — kelola tarif per kWh dan biaya beban.
4. **Registrasi Pengguna** — setujui atau tolak pendaftar.
5. **Riwayat Pembayaran** dan **Laporan Pengaduan** — pantau seluruh transaksi dan laporan.

| Dashboard | Data Petugas |
|---|---|
| ![Admin Dashboard](docs/screenshots/10-admin-dashboard.png) | ![Admin Petugas](docs/screenshots/11-admin-petugas.png) |

| Golongan Tarif | Registrasi Pengguna |
|---|---|
| ![Admin Golongan](docs/screenshots/12-admin-golongan.png) | ![Admin Registrasi](docs/screenshots/13-admin-registrasi.png) |

| Riwayat Pembayaran | Laporan Pengaduan |
|---|---|
| ![Admin Pembayaran](docs/screenshots/14-admin-pembayaran.png) | ![Admin Pengaduan](docs/screenshots/15-admin-pengaduan.png) |

| Profil Admin |
|---|
| ![Admin Profil](docs/screenshots/16-admin-profil.png) |

#### Petugas Lapangan
1. **Membuat tagihan** — pilih pelanggan di tabel, isi periode, meter awal/akhir, dan jatuh tempo, lalu **Simpan Tagihan**. kWh dan total dihitung otomatis.
2. **Detail Tagihan Pelanggan** — lihat seluruh riwayat tagihan pelanggan yang dipilih.
3. **Status pengaduan** — pilih laporan, ubah status, lalu **Perbarui Status**.

| Membuat Tagihan | Detail Tagihan Pelanggan |
|---|---|
| ![Buat Tagihan](docs/screenshots/30-petugas-buat-tagihan.png) | ![Detail Tagihan](docs/screenshots/31-petugas-detail-tagihan.png) |

| Status Pengaduan | Profil Petugas |
|---|---|
| ![Status Pengaduan](docs/screenshots/32-petugas-status-pengaduan.png) | ![Profil Petugas](docs/screenshots/33-petugas-profil.png) |

#### Kasir
1. **Transaksi** — cari tagihan belum lunas, pilih, lalu **Proses Pembayaran** (tunai).
2. **Bukti pembayaran** — dapat dicetak ulang dari riwayat.

| Transaksi | Bukti Pembayaran |
|---|---|
| ![Kasir Transaksi](docs/screenshots/20-kasir-transaksi.png) | ![Kasir Bukti](docs/screenshots/21-kasir-bukti.png) |

| Riwayat Transaksi |
|---|
| ![Kasir Riwayat](docs/screenshots/22-kasir-riwayat.png) |

#### Pelanggan
1. **Beranda** — ringkasan pemakaian dan tagihan; tombol pintas *Lapor gangguan* & *Bayar tagihan*.
2. **Tagihan & Riwayat kWh** — pilih tagihan lalu **Bayar Tagihan Terpilih**, konfirmasi pembayaran.
3. **Lapor Gangguan** — **Buat Laporan Baru**, isi lokasi dan deskripsi, tentukan koordinat dengan **Lokasi Saya**, **Pilih di Peta**, atau manual, lalu **Kirim Laporan**. Pantau status di tabel.

| Beranda | Tagihan & Riwayat kWh |
|---|---|
| ![Beranda](docs/screenshots/40-pelanggan-beranda.png) | ![Tagihan](docs/screenshots/41-pelanggan-tagihan.png) |

| Konfirmasi Pembayaran | Lapor Gangguan |
|---|---|
| ![Konfirmasi Bayar](docs/screenshots/42-pelanggan-konfirmasi-bayar.png) | ![Lapor Gangguan](docs/screenshots/43-pelanggan-lapor-gangguan.png) |

| Form Buat Laporan | Pilih Lokasi di Peta |
|---|---|
| ![Buat Laporan](docs/screenshots/44-pelanggan-buat-laporan.png) | ![Pilih Peta](docs/screenshots/45-pelanggan-pilih-peta.png) |

| Profil Pelanggan |
|---|
| ![Profil Pelanggan](docs/screenshots/46-pelanggan-profil.png) |

> Daftar lengkap nama file screenshot ada di [`docs/screenshots/README.md`](docs/screenshots/README.md).

---

## 9. Kontributor

| No | Nama | NIM | Peran / Kontribusi |
|---|---|---|---|
| 1 | _Nama Anggota 1_ | _NIM_ | _mis. Perancangan database & DAO_ |
| 2 | _Nama Anggota 2_ | _NIM_ | _mis. Controller & logika bisnis_ |
| 3 | _Nama Anggota 3_ | _NIM_ | _mis. Desain GUI_ |
| 4 | _Nama Anggota 4_ | _NIM_ | _mis. Dokumentasi & pengujian_ |

---

<sub>Catatan teknis pengembangan dan riwayat perubahan: [`docs/CATATAN_PENGEMBANGAN.md`](docs/CATATAN_PENGEMBANGAN.md).</sub>
