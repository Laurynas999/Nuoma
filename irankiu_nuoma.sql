-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 22, 2021 at 12:41 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 7.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `irankiu_nuoma`
--

-- --------------------------------------------------------

--
-- Table structure for table `irankiai`
--

CREATE TABLE `irankiai` (
  `id` int(255) NOT NULL,
  `pavadinimas` varchar(150) NOT NULL,
  `tipas` varchar(100) NOT NULL,
  `inventoriaus_nr` varchar(255) NOT NULL,
  `isigyjimo_data` date NOT NULL,
  `isigyjimo_kaina` decimal(30,2) UNSIGNED NOT NULL,
  `nuomos_kaina` decimal(30,2) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `irankiai`
--

INSERT INTO `irankiai` (`id`, `pavadinimas`, `tipas`, `inventoriaus_nr`, `isigyjimo_data`, `isigyjimo_kaina`, `nuomos_kaina`) VALUES
(1, 'Kastuvas', 'Kasimo', 'K-74589', '2021-07-06', '99.99', '10.00'),
(2, 'Grąžtas', 'Gręžimo', 'G-83275', '2021-07-02', '140.35', '15.00');

-- --------------------------------------------------------

--
-- Table structure for table `klientai`
--

CREATE TABLE `klientai` (
  `id` int(255) NOT NULL,
  `kategorija` enum('juridinis','privatus') NOT NULL,
  `pavadinimas` varchar(100) NOT NULL,
  `kontaktai` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `klientai`
--

INSERT INTO `klientai` (`id`, `kategorija`, `pavadinimas`, `kontaktai`) VALUES
(1, 'juridinis', 'Vardenis Pavardenis', 'Tel. nr. 861234567'),
(2, 'privatus', 'Simonas Labas', 'Tel. nr. 861234567, email @gmail'),
(3, 'juridinis', 'Vardenis Pavardenis', 'Tel. nr. 861234567');

-- --------------------------------------------------------

--
-- Table structure for table `nuomos_zurnalas`
--

CREATE TABLE `nuomos_zurnalas` (
  `id` int(255) UNSIGNED NOT NULL,
  `kliento_id` int(255) UNSIGNED DEFAULT NULL,
  `irankio_id` int(255) UNSIGNED DEFAULT NULL,
  `nuoma_nuo` date NOT NULL,
  `nuoma_iki` date NOT NULL,
  `irankio_bukle` int(2) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `irankiai`
--
ALTER TABLE `irankiai`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `klientai`
--
ALTER TABLE `klientai`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `nuomos_zurnalas`
--
ALTER TABLE `nuomos_zurnalas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `irankio_id` (`irankio_id`),
  ADD KEY `kliento_id` (`kliento_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `irankiai`
--
ALTER TABLE `irankiai`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `klientai`
--
ALTER TABLE `klientai`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `nuomos_zurnalas`
--
ALTER TABLE `nuomos_zurnalas`
  MODIFY `id` int(255) UNSIGNED NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
