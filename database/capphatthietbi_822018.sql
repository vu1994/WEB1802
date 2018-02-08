-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th2 08, 2018 lúc 05:59 PM
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
(3, 'Bàn phím'),
(4, 'CAMERA DAHUA'),
(5, 'NVR DAHUA');

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
(6, 'Nguyễn Phi Vũ', '15 Hoàng Văn Thụ', 'npvu@gmail.com', '0978542565', 1, '1993-10-19', 1),
(7, 'Trần Hoàng Anh', '132 Đường 3/2', 'hoanganh@gmail.com', '0975842368', 1, '1995-11-09', 2),
(9, 'Nguyễn Vũ Hải Đăng', '33 Nguyễn Văn Cừ', 'nvhdang@gmail.com', '0978542565', 1, '1995-12-12', 1),
(11, 'Lữ Thanh Quy', '356 Trần Bình Trọng', 'ltquy@gmail.com', '0985421687', 1, '1990-08-13', 1),
(14, 'Phan Thị Bích Vân', '155 Đường 3/2', 'ptbvan@gmail.com', '0956885224', 0, '1989-12-12', 1),
(15, 'Nguyễn Dương', '85 Hoàng Văn Thụ', 'nduong@gmail.com', '0985468752', 1, '1994-05-22', 1),
(16, 'Lê Nguyễn Anh Khang', '100 Mậu Thân', 'lnakhang@gmail.com', '0985444555', 1, '1991-06-12', 1),
(17, 'Hà Thị Thái Bình', '25 Võ Văn Kiệt', 'httbinh@gmail.com', '0932885431', 0, '1991-05-15', 2),
(20, 'Nguyễn Thị Thúy Hằng', '33/85 Châu Văn Liêm', 'ntthang@gmail.com', '0966325412', 0, '1989-03-26', 3),
(21, 'Bùi Thanh Trúc', '25 Trần Phú', 'bttruc@gmail.com', '0985621456', 0, '1992-12-12', 4),
(24, 'Nhan Thị Huỳnh Như', '19/88 Nguyễn Văn Linh', 'nthnhu@gmail.com', '0985458752', 0, '1992-06-06', 5),
(26, 'Trần Thị Bảo Trân', '25 Lý Thường Kiệt', 'ttbtran@gmail.com', '0958745654', 0, '1986-12-01', 3),
(28, 'Lê Huỳnh Quốc Bảo', '256 Trần Phú', 'lhqbao@gmail.com', '0958466546', 1, '1988-12-12', 4),
(31, 'Nguyễn Thanh Nhàn', '12 Lê Lai', 'ntnhan@gmail.com', '0985456748', 1, '1993-12-04', 8),
(32, 'Trần Hoài Thương', '125 Lê Lợi', 'ththuong@gmail.com', '0985421561', 1, '1991-12-12', 8),
(33, 'Lê Quốc Phú', '77 Lê Duẩn', 'lqphu@gmail.com', '0958745456', 1, '1987-05-05', 8),
(34, 'Lê Thị Thùy Trang', '52 Lê Bình', 'ltttrang@gmail.com', '0985421754', 1, '1992-06-06', 4);

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
(4, 'ITO'),
(5, 'Kiểm định'),
(8, 'Kinh doanh');

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
(10, 'MITSUMI', 3, 4, '2018-01-01', '2018-02-08', 31, 0, 'Đã thu hồi', NULL),
(11, 'SAMSUNG', 2, 2, '2018-01-01', '2018-02-06', 0, 0, 'Cấp bổ sung', NULL),
(12, 'Dell ins 5559 i7 6500u/8g/1tb/vga r5 m335 4g/màn 15.6 HD ( dvd , cam,HDMI ,usb ) Hót hót', 2, 2, '2018-02-08', '2018-02-08', 2, 0, 'Cấp mới', NULL),
(13, 'Dell ins 5559 i5 6200u', 2, 2, '2018-02-08', '2018-02-08', 0, 0, 'Cấp mới', NULL),
(14, 'Dell ins 5559 i3 6100u', 2, 2, '2018-02-08', '2018-02-08', 1, 0, 'Cấp mới', NULL),
(15, 'Dell ins 5558 i5  5200u/4g/500g/vga rời 2g /màn 15.6 HD( dvd , cam,HDMI ,usb )', 1, 2, '2018-02-08', '2018-02-08', 7, 0, 'Cấp mới', NULL),
(16, 'Dell ins 3559 i5 6200u/4g/500g/vga r5 m315 2G/ màn 15.6 HD(  cam,HDMI ,usb )', 1, 2, '2018-02-08', '2018-02-08', 6, 0, 'Cấp mới', NULL),
(17, 'Dell vos 3559 i5 6200u/4g/500g/vga HD 620/ màn 15.6 HD (  cam,HDMI ,usb )', 1, 2, '2018-02-08', '2018-02-08', 9, 0, 'Cấp mới', NULL),
(18, 'Dell ins 3543 i7 5500U/8g/1tb/ vga Gt840M 2g/ màn 15.6 HD ( dvd , cam,HDMI ,usb )', 1, 2, '2018-02-08', '2018-02-08', 11, 0, 'Cấp mới', NULL),
(19, 'Dell ins 3542 i7 4510u/8g/1tb/vga Gt820m 2g/màn 15.6 HD ( dvd , cam,HDMI ,usb )', 1, 4, '2018-02-08', NULL, 0, 0, 'Đã thu hồi', '2018-02-08'),
(20, 'Dell ins 5548 i7 5500u/8g/1tb/vga r7 m265 2g/màn 15.6 HD (  cam,HDMI ,usb )', 1, 1, '2018-02-08', NULL, 0, 0, '', '2018-02-08'),
(21, 'Dell ins 5547 i7 4510u/8g/1tb/vga r7 m265 2g/màn 15.6 HD (  cam,HDMI ,usb )', 1, 4, '2018-02-08', NULL, 0, 0, 'Đã thu hồi', '2018-02-08'),
(22, 'Dell ins 5547 i5 4510u/4g/500g/vga r7 m260 2g/màn 15.6 HD (  cam,HDMI ,usb )', 1, 2, '2018-02-08', '2018-02-08', 1, 0, 'Cấp mới', NULL),
(23, 'Dell vos 5568 i5 7200u/4g/1tb/vga Gt940Mx 2G /màn 15.6 HD ( dvd , cam,HDMI ,usb )', 1, 1, '2018-02-08', NULL, 0, 0, '', '2018-02-08'),
(24, 'Dell vos 5568 i3 7100u/4g/500g/vga HD 620 /màn 15.6 HD ( dvd , cam,HDMI ,usb )', 1, 1, '2018-02-08', NULL, 0, 0, '', '2018-02-08'),
(25, 'Dell ins 3568 i5 7200U/4G/500g/vga ati r5 m420 2g/màn 15.6 HD ( dvd , cam,HDMI ,usb )', 1, 1, '2018-02-08', '2018-02-08', 0, 0, '', NULL),
(26, 'Dell ins 3567 i5 7200U/4G/500g/vga ati r5 m420 2g/màn 15.6 HD ( dvd , cam,HDMI ,usb )', 1, 1, '2018-02-08', '2018-02-08', 24, 0, '', NULL),
(27, 'Dell gaming 7567 Core i7-7700HQ, 8GB, SSD 256G, 15.6\" Full HD  (1920 x 1080), GTX 1050 Ti 4GB, Win10 ', 1, 2, '2018-02-08', '2018-02-08', 1, 0, 'Cấp mới', NULL),
(28, 'Dell gaming 7567 Core i5-7300HQ, 8GB, SSD 256G, 15.6\" Full HD  (1920 x 1080), GTX 1050 Ti 4GB, Win10 ', 1, 1, '2018-02-08', '2018-02-08', 0, 0, '', NULL),
(29, 'Dell gaming 7559 Core i7-6700HQ, 8GB, 1TB, 15.6\" 4K (3840 x 2160) CẢM ỨNG, GTX 960M 4GB, Win10 ', 1, 2, '2018-02-08', '2018-02-08', 26, 0, 'Cấp mới', NULL),
(30, 'Asus F555LF -XX168D -Core i7 5500U/ Ram 4GB/ HDD 1TB/VGA NVIDIA Geforce 930M 2GB/15.6 HD/ DVD / Pin 3Cell/ Free DOS', 1, 2, '2018-02-08', '2018-02-08', 28, 0, 'Cấp mới', NULL),
(31, 'Asus X541UV -XX143D -Core i5 6198U/ Ram 4GB/ HDD 500GB/VGA NVIDIA Geforce 920MX 2GB/15.6 HD/ DVD / Pin 3Cell/ Free DOS', 1, 2, '2018-02-08', '2018-02-08', 1, 0, 'Cấp mới', NULL),
(32, 'Asus A556UF -XX062D -Core i5 6200U/ Ram 4GB/ HDD 500GB/VGA NVIDIA Geforce 930M 2GB/15.6 HD/ DVD / Pin 3Cell/ Free DOS', 1, 2, '2018-02-08', '2018-02-08', 1, 0, 'Cấp mới', NULL),
(33, 'Asus TP500LB -CJ020H -Core i5 5200U/ Ram 4GB/ HDD 500GB + SSD 24G/VGA NVIDIA 940M 2GB/15.6 HD cảm ứng/ Pin 3Cell/ Win 10', 1, 2, '2018-02-08', '2018-02-08', 31, 0, 'Cấp mới', NULL),
(34, 'Asus TP550LA -CJ043H -Core i3 4030U/ Ram 4GB/ HDD 1TB/VGA HD/15.6 cảm ứng/ DVD / Pin 3Cell/ Win 10', 1, 2, '2018-02-08', '2018-02-08', 1, 0, 'Cấp mới', NULL),
(35, 'Asus F554LA-xx1567d - core i3 4005U/ Ram 4GB/ HDD 500G/VGA HD/15.6/ DVD / Pin 3Cell/ Free DOS', 1, 2, '2018-02-08', '2018-02-08', 1, 0, 'Cấp mới', NULL),
(36, 'Asus TP301UA -C4147T- Core i5 6200U/Ram 4GB/ HDD 500G/VGA HD/13.3 cảm ứng / Pin 3Cell/ Win 10', 1, 2, '2018-02-08', '2018-02-08', 32, 0, 'Cấp mới', NULL),
(37, 'ASUS E402SA-WX251D- Intel Celeron N3060- 14.0inch-500Gb HDD- ram 2Gb', 1, 2, '2018-02-08', '2018-02-08', 6, 0, 'Cấp mới', NULL),
(38, 'ASUS E402SA -WX134D- Intel Celeron N3060- 14.0inch-500Gb HDD- ram 4Gb', 1, 2, '2018-02-08', '2018-02-08', 33, 0, 'Cấp mới', NULL),
(39, 'ASUS E402SA -WX098D-Intel Celeron N3050- 14.0inch-500Gb HDD- ram 4Gb', 1, 2, '2018-02-08', '2018-02-08', 2, 0, 'Cấp mới', NULL),
(40, 'ASUS X403SA-WX235T- Intel Pentium N3700 14.0inch-500Gb HDD- ram 2Gb', 1, 2, '2018-02-08', '2018-02-08', 34, 0, 'Cấp mới', NULL),
(41, 'DS2130FIP', 4, 2, '2018-02-08', '2018-02-08', 0, 0, 'Cấp mới', NULL),
(42, 'DS2130DIP', 4, 2, '2018-02-08', '2018-02-08', 0, 0, 'Cấp mới', NULL),
(43, 'DS2230FIP', 4, 2, '2018-02-08', '2018-02-08', 0, 0, 'Cấp mới', NULL),
(44, 'DS2300DIP', 4, 2, '2018-02-08', '2018-02-08', 0, 0, 'Cấp mới', NULL),
(45, '\"IPC-HUM8101 (Ultra smart)\"', 4, 2, '2018-02-08', '2018-02-08', 0, 0, 'Cấp mới', NULL),
(46, 'IPC-HFW2100SP', 4, 2, '2018-02-08', '2018-02-08', 0, 0, 'Cấp mới', NULL),
(47, '\" IPC-HFW1020SP\"', 4, 2, '2018-02-08', '2018-02-08', 0, 0, 'Cấp mới', NULL),
(48, '\" IPC-HFW1120SP\"', 4, 2, '2018-02-08', '2018-02-08', 0, 0, 'Cấp mới', NULL),
(49, 'IPC-HDW1120SP', 4, 2, '2018-02-08', '2018-02-08', 0, 0, 'Cấp mới', NULL),
(50, 'IPC-HDBW1220EP-S', 5, 2, '2018-02-08', '2018-02-08', 1, 0, 'Cấp mới', NULL),
(51, 'IPC-HFW1220MP-AS-I2', 5, 2, '2018-02-08', '2018-02-08', 1, 0, 'Cấp mới', NULL),
(52, 'IPC-HFW1220MP-S-I2', 5, 4, '2018-02-08', NULL, 0, 0, 'Đã thu hồi', '2018-02-08'),
(53, 'IPC-HFW4220EP', 5, 1, '2018-02-08', '0000-00-00', 0, 0, '', NULL);

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
  `nv_id` int(11) NOT NULL,
  `user_role` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`user_id`, `user_screenname`, `user_password`, `nv_id`, `user_role`) VALUES
