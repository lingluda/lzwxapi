/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2018-01-09 17:45:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `manager_user`
-- ----------------------------
DROP TABLE IF EXISTS `manager_user`;
CREATE TABLE `manager_user` (
  `id` varchar(32) CHARACTER SET utf8mb4 NOT NULL,
  `user_name` varchar(200) NOT NULL COMMENT '登录用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `real_name` varchar(50) DEFAULT NULL COMMENT '真是姓名',
  `phone_no` varchar(50) DEFAULT NULL COMMENT '联系号码',
  `email` varchar(50) DEFAULT NULL COMMENT '邮件地址',
  `dept_no` varchar(32) NOT NULL COMMENT '系部代码',
  `type` int(2) NOT NULL COMMENT '用户类型,学生和教师',
  `nickname` varchar(100) DEFAULT NULL COMMENT '昵称',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of manager_user
-- ----------------------------
INSERT INTO `manager_user` VALUES ('1', 'admin', 'E10ADC3949BA59ABBE56E057F20F883E', 'admin', '123456789111', 'admin@mbase.com', '1001', '1', '系统超级管理员', '1', '2016-04-20 17:29:00');
INSERT INTO `manager_user` VALUES ('4efe5be7aa3542248706b8d951a1374c', '1001010101', 'E10ADC3949BA59ABBE56E057F20F883E', '信息学生1', '', '', '1001', '0', '学生1', '1', '2017-11-15 16:34:49');
INSERT INTO `manager_user` VALUES ('52de586659b64187b261a7b83255c625', '10011002', 'E10ADC3949BA59ABBE56E057F20F883E', '信息2', '13977161545', '12@qq.com', '1001', '1', '信息2', '1', '2017-11-22 18:10:54');
INSERT INTO `manager_user` VALUES ('680e2cc23c77415b91e99bb10349cfdd', '10011001', 'E10ADC3949BA59ABBE56E057F20F883E', '信息1', '13977161545', '12@ww.com', '1001', '1', '信息1', '1', '2017-11-22 18:08:28');
INSERT INTO `manager_user` VALUES ('973472c2dee14fa5849ee31245fe3098', '1001010102', 'E10ADC3949BA59ABBE56E057F20F883E', '学生2', '13878451245', '12121@qq.com', '1001', '0', '学生2', '1', '2017-11-22 18:12:17');
INSERT INTO `manager_user` VALUES ('f5d91f56037a4df4a570904b6dedae39', '10011003', 'E10ADC3949BA59ABBE56E057F20F883E', '信息3', '10011003', '12212@eee.com', '1001', '1', '信息3', '1', '2017-11-22 18:14:41');


DROP TABLE IF EXISTS `manager_task_info`;
CREATE TABLE `manager_task_info` (
  `id` varchar(32) NOT NULL,
  `task_name` varchar(200) DEFAULT NULL,
  `task_group` varchar(200) DEFAULT NULL,
  `cls_name` varchar(200) DEFAULT NULL,
  `express` varchar(100) DEFAULT NULL,
  `remark` longtext,
  `status` int(2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of manager_task_info
-- ----------------------------
INSERT INTO `manager_task_info` VALUES ('1', 'testJob', 'testJob', 'com.maiyue.weixin.test.TestJob', '0/20 * * * * ?', null, '1', '2018-01-16 16:51:45');