/*
Navicat MySQL Data Transfer

Source Server         : Serwer pk
Source Server Version : 50554
Source Host           : 149.156.136.151:3306
Source Database       : miloszmomot

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2020-04-06 03:18:04
*/

SET FOREIGN_KEY_CHECKS=0;

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
