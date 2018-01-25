-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 25, 2018 lúc 09:03 SA
-- Phiên bản máy phục vụ: 10.1.21-MariaDB
-- Phiên bản PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `thietbi`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thietbi`
--

CREATE TABLE `thietbi` (
  `thietbi_id` int(11) NOT NULL,
  `thietbi_ten` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `danhmuc_thietbi_id` int(11) NOT NULL,
  `tinhtrang_id` int(11) NOT NULL,
  `thietbi_ngaynhap` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `thietbi`
--

INSERT INTO `thietbi` (`thietbi_id`, `thietbi_ten`, `danhmuc_thietbi_id`, `tinhtrang_id`, `thietbi_ngaynhap`) VALUES
(1, 'PC Intel Core i7 4790 3.6GHz', 1, 1, '2018-01-24'),
(2, 'PC Intel Core i7 4790 3.6GHz', 1, 2, '2018-01-17');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `thietbi`
--
ALTER TABLE `thietbi`
  ADD PRIMARY KEY (`thietbi_id`),
  ADD KEY `fk_danhmuc` (`danhmuc_thietbi_id`),
  ADD KEY `fk_tinhtrang` (`tinhtrang_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `thietbi`
--
ALTER TABLE `thietbi`
  MODIFY `thietbi_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `thietbi`
--
ALTER TABLE `thietbi`
  ADD CONSTRAINT `fk_danhmuc` FOREIGN KEY (`danhmuc_thietbi_id`) REFERENCES `danhmuc_thietbi` (`danhmuc_thietbi_id`),
  ADD CONSTRAINT `fk_tinhtrang` FOREIGN KEY (`tinhtrang_id`) REFERENCES `tinhtrang` (`tinhtrang_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
