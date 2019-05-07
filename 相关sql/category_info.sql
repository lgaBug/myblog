/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50524
Source Host           : localhost:3306
Source Database       : myblog

Target Server Type    : MYSQL
Target Server Version : 50524
File Encoding         : 65001

Date: 2019-05-07 22:22:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `category_info`
-- ----------------------------
DROP TABLE IF EXISTS `category_info`;
CREATE TABLE `category_info` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(100) NOT NULL,
  `category_alias` varchar(100) NOT NULL,
  `category_desc` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='��Ŀ��Ϣ��';

-- ----------------------------
-- Records of category_info
-- ----------------------------
INSERT INTO `category_info` VALUES ('1', 'java基础', 'java', '该栏目包含了，java基础部分');
INSERT INTO `category_info` VALUES ('3', '数据库', 'sql', 'mysql,oracle');
INSERT INTO `category_info` VALUES ('5', '架构师', 'jiagoushi', '包含了架构师需要学习的部分');
INSERT INTO `category_info` VALUES ('19', 'spring', 'spring', 'spring学习');
INSERT INTO `category_info` VALUES ('20', '日常工具', 'utils', 'java开发需要用到的一些工具');
