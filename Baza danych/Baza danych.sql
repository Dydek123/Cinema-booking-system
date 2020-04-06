/*
Navicat MySQL Data Transfer

Source Server         : Serwer pk
Source Server Version : 50554
Source Host           : 149.156.136.151:3306
Source Database       : miloszmomot

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2020-04-06 19:32:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `Bilety`
-- ----------------------------
DROP TABLE IF EXISTS `Bilety`;
CREATE TABLE `Bilety` (
  `ID_bilety` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Cena_biletu` decimal(11,2) NOT NULL,
  `Rodzaj` varchar(250) NOT NULL,
  PRIMARY KEY (`ID_bilety`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Bilety
-- ----------------------------
INSERT INTO `Bilety` VALUES ('1', '15.50', 'Ulgowy');
INSERT INTO `Bilety` VALUES ('2', '23.00', 'Zwykły');
INSERT INTO `Bilety` VALUES ('3', '23.00', 'Zwykły');

-- ----------------------------
-- Table structure for `Filmy`
-- ----------------------------
DROP TABLE IF EXISTS `Filmy`;
CREATE TABLE `Filmy` (
  `ID_filmy` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Tytul` varchar(250) NOT NULL,
  `ID_rezyserzy` int(11) unsigned NOT NULL,
  `ID_gatunki` int(11) unsigned NOT NULL,
  `Ocena` decimal(4,2) NOT NULL,
  `Czas_trwania` varchar(8) NOT NULL,
  `Rok_produkcji` year(4) NOT NULL,
  `Opis` text,
  `Zwiastun` varchar(250) DEFAULT '',
  PRIMARY KEY (`ID_filmy`),
  KEY `ID_rezyserzy` (`ID_rezyserzy`),
  KEY `ID_gatunki` (`ID_gatunki`),
  CONSTRAINT `ID_gatunki` FOREIGN KEY (`ID_gatunki`) REFERENCES `Gatunki` (`ID_gatunki`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ID_rezyserzy` FOREIGN KEY (`ID_rezyserzy`) REFERENCES `Rezyserzy` (`ID_rezyserzy`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Filmy
-- ----------------------------
INSERT INTO `Filmy` VALUES ('1', 'Jojo Rabit', '1', '1', '7.80', '1:48:00', '2019', 'Młody Niemiec Jojo, członek nazistowskiej organizacji dla młodzieży Jungvolk, pomaga Żydówce. Jednocześnie próbuje pozostać nazistą.', 'https://www.youtube.com/watch?v=bgMb4iikhSs');
INSERT INTO `Filmy` VALUES ('2', 'Żółty szalik', '2', '2', '7.70', '0:59:00', '2000', 'Szanowany dyrektor firmy od lat zmaga się z nałogiem alkoholowym.', 'https://www.youtube.com/watch?v=ccMj0mTrQqk');
INSERT INTO `Filmy` VALUES ('3', 'AlphaGo', '3', '3', '7.60', '1:30:00', '2017', 'Starochińska gra planszowa Go od lat była wielkim wyzwaniem dla sztucznej inteligencji. Wydawało się, że opanowanie gry przez maszynę jest niemożliwe. Jednak w 2016 roku zespół DeepMind firmy Google ogłosił, że stworzona przez nich sztuczna inteligencja do gry w Go – AlphaGo – zmierzy się z jednym z najlepszych mistrzów na świecie, Lee Sedolem. Dokument jest zapisem pracy zespołu DeepMind podczas testowania ograniczeń rozwijającej się w zawrotnym tempie sztucznej inteligencji, spojrzeniem na jej przyszłość oraz wglądem w zasady działania ludzkiego umysłu. Fascynujący dokument sportowy.', 'https://www.youtube.com/watch?v=8tq1C8spV_g');

-- ----------------------------
-- Table structure for `Gatunki`
-- ----------------------------
DROP TABLE IF EXISTS `Gatunki`;
CREATE TABLE `Gatunki` (
  `ID_gatunki` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Nazwa_gatunku` varchar(250) NOT NULL,
  PRIMARY KEY (`ID_gatunki`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Gatunki
-- ----------------------------
INSERT INTO `Gatunki` VALUES ('1', 'Wojenny');
INSERT INTO `Gatunki` VALUES ('2', 'Dramat');
INSERT INTO `Gatunki` VALUES ('3', 'Dokumentalny');

-- ----------------------------
-- Table structure for `Rezerwacje`
-- ----------------------------
DROP TABLE IF EXISTS `Rezerwacje`;
CREATE TABLE `Rezerwacje` (
  `ID_rezerwacje` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ID_uzytkownicy` int(11) unsigned NOT NULL,
  `ID_seanse` int(11) unsigned NOT NULL,
  `Rzad` int(3) NOT NULL,
  `Miejsce` int(4) NOT NULL,
  PRIMARY KEY (`ID_rezerwacje`),
  KEY `ID_uzytkownicy` (`ID_uzytkownicy`),
  KEY `ID_seanse` (`ID_seanse`),
  CONSTRAINT `ID_seanse` FOREIGN KEY (`ID_seanse`) REFERENCES `Seanse` (`ID_seanse`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ID_uzytkownicy` FOREIGN KEY (`ID_uzytkownicy`) REFERENCES `Uzytkownicy` (`ID_uzytkownicy`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Rezerwacje
-- ----------------------------
INSERT INTO `Rezerwacje` VALUES ('1', '5', '1', '3', '10');
INSERT INTO `Rezerwacje` VALUES ('2', '2', '3', '2', '5');
INSERT INTO `Rezerwacje` VALUES ('4', '1', '6', '1', '7');

-- ----------------------------
-- Table structure for `Rezyserzy`
-- ----------------------------
DROP TABLE IF EXISTS `Rezyserzy`;
CREATE TABLE `Rezyserzy` (
  `ID_rezyserzy` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Imie_rezysera` varchar(250) NOT NULL,
  `Nazwisko_rezysera` varchar(250) NOT NULL,
  PRIMARY KEY (`ID_rezyserzy`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Rezyserzy
-- ----------------------------
INSERT INTO `Rezyserzy` VALUES ('1', 'Taika', 'Waititi');
INSERT INTO `Rezyserzy` VALUES ('2', 'Janusz', 'Morgenstern');
INSERT INTO `Rezyserzy` VALUES ('3', 'Greg', 'Kohs');

-- ----------------------------
-- Table structure for `Sale`
-- ----------------------------
DROP TABLE IF EXISTS `Sale`;
CREATE TABLE `Sale` (
  `ID_sale` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Numer` int(3) NOT NULL,
  `Liczba_miejsc` int(4) NOT NULL,
  PRIMARY KEY (`ID_sale`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Sale
-- ----------------------------
INSERT INTO `Sale` VALUES ('1', '1', '40');
INSERT INTO `Sale` VALUES ('2', '2', '80');
INSERT INTO `Sale` VALUES ('3', '3', '120');

-- ----------------------------
-- Table structure for `Seanse`
-- ----------------------------
DROP TABLE IF EXISTS `Seanse`;
CREATE TABLE `Seanse` (
  `ID_seanse` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ID_sale` int(11) unsigned NOT NULL,
  `ID_filmy` int(11) unsigned NOT NULL,
  `Data_seansu` date NOT NULL,
  `Godzina_seansu` time NOT NULL,
  PRIMARY KEY (`ID_seanse`),
  KEY `ID_sale` (`ID_sale`),
  KEY `ID_filmy` (`ID_filmy`),
  CONSTRAINT `ID_filmy` FOREIGN KEY (`ID_filmy`) REFERENCES `Filmy` (`ID_filmy`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ID_sale` FOREIGN KEY (`ID_sale`) REFERENCES `Sale` (`ID_sale`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Seanse
-- ----------------------------
INSERT INTO `Seanse` VALUES ('1', '1', '3', '2020-04-10', '18:15:00');
INSERT INTO `Seanse` VALUES ('3', '3', '2', '2020-04-13', '16:00:00');
INSERT INTO `Seanse` VALUES ('6', '1', '3', '2020-04-15', '20:30:00');

-- ----------------------------
-- Table structure for `Uzytkownicy`
-- ----------------------------
DROP TABLE IF EXISTS `Uzytkownicy`;
CREATE TABLE `Uzytkownicy` (
  `ID_uzytkownicy` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Login` varchar(250) NOT NULL,
  `Haslo` varchar(250) NOT NULL,
  `Email` varchar(250) NOT NULL,
  `Imie_uzytkownika` varchar(250) NOT NULL,
  `Nazwisko_uzytkownika` varchar(250) NOT NULL,
  `Wiek` int(3) NOT NULL,
  `Telefon` varchar(20) NOT NULL,
  `Zgoda_marketingowa` bit(1) NOT NULL,
  PRIMARY KEY (`ID_uzytkownicy`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Uzytkownicy
-- ----------------------------
INSERT INTO `Uzytkownicy` VALUES ('1', 'dzbanek', 'NoweHaslo123', 'dzbanek10@gmail.com', 'Tadeusz', 'Dzbankiewicz', '25', '+48101202303', '');
INSERT INTO `Uzytkownicy` VALUES ('2', 'koval', 'qwerty123', 'nowyemail@gmail.com', 'Marian', 'Kowalski', '49', '+48111222333', '');
INSERT INTO `Uzytkownicy` VALUES ('5', 'pirat', 'MocneHaslo$123', 'piotrekmatuszewski@gmail.com', 'Piotrek', 'Matuszewski', '15', '+48123456789', '');

-- ----------------------------
-- Table structure for `Zakupy`
-- ----------------------------
DROP TABLE IF EXISTS `Zakupy`;
CREATE TABLE `Zakupy` (
  `ID_zakupy` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ID_bilety` int(11) unsigned NOT NULL,
  `ID_rezerwacje` int(11) unsigned NOT NULL,
  `Data_zakupu` date NOT NULL,
  PRIMARY KEY (`ID_zakupy`),
  KEY `ID_bilety` (`ID_bilety`),
  KEY `ID_rezerwacje` (`ID_rezerwacje`),
  CONSTRAINT `ID_rezerwacje` FOREIGN KEY (`ID_rezerwacje`) REFERENCES `Rezerwacje` (`ID_rezerwacje`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ID_bilety` FOREIGN KEY (`ID_bilety`) REFERENCES `Bilety` (`ID_bilety`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Zakupy
-- ----------------------------
INSERT INTO `Zakupy` VALUES ('1', '1', '1', '2020-04-06');
INSERT INTO `Zakupy` VALUES ('2', '2', '2', '2020-04-07');
