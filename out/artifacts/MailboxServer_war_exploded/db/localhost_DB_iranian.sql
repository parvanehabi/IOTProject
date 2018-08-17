-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 24, 2017 at 06:13 AM
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
-- Table structure for table `azhans`
--

CREATE TABLE IF NOT EXISTS `azhans` (
  `azhans_id` int(11) NOT NULL AUTO_INCREMENT,
  `azhans_username` varchar(16) CHARACTER SET utf8 NOT NULL,
  `azhans_password` varchar(8) CHARACTER SET utf8 NOT NULL,
  `image_url` varchar(250) CHARACTER SET utf8 NOT NULL,
  `malek_name` varchar(20) CHARACTER SET utf8 NOT NULL,
  `malek_family` varchar(20) CHARACTER SET utf8 NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 NOT NULL,
  `tell` text NOT NULL,
  `address` mediumtext CHARACTER SET utf8 NOT NULL,
  `start_date` datetime NOT NULL,
  `lock` bit(50) NOT NULL,
  `securety_q` varchar(100) CHARACTER SET utf8 NOT NULL,
  `securety_answer` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`azhans_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `melk_forushi`
--

CREATE TABLE IF NOT EXISTS `melk_forushi` (
  `malk_id` int(11) NOT NULL AUTO_INCREMENT,
  `kind` varchar(100) NOT NULL,
  `city` varchar(100) NOT NULL,
  `area` varchar(500) NOT NULL,
  `metrazh` bigint(20) NOT NULL,
  `prise` bigint(20) NOT NULL,
  `num_of_room` int(100) NOT NULL,
  `picture_url` varchar(500) NOT NULL,
  `map` varchar(500) NOT NULL,
  `parking` bit(5) NOT NULL,
  `lift` bit(5) NOT NULL,
  `custodian` bit(5) NOT NULL,
  `pomd` bit(5) NOT NULL,
  `yard` bit(5) NOT NULL,
  `jacuzzy` bit(5) NOT NULL,
  `sport_sollon` bit(5) NOT NULL,
  PRIMARY KEY (`malk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `public_user`
--

CREATE TABLE IF NOT EXISTS `public_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `user_pass` varchar(16) NOT NULL,
  `securety_q` varchar(50) NOT NULL,
  `securety_answer` varchar(50) NOT NULL,
  `name` varchar(20) NOT NULL,
  `family` varchar(50) NOT NULL,
  `email` varchar(40) NOT NULL,
  `tell` text NOT NULL,
  `lock` bit(5) NOT NULL,
  `date` datetime NOT NULL,
  `address` mediumtext NOT NULL,
  `image_url` varchar(500) NOT NULL,
  `ok` bit(5) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
