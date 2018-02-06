-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th2 06, 2018 lúc 02:26 SA
-- Phiên bản máy phục vụ: 10.1.21-MariaDB
-- Phiên bản PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
-- Cấu trúc bảng cho bảng `danhmuc_thietbi`
--

CREATE TABLE `danhmuc_thietbi` (
  `danhmuc_thietbi_id` int(11) NOT NULL,
  `danhmuc_thietbi_ten` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `danhmuc_thietbi`
--

INSERT INTO `danhmuc_thietbi` (`danhmuc_thietbi_id`, `danhmuc_thietbi_ten`) VALUES
(1, 'CPU'),
(2, 'Màn hình'),
(3, 'Bàn phím');

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
  `nv_gioitinh` tinyint(1) DEFAULT '1',
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

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phongban`
--

CREATE TABLE `phongban` (
  `pb_id` int(11) NOT NULL,
  `pb_ten` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phongban`
--

INSERT INTO `phongban` (`pb_id`, `pb_ten`) VALUES
(1, 'GOV'),
(2, 'BIZ'),
(3, 'UNI'),
(4, 'ITO');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thietbi`
--

CREATE TABLE `thietbi` (
  `thietbi_id` int(11) NOT NULL,
  `thietbi_ten` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `danhmuc_thietbi_id` int(11) NOT NULL,
  `tinhtrang_id` int(11) NOT NULL,
  `thietbi_ngaynhap` date NOT NULL,
  `thietbi_ngaycap` date DEFAULT NULL,
  `thietbi_capcho` int(11) DEFAULT '0',
  `thietbi_nguoicap` int(11) DEFAULT '0',
  `thietbi_trangthai_capphat` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `thietbi_ngaythuhoi` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `thietbi`
--

INSERT INTO `thietbi` (`thietbi_id`, `thietbi_ten`, `danhmuc_thietbi_id`, `tinhtrang_id`, `thietbi_ngaynhap`, `thietbi_ngaycap`, `thietbi_capcho`, `thietbi_nguoicap`, `thietbi_trangthai_capphat`, `thietbi_ngaythuhoi`) VALUES
(1, 'PC Intel Core i7 4790 3.6GHz', 1, 2, '2018-01-24', '2018-01-30', 1, 0, 'Cấp mới', NULL),
(2, 'Dell', 2, 1, '2018-01-17', NULL, 0, 0, NULL, NULL),
(9, 'ava', 1, 1, '2018-02-01', NULL, 0, 0, NULL, NULL),
(10, 'MITSUMI', 3, 2, '2018-01-01', '2018-01-28', 1, 0, 'Cấp mới', NULL),
(11, 'SAMSUNG', 2, 2, '2018-01-01', '2018-02-05', 2, 0, 'Cấp bổ sung', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tinhtrang`
--

CREATE TABLE `tinhtrang` (
  `tinhtrang_id` int(11) NOT NULL,
  `tinhtrang_ten` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `tinhtrang_noidung` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tinhtrang`
--

INSERT INTO `tinhtrang` (`tinhtrang_id`, `tinhtrang_ten`, `tinhtrang_noidung`) VALUES
(1, 'Mới', ''),
(2, 'Đang sử dụng', ''),
(3, 'Đã sử dụng', ''),
(4, 'Bị hỏng', '');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_screenname` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `user_password` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `nv_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`user_id`, `user_screenname`, `user_password`, `nv_id`) VALUES
(1, 'thyen', '1234567', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `danhmuc_thietbi`
--
ALTER TABLE `danhmuc_thietbi`
  ADD PRIMARY KEY (`danhmuc_thietbi_id`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`nv_id`),
  ADD KEY `FK__phongban` (`pb_id`);

--
-- Chỉ mục cho bảng `phongban`
--
ALTER TABLE `phongban`
  ADD PRIMARY KEY (`pb_id`);

--
-- Chỉ mục cho bảng `thietbi`
--
ALTER TABLE `thietbi`
  ADD PRIMARY KEY (`thietbi_id`),
  ADD KEY `fk_danhmuc` (`danhmuc_thietbi_id`),
  ADD KEY `fk_tinhtrang` (`tinhtrang_id`);

--
-- Chỉ mục cho bảng `tinhtrang`
--
ALTER TABLE `tinhtrang`
  ADD PRIMARY KEY (`tinhtrang_id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `fk_user_nv` (`nv_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `danhmuc_thietbi`
--
ALTER TABLE `danhmuc_thietbi`
  MODIFY `danhmuc_thietbi_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `nv_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT cho bảng `phongban`
--
ALTER TABLE `phongban`
  MODIFY `pb_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT cho bảng `thietbi`
--
ALTER TABLE `thietbi`
  MODIFY `thietbi_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD CONSTRAINT `FK__phongban` FOREIGN KEY (`pb_id`) REFERENCES `phongban` (`pb_id`);

--
-- Các ràng buộc cho bảng `thietbi`
--
ALTER TABLE `thietbi`
  ADD CONSTRAINT `fk_danhmuc` FOREIGN KEY (`danhmuc_thietbi_id`) REFERENCES `danhmuc_thietbi` (`danhmuc_thietbi_id`),
  ADD CONSTRAINT `fk_tinhtrang` FOREIGN KEY (`tinhtrang_id`) REFERENCES `tinhtrang` (`tinhtrang_id`);

--
-- Các ràng buộc cho bảng `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_user_nv` FOREIGN KEY (`nv_id`) REFERENCES `nhanvien` (`nv_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
