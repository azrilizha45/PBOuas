-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 14 Des 2021 pada 03.31
-- Versi server: 10.4.21-MariaDB
-- Versi PHP: 7.4.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `notaid_database`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `cttn_pembelian`
--

CREATE TABLE `cttn_pembelian` (
  `id_pembelian` int(8) NOT NULL,
  `nama_barang` varchar(20) NOT NULL,
  `harga_barang` int(10) NOT NULL,
  `jumlah_barang` int(10) NOT NULL,
  `total_harga` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `cttn_pembelian`
--

INSERT INTO `cttn_pembelian` (`id_pembelian`, `nama_barang`, `harga_barang`, `jumlah_barang`, `total_harga`) VALUES
(1, 'snack cheetos', 6500, 2, 13000),
(2, 'susu uht', 12000, 2, 24000),
(3, 'sapu ijuk', 10000, 3, 30000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `rencana_belanja`
--

CREATE TABLE `rencana_belanja` (
  `id_rencana` int(8) NOT NULL,
  `nama_barang` varchar(20) NOT NULL,
  `jumlah_barang` int(255) NOT NULL,
  `tgl_buat` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `rencana_belanja`
--

INSERT INTO `rencana_belanja` (`id_rencana`, `nama_barang`, `jumlah_barang`, `tgl_buat`) VALUES
(1103, 'gelang', 3, '13/12/2021');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `cttn_pembelian`
--
ALTER TABLE `cttn_pembelian`
  ADD PRIMARY KEY (`id_pembelian`);

--
-- Indeks untuk tabel `rencana_belanja`
--
ALTER TABLE `rencana_belanja`
  ADD PRIMARY KEY (`id_rencana`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `cttn_pembelian`
--
ALTER TABLE `cttn_pembelian`
  MODIFY `id_pembelian` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `rencana_belanja`
--
ALTER TABLE `rencana_belanja`
  MODIFY `id_rencana` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1104;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
