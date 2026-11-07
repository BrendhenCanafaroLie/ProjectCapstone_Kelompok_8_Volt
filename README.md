# PROJECT CAPSTONE
Mata Kuliah : Pemrograman Berorientasi Objek & Sistem Basis Data

**Kelompok 8 - Volt**

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
**petugas lapangan** mencatat meter dan membuat tagihan, **pelanggan** melihat dan membayar tagihan, **kasir** memproses pembayaran tunai, dan **admin** mengelola data master serta memantau statistik. Pelanggan juga dapat melaporkan gangguan listrik (lengkap dengan koordinat lokasi yang bisa dipilih di peta), lalu petugas lapangan memperbarui status penanganannya.

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
<img width="2502" height="1978" alt="Copy of PROJECT CAPSTONE-Menu Utama  drawio (1)" src="https://github.com/user-attachments/assets/76744f8d-732c-4023-b3fe-37da7a8848e5" />

**b) Admin**
<img width="1852" height="2377" alt="Copy of PROJECT CAPSTONE-Admin" src="https://github.com/user-attachments/assets/76f121fd-11ba-4cd4-9687-89880a435b67" />

**c) Admin CRUD Petugas**
<img width="1984" height="2247" alt="Copy of PROJECT CAPSTONE-Admin-CRUD Petugas" src="https://github.com/user-attachments/assets/e7be5c49-261b-4c3a-93c3-58125047a3da" />

**d) Admin Dashboard**
<img width="1582" height="2167" alt="Copy of PROJECT CAPSTONE-Admin-Dashboard" src="https://github.com/user-attachments/assets/679b3f6a-3fe7-4134-bb73-4f5bf02e6b45" />

**e) Admin CRUD Golongan Tarif**
<img width="1964" height="2287" alt="Copy of PROJECT CAPSTONE-Admin-Golongan Tarif" src="https://github.com/user-attachments/assets/2b57471a-b782-40b2-b6ee-e5d9e806d8ec" />

**f) Petugas Lapangan**
<img width="3232" height="1897" alt="Copy of PROJECT CAPSTONE-Petugas Lapangan" src="https://github.com/user-attachments/assets/fc50a5ad-d065-43fa-b18a-8a686d9a174e" />

**g) Kasir**
<img width="3132" height="1637" alt="Copy of PROJECT CAPSTONE-Kasir" src="https://github.com/user-attachments/assets/09c956c7-451d-4215-8015-26cc8dd6e7cd" />

**h) Pelanggan**
<img width="2792" height="2132" alt="Copy of PROJECT CAPSTONE-Pelanggan" src="https://github.com/user-attachments/assets/b8b34839-6e9a-4cd8-96b8-12169a788760" />

### 5.2 Use Case Diagram
<img width="1931" height="1937" alt="Copy of PROJECT CAPSTONE-USE CASE " src="https://github.com/user-attachments/assets/508efe9b-6eb1-4f28-b3cc-57e5047ad9f8" />

### 5.3 ERD (Entity Relationship Diagram)
<img width="1564" height="728" alt="image" src="https://github.com/user-attachments/assets/479672cd-4465-43eb-a899-ee903ee59673" />

<img width="1600" height="645" alt="image" src="https://github.com/user-attachments/assets/18517329-ba07-414a-9f3e-f67df2e0fd2b" />

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

### 7.1 Enkapsulasi (Encapsulation)
Atribut dideklarasikan `private` dan hanya diakses lewat *getter/setter*; data tidak diubah langsung dari luar kelas.
Validasi input dipusatkan di controller, bukan di View.

<img width="575" height="212" alt="image" src="https://github.com/user-attachments/assets/3d503ff5-4017-46f9-9318-dfe7e1df3851" />


### 7.2 Pewarisan (Inheritance)
Kelas turunan memakai ulang atribut dan perilaku induknya.

- **Model:** `Pengguna → Karyawan → Admin / Kasir / PetugasLapangan` dan `Pengguna → Pelanggan → PelangganRumahTangga / PelangganUsaha`.
- **Lapisan lain:** `BaseDao` (koneksi & penanganan error JDBC) diwarisi semua DAO; `BaseController` (validasi umum: `isi`, `angka`, `uang`, `tanggal`, `telepon`) diwarisi semua controller; `BasePanel → BaseMenuPanel` diwarisi semua panel menu.

