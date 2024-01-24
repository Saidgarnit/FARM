-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 24 jan. 2024 à 21:03
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `myprojectjavafx`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `NTele` int(11) NOT NULL,
  `DateBird` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`id`, `password`, `email`, `full_name`, `NTele`, `DateBird`) VALUES
(8, 'said1234', 'said@gamil.com', 'said', 0, NULL),
(9, '12345600', 'said@gmail', 'said', 0, NULL),
(10, 'said1234', 'said@gmail.com', 'said', 0, NULL),
(11, 'said12345', 'said@gmail.com', 'said', 0, NULL),
(12, 'said1234', 'said@gamil.com', 'said', 0, NULL),
(13, 'said1234', 'said@gmail.com', 'said', 0, NULL),
(14, 'said1234', 'said@ff', 'said', 0, NULL),
(15, 'said1234', 'said@gmail.com', 'said', 0, NULL),
(16, 'said1234', 'said@gmail.com', 'said', 6, NULL),
(17, '', '', '', 0, '0000-00-00'),
(18, 'said1234', 'said@gmail.com', 'said', 0, NULL),
(19, 'popo', 'popo', 'popo', 6060, '2023-11-08');

-- --------------------------------------------------------

--
-- Structure de la table `production`
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
-- Déchargement des données de la table `production`
--

INSERT INTO `production` (`id`, `metrage`, `Nom_de_race`, `Quantite`, `Qantite_Finale`, `Prix`, `Date_dentre`, `Nom_de_lemploye`, `Nom_de_fournisseur`, `origine`) VALUES
(3, '2', 'Metrage', '3', '45', '55.0', '2023-12-04', 'TR', 'AHMED', 'EEZ'),
(11, '2', 'Metrage', '3', '45', '55.0', '2023-12-04', 'TR', 'AHMED', 'EEZ'),
(12, '2', 'Metrage', '3', '45', '55.0', '2023-12-04', 'TR', 'AHMED', 'EEZ'),
(13, '23', 'Metrage', '34', '2', '3.0', '2023-12-04', 'TR', 'DOHA', 'FRRE'),
(15, '23', 'Metrage', '34', '2', '3.0', '2023-12-04', 'TR', 'DOHA', 'FRRE'),
(16, '23', 'ahmed', '34', '2', '3.0', '2023-12-04', 'FRRE', 'TR', 'DOHA'),
(17, '3', 'Metrage', '3', '4', '5.0', '2023-12-04', 'T', 'AHMED', 'TTT'),
(22, '100', 'Metrage', '99', '98', '55.0', '2023-12-04', 'AA', 'tAR', 'DOHA'),
(24, '30', 'simo', '50', '70', '90.0', '2023-11-27', 'AZE', 'az', 'AQ'),
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
(58, '1000', 'aaaa', '20000', '1500', '70000.0', '2023-12-05', 'asaka', 'SAID', 'laarbi'),
(59, '1000', 'aaaa', '20000', '1500', '70000.0', '2023-12-05', 'asaka', 'SAID', 'laarbi'),
(60, '1000', 'aaaa', '20000', '1500', '70000.0', '2023-12-05', 'asaka', 'SAID', 'laarbi'),
(61, '1000', 'aaaa', '20000', '1500', '70000.0', '2023-12-05', 'asaka', 'SAID', 'jhzkjhzkjhzjkjzbi'),
(68, '1000', 'dajaji', '70', '60', '300.0', '2023-12-04', 'TAROUDANT', 'elmhjoub', 'hsika'),
(69, '1000', 'dajaji', '70', '60', '300.0', '2023-12-04', 'TAROUDANT', 'elmhjoub', 'hsika'),
(70, '1000', 'dajaji', '70', '60', '300.0', '2023-12-04', 'hsika', 'TAROUDANT', 'elmhjoub'),
(71, '1000', 'dajaj', '30000', '20000', '600000.0', '2023-12-06', 'AHMED', 'hamza', 'taroudant'),
(72, '1000', 'dajaj', '30000', '20000', '600000.0', '2023-12-06', 'DOHA', 'ghgh', 'taroudant'),
(73, '1000', 'dajaj', '30000', '20000', '600000.0', '2023-12-06', 'DOHA', 'ghgh', 'taroudant'),
(75, '30', 'rtret', '50', '70', '90.0', '2023-11-27', 'elmhjoub', 'AQ', 'AZE'),
(79, '200', 'bibi', '1800', '1700', '5000.0', '2024-01-24', 'elmhjoub', 'AHMEDD', 'TAROUDANTT'),
(80, '300', 'ronaldinyo', '1000', '9000', '3000.0', '2024-01-24', 'elmhjoub', 'ahmed', 'taroudant'),
(81, '300', 'ronaldinyo', '1000', '9000', '3000.0', '2024-01-24', 'elmhjoub', 'ahmed', 'taroudant');

