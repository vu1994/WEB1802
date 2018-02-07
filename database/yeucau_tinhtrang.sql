-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th2 07, 2018 lúc 04:25 PM
-- Phiên bản máy phục vụ: 10.1.30-MariaDB
-- Phiên bản PHP: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `capphatthietbi`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `yeucau_tinhtrang`
--

CREATE TABLE `yeucau_tinhtrang` (
  `yeucau_tinhtrang_id` int(11) NOT NULL,
  `yeucau_tinhtrang_ten` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `yeucau_tinhtrang`
--

INSERT INTO `yeucau_tinhtrang` (`yeucau_tinhtrang_id`, `yeucau_tinhtrang_ten`) VALUES
(0, 'Chưa xử lý'),
(1, 'Đã xử lý'),
(2, 'Hủy yêu cầu');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `yeucau_tinhtrang`
--
ALTER TABLE `yeucau_tinhtrang`
  ADD PRIMARY KEY (`yeucau_tinhtrang_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `yeucau_tinhtrang`
--
ALTER TABLE `yeucau_tinhtrang`
  MODIFY `yeucau_tinhtrang_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