(1, 'thyen', '1234567', 1, 0),
(2, 'npvu', '1234567', 6, 1);

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
(3, 1, 1, '2018-02-07', 'Hư', 2),
(4, 1, 1, '2018-02-08', 'Hu hong', 1);

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
-- Chỉ mục cho bảng `yeucau_suachua`
--
ALTER TABLE `yeucau_suachua`
  ADD PRIMARY KEY (`yeucau_id`),
  ADD KEY `FK_yeucau_suachua_nhanvien` (`yeucau_nv_id`),
  ADD KEY `FK_yeucau_suachua_thietbi` (`yeucau_tb_id`),
  ADD KEY `FK_yeucau_suachua_yeucau_tinhtrang` (`yeucau_tinhtrangsc`);

--
-- Chỉ mục cho bảng `yeucau_tinhtrang`
--
ALTER TABLE `yeucau_tinhtrang`
  ADD PRIMARY KEY (`yeucau_tinhtrang_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `danhmuc_thietbi`
--
ALTER TABLE `danhmuc_thietbi`
  MODIFY `danhmuc_thietbi_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `nv_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT cho bảng `phongban`
--
ALTER TABLE `phongban`
  MODIFY `pb_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `thietbi`
--
ALTER TABLE `thietbi`
  MODIFY `thietbi_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `yeucau_suachua`
--
ALTER TABLE `yeucau_suachua`
  MODIFY `yeucau_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `yeucau_tinhtrang`
--
ALTER TABLE `yeucau_tinhtrang`
  MODIFY `yeucau_tinhtrang_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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

--
-- Các ràng buộc cho bảng `yeucau_suachua`
--
ALTER TABLE `yeucau_suachua`
  ADD CONSTRAINT `FK_yeucau_suachua_nhanvien` FOREIGN KEY (`yeucau_nv_id`) REFERENCES `nhanvien` (`nv_id`),
  ADD CONSTRAINT `FK_yeucau_suachua_thietbi` FOREIGN KEY (`yeucau_tb_id`) REFERENCES `thietbi` (`thietbi_id`),
  ADD CONSTRAINT `FK_yeucau_suachua_yeucau_tinhtrang` FOREIGN KEY (`yeucau_tinhtrangsc`) REFERENCES `yeucau_tinhtrang` (`yeucau_tinhtrang_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
