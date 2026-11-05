-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 04, 2026 at 06:45 AM
-- Server version: 8.4.3
-- PHP Version: 8.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `volt`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_karyawan` int NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_karyawan`, `email`) VALUES
(1, 'andi.pratama@pdam-pln-samarinda.co.id'),
(3, 'budi.setiawan@pdam-pln-samarinda.co.id'),
(2, 'siti.nurhaliza@pdam-pln-samarinda.co.id');

-- --------------------------------------------------------

--
-- Table structure for table `golongan`
--

CREATE TABLE `golongan` (
  `id_golongan` int NOT NULL,
  `kode_golongan` varchar(5) NOT NULL,
  `daya_va` int NOT NULL,
  `tarif_per_kwh` decimal(10,2) NOT NULL,
  `biaya_beban` decimal(12,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `golongan`
--

INSERT INTO `golongan` (`id_golongan`, `kode_golongan`, `daya_va`, `tarif_per_kwh`, `biaya_beban`) VALUES
(1, 'R1', 450, 415.00, 5000.00),
(2, 'R1', 900, 605.00, 5000.00),
(3, 'R1', 900, 1352.00, 5000.00),
(4, 'R1', 1300, 1444.70, 5000.00),
(5, 'R1', 2200, 1444.70, 5000.00),
(6, 'R2', 3500, 1699.53, 10000.00),
(7, 'R2', 4400, 1699.53, 10000.00),
(8, 'R2', 5500, 1699.53, 10000.00),
(9, 'R3', 6600, 1699.53, 20000.00),
(10, 'R3', 13200, 1699.53, 20000.00),
(11, 'B2', 6600, 1444.70, 25000.00),
(12, 'B2', 200000, 1444.70, 25000.00),
(13, 'B3', 250000, 1035.78, 50000.00),
(14, 'B3', 500000, 1035.78, 50000.00),
(15, 'I1', 450, 1699.53, 15000.00),
(16, 'I1', 13200, 1699.53, 15000.00),
(17, 'I2', 16500, 1444.70, 30000.00),
(18, 'I2', 200000, 1444.70, 30000.00),
(19, 'I3', 250000, 1035.78, 100000.00),
(20, 'I3', 30000000, 1035.78, 100000.00),
(21, 'I4', 35000000, 996.74, 500000.00),
(22, 'I4', 100000000, 996.74, 500000.00);

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `id_karyawan` int NOT NULL,
  `nama` varchar(100) NOT NULL,
  `no_telepon` varchar(15) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`id_karyawan`, `nama`, `no_telepon`, `username`, `password`) VALUES
(1, 'Andi Pratama', '081345678901', 'andi.pratama', 'admin01'),
(2, 'Siti Nurhaliza', '081298765432', 'siti.nurhaliza', 'admin02'),
(3, 'Budi Setiawan', '081377788899', 'budi.setiawan', 'admin03'),
(4, 'Dewi Lestari', '081255566677', 'dewi.lestari', 'kasir04'),
(5, 'Rizky Ramadhan', '081366655544', 'rizky.ramadhan', 'kasir05'),
(6, 'Eko Wahyudi', '081311122233', 'eko.wahyudi', 'kasir06'),
(7, 'Rizal Hakim', '081422233344', 'rizal.hakim', 'lapang07'),
(8, 'Fajar Nugroho', '081533344455', 'fajar.nugroho', 'lapang08'),
(9, 'Yoga Prasetyo', '081644455566', 'yoga.prasetyo', 'lapang09'),
(10, 'Hendra Kusuma', '081755566677', 'hendra.kusuma', 'lapang10'),
(11, 'Bayu Saputra', '081866677788', 'bayu.saputra', 'lapang11'),
(12, 'Doni Firmansyah', '081977788899', 'doni.firmansyah', 'lapang12'),
(13, 'Dimas Arya', '082188899900', 'dimas.arya', 'lapang13'),
(14, 'Agus Salim', '082299900011', 'agus.salim', 'lapang14'),
(15, 'Ardi Kurniawan', '082311122233', 'ardi.kurniawan', 'lapang15'),
(16, 'Rendra Wijaya', '082322233344', 'rendra.wijaya', 'lapang16'),
(17, 'Galih Pratama', '082333344455', 'galih.pratama', 'lapang17'),
(18, 'Hasbi Maulana', '082344455566', 'hasbi.maulana', 'lapang18'),
(19, 'Wahyu Nugroho', '082355566677', 'wahyu.nugroho', 'lapang19'),
(20, 'Yusuf Ramli', '082366677788', 'yusuf.ramli', 'lapang20');

-- --------------------------------------------------------

--
-- Table structure for table `kasir`
--

CREATE TABLE `kasir` (
  `id_karyawan` int NOT NULL,
  `status_setoran` enum('Sudah Setor','Belum Setor') NOT NULL,
  `tanggal_setor` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `kasir`
--

INSERT INTO `kasir` (`id_karyawan`, `status_setoran`, `tanggal_setor`) VALUES
(4, 'Sudah Setor', '2026-10-25 17:00:00'),
(5, 'Sudah Setor', '2026-11-03 16:30:00'),
(6, 'Belum Setor', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` int NOT NULL,
  `nomor_meter` varchar(20) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `alamat` text NOT NULL,
  `no_telepon` varchar(15) NOT NULL,
  `jenis_pelanggan` enum('Rumah Tangga','Usaha') NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(10) NOT NULL,
  `status_akun` enum('Menunggu','Aktif','Tidak Aktif') NOT NULL,
  `id_golongan` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nomor_meter`, `nama`, `alamat`, `no_telepon`, `jenis_pelanggan`, `username`, `password`, `status_akun`, `id_golongan`) VALUES
(1, '14200000001', 'Suparman', 'Jl. Pahlawan No. 12, Kel. Sungai Pinang', '081256789012', 'Rumah Tangga', 'suparman01', 'pass01', 'Aktif', 1),
(2, '14200000002', 'Sri Wahyuni', 'Jl. Bung Tomo No. 45, Kel. Bugis', '081367890123', 'Rumah Tangga', 'sriwahyuni02', 'pass02', 'Aktif', 2),
(3, '14200000003', 'Marjono', 'Jl. Merdeka Gg. 3 No. 7, Kel. Pasar Baru', '081478901234', 'Rumah Tangga', 'marjono03', 'pass03', 'Aktif', 1),
(4, '14200000004', 'Yusniar', 'Jl. Kakap No. 18, Kel. Sungai Dama', '081589012345', 'Rumah Tangga', 'yusniar04', 'pass04', 'Aktif', 2),
(5, '14200000005', 'Kasmir', 'Jl. Antasari No. 33, Kel. Sungai Kunjang', '081690123456', 'Rumah Tangga', 'kasmir05', 'pass05', 'Aktif', 1),
(6, '14200000006', 'Rahmawati', 'Jl. Juanda No. 9, Kel. Karang Asam', '081701234567', 'Rumah Tangga', 'rahmawati06', 'pass06', 'Tidak Aktif', 2),
(7, '14200000007', 'Heri Susanto', 'Jl. Ahmad Yani No. 21, Kel. Temindung', '082112345678', 'Rumah Tangga', 'heri07', 'pass07', 'Aktif', 3),
(8, '14200000008', 'Nurhayati', 'Jl. Cipto Mangunkusumo No. 5, Kel. Sidodadi', '082223456789', 'Rumah Tangga', 'nurhayati08', 'pass08', 'Aktif', 4),
(9, '14200000009', 'Agung Prasetyo', 'Jl. Sultan Hasanuddin No. 14, Kel. Lempake', '082334567890', 'Rumah Tangga', 'agung09', 'pass09', 'Aktif', 5),
(10, '14200000010', 'Lilis Suryani', 'Jl. Gajah Mada No. 27, Kel. Sungai Pinang', '082145678901', 'Rumah Tangga', 'lilis10', 'pass10', 'Aktif', 6),
(11, '14200000011', 'Taufik Hidayat', 'Jl. Mulawarman No. 60, Kel. Air Hitam', '082256789012', 'Rumah Tangga', 'taufik11', 'pass11', 'Aktif', 7),
(12, '14200000012', 'Yuliana', 'Perum Griya Permai Blok C No. 4', '082367890123', 'Rumah Tangga', 'yuliana12', 'pass12', 'Aktif', 8),
(13, '14200000013', 'Hasan Basri', 'Jl. Pramuka No. 88, Kel. Sungai Kapih', '082478901234', 'Rumah Tangga', 'hasan13', 'pass13', 'Tidak Aktif', 9),
(14, '14200000014', 'Ratna Dewi', 'Jl. Wahid Hasyim No. 16, Kel. Sungai Pinang', '082589012345', 'Rumah Tangga', 'ratna14', 'pass14', 'Aktif', 10),
(15, '14200000015', 'Irfan Maulana', 'Jl. Teuku Umar No. 40, Kel. Karang Mumus', '082690123456', 'Rumah Tangga', 'irfan15', 'pass15', 'Aktif', 10),
(16, '14200000016', 'Dedi Kurniawan', 'Jl. Pasar Pagi No. 2, Kel. Pasar Pagi', '081811223344', 'Usaha', 'dedi16', 'pass16', 'Aktif', 14),
(17, '14200000017', 'Sumarni', 'Jl. Imam Bonjol No. 11, Kel. Pelita', '081822334455', 'Usaha', 'sumarni17', 'pass17', 'Aktif', 15),
(18, '14200000018', 'Bambang Sutrisno', 'Jl. Yos Sudarso No. 52, Kel. Loa Bakung', '081833445566', 'Usaha', 'bambang18', 'pass18', 'Aktif', 17),
(19, '14200000019', 'Dr. Mulyadi', 'Jl. Kesehatan No. 3, Kel. Sungai Pinang', '081844556677', 'Usaha', 'mulyadi19', 'pass19', 'Aktif', 19),
(20, '14200000020', 'Hermanto', 'Jl. Kartini No. 100, Kel. Sungai Kunjang', '081855667788', 'Usaha', 'hermanto20', 'pass20', 'Tidak Aktif', 21),
(21, '14200000021', 'Apriliani', 'Jl. Basuki Rahmat No. 19, Kel. Pelita', '081866778899', 'Usaha', 'apriliani21', 'pass21', 'Aktif', 12),
(22, '14200000022', 'Ir. Gunawan', 'Kawasan Industri Palaran Blok B-5', '081877889900', 'Usaha', 'gunawan22', 'pass22', 'Aktif', 13),
(23, '14200000023', 'Yanti Susilowati', 'Jl. Slamet Riyadi No. 8, Kel. Sungai Kapih', '081888990011', 'Usaha', 'yanti23', 'pass23', 'Aktif', 16),
(24, '14200000024', 'Eddy Sutanto', 'Jl. Kusuma Bangsa No. 70, Kel. Pasar Baru', '081899001122', 'Usaha', 'eddy24', 'pass24', 'Aktif', 18),
(25, '14200000025', 'Mariana', 'Jl. Anggur No. 6, Kel. Sungai Pinang', '081900112233', 'Usaha', 'mariana25', 'pass25', 'Aktif', 20),
(26, '14200000026', 'Joko Purnomo', 'Jl. Pelabuhan No. 23, Kel. Mangkupalas', '085711223344', 'Usaha', 'joko26', 'pass26', 'Aktif', 22),
(27, '14200000027', 'Siska Amelia', 'Jl. Sultan Alimuddin No. 44, Kel. Sungai Dama', '085722334455', 'Usaha', 'siska27', 'pass27', 'Tidak Aktif', 11),
(28, '14200000028', 'Hendrik Wijaya', 'Jl. Industri No. 15, Kel. Loa Janan Ilir', '085733445566', 'Usaha', 'hendrik28', 'pass28', 'Aktif', 13),
(29, '14200000029', 'Tiara Ningsih', 'Jl. Raya Samarinda-Bontang Km 12', '085744556677', 'Usaha', 'tiara29', 'pass29', 'Aktif', 16),
(30, '14200000030', 'Ir. Rudi Hartono', 'Kawasan Industri Kariangau Lot 7', '085755667788', 'Usaha', 'rudi30', 'pass30', 'Aktif', 22),
(31, '14200000031', 'Rina Kusumawati', 'Jl. Pangeran Antasari No. 10, Kel. Sungai Pinang', '082811112222', 'Rumah Tangga', 'rina31', 'pass31', 'Aktif', 1),
(32, '14200000032', 'Budi Santoso', 'Jl. Kakap No. 22, Kel. Sungai Dama', '082822223333', 'Rumah Tangga', 'budi32', 'pass32', 'Aktif', 2),
(33, '14200000033', 'Dewi Lestari', 'Jl. Juanda No. 30, Kel. Karang Asam', '082833334444', 'Rumah Tangga', 'dewi33', 'pass33', 'Aktif', 3),
(34, '14200000034', 'Akbar Ramadhan', 'Jl. Bung Tomo No. 77, Kel. Bugis', '082844445555', 'Rumah Tangga', 'akbar34', 'pass34', 'Tidak Aktif', 4),
(35, '14200000035', 'Melati Anggraini', 'Jl. Merdeka No. 15, Kel. Pasar Baru', '082855556666', 'Rumah Tangga', 'melati35', 'pass35', 'Aktif', 5),
(36, '14200000036', 'Fajar Nugroho', 'Jl. Pramuka No. 102, Kel. Sungai Kapih', '082866667777', 'Rumah Tangga', 'fajar36', 'pass36', 'Aktif', 6),
(37, '14200000037', 'Susi Handayani', 'Jl. Wahid Hasyim No. 40, Kel. Sungai Pinang', '082877778888', 'Rumah Tangga', 'susi37', 'pass37', 'Aktif', 8),
(38, '14200000038', 'Rudianto', 'Jl. Teuku Umar No. 5, Kel. Karang Mumus', '082888889999', 'Rumah Tangga', 'rudianto38', 'pass38', 'Aktif', 9),
(39, '14200000039', 'Nurul Hidayah', 'Jl. Cipto No. 18, Kel. Sidodadi', '082899990000', 'Rumah Tangga', 'nurul39', 'pass39', 'Aktif', 10),
(40, '14200000040', 'Samsul Arifin', 'Jl. Pelita Raya No. 9, Kel. Pelita', '081311122233', 'Usaha', 'samsul40', 'pass40', 'Aktif', 11),
(41, '14200000041', 'Wati Purnamasari', 'Jl. Yos Sudarso No. 90, Kel. Loa Bakung', '081322233344', 'Usaha', 'wati41', 'pass41', 'Aktif', 12),
(42, '14200000042', 'Hadi Pranoto', 'Jl. Pasar Segiri No. 4, Kel. Pasar Pagi', '081333344455', 'Usaha', 'hadi42', 'pass42', 'Aktif', 14),
(43, '14200000043', 'Lina Marlina', 'Jl. Gajah Mada No. 61, Kel. Sungai Pinang', '081344455566', 'Usaha', 'lina43', 'pass43', 'Aktif', 16),
(44, '14200000044', 'Yudi Setiawan', 'Jl. Ahmad Dahlan No. 12, Kel. Sungai Pinang', '082911223344', 'Rumah Tangga', 'yudi44', 'pass44', 'Aktif', 7),
(45, '14200000045', 'Citra Permata', 'Jl. Kemakmuran No. 8, Kel. Air Putih', '082922334455', 'Rumah Tangga', 'citra45', 'pass45', 'Aktif', 10),
(46, '14200000046', 'Rendi Saputra', 'Jl. Kesuma Bangsa No. 26, Kel. Bugis', '082933445566', 'Rumah Tangga', 'rendi46', 'pass46', 'Menunggu', 2),
(47, '14200000047', 'Ani Wulandari', 'Jl. Sungai Dama No. 14, Kel. Sungai Dama', '082944556677', 'Rumah Tangga', 'ani47', 'pass47', 'Menunggu', 4),
(48, '14200000048', 'Toko Berkah Jaya', 'Jl. Pasar Pagi Blok A No. 5, Kel. Pasar Pagi', '081355667788', 'Usaha', 'berkah48', 'pass48', 'Menunggu', 17),
(49, '14200000049', 'Hendra Gunawan', 'Jl. Pelabuhan No. 40, Kel. Mangkupalas', '081366778899', 'Usaha', 'hendra49', 'pass49', 'Menunggu', 19),
(50, '14200000050', 'Ir. Sahrul Ramadan', 'Kawasan Industri Palaran Blok C-2', '081377889900', 'Usaha', 'sahrul50', 'pass50', 'Menunggu', 22);

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `id_pembayaran` int NOT NULL,
  `no_struk` varchar(30) NOT NULL,
  `tanggal_bayar` datetime NOT NULL,
  `jumlah_bayar` decimal(14,2) NOT NULL,
  `metode` enum('Tunai','Digital') NOT NULL,
  `id_tagihan` int NOT NULL,
  `id_kasir` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pembayaran`
--

INSERT INTO `pembayaran` (`id_pembayaran`, `no_struk`, `tanggal_bayar`, `jumlah_bayar`, `metode`, `id_tagihan`, `id_kasir`) VALUES
(1, 'STR-202610-0001', '2026-10-13 09:00:00', 40275.00, 'Tunai', 1, 4),
(2, 'STR-202610-0002', '2026-10-26 09:40:00', 319302.80, 'Digital', 14, NULL),
(3, 'STR-202610-0003', '2026-10-13 10:15:00', 71550.00, 'Digital', 2, NULL),
(4, 'STR-202610-0004', '2026-10-26 09:15:00', 44425.00, 'Tunai', 27, 5),
(5, 'STR-202610-0005', '2026-10-18 09:00:00', 671468.00, 'Digital', 19, NULL),
(6, 'STR-202610-0006', '2026-10-20 16:00:00', 257822.50, 'Tunai', 8, 6),
(7, 'STR-202610-0007', '2026-10-24 08:50:00', 371901.30, 'Digital', 25, NULL),
(8, 'STR-202610-0008', '2026-10-18 09:20:00', 221320.00, 'Digital', 6, NULL),
(9, 'STR-202611-0009', '2026-11-02 10:00:00', 30315.00, 'Tunai', 39, 4),
(10, 'STR-202610-0010', '2026-10-14 11:00:00', 338229.40, 'Digital', 17, NULL),
(11, 'STR-202610-0011', '2026-10-25 10:00:00', 334413.05, 'Tunai', 13, 5),
(12, 'STR-202610-0012', '2026-10-21 08:45:00', 400891.90, 'Digital', 9, NULL),
(13, 'STR-202610-0013', '2026-10-15 09:30:00', 192811.00, 'Tunai', 30, 6),
(14, 'STR-202610-0014', '2026-10-21 10:30:00', 576458.80, 'Digital', 22, NULL),
(15, 'STR-202610-0015', '2026-10-16 15:00:00', 290422.45, 'Digital', 31, NULL),
(16, 'STR-202610-0016', '2026-10-22 13:10:00', 332910.70, 'Tunai', 10, 4),
(17, 'STR-202610-0017', '2026-10-25 13:00:00', 1945273.00, 'Digital', 26, NULL),
(18, 'STR-202610-0018', '2026-10-24 10:00:00', 376901.30, 'Digital', 12, NULL),
(19, 'STR-202610-0019', '2026-10-17 11:00:00', 26580.00, 'Tunai', 5, 5),
(20, 'STR-202610-0020', '2026-10-17 11:30:00', 631774.00, 'Digital', 18, NULL),
(21, 'STR-202610-0021', '2026-10-27 11:45:00', 89700.00, 'Digital', 28, NULL),
(22, 'STR-202610-0022', '2026-10-17 10:10:00', 247934.20, 'Tunai', 32, 6),
(23, 'STR-202610-0023', '2026-10-22 16:20:00', 1397066.00, 'Digital', 23, NULL),
(24, 'STR-202611-0024', '2026-11-04 09:00:00', 41520.00, 'Tunai', 61, 4),
(25, 'STR-202610-0025', '2026-10-15 10:20:00', 188917.00, 'Digital', 16, NULL),
(26, 'STR-202611-0026', '2026-11-03 11:20:00', 312319.16, 'Digital', 47, NULL),
(27, 'STR-202610-0027', '2026-10-20 14:45:00', 405622.00, 'Digital', 21, NULL),
(28, 'STR-202610-0028', '2026-10-14 14:30:00', 34050.00, 'Digital', 3, NULL),
(29, 'STR-202610-0029', '2026-10-14 10:00:00', 146960.00, 'Digital', 29, NULL),
(30, 'STR-202610-0030', '2026-10-19 14:00:00', 385398.95, 'Digital', 34, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `pengaduan`
--

CREATE TABLE `pengaduan` (
  `id_pengaduan` int NOT NULL,
  `lokasi` varchar(200) NOT NULL,
  `lintang` decimal(9,6) NOT NULL,
  `bujur` decimal(9,6) NOT NULL,
  `tanggal_lapor` datetime NOT NULL,
  `tanggal_selesai` datetime DEFAULT NULL,
  `deskripsi` text NOT NULL,
  `status` enum('Dilaporkan','Diproses','Selesai') NOT NULL,
  `id_petugas_lapangan` int DEFAULT NULL,
  `id_pelanggan` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pengaduan`
--

INSERT INTO `pengaduan` (`id_pengaduan`, `lokasi`, `lintang`, `bujur`, `tanggal_lapor`, `tanggal_selesai`, `deskripsi`, `status`, `id_petugas_lapangan`, `id_pelanggan`) VALUES
(1, 'Jl. Pahlawan No. 12, Kel. Sungai Pinang', -0.478512, 117.142863, '2026-10-05 08:30:00', '2026-10-06 14:00:00', 'Meteran listrik berbunyi dan terasa panas saat dilihat.', 'Selesai', 7, 1),
(2, 'Jl. Bung Tomo No. 45, Kel. Bugis', -0.491236, 117.155471, '2026-10-06 09:15:00', '2026-10-08 11:30:00', 'Lampu rumah sering berkedip dan kadang mati sendiri.', 'Selesai', 8, 2),
(3, 'Jl. Merdeka Gg. 3 No. 7, Kel. Pasar Baru', -0.486789, 117.148902, '2026-10-07 10:00:00', '2026-10-07 16:45:00', 'Tagihan bulan September terasa lebih besar dari biasanya.', 'Selesai', 9, 3),
(4, 'Jl. Antasari No. 33, Kel. Sungai Kunjang', -0.503345, 117.134207, '2026-10-09 13:20:00', '2026-10-10 09:00:00', 'Tidak ada aliran listrik di sebagian ruangan.', 'Selesai', 10, 5),
(5, 'Jl. Ahmad Yani No. 21, Kel. Temindung', -0.494418, 117.163725, '2026-10-10 08:00:00', '2026-10-12 15:10:00', 'Kabel listrik di depan rumah terlihat menggantung.', 'Selesai', 11, 7),
(6, 'Jl. Cipto Mangunkusumo No. 5, Kel. Sidodadi', -0.512873, 117.147650, '2026-10-11 11:40:00', '2026-10-13 10:20:00', 'Stop kontak di kamar tidur mengeluarkan bau gosong.', 'Selesai', 12, 8),
(7, 'Jl. Gajah Mada No. 27, Kel. Sungai Pinang', -0.488960, 117.139884, '2026-10-13 14:05:00', '2026-10-14 12:00:00', 'Meter listrik tidak mencatat pemakaian dengan benar.', 'Selesai', 13, 10),
(8, 'Jl. Wahid Hasyim No. 16, Kel. Sungai Pinang', -0.490127, 117.141560, '2026-10-15 09:00:00', '2026-10-16 17:30:00', 'Pemutus daya sering turun ketika AC dinyalakan.', 'Selesai', 14, 12),
(9, 'Jl. Teuku Umar No. 40, Kel. Karang Mumus', -0.497702, 117.152389, '2026-10-17 07:50:00', '2026-10-18 13:15:00', 'Tegangan listrik terasa turun saat peralatan dinyalakan.', 'Selesai', 15, 14),
(10, 'Jl. Pasar Pagi No. 2, Kel. Pasar Pagi', -0.479965, 117.150918, '2026-10-19 10:30:00', '2026-10-22 10:00:00', 'Listrik toko padam sekitar setengah jam setiap sore.', 'Selesai', 16, 16),
(11, 'Jl. Kesehatan No. 3, Kel. Sungai Pinang', -0.485104, 117.144276, '2026-10-20 15:00:00', '2026-10-21 16:40:00', 'Panel listrik klinik mengeluarkan suara berdengung.', 'Selesai', 17, 19),
(12, 'Kawasan Industri Palaran Blok B-5', -0.572381, 117.187654, '2026-10-22 08:45:00', '2026-10-24 11:00:00', 'Daya listrik tidak stabil pada jam operasional.', 'Selesai', 18, 22),
(13, 'Jl. Kusuma Bangsa No. 70, Kel. Pasar Baru', -0.483659, 117.149703, '2026-10-23 12:30:00', '2026-10-26 09:30:00', 'Mesin cuci listrik sering berhenti mendadak.', 'Selesai', 19, 25),
(14, 'Jl. Pelabuhan No. 23, Kel. Mangkupalas', -0.456782, 117.175340, '2026-10-12 10:10:00', NULL, 'Kabel service terlihat rusak dan perlu diperiksa.', 'Diproses', 7, 26),
(15, 'Jl. Industri No. 15, Kel. Loa Janan Ilir', -0.530128, 117.128945, '2026-10-14 08:40:00', NULL, 'Tagihan tidak sesuai dengan pemakaian listrik bulan ini.', 'Diproses', 8, 28),
(16, 'Jl. Raya Samarinda-Bontang Km 12', -0.462917, 117.203418, '2026-10-16 13:00:00', NULL, 'Gardu listrik di area usaha mengeluarkan bunyi keras.', 'Diproses', 9, 29),
(17, 'Jl. Kesehatan No. 3, Kel. Sungai Pinang', -0.487541, 117.143012, '2026-10-18 09:50:00', NULL, 'Instalasi listrik ruang periksa sering turun daya.', 'Diproses', 10, 19),
(18, 'Jl. Yos Sudarso No. 52, Kel. Loa Bakung', -0.518834, 117.124706, '2026-10-21 16:20:00', NULL, 'Lampu penerangan depan usaha tidak menyala.', 'Diproses', 11, 18),
(19, 'Jl. Basuki Rahmat No. 19, Kel. Pelita', -0.510962, 117.156283, '2026-10-23 11:15:00', NULL, 'Meteran listrik usaha tampak retak pada kaca penutup.', 'Diproses', 12, 21),
(20, 'Jl. Slamet Riyadi No. 8, Kel. Sungai Kapih', -0.479380, 117.127599, '2026-10-25 14:30:00', NULL, 'Listrik sering padam pada siang hari.', 'Diproses', 13, 23),
(21, 'Jl. Industri No. 15, Kel. Loa Janan Ilir', -0.529876, 117.131502, '2026-10-27 10:00:00', NULL, 'Penambahan daya belum diproses sesuai pengajuan.', 'Diproses', 14, 28),
(22, 'Jl. Pangeran Antasari No. 10, Kel. Sungai Pinang', -0.491874, 117.140231, '2026-10-28 08:20:00', NULL, 'Pemasangan kWh meter baru belum dilakukan.', 'Diproses', 15, 31),
(23, 'Jl. Pelita Raya No. 9, Kel. Pelita', -0.508213, 117.158867, '2026-10-29 15:45:00', NULL, 'Tegangan listrik rendah ketika mesin produksi dinyalakan.', 'Diproses', 16, 36),
(24, 'Jl. Anggur No. 6, Kel. Sungai Pinang', -0.484297, 117.146015, '2026-10-30 09:00:00', NULL, 'Ada kabel listrik tergantung rendah di depan rumah.', 'Dilaporkan', NULL, 25),
(25, 'Jl. Sultan Alimuddin No. 44, Kel. Sungai Dama', -0.517630, 117.118492, '2026-10-31 10:30:00', NULL, 'Lampu jalan di sekitar rumah tidak menyala.', 'Dilaporkan', NULL, 29),
(26, 'Jl. Juanda No. 30, Kel. Karang Asam', -0.476083, 117.166574, '2026-11-01 13:10:00', NULL, 'Listrik di rumah tiba-tiba padam beberapa kali.', 'Dilaporkan', NULL, 33),
(27, 'Jl. Merdeka No. 15, Kel. Pasar Baru', -0.489651, 117.150238, '2026-11-02 08:15:00', NULL, 'Mesin pompa air tidak bisa menyala.', 'Dilaporkan', NULL, 35),
(28, 'Jl. Teuku Umar No. 5, Kel. Karang Mumus', -0.499027, 117.155912, '2026-11-02 11:50:00', NULL, 'Bunyi percikan terdengar dari dalam box meter.', 'Dilaporkan', NULL, 38),
(29, 'Jl. Pelita Raya No. 9, Kel. Pelita', -0.509845, 117.160473, '2026-11-03 14:20:00', NULL, 'Tagihan bulan Oktober terasa tidak sesuai pemakaian.', 'Dilaporkan', NULL, 40),
(30, 'Jl. Kemakmuran No. 8, Kel. Air Putih', -0.466518, 117.128734, '2026-11-04 09:05:00', NULL, 'Stop kontak ruang tamu tidak berfungsi.', 'Dilaporkan', NULL, 42);

-- --------------------------------------------------------

--
-- Table structure for table `petugas_lapangan`
--

CREATE TABLE `petugas_lapangan` (
  `id_karyawan` int NOT NULL,
  `wilayah_tugas` varchar(100) NOT NULL,
  `spesialis` enum('Teknisi','Catat Meter','Keduanya') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `petugas_lapangan`
--

INSERT INTO `petugas_lapangan` (`id_karyawan`, `wilayah_tugas`, `spesialis`) VALUES
(7, 'Samarinda Ulu', 'Catat Meter'),
(8, 'Samarinda Ilir', 'Catat Meter'),
(9, 'Samarinda Utara', 'Catat Meter'),
(10, 'Sungai Kunjang', 'Catat Meter'),
(11, 'Sungai Pinang', 'Teknisi'),
(12, 'Palaran', 'Teknisi'),
(13, 'Loa Janan Ilir', 'Teknisi'),
(14, 'Samarinda Seberang', 'Teknisi'),
(15, 'Sungai Kapih', 'Teknisi'),
(16, 'Samarinda Kota', 'Keduanya'),
(17, 'Sambutan', 'Keduanya'),
(18, 'Loa Bakung', 'Keduanya'),
(19, 'Mangkupalas', 'Keduanya'),
(20, 'Bugis', 'Keduanya');

-- --------------------------------------------------------

--
-- Table structure for table `rumah_tangga`
--

CREATE TABLE `rumah_tangga` (
  `id_pelanggan` int NOT NULL,
  `nik` char(16) NOT NULL,
  `kategori_subsidi` enum('Subsidi','Non-Subsidi') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `rumah_tangga`
--

INSERT INTO `rumah_tangga` (`id_pelanggan`, `nik`, `kategori_subsidi`) VALUES
(1, '6471011201800001', 'Subsidi'),
(2, '6471024505850002', 'Subsidi'),
(3, '6471013008750003', 'Subsidi'),
(4, '6471026712900004', 'Subsidi'),
(5, '6471010903680005', 'Subsidi'),
(6, '6471025110950006', 'Subsidi'),
(7, '6471012207820007', 'Non-Subsidi'),
(8, '6471024108880008', 'Non-Subsidi'),
(9, '6471011505760009', 'Non-Subsidi'),
(10, '6471026203910010', 'Non-Subsidi'),
(11, '6471010611830011', 'Non-Subsidi'),
(12, '6471025704940012', 'Non-Subsidi'),
(13, '6471013112700013', 'Non-Subsidi'),
(14, '6471022809890014', 'Non-Subsidi'),
(15, '6471010708860015', 'Non-Subsidi'),
(31, '6471011503920031', 'Subsidi'),
(32, '6471022007880032', 'Subsidi'),
(33, '6471010511950033', 'Non-Subsidi'),
(34, '6471021302800034', 'Non-Subsidi'),
(35, '6471012809990035', 'Non-Subsidi'),
(36, '6471020106910036', 'Non-Subsidi'),
(37, '6471026204840037', 'Non-Subsidi'),
(38, '6471011712760038', 'Non-Subsidi'),
(39, '6471024908930039', 'Non-Subsidi'),
(44, '6471013001970044', 'Non-Subsidi'),
(45, '6471025210020045', 'Non-Subsidi'),
(46, '6471012505890046', 'Subsidi'),
(47, '6471024303980047', 'Non-Subsidi');

-- --------------------------------------------------------

--
-- Table structure for table `tagihan`
--

CREATE TABLE `tagihan` (
  `id_tagihan` int NOT NULL,
  `id_pelanggan` int NOT NULL,
  `bulan` varchar(10) NOT NULL,
  `tahun` varchar(4) NOT NULL,
  `meter_awal` decimal(10,2) NOT NULL,
  `meter_akhir` decimal(10,2) NOT NULL,
  `jumlah_pemakaian_kwh` decimal(10,2) NOT NULL,
  `total_biaya` decimal(14,2) NOT NULL,
  `jatuh_tempo` date NOT NULL,
  `status` varchar(20) NOT NULL,
  `id_petugas_lapangan` int NOT NULL,
  `id_kasir` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tagihan`
--

INSERT INTO `tagihan` (`id_tagihan`, `id_pelanggan`, `bulan`, `tahun`, `meter_awal`, `meter_akhir`, `jumlah_pemakaian_kwh`, `total_biaya`, `jatuh_tempo`, `status`, `id_petugas_lapangan`, `id_kasir`) VALUES
(1, 1, 'Oktober', '2026', 1300.00, 1385.00, 85.00, 40275.00, '2026-10-15', 'Lunas', 7, 4),
(2, 2, 'Oktober', '2026', 3600.00, 3710.00, 110.00, 71550.00, '2026-10-16', 'Lunas', 8, 5),
(3, 3, 'Oktober', '2026', 850.00, 920.00, 70.00, 34050.00, '2026-10-17', 'Lunas', 9, 6),
(4, 4, 'Oktober', '2026', 2200.00, 2330.00, 130.00, 83650.00, '2026-10-18', 'Terlambat', 10, 4),
(5, 5, 'Oktober', '2026', 540.00, 592.00, 52.00, 26580.00, '2026-10-19', 'Lunas', 16, 5),
(6, 7, 'Oktober', '2026', 4400.00, 4560.00, 160.00, 221320.00, '2026-10-20', 'Lunas', 17, 6),
(7, 8, 'Oktober', '2026', 7850.00, 8050.00, 200.00, 293940.00, '2026-10-21', 'Belum Lunas', 18, 4),
(8, 9, 'Oktober', '2026', 9300.00, 9475.00, 175.00, 257822.50, '2026-10-22', 'Lunas', 19, 5),
(9, 10, 'Oktober', '2026', 5200.00, 5430.00, 230.00, 400891.90, '2026-10-23', 'Lunas', 20, 6),
(10, 11, 'Oktober', '2026', 2600.00, 2790.00, 190.00, 332910.70, '2026-10-24', 'Lunas', 7, 4),
(11, 12, 'Oktober', '2026', 15500.00, 15740.00, 240.00, 417887.20, '2026-10-25', 'Terlambat', 8, 5),
(12, 14, 'Oktober', '2026', 6000.00, 6210.00, 210.00, 376901.30, '2026-10-26', 'Lunas', 9, 6),
(13, 15, 'Oktober', '2026', 12000.00, 12185.00, 185.00, 334413.05, '2026-10-27', 'Lunas', 10, 4),
(14, 16, 'Oktober', '2026', 11300.00, 11560.00, 260.00, 319302.80, '2026-10-28', 'Lunas', 16, 5),
(15, 17, 'Oktober', '2026', 21900.00, 22200.00, 300.00, 524859.00, '2026-10-15', 'Belum Lunas', 17, 6),
(16, 18, 'Oktober', '2026', 6500.00, 6610.00, 110.00, 188917.00, '2026-10-16', 'Lunas', 18, 4),
(17, 19, 'Oktober', '2026', 36000.00, 36230.00, 230.00, 338229.40, '2026-10-17', 'Lunas', 19, 5),
(18, 21, 'Oktober', '2026', 7000.00, 7420.00, 420.00, 631774.00, '2026-10-18', 'Lunas', 20, 6),
(19, 22, 'Oktober', '2026', 98600.00, 99200.00, 600.00, 671468.00, '2026-10-19', 'Lunas', 7, 4),
(20, 23, 'Oktober', '2026', 121300.00, 122080.00, 780.00, 1340633.40, '2026-10-20', 'Terlambat', 8, 5),
(21, 24, 'Oktober', '2026', 5000.00, 5260.00, 260.00, 405622.00, '2026-10-21', 'Lunas', 9, 6),
(22, 25, 'Oktober', '2026', 40000.00, 40460.00, 460.00, 576458.80, '2026-10-22', 'Lunas', 10, 4),
(23, 26, 'Oktober', '2026', 6400.00, 7300.00, 900.00, 1397066.00, '2026-10-23', 'Lunas', 16, 5),
(24, 28, 'Oktober', '2026', 45410.00, 45740.00, 330.00, 391807.40, '2026-10-24', 'Belum Lunas', 17, 6),
(25, 29, 'Oktober', '2026', 18000.00, 18210.00, 210.00, 371901.30, '2026-10-25', 'Lunas', 18, 4),
(26, 30, 'Oktober', '2026', 311500.00, 312950.00, 1450.00, 1945273.00, '2026-10-26', 'Lunas', 19, 5),
(27, 31, 'Oktober', '2026', 1050.00, 1145.00, 95.00, 44425.00, '2026-10-27', 'Lunas', 20, 6),
(28, 32, 'Oktober', '2026', 2300.00, 2440.00, 140.00, 89700.00, '2026-10-28', 'Lunas', 7, 4),
(29, 33, 'Oktober', '2026', 600.00, 705.00, 105.00, 146960.00, '2026-10-15', 'Lunas', 8, 5),
(30, 35, 'Oktober', '2026', 1500.00, 1630.00, 130.00, 192811.00, '2026-10-16', 'Lunas', 9, 6),
(31, 36, 'Oktober', '2026', 800.00, 965.00, 165.00, 290422.45, '2026-10-17', 'Lunas', 10, 4),
(32, 37, 'Oktober', '2026', 3000.00, 3140.00, 140.00, 247934.20, '2026-10-18', 'Lunas', 16, 5),
(33, 38, 'Oktober', '2026', 7200.00, 7395.00, 195.00, 351408.35, '2026-10-19', 'Terlambat', 17, 6),
(34, 39, 'Oktober', '2026', 4200.00, 4415.00, 215.00, 385398.95, '2026-10-20', 'Lunas', 18, 4),
(35, 1, 'November', '2026', 1385.00, 1463.00, 78.00, 37370.00, '2026-11-15', 'Belum Lunas', 19, 4),
(36, 2, 'November', '2026', 3710.00, 3835.00, 125.00, 80625.00, '2026-11-16', 'Belum Lunas', 20, 5),
(37, 3, 'November', '2026', 920.00, 986.00, 66.00, 32390.00, '2026-11-17', 'Belum Lunas', 7, 6),
(38, 4, 'November', '2026', 2330.00, 2448.00, 118.00, 76390.00, '2026-11-18', 'Belum Lunas', 8, 4),
(39, 5, 'November', '2026', 592.00, 653.00, 61.00, 30315.00, '2026-11-19', 'Lunas', 9, 5),
(40, 7, 'November', '2026', 4560.00, 4708.00, 148.00, 205096.00, '2026-11-20', 'Belum Lunas', 10, 6),
(41, 8, 'November', '2026', 8050.00, 8235.00, 185.00, 272269.50, '2026-11-21', 'Belum Lunas', 16, 4),
(42, 9, 'November', '2026', 9475.00, 9665.00, 190.00, 279493.00, '2026-11-22', 'Belum Lunas', 17, 5),
(43, 10, 'November', '2026', 5430.00, 5644.00, 214.00, 373699.42, '2026-11-23', 'Belum Lunas', 18, 6),
(44, 11, 'November', '2026', 2790.00, 2995.00, 205.00, 358403.65, '2026-11-24', 'Belum Lunas', 19, 4),
(45, 12, 'November', '2026', 15740.00, 15966.00, 226.00, 394093.78, '2026-11-25', 'Belum Lunas', 20, 5),
(46, 14, 'November', '2026', 6210.00, 6408.00, 198.00, 356506.94, '2026-11-26', 'Belum Lunas', 7, 6),
(47, 15, 'November', '2026', 12185.00, 12357.00, 172.00, 312319.16, '2026-11-27', 'Lunas', 8, 4),
(48, 16, 'November', '2026', 11560.00, 11805.00, 245.00, 303766.10, '2026-11-28', 'Belum Lunas', 9, 5),
(49, 17, 'November', '2026', 22200.00, 22485.00, 285.00, 499366.05, '2026-11-15', 'Belum Lunas', 10, 6),
(50, 18, 'November', '2026', 6610.00, 6730.00, 120.00, 203364.00, '2026-11-16', 'Belum Lunas', 16, 4),
(51, 19, 'November', '2026', 36230.00, 36470.00, 240.00, 348587.20, '2026-11-17', 'Belum Lunas', 17, 5),
(52, 21, 'November', '2026', 7420.00, 7805.00, 385.00, 581109.50, '2026-11-18', 'Belum Lunas', 18, 6),
(53, 22, 'November', '2026', 99200.00, 99775.00, 575.00, 645573.50, '2026-11-19', 'Belum Lunas', 19, 4),
(54, 23, 'November', '2026', 122080.00, 122890.00, 810.00, 1391617.30, '2026-11-20', 'Belum Lunas', 20, 5),
(55, 24, 'November', '2026', 5260.00, 5500.00, 240.00, 376728.00, '2026-11-21', 'Belum Lunas', 7, 6),
(56, 25, 'November', '2026', 40460.00, 40890.00, 430.00, 545385.40, '2026-11-22', 'Belum Lunas', 8, 4),
(57, 26, 'November', '2026', 7300.00, 8170.00, 870.00, 1367163.80, '2026-11-23', 'Belum Lunas', 9, 5),
(58, 28, 'November', '2026', 45740.00, 46045.00, 305.00, 365912.90, '2026-11-24', 'Belum Lunas', 10, 6),
(59, 29, 'November', '2026', 18210.00, 18435.00, 225.00, 397394.25, '2026-11-25', 'Belum Lunas', 16, 4),
(60, 30, 'November', '2026', 312950.00, 314470.00, 1520.00, 2014844.80, '2026-11-26', 'Belum Lunas', 17, 5),
(61, 31, 'November', '2026', 1145.00, 1233.00, 88.00, 41520.00, '2026-11-27', 'Lunas', 18, 6),
(62, 32, 'November', '2026', 2440.00, 2572.00, 132.00, 84860.00, '2026-11-28', 'Belum Lunas', 19, 4),
(63, 33, 'November', '2026', 705.00, 803.00, 98.00, 137496.00, '2026-11-15', 'Belum Lunas', 20, 5),
(64, 35, 'November', '2026', 1630.00, 1772.00, 142.00, 210107.40, '2026-11-16', 'Belum Lunas', 7, 6),
(65, 36, 'November', '2026', 965.00, 1143.00, 178.00, 312516.34, '2026-11-17', 'Belum Lunas', 8, 4),
(66, 37, 'November', '2026', 3140.00, 3290.00, 150.00, 264929.50, '2026-11-18', 'Belum Lunas', 9, 5),
(67, 38, 'November', '2026', 7395.00, 7575.00, 180.00, 325915.40, '2026-11-19', 'Belum Lunas', 10, 6),
(68, 39, 'November', '2026', 4415.00, 4645.00, 230.00, 410891.90, '2026-11-20', 'Belum Lunas', 16, 4);

-- --------------------------------------------------------

--
-- Table structure for table `usaha`
--

CREATE TABLE `usaha` (
  `id_pelanggan` int NOT NULL,
  `npwp` varchar(20) NOT NULL,
  `nama_usaha` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `usaha`
--

INSERT INTO `usaha` (`id_pelanggan`, `npwp`, `nama_usaha`) VALUES
(16, '012345678901000', 'UD Grosir Pasar Pagi'),
(17, '023456789012000', 'Warung Makan Sederhana'),
(18, '034567890123000', 'Hotel Mentari'),
(19, '045678901234000', 'Klinik Sehat Sentosa'),
(20, '056789012345000', 'Supermarket Sumber Rejeki'),
(21, '067890123456000', 'Apotek Kasih'),
(22, '078901234567000', 'PT Mega Konstruksi Nusantara'),
(23, '089012345678000', 'RS Harapan Bunda'),
(24, '090123456789000', 'Mall Samarinda Plaza'),
(25, '001234567890000', 'Home Industri Keripik Singkong Mbak Mar'),
(26, '002345678901000', 'Bengkel Las Jaya Abadi'),
(27, '003456789012000', 'Konveksi Amelia'),
(28, '004567890123000', 'Pabrik Tahu Sumber Murni'),
(29, '005678901234000', 'Pabrik Roti Tiara'),
(30, '006789012345000', 'PT Baja Nusa Pratama'),
(40, '101234567890000', 'Toko Bangunan Pelita Raya'),
(41, '112345678901000', 'Rumah Makan Purnama'),
(42, '123456789012000', 'CV Hadi Pranoto Distribusi'),
(43, '134567890123000', 'Butik Lina Marlina'),
(48, '145678901234000', 'Toko Berkah Jaya'),
(49, '156789012345000', 'CV Hendra Gunawan Logistik'),
(50, '167890123456000', 'PT Palaran Industri Sejahtera');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_karyawan`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `golongan`
--
ALTER TABLE `golongan`
  ADD PRIMARY KEY (`id_golongan`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id_karyawan`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `kasir`
--
ALTER TABLE `kasir`
  ADD PRIMARY KEY (`id_karyawan`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`),
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `fk_pelanggan_golongan` (`id_golongan`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`id_pembayaran`),
  ADD UNIQUE KEY `no_struk` (`no_struk`),
  ADD KEY `fk_bayar_tagihan` (`id_tagihan`),
  ADD KEY `fk_bayar_kasir` (`id_kasir`);

--
-- Indexes for table `pengaduan`
--
ALTER TABLE `pengaduan`
  ADD PRIMARY KEY (`id_pengaduan`),
  ADD KEY `fk_pengaduan_petugas` (`id_petugas_lapangan`),
  ADD KEY `fk_pengaduan_pelanggan` (`id_pelanggan`);

--
-- Indexes for table `petugas_lapangan`
--
ALTER TABLE `petugas_lapangan`
  ADD PRIMARY KEY (`id_karyawan`);

--
-- Indexes for table `rumah_tangga`
--
ALTER TABLE `rumah_tangga`
  ADD PRIMARY KEY (`id_pelanggan`),
  ADD UNIQUE KEY `nik` (`nik`);

--
-- Indexes for table `tagihan`
--
ALTER TABLE `tagihan`
  ADD PRIMARY KEY (`id_tagihan`),
  ADD KEY `fk_tagihan_pelanggan` (`id_pelanggan`),
  ADD KEY `fk_tagihan_petugas` (`id_petugas_lapangan`),
  ADD KEY `fk_tagihan_kasir` (`id_kasir`);

--
-- Indexes for table `usaha`
--
ALTER TABLE `usaha`
  ADD PRIMARY KEY (`id_pelanggan`),
  ADD UNIQUE KEY `npwp` (`npwp`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `golongan`
--
ALTER TABLE `golongan`
  MODIFY `id_golongan` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `karyawan`
--
ALTER TABLE `karyawan`
  MODIFY `id_karyawan` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `id_pelanggan` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT for table `pembayaran`
--
ALTER TABLE `pembayaran`
  MODIFY `id_pembayaran` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `pengaduan`
--
ALTER TABLE `pengaduan`
  MODIFY `id_pengaduan` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `tagihan`
--
ALTER TABLE `tagihan`
  MODIFY `id_tagihan` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `fk_admin_karyawan` FOREIGN KEY (`id_karyawan`) REFERENCES `karyawan` (`id_karyawan`);

--
-- Constraints for table `kasir`
--
ALTER TABLE `kasir`
  ADD CONSTRAINT `fk_kasir_karyawan` FOREIGN KEY (`id_karyawan`) REFERENCES `karyawan` (`id_karyawan`);

--
-- Constraints for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD CONSTRAINT `fk_pelanggan_golongan` FOREIGN KEY (`id_golongan`) REFERENCES `golongan` (`id_golongan`);

--
-- Constraints for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD CONSTRAINT `fk_bayar_kasir` FOREIGN KEY (`id_kasir`) REFERENCES `kasir` (`id_karyawan`),
  ADD CONSTRAINT `fk_bayar_tagihan` FOREIGN KEY (`id_tagihan`) REFERENCES `tagihan` (`id_tagihan`);

--
-- Constraints for table `pengaduan`
--
ALTER TABLE `pengaduan`
  ADD CONSTRAINT `fk_pengaduan_pelanggan` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id_pelanggan`),
  ADD CONSTRAINT `fk_pengaduan_petugas` FOREIGN KEY (`id_petugas_lapangan`) REFERENCES `petugas_lapangan` (`id_karyawan`);

--
-- Constraints for table `petugas_lapangan`
--
ALTER TABLE `petugas_lapangan`
  ADD CONSTRAINT `fk_pl_karyawan` FOREIGN KEY (`id_karyawan`) REFERENCES `karyawan` (`id_karyawan`);

--
-- Constraints for table `rumah_tangga`
--
ALTER TABLE `rumah_tangga`
  ADD CONSTRAINT `fk_rt_pelanggan` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id_pelanggan`);

--
-- Constraints for table `tagihan`
--
ALTER TABLE `tagihan`
  ADD CONSTRAINT `fk_tagihan_kasir` FOREIGN KEY (`id_kasir`) REFERENCES `kasir` (`id_karyawan`),
  ADD CONSTRAINT `fk_tagihan_pelanggan` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id_pelanggan`),
  ADD CONSTRAINT `fk_tagihan_petugas` FOREIGN KEY (`id_petugas_lapangan`) REFERENCES `petugas_lapangan` (`id_karyawan`);

--
-- Constraints for table `usaha`
--
ALTER TABLE `usaha`
  ADD CONSTRAINT `fk_usaha_pelanggan` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id_pelanggan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
