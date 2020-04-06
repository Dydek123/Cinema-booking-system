/*
Navicat MySQL Data Transfer

Source Server         : Serwer pk
Source Server Version : 50554
Source Host           : 149.156.136.151:3306
Source Database       : miloszmomot

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2020-04-06 03:17:56
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
