-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 05, 2023 at 11:15 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `myprojectjavafx`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `DateBird` date DEFAULT NULL,
  `image_path` varchar(100) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `Ntele` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `password`, `email`, `full_name`, `DateBird`, `image_path`, `Age`, `Ntele`) VALUES
(24, 'SaidSaid', 'Said@gmail.com', 'Said', '1968-12-05', 'C:\\Users\\Said\\Desktop\\ProjetFX\\login 2\\images\\admin_image_Said@gmail.com.jpg', 55, '0666666666'),
(25, 'Said9Said9', 'Said9@gmail.com', 'Said9', '2023-12-05', 'C:UsersSaidDesktopProjetFXlogin 2srcmain\resourcesImages14.png', NULL, NULL),
(26, 'Garnit6Garnit6', 'Garnit6@gmail.com', 'Garnit6', '2023-12-05', 'C:UsersSaidDesktopProjetFXlogin 2srcmain\resourcesImages14.png', NULL, NULL),
(27, 'GarnitGarnit', 'Garnit@gmail.com', 'Garnit', '2006-12-05', 'C:UsersSaidDesktopProjetFXlogin 2srcmain\resourcesImages14.png', 17, NULL),
(28, 'SaidSaid', 'Said@gmail.com', 'Said', '1968-12-05', 'C:\\Users\\Said\\Desktop\\ProjetFX\\login 2\\images\\admin_image_Said@gmail.com.jpg', 55, '0666666666'),
(29, 'hamzahamza', 'hamza@gmail.com', 'hamza', '2001-12-05', 'C:UsersSaidDesktopProjetFXlogin 2srcmain\resourcesImages14.png', 22, '0622222222');

-- --------------------------------------------------------

--
-- Table structure for table `production`
--

