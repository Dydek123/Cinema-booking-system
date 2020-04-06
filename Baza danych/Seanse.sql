/*
Navicat MySQL Data Transfer

Source Server         : Serwer pk
Source Server Version : 50554
Source Host           : 149.156.136.151:3306
Source Database       : miloszmomot

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2020-04-06 03:18:34
*/

SET FOREIGN_KEY_CHECKS=0;

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
