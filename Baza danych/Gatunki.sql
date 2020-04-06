/*
Navicat MySQL Data Transfer

Source Server         : Serwer pk
Source Server Version : 50554
Source Host           : 149.156.136.151:3306
Source Database       : miloszmomot

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2020-04-06 03:18:10
*/

SET FOREIGN_KEY_CHECKS=0;

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
