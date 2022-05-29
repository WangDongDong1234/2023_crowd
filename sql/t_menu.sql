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

 Date: 29/05/2022 23:45:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NULL DEFAULT NULL,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `icon` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES (1, NULL, '系统权限菜单', NULL, 'glyphicon\r\nglyphicon-th-list');
INSERT INTO `t_menu` VALUES (2, 1, ' 控制面板', 'main.htm', 'glyphicon\r\nglyphicon-dashboard');
INSERT INTO `t_menu` VALUES (3, 1, '权限管理', NULL, 'glyphicon glyphicon\r\nglyphicon-tasks');
INSERT INTO `t_menu` VALUES (4, 3, ' 用户维护', 'admin/get/page.html', 'glyphicon\r\nglyphicon-user');
INSERT INTO `t_menu` VALUES (5, 3, ' 角色维护', 'role/index.htm', 'glyphicon\r\nglyphicon-king');
INSERT INTO `t_menu` VALUES (6, 3, ' 菜单维护', 'permission/index.htm', 'glyphicon\r\nglyphicon-lock');
INSERT INTO `t_menu` VALUES (7, 1, ' 业务审核', NULL, 'glyphicon\r\nglyphicon-ok');
INSERT INTO `t_menu` VALUES (8, 7, ' 实名认证审核', 'auth_cert/index.htm', 'glyphicon\r\nglyphicon-check');
INSERT INTO `t_menu` VALUES (9, 7, ' 广告审核', 'auth_adv/index.htm', 'glyphicon\r\nglyphicon-check');
INSERT INTO `t_menu` VALUES (10, 7, ' 项目审核', 'auth_project/index.htm', 'glyphicon\r\nglyphicon-check');
INSERT INTO `t_menu` VALUES (11, 1, ' 业务管理', NULL, 'glyphicon\r\nglyphicon-th-large');
INSERT INTO `t_menu` VALUES (12, 11, ' 资质维护', 'cert/index.htm', 'glyphicon\r\nglyphicon-picture');
INSERT INTO `t_menu` VALUES (13, 11, ' 分类管理', 'certtype/index.htm', 'glyphicon\r\nglyphicon-equalizer');
INSERT INTO `t_menu` VALUES (14, 11, ' 流程管理', 'process/index.htm', 'glyphicon\r\nglyphicon-random');
INSERT INTO `t_menu` VALUES (15, 11, ' 广告管理', 'advert/index.htm', 'glyphicon\r\nglyphicon-hdd');
INSERT INTO `t_menu` VALUES (16, 11, ' 消息模板', 'message/index.htm', 'glyphicon\r\nglyphicon-comment');
INSERT INTO `t_menu` VALUES (17, 11, ' 项目分类', 'projectType/index.htm', 'glyphicon\r\nglyphicon-list');
INSERT INTO `t_menu` VALUES (18, 11, ' 项目标签', 'tag/index.htm', 'glyphicon\r\nglyphicon-tags');
INSERT INTO `t_menu` VALUES (20, 1, '参数管理', 'param/index.htm', 'glyphicon glyphicon-list-alt');

SET FOREIGN_KEY_CHECKS = 1;
