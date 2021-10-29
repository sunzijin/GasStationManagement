/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : mygasdb

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 14/04/2021 17:16:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for g_advise
-- ----------------------------
DROP TABLE IF EXISTS `g_advise`;
CREATE TABLE `g_advise`  (
  `a_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `a_dialog` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`a_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of g_advise
-- ----------------------------
INSERT INTO `g_advise` VALUES ('1', 'I like this gassoftware!');
INSERT INTO `g_advise` VALUES ('431512619829039104', 'my name is sunzijin');
INSERT INTO `g_advise` VALUES ('434756650201649152', '我很喜欢这个加油站');

-- ----------------------------
-- Table structure for g_gas
-- ----------------------------
DROP TABLE IF EXISTS `g_gas`;
CREATE TABLE `g_gas`  (
  `g_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `g_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '油品型号',
  `g_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '油品类型',
  `g_u_money` float(11, 3) NULL DEFAULT NULL COMMENT '普通油价',
  `g_v_money` float(11, 3) NULL DEFAULT NULL COMMENT '会员油价',
  PRIMARY KEY (`g_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of g_gas
-- ----------------------------
INSERT INTO `g_gas` VALUES ('1', '92#', '汽油', 7.000, 6.330);
INSERT INTO `g_gas` VALUES ('2', '95#', '汽油', 7.500, 7.000);
INSERT INTO `g_gas` VALUES ('3', '98#', '汽油', 8.200, 7.500);
INSERT INTO `g_gas` VALUES ('4', '柴油', '柴油', 6.200, 6.000);

-- ----------------------------
-- Table structure for g_ob
-- ----------------------------
DROP TABLE IF EXISTS `g_ob`;
CREATE TABLE `g_ob`  (
  `o_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `o_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `o_count` int(11) NULL DEFAULT NULL COMMENT '商品数量',
  `o_price` float(11, 3) NULL DEFAULT NULL COMMENT '商品价格',
  `o_factory` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生产厂',
  PRIMARY KEY (`o_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of g_ob
-- ----------------------------
INSERT INTO `g_ob` VALUES ('1', '润滑油', 100, 100.000, '壳牌');
INSERT INTO `g_ob` VALUES ('10', '蓄电池', 1000, 400.000, '风帆');
INSERT INTO `g_ob` VALUES ('2', '千斤顶', 1000, 400.000, '海滨');
INSERT INTO `g_ob` VALUES ('3', '农夫山泉', 100, 2.000, '农夫山泉');
INSERT INTO `g_ob` VALUES ('4', '玻璃水', 1000, 10.000, '龟牌');
INSERT INTO `g_ob` VALUES ('5', '机油', 100, 200.000, '壳牌');
INSERT INTO `g_ob` VALUES ('6', '备用轮胎', 100, 300.000, '米其林');
INSERT INTO `g_ob` VALUES ('7', '扳手', 100, 20.000, '万能');
INSERT INTO `g_ob` VALUES ('8', '泡面', 1000, 4.000, '统一');
INSERT INTO `g_ob` VALUES ('9', '红牛', 1000, 6.000, '红牛');

-- ----------------------------
-- Table structure for g_sales
-- ----------------------------
DROP TABLE IF EXISTS `g_sales`;
CREATE TABLE `g_sales`  (
  `s_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `s_money` float(11, 3) NULL DEFAULT NULL COMMENT '营业额',
  PRIMARY KEY (`s_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of g_sales
-- ----------------------------
INSERT INTO `g_sales` VALUES ('1', 0.000);

-- ----------------------------
-- Table structure for g_vip
-- ----------------------------
DROP TABLE IF EXISTS `g_vip`;
CREATE TABLE `g_vip`  (
  `v_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '会员编号',
  `v_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员姓名',
  `v_sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员性别',
  `v_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员电话',
  PRIMARY KEY (`v_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of g_vip
-- ----------------------------
INSERT INTO `g_vip` VALUES ('0001', '小王', '女', '1234566');
INSERT INTO `g_vip` VALUES ('0002', '小李', '男', '234567');

-- ----------------------------
-- Table structure for user_login
-- ----------------------------
DROP TABLE IF EXISTS `user_login`;
CREATE TABLE `user_login`  (
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '员工编号',
  `user_login_id` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `current_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `user_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型',
  `m_sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `m_age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `m_money` float(11, 3) NULL DEFAULT NULL COMMENT '工资',
  `m_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_login
-- ----------------------------
INSERT INTO `user_login` VALUES ('2', 'x1111', '1111', '销售人员', '销售人员', '男', 25, 3000.000, '112233');
INSERT INTO `user_login` VALUES ('3', 'f1111', '1111', '服务人员', '服务人员', '女', 40, 3000.000, '011234');
INSERT INTO `user_login` VALUES ('4', 's1111', '1111', '店长', '店长', '男', 20, 6000.000, '123456');
INSERT INTO `user_login` VALUES ('432861268320325632', 'b1111', '1111', '补货人员', '补货人员', '男', 20, 3000.000, '1234567');
INSERT INTO `user_login` VALUES ('432866322339205120', '1223456', '123456', '测试用户', '店长', '男', 150, 1222.000, '123456');

SET FOREIGN_KEY_CHECKS = 1;
