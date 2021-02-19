-- MySQL Script generated by MySQL Workbench
-- Fri Feb 19 19:09:22 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Pays`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pays` (
  `nom` VARCHAR(45) NULL,
  `idpays` INT NOT NULL,
  PRIMARY KEY (`idpays`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Ville`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Ville` (
  `nom` VARCHAR(45) NULL,
  `idVille` INT NOT NULL,
  `Pays_idpays` INT NOT NULL,
  PRIMARY KEY (`idVille`),
  INDEX `fk_Ville_Pays1_idx` (`Pays_idpays` ASC) VISIBLE,
  CONSTRAINT `fk_Ville_Pays1`
    FOREIGN KEY (`Pays_idpays`)
    REFERENCES `mydb`.`Pays` (`idpays`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Aeroport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Aeroport` (
  `idAeroport` INT NOT NULL,
  `nom` VARCHAR(45) NULL,
  `Ville_idVille` INT NOT NULL,
  PRIMARY KEY (`idAeroport`),
  INDEX `fk_Aeroport_Ville1_idx` (`Ville_idVille` ASC) VISIBLE,
  CONSTRAINT `fk_Aeroport_Ville1`
    FOREIGN KEY (`Ville_idVille`)
    REFERENCES `mydb`.`Ville` (`idVille`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cabine`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cabine` (
  `typeCabine` VARCHAR(45) NOT NULL,
  `Capacite` INT NULL,
  `idCabine` INT NOT NULL,
  PRIMARY KEY (`idCabine`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Vol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Vol` (
  `idVol` INT NOT NULL,
  `dateDepart` DATE NOT NULL,
  `dateArrivee` DATE NOT NULL,
  `heureDepart` TIME NOT NULL,
  `heureArrivee` TIME NOT NULL,
  `price` DECIMAL(12,4) NOT NULL,
  `Aeroport_idAeroportDepart` INT NOT NULL,
  `Aeroport_idAeroportArrivee` INT NOT NULL,
  `Cabine_idCabine` INT NOT NULL,
  PRIMARY KEY (`idVol`),
  INDEX `fk_Vol_Aeroport_idx` (`Aeroport_idAeroportDepart` ASC) VISIBLE,
  INDEX `fk_Vol_Aeroport1_idx` (`Aeroport_idAeroportArrivee` ASC) VISIBLE,
  INDEX `fk_Vol_Cabine1_idx` (`Cabine_idCabine` ASC) VISIBLE,
  CONSTRAINT `fk_Vol_Aeroport`
    FOREIGN KEY (`Aeroport_idAeroportDepart`)
    REFERENCES `mydb`.`Aeroport` (`idAeroport`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vol_Aeroport1`
    FOREIGN KEY (`Aeroport_idAeroportArrivee`)
    REFERENCES `mydb`.`Aeroport` (`idAeroport`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vol_Cabine1`
    FOREIGN KEY (`Cabine_idCabine`)
    REFERENCES `mydb`.`Cabine` (`idCabine`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Client` (
  `idClient` INT NOT NULL,
  `nom` VARCHAR(45) NULL,
  `numeroPassport` VARCHAR(45) NULL,
  PRIMARY KEY (`idClient`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Reservation` (
  `idReservation` INT NOT NULL,
  `dateReservation` VARCHAR(45) NULL,
  `heureReservation` VARCHAR(45) NULL,
  `Vol_idVol` INT NOT NULL,
  `Client_idClient` INT NOT NULL,
  PRIMARY KEY (`idReservation`),
  INDEX `fk_Reservation_Vol1_idx` (`Vol_idVol` ASC) VISIBLE,
  INDEX `fk_Reservation_Client1_idx` (`Client_idClient` ASC) VISIBLE,
  CONSTRAINT `fk_Reservation_Vol1`
    FOREIGN KEY (`Vol_idVol`)
    REFERENCES `mydb`.`Vol` (`idVol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reservation_Client1`
    FOREIGN KEY (`Client_idClient`)
    REFERENCES `mydb`.`Client` (`idClient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
