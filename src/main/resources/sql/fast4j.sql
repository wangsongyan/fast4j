/*
Navicat MySQL Data Transfer

Source Server         : localhost-mysql
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : fast4j

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-08-28 22:40:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `id` varchar(50) NOT NULL COMMENT 'class的id',
  `calss_name` varchar(255) DEFAULT NULL COMMENT '类名',
  `job_desc` varchar(255) DEFAULT NULL COMMENT '任务描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES ('6b0d4360620a48c49a31760032916371', 'cn.wangsy.fast4j.web.quartz.QuartzJobFactory', '测试');
INSERT INTO `job` VALUES ('883b207c8ba040a48ea9852fba668b6f', 'cn.wangsy.fast4j.web.quartz.QuartzJobFactory', null);
INSERT INTO `job` VALUES ('8d4a4a67b8264903bae934ffd2451e5b', 'cn.wangsy.fast4j.web.quartz.FileScanJob', '文件扫描');
INSERT INTO `job` VALUES ('9620da51eb6f4c89813541e390831aa3', 'cn.wangsy.fast4j.web.quartz.QuartzJobFactory', null);
INSERT INTO `job` VALUES ('ad39b879e8a14cadbc89b0b61e2ea7f7', 'cn.wangsy.fast4j.web.quartz.QuartzJobFactory', null);

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
  `description` varchar(255) DEFAULT NULL COMMENT '描述信息',
  `content` tinytext COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志表';

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('1797207f23884b10b0317e600114e557', '查询', null, null, '2016-08-09 15:31:58', null, null, '查询任务列表', null);
INSERT INTO `log` VALUES ('1d0d190f23df4cc095194d000d06a845', 'insertSelective', null, null, '2016-07-28 12:53:26', '[{\"code\":\"user:created\",\"id\":\"f1ad5add2f8044b1b0fcfccd32b741f1\",\"name\":\"创建用户\"}]', 'null', null, null);
INSERT INTO `log` VALUES ('2fe7e051266541b58986eb088b332de7', 'updateByPrimaryKeySelective', null, null, '2016-07-28 12:54:07', '{\"code\":\"user:created\",\"id\":\"f1ad5add2f8044b1b0fcfccd32b741f1\",\"name\":\"创建用户\"}', '[{\"code\":\"user:create\",\"id\":\"f1ad5add2f8044b1b0fcfccd32b741f1\",\"name\":\"创建用户\"}]', null, null);
INSERT INTO `log` VALUES ('383a244e4e414a329d22bc0d18c25e74', 'insertSelective', null, null, '2016-07-28 12:52:59', '[{\"code\":\"user:select\",\"id\":\"5aad1b1537bb48d5a1052c6a84b28380\",\"name\":\"查询用户\"}]', 'null', null, null);
INSERT INTO `log` VALUES ('38b0a256e2a148f6bb91780048b1d169', 'insertSelective', null, null, '2016-07-29 15:52:25', '[{\"createdAt\":1469778744842,\"email\":\"1136765101@qq.com\",\"id\":\"a007debf8d7c47f89a33dfc2c345e7a4\",\"password\":\"45b940b92698c93fcb3c0924f0af2552\",\"phone\":\"18288631295\",\"userName\":\"syj\"}]', 'null', null, null);
INSERT INTO `log` VALUES ('3feff7258f4d4973b2666159bf989592', 'deleteByPrimaryKey', null, null, '2016-07-28 12:54:56', '{\"code\":\"user:create\",\"id\":\"f1ad5add2f8044b1b0fcfccd32b741f1\",\"name\":\"创建用户\"}', '[\"f1ad5add2f8044b1b0fcfccd32b741f1\"]', null, null);
INSERT INTO `log` VALUES ('4cc5023d8177464a94f0b7e805b7d8ea', 'insertSelective', null, null, '2016-07-29 15:33:40', '[{\"createdAt\":1469777619578,\"id\":\"27db6cac190a410eb571dd386139e1a3\",\"password\":\"c4ca4238a0b923820dcc509a6f75849b\",\"userName\":\"wsy\"}]', 'null', null, null);
INSERT INTO `log` VALUES ('4cd8d500b2944ca2ab4c36a229a4f7d5', '查询', null, null, '2016-08-05 13:15:08', null, null, '查询任务列表', null);
INSERT INTO `log` VALUES ('51c42f9fa75249ad85578c0cda5188ac', 'insertSelective', null, null, '2016-07-28 12:53:05', '[{\"code\":\"user:delete\",\"id\":\"dbc7770c1a64450c83babecb2c1736b9\",\"name\":\"删除用户\"}]', 'null', null, null);
INSERT INTO `log` VALUES ('624ce33cf90a4535b7e9b93b49f00632', '查询', null, null, '2016-08-05 13:15:57', null, null, '查询任务列表', null);
INSERT INTO `log` VALUES ('98fadd7229ef47009437911bb9d77d9e', 'deleteByPrimaryKey', null, null, '2016-07-28 12:55:37', '{\"code\":\"user:delete\",\"id\":\"dbc7770c1a64450c83babecb2c1736b9\",\"name\":\"删除用户\"}', '[\"dbc7770c1a64450c83babecb2c1736b9\"]', null, null);
INSERT INTO `log` VALUES ('99fb8d55cd254a3d9d9c248e53072514', '新增', null, null, '2016-08-28 22:38:37', null, null, '添加/修改用户', '[类名]:cn.wangsy.fast4j.web.service.UserService,[方法]:save,[参数]:password=123&phone=123&userName=test&email=100@te.a&,[IP]:0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('c535072f13ec40879f0bdaf506b7e60d', 'insertSelective', null, null, '2016-07-29 15:54:27', '[{\"createdAt\":1469778866910,\"email\":\"11367651011@qq.com\",\"id\":\"95f3b97b46524ea7b3c257a2ef1927b8\",\"password\":\"c81e728d9d4c2f636f067f89cc14862c\",\"phone\":\"18288631296\",\"userName\":\"syj1\"}]', 'null', null, null);
INSERT INTO `log` VALUES ('e20a4c0039ea47c3b6870eba3939da8a', '新增', null, null, '2016-08-28 22:36:21', null, null, '添加/修改用户', '[类名]:cn.wangsy.fast4j.web.service.UserService,[方法]:save,[参数]:password=123&userName=test&,[IP]:0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('f1298fcd832e432f94efd44e1fa0f6bf', '查询', null, null, '2016-08-05 10:55:42', null, null, '查询任务列表', null);
INSERT INTO `log` VALUES ('f72fc818f7904448a116f0582cec1d12', '新增', null, null, '2016-08-28 22:38:28', null, null, '添加/修改用户', '[类名]:cn.wangsy.fast4j.web.service.UserService,[方法]:save,[参数]:password=123&userName=test&email=100@te.a&,[IP]:0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('ff8f739ea57f4630a06371081f6d67c6', 'insertSelective', null, null, '2016-07-29 15:34:19', '[{\"createdAt\":1469777658571,\"id\":\"399e1e735afd438b9b35f2c084d54985\",\"password\":\"c4ca4238a0b923820dcc509a6f75849b\",\"userName\":\"wsy\"}]', 'null', null, null);

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
INSERT INTO `permission` VALUES ('5aad1b1537bb48d5a1052c6a84b28380', '查询用户', 'user:query');

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
INSERT INTO `role` VALUES ('1187b57f9b5b4ab8a180a47a55a3678c', '管理员', 'manager', null);
INSERT INTO `role` VALUES ('a4509114d1c34b9aba93541e089d2209', '超级管理员', 'admin', null);

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
INSERT INTO `role_permission` VALUES ('6f63d0267a654b90820e77a1c56fbacb', '1187b57f9b5b4ab8a180a47a55a3678c', '5aad1b1537bb48d5a1052c6a84b28380');

-- ----------------------------
-- Table structure for schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job` (
  `id` varchar(50) NOT NULL COMMENT '任务id',
  `job_name` varchar(100) DEFAULT NULL COMMENT '任务名称',
  `job_group` varchar(100) DEFAULT NULL COMMENT '任务分组',
  `job_status` varchar(10) DEFAULT NULL COMMENT '任务状态',
  `cron_expression` varchar(200) DEFAULT NULL COMMENT '任务运行时间表达式',
  `job_desc` varchar(200) DEFAULT NULL COMMENT '任务描述',
  `class_id` varchar(500) DEFAULT NULL COMMENT '对应执行类的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务';

-- ----------------------------
-- Records of schedule_job
-- ----------------------------
INSERT INTO `schedule_job` VALUES ('80a7ba8cf427415ab3d837b440ff55d9', '测试任务', '测试分组', '1', '0/10 * * * * ?', '仅仅用于测试', '6b0d4360620a48c49a31760032916371');
INSERT INTO `schedule_job` VALUES ('a1163667dc9740ca89317f44b651ed55', '测试任务 FileScan', '测试分组', '1', '0/10 * * * * ?', '仅仅用于测试', '8d4a4a67b8264903bae934ffd2451e5b');
INSERT INTO `schedule_job` VALUES ('b34a9ab667eb4359843419a84a25f5de', '测试任务', '测试分组', '1', '* 0/1 * * * ?', '仅仅用于测试', '6b0d4360620a48c49a31760032916371');
INSERT INTO `schedule_job` VALUES ('d41bc0d8a4884209b5239f066852c3cf', '测试任务', '测试分组', '1', '* 0/1 * * * ?', '仅仅用于测试', '6b0d4360620a48c49a31760032916371');
INSERT INTO `schedule_job` VALUES ('fec6945fe0aa436eb15e2249d87f5519', '测试任务', '测试分组', '1', '* 0/1 * * * ?', '仅仅用于测试', '6b0d4360620a48c49a31760032916371');

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
INSERT INTO `user` VALUES ('a35696fa555e4cfdb52d1612d9c7a37a', 'test', '202cb962ac59075b964b07152d234b70', '100@te.a', '123', null, '2016-08-28 22:38:37', null);

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
INSERT INTO `user_role` VALUES ('bd11ac66f4474054a5e38a7664ae7f47', '27db6cac190a410eb571dd386139e1a3', '1187b57f9b5b4ab8a180a47a55a3678c');
