/*
 Navicat MySQL Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : korozet

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 16/12/2021 17:58:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `request_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求用户',
  `time` int(11) NULL DEFAULT NULL COMMENT '执行时间',
  `request_uri` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求地址',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '具体操作',
  `params` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '请求参数',
  `request_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求ip',
  `user_agent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求代理人',
  `method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求方式（GET,POST）',
  `type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求状态（1：异常，0正常）',
  `exception` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '错误信息',
  `create_time` datetime NULL DEFAULT NULL COMMENT '日志创建时间',
  `request_platform` int(1) NULL DEFAULT NULL COMMENT '请求平台',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 861478 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '日志表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (861468, 'korozet1', NULL, '/korozet/login', 'korozet1登录系统', NULL, '', 'PostmanRuntime/7.28.4', 'POST', '0', NULL, '2021-12-16 16:46:15', NULL);
INSERT INTO `sys_log` VALUES (861469, 'korozet1', NULL, '/korozet/login', 'korozet1登录系统', NULL, '', 'PostmanRuntime/7.28.4', 'POST', '0', NULL, '2021-12-16 16:46:22', NULL);
INSERT INTO `sys_log` VALUES (861470, 'korozet1', NULL, '/korozet/login', 'korozet1登录系统', NULL, '', 'PostmanRuntime/7.28.4', 'POST', '0', NULL, '2021-12-16 16:47:25', NULL);
INSERT INTO `sys_log` VALUES (861471, 'korozet1', NULL, '/korozet/login', 'korozet1登录系统', NULL, '', 'PostmanRuntime/7.28.4', 'POST', '0', NULL, '2021-12-16 16:50:10', NULL);
INSERT INTO `sys_log` VALUES (861472, 'korozet1', NULL, '/korozet/login', 'korozet1登录系统', NULL, '', 'PostmanRuntime/7.28.4', 'POST', '0', NULL, '2021-12-16 16:50:32', NULL);
INSERT INTO `sys_log` VALUES (861473, 'korozet1', NULL, '/korozet/login', 'korozet1登录系统', NULL, '', 'PostmanRuntime/7.28.4', 'POST', '0', NULL, '2021-12-16 16:50:34', NULL);
INSERT INTO `sys_log` VALUES (861474, 'korozet1', NULL, '/korozet/login', 'korozet1登录系统', NULL, '', 'PostmanRuntime/7.28.4', 'POST', '0', NULL, '2021-12-16 16:50:35', NULL);
INSERT INTO `sys_log` VALUES (861475, 'korozet1', NULL, '/korozet/login', 'korozet1登录系统', NULL, '', 'PostmanRuntime/7.28.4', 'POST', '0', NULL, '2021-12-16 16:50:35', NULL);
INSERT INTO `sys_log` VALUES (861476, 'korozet1', NULL, '/korozet/login', 'korozet1登录系统', NULL, '', 'PostmanRuntime/7.28.4', 'POST', '0', NULL, '2021-12-16 16:51:37', NULL);
INSERT INTO `sys_log` VALUES (861477, 'korozet1', NULL, '/korozet/login', 'korozet1登录系统', NULL, '', 'PostmanRuntime/7.28.4', 'POST', '0', NULL, '2021-12-16 16:57:55', NULL);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求地址',
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父级菜单id',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `sort` int(255) NULL DEFAULT NULL COMMENT '菜单排序',
  `create_time` datetime NULL DEFAULT NULL COMMENT '菜单创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '菜单修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '/korozet/view', '系统可视化界面', NULL, NULL, NULL, '2021-12-16 14:12:19', NULL);
INSERT INTO `sys_menu` VALUES (2, '/korozet/zet', '系统界面', NULL, NULL, NULL, '2021-12-16 14:13:37', NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员');
INSERT INTO `sys_role` VALUES (2, '浏览用户');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(11) NOT NULL COMMENT '角色id',
  `permission_id` bigint(11) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 83 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单对照表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1, 1);
INSERT INTO `sys_role_menu` VALUES (2, 1, 2);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户真实名称',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `status` int(255) NULL DEFAULT 0 COMMENT '用户状态（0：有效 1：锁定）',
  `mobile_phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'korozet1', '{bcrypt}$2a$10$LSdLiwOGY8cGlLjs0rivXeV5fHhadqndF97yCFZXT6PHxHQep4NfO', 'wjp', '2021-11-17 16:06:25', 0, '111****');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL COMMENT '用户id',
  `role_id` bigint(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
