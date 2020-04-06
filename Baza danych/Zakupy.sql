/*
Navicat MySQL Data Transfer

Source Server         : Serwer pk
Source Server Version : 50554
Source Host           : 149.156.136.151:3306
Source Database       : miloszmomot

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2020-04-06 03:18:43
*/

SET FOREIGN_KEY_CHECKS=0;

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
