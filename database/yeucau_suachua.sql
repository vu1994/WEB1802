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
-- Cấu trúc bảng cho bảng `yeucau_suachua`
--

CREATE TABLE `yeucau_suachua` (
  `yeucau_id` int(11) NOT NULL,
  `yeucau_nv_id` int(11) NOT NULL,
  `yeucau_tb_id` int(11) NOT NULL,
  `yeucau_ngayyeucau` date NOT NULL,
  `yeucau_tinhtranghong` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `yeucau_tinhtrangsc` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `yeucau_suachua`
--

INSERT INTO `yeucau_suachua` (`yeucau_id`, `yeucau_nv_id`, `yeucau_tb_id`, `yeucau_ngayyeucau`, `yeucau_tinhtranghong`, `yeucau_tinhtrangsc`) VALUES
(1, 1, 1, '2018-02-07', 'Boc khoi', 2),
(2, 1, 11, '2018-02-07', 'Bị nứt', 0),
(3, 1, 1, '2018-02-07', 'Hư', 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `yeucau_suachua`
--
ALTER TABLE `yeucau_suachua`
  ADD PRIMARY KEY (`yeucau_id`),
  ADD KEY `FK_yeucau_suachua_nhanvien` (`yeucau_nv_id`),
  ADD KEY `FK_yeucau_suachua_thietbi` (`yeucau_tb_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `yeucau_suachua`
--
ALTER TABLE `yeucau_suachua`
  MODIFY `yeucau_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `yeucau_suachua`
--
ALTER TABLE `yeucau_suachua`
  ADD CONSTRAINT `FK_yeucau_suachua_nhanvien` FOREIGN KEY (`yeucau_nv_id`) REFERENCES `nhanvien` (`nv_id`),
  ADD CONSTRAINT `FK_yeucau_suachua_thietbi` FOREIGN KEY (`yeucau_tb_id`) REFERENCES `thietbi` (`thietbi_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
