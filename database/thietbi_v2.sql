-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 28, 2018 at 12:57 PM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `capphatthietbi`
--

-- --------------------------------------------------------

--
-- Table structure for table `thietbi`
--

CREATE TABLE `thietbi` (
  `thietbi_id` int(11) NOT NULL,
  `thietbi_ten` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `danhmuc_thietbi_id` int(11) NOT NULL,
  `tinhtrang_id` int(11) NOT NULL,
  `thietbi_ngaynhap` date NOT NULL,
  `thietbi_ngaycap` date DEFAULT NULL,
  `thietbi_capcho` int(11) DEFAULT NULL,
  `thietbi_nguoicap` int(11) DEFAULT NULL,
  `thietbi_ngaythuhoi` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `thietbi`
--

INSERT INTO `thietbi` (`thietbi_id`, `thietbi_ten`, `danhmuc_thietbi_id`, `tinhtrang_id`, `thietbi_ngaynhap`, `thietbi_ngaycap`, `thietbi_capcho`, `thietbi_nguoicap`, `thietbi_ngaythuhoi`) VALUES
(1, 'PC Intel Core i7 4790 3.6GHz', 1, 1, '2018-01-24', NULL, NULL, NULL, NULL),
(2, 'Dell ', 2, 2, '2018-01-17', NULL, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `thietbi`
--
ALTER TABLE `thietbi`
  ADD PRIMARY KEY (`thietbi_id`),
  ADD KEY `fk_danhmuc` (`danhmuc_thietbi_id`),
  ADD KEY `fk_tinhtrang` (`tinhtrang_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `thietbi`
--
ALTER TABLE `thietbi`
  MODIFY `thietbi_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `thietbi`
--
ALTER TABLE `thietbi`
  ADD CONSTRAINT `fk_danhmuc` FOREIGN KEY (`danhmuc_thietbi_id`) REFERENCES `danhmuc_thietbi` (`danhmuc_thietbi_id`),
  ADD CONSTRAINT `fk_tinhtrang` FOREIGN KEY (`tinhtrang_id`) REFERENCES `tinhtrang` (`tinhtrang_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
