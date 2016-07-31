/*
Navicat MySQL Data Transfer

Source Server         : localhost-mysql
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : fast4j

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-07-31 17:35:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` varchar(50) NOT NULL COMMENT '日志id',
  `operation_type` varchar(255) DEFAULT NULL COMMENT '操作类型',
  `table` varchar(255) DEFAULT NULL COMMENT '操作的表',
  `type` varchar(255) DEFAULT NULL COMMENT '日志类型',
  `create_date` datetime NOT NULL COMMENT '日志发生时间',
  `src_data` tinytext COMMENT '源数据',
  `dest_data` tinytext COMMENT '目标数据',
  `desc` varchar(255) DEFAULT NULL COMMENT '描述信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志表';

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('1d0d190f23df4cc095194d000d06a845', 'insertSelective', null, null, '2016-07-28 12:53:26', '[{\"code\":\"user:created\",\"id\":\"f1ad5add2f8044b1b0fcfccd32b741f1\",\"name\":\"创建用户\"}]', 'null', null);
INSERT INTO `log` VALUES ('2fe7e051266541b58986eb088b332de7', 'updateByPrimaryKeySelective', null, null, '2016-07-28 12:54:07', '{\"code\":\"user:created\",\"id\":\"f1ad5add2f8044b1b0fcfccd32b741f1\",\"name\":\"创建用户\"}', '[{\"code\":\"user:create\",\"id\":\"f1ad5add2f8044b1b0fcfccd32b741f1\",\"name\":\"创建用户\"}]', null);
INSERT INTO `log` VALUES ('383a244e4e414a329d22bc0d18c25e74', 'insertSelective', null, null, '2016-07-28 12:52:59', '[{\"code\":\"user:select\",\"id\":\"5aad1b1537bb48d5a1052c6a84b28380\",\"name\":\"查询用户\"}]', 'null', null);
INSERT INTO `log` VALUES ('38b0a256e2a148f6bb91780048b1d169', 'insertSelective', null, null, '2016-07-29 15:52:25', '[{\"createdAt\":1469778744842,\"email\":\"1136765101@qq.com\",\"id\":\"a007debf8d7c47f89a33dfc2c345e7a4\",\"password\":\"45b940b92698c93fcb3c0924f0af2552\",\"phone\":\"18288631295\",\"userName\":\"syj\"}]', 'null', null);
INSERT INTO `log` VALUES ('3feff7258f4d4973b2666159bf989592', 'deleteByPrimaryKey', null, null, '2016-07-28 12:54:56', '{\"code\":\"user:create\",\"id\":\"f1ad5add2f8044b1b0fcfccd32b741f1\",\"name\":\"创建用户\"}', '[\"f1ad5add2f8044b1b0fcfccd32b741f1\"]', null);
INSERT INTO `log` VALUES ('4cc5023d8177464a94f0b7e805b7d8ea', 'insertSelective', null, null, '2016-07-29 15:33:40', '[{\"createdAt\":1469777619578,\"id\":\"27db6cac190a410eb571dd386139e1a3\",\"password\":\"c4ca4238a0b923820dcc509a6f75849b\",\"userName\":\"wsy\"}]', 'null', null);
INSERT INTO `log` VALUES ('51c42f9fa75249ad85578c0cda5188ac', 'insertSelective', null, null, '2016-07-28 12:53:05', '[{\"code\":\"user:delete\",\"id\":\"dbc7770c1a64450c83babecb2c1736b9\",\"name\":\"删除用户\"}]', 'null', null);
INSERT INTO `log` VALUES ('98fadd7229ef47009437911bb9d77d9e', 'deleteByPrimaryKey', null, null, '2016-07-28 12:55:37', '{\"code\":\"user:delete\",\"id\":\"dbc7770c1a64450c83babecb2c1736b9\",\"name\":\"删除用户\"}', '[\"dbc7770c1a64450c83babecb2c1736b9\"]', null);
INSERT INTO `log` VALUES ('c535072f13ec40879f0bdaf506b7e60d', 'insertSelective', null, null, '2016-07-29 15:54:27', '[{\"createdAt\":1469778866910,\"email\":\"11367651011@qq.com\",\"id\":\"95f3b97b46524ea7b3c257a2ef1927b8\",\"password\":\"c81e728d9d4c2f636f067f89cc14862c\",\"phone\":\"18288631296\",\"userName\":\"syj1\"}]', 'null', null);
INSERT INTO `log` VALUES ('ff8f739ea57f4630a06371081f6d67c6', 'insertSelective', null, null, '2016-07-29 15:34:19', '[{\"createdAt\":1469777658571,\"id\":\"399e1e735afd438b9b35f2c084d54985\",\"password\":\"c4ca4238a0b923820dcc509a6f75849b\",\"userName\":\"wsy\"}]', 'null', null);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` varchar(50) NOT NULL COMMENT '权限id',
  `name` varchar(50) DEFAULT NULL COMMENT '权限名字',
  `permission_sign` varchar(50) DEFAULT NULL COMMENT '权限编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('5aad1b1537bb48d5a1052c6a84b28380', '查询用户', 'user:select');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(50) NOT NULL COMMENT '角色id',
  `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `role_sign` varchar(100) DEFAULT NULL COMMENT '签名',
  `parent` varchar(50) DEFAULT NULL COMMENT '父角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` varchar(50) NOT NULL COMMENT '关系id',
  `role_id` varchar(50) NOT NULL COMMENT '角色id',
  `permission_id` varchar(50) NOT NULL COMMENT '权限id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限id';

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(80) DEFAULT NULL COMMENT '密码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `auth_data` tinytext COMMENT '授权信息',
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX` (`user_name`,`email`,`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('27db6cac190a410eb571dd386139e1a3', 'wsy', 'c4ca4238a0b923820dcc509a6f75849b', '1104237534@qq.com', '15969595727', null, '2016-07-29 15:33:40', null);
INSERT INTO `user` VALUES ('95f3b97b46524ea7b3c257a2ef1927b8', 'syj1', 'c81e728d9d4c2f636f067f89cc14862c', '11367651011@qq.com', '18288631296', null, '2016-07-29 15:54:27', null);
INSERT INTO `user` VALUES ('a007debf8d7c47f89a33dfc2c345e7a4', 'syj', '45b940b92698c93fcb3c0924f0af2552', '1136765101@qq.com', '18288631295', null, '2016-07-29 15:52:25', null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` varchar(50) NOT NULL COMMENT '关系id',
  `user_id` varchar(50) NOT NULL COMMENT '用户id',
  `role_id` varchar(50) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
