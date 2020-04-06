/*
Navicat MySQL Data Transfer

Source Server         : Serwer pk
Source Server Version : 50554
Source Host           : 149.156.136.151:3306
Source Database       : miloszmomot

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2020-04-06 03:18:39
*/

SET FOREIGN_KEY_CHECKS=0;

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
