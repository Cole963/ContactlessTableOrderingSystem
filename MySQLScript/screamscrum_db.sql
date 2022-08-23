-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 27, 2022 at 06:59 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `screamscrum_db`
--
CREATE DATABASE IF NOT EXISTS `screamscrum_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `screamscrum_db`;

-- --------------------------------------------------------

--
-- Table structure for table `couponcode`
--

DROP TABLE IF EXISTS `couponcode`;
CREATE TABLE `couponcode` (
  `id` int(11) NOT NULL,
  `code` varchar(20) NOT NULL,
  `status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `couponcode`
--

INSERT INTO `couponcode` (`id`, `code`, `status`) VALUES
(1, 'code-AbC32Ab', 'active'),
(2, 'code-21Ab3Sb', 'active'),
(3, 'code-23Abb23', 'active'),
(4, 'code-123456', 'expired'),
(5, 'code-231b42', 'expired'),
(6, 'code-CaBcp4Tl', 'expired'),
(7, 'code-gM3TFVFp', 'expired'),
(8, 'code-4MXAAf5Q', 'active'),
(9, 'code-6lAsDJHqet', 'active'),
(10, 'code-7WhR4', 'active'),
(11, 'code-JyZP4', 'active'),
(12, 'code-RnY1Uya57i', 'expired'),
(13, 'code-B9q1u9j', 'expired'),
(14, 'code-iydYaWw', 'expired'),
(15, 'code-HXs6M', 'active'),
(16, 'code-4Qzex', 'active'),
(17, 'code-uqMhn', 'active'),
(18, 'code-Je1ND6', 'expired'),
(19, 'code-0MzXegE', 'expired'),
(20, 'code-y5jgkyPpL6', 'active'),
(21, 'code-AqUa15y', 'active'),
(22, 'code-X1y9I6', 'expired'),
(23, 'code-hpNI6pOES', 'expired'),
(24, 'code-sKoMaBX', 'active'),
(25, 'code-tQiMBm', 'expired'),
(26, 'code-u48Xd5W6Cb', 'expired'),
(27, 'code-tDqx74uyEE', 'active'),
(28, 'code-akwlAFhSDz', 'active'),
(29, 'code-C0DMQYC', 'active'),
(30, 'code-vfJ86vuUi', 'expired'),
(31, 'code-v3xpAw', 'expired'),
(32, 'code-yoZSygZ', 'expired'),
(33, 'code-cc7E33NGU', 'expired'),
(34, 'code-ZJrdNeL', 'expired'),
(35, 'code-iOoKdh', 'active'),
(36, 'code-8a4wqs', 'expired'),
(37, 'code-EJxyWkXuF', 'expired'),
(38, 'code-iz0Zjro', 'active'),
(39, 'code-dxuM8XgjE', 'active'),
(40, 'code-PL13o5dD', 'active'),
(41, 'code-z0cRwrFa', 'active'),
(42, 'code-K67Wb', 'active'),
(43, 'code-DA6p5g', 'active'),
(44, 'code-IfvEXKB', 'expired'),
(45, 'code-q2e5TB38g', 'expired'),
(46, 'code-9beHVVi5H8', 'active'),
(47, 'code-4xlDGcFE', 'expired'),
(48, 'code-rtmloUYfp', 'expired'),
(49, 'code-MBmTF', 'expired'),
(50, 'code-sMe0F', 'expired'),
(51, 'code-W55FT', 'expired'),
(52, 'code-K8MKPT', 'active'),
(53, 'code-nPaToRLH', 'active'),
(54, 'code-KLhzRjVA', 'active'),
(55, 'code-ETmSVLOCHK', 'expired'),
(56, 'code-39pXodMgd', 'expired'),
(57, 'code-yGNNwRuTr', 'active'),
(58, 'code-CKDQwd', 'active'),
(59, 'code-vH5aA', 'expired'),
(60, 'code-WhHZc', 'expired'),
(61, 'code-CrBl3VW7LD', 'active'),
(62, 'code-mgVKYTywVx', 'active'),
(63, 'code-RSGzLTRy', 'expired'),
(64, 'code-4Nja6', 'expired'),
(65, 'code-jTmK2A', 'active'),
(66, 'code-LlQbXYhs', 'active'),
(67, 'code-r3UdA3cdW', 'active'),
(68, 'code-Gp39N', 'active'),
(69, 'code-0JWwk5', 'active'),
(70, 'code-cqdtYE8', 'active'),
(71, 'code-PC6es6ufe', 'expired'),
(72, 'code-myHD3TpuD', 'active'),
(73, 'code-NhMr3qxXrB', 'active'),
(74, 'code-vDfT2mEjj', 'active'),
(75, 'code-R5Wrl', 'expired'),
(76, 'code-lJoMo5sx', 'active'),
(77, 'code-6Fk2q4M', 'active'),
(78, 'code-j1Tg0q', 'active'),
(79, 'code-9MKVQKg', 'expired'),
(80, 'code-QXtCR', 'expired'),
(81, 'code-eQehUvy5ji', 'active'),
(82, 'code-zC75Gew', 'expired'),
(83, 'code-n3xRaXiw', 'active'),
(84, 'code-CKRiCIpc1', 'expired'),
(85, 'code-sijxds', 'active'),
(86, 'code-muGsSmGuAS', 'active'),
(87, 'code-458lcv', 'expired'),
(88, 'code-0JklP', 'expired'),
(89, 'code-KAgiJJme', 'active'),
(90, 'code-OSrou', 'expired'),
(91, 'code-ZfA1nf3', 'active'),
(92, 'code-sFZ6yy0', 'expired'),
(93, 'code-p0Tbvzhuj', 'active'),
(94, 'code-b9n64h37', 'expired'),
(95, 'code-HJ6sZTJH', 'active'),
(96, 'code-vzuPo', 'expired'),
(97, 'code-7YoFYrvGd', 'expired'),
(98, 'code-978KUFi1dN', 'expired'),
(99, 'code-Ysr32gAW', 'active'),
(100, 'code-01Xcsqb', 'expired');

-- --------------------------------------------------------

--
-- Table structure for table `menuitem`
--

