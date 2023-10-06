/*
SQLyog Community v13.1.9 (64 bit)
MySQL - 10.4.25-MariaDB : Database - rajacki
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rajacki` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `rajacki`;

/*Table structure for table `administrator` */

DROP TABLE IF EXISTS `administrator`;

CREATE TABLE `administrator` (
  `AdministratorID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `Ime` varchar(30) NOT NULL,
  `Prezime` varchar(30) NOT NULL,
  `Username` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  PRIMARY KEY (`AdministratorID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `clanklase` */

DROP TABLE IF EXISTS `clanklase`;

CREATE TABLE `clanklase` (
  `KlasaID` bigint(10) unsigned NOT NULL,
  `RbClana` int(7) NOT NULL,
  `Napomena` varchar(70) NOT NULL,
  `PolaznikID` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`KlasaID`,`RbClana`),
  KEY `fk_polaznik_id` (`PolaznikID`),
  CONSTRAINT `fk_klase_id` FOREIGN KEY (`KlasaID`) REFERENCES `klasa` (`KlasaID`),
  CONSTRAINT `fk_polaznik_id` FOREIGN KEY (`PolaznikID`) REFERENCES `polaznik` (`PolaznikID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `kategorija` */

DROP TABLE IF EXISTS `kategorija`;

CREATE TABLE `kategorija` (
  `KategorijaID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `NazivKategorije` varchar(30) NOT NULL,
  `OpisKategorije` varchar(255) NOT NULL,
  PRIMARY KEY (`KategorijaID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `klasa` */

DROP TABLE IF EXISTS `klasa`;

CREATE TABLE `klasa` (
  `KlasaID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `NazivKlase` varchar(30) NOT NULL,
  `OpisKlase` varchar(255) NOT NULL,
  `BrojPolaznika` int(7) NOT NULL,
  `KategorijaID` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`KlasaID`),
  KEY `fk_kategorija2_id` (`KategorijaID`),
  CONSTRAINT `fk_kategorija2_id` FOREIGN KEY (`KategorijaID`) REFERENCES `kategorija` (`KategorijaID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `polaznik` */

DROP TABLE IF EXISTS `polaznik`;

CREATE TABLE `polaznik` (
  `PolaznikID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `ImePolaznika` varchar(30) NOT NULL,
  `PrezimePolaznika` varchar(30) NOT NULL,
  `Pol` varchar(30) NOT NULL,
  `Godine` int(7) NOT NULL,
  `KontaktTelefon` varchar(50) NOT NULL,
  `KategorijaID` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`PolaznikID`),
  KEY `fk_kategorija_id` (`KategorijaID`),
  CONSTRAINT `fk_kategorija_id` FOREIGN KEY (`KategorijaID`) REFERENCES `kategorija` (`KategorijaID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
