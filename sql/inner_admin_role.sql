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

 Date: 29/05/2022 23:46:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for inner_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `inner_admin_role`;
CREATE TABLE `inner_admin_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_id` int(11) NULL DEFAULT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inner_admin_role
-- ----------------------------
INSERT INTO `inner_admin_role` VALUES (10, 24, 11);
INSERT INTO `inner_admin_role` VALUES (11, 32, 7);
INSERT INTO `inner_admin_role` VALUES (12, 32, 8);
INSERT INTO `inner_admin_role` VALUES (13, 32, 11);
INSERT INTO `inner_admin_role` VALUES (14, 33, 8);
INSERT INTO `inner_admin_role` VALUES (15, 33, 11);
INSERT INTO `inner_admin_role` VALUES (16, 34, 11);
INSERT INTO `inner_admin_role` VALUES (17, 134, 8);
INSERT INTO `inner_admin_role` VALUES (18, 134, 11);

SET FOREIGN_KEY_CHECKS = 1;
