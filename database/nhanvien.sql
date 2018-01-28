-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 27, 2018 lúc 05:11 PM
-- Phiên bản máy phục vụ: 10.1.26-MariaDB
-- Phiên bản PHP: 7.1.9

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
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `nv_id` int(11) NOT NULL,
  `nv_ten` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `nv_diachi` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `nv_email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `nv_sdt` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `nv_gioitinh` int(1) NOT NULL DEFAULT '1',
  `nv_ngaysinh` date NOT NULL,
  `pb_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`nv_id`, `nv_ten`, `nv_diachi`, `nv_email`, `nv_sdt`, `nv_gioitinh`, `nv_ngaysinh`, `pb_id`) VALUES
(1, 'Trần Hoàng Yến', '18 Xô Viết Nghệ Tĩnh, Cần Thơ', 'tranhoangyen@gmai.com', '0913456789', 0, '1991-02-14', 1),
(2, 'Nguyễn Tuấn Nhã', '16 Nguyễn Trãi, Cần Thơ', 'tuannha@gmail.com', '0975846732', 1, '1991-12-25', 2),
(6, 'Nguyễn Thanh Tuấn', '15 Hoàng Văn Thụ', 'thanhtuan@gmail.com', '01236548752', 1, '1993-10-19', 4);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`nv_id`),
  ADD KEY `FK__phongban` (`pb_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `nv_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD CONSTRAINT `FK__phongban` FOREIGN KEY (`pb_id`) REFERENCES `phongban` (`pb_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