<img width="1052" height="826" alt="image" src="https://github.com/user-attachments/assets/edaa0f84-04bb-4374-a1c7-e2ccd4e40892" />


<img width="1368" height="518" alt="image" src="https://github.com/user-attachments/assets/4cbebf4e-df38-471c-9205-c042a8fbf4df" />


### 7.3 Polimorfisme (Polymorphism)
Satu pemanggilan metode menghasilkan perilaku berbeda sesuai tipe objeknya.

<img width="647" height="152" alt="image" src="https://github.com/user-attachments/assets/b9d4363c-6590-44c3-afa2-ee70394539e7" />


<img width="997" height="118" alt="image" src="https://github.com/user-attachments/assets/726e30f2-d5b2-44e3-b446-7b8f02ef90a4" />


Contoh lain: `getJenis()`, `getKeterangan()`, `getDetail()` dan `cetak()` yang diimplementasi berbeda di tiap kelas.

### 7.4 Abstraksi (Abstraction)
Detail disembunyikan di balik **kelas abstrak** dan **interface** yang hanya mendefinisikan kontrak.

<img width="351" height="126" alt="image" src="https://github.com/user-attachments/assets/7262ac4f-47b2-4d18-afb5-d57c6a12df58" />

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

### HALAMAN AWAL

**1. Menu Utama**
<img width="1917" height="1015" alt="image" src="https://github.com/user-attachments/assets/af6eca15-2dd9-43ed-a488-eb836bfcc8c1" />

**2. Login**
<img width="1911" height="1018" alt="image" src="https://github.com/user-attachments/assets/bcca2bed-70ec-419e-bf81-7f21e17e5a9d" />

**3. Daftar**
<img width="1917" height="1015" alt="image" src="https://github.com/user-attachments/assets/c39eb568-6fce-4586-900f-99bbb6558f64" />

Pilih **Login**, masukkan username & password. Pelanggan baru memilih **Daftar**; akun berstatus *Menunggu* sampai disetujui admin.

### ADMIN
**1. Dashboard**

<img width="1917" height="1015" alt="image" src="https://github.com/user-attachments/assets/d170ecfe-0d2b-4ff8-8755-cad4a58cec4b" />

**2. Data Petugas**

<img width="1917" height="1020" alt="image" src="https://github.com/user-attachments/assets/169c06f6-02d4-4bd1-81e1-bce332853984" />

**3. Golongan Tarif**

<img width="1917" height="1020" alt="image" src="https://github.com/user-attachments/assets/c1fb56d7-dd8f-40b5-a32b-38baa33c4963" />

**4. Registrasi Pengguna** 

<img width="1917" height="1016" alt="image" src="https://github.com/user-attachments/assets/9e280c62-668d-4e5d-af85-0dee5f7f1618" />

**5. Riwayat Pembayaran**

<img width="1917" height="1020" alt="image" src="https://github.com/user-attachments/assets/50559588-e651-46f8-86c0-3e953748d8ef" />

**6. Laporan Pengaduan**

<img width="1917" height="1020" alt="image" src="https://github.com/user-attachments/assets/6a9a06c8-8fea-4cd9-870e-ebe884556f60" /> 

**7. Profile Admin**

<img width="1912" height="1017" alt="image" src="https://github.com/user-attachments/assets/34a16ce4-024b-4772-a90a-d972f06d001b" />


### PETUGAS LAPANGAN

- **Membuat tagihan** — pilih pelanggan di tabel, isi periode, meter awal/akhir, dan jatuh tempo, lalu **Simpan Tagihan**. kWh dan total dihitung otomatis.

- **Detail Tagihan Pelanggan** — lihat seluruh riwayat tagihan pelanggan yang dipilih.

- **Status pengaduan** — pilih laporan, ubah status, lalu **Perbarui Status**.

**1. Membuat Tagihan**

<img width="1627" height="890" alt="image" src="https://github.com/user-attachments/assets/fc4c69f8-bfc2-4520-a8de-32c5d6c7e131" />

**2. Detail Tagihan** 

<img width="613" height="577" alt="image" src="https://github.com/user-attachments/assets/574fe956-1795-4ef7-9bcb-0853eb7bf7d7" />

**3. Perbarui Status Pengaduan**

