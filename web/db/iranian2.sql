-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 27, 2017 at 01:55 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `iranian`
--
CREATE DATABASE IF NOT EXISTS `iranian` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `iranian`;

-- --------------------------------------------------------

--
-- Table structure for table `area`
--

CREATE TABLE IF NOT EXISTS `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `status` int(3) NOT NULL,
  `city_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE IF NOT EXISTS `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `status` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `home`
--

CREATE TABLE IF NOT EXISTS `home` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `seil-price-min` int(11) NOT NULL,
  `seil-price-max` int(11) NOT NULL,
  `rent-price-min` int(11) NOT NULL,
  `rent-price-max` int(11) NOT NULL,
  `type` int(3) NOT NULL COMMENT '0=sail     1=rent',
  `id-area` int(11) NOT NULL,
  `id-user` int(11) NOT NULL,
  `status` int(11) NOT NULL COMMENT '0=delete    1=ok',
  `parking` int(3) NOT NULL COMMENT '0=no parking  1=have parking',
  `map` varchar(250) NOT NULL,
  `pic-id1` int(10) NOT NULL,
  `number-of-room` int(100) NOT NULL,
  `type-build` int(20) NOT NULL COMMENT '1=apartoman  2=ederi  3=tejari  4=vila   5=mostaghelat  6=zamin  7=kolangi  8=bagh  9=anbar',
  `car-park` int(3) NOT NULL COMMENT '0=not  1=have',
  `balcony` int(3) NOT NULL,
  `lift` int(3) NOT NULL,
  `custoddian` int(3) NOT NULL,
  `lobby` int(3) NOT NULL,
  `pool` int(3) NOT NULL,
  `pantry` int(3) NOT NULL,
  `yard` int(3) NOT NULL,
  `sauna` int(3) NOT NULL,
  `sport sallon` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `tell` text NOT NULL,
  `access` int(5) NOT NULL COMMENT '1=admin  2=agance  3=mamuli',
  `uname` varchar(20) NOT NULL,
  `pass` int(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
