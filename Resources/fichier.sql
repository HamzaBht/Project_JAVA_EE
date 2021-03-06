-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
-- Hôte : 127.0.0.1:3306
-- Version du serveur :  8.0.22
-- Version de PHP :  7.0.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `flightscomp`
--

-- --------------------------------------------------------

--
-- Structure de la table `aeroport`
--

DROP TABLE IF EXISTS `aeroport`;
CREATE TABLE IF NOT EXISTS `aeroport` (
  `idAeroport` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `Ville_idVille` int NOT NULL,
  PRIMARY KEY (`idAeroport`),
  KEY `fk_Aeroport_Ville1_idx` (`Ville_idVille`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `aeroport`
--

INSERT INTO `aeroport` (`idAeroport`, `nom`, `Ville_idVille`) VALUES
(1, 'Aéroport de Casablanca Mohammed V', 1),
(2, 'Aéroport de Marrakech-Ménara', 2),
(3, 'Aéroport Agadir Al Massira', 3),
(4, 'Aéroport Fès Saïss', 4),
(5, 'Aéroport de Tanger-Ibn Batouta', 5),
(6, ' Aéroport Rabat-Salé', 6),
(7, 'Aéroport de Nador-Al Aroui ', 7),
(8, 'Aéroport d\'Oujda-Angad', 8),
(9, 'Aéroport de Dakhla', 9),
(10, 'Aéroport de Laâyoune Hassan 1er', 10),
(11, 'Aéroport d\'Ouarzazate', 11),
(12, 'Aéroport d\'Essaouira-Mogador', 12),
(13, 'Aéroport Al Hoceima Cherif Al Idrissi', 13),
(14, ' Paris-Charles de Gaulle', 14),
(15, 'Aéroport Nice Côte d\'Azur', 15),
(16, 'Aéroport Marseille Provence', 16),
(17, 'Aéroport de Lyon-Saint Exupéry', 17),
(18, 'Aéroport Toulouse-Blagnac', 18),
(19, 'EuroAirport Basel-Mulhouse-Freiburg', 19),
(20, 'Aéroport Montpellier Méditerranée', 20),
(21, 'Aéroport de Grenoble-Isère', 21),
(22, 'Aéroport de Cannes-Mandelieu', 22),
(23, 'Aéroport Nantes Atlantique', 23),
(24, 'Aéroport de Francfort', 24),
(25, 'Aéroport Franz-Josef-Strauss de Munich', 25),
(26, 'Aéroport international de Düsseldorf', 26),
(27, 'Aéroport de Berlin-Tempelhof', 27),
(28, 'Aéroport Léonard-de-Vinci de Rome Fiumicino', 28),
(29, 'Aéroport de Milan Malpensa', 29),
(30, 'Aéroport international Galileo Galilei de Pis', 30),
(31, 'Genève Aéroport', 31),
(32, 'Aéroport Adolfo-Suárez de Madrid-Barajas', 32),
(33, 'Aéroport de Stockholm-Arlanda', 33),
(34, 'Aéroport international d\'Athènes Elefthérios-', 34),
(35, 'Aéroport de Varsovie-Chopin', 35),
(36, 'Aéroport de Bruxelles', 36),
(37, 'Aéroport international de Dublin', 37),
(38, 'Aéroport d\'Helsinki-Vantaa\r\n\r\n', 38),
(39, 'Aéroport d\'Oslo-Gardermoen', 39),
(40, 'Aéroport international de Malte', 40),
(41, 'Aéroport de Zagreb', 41),
(42, ' Aéroport de Kaunas ', 42),
(43, ' Aéroport de Luxembourg', 43),
(44, 'Aéroport d\'Amsterdam Schiphol', 44),
(45, 'Aéroport de Tirana', 45),
(46, 'solalo', 2);

-- --------------------------------------------------------

--
-- Structure de la table `cabine`
--

DROP TABLE IF EXISTS `cabine`;
CREATE TABLE IF NOT EXISTS `cabine` (
  `typeCabine` varchar(45) NOT NULL,
  `Capacite` int DEFAULT NULL,
  `idCabine` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idCabine`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `cabine`
--

INSERT INTO `cabine` (`typeCabine`, `Capacite`, `idCabine`) VALUES
('Première', 9, 1),
('Affaire', 80, 2),
('Éco-premium', 88, 3),
('Économie', 343, 4),
('LOLA', 20, 5);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `idClient` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `numeroPassport` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idClient`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`idClient`, `nom`, `numeroPassport`) VALUES
(1, 'Hamza', '22'),
(2, 'Hafsa', '22'),
(3, 'amine', '22'),
(4, 'mouad', '22'),
(5, 'jalil', '22'),
(6, 'Haf', '22');

-- --------------------------------------------------------

--
-- Structure de la table `pays`
--

DROP TABLE IF EXISTS `pays`;
CREATE TABLE IF NOT EXISTS `pays` (
  `nom` varchar(45) DEFAULT NULL,
  `idpays` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idpays`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `pays`
--

INSERT INTO `pays` (`nom`, `idpays`) VALUES
('Maroc', 1),
('France', 2),
('Allemagne', 3),
('Italie', 4),
('Suisse', 5),
('Espagne', 6),
('Suède', 7),
('Grèce', 8),
('Pologne', 9),
('Belgique', 10),
('Autriche', 11),
('Irlande', 12),
('Finlande', 13),
('Norvège', 14),
('Malte', 15),
('Croatie', 16),
('Lituanie', 17),
('Luxembourg', 18),
('Pays-bas', 19),
('Albanie', 20);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `idReservation` int NOT NULL AUTO_INCREMENT,
  `dateReservation` varchar(45) DEFAULT NULL,
  `heureReservation` varchar(45) DEFAULT NULL,
  `Vol_idVol` int NOT NULL,
  `Client_idClient` int NOT NULL,
  PRIMARY KEY (`idReservation`),
  KEY `fk_Reservation_Vol1_idx` (`Vol_idVol`),
  KEY `fk_Reservation_Client1_idx` (`Client_idClient`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`idReservation`, `dateReservation`, `heureReservation`, `Vol_idVol`, `Client_idClient`) VALUES
(1, '2021-02-28', '09:00:00', 1, 1),
(2, '2021-02-28', '09:00:00', 2, 1),
(3, '2021-02-28', '09:00:00', 2, 2),
(4, '2021-02-28', '09:00:00', 2, 3),
(5, '2021-02-28', '09:00:00', 2, 4);

-- --------------------------------------------------------

--
-- Structure de la table `ville`
--

DROP TABLE IF EXISTS `ville`;
CREATE TABLE IF NOT EXISTS `ville` (
  `nom` varchar(45) DEFAULT NULL,
  `idVille` int NOT NULL AUTO_INCREMENT,
  `Pays_idpays` int NOT NULL,
  PRIMARY KEY (`idVille`),
  KEY `fk_Ville_Pays1_idx` (`Pays_idpays`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `ville`
--

INSERT INTO `ville` (`nom`, `idVille`, `Pays_idpays`) VALUES
('Casablanca', 1, 1),
('Marrakech', 2, 1),
('Agadir', 3, 1),
('Fès', 4, 1),
('Tanger', 5, 1),
('Salé', 6, 1),
('Nador', 7, 1),
('Oujda', 8, 1),
('Dakhla', 9, 1),
('Laayoune', 10, 1),
('Ouarzazate', 11, 1),
('Essaouira', 12, 1),
('Al Hoceima', 13, 1),
('Paris', 14, 2),
('Nice', 15, 2),
('Marseille', 16, 2),
('Lyon', 17, 2),
('Toulouse', 18, 2),
('Mulhouse', 19, 2),
('Montpellier', 20, 2),
('Grenoble', 21, 2),
('Cannes', 22, 2),
('Nantes', 23, 2),
('Francfort', 24, 3),
('Munich', 25, 3),
('Düsseldorf', 26, 3),
('berlin', 27, 3),
('Rome', 28, 4),
('milan', 29, 4),
('Pise', 30, 4),
('Genève', 31, 5),
('Madrid', 32, 6),
('Stockholm', 33, 7),
('Athènes', 34, 8),
('Varsovie', 35, 9),
('Bruxelles', 36, 10),
('Dublin', 37, 12),
('Helsinki', 38, 13),
('oslo', 39, 14),
('Gudja', 40, 15),
('Zagreb', 41, 16),
('Kaunas', 42, 17),
('Sandweiler', 43, 18),
('Amsterdam', 44, 19),
('Tirana', 45, 20);

-- --------------------------------------------------------

--
-- Structure de la table `vol`
--

DROP TABLE IF EXISTS `vol`;
CREATE TABLE IF NOT EXISTS `vol` (
  `idVol` int NOT NULL AUTO_INCREMENT,
  `dateDepart` date NOT NULL,
  `dateArrivee` date NOT NULL,
  `heureDepart` time NOT NULL,
  `heureArrivee` time NOT NULL,
  `price` decimal(12,4) NOT NULL,
  `Aeroport_idAeroportDepart` int NOT NULL,
  `Aeroport_idAeroportArrivee` int NOT NULL,
  `Cabine_idCabine` int NOT NULL,
  `isreservationavailable` int DEFAULT NULL,
  PRIMARY KEY (`idVol`),
  KEY `fk_Vol_Aeroport_idx` (`Aeroport_idAeroportDepart`),
  KEY `fk_Vol_Aeroport1_idx` (`Aeroport_idAeroportArrivee`),
  KEY `fk_Vol_Cabine1_idx` (`Cabine_idCabine`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `vol`
--

INSERT INTO `vol` (`idVol`, `dateDepart`, `dateArrivee`, `heureDepart`, `heureArrivee`, `price`, `Aeroport_idAeroportDepart`, `Aeroport_idAeroportArrivee`, `Cabine_idCabine`, `isreservationavailable`) VALUES
(1, '2021-02-28', '2021-02-28', '09:00:00', '11:45:00', '1628.0000', 6, 14, 3, 0),
(2, '2021-03-02', '2021-03-02', '17:00:00', '20:20:00', '2930.0000', 1, 36, 3, 0),
(3, '2021-03-02', '2021-03-02', '06:10:00', '07:25:00', '2971.0000', 2, 28, 1, 0),
(4, '2021-03-02', '2021-03-02', '15:00:00', '17:12:00', '2736.0000', 6, 14, 2, 0),
(5, '2021-03-17', '2021-03-17', '14:00:00', '16:36:00', '1543.0000', 4, 17, 3, 0),

(6, '2021-03-10', '2021-03-10', '08:35:00', '11:00:00', '2109.0000', 1, 16, 4, 0),
(7, '2021-03-12', '2021-03-12', '16:15:00', '17:00:00', '548.0000', 17, 22, 1, 0),
(8, '2021-03-13', '2021-03-13', '10:20:00', '12:55:00', '2071.0000', 7, 18, 2, 0),
(9, '2021-03-14', '2021-02-14', '14:05:00', '16:44:00', '945.0000', 37, 33, 4, 0),
(10, '2021-03-15', '2021-03-15', '13:00:00', '15:30:00', '887.0000', 29, 26, 3, 0),

(11, '2021-03-16', '2021-03-16', '07:15:00', '08:50:00', '1040.0000', 36, 32, 1, 0),
(12, '2021-03-17', '2021-03-18', '20:00:00', '01:30:00', '1732.0000', 39, 24, 4, 0),
(13, '2021-03-18', '2021-03-18', '19:20:00', '21:30:00', '1927.0000', 8, 15, 2, 0),
(14, '2021-03-19', '2021-03-19', '09:30:00', '13:05:00', '2104.0000', 28, 43, 2, 0),
(15, '2021-03-19', '2021-03-19', '11:40:00', '15:30:00', '2887.0000', 44, 38, 3, 0),

(16, '2021-03-20', '2021-03-20', '09:10:00', '12:05:00', '1628.0000', 6, 9, 3, 0),
(17, '2021-03-20', '2021-03-20', '17:00:00', '20:20:00', '2130.0000', 1, 14, 3, 0),
(18, '2021-03-20', '2021-03-21', '23:35:00', '01:55:00', '2971.0000', 24, 2, 1, 0),
(19, '2021-03-21', '2021-03-21', '14:00:00', '16:36:00', '1543.0000', 4, 34, 3, 0),
(20, '2021-03-21', '2021-03-21', '15:20:00', '18:12:00', '2736.0000', 8, 30, 2, 0),

(21, '2021-03-21', '2021-03-21', '16:00:00', '18:26:00', '1743.0000', 1, 10, 4, 0),
(22, '2021-03-21', '2021-03-21', '17:00:00', '16:36:00', '2308.0000', 6, 16, 1, 0),
(23, '2021-03-21', '2021-03-21', '18:00:00', '16:36:00', '2245.0000', 4, 17, 3, 0),
(24, '2021-03-21', '2021-03-21', '19:00:00', '16:36:00', '1860.0000', 1, 21, 4, 0),
(25, '2021-03-21', '2021-03-21', '10:00:00', '16:36:00', '1798.0000', 6, 22, 3, 0),
(26, '2021-03-21', '2021-03-21', '12:00:00', '16:36:00', '2369.4200', 8, 20, 1, 0),

(27, '2021-03-20', '2021-03-20', '15:00:00', '17:20:00', '2130.0000', 1, 14, 3, 0),
(28, '2021-03-20', '2021-03-20', '16:00:00', '18:30:00', '2030.0000', 1, 14, 3, 0),
(29, '2021-03-20', '2021-03-20', '17:00:00', '20:10:00', '2100.0000', 1, 14, 3, 0),
(30, '2021-03-20', '2021-03-20', '20:00:00', '22:20:00', '1930.0000', 1, 14, 3, 0),

(31, '2021-03-20', '2021-03-20', '08:00:00', '10:30:00', '2030.0000', 6, 14, 3, 0),
(32, '2021-03-20', '2021-03-20', '10:00:00', '12:20:00', '2250.0000', 6, 14, 3, 0),
(33, '2021-03-20', '2021-03-20', '11:30:00', '14:00:00', '2100.0000', 6, 14, 3, 0),
(34, '2021-03-20', '2021-03-20', '18:00:00', '20:15:00', '1800.0000', 6, 14, 3, 0),

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `aeroport`
--
ALTER TABLE `aeroport`
  ADD CONSTRAINT `fk_Aeroport_Ville1` FOREIGN KEY (`Ville_idVille`) REFERENCES `ville` (`idVille`);

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `fk_Reservation_Client1` FOREIGN KEY (`Client_idClient`) REFERENCES `client` (`idClient`),
  ADD CONSTRAINT `fk_Reservation_Vol1` FOREIGN KEY (`Vol_idVol`) REFERENCES `vol` (`idVol`);

--
-- Contraintes pour la table `ville`
--
ALTER TABLE `ville`
  ADD CONSTRAINT `fk_Ville_Pays1` FOREIGN KEY (`Pays_idpays`) REFERENCES `pays` (`idpays`);

--
-- Contraintes pour la table `vol`
--
ALTER TABLE `vol`
  ADD CONSTRAINT `fk_Vol_Aeroport` FOREIGN KEY (`Aeroport_idAeroportDepart`) REFERENCES `aeroport` (`idAeroport`),
  ADD CONSTRAINT `fk_Vol_Aeroport1` FOREIGN KEY (`Aeroport_idAeroportArrivee`) REFERENCES `aeroport` (`idAeroport`),
  ADD CONSTRAINT `fk_Vol_Cabine1` FOREIGN KEY (`Cabine_idCabine`) REFERENCES `cabine` (`idCabine`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
