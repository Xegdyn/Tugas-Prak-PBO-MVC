-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 30, 2023 at 09:34 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kasir`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `harga` int(50) NOT NULL,
  `jumlah` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id`, `nama`, `harga`, `jumlah`) VALUES
(21, 'Gula', 5000, 80),
(22, 'Mie Instan', 2000, 200),
(23, 'Kopi', 10000, 20),
(24, 'Sabun Mandi', 8000, 60),
(25, 'Minyak Goreng', 15000, 130),
(26, 'Tepung Terigu', 7000, 150),
(27, 'Susu Kental Manis', 12000, 60),
(28, 'Sarden Kaleng', 9000, 100),
(29, 'Teh Celup', 6000, 70),
(30, 'Garam', 3000, 75),
(31, 'Kecap Manis', 6000, 79),
(32, 'Saus Tomat', 7000, 100),
(33, 'Mentega', 10000, 35),
(34, 'Tepung Maizena', 4000, 90),
(35, 'Sikat Gigi', 3000, 200),
(36, 'Tissue Toilet', 6000, 150),
(37, 'Telur', 15000, 29),
(38, 'Beras', 20000, 100),
(39, 'Kacang Tanah', 5000, 50),
(40, 'Sirup', 10000, 60),
(42, 'Chicken Wings', 25000, 30),
(43, 'Sosis Ayam', 15000, 40),
(45, 'Teh Botol', 8000, 50);

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `id` int(11) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `barang` varchar(50) NOT NULL,
  `jumlah` int(100) NOT NULL,
  `harga` int(50) NOT NULL,
  `total` int(50) NOT NULL,
  `waktu_pembelian` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`id`, `id_barang`, `barang`, `jumlah`, `harga`, `total`, `waktu_pembelian`) VALUES
(3, 30, 'Garam', 30, 3000, 90000, '2023-05-28 00:08:41'),
(4, 39, 'Kacang Tanah', 20, 5000, 100000, '2023-05-28 00:08:41'),
(5, 22, 'Mie Instan', 25, 2000, 50000, '2023-05-28 00:08:41'),
(6, 38, 'Beras', 24, 20000, 480000, '2023-05-28 00:16:51'),
(7, 33, 'Mentega', 15, 10000, 150000, '2023-05-28 00:16:51'),
(8, 21, 'Gula', 40, 5000, 200000, '2023-05-28 01:32:32'),
(9, 39, 'Kacang Tanah', 10, 5000, 50000, '2023-05-28 01:34:12'),
(10, 30, 'Garam', 20, 3000, 60000, '2023-05-28 01:37:41'),
(11, 23, 'Kopi', 30, 10000, 300000, '2023-05-28 01:37:41'),
(12, 31, 'Kecap Manis', 25, 5000, 125000, '2023-05-28 01:42:56'),
(13, 31, 'Kecap Manis', 5, 5000, 25000, '2023-05-28 01:49:03'),
(14, 38, 'Beras', 4, 20000, 80000, '2023-05-28 14:19:53'),
(15, 37, 'Telur', 10, 15000, 150000, '2023-05-28 14:19:53'),
(16, 38, 'Beras', 1, 20000, 20000, '2023-05-30 12:36:09'),
(17, 30, 'Garam', 1, 3000, 3000, '2023-05-30 12:36:09'),
(18, 21, 'Gula', 1, 5000, 5000, '2023-05-30 12:36:09'),
(19, 25, 'Minyak Goreng', 1, 15000, 15000, '2023-05-30 12:36:09'),
(20, 22, 'Mie Instan', 1, 2000, 2000, '2023-05-30 12:36:09'),
(21, 35, 'Sikat Gigi', 1, 3000, 3000, '2023-05-30 12:36:39'),
(22, 30, 'Garam', 25, 3000, 75000, '2023-05-30 13:25:58'),
(23, 37, 'Telur', 1, 15000, 15000, '2023-05-30 13:46:47'),
(24, 31, 'Kecap Manis', 1, 6000, 6000, '2023-05-30 13:46:48');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_barang` (`id_barang`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT for table `penjualan`
--
ALTER TABLE `penjualan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD CONSTRAINT `penjualan_ibfk_1` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
