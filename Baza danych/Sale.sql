/*
Navicat MySQL Data Transfer

Source Server         : Serwer pk
Source Server Version : 50554
Source Host           : 149.156.136.151:3306
Source Database       : miloszmomot

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2020-04-06 03:18:31
*/

SET FOREIGN_KEY_CHECKS=0;

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