-- --------------------------------------------------------

--
-- Structure de la table `suivi_production`
--

CREATE TABLE `suivi_production` (
  `id` int(11) NOT NULL,
  `quantite_par_jour` varchar(30) NOT NULL,
  `date` varchar(30) NOT NULL,
  `consomation` varchar(30) NOT NULL,
  `emploiyee` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `suivi_production`
--

INSERT INTO `suivi_production` (`id`, `quantite_par_jour`, `date`, `consomation`, `emploiyee`) VALUES
(4, '34', '2023-06-06', '34', ''),
(5, '34', '2023-06-06', '34', ''),
(6, '34\'', '2023-12-13', '34', ''),
(7, '324\'', '2023-12-13', '34', ''),
(8, '20', '2023-12-11', '10', ''),
(9, '12', '2023-12-11', '16', ''),
(10, '12', '2023-12-04', '23', 'AHMED'),
(11, '12', '2023-12-11', '45', 'elmhjoub'),
(12, '12', '2023-12-12', '20', 'SAID'),
(14, '120', '2023-12-11', '40', 'T'),
(15, '120', '2023-12-11', '40', 'T'),
(16, '120', '2023-12-11', '40', 'T'),
(17, '120', '2023-12-11', '40', 'T'),
(18, '120', '2023-12-11', '40', 'T'),
(19, '12', '2023-12-12', '34', 'TAROUDANT'),
(20, '12', '2023-12-12', '34', 'TAROUDANT'),
(21, '12', '2023-12-12', '34', 'TAROUDANT'),
(22, '23', '2023-12-12', '32', 'AZE'),
(23, '23', '2023-12-12', '32', 'AZE'),
(24, '12', '2023-12-12', '23', 'T'),
(26, '23', '2023-12-04', '125', 'AHMED'),
(27, '133', '2024-01-16', '23', 'elmhjoub'),
(28, '150', '2024-01-08', '32', 'SAID'),
(29, '150', '2024-01-17', '32', 'SAID'),
(30, '150', '2024-01-17', '123', 'elmhjoub'),
(31, '150', '2024-01-16', '123', 'elmhjoub'),
(32, '150', '2024-01-16', '123', 'elmhjoub'),
(33, '150', '2024-01-16', '123', 'TAROUDANT'),
(34, '122', '2024-01-16', '134', 'AHMED'),
(35, '122', '2024-01-16', '134', 'AHMED'),
(36, '34', '2024-01-24', '5', 'elmhjoub'),
(37, '20', '2024-01-24', '10', 'elmhjoub'),
(38, '23', '2024-01-24', '9', 'elmhjoub');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `production`
--
ALTER TABLE `production`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `suivi_production`
--
ALTER TABLE `suivi_production`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT pour la table `production`
--
ALTER TABLE `production`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=82;

--
-- AUTO_INCREMENT pour la table `suivi_production`
--
ALTER TABLE `suivi_production`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
