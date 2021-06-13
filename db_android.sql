-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 13 Jun 2021 pada 16.07
-- Versi server: 10.4.8-MariaDB
-- Versi PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_android`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_data`
--

CREATE TABLE `tb_data` (
  `staff_id` int(11) NOT NULL,
  `staff_name` varchar(30) NOT NULL,
  `staff_keluhan` varchar(1000) NOT NULL,
  `staff_fakultas` varchar(50) NOT NULL,
  `staff_penerima` varchar(30) NOT NULL,
  `staff_tanggal` varchar(11) NOT NULL,
  `staff_tipe` varchar(10) NOT NULL,
  `staff_tindakan` varchar(300) NOT NULL,
  `staff_status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_data`
--

INSERT INTO `tb_data` (`staff_id`, `staff_name`, `staff_keluhan`, `staff_fakultas`, `staff_penerima`, `staff_tanggal`, `staff_tipe`, `staff_tindakan`, `staff_status`) VALUES
(11, 'Muhammad Yasril Rais', 'Selamat pagi,\nsaya ingin bertanya mengenai beasiswa yang saya miliki. Saya mendapatkan beasiswa OSC, yaitu potongan biaya kuliah sebesar 100. Pada laman pembayaran telah muncul pembayaran BPP semester depan tanpa ada potongan. Apa yang harus saya lakukan selanjutnya? Apa saya harus melakukan klaim atau sejenisnya agar status di laman menjadi lunas? Terimakasih.', 'FTE', '', '14-05-2021', 'Keluhan', 'tesssss', 'open'),
(12, 'Rizky Fajar', 'tes', 'FTE', '', '19-05-2021', 'Masukan', 'tes', 'open'),
(13, 'Fachrie M', 'tess', 'FIK', '', '24-05-2021', 'Keluhan', '', 'open');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_user`
--

CREATE TABLE `tb_user` (
  `user_id` int(11) NOT NULL,
  `user_nama` varchar(125) NOT NULL,
  `user_nim` varchar(11) NOT NULL,
  `user_email` varchar(125) NOT NULL,
  `user_password` varchar(125) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_user`
--

INSERT INTO `tb_user` (`user_id`, `user_nama`, `user_nim`, `user_email`, `user_password`) VALUES
(5, 'yasril', '1103174179', 'yasrilrais', '827ccb0eea8a706c4c34a16891f84e7b'),
(6, 'Rizky Fajar', '1103179174', 'fajar11', '827ccb0eea8a706c4c34a16891f84e7b');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tb_data`
--
ALTER TABLE `tb_data`
  ADD PRIMARY KEY (`staff_id`);

--
-- Indeks untuk tabel `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tb_data`
--
ALTER TABLE `tb_data`
  MODIFY `staff_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT untuk tabel `tb_user`
--
ALTER TABLE `tb_user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
