-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 01, 2018 at 10:19 PM
-- Server version: 5.7.22-0ubuntu0.16.04.1
-- PHP Version: 7.0.28-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `WebApp`
--

-- --------------------------------------------------------

--
-- Table structure for table `Categorie`
--

CREATE TABLE `Categorie` (
  `Codice` int(3) NOT NULL,
  `Descrizione` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Categorie`
--

INSERT INTO `Categorie` (`Codice`, `Descrizione`) VALUES
(1, 'Prodotto1');

-- --------------------------------------------------------

--
-- Table structure for table `Clienti`
--

CREATE TABLE `Clienti` (
  `Piva` varchar(11) NOT NULL,
  `Nome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `CTeam`
--

CREATE TABLE `CTeam` (
  `MatricolaDipendente` int(3) NOT NULL,
  `CodiceNC` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Dipendenti`
--

CREATE TABLE `Dipendenti` (
  `Matricola` int(3) NOT NULL,
  `Nome` varchar(30) NOT NULL,
  `Cognome` varchar(30) NOT NULL,
  `Reparto` int(3) NOT NULL,
  `Username` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Dipendenti`
--

INSERT INTO `Dipendenti` (`Matricola`, `Nome`, `Cognome`, `Reparto`, `Username`) VALUES
(1, 'Operaio', 'Operaio', 1, 'Operaio'),
(2, 'Manager', 'Manager', 2, 'Manager'),
(3, 'Responsabile Qualita', 'Responsabile Qualita', 3, 'ResponsabileQualita'),
(4, 'ControlloreQualita', 'ControlloreQualita', 1, 'ControlloreQualita');

-- --------------------------------------------------------

--
-- Table structure for table `Elaborazioni`
--

CREATE TABLE `Elaborazioni` (
  `Codice` int(4) NOT NULL,
  `Descrizione` varchar(255) NOT NULL,
  `DataInizio` date NOT NULL,
  `DataFine` date DEFAULT NULL,
  `MatricolaDipendente` int(3) NOT NULL,
  `CodiceNC` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Fornitori`
--

CREATE TABLE `Fornitori` (
  `Piva` varchar(11) NOT NULL,
  `Nome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `NonConformita`
--

CREATE TABLE `NonConformita` (
  `Codice` int(5) NOT NULL,
  `Descrizione` varchar(255) NOT NULL,
  `AzioniContenimento` varchar(255) NOT NULL,
  `AzioniCorrettive` varchar(255) DEFAULT NULL,
  `AzioniPreventive` varchar(255) DEFAULT NULL,
  `DataApertura` date NOT NULL,
  `DataChiusura` date DEFAULT NULL,
  `Cause` varchar(255) NOT NULL,
  `Gravita` int(2) NOT NULL,
  `Costo` decimal(12,2) DEFAULT NULL,
  `Tipo` varchar(30) NOT NULL,
  `PivaFornitore` varchar(11) DEFAULT NULL,
  `PivaCliente` varchar(11) DEFAULT NULL,
  `IDReparto` int(3) DEFAULT NULL,
  `MatricolaDipendente` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `NonConformita`
--

INSERT INTO `NonConformita` (`Codice`, `Descrizione`, `AzioniContenimento`, `AzioniCorrettive`, `AzioniPreventive`, `DataApertura`, `DataChiusura`, `Cause`, `Gravita`, `Costo`, `Tipo`, `PivaFornitore`, `PivaCliente`, `IDReparto`, `MatricolaDipendente`) VALUES
(1, 'aa', 'aa', NULL, NULL, '2018-05-10', NULL, '', 1, '0.00', 'Tipo NC 1', NULL, NULL, 1, 4);

-- --------------------------------------------------------

--
-- Table structure for table `Pezzi`
--

CREATE TABLE `Pezzi` (
  `Codice` int(7) NOT NULL,
  `Categoria` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Pezzi`
--

INSERT INTO `Pezzi` (`Codice`, `Categoria`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1),
(11, 1),
(12, 1),
(13, 1),
(14, 1),
(15, 1),
(16, 1),
(17, 1),
(18, 1),
(19, 1),
(20, 1),
(21, 1),
(22, 1),
(23, 1),
(24, 1),
(25, 1),
(26, 1),
(27, 1),
(28, 1),
(29, 1),
(30, 1),
(31, 1),
(32, 1),
(33, 1),
(34, 1),
(35, 1),
(36, 1),
(37, 1),
(38, 1),
(39, 1),
(40, 1),
(41, 1),
(42, 1),
(43, 1),
(44, 1),
(45, 1),
(46, 1),
(47, 1),
(48, 1),
(49, 1),
(50, 1),
(51, 1),
(52, 1),
(53, 1),
(54, 1),
(55, 1),
(56, 1),
(57, 1),
(58, 1),
(59, 1),
(60, 1),
(61, 1),
(62, 1),
(63, 1),
(64, 1),
(65, 1),
(66, 1),
(67, 1),
(68, 1),
(69, 1),
(70, 1),
(71, 1),
(72, 1),
(73, 1),
(74, 1),
(75, 1),
(76, 1),
(77, 1),
(78, 1),
(79, 1),
(80, 1),
(81, 1),
(82, 1),
(83, 1),
(84, 1),
(85, 1),
(86, 1),
(87, 1),
(88, 1),
(89, 1),
(90, 1),
(91, 1),
(92, 1),
(93, 1),
(94, 1),
(95, 1),
(96, 1),
(97, 1),
(98, 1),
(99, 1),
(100, 1),
(101, 1),
(102, 1),
(103, 1),
(104, 1),
(105, 1),
(106, 1),
(107, 1),
(108, 1),
(109, 1),
(110, 1),
(111, 1),
(112, 1),
(113, 1),
(114, 1),
(115, 1),
(116, 1),
(117, 1),
(118, 1),
(119, 1),
(120, 1);

-- --------------------------------------------------------

--
-- Table structure for table `PezzoNC`
--

CREATE TABLE `PezzoNC` (
  `CodicePezzo` int(7) NOT NULL,
  `CodiceNC` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `PezzoNC`
--

INSERT INTO `PezzoNC` (`CodicePezzo`, `CodiceNC`) VALUES
(12, 1);

-- --------------------------------------------------------

--
-- Table structure for table `Reparti`
--

CREATE TABLE `Reparti` (
  `ID` int(3) NOT NULL,
  `Nome` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Reparti`
--

INSERT INTO `Reparti` (`ID`, `Nome`) VALUES
(1, 'Produzione'),
(2, 'Direzione'),
(3, 'Qualita');

-- --------------------------------------------------------

--
-- Table structure for table `Segnalazioni`
--

CREATE TABLE `Segnalazioni` (
  `Codice` int(5) NOT NULL,
  `Titolo` varchar(255) NOT NULL,
  `Descrizione` varchar(255) NOT NULL,
  `Data` date NOT NULL,
  `MatricolaDipendente` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Tipi`
--

CREATE TABLE `Tipi` (
  `Nome` varchar(30) NOT NULL,
  `Descrizione` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Tipi`
--

INSERT INTO `Tipi` (`Nome`, `Descrizione`) VALUES
('Tipo NC 1', 'Tipo NC 1');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(45) NOT NULL,
  `password` varchar(60) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `enabled`) VALUES
('ControlloreQualita', '$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', 1),
('Manager', '$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', 1),
('Operaio', '$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', 1),
('ResponsabileQualita', '$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `user_role_id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`user_role_id`, `username`, `role`) VALUES
(5, 'ControlloreQualita', 'ROLE_CONTROLQUA'),
(2, 'Manager', 'ROLE_MANAGER'),
(3, 'Operaio', 'ROLE_OPERAIO'),
(4, 'ResponsabileQualita', 'ROLE_RESPOQUA');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Categorie`
--
ALTER TABLE `Categorie`
  ADD PRIMARY KEY (`Codice`);

--
-- Indexes for table `Clienti`
--
ALTER TABLE `Clienti`
  ADD PRIMARY KEY (`Piva`);

--
-- Indexes for table `CTeam`
--
ALTER TABLE `CTeam`
  ADD PRIMARY KEY (`MatricolaDipendente`,`CodiceNC`),
  ADD KEY `CodiceNC` (`CodiceNC`);

--
-- Indexes for table `Dipendenti`
--
ALTER TABLE `Dipendenti`
  ADD PRIMARY KEY (`Matricola`),
  ADD KEY `Reparto` (`Reparto`),
  ADD KEY `Username` (`Username`);

--
-- Indexes for table `Elaborazioni`
--
ALTER TABLE `Elaborazioni`
  ADD PRIMARY KEY (`Codice`),
  ADD KEY `MatricolaDipendente` (`MatricolaDipendente`),
  ADD KEY `CodiceNC` (`CodiceNC`);

--
-- Indexes for table `Fornitori`
--
ALTER TABLE `Fornitori`
  ADD PRIMARY KEY (`Piva`);

--
-- Indexes for table `NonConformita`
--
ALTER TABLE `NonConformita`
  ADD PRIMARY KEY (`Codice`),
  ADD KEY `Tipo` (`Tipo`),
  ADD KEY `PivaFornitore` (`PivaFornitore`),
  ADD KEY `PivaCliente` (`PivaCliente`),
  ADD KEY `IDReparto` (`IDReparto`),
  ADD KEY `MatricolaDipendente` (`MatricolaDipendente`);

--
-- Indexes for table `Pezzi`
--
ALTER TABLE `Pezzi`
  ADD PRIMARY KEY (`Codice`),
  ADD KEY `Categoria` (`Categoria`);

--
-- Indexes for table `PezzoNC`
--
ALTER TABLE `PezzoNC`
  ADD PRIMARY KEY (`CodicePezzo`,`CodiceNC`),
  ADD KEY `CodiceNC` (`CodiceNC`);

--
-- Indexes for table `Reparti`
--
ALTER TABLE `Reparti`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Segnalazioni`
--
ALTER TABLE `Segnalazioni`
  ADD PRIMARY KEY (`Codice`),
  ADD KEY `MatricolaDipendente` (`MatricolaDipendente`);

--
-- Indexes for table `Tipi`
--
ALTER TABLE `Tipi`
  ADD PRIMARY KEY (`Nome`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_role_id`),
  ADD UNIQUE KEY `uni_username_role` (`role`,`username`),
  ADD KEY `fk_username_idx` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Categorie`
--
ALTER TABLE `Categorie`
  MODIFY `Codice` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `Dipendenti`
--
ALTER TABLE `Dipendenti`
  MODIFY `Matricola` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `Elaborazioni`
--
ALTER TABLE `Elaborazioni`
  MODIFY `Codice` int(4) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `NonConformita`
--
ALTER TABLE `NonConformita`
  MODIFY `Codice` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `Pezzi`
--
ALTER TABLE `Pezzi`
  MODIFY `Codice` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=121;
--
-- AUTO_INCREMENT for table `Reparti`
--
ALTER TABLE `Reparti`
  MODIFY `ID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `Segnalazioni`
--
ALTER TABLE `Segnalazioni`
  MODIFY `Codice` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user_roles`
--
ALTER TABLE `user_roles`
  MODIFY `user_role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `CTeam`
--
ALTER TABLE `CTeam`
  ADD CONSTRAINT `CTeam_ibfk_1` FOREIGN KEY (`MatricolaDipendente`) REFERENCES `Dipendenti` (`Matricola`),
  ADD CONSTRAINT `CTeam_ibfk_2` FOREIGN KEY (`CodiceNC`) REFERENCES `NonConformita` (`Codice`);

--
-- Constraints for table `Dipendenti`
--
ALTER TABLE `Dipendenti`
  ADD CONSTRAINT `Dipendenti_ibfk_1` FOREIGN KEY (`Reparto`) REFERENCES `Reparti` (`ID`),
  ADD CONSTRAINT `Dipendenti_ibfk_2` FOREIGN KEY (`Username`) REFERENCES `users` (`username`);

--
-- Constraints for table `Elaborazioni`
--
ALTER TABLE `Elaborazioni`
  ADD CONSTRAINT `Elaborazioni_ibfk_1` FOREIGN KEY (`MatricolaDipendente`) REFERENCES `Dipendenti` (`Matricola`),
  ADD CONSTRAINT `Elaborazioni_ibfk_2` FOREIGN KEY (`CodiceNC`) REFERENCES `NonConformita` (`Codice`);

--
-- Constraints for table `NonConformita`
--
ALTER TABLE `NonConformita`
  ADD CONSTRAINT `NonConformita_ibfk_1` FOREIGN KEY (`Tipo`) REFERENCES `Tipi` (`Nome`),
  ADD CONSTRAINT `NonConformita_ibfk_2` FOREIGN KEY (`PivaFornitore`) REFERENCES `Fornitori` (`Piva`),
  ADD CONSTRAINT `NonConformita_ibfk_3` FOREIGN KEY (`PivaCliente`) REFERENCES `Clienti` (`Piva`),
  ADD CONSTRAINT `NonConformita_ibfk_4` FOREIGN KEY (`IDReparto`) REFERENCES `Reparti` (`ID`),
  ADD CONSTRAINT `NonConformita_ibfk_5` FOREIGN KEY (`MatricolaDipendente`) REFERENCES `Dipendenti` (`Matricola`);

--
-- Constraints for table `Pezzi`
--
ALTER TABLE `Pezzi`
  ADD CONSTRAINT `Pezzi_ibfk_1` FOREIGN KEY (`Categoria`) REFERENCES `Categorie` (`Codice`);

--
-- Constraints for table `PezzoNC`
--
ALTER TABLE `PezzoNC`
  ADD CONSTRAINT `PezzoNC_ibfk_1` FOREIGN KEY (`CodicePezzo`) REFERENCES `Pezzi` (`Codice`),
  ADD CONSTRAINT `PezzoNC_ibfk_2` FOREIGN KEY (`CodiceNC`) REFERENCES `NonConformita` (`Codice`);

--
-- Constraints for table `Segnalazioni`
--
ALTER TABLE `Segnalazioni`
  ADD CONSTRAINT `Segnalazioni_ibfk_1` FOREIGN KEY (`MatricolaDipendente`) REFERENCES `Dipendenti` (`Matricola`);

--
-- Constraints for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `fk_username` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
