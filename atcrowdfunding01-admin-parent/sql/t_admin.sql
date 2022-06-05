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

 Date: 29/05/2022 23:45:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_acct` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_pswd` char(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_account`(`login_acct`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 134 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (31, 'tom', '$2a$10$s/d/VcWBhUQ3ziTM5QzAReC00lL7YdM3tnhCSU59DaGjkq5EucJAW', '汤姆', '827495316@qq.com', '2022-03-28 16:11:47');
INSERT INTO `t_admin` VALUES (32, 'super', '$2a$10$s/d/VcWBhUQ3ziTM5QzAReC00lL7YdM3tnhCSU59DaGjkq5EucJAW', '超级管理员', 'super@qq.com', '2022-05-29 21:05:59');
INSERT INTO `t_admin` VALUES (33, 'vip', '$2a$10$s/d/VcWBhUQ3ziTM5QzAReC00lL7YdM3tnhCSU59DaGjkq5EucJAW', '王德宏', 'vip@qq.com', '2022-05-29 21:06:38');
INSERT INTO `t_admin` VALUES (34, 'common', '$2a$10$s/d/VcWBhUQ3ziTM5QzAReC00lL7YdM3tnhCSU59DaGjkq5EucJAW', '游客', '11tom@qq.com', '2022-05-29 21:16:11');
INSERT INTO `t_admin` VALUES (36, 'tom13', '123123', '汤姆143', '13tom@qq.com', '2022-05-29 23:29:47');
INSERT INTO `t_admin` VALUES (37, 'tom14', '123123', '汤姆14', '14tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (38, 'tom15', '123123', '汤姆15', '15tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (39, 'tom16', '123123', '汤姆16', '16tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (41, 'tom18', '123123', '汤姆18', '18tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (42, 'tom19', '123123', '汤姆19', '19tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (43, 'tom20', '123123', '汤姆20', '20tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (44, 'tom21', '123123', '汤姆21', '21tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (45, 'tom22', '123123', '汤姆22', '22tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (46, 'tom23', '123123', '汤姆23', '23tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (47, 'tom24', '123123', '汤姆24', '24tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (48, 'tom25', '123123', '汤姆25', '25tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (49, 'tom26', '123123', '汤姆26', '26tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (50, 'tom27', '123123', '汤姆27', '27tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (51, 'tom28', '123123', '汤姆28', '28tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (52, 'tom29', '123123', '汤姆29', '29tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (53, 'tom30', '123123', '汤姆30', '30tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (54, 'tom31', '123123', '汤姆31', '31tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (55, 'tom32', '123123', '汤姆32', '32tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (56, 'tom33', '123123', '汤姆33', '33tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (57, 'tom34', '123123', '汤姆34', '34tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (58, 'tom35', '123123', '汤姆35', '35tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (59, 'tom36', '123123', '汤姆36', '36tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (60, 'tom37', '123123', '汤姆37', '37tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (61, 'tom38', '123123', '汤姆38', '38tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (62, 'tom39', '123123', '汤姆39', '39tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (63, 'tom40', '123123', '汤姆40', '40tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (64, 'tom41', '123123', '汤姆41', '41tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (65, 'tom42', '123123', '汤姆42', '42tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (66, 'tom43', '123123', '汤姆43', '43tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (67, 'tom44', '123123', '汤姆44', '44tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (68, 'tom45', '123123', '汤姆45', '45tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (69, 'tom46', '123123', '汤姆46', '46tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (70, 'tom47', '123123', '汤姆47', '47tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (71, 'tom48', '123123', '汤姆48', '48tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (72, 'tom49', '123123', '汤姆49', '49tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (73, 'tom50', '123123', '汤姆50', '50tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (74, 'tom51', '123123', '汤姆51', '51tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (75, 'tom52', '123123', '汤姆52', '52tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (76, 'tom53', '123123', '汤姆53', '53tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (77, 'tom54', '123123', '汤姆54', '54tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (78, 'tom55', '123123', '汤姆55', '55tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (79, 'tom56', '123123', '汤姆56', '56tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (80, 'tom57', '123123', '汤姆57', '57tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (81, 'tom58', '123123', '汤姆58', '58tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (82, 'tom59', '123123', '汤姆59', '59tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (83, 'tom60', '123123', '汤姆60', '60tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (84, 'tom61', '123123', '汤姆61', '61tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (85, 'tom62', '123123', '汤姆62', '62tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (86, 'tom63', '123123', '汤姆63', '63tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (87, 'tom64', '123123', '汤姆64', '64tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (88, 'tom65', '123123', '汤姆65', '65tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (89, 'tom66', '123123', '汤姆66', '66tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (90, 'tom67', '123123', '汤姆67', '67tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (91, 'tom68', '123123', '汤姆68', '68tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (92, 'tom69', '123123', '汤姆69', '69tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (93, 'tom70', '123123', '汤姆70', '70tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (94, 'tom71', '123123', '汤姆71', '71tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (95, 'tom72', '123123', '汤姆72', '72tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (96, 'tom73', '123123', '汤姆73', '73tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (97, 'tom74', '123123', '汤姆74', '74tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (98, 'tom75', '123123', '汤姆75', '75tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (99, 'tom76', '123123', '汤姆76', '76tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (100, 'tom77', '123123', '汤姆77', '77tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (101, 'tom78', '123123', '汤姆78', '78tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (102, 'tom79', '123123', '汤姆79', '79tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (103, 'tom80', '123123', '汤姆80', '80tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (104, 'tom81', '123123', '汤姆81', '81tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (105, 'tom82', '123123', '汤姆82', '82tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (106, 'tom83', '123123', '汤姆83', '83tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (107, 'tom84', '123123', '汤姆84', '84tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (108, 'tom85', '123123', '汤姆85', '85tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (109, 'tom86', '123123', '汤姆86', '86tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (110, 'tom87', '123123', '汤姆87', '87tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (111, 'tom88', '123123', '汤姆88', '88tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (112, 'tom89', '123123', '汤姆89', '89tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (113, 'tom90', '123123', '汤姆90', '90tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (114, 'tom91', '123123', '汤姆91', '91tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (115, 'tom92', '123123', '汤姆92', '92tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (116, 'tom93', '123123', '汤姆93', '93tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (117, 'tom94', '123123', '汤姆94', '94tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (118, 'tom95', '123123', '汤姆95', '95tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (119, 'tom96', '123123', '汤姆96', '96tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (120, 'tom97', '123123', '汤姆97', '97tom@qq.com', NULL);
INSERT INTO `t_admin` VALUES (127, '18851750391', 'E10ADC3949BA59ABBE56E057F20F883E', '王冬冬', '827495316@qq.com', '2022-03-16 22:07:19');
INSERT INTO `t_admin` VALUES (131, '15798077593', '63A9F0EA7BB98050796B649E85481845', '李梦莎', '2574084381@qq.com', '2022-03-16 14:06:35');
INSERT INTO `t_admin` VALUES (132, 'wangdongdong', '$2a$10$NMYqGQAEYNK65EySiLcede6iS.D8ad46BgxHtwXKFBaddpz1BPwhe', '汤姆', 'tom@qq.com', '2022-03-28 08:47:05');
INSERT INTO `t_admin` VALUES (134, 'common2', '$2a$10$M6cyGodwvkI5nxWIjYa55eQmJQaA9J4FbcXfs6bJKojrybh4gObe2', '游客2', 'youke@qq.com', '2022-05-29 14:54:59');

SET FOREIGN_KEY_CHECKS = 1;
