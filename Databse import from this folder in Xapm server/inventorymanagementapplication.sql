-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 30, 2023 at 12:59 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventorymanagementapplication`
--

-- --------------------------------------------------------

--
-- Table structure for table `borrowed_products`
--

CREATE TABLE `borrowed_products` (
  `id` int(11) NOT NULL,
  `productName` varchar(255) NOT NULL,
  `productModel` varchar(255) NOT NULL,
  `quantity` int(11) NOT NULL,
  `dateOfReturn` text DEFAULT NULL,
  `currentDateAndTime` text DEFAULT NULL,
  `studentName` varchar(255) NOT NULL,
  `studentPhone` varchar(20) NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  `return_Status` varchar(20) NOT NULL DEFAULT 'not_return'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `borrowed_products`
--

INSERT INTO `borrowed_products` (`id`, `productName`, `productModel`, `quantity`, `dateOfReturn`, `currentDateAndTime`, `studentName`, `studentPhone`, `status`, `return_Status`) VALUES
(29, 'item', 'model 2', 3, '2023/4/29', '2023-04-30T02:40:33.596', 'asif001', '0340030030', 'handover', 'not_return'),
(30, 'capicator 2', 'model e', 2, '2023/4/29', '2023-04-30T02:40:35.315', 'asif001', '0340030030', 'pending', 'not_return'),
(31, 'sfd', 'sdf', 2, '2023/4/29', '2023-04-30T02:40:36.268', 'asif001', '0340030030', 'pending', 'not_return'),
(32, 'Resistor', 'R2', 2, '2023/4/29', '2023-04-30T03:03:02.937', 'xyz', 'xyz2', 'pending', 'not_return'),
(33, 'capicator 4', 'model 2', 1, '2023/4/29', '2023-04-30T03:03:04.301', 'xyz', 'xyz2', 'handover', 'not_return'),
(34, 'capicator 4', 'model 2', 2, '2023/4/22', '2023-04-30T03:54:58.826', 'irfan', '0340004343', 'pending', 'not_return'),
(35, 'Resistor', 'R2', 2, '2023/4/22', '2023-04-30T03:55:00.235', 'irfan', '0340004343', 'pending', 'not_return');

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `value` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `returnDays` int(12) DEFAULT 5,
  `expiryDate` varchar(50) NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`id`, `name`, `model`, `value`, `quantity`, `returnDays`, `expiryDate`) VALUES
(6, 'capicator 2', 'model e', 0, -3, 5, '2024/04/13'),
(7, 'sfd', 'sdf', 0, 21, 5, '2024/04/06'),
(8, 'capicator 4', 'model 2', 0, 11, 5, '2024/04/20'),
(9, 'Resistor', 'R2', 0, 100, 5, '2024/04/27');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `name`, `user_id`, `password`, `phone_number`) VALUES
(1, 'irfan', 'irfan', '123', '0340004343'),
(2, 'khan', 'khan12', '123', '03352353'),
(4, 'abc', 'abc12', '123', '0234234'),
(5, 'usr', 'user12', '123', '0345664465'),
(6, 'Asif', 'asif001', '12345', '0340030030'),
(7, 'xyz', 'xyz', '123', 'xyz2');

-- --------------------------------------------------------

--
-- Table structure for table `technician`
--

CREATE TABLE `technician` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `technician`
--

INSERT INTO `technician` (`id`, `name`, `user_id`, `password`) VALUES
(1, 'tech', 'tech', 't2023');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `borrowed_products`
--
ALTER TABLE `borrowed_products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `technician`
--
ALTER TABLE `technician`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `borrowed_products`
--
ALTER TABLE `borrowed_products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `technician`
--
ALTER TABLE `technician`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