DROP TABLE IF EXISTS `menuitem`;
CREATE TABLE `menuitem` (
  `id` int(5) NOT NULL,
  `name` varchar(70) NOT NULL,
  `price` decimal(6,2) NOT NULL,
  `picture` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `menuitem`
--

INSERT INTO `menuitem` (`id`, `name`, `price`, `picture`) VALUES
(1, 'Fried Rice', '3.50', 'img/img1.jpg'),
(2, 'Curry Rice', '6.00', 'img/img2.jpg'),
(3, 'Chicken Meatball', '5.50', 'img/img3.jpg'),
(4, 'Chicken Rice', '4.40', 'img/img4.jpg'),
(5, 'Fried Noodle', '5.10', 'img/img5.jpg'),
(6, 'Half Chicken', '7.00', 'img/img6.jpg'),
(7, 'Nasi Lemak', '9.50', 'img/img7.jpg'),
(8, 'Salad', '3.00', 'img/img8.jpg'),
(9, 'Ramen', '6.00', 'img/img9.jpg'),
(10, 'Tom Yum', '5.50', 'img/img10.jpg'),
(11, 'Chicken Soup', '6.70', 'img/img11.jpg'),
(12, 'Spaghetti', '6.90', 'img/img12.jpg'),
(13, 'Mutton Meatball', '4.30', 'img/img13.jpg'),
(14, 'French Fries', '2.00', 'img/img14.jpg'),
(15, 'Nuggets (3pcs)', '3.00', 'img/img15.jpg'),
(16, 'Sausages (3pcs)', '4.80', 'img/img16.jpg'),
(17, 'Coffee', '2.50', 'img/drink1.jpg'),
(18, 'Tea', '2.50', 'img/drink2.jpg'),
(19, 'Cola', '2.00', 'img/drink3.jpg'),
(20, 'Sprite', '2.00', 'img/drink4.jpg'),
(21, 'Dummy Data', '3.50', 'img/img1.jpg'),
(22, 'Dummy Data', '6.00', 'img/img2.jpg'),
(23, 'Dummy Data', '5.50', 'img/img3.jpg'),
(24, 'Dummy Data', '4.40', 'img/img4.jpg'),
(25, 'Dummy Data', '5.10', 'img/img5.jpg'),
(26, 'Dummy Data', '7.00', 'img/img6.jpg'),
(27, 'Dummy Data', '9.50', 'img/img7.jpg'),
(28, 'Dummy Data', '3.00', 'img/img8.jpg'),
(29, 'Dummy Data', '6.00', 'img/img9.jpg'),
(30, 'Dummy Data', '5.50', 'img/img10.jpg'),
(31, 'Dummy Data', '6.70', 'img/img11.jpg'),
(32, 'Dummy Data', '6.90', 'img/img12.jpg'),
(33, 'Dummy Data', '4.30', 'img/img13.jpg'),
(34, 'Dummy Data', '2.00', 'img/img14.jpg'),
(35, 'Dummy Data', '3.00', 'img/img15.jpg'),
(36, 'Dummy Data', '4.80', 'img/img16.jpg'),
(37, 'Dummy Data', '2.50', 'img/drink1.jpg'),
(38, 'Dummy Data', '2.50', 'img/drink2.jpg'),
(39, 'Dummy Data', '2.00', 'img/drink3.jpg'),
(40, 'Dummy Data', '2.00', 'img/drink4.jpg'),
(41, 'Dummy Data', '3.50', 'img/img1.jpg'),
(42, 'Dummy Data', '6.00', 'img/img2.jpg'),
(43, 'Dummy Data', '5.50', 'img/img3.jpg'),
(44, 'Dummy Data', '4.40', 'img/img4.jpg'),
(45, 'Dummy Data', '5.10', 'img/img5.jpg'),
(46, 'Dummy Data', '7.00', 'img/img6.jpg'),
(47, 'Dummy Data', '9.50', 'img/img7.jpg'),
(48, 'Dummy Data', '3.00', 'img/img8.jpg'),
(49, 'Dummy Data', '6.00', 'img/img9.jpg'),
(50, 'Dummy Data', '5.50', 'img/img10.jpg'),
(51, 'Dummy Data', '6.70', 'img/img11.jpg'),
(52, 'Dummy Data', '6.90', 'img/img12.jpg'),
(53, 'Dummy Data', '4.30', 'img/img13.jpg'),
(54, 'Dummy Data', '2.00', 'img/img14.jpg'),
(55, 'Dummy Data', '3.00', 'img/img15.jpg'),
(56, 'Dummy Data', '4.80', 'img/img16.jpg'),
(57, 'Dummy Data', '2.50', 'img/drink1.jpg'),
(58, 'Dummy Data', '2.50', 'img/drink2.jpg'),
(59, 'Dummy Data', '2.00', 'img/drink3.jpg'),
(60, 'Dummy Data', '2.00', 'img/drink4.jpg'),
(61, 'Dummy Data', '3.50', 'img/img1.jpg'),
(62, 'Dummy Data', '6.00', 'img/img2.jpg'),
(63, 'Dummy Data', '5.50', 'img/img3.jpg'),
(64, 'Dummy Data', '4.40', 'img/img4.jpg'),
(65, 'Dummy Data', '5.10', 'img/img5.jpg'),
(66, 'Dummy Data', '7.00', 'img/img6.jpg'),
(67, 'Dummy Data', '9.50', 'img/img7.jpg'),
(68, 'Dummy Data', '3.00', 'img/img8.jpg'),
(69, 'Dummy Data', '6.00', 'img/img9.jpg'),
(70, 'Dummy Data', '5.50', 'img/img10.jpg'),
(71, 'Dummy Data', '6.70', 'img/img11.jpg'),
(72, 'Dummy Data', '6.90', 'img/img12.jpg'),
(73, 'Dummy Data', '4.30', 'img/img13.jpg'),
(74, 'Dummy Data', '2.00', 'img/img14.jpg'),
(75, 'Dummy Data', '3.00', 'img/img15.jpg'),
(76, 'Dummy Data', '4.80', 'img/img16.jpg'),
(77, 'Dummy Data', '2.50', 'img/drink1.jpg'),
(78, 'Dummy Data', '2.50', 'img/drink2.jpg'),
(79, 'Dummy Data', '2.00', 'img/drink3.jpg'),
(80, 'Dummy Data', '2.00', 'img/drink4.jpg'),
(81, 'Dummy Data', '3.50', 'img/img1.jpg'),
(82, 'Dummy Data', '6.00', 'img/img2.jpg'),
(83, 'Dummy Data', '5.50', 'img/img3.jpg'),
(84, 'Dummy Data', '4.40', 'img/img4.jpg'),
(85, 'Dummy Data', '5.10', 'img/img5.jpg'),
(86, 'Dummy Data', '7.00', 'img/img6.jpg'),
(87, 'Dummy Data', '9.50', 'img/img7.jpg'),
(88, 'Dummy Data', '3.00', 'img/img8.jpg'),
(89, 'Dummy Data', '6.00', 'img/img9.jpg'),
(90, 'Dummy Data', '5.50', 'img/img10.jpg'),
(91, 'Dummy Data', '6.70', 'img/img11.jpg'),
(92, 'Dummy Data', '6.90', 'img/img12.jpg'),
(93, 'Dummy Data', '4.30', 'img/img13.jpg'),
(94, 'Dummy Data', '2.00', 'img/img14.jpg'),
(95, 'Dummy Data', '3.00', 'img/img15.jpg'),
(96, 'Dummy Data', '4.80', 'img/img16.jpg'),
(97, 'Dummy Data', '2.50', 'img/drink1.jpg'),
(98, 'Dummy Data', '2.50', 'img/drink2.jpg'),
(99, 'Dummy Data', '2.00', 'img/drink3.jpg'),
(100, 'Dummy Data', '2.00', 'img/drink4.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `orderitem`
--

DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `oi_id` int(5) NOT NULL,
  `oi_name` varchar(70) NOT NULL,
  `oi_unitprice` decimal(6,2) NOT NULL,
  `oi_quantity` int(5) NOT NULL,
  `oi_subtotalprice` decimal(10,2) NOT NULL,
  `oi_orderid` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orderitem`
--

INSERT INTO `orderitem` (`oi_id`, `oi_name`, `oi_unitprice`, `oi_quantity`, `oi_subtotalprice`, `oi_orderid`) VALUES
(1, 'Curry Rice', '6.00', 1, '6.00', 1),
(2, 'Chicken Rice', '4.40', 4, '17.60', 1),
(3, 'Chicken Meatball', '5.50', 2, '11.00', 1),
(4, 'Fried Rice', '3.50', 4, '14.00', 1),
(5, 'Chicken Meatball', '5.50', 1, '5.50', 2),
(6, 'Salad', '3.00', 3, '9.00', 2),
(7, 'Chicken Meatball', '5.50', 1, '5.50', 3),
(8, 'Half Chicken', '7.00', 1, '7.00', 3),
(9, 'Chicken Rice', '4.40', 1, '4.40', 3),
(10, 'Salad', '3.00', 1, '3.00', 4),
(11, 'Tom Yum', '5.50', 1, '5.50', 4),
(12, 'Mutton Meatball', '4.30', 1, '4.30', 4),
(13, 'Chicken Meatball', '5.50', 1, '5.50', 5),
(14, 'Ramen', '6.00', 1, '6.00', 5),
(15, 'Fried Rice', '3.50', 2, '7.00', 5),
(16, 'Salad', '3.00', 1, '3.00', 6),
(17, 'French Fries', '2.00', 2, '4.00', 6),
(18, 'Cola', '2.00', 1, '2.00', 6),
(19, 'Ramen', '6.00', 2, '12.00', 7),
(20, 'Half Chicken', '7.00', 1, '7.00', 7),
(21, 'Sausages (3pcs)', '4.80', 1, '4.80', 8),
(22, 'Chicken Rice', '4.40', 1, '4.40', 8),
(23, 'Salad', '3.00', 1, '3.00', 8),
(24, 'Tom Yum', '5.50', 1, '5.50', 9),
(25, 'Spaghetti', '6.90', 2, '13.80', 9),
(26, 'French Fries', '2.00', 1, '2.00', 9),
(27, 'Sausages (3pcs)', '4.80', 3, '14.40', 10),
(28, 'Cola', '2.00', 2, '4.00', 10),
(29, 'Fried Rice', '3.50', 1, '3.50', 10),
(30, 'Spaghetti', '6.90', 1, '6.90', 11),
(31, 'French Fries', '2.00', 1, '2.00', 11),
(32, 'Chicken Meatball', '5.50', 1, '5.50', 11),
(33, 'Sausages (3pcs)', '4.80', 1, '4.80', 12),
(34, 'Cola', '2.00', 1, '2.00', 12),
(35, 'Fried Rice', '3.50', 1, '3.50', 12),
(36, 'Sprite', '2.00', 2, '4.00', 13),
(37, 'Chicken Rice', '4.40', 1, '4.40', 13),
(38, 'Chicken Meatball', '5.50', 1, '5.50', 13),
(39, 'Chicken Meatball', '5.50', 1, '5.50', 14),
(40, 'Nasi Lemak', '9.50', 1, '9.50', 15),
(41, 'Sausages (3pcs)', '4.80', 3, '14.40', 16),
(42, 'Cola', '2.00', 1, '2.00', 16),
(43, 'Curry Rice', '6.00', 1, '6.00', 16),
(44, 'Ramen', '6.00', 1, '6.00', 17),
(45, 'Sausages (3pcs)', '4.80', 1, '4.80', 17),
(46, 'Chicken Rice', '4.40', 1, '4.40', 17),
(47, 'Sausages (3pcs)', '4.80', 1, '4.80', 18),
(48, 'French Fries', '2.00', 1, '2.00', 18),
(49, 'Chicken Meatball', '5.50', 1, '5.50', 18),
(50, 'Fried Rice', '3.50', 1, '3.50', 19),
(51, 'Salad', '3.00', 1, '3.00', 19),
(52, 'Chicken Soup', '6.70', 1, '6.70', 19),
(53, 'Spaghetti', '6.90', 3, '20.70', 20),
(54, 'Sausages (3pcs)', '4.80', 1, '4.80', 20),
(55, 'Mutton Meatball', '4.30', 1, '4.30', 20),
(56, 'Chicken Rice', '4.40', 1, '4.40', 21),
(57, 'Curry Rice', '6.00', 1, '6.00', 21),
(58, 'Salad', '3.00', 1, '3.00', 22),
(59, 'French Fries', '2.00', 1, '2.00', 23),
(60, 'Sausages (3pcs)', '4.80', 1, '4.80', 23),
(61, 'Mutton Meatball', '4.30', 1, '4.30', 24),
(62, 'Sprite', '2.00', 1, '2.00', 24),
(63, 'Sprite', '2.00', 1, '2.00', 25),
(64, 'Fried Rice', '3.50', 1, '3.50', 25),
(65, 'Chicken Rice', '4.40', 2, '8.80', 26),
(66, 'Salad', '3.00', 3, '9.00', 26),
(67, 'Chicken Rice', '4.40', 3, '13.20', 27),
(68, 'Salad', '3.00', 1, '3.00', 27),
(69, 'Chicken Rice', '4.40', 2, '8.80', 28),
(70, 'Salad', '3.00', 3, '9.00', 28),
(71, 'Fried Rice', '3.50', 1, '3.50', 29),
(72, 'Fried Noodle', '5.10', 3, '15.30', 29),
(73, 'Spaghetti', '6.90', 1, '6.90', 30),
(74, 'Sausages (3pcs)', '4.80', 1, '4.80', 30),
(75, 'Tea', '2.50', 1, '2.50', 30),
(76, 'Coffee', '2.50', 1, '2.50', 31),
(77, 'Chicken Rice', '4.40', 1, '4.40', 32),
(78, 'Salad', '3.00', 1, '3.00', 32),
(79, 'Chicken Soup', '6.70', 1, '6.70', 32),
(80, 'Fried Noodle', '5.10', 1, '5.10', 33),
(81, 'Spaghetti', '6.90', 1, '6.90', 34),
(82, 'Chicken Rice', '4.40', 1, '4.40', 34),
(83, 'Fried Rice', '3.50', 1, '3.50', 34),
(84, 'Mutton Meatball', '4.30', 1, '4.30', 35),
(85, 'Half Chicken', '7.00', 1, '7.00', 35),
(86, 'Chicken Rice', '4.40', 1, '4.40', 36),
(87, 'Salad', '3.00', 1, '3.00', 36),
(88, 'Fried Noodle', '5.10', 1, '5.10', 37),
(89, 'Chicken Meatball', '5.50', 1, '5.50', 37),
(90, 'Curry Rice', '6.00', 1, '6.00', 38),
(91, 'Chicken Soup', '6.70', 1, '6.70', 38),
(92, 'Sausages (3pcs)', '4.80', 1, '4.80', 39),
(93, 'Chicken Rice', '4.40', 1, '4.40', 39),
(94, 'Fried Rice', '3.50', 1, '3.50', 40),
(95, 'Nasi Lemak', '9.50', 1, '9.50', 40),
(96, 'Nuggets (3pcs)', '3.00', 1, '3.00', 41),
(97, 'French Fries', '2.00', 1, '2.00', 41),
(98, 'Sausages (3pcs)', '4.80', 1, '4.80', 42),
(99, 'Sprite', '2.00', 1, '2.00', 42),
(100, 'Curry Rice', '6.00', 1, '6.00', 43),
(101, 'Chicken Rice', '4.40', 1, '4.40', 43),
(102, 'Mutton Meatball', '4.30', 1, '4.30', 44),
(103, 'Salad', '3.00', 1, '3.00', 44),
(104, 'Tea', '2.50', 1, '2.50', 45),
(105, 'Chicken Meatball', '5.50', 1, '5.50', 45),
(106, 'Fried Noodle', '5.10', 1, '5.10', 45),
(107, 'Spaghetti', '6.90', 1, '6.90', 46),
(108, 'Chicken Rice', '4.40', 1, '4.40', 46),
(109, 'Curry Rice', '6.00', 1, '6.00', 46),
(110, 'Sausages (3pcs)', '4.80', 1, '4.80', 47),
(111, 'Chicken Rice', '4.40', 1, '4.40', 47),
(112, 'Curry Rice', '6.00', 1, '6.00', 47),
(113, 'Chicken Soup', '6.70', 1, '6.70', 48),
(114, 'Chicken Rice', '4.40', 1, '4.40', 48),
(115, 'Fried Rice', '3.50', 1, '3.50', 48),
(116, 'Spaghetti', '6.90', 1, '6.90', 49),
(117, 'Chicken Meatball', '5.50', 2, '11.00', 49),
(118, 'Nasi Lemak', '9.50', 1, '9.50', 49),
(119, 'Spaghetti', '6.90', 1, '6.90', 50),
(120, 'Chicken Meatball', '5.50', 1, '5.50', 50),
(121, 'Fried Rice', '3.50', 1, '3.50', 50),
(122, 'Chicken Rice', '4.40', 1, '4.40', 51),
(123, 'Spaghetti', '6.90', 1, '6.90', 51),
(124, 'Half Chicken', '7.00', 1, '7.00', 51),
(125, 'Spaghetti', '6.90', 1, '6.90', 52),
(126, 'Half Chicken', '7.00', 1, '7.00', 52),
(127, 'Chicken Rice', '4.40', 1, '4.40', 53),
(128, 'Chicken Meatball', '5.50', 1, '5.50', 53),
(129, 'Sausages (3pcs)', '4.80', 1, '4.80', 54),
(130, 'French Fries', '2.00', 1, '2.00', 54),
(131, 'Fried Rice', '3.50', 1, '3.50', 55),
(132, 'Ramen', '6.00', 1, '6.00', 55),
(133, 'Tea', '2.50', 1, '2.50', 56),
(134, 'Chicken Meatball', '5.50', 1, '5.50', 56),
(135, 'Chicken Rice', '4.40', 1, '4.40', 57),
(136, 'Salad', '3.00', 1, '3.00', 57),
(137, 'Tom Yum', '5.50', 1, '5.50', 58),
(138, 'Curry Rice', '6.00', 1, '6.00', 58),
(139, 'Chicken Meatball', '5.50', 1, '5.50', 59),
(140, 'Salad', '3.00', 1, '3.00', 59),
(141, 'Mutton Meatball', '4.30', 1, '4.30', 60),
(142, 'Cola', '2.00', 1, '2.00', 60),
(143, 'Fried Rice', '3.50', 1, '3.50', 61),
(144, 'Salad', '3.00', 1, '3.00', 61),
(145, 'Chicken Soup', '6.70', 1, '6.70', 62),
(146, 'Sausages (3pcs)', '4.80', 1, '4.80', 63),
(147, 'Chicken Rice', '4.40', 1, '4.40', 63),
(148, 'French Fries', '2.00', 1, '2.00', 64),
(149, 'Chicken Meatball', '5.50', 1, '5.50', 64),
(150, 'Ramen', '6.00', 1, '6.00', 65),
(151, 'Nasi Lemak', '9.50', 1, '9.50', 65),
(152, 'Spaghetti', '6.90', 3, '20.70', 66),
(153, 'Fried Rice', '3.50', 2, '7.00', 66),
(154, 'Dummy Data', '3.50', 1, '3.50', 67),
(155, 'Chicken Meatball', '5.50', 1, '5.50', 67),
(156, 'Spaghetti', '6.90', 1, '6.90', 68),
(157, 'Chicken Soup', '6.70', 1, '6.70', 68),
(158, 'Sausages (3pcs)', '4.80', 1, '4.80', 69),
(159, 'Chicken Rice', '4.40', 1, '4.40', 69),
(160, 'French Fries', '2.00', 1, '2.00', 70),
(161, 'Curry Rice', '6.00', 1, '6.00', 70),
(162, 'Chicken Rice', '4.40', 1, '4.40', 71),
(163, 'Nasi Lemak', '9.50', 1, '9.50', 71),
(164, 'Chicken Rice', '4.40', 1, '4.40', 72),
(165, 'Half Chicken', '7.00', 1, '7.00', 72),
(166, 'Salad', '3.00', 1, '3.00', 73),
(167, 'Curry Rice', '6.00', 1, '6.00', 73),
(168, 'Chicken Meatball', '5.50', 1, '5.50', 74),
(169, 'Nasi Lemak', '9.50', 1, '9.50', 74),
(170, 'Sausages (3pcs)', '4.80', 1, '4.80', 75),
(171, 'Mutton Meatball', '4.30', 1, '4.30', 75),
(172, 'Spaghetti', '6.90', 1, '6.90', 76),
(173, 'Curry Rice', '6.00', 1, '6.00', 76),
(174, 'Chicken Meatball', '5.50', 1, '5.50', 77),
(175, 'Ramen', '6.00', 1, '6.00', 77),
(176, 'Sausages (3pcs)', '4.80', 1, '4.80', 78),
(177, 'Chicken Meatball', '5.50', 1, '5.50', 78),
(178, 'Spaghetti', '6.90', 1, '6.90', 79),
(179, 'Ramen', '6.00', 1, '6.00', 79),
(180, 'Spaghetti', '6.90', 1, '6.90', 80),
(181, 'Chicken Meatball', '5.50', 1, '5.50', 80),
(182, 'Curry Rice', '6.00', 1, '6.00', 81),
(183, 'Salad', '3.00', 1, '3.00', 81),
(184, 'Chicken Meatball', '5.50', 1, '5.50', 82),
(185, 'Tom Yum', '5.50', 1, '5.50', 82),
(186, 'Sausages (3pcs)', '4.80', 1, '4.80', 83),
(187, 'Fried Rice', '3.50', 1, '3.50', 84),
(188, 'Ramen', '6.00', 1, '6.00', 84),
(189, 'Chicken Rice', '4.40', 1, '4.40', 85),
(190, 'Spaghetti', '6.90', 1, '6.90', 85),
(191, 'French Fries', '2.00', 1, '2.00', 86),
(192, 'Curry Rice', '6.00', 1, '6.00', 86),
(193, 'Ramen', '6.00', 1, '6.00', 87),
(194, 'Chicken Meatball', '5.50', 1, '5.50', 87),
(195, 'Sausages (3pcs)', '4.80', 1, '4.80', 88),
(196, 'Nasi Lemak', '9.50', 1, '9.50', 88),
(197, 'French Fries', '2.00', 3, '6.00', 89),
(198, 'Chicken Meatball', '5.50', 1, '5.50', 89),
(199, 'Salad', '3.00', 2, '6.00', 90),
(200, 'Fried Noodle', '5.10', 2, '10.20', 90),
(201, 'Nuggets (3pcs)', '3.00', 2, '6.00', 91),
(202, 'Fried Rice', '3.50', 1, '3.50', 91),
(203, 'Sausages (3pcs)', '4.80', 1, '4.80', 92),
(204, 'Mutton Meatball', '4.30', 3, '12.90', 92),
(205, 'Chicken Meatball', '5.50', 1, '5.50', 93),
(206, 'Salad', '3.00', 1, '3.00', 93),
(207, 'Curry Rice', '6.00', 1, '6.00', 94),
(208, 'Tom Yum', '5.50', 1, '5.50', 95),
(209, 'Ramen', '6.00', 1, '6.00', 95),
(210, 'Chicken Meatball', '5.50', 1, '5.50', 95),
(211, 'Cola', '2.00', 1, '2.00', 96),
(212, 'French Fries', '2.00', 1, '2.00', 96),
(213, 'Chicken Meatball', '5.50', 1, '5.50', 96),
(214, 'Chicken Rice', '4.40', 1, '4.40', 97),
(215, 'Salad', '3.00', 1, '3.00', 97),
(216, 'Fried Noodle', '5.10', 1, '5.10', 97),
(217, 'Chicken Soup', '6.70', 1, '6.70', 98),
(218, 'Curry Rice', '6.00', 1, '6.00', 98),
(219, 'Salad', '3.00', 1, '3.00', 98),
(220, 'Coffee', '2.50', 1, '2.50', 99),
(221, 'Curry Rice', '6.00', 1, '6.00', 99),
(222, 'Chicken Rice', '4.40', 1, '4.40', 99),
(223, 'Chicken Rice', '4.40', 1, '4.40', 100),
(224, 'Salad', '3.00', 1, '3.00', 100),
(225, 'Tom Yum', '5.50', 1, '5.50', 100);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `o_id` int(5) NOT NULL,
  `o_timestamp` varchar(45) NOT NULL,
  `o_mobilenum` int(20) NOT NULL,
  `o_totalprice` decimal(10,2) NOT NULL,
  `o_status` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`o_id`, `o_timestamp`, `o_mobilenum`, `o_totalprice`, `o_status`) VALUES
(1, '2022-05-12 at 16:42:32', 12345678, '48.60', 'preparing'),
(2, '2022-05-23 at 21:23:45', 4877452, '14.50', 'preparing'),
(3, '2022-05-24 at 17:36:19', 27961380, '16.90', 'preparing'),
(4, '2022-05-24 at 17:36:43', 49203979, '12.80', 'preparing'),
(5, '2022-05-24 at 17:37:03', 30900405, '18.50', 'preparing'),
(6, '2022-05-24 at 17:37:20', 82332981, '9.00', 'preparing'),
(7, '2022-05-24 at 17:37:38', 9119409, '19.00', 'preparing'),
(8, '2022-05-24 at 17:37:59', 97841395, '12.20', 'preparing'),
(9, '2022-05-24 at 17:38:33', 70499987, '21.30', 'preparing'),
(10, '2022-05-24 at 17:38:50', 26529173, '21.90', 'preparing'),
(11, '2022-05-24 at 17:39:03', 99583870, '14.40', 'preparing'),
(12, '2022-05-24 at 17:39:17', 43201007, '10.30', 'preparing'),
(13, '2022-05-24 at 17:39:36', 77241499, '13.90', 'preparing'),
(14, '2022-05-24 at 17:39:45', 65558664, '5.50', 'preparing'),
(15, '2022-05-24 at 17:40:00', 60649389, '9.50', 'preparing'),
(16, '2022-05-24 at 17:40:21', 91496409, '22.40', 'preparing'),
(17, '2022-05-24 at 17:40:33', 24037205, '15.20', 'preparing'),
(18, '2022-05-24 at 17:40:58', 49815844, '12.30', 'preparing'),
(19, '2022-05-24 at 17:41:11', 81144095, '13.20', 'preparing'),
(20, '2022-05-22 at 17:41:29', 74687566, '29.80', 'completed'),
(21, '2022-05-22 at 17:42:22', 37734085, '10.40', 'completed'),
(22, '2022-05-22 at 17:42:30', 50796289, '3.00', 'completed'),
(23, '2022-05-22 at 17:42:50', 25407000, '6.80', 'completed'),
(24, '2022-05-22 at 17:43:02', 82096825, '6.30', 'completed'),
(25, '2022-05-23 at 17:43:14', 99124397, '5.50', 'completed'),
(26, '2022-05-23 at 17:44:00', 63860208, '17.80', 'completed'),
(27, '2022-05-21 at 17:52:40', 98070205, '16.20', 'completed'),
(28, '2022-05-20 at 17:52:58', 10036785, '17.80', 'completed'),
(29, '2022-05-21 at 17:55:06', 82943708, '18.80', 'completed'),
(30, '2022-05-22 at 17:55:41', 16915181, '14.20', 'completed'),
(31, '2022-05-23 at 17:55:53', 64269934, '2.50', 'completed'),
(32, '2022-04-21 at 17:56:03', 68382602, '14.10', 'completed'),
(33, '2022-02-22 at 17:56:08', 12413567, '5.10', 'completed'),
(34, '2022-01-21 at 17:56:16', 98962691, '14.80', 'completed'),
(35, '2021-12-22 at 17:56:37', 82433678, '11.30', 'completed'),
(36, '2022-03-24 at 17:56:43', 36199659, '7.40', 'completed'),
(37, '2022-01-24 at 17:56:49', 105303512, '10.60', 'completed'),
(38, '2022-02-12 at 17:56:57', 30605454, '12.70', 'completed'),
(39, '2022-05-21 at 17:57:03', 12218505, '9.20', 'completed'),
(40, '2022-05-23 at 17:57:10', 20543156, '13.00', 'completed'),
(41, '2022-04-15 at 17:57:19', 35519139, '5.00', 'completed'),
(42, '2022-02-12 at 17:57:26', 21015480, '6.80', 'completed'),
(43, '2022-02-12 at 17:57:33', 85880841, '10.40', 'completed'),
(44, '2022-05-24 at 17:57:42', 52970835, '7.30', 'preparing'),
(45, '2022-05-24 at 17:57:51', 109113031, '13.10', 'preparing'),
(46, '2022-05-24 at 17:57:58', 38399592, '17.30', 'preparing'),
(47, '2022-05-24 at 17:58:08', 56682549, '15.20', 'completed'),
(48, '2022-05-24 at 17:58:15', 90019863, '14.60', 'preparing'),
(49, '2022-05-24 at 17:58:23', 95450121, '27.40', 'completed'),
(50, '2022-05-24 at 17:58:37', 60476880, '15.90', 'preparing'),
(51, '2022-05-24 at 17:58:53', 60633093, '18.30', 'preparing'),
(52, '2022-05-24 at 17:59:00', 81828140, '13.90', 'completed'),
(53, '2022-05-24 at 17:59:06', 49619889, '9.90', 'preparing'),
(54, '2022-05-24 at 17:59:14', 41076334, '6.80', 'preparing'),
(55, '2022-05-24 at 17:59:21', 58872308, '9.50', 'preparing'),
(56, '2022-05-24 at 17:59:31', 95262874, '8.00', 'completed'),
(57, '2022-05-24 at 17:59:37', 92212756, '7.40', 'preparing'),
(58, '2022-05-24 at 17:59:42', 92245334, '11.50', 'preparing'),
(59, '2022-05-24 at 17:59:48', 109661262, '8.50', 'completed'),
(60, '2022-05-24 at 17:59:56', 29999671, '6.30', 'preparing'),
(61, '2022-05-24 at 18:00:06', 11557601, '6.50', 'completed'),
(62, '2022-05-24 at 18:00:23', 52762487, '6.70', 'preparing'),
(63, '2022-05-24 at 18:00:30', 53090037, '9.20', 'preparing'),
(64, '2022-05-24 at 18:00:36', 28794460, '7.50', 'completed'),
(65, '2022-05-24 at 18:00:43', 51030230, '15.50', 'preparing'),
(66, '2022-05-24 at 18:00:57', 58120958, '27.70', 'completed'),
(67, '2022-05-24 at 18:01:05', 62234451, '9.00', 'preparing'),
(68, '2022-05-24 at 18:01:13', 106145257, '13.60', 'completed'),
(69, '2022-05-24 at 18:01:19', 65307623, '9.20', 'preparing'),
(70, '2022-05-24 at 18:01:27', 74714301, '8.00', 'completed'),
(71, '2022-05-24 at 18:01:34', 89972144, '13.90', 'preparing'),
(72, '2022-05-24 at 18:01:42', 82434406, '11.40', 'preparing'),
(73, '2022-05-24 at 18:01:48', 105548098, '9.00', 'completed'),
(74, '2022-05-24 at 18:01:56', 20702040, '15.00', 'completed'),
(75, '2022-05-24 at 18:02:04', 86257948, '9.10', 'completed'),
(76, '2022-05-24 at 18:02:15', 84964103, '12.90', 'completed'),
(77, '2022-05-24 at 18:02:25', 27779913, '11.50', 'completed'),
(78, '2022-05-24 at 18:02:32', 56123968, '10.30', 'completed'),
(79, '2022-05-24 at 18:02:40', 12449270, '12.90', 'completed'),
(80, '2022-05-24 at 18:02:47', 96925346, '12.40', 'completed'),
(81, '2022-05-24 at 18:02:54', 27089763, '9.00', 'completed'),
(82, '2022-05-24 at 18:03:01', 92826208, '11.00', 'completed'),
(83, '2022-05-24 at 18:03:07', 106959302, '4.80', 'completed'),
(84, '2022-05-24 at 18:03:19', 26901156, '9.50', 'completed'),
(85, '2022-05-24 at 18:03:26', 79173481, '11.30', 'completed'),
(86, '2022-05-24 at 18:03:33', 34508617, '8.00', 'completed'),
(87, '2022-05-24 at 18:03:41', 42436037, '11.50', 'completed'),
(88, '2022-05-24 at 18:03:48', 86944199, '14.30', 'completed'),
(89, '2022-05-24 at 18:03:59', 41486496, '11.50', 'completed'),
(90, '2022-05-24 at 18:04:14', 39635925, '16.20', 'completed'),
(91, '2022-05-24 at 18:04:24', 85510395, '9.50', 'completed'),
(92, '2022-05-24 at 18:04:34', 51752653, '17.70', 'completed'),
(93, '2022-05-24 at 18:04:42', 43867129, '8.50', 'completed'),
(94, '2022-05-24 at 18:04:46', 41151488, '6.00', 'completed'),
(95, '2022-05-24 at 18:04:55', 21684721, '17.00', 'completed'),
(96, '2022-05-24 at 18:05:06', 20293835, '9.50', 'completed'),
(97, '2022-05-24 at 18:05:17', 64845070, '12.50', 'completed'),
(98, '2022-05-24 at 18:05:26', 65597604, '15.70', 'completed'),
(99, '2022-05-24 at 18:05:42', 54240330, '12.90', 'completed'),
(100, '2022-05-24 at 18:05:57', 99584012, '12.90', 'completed');

-- --------------------------------------------------------

--
-- Table structure for table `useraccount`
--

DROP TABLE IF EXISTS `useraccount`;
CREATE TABLE `useraccount` (
  `id` int(5) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `name` varchar(70) NOT NULL,
  `email` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `userprofile` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `useraccount`
--

INSERT INTO `useraccount` (`id`, `username`, `password`, `name`, `email`, `status`, `userprofile`) VALUES
(1, 'admin', 'admin', 'admin', 'admin@yahoo.com', 'active', 1),
(2, 'manager', 'manager', 'manager', 'manager@yahoo.com', 'active', 2),
(3, 'staff', 'staff', 'staff', 'staff@yahoo.com', 'active', 3),
(4, 'owner', 'owner', 'owner', 'owner@yahoo.com', 'active', 4),
(5, 'colemann', 'Colemann', 'Gee Wei Shaun Colemann', 'colemann@gmail.com', 'active', 1),
(6, 'ekki', 'ekki', 'Ekki Gunawan', 'ekkigunawan@rocketmail.com', 'active', 2),
(7, 'theodore', 'theodore', 'Wee Tee Hian Theodore James', 'theodore@gmail.com', 'active', 3),
(8, 'zhizhong', 'zhizhong', 'Tan Zhi Zhong', 'zhizhong@yahoo.com', 'active', 4),
(9, 'jolene', 'jolene', 'Jolene Tan', 'jolene@yahoo.com', 'active', 1),
(10, 'sokmun', 'sokmun', 'Tang Sok Mun', 'tangsokmun@yahoo.com', 'active', 2),
(11, 'yongyi', 'yongyi', 'Ho yong yi', 'hoyongyi@yahoo.com', 'active', 3),
(12, 'terrance', 'terrance', 'Terrance', 'terrance@yahoo.com', 'active', 4),
(13, 'dummy', 'dummy', 'dummy', 'dummy@yahoo.com', 'active', 1),
(14, 'dummy1', 'dummy1', 'dummy1', 'dummy1@yahoo.com', 'active', 2),
(15, 'dummy2', 'dummy2', 'dummy2', 'dummy2@yahoo.com', 'active', 3),
(16, 'dummy3', 'dummy3', 'dummy3', 'dummy3@yahoo.com', 'active', 4),
(17, 'dummy4', 'dummy4', 'dummy4', 'dummy4@yahoo.com', 'active', 1),
(18, 'dummy5', 'dummy5', 'dummy5', 'dummy5@yahoo.com', 'active', 2),
(19, 'dummy6', 'dummy6', 'dummy6', 'dummy6@yahoo.com', 'active', 3),
(20, 'dummy7', 'dummy7', 'dummy7', 'dummy7@yahoo.com', 'active', 4),
(21, 'dummy8', 'dummy8', 'dummy8', 'dummy8@yahoo.com', 'active', 1),
(22, 'dummy9', 'dummy9', 'dummy9', 'dummy9@yahoo.com', 'active', 2),
(23, 'dummy10', 'dummy10', 'dummy10', 'dummy10@yahoo.com', 'active', 3),
(24, 'dummy11', 'dummy11', 'dummy11', 'dummy11@yahoo.com', 'active', 4),
(25, 'dummy12', 'dummy12', 'dummy12', 'dummy12@yahoo.com', 'active', 1),
(26, 'dummy13', 'dummy13', 'dummy13', 'dummy13@yahoo.com', 'active', 2),
(27, 'dummy14', 'dummy14', 'dummy14', 'dummy14@yahoo.com', 'active', 3),
(28, 'dummy15', 'dummy15', 'dummy15', 'dummy15@yahoo.com', 'active', 4),
(29, 'dummy16', 'dummy16', 'dummy16', 'dummy16@yahoo.com', 'active', 1),
(30, 'dummy17', 'dummy17', 'dummy17', 'dummy17@yahoo.com', 'active', 2),
(31, 'dummy18', 'dummy18', 'dummy18', 'dummy18@yahoo.com', 'active', 3),
(32, 'dummy19', 'dummy19', 'dummy19', 'dummy19@yahoo.com', 'active', 4),
(33, 'dummy20', 'dummy20', 'dummy20', 'dummy20@yahoo.com', 'active', 1),
(34, 'dummy21', 'dummy21', 'dummy21', 'dummy21@yahoo.com', 'active', 2),
(35, 'dummy22', 'dummy22', 'dummy22', 'dummy22@yahoo.com', 'active', 3),
(36, 'dummy23', 'dummy23', 'dummy23', 'dummy23@yahoo.com', 'active', 4),
(37, 'dummy24', 'dummy24', 'dummy24', 'dummy24@yahoo.com', 'active', 1),
(38, 'dummy25', 'dummy25', 'dummy25', 'dummy25@yahoo.com', 'active', 2),
(39, 'dummy26', 'dummy26', 'dummy26', 'dummy26@yahoo.com', 'active', 3),
(40, 'dummy27', 'dummy27', 'dummy27', 'dummy27@yahoo.com', 'active', 4),
(41, 'dummy28', 'dummy28', 'dummy28', 'dummy28@yahoo.com', 'active', 1),
(42, 'dummy29', 'dummy29', 'dummy29', 'dummy29@yahoo.com', 'active', 2),
(43, 'dummy30', 'dummy30', 'dummy30', 'dummy30@yahoo.com', 'active', 3),
(44, 'dummy31', 'dummy31', 'dummy31', 'dummy31@yahoo.com', 'active', 4),
(45, 'dummy32', 'dummy32', 'dummy32', 'dummy32@yahoo.com', 'active', 1),
(46, 'dummy33', 'dummy33', 'dummy33', 'dummy33@yahoo.com', 'active', 2),
(47, 'dummy34', 'dummy34', 'dummy34', 'dummy34@yahoo.com', 'active', 3),
(48, 'dummy35', 'dummy35', 'dummy35', 'dummy35@yahoo.com', 'active', 4),
(49, 'dummy36', 'dummy36', 'dummy36', 'dummy36@yahoo.com', 'active', 1),
(50, 'dummy37', 'dummy37', 'dummy37', 'dummy37@yahoo.com', 'active', 2),
(51, 'dummy38', 'dummy38', 'dummy38', 'dummy38@yahoo.com', 'active', 3),
(52, 'dummy39', 'dummy39', 'dummy39', 'dummy39@yahoo.com', 'active', 4),
(53, 'dummy40', 'dummy40', 'dummy40', 'dummy40@yahoo.com', 'active', 1),
(54, 'dummy41', 'dummy41', 'dummy41', 'dummy41@yahoo.com', 'active', 2),
(55, 'dummy42', 'dummy42', 'dummy42', 'dummy42@yahoo.com', 'active', 3),
(56, 'dummy43', 'dummy43', 'dummy43', 'dummy43@yahoo.com', 'active', 4),
(57, 'dummy44', 'dummy44', 'dummy44', 'dummy44@yahoo.com', 'active', 1),
(58, 'dummy45', 'dummy45', 'dummy45', 'dummy45@yahoo.com', 'active', 2),
(59, 'dummy46', 'dummy46', 'dummy46', 'dummy46@yahoo.com', 'active', 3),
(60, 'dummy47', 'dummy47', 'dummy47', 'dummy47@yahoo.com', 'active', 4),
(61, 'dummy48', 'dummy48', 'dummy48', 'dummy48@yahoo.com', 'active', 1),
(62, 'dummy49', 'dummy49', 'dummy49', 'dummy49@yahoo.com', 'active', 2),
(63, 'dummy50', 'dummy50', 'dummy50', 'dummy50@yahoo.com', 'active', 3),
(64, 'dummy51', 'dummy51', 'dummy51', 'dummy51@yahoo.com', 'active', 4),
(65, 'dummy52', 'dummy52', 'dummy52', 'dummy52@yahoo.com', 'active', 1),
(66, 'dummy53', 'dummy53', 'dummy53', 'dummy53@yahoo.com', 'active', 2),
(67, 'dummy54', 'dummy54', 'dummy54', 'dummy54@yahoo.com', 'active', 3),
(68, 'dummy55', 'dummy55', 'dummy55', 'dummy55@yahoo.com', 'active', 4),
(69, 'dummy56', 'dummy56', 'dummy56', 'dummy56@yahoo.com', 'active', 1),
(70, 'dummy57', 'dummy57', 'dummy57', 'dummy57@yahoo.com', 'active', 2),
(71, 'dummy58', 'dummy58', 'dummy58', 'dummy58@yahoo.com', 'active', 3),
(72, 'dummy59', 'dummy59', 'dummy59', 'dummy59@yahoo.com', 'active', 4),
(73, 'dummy60', 'dummy60', 'dummy60', 'dummy60@yahoo.com', 'active', 1),
(74, 'dummy61', 'dummy61', 'dummy61', 'dummy61@yahoo.com', 'active', 2),
(75, 'dummy62', 'dummy62', 'dummy62', 'dummy62@yahoo.com', 'active', 3),
(76, 'dummy63', 'dummy63', 'dummy63', 'dummy63@yahoo.com', 'active', 4),
(77, 'dummy64', 'dummy64', 'dummy64', 'dummy64@yahoo.com', 'active', 1),
(78, 'dummy65', 'dummy65', 'dummy65', 'dummy65@yahoo.com', 'active', 2),
(79, 'dummy66', 'dummy66', 'dummy66', 'dummy66@yahoo.com', 'active', 3),
(80, 'dummy67', 'dummy67', 'dummy67', 'dummy67@yahoo.com', 'active', 4),
(81, 'dummy68', 'dummy68', 'dummy68', 'dummy68@yahoo.com', 'active', 1),
(82, 'dummy69', 'dummy69', 'dummy69', 'dummy69@yahoo.com', 'active', 2),
(83, 'dummy70', 'dummy70', 'dummy70', 'dummy70@yahoo.com', 'active', 3),
(84, 'dummy71', 'dummy71', 'dummy71', 'dummy71@yahoo.com', 'active', 4),
(85, 'dummy72', 'dummy72', 'dummy72', 'dummy72@yahoo.com', 'active', 1),
(86, 'dummy73', 'dummy73', 'dummy73', 'dummy73@yahoo.com', 'active', 2),
(87, 'dummy74', 'dummy74', 'dummy74', 'dummy74@yahoo.com', 'active', 3),
(88, 'dummy75', 'dummy75', 'dummy75', 'dummy75@yahoo.com', 'active', 4),
(89, 'dummy76', 'dummy76', 'dummy76', 'dummy76@yahoo.com', 'active', 1),
(90, 'dummy77', 'dummy77', 'dummy77', 'dummy77@yahoo.com', 'active', 2),
(91, 'dummy78', 'dummy78', 'dummy78', 'dummy78@yahoo.com', 'active', 3),
(92, 'dummy79', 'dummy79', 'dummy79', 'dummy79@yahoo.com', 'active', 4),
(93, 'dummy80', 'dummy80', 'dummy80', 'dummy80@yahoo.com', 'active', 1),
(94, 'dummy81', 'dummy81', 'dummy81', 'dummy81@yahoo.com', 'active', 2),
(95, 'dummy82', 'dummy82', 'dummy82', 'dummy82@yahoo.com', 'active', 3),
(96, 'dummy83', 'dummy83', 'dummy83', 'dummy83@yahoo.com', 'active', 4),
(97, 'dummy84', 'dummy84', 'dummy84', 'dummy84@yahoo.com', 'active', 1),
(98, 'dummy85', 'dummy85', 'dummy85', 'dummy85@yahoo.com', 'active', 2),
(99, 'dummy86', 'dummy86', 'dummy86', 'dummy86@yahoo.com', 'active', 3),
(100, 'dummy87', 'dummy87', 'dummy87', 'dummy87@yahoo.com', 'active', 4);

-- --------------------------------------------------------

--
-- Table structure for table `userprofile`
--

DROP TABLE IF EXISTS `userprofile`;
CREATE TABLE `userprofile` (
  `id` int(5) NOT NULL,
  `profile` varchar(70) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `description` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `userprofile`
--

INSERT INTO `userprofile` (`id`, `profile`, `description`) VALUES
(1, 'User Admin', 'Manager user accounts and profiles'),
(2, 'Restaurant Manager', 'Manage menu items'),
(3, 'Restaurant Staff', 'Manage orders'),
(4, 'Restaurant Owner', 'Generate reports'),
(5, 'Default User', 'View menu items');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `couponcode`
--
ALTER TABLE `couponcode`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `menuitem`
--
ALTER TABLE `menuitem`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orderitem`
--
ALTER TABLE `orderitem`
  ADD PRIMARY KEY (`oi_id`),
  ADD KEY `FK_o_id` (`oi_orderid`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`o_id`);

--
-- Indexes for table `useraccount`
--
ALTER TABLE `useraccount`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `fkey_userprofile` (`userprofile`);

--
-- Indexes for table `userprofile`
--
ALTER TABLE `userprofile`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `profile` (`profile`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `couponcode`
--
ALTER TABLE `couponcode`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT for table `menuitem`
--
ALTER TABLE `menuitem`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;

--
-- AUTO_INCREMENT for table `orderitem`
--
ALTER TABLE `orderitem`
  MODIFY `oi_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=226;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `o_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT for table `useraccount`
--
ALTER TABLE `useraccount`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT for table `userprofile`
--
ALTER TABLE `userprofile`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orderitem`
--
ALTER TABLE `orderitem`
  ADD CONSTRAINT `FK_o_id` FOREIGN KEY (`oi_orderid`) REFERENCES `orders` (`o_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `useraccount`
--
ALTER TABLE `useraccount`
  ADD CONSTRAINT `fk_userprofile` FOREIGN KEY (`userprofile`) REFERENCES `userprofile` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
