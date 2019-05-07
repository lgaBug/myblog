/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50524
Source Host           : localhost:3306
Source Database       : myblog

Target Server Type    : MYSQL
Target Server Version : 50524
File Encoding         : 65001

Date: 2019-05-07 22:22:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `message_info`
-- ----------------------------
DROP TABLE IF EXISTS `message_info`;
CREATE TABLE `message_info` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_content` varchar(2000) DEFAULT NULL,
  `message_time` datetime DEFAULT NULL,
  `message_name` varchar(1000) DEFAULT NULL,
  `message_mark` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message_info
-- ----------------------------
INSERT INTO `message_info` VALUES ('1', null, '2019-05-04 00:00:00', null, '1');
INSERT INTO `message_info` VALUES ('2', '系统很好！！继续加油。。。。。。。。。。。。。。。1111111111', '2019-05-04 00:00:00', '王五', '1');
INSERT INTO `message_info` VALUES ('3', '在线留言功能不错，加油。。。。。。。。。。。。。。。。。。。。。。。。。。。。', '2019-05-04 00:00:00', '王五', '1');

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL,
  `user_phone` varchar(100) DEFAULT NULL,
  `user_account` varchar(100) NOT NULL,
  `user_password` varchar(100) NOT NULL,
  `user_mark` varchar(10) DEFAULT NULL COMMENT '-1 ',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_account` (`user_account`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '刘高安(修改)', '18270230947', 'lga', 'admin', '1');
INSERT INTO `user_info` VALUES ('2', '吴蕾', '15979900603', 'wl', 'admin', '1');
INSERT INTO `user_info` VALUES ('3', '张三', '18412312312', 'zs', 'admin', '1');
INSERT INTO `user_info` VALUES ('4', '李四', '18221321313', 'ls', 'admin', '1');
INSERT INTO `user_info` VALUES ('5', '王五', '12303123131', 'ww', 'admin', '1');
INSERT INTO `user_info` VALUES ('8', '留恋', '1283719381', 'll', 'admin', '1');