<img width="1630" height="886" alt="image" src="https://github.com/user-attachments/assets/078d575a-5a16-4fc7-b59d-b9276f81dd98" />

**4. Profile Petugas Lapangan**

<img width="772" height="575" alt="image" src="https://github.com/user-attachments/assets/070ff365-17c5-400f-aa9b-a71aaebd9dea" />


### KASIR
- **Transaksi** — cari tagihan belum lunas, pilih, lalu **Proses Pembayaran** (tunai).
- **Bukti pembayaran** — dapat dicetak ulang dari riwayat.

**1. Menu Transaksi**

<img width="1630" height="890" alt="image" src="https://github.com/user-attachments/assets/627d52e8-9a76-4c5a-8340-569c51b2cde9" />

**2. Bukti Transaksi**

<img width="616" height="657" alt="image" src="https://github.com/user-attachments/assets/14380149-4fe6-4a56-ba8a-3addfc7e07b9" />

**3. Riwayat Transaksi**

<img width="1623" height="877" alt="image" src="https://github.com/user-attachments/assets/5d78b2c8-9f95-40ed-991b-382b708307c2" />

 
### PELANGGAN
- **Beranda** — ringkasan pemakaian dan tagihan; tombol pintas *Lapor gangguan* & *Bayar tagihan*.
- **Tagihan & Riwayat kWh** — pilih tagihan lalu **Bayar Tagihan Terpilih**, konfirmasi pembayaran.
- **Lapor Gangguan** — **Buat Laporan Baru**, isi lokasi dan deskripsi, tentukan koordinat dengan **Lokasi Saya**, **Pilih di Peta**, atau manual, lalu **Kirim Laporan**. Pantau status di tabel.

**1. Beranda**

<img width="1917" height="1018" alt="image" src="https://github.com/user-attachments/assets/8693c1b8-7631-488e-b73e-0f05f103c16c" />

**2. Menu Tagihan**

<img width="1917" height="1016" alt="image" src="https://github.com/user-attachments/assets/77650279-af83-420e-a1d1-a2576dfd3c09" />

**3. Konfirmasi Pembayaran**

<img width="610" height="598" alt="image" src="https://github.com/user-attachments/assets/51e852ec-91a1-428b-81b4-9f3f0a3a9f49" />

**4. Menu Laporan**

<img width="1917" height="1015" alt="image" src="https://github.com/user-attachments/assets/b12e2669-1daa-44d8-9a3e-e3a1f42840eb" />

**5. Membuat Laporan**

<img width="826" height="490" alt="image" src="https://github.com/user-attachments/assets/946b9b77-cf29-423d-b76c-5824eab9a9c0" />

**6. Lokasi**

<img width="1016" height="826" alt="image" src="https://github.com/user-attachments/assets/1a954706-71e2-4aba-bdcc-af08154186e3" />

**7. Profile Pelanggan**

<img width="770" height="626" alt="image" src="https://github.com/user-attachments/assets/e2f921d8-49f4-41b6-9fc7-9c86832eb8c5" />


---

## 9. Kontributor

| No | Nama | NIM | Peran / Kontribusi |
|---|---|---|---|
| 1 | Alisya Octa Noor Ghina | 2509116017 | Perancangan database & ERD, Laporan, Readme dan PPT |
| 2 | Muhammad Aidil Fadilah | 250911632 | View Pada Program, Laporan, ERD, dan Readme |
| 3 | Brendhen Canafaro Lie | 2509116033 | Alur Program PBO, Readme, dan ERD |
| 4 | Muhammad Kevin Athflayuna | 2509116058 | Laporan Flowchart dan Use Case|

---

## 10. Lampiran
1. Lampiran 1 - **Berkas Google Drive**	- https://drive.google.com/drive/folders/1LK5X1ATwIGfWjITccuL2EtRwihfzbh43?usp=sharing
2. Lampiran 2 - **Dokumen Word (OneDrive)**	- [Buka di OneDrive](https://1drv.ms/w/c/e585da04d11cfd29/IQB2t-6yOZSdT79fIfG4fwq1AbCnmXLbkeyV_vIAZNUpdSQ?e=jPrRmZ)
3. Lampiran 3 - **Desain Canva** - [Buka di Canva](https://canva.link/2p5quy23ry97f3u)
