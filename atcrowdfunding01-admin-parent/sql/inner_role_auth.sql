/*
 Navicat Premium Data Transfer

 Source Server         : mylocalhost
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : project_crowd

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 29/05/2022 23:46:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for inner_role_auth
-- ----------------------------
DROP TABLE IF EXISTS `inner_role_auth`;
CREATE TABLE `inner_role_auth`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL,
  `auth_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inner_role_auth
-- ----------------------------
INSERT INTO `inner_role_auth` VALUES (20, 7, 1);
INSERT INTO `inner_role_auth` VALUES (21, 7, 2);
INSERT INTO `inner_role_auth` VALUES (22, 7, 3);
INSERT INTO `inner_role_auth` VALUES (23, 7, 4);
INSERT INTO `inner_role_auth` VALUES (24, 7, 5);
INSERT INTO `inner_role_auth` VALUES (25, 7, 6);
INSERT INTO `inner_role_auth` VALUES (26, 7, 7);
INSERT INTO `inner_role_auth` VALUES (27, 7, 8);
INSERT INTO `inner_role_auth` VALUES (28, 7, 9);
INSERT INTO `inner_role_auth` VALUES (29, 7, 10);
INSERT INTO `inner_role_auth` VALUES (30, 8, 1);
INSERT INTO `inner_role_auth` VALUES (31, 8, 3);
INSERT INTO `inner_role_auth` VALUES (32, 8, 4);
INSERT INTO `inner_role_auth` VALUES (33, 8, 6);
INSERT INTO `inner_role_auth` VALUES (34, 8, 8);

SET FOREIGN_KEY_CHECKS = 1;