CREATE TABLE `production` (
  `id` int(11) NOT NULL,
  `metrage` varchar(2000) NOT NULL,
  `Nom_de_race` varchar(20) NOT NULL,
  `Quantite` varchar(20) NOT NULL,
  `Qantite_Finale` varchar(20) NOT NULL,
  `Prix` varchar(20) NOT NULL,
  `Date_dentre` varchar(10) NOT NULL,
  `Nom_de_lemploye` varchar(20) NOT NULL,
  `Nom_de_fournisseur` varchar(20) NOT NULL,
  `origine` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `production`
--

INSERT INTO `production` (`id`, `metrage`, `Nom_de_race`, `Quantite`, `Qantite_Finale`, `Prix`, `Date_dentre`, `Nom_de_lemploye`, `Nom_de_fournisseur`, `origine`) VALUES
(3, '2', 'Metrage', '3', '45', '55.0', '2023-12-04', 'TR', 'AHMED', 'EEZ'),
(11, '2', 'Metrage', '3', '45', '55.0', '2023-12-04', 'TR', 'AHMED', 'EEZ'),
(12, '2', 'Metrage', '3', '45', '55.0', '2023-12-04', 'TR', 'AHMED', 'EEZ'),
(13, '23', 'Metrage', '34', '2', '3.0', '2023-12-04', 'TR', 'DOHA', 'FRRE'),
(15, '23', 'Metrage', '34', '2', '3.0', '2023-12-04', 'TR', 'DOHA', 'FRRE'),
(16, '23', 'ahmed', '34', '2', '3.0', '2023-12-04', 'FRRE', 'TR', 'DOHA'),
(17, '3', 'Metrage', '3', '4', '5.0', '2023-12-04', 'T', 'AHMED', 'TTT'),
(18, '3', 'Metrage', '3', '4', '5.0', '2023-12-04', 'T', 'AHMED', 'TTT'),
(19, '1000', 'Metrage', '990', '880', '50000.0', '2023-12-04', 'taroudant', 'DOHA', 'ddd'),
(21, '1000', 'Metrage', '990', '880', '50000.0', '2023-12-04', 'taroudant', 'DOHA', 'ddd'),
(22, '100', 'Metrage', '99', '98', '55.0', '2023-12-04', 'AA', 'tAR', 'DOHA'),
(24, '30', 'simo', '50', '70', '90.0', '2023-11-27', 'elmhjoub', 'AQ', 'AZE'),
(25, '30', 'simo', '50', '70', '90.0', '2023-11-27', 'elmhjoub', 'AQ', 'AZE'),
(26, '30', 'simoppop', '50', '70', '90.0', '2023-11-27', 'AZE', 'elmhjoub', 'AQ'),
(27, '30', 'simo', '50', '70', '90.0', '2023-11-27', 'elmhjoub', 'AQ', 'AZE'),
(28, '30', 'simo', '50', '70', '90.0', '2023-11-27', 'elmhjoub', 'AQ', 'AZE'),
(29, '30', 'simo', '50', '70', '90.0', '2023-11-27', 'elmhjoub', 'AQ', 'AZE'),
(30, '30', 'simo', '50', '70', '90.0', '2023-11-27', 'elmhjoub', 'AQ', 'AZE'),
(31, '30', 'simo', '50', '70', '90.0', '2023-11-27', 'elmhjoub', 'AQ', 'AZE'),
(32, '1', 'A', '1', '1', '1.0', '2024-01-01', 'AHMED', 'A', 'A'),
(33, '1', 'A', '1', '1', '1.0', '2024-01-01', 'AHMED', 'A', 'A'),
(34, '1', 'A', '1', '1', '1.0', '2024-01-01', 'AHMED', 'A', 'A'),
(35, '1', 'A', '1', '1', '1.0', '2024-01-01', 'AHMED', 'A', 'A'),
(36, '1', 'A', '1', '1', '1.0', '2024-01-01', 'AHMED', 'A', 'A'),
(37, '1', 'A', '1', '1', '1.0', '2024-01-01', 'AHMED', 'A', 'A'),
(38, '1', 'A', '1', '1', '1.0', '2024-01-01', 'AHMED', 'A', 'A'),
(39, '1', 'A', '1', '1', '1.0', '2024-01-01', 'AHMED', 'A', 'A'),
(40, '1', 'A', '1', '1', '1.0', '2024-01-01', 'AHMED', 'A', 'A'),
(41, '1', 'A', '1', '1', '1.0', '2024-01-01', 'AHMED', 'A', 'A'),
(42, '1', 'A', '1', '1', '1.0', '2024-01-01', 'AHMED', 'A', 'A'),
(43, '1', 'A', '1', '1', '1.0', '2024-01-01', 'AHMED', 'A', 'A'),
(44, '1', 'A', '1', '1', '1.0', '2024-01-01', 'AHMED', 'A', 'A'),
(45, '1', 'A', '1', '1', '1.0', '2024-01-01', 'AHMED', 'A', 'A'),
(46, '1', 'A', '1', '1', '1.0', '2024-01-01', 'AHMED', 'A', 'A'),
(47, '1', 'A', '1', '1', '1.0', '2024-01-01', 'AHMED', 'A', 'A'),
(48, '1', 'A', '1', '1', '1.0', '2024-01-01', 'AHMED', 'A', 'A'),
(50, '1', 'A', '1', '1', '1.0', '2024-01-01', 'AHMED', 'A', 'A'),
(51, '1', 'A', '1', '1', '1.0', '2024-01-01', 'AHMED', 'A', 'A'),
(52, '1', 'A', '1', '1', '1.0', '2024-01-01', 'AHMED', 'A', 'A'),
(53, '1', 'A', '1', '1', '1.0', '2024-01-01', 'AHMED', 'A', 'A'),
(54, '1', 'A', '1', '1', '1.0', '2024-01-01', 'AHMED', 'A', 'A'),
(55, '1000', 'dajaji', '20000', '1500', '70000.0', '2023-12-05', 'SAID', 'laarbi', 'asaka'),
(56, '1000', 'dajaji', '70', '60', '300.0', '2023-12-04', 'elmhjoub', 'hsika', 'TAROUDANT'),
(57, '1000', 'aaaa', '20000', '1500', '70000.0', '2023-12-05', 'asaka', 'SAID', 'laarbi'),
(58, '1000', 'said', '20000', '1500', '70000.0', '2023-12-05', 'laarbi', 'asaka', 'SAID'),
(59, '1000', 'aaaa', '20000', '1500', '70000.0', '2023-12-05', 'asaka', 'SAID', 'laarbi'),
(60, '1000', 'aaaa', '20000', '1500', '70000.0', '2023-12-05', 'asaka', 'SAID', 'laarbi'),
(61, '1000', 'aaaa', '20000', '1500', '70000.0', '2023-12-05', 'asaka', 'SAID', 'jhzkjhzkjhzjkjzbi'),
(66, '1000', 'AZZZZZZ', '20000', '1500', '70000.0', '2023-12-05', 'jhzkjhzkjhzjkjzbi', 'asaka', 'SAID'),
(68, '2', 'Metrage99', '3', '45', '55.0', '2023-12-04', 'EEZ', 'TR', 'AHMED'),
(69, '2', 'Metrage', '3', '45', '55.0', '2023-12-04', 'EEZ', 'TR', 'AHMED'),
(70, '88', 'said', '99', '459', '55.09', '2023-12-04', 'DOHA', 'TR', 'AHMED');


--
-- Structure de la table `ventes`
--

CREATE TABLE `ventes` (
  `id` int(11) NOT NULL,
  `Nom_De_Product` varchar(20) NOT NULL,
  `Quantite` varchar(20) NOT NULL,
  `Prix` varchar(20) NOT NULL,
  `Date_Ventre` varchar(10) NOT NULL,
  `Client` varchar(20) NOT NULL,
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Déchargement des données de la table `ventes`


INSERT INTO `ventes` (`id`, `Nom_De_Product`, `Quantite`, `Prix`, `Date_Ventre`, `Client`) VALUES
(1, 'Product1', '10', '100.0', '2023-12-05', 'Client1'),
(2, 'Product2', '15', '150.0', '2023-12-05', 'Client2'),
(3, 'Product3', '20', '200.0', '2023-12-05', 'Client3'),
(4, 'Product4', '25', '250.0', '2023-12-05', 'Client4'),
(5, 'Product5', '30', '300.0', '2023-12-05', 'Client5'),
(6, 'Product6', '35', '350.0', '2023-12-05', 'Client6'),
(7, 'Product7', '40', '400.0', '2023-12-05', 'Client7'),
(8, 'Product8', '45', '450.0', '2023-12-05', 'Client8'),
(9, 'Product9', '50', '500.0', '2023-12-05', 'Client9'),
(10, 'Product10', '55', '550.0', '2023-12-05', 'Client10');

-- --------------------------------------------------------


--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `production`
--
ALTER TABLE `production`
  ADD PRIMARY KEY (`id`);

-- Indexes for table `ventes`
--
ALTER TABLE `ventes`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

-- AUTO_INCREMENT for table `ventes`
--
ALTER TABLE `ventes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;


--
-- AUTO_INCREMENT for table `production`
--
ALTER TABLE `production`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
