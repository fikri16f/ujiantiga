-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 26, 2021 at 01:47 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ujiantiga`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `Countdepartement` ()  SELECT departement, COUNT(departement) AS jumlah FROM worker GROUP BY departement$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSalary` (IN `nilai` INT(100))  SELECT * from worker where worker.salary >= 5000$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getMaxsallary` ()  SELECT salary,first_name,last_name,departement FROM worker ORDER BY salary DESC LIMIT 5$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getSamedata` ()  SELECT * FROM worker where salary IN (SELECT salary  FROM worker GROUP BY salary HAVING count(*) > 1)$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `bonus`
--

CREATE TABLE `bonus` (
  `worker_ref_id` int(10) NOT NULL,
  `bonus_date` date NOT NULL,
  `bonus_amount` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bonus`
--

INSERT INTO `bonus` (`worker_ref_id`, `bonus_date`, `bonus_amount`) VALUES
(1, '2016-02-20', 5000),
(2, '2016-06-11', 3000),
(3, '2016-02-20', 4000),
(1, '2016-02-20', 4500),
(2, '2016-06-11', 3500);

-- --------------------------------------------------------

--
-- Table structure for table `tittle`
--

CREATE TABLE `tittle` (
  `worker_ref_id` int(10) NOT NULL,
  `worker_title` varchar(15) NOT NULL,
  `affected_from` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tittle`
--

INSERT INTO `tittle` (`worker_ref_id`, `worker_title`, `affected_from`) VALUES
(1, 'Manager', '2016-02-20'),
(2, 'Executive', '2016-06-11'),
(8, 'Executive', '2016-06-11'),
(5, 'Manager', '2016-06-11'),
(7, 'Executive', '2016-06-11'),
(6, 'Lead', '2016-06-11'),
(1, 'Lead', '2016-06-11');

-- --------------------------------------------------------

--
-- Table structure for table `worker`
--

CREATE TABLE `worker` (
  `worker_id` int(15) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `salary` int(10) NOT NULL,
  `joining_date` date NOT NULL,
  `departement` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `worker`
--

INSERT INTO `worker` (`worker_id`, `first_name`, `last_name`, `salary`, `joining_date`, `departement`) VALUES
(1, 'Monika', 'Arora', 100000, '2014-02-20', 'HR'),
(2, 'Niharika', 'Verma', 80000, '2014-06-11', 'Admin'),
(3, 'Vishal', 'Singhal', 300000, '2014-02-20', 'HR'),
(4, 'Amitabh', 'Singh', 500000, '2014-02-20', 'Admin'),
(5, 'Vivek', 'Bhati', 500000, '2014-06-11', 'Admin'),
(6, 'Vipul', 'Diwan', 200000, '2014-06-11', 'Account'),
(7, 'Satish', 'Kumar', 75000, '2014-01-20', 'Account'),
(8, 'Geetika', 'Chauhan', 90000, '2014-04-11', 'Admin'),
(9, 'fikri', 'Ahay', 10000, '2014-04-11', 'Leader');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
