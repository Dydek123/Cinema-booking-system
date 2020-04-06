/*
Navicat MySQL Data Transfer

Source Server         : Serwer pk
Source Server Version : 50554
Source Host           : 149.156.136.151:3306
Source Database       : miloszmomot

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2020-04-06 03:18:19
*/

SET FOREIGN_KEY_CHECKS=0;

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
