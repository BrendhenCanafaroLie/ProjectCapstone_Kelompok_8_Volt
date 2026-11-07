# Project Capstone (Pemrograman Berorientasi Objek & Sistem Basis Data)

## Kelompok 8 Volt
1. Muhammad Aidil Fadilah     - (2509116032) - Kelas A
2. Brendhen Canafaro Lie      - (2509116033) - Kelas A
3. Alisya Octa Noor Ghina     - (2509116017) - Kelas A
4. Muhammad Kevin Athflayuna  - (2509116058) - Kelas B

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

**VOLT** — Sistem Tagihan Listrik & Pengaduan Gangguan (Samarinda)

---

## 2. Deskripsi Singkat

VOLT membantu penyedia layanan listrik mengelola proses dari ujung ke ujung dalam satu aplikasi:
**petugas lapangan** mencatat meter dan membuat tagihan,** pelanggan** melihat dan membayar tagihan, **kasir** memproses pembayaran tunai, dan **admin** mengelola data master serta memantau statistik. Pelanggan juga dapat melaporkan gangguan listrik (lengkap dengan koordinat lokasi yang bisa dipilih di peta), lalu petugas lapangan memperbarui status penanganannya.

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
| Framework | **Tidak ada** |
| Arsitektur | **MVC** + pola **DAO** |
| Layanan eksternal | OpenStreetMap (peta & ubin), Nominatim (pencarian alamat), ipwho.is (perkiraan lokasi) — membutuhkan internet |

---

## 5. Perancangan Sistem

Diagram dibuat dengan **drawio**, yang memudahkan pembuatan. Pembuatan flowchart terbagi menjadi beberapa bagian yaitu **Menu Utama, Admin (CRUD Petugas, Dashboard, Golongan Tarif), Petugas Lapangan, Kasir dan Pelanggan**

### 5.1 Flowchart

**a) Menu Utama**



**b) Admin**



**c) Admin CRUD Petugas**



**d) Admin Dashboard**



**e) Admin CRUD Golongan Tarif**



**f) Petugas Lapangan**



**g) Kasir**



**h) Pelanggan**





### 5.2 Use Case Diagram



### 5.3 ERD (Entity Relationship Diagram)




---

## 6. Struktur Folder / Package

<img width="243" height="424" alt="image" src="https://github.com/user-attachments/assets/64a45309-a799-4209-b2c8-51d0160e3053" />


Berikut adalah penjelasan tentang fungsi dari masing-masing package:
1. **Model**          : Berisi entitas data dan aturan domain yang mengatur bagaimana data divalidasi dan dikelola secara mandiri dari tampilan maupun database.
2. **View**           : Berisi antarmuka pengguna berbasis Java Swing seperti panel dan dialog yang murni untuk menampilkan data serta menerima input tanpa menyertakan logika bisnis.
3. **Controller**     : Berisi pengontrol yang menangani validasi input, mengatur alur proses aplikasi, serta menjembatani komunikasi antara View dan lapisan akses data (DAO).
4. **Dao**            : Bertanggung jawab penuh untuk melakukan interaksi langsung ke database menggunakan JDBC (menyimpan, mengambil, memperbarui, dan menghapus data).
5. **Util**           : Berisi berbagai kelas pembantu yang sering digunakan bersama, seperti manajemen koneksi database, kumpulan konstanta, fungsi pemformatan, hingga penanganan exception khusus aplikasi.

---

## 7. Penerapan 4 Pilar OOP

# Penerapan 4 Pilar OOP pada VOLT

> Dokumen ini menjelaskan bagaimana **Enkapsulasi, Pewarisan, Polimorfisme, dan Abstraksi** diterapkan pada kode VOLT.
> Kembali ke [README utama](../README.md).

**Daftar isi:** [Hierarki kelas](#hierarki-kelas-utama) · [1. Enkapsulasi](#1-enkapsulasi-encapsulation) · [2. Pewarisan](#2-pewarisan-inheritance) · [3. Polimorfisme](#3-polimorfisme-polymorphism) · [4. Abstraksi](#4-abstraksi-abstraction)

---

### 7.1 Enkapsulasi (Encapsulation)
Atribut dideklarasikan `private` dan hanya diakses lewat *getter/setter*; data tidak diubah langsung dari luar kelas.
Validasi input dipusatkan di controller, bukan di View.





### 7.2 Pewarisan (Inheritance)
Kelas turunan memakai ulang atribut dan perilaku induknya.

- **Model:** `Pengguna → Karyawan → Admin / Kasir / PetugasLapangan` dan `Pengguna → Pelanggan → PelangganRumahTangga / PelangganUsaha`.
- **Lapisan lain:** `BaseDao` (koneksi & penanganan error JDBC) diwarisi semua DAO; `BaseController` (validasi umum: `isi`, `angka`, `uang`, `tanggal`, `telepon`) diwarisi semua controller; `BasePanel → BaseMenuPanel` diwarisi semua panel menu.





### 7.3 Polimorfisme (Polymorphism)
Satu pemanggilan metode menghasilkan perilaku berbeda sesuai tipe objeknya.





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




---

## 8. Cara Penggunaan Program

### 8.1 Instalasi & menjalankan

1. **Buat database** `volt`, lalu impor file sql:
   
   
2. **Atur koneksi** di `src/main/resources/db.properties`:

   
  
3. **Jalankan program** (pilih salah satu):

   
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

### 8.3 Jalannya Program

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
| 1 | Alisya Octa Noor Ghina | 2509116017 | _mis. Perancangan database & DAO_ |
| 2 | Muhammad Aidil Fadilah | 250911632 | _mis. Controller & logika bisnis_ |
| 3 | Brendhen Canafaro Lie | 2509116033 | _mis. Desain GUI_ |
| 4 | Muhammad Kevin Athflayuna | 2509116058 | _mis. Dokumentasi & pengujian_ |

---

## 10. Lampiran
1. Lampiran 1 - **Berkas Google Drive**	- Buka di Google Drive
2. Lampiran 2 - **Dokumen Word (OneDrive)**	- Buka di OneDrive
3. Lampiran 3 - **Desain Canva** - Buka di Canva
