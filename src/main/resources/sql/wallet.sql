/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : wallet

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-08-13 21:48:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` varchar(50) NOT NULL COMMENT '账单记录id',
  `create_date` datetime DEFAULT NULL COMMENT '发生时间',
  `summary` varchar(100) DEFAULT NULL COMMENT '摘要',
  `purpose` varchar(100) DEFAULT NULL COMMENT '用途',
  `input` varchar(100) DEFAULT NULL COMMENT '收入',
  `output` varchar(100) DEFAULT NULL COMMENT '支出',
  `balance` varchar(100) DEFAULT NULL COMMENT '余额',
  `operator` varchar(100) DEFAULT NULL COMMENT '经办人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账单';

-- ----------------------------
-- Records of account
-- ----------------------------

-- ----------------------------
-- Table structure for consumption
-- ----------------------------
DROP TABLE IF EXISTS `consumption`;
CREATE TABLE `consumption` (
  `id` varchar(50) NOT NULL COMMENT '记录id',
  `type` int(11) NOT NULL COMMENT '记录类型，0支出，1收入',
  `value` double(11,0) NOT NULL COMMENT '交易金额',
  `remark` varchar(255) DEFAULT NULL COMMENT '描述',
  `date` datetime NOT NULL COMMENT '发生时间',
  `consume_type` varchar(50) DEFAULT NULL COMMENT '消费类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消费记录表';

-- ----------------------------
-- Records of consumption
-- ----------------------------
INSERT INTO `consumption` VALUES ('009fbf13439d48879d9e3dd036a57b19', '3', '45', '水费（3.0吨）', '2015-11-11 21:30:39', null);
INSERT INTO `consumption` VALUES ('03a18921faa347dda613a2e072fe50fb', '4', '23', '天津西-北京', '2015-11-20 00:00:00', null);
INSERT INTO `consumption` VALUES ('0b25b20813bf41c79f1d2e25ea528fe7', '2', '55', '乐美购-老汉-火锅', '2015-12-12 00:00:00', null);
INSERT INTO `consumption` VALUES ('0bdb345aaebe42e3a199f1f5b431c4a8', '5', '99', '乐美购', '2015-11-29 00:00:00', null);
INSERT INTO `consumption` VALUES ('0ed144fbfcda46bf8826d8d39d0cbb8a', '1', '78', '金包银内衣', '2015-11-14 22:05:29', null);
INSERT INTO `consumption` VALUES ('0fe116e3a77a419aa4eb7ed82947aa26', '4', '302', '北京-昆明火车票', '2015-11-20 00:00:00', null);
INSERT INTO `consumption` VALUES ('184d6fbcea084fdfb98ccc56be5b3c93', '4', '121', '昆明西部客运站-弥渡', '2015-11-22 00:00:00', null);
INSERT INTO `consumption` VALUES ('1d675b0356764fe2bf8642d58e04dd1e', '3', '868', '买洗衣机', '2015-10-18 23:33:07', null);
INSERT INTO `consumption` VALUES ('1f603f8dee1a430aadf99c01f9ed7c2b', '2', '55', '冒菜', '2015-12-11 00:00:00', null);
INSERT INTO `consumption` VALUES ('206f496db0fc4b948b65f68a816d1171', '2', '5', '鸡腿', '2015-11-14 22:08:09', null);
INSERT INTO `consumption` VALUES ('26e1930e265f4bff916cb5d880e9ccc8', '2', '65', '大米', '2015-11-19 18:18:07', null);
INSERT INTO `consumption` VALUES ('2b75270ed343465ab438b8af9e827c84', '5', '78', '娇兰佳人洗发水', '2015-11-21 18:07:36', null);
INSERT INTO `consumption` VALUES ('319a832bb4084c438516da2c7c12d1c4', '2', '30', '买菜，鱼', '2015-11-23 00:00:00', null);
INSERT INTO `consumption` VALUES ('3289d5f4657a4867bb2e236cbeb14ff1', '1', '96', '史艳琼-书包', '2015-11-12 18:17:09', null);
INSERT INTO `consumption` VALUES ('32d3ba2837784c3893eb14f14f0776a8', '5', '58', '乐美购', '2015-12-06 00:00:00', null);
INSERT INTO `consumption` VALUES ('3390c931e875419c996d0a6cae041edf', '1', '158', '森马男士牛仔裤', '2015-11-07 20:15:43', null);
INSERT INTO `consumption` VALUES ('461bfecbac4943ab97b65773a513cbd8', '5', '80', '初级会计报名', '2015-11-15 13:36:32', null);
INSERT INTO `consumption` VALUES ('4857739ab0ca4d2586297e9b9370455c', '3', '338', '美的电压力锅', '2015-12-20 00:00:00', null);
INSERT INTO `consumption` VALUES ('4e0eb61547584df3bf8954bd5720c5c2', '1', '39', '打底裤', '2015-11-21 18:06:44', null);
INSERT INTO `consumption` VALUES ('5c5d0c1cb8164b29a938eecac00725a9', '2', '29', '早上买菜', '2015-10-18 23:35:13', null);
INSERT INTO `consumption` VALUES ('5ee0e0576e2d4d2f9bfe82feb98db7a5', '4', '18', '打车（龙院村->小菜园）', '2015-11-09 21:35:06', null);
INSERT INTO `consumption` VALUES ('6ec103f484da42d7bde0e872e90255a7', '2', '9', '奶片', '2015-11-28 00:00:00', null);
INSERT INTO `consumption` VALUES ('7a347e1f07ae4252bbd9685ef71753bb', '2', '11', '柠檬水+鸡腿', '2015-11-07 20:18:19', null);
INSERT INTO `consumption` VALUES ('8385510a179c43e985e1a9f3e6dea5c7', '4', '14', '打车', '2015-10-18 23:33:41', null);
INSERT INTO `consumption` VALUES ('86f5ffd341504ad18da7069c2e6108a3', '3', '210', '床垫', '2015-12-19 00:00:00', null);
INSERT INTO `consumption` VALUES ('8a93a272c7ca488f8c536f85b5f68918', '1', '300', '针织外套-丰宁小区', '2015-11-15 18:11:33', null);
INSERT INTO `consumption` VALUES ('9ee93876cce54d879e64d38fc7987113', '1', '222', '屈臣氏化妆品', '2015-11-07 20:17:20', null);
INSERT INTO `consumption` VALUES ('a231ed399f824d909ebc167c86b43b01', '1', '100', '公交卡', '2015-11-21 00:00:00', null);
INSERT INTO `consumption` VALUES ('a332a5f5754b4c80b7b82573c6446156', '5', '128', '家乐福购物', '2015-10-18 23:32:28', null);
INSERT INTO `consumption` VALUES ('a68b300178ae49349794b30bee7d583b', '4', '23', '打车（小菜园->龙院村）', '2015-11-09 21:34:35', null);
INSERT INTO `consumption` VALUES ('a8928a516ead4b82aa5ce7a811def074', '2', '20', '糕点', '2015-12-21 00:00:00', null);
INSERT INTO `consumption` VALUES ('ad4d352bd44844a096dd508ef7b924c3', '5', '79', '家乐福购物', '2015-12-05 00:00:00', null);
INSERT INTO `consumption` VALUES ('b3c33d2704cf43b7b91ac12ea267a53a', '2', '34', '麻辣烫、鸡腿、蒸饵丝、洋芋', '2015-11-21 18:09:18', null);
INSERT INTO `consumption` VALUES ('b4e741ebfea647e58cb7517725ac0e35', '5', '180', '世纪广场屈臣氏', '2015-12-12 00:00:00', null);
INSERT INTO `consumption` VALUES ('bd9be3ebda304539a3e6fd8ce402e5b4', '2', '21', '青和米线', '2015-12-05 00:00:00', null);
INSERT INTO `consumption` VALUES ('bdf6ebc538f447be9716aecf90b203ee', '1', '308', '海澜之家羽绒服', '2015-11-11 22:11:56', null);
INSERT INTO `consumption` VALUES ('be2e6c3bdafc4625ac0d7a36ddd98e38', '2', '130', '水票', '2015-12-06 00:00:00', null);
INSERT INTO `consumption` VALUES ('c3020e7ccf4a45e9b63e1bcff2f95fce', '2', '20', '周五宵夜', '2015-11-27 00:00:00', null);
INSERT INTO `consumption` VALUES ('c7fc578882464d60a8010cb4941bf085', '2', '30', '金农红小锅米线', '2015-11-14 22:07:16', null);
INSERT INTO `consumption` VALUES ('cdb47e9cacfa4a4883a317db5550255d', '3', '25', '床垫运费', '2015-12-19 00:00:00', null);
INSERT INTO `consumption` VALUES ('d4517b4a0ef84f70b9659e7f647b428c', '1', '69', '打底衫', '2015-11-21 18:08:24', null);
INSERT INTO `consumption` VALUES ('d655a3d2f07a4a50ab2b365980e07fb4', '3', '135', '电费（90度）', '2015-11-11 21:32:27', null);
INSERT INTO `consumption` VALUES ('e07edac2e9d44c5f855bec66ffbe9532', '2', '93', '乐美购超市', '2015-12-20 00:00:00', null);
INSERT INTO `consumption` VALUES ('e413ed88086a4f21af882d8b0db12b6c', '4', '20', '理发', '2015-12-19 00:00:00', null);
INSERT INTO `consumption` VALUES ('ec7d433bceaa470587197bea87ed8474', '4', '15', '打车', '2015-12-19 00:00:00', null);
INSERT INTO `consumption` VALUES ('f0c40da397ca4dafbe1be4df00411667', '5', '54', '好乐多水壶', '2015-11-20 18:05:32', null);
INSERT INTO `consumption` VALUES ('f3c1328c40194129844c64771289c688', '1', '178', '卓诗尼皮鞋', '2015-11-20 18:04:54', null);
INSERT INTO `consumption` VALUES ('f5d803b64c884214836655a98b1ce5a0', '1', '149', '特步鞋子', '2015-11-11 23:48:56', null);
INSERT INTO `consumption` VALUES ('fdd98fd561994143ae6ae97155d2b965', '5', '112', '家乐福超市', '2015-11-14 22:04:42', null);

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int(11) NOT NULL,
  `type_desc` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '衣');
INSERT INTO `type` VALUES ('2', '食');
INSERT INTO `type` VALUES ('3', '住');
INSERT INTO `type` VALUES ('4', '行');
INSERT INTO `type` VALUES ('5', '其他');
