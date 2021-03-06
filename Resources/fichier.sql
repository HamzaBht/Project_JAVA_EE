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
(1, '2021-02-28', '2021-02-28', '09:00:00', '11:45:00', '1628.0000', 6, 14, 4, 0),
(2, '2021-03-02', '2021-03-02', '17:00:00', '20:20:00', '2930.0000', 1, 36, 3, 0),
(3, '2021-03-02', '2021-03-02', '06:10:00', '07:25:00', '2971.0000', 2, 28, 1, 0),
(4, '2021-03-02', '2021-02-02', '15:00:00', '17:12:00', '2736.0000', 6, 14, 2, 0),
(5, '2021-03-17', '2021-03-17', '14:00:00', '16:36:00', '1543.0000', 4, 17, 3, 0);

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
