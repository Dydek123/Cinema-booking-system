/*
Navicat MySQL Data Transfer

Source Server         : Serwer pk
Source Server Version : 50554
Source Host           : 149.156.136.151:3306
Source Database       : miloszmomot

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2020-04-06 03:18:25
*/

SET FOREIGN_KEY_CHECKS=0;

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
