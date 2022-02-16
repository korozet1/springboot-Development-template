/*
 Navicat Premium Data Transfer

 Source Server         : linux全息展示平台238
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : 192.168.1.238:3306
 Source Schema         : project_manage

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 24/05/2021 14:48:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_user` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文件管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_file
-- ----------------------------
INSERT INTO `sys_file` VALUES (3, 'Month(2021-05-01~2021-05-31).doc', '月报', 1, '2021-05-20 16:24:15');
INSERT INTO `sys_file` VALUES (4, 'Month(2021-05-01~2021-05-31).doc', '月报', 1, '2021-05-20 17:34:48');
INSERT INTO `sys_file` VALUES (5, 'Week(2021-05-17~2021-05-23).doc', '周报', 1, '2021-05-20 17:34:56');
INSERT INTO `sys_file` VALUES (6, 'Week(2021-05-24~2021-05-30).doc', '周报', 1, '2021-05-23 23:50:03');

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
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '日志创建时间',
  `request_platform` int(1) NULL DEFAULT NULL COMMENT '请求平台',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '日志表' ROW_FORMAT = Dynamic;

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
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '菜单创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '菜单修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (5, '/manage/system', '系统管理', -1, NULL, 6, '2021-04-27 14:48:21', '2021-04-27 14:48:24');
INSERT INTO `sys_menu` VALUES (6, '/manage/system/user', '用户管理', 5, NULL, 1, '2021-04-27 14:48:57', '2021-04-27 14:48:59');
INSERT INTO `sys_menu` VALUES (7, '/manage/system/autho', '权限管理', 5, NULL, 2, '2021-04-27 14:50:03', '2021-04-27 14:50:06');
INSERT INTO `sys_menu` VALUES (8, '/manage/system/log', '日志管理', 5, NULL, 3, '2021-04-27 14:50:27', '2021-04-27 14:50:29');
INSERT INTO `sys_menu` VALUES (9, '/manage/project', '工程管理', -1, NULL, 2, '2021-04-27 16:49:18', '2021-04-27 16:49:21');
INSERT INTO `sys_menu` VALUES (10, '/manage/index', '首页', -1, NULL, 1, '2021-04-28 14:46:48', '2021-04-28 14:46:50');
INSERT INTO `sys_menu` VALUES (11, '/manage/project/projects', '风场管理', 9, NULL, 4, '2021-05-14 11:28:17', '2021-05-14 11:28:17');
INSERT INTO `sys_menu` VALUES (12, '/manage/project/projects', '里程碑管理', 9, NULL, 1, '2021-05-14 11:13:18', '2021-05-14 11:13:20');
INSERT INTO `sys_menu` VALUES (13, '/manage/project/device', '设备管理', 9, NULL, 2, '2021-05-14 11:13:49', '2021-05-14 11:13:51');
INSERT INTO `sys_menu` VALUES (14, '/manage/project/config', '项目设置', 9, NULL, 3, '2021-05-14 11:14:29', '2021-05-14 11:14:31');
INSERT INTO `sys_menu` VALUES (15, '/manage/jindu', '进度管理', -1, NULL, 3, '2021-05-14 11:26:24', '2021-05-14 11:26:27');
INSERT INTO `sys_menu` VALUES (16, '/manage/monitor', '监控管理', -1, NULL, 4, '2021-05-14 11:27:27', '2021-05-14 11:27:29');
INSERT INTO `sys_menu` VALUES (17, '/manage/report', '报表管理', -1, NULL, 5, '2021-05-14 11:28:17', '2021-05-14 11:28:19');
INSERT INTO `sys_menu` VALUES (18, '/manage/file', '文件管理', -1, NULL, 5, '2021-05-14 11:28:17', '2021-05-14 11:28:19');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 83 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单对照表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (27, 5, 5);
INSERT INTO `sys_role_menu` VALUES (28, 5, 6);
INSERT INTO `sys_role_menu` VALUES (29, 5, 7);
INSERT INTO `sys_role_menu` VALUES (30, 5, 8);
INSERT INTO `sys_role_menu` VALUES (31, 5, 9);
INSERT INTO `sys_role_menu` VALUES (32, 5, 11);
INSERT INTO `sys_role_menu` VALUES (33, 5, 12);
INSERT INTO `sys_role_menu` VALUES (34, 5, 13);
INSERT INTO `sys_role_menu` VALUES (35, 5, 14);
INSERT INTO `sys_role_menu` VALUES (36, 5, 10);
INSERT INTO `sys_role_menu` VALUES (39, 7, 18);
INSERT INTO `sys_role_menu` VALUES (40, 7, 17);
INSERT INTO `sys_role_menu` VALUES (41, 8, 16);
INSERT INTO `sys_role_menu` VALUES (42, 8, 15);
INSERT INTO `sys_role_menu` VALUES (55, 6, 10);
INSERT INTO `sys_role_menu` VALUES (56, 6, 15);
INSERT INTO `sys_role_menu` VALUES (69, 1, 5);
INSERT INTO `sys_role_menu` VALUES (70, 1, 6);
INSERT INTO `sys_role_menu` VALUES (71, 1, 7);
INSERT INTO `sys_role_menu` VALUES (72, 1, 8);
INSERT INTO `sys_role_menu` VALUES (73, 1, 10);
INSERT INTO `sys_role_menu` VALUES (74, 1, 15);
INSERT INTO `sys_role_menu` VALUES (75, 1, 16);
INSERT INTO `sys_role_menu` VALUES (76, 1, 17);
INSERT INTO `sys_role_menu` VALUES (77, 1, 18);
INSERT INTO `sys_role_menu` VALUES (78, 1, 12);
INSERT INTO `sys_role_menu` VALUES (79, 1, 13);
INSERT INTO `sys_role_menu` VALUES (80, 1, 14);
INSERT INTO `sys_role_menu` VALUES (81, 1, 11);
INSERT INTO `sys_role_menu` VALUES (82, 1, 9);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户真实名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` int(255) NULL DEFAULT 0 COMMENT '用户状态（0：有效 1：锁定）',
  `mobile_phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '{bcrypt}$2a$10$Tme77eHtXzcB8ghQUepYguJr7P7ESg0Y7XHMnk60s.kf2A.BWBD9m', 'admin', '2021-05-19 15:19:17', 0, '18268974598');
INSERT INTO `sys_user` VALUES (2, 'chenyu', '{bcrypt}$2a$10$Tme77eHtXzcB8ghQUepYguJr7P7ESg0Y7XHMnk60s.kf2A.BWBD9m', '陈宇', '2021-04-27 14:18:40', 0, '15123006831');
INSERT INTO `sys_user` VALUES (3, 'zt', '$2a$10$LhBYQNjJoTJQd8E7WJra7OlJvH1RnDpANrQJEEhpqvwvEMlFYd9GG', '张涛', '2021-05-19 17:46:51', 0, '');
INSERT INTO `sys_user` VALUES (4, 'xfl', '$2a$10$LhBYQNjJoTJQd8E7WJra7OlJvH1RnDpANrQJEEhpqvwvEMlFYd9GG', '徐凤龙', '2021-05-21 10:07:15', 0, NULL);
INSERT INTO `sys_user` VALUES (8, '11', '$2a$10$TDIrzBPHR8n0W9k45dU7MuK0m41Dkw923OSW6.DzWjVpfWklnhc8S', '木质树洞', '2021-05-21 17:35:49', 0, '');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL,
  `role_id` bigint(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2, 2);
INSERT INTO `sys_user_role` VALUES (3, 3, 1);
INSERT INTO `sys_user_role` VALUES (4, 4, 1);

-- ----------------------------
-- Table structure for t_device
-- ----------------------------
DROP TABLE IF EXISTS `t_device`;
CREATE TABLE `t_device`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `device_no` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备编号',
  `platform_id` int(10) NULL DEFAULT NULL COMMENT '平台id',
  `device_status` int(1) NULL DEFAULT NULL COMMENT '设备状态 0：正常 1：故障 2：离线 3：停机',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `fixed_point_flag` int(1) NULL DEFAULT NULL COMMENT '是否固定点位（1：是 2：否）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_device
-- ----------------------------
INSERT INTO `t_device` VALUES (1, 'CS-001', 1, 0, '2021-04-28 16:46:09', 1);

-- ----------------------------
-- Table structure for t_platform
-- ----------------------------
DROP TABLE IF EXISTS `t_platform`;
CREATE TABLE `t_platform`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `platform_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '平台名称',
  `finish_cycle` int(2) NULL DEFAULT NULL COMMENT '周期',
  `finish_cycle_unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '周期单位',
  `start_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开工时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_platform
-- ----------------------------
INSERT INTO `t_platform` VALUES (1, '丘北一期', 2, '年', '2022-10-11');

-- ----------------------------
-- Table structure for t_project_device
-- ----------------------------
DROP TABLE IF EXISTS `t_project_device`;
CREATE TABLE `t_project_device`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `device_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备编号',
  `type` int(10) NULL DEFAULT NULL COMMENT '类型（1：风机 2：升压站3：其他设施）',
  `platform_id` int(11) NULL DEFAULT NULL COMMENT '所属风机平台',
  `start_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开始动工时间',
  `finish_cycle` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预计完成时间',
  `finish_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '实际完成时间',
  `status` int(10) NULL DEFAULT 0 COMMENT '建设状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目设备表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_project_device
-- ----------------------------
INSERT INTO `t_project_device` VALUES (1, 'J1', 1, 1, '2021-05-06', '2021-05-28', NULL, 4);
INSERT INTO `t_project_device` VALUES (2, 'J2', 1, 1, '2021-05-01', '2021-05-07', NULL, 1);
INSERT INTO `t_project_device` VALUES (3, 'J3', 1, 1, '2021-05-01', '2021-05-07', NULL, 1);
INSERT INTO `t_project_device` VALUES (4, 'J4', 1, 1, '2021-05-01', '2021-05-07', NULL, 1);
INSERT INTO `t_project_device` VALUES (5, 'J5', 1, 1, '2021-05-01', '2021-05-07', NULL, 1);
INSERT INTO `t_project_device` VALUES (6, 'J6', 1, 1, '2021-05-01', '2021-05-07', NULL, 1);
INSERT INTO `t_project_device` VALUES (7, 'J7', 1, 1, '2021-05-01', '2021-05-07', NULL, 1);
INSERT INTO `t_project_device` VALUES (8, 'J8', 1, 1, '2021-05-01', '2021-05-07', NULL, 1);
INSERT INTO `t_project_device` VALUES (9, 'J9', 1, 1, '2021-05-01', '2021-05-07', NULL, 1);
INSERT INTO `t_project_device` VALUES (10, 'J10', 1, 1, '2021-05-01', '2021-05-07', NULL, 1);
INSERT INTO `t_project_device` VALUES (11, 'J11', 1, 1, '2021-05-01', '2021-05-07', NULL, 1);
INSERT INTO `t_project_device` VALUES (12, 'J12', 1, 1, '2021-05-01', '2021-05-07', NULL, 1);
INSERT INTO `t_project_device` VALUES (13, 'J13', 1, 1, '2021-05-01', '2021-05-07', NULL, 1);
INSERT INTO `t_project_device` VALUES (14, 'J14', 1, 1, '2021-05-01', '2021-05-07', NULL, 1);
INSERT INTO `t_project_device` VALUES (15, 'J15', 1, 1, '2021-05-01', '2021-05-07', NULL, 1);
INSERT INTO `t_project_device` VALUES (16, 'J16', 1, 1, '2021-05-01', '2021-05-07', NULL, 1);
INSERT INTO `t_project_device` VALUES (17, 'J17', 1, 1, '2021-05-01', '2021-05-07', NULL, 1);
INSERT INTO `t_project_device` VALUES (18, 'J18', 1, 1, '2021-05-01', '2021-05-07', NULL, 1);
INSERT INTO `t_project_device` VALUES (19, 'J19', 1, 1, '2021-05-01', '2021-05-07', NULL, 1);
INSERT INTO `t_project_device` VALUES (20, 'J20', 1, 1, '2021-05-01', '2021-05-07', NULL, 1);
INSERT INTO `t_project_device` VALUES (21, 'J21', 1, 1, '2021-05-01', '2021-05-07', NULL, 2);
INSERT INTO `t_project_device` VALUES (22, 'J22', 1, 1, '2021-05-01', '2021-05-07', NULL, 2);
INSERT INTO `t_project_device` VALUES (23, 'J23', 1, 1, '2021-05-01', '2021-05-07', NULL, 2);
INSERT INTO `t_project_device` VALUES (24, 'J24', 1, 1, '2021-05-01', '2021-05-07', NULL, 2);
INSERT INTO `t_project_device` VALUES (25, 'J25', 1, 1, '2021-05-01', '2021-05-07', NULL, 2);
INSERT INTO `t_project_device` VALUES (26, 'J26', 1, 1, '2021-05-01', '2021-05-07', NULL, 2);
INSERT INTO `t_project_device` VALUES (27, 'J27', 1, 1, '2021-05-01', '2021-05-07', NULL, 2);
INSERT INTO `t_project_device` VALUES (28, 'J28', 1, 1, '2021-05-01', '2021-05-07', NULL, 2);
INSERT INTO `t_project_device` VALUES (29, 'J29', 1, 1, '2021-05-01', '2021-05-07', NULL, 2);
INSERT INTO `t_project_device` VALUES (30, 'J30', 1, 1, '2021-05-01', '2021-05-07', NULL, 2);
INSERT INTO `t_project_device` VALUES (31, 'J31', 1, 1, '2021-05-01', '2021-05-07', NULL, 2);
INSERT INTO `t_project_device` VALUES (32, 'J32', 1, 1, '2021-05-01', '2021-05-07', NULL, 2);
INSERT INTO `t_project_device` VALUES (33, 'J33', 1, 1, '2021-05-01', '2021-05-07', NULL, 2);
INSERT INTO `t_project_device` VALUES (34, 'J34', 1, 1, '2021-05-01', '2021-05-07', NULL, 2);
INSERT INTO `t_project_device` VALUES (35, 'J35', 1, 1, '2021-05-01', '2021-05-07', NULL, 2);
INSERT INTO `t_project_device` VALUES (36, 'J36', 1, 1, '2021-05-01', '2021-05-07', NULL, 2);
INSERT INTO `t_project_device` VALUES (37, 'J37', 1, 1, '2021-05-01', '2021-05-07', NULL, 2);
INSERT INTO `t_project_device` VALUES (38, 'J38', 1, 1, '2021-05-01', '2021-05-07', NULL, 2);
INSERT INTO `t_project_device` VALUES (39, 'J39', 1, 1, '2021-05-01', '2021-05-07', NULL, 2);
INSERT INTO `t_project_device` VALUES (40, 'J40', 1, 1, '2021-05-01', '2021-05-07', NULL, 2);
INSERT INTO `t_project_device` VALUES (41, 'J41', 1, 1, '2021-05-01', '2021-05-07', NULL, 2);
INSERT INTO `t_project_device` VALUES (42, 'J42', 1, 1, '2021-05-01', '2021-05-07', NULL, 2);
INSERT INTO `t_project_device` VALUES (43, 'J43', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (44, 'J44', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (45, 'J45', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (46, 'J46', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (47, 'J47', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (48, 'J48', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (49, 'J49', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (50, 'J50', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (51, 'J51', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (52, 'J52', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (53, 'J53', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (54, 'J54', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (55, 'J55', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (56, 'J56', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (57, 'J57', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (58, 'J58', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (59, 'J59', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (60, 'J60', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (61, 'J61', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (62, 'J62', 1, 1, '2021-05-01', '2021-05-07', NULL, 4);
INSERT INTO `t_project_device` VALUES (63, 'J63', 1, 1, '2021-05-01', '2021-05-07', NULL, 4);
INSERT INTO `t_project_device` VALUES (64, 'J64', 1, 1, '2021-05-01', '2021-05-07', NULL, 4);
INSERT INTO `t_project_device` VALUES (65, 'J65', 1, 1, '2021-05-01', '2021-05-07', NULL, 4);
INSERT INTO `t_project_device` VALUES (66, 'J66', 1, 1, '2021-05-01', '2021-05-07', NULL, 4);
INSERT INTO `t_project_device` VALUES (67, 'J67', 1, 1, '2021-05-01', '2021-05-07', NULL, 4);
INSERT INTO `t_project_device` VALUES (68, 'J68', 1, 1, '2021-05-01', '2021-05-07', NULL, 4);
INSERT INTO `t_project_device` VALUES (69, 'J69', 1, 1, '2021-05-01', '2021-05-07', NULL, 4);
INSERT INTO `t_project_device` VALUES (70, 'J70', 1, 1, '2021-05-01', '2021-05-07', NULL, 4);
INSERT INTO `t_project_device` VALUES (71, 'J71', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (72, 'J72', 1, 1, '2021-05-01', '2021-05-07', NULL, 5);
INSERT INTO `t_project_device` VALUES (73, 'J73', 1, 1, '2021-05-01', '2021-05-07', NULL, 5);
INSERT INTO `t_project_device` VALUES (74, 'J74', 1, 1, '2021-05-01', '2021-05-07', NULL, 5);
INSERT INTO `t_project_device` VALUES (75, 'J75', 1, 1, '2021-05-01', '2021-05-07', NULL, 5);
INSERT INTO `t_project_device` VALUES (76, 'J76', 1, 1, '2021-05-01', '2021-05-07', NULL, 5);
INSERT INTO `t_project_device` VALUES (77, 'J77', 1, 1, '2021-05-01', '2021-05-07', NULL, 5);
INSERT INTO `t_project_device` VALUES (78, 'J78', 1, 1, '2021-05-01', '2021-05-07', NULL, 5);
INSERT INTO `t_project_device` VALUES (79, 'J79', 1, 1, '2021-05-01', '2021-05-07', NULL, 5);
INSERT INTO `t_project_device` VALUES (80, 'J80', 1, 1, '2021-05-01', '2021-05-07', NULL, 5);
INSERT INTO `t_project_device` VALUES (81, 'J81', 1, 1, '2021-05-01', '2021-05-07', NULL, 5);
INSERT INTO `t_project_device` VALUES (82, 'J82', 1, 1, '2021-05-01', '2021-05-07', NULL, 5);
INSERT INTO `t_project_device` VALUES (83, 'J83', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (84, 'J84', 1, 1, '2021-05-01', '2021-05-07', NULL, 6);
INSERT INTO `t_project_device` VALUES (85, 'J85', 1, 1, '2021-05-01', '2021-05-07', NULL, 6);
INSERT INTO `t_project_device` VALUES (86, 'J86', 1, 1, '2021-05-01', '2021-05-07', NULL, 6);
INSERT INTO `t_project_device` VALUES (87, 'J87', 1, 1, '2021-05-01', '2021-05-07', NULL, 6);
INSERT INTO `t_project_device` VALUES (88, 'J88', 1, 1, '2021-05-01', '2021-05-07', NULL, 6);
INSERT INTO `t_project_device` VALUES (89, 'J89', 1, 1, '2021-05-01', '2021-05-07', NULL, 6);
INSERT INTO `t_project_device` VALUES (90, 'J90', 1, 1, '2021-05-01', '2021-05-07', NULL, 6);
INSERT INTO `t_project_device` VALUES (91, 'J91', 1, 1, '2021-05-01', '2021-05-07', NULL, 6);
INSERT INTO `t_project_device` VALUES (92, 'J92', 1, 1, '2021-05-01', '2021-05-07', NULL, 6);
INSERT INTO `t_project_device` VALUES (93, 'J93', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (94, 'J94', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (95, 'J95', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (96, 'J96', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (97, 'J97', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (98, 'J98', 1, 1, '2021-05-01', '2021-05-07', NULL, 0);
INSERT INTO `t_project_device` VALUES (99, '金龙山升压站', 2, 1, '2021-07-01', '2021-05-13', NULL, 2);

-- ----------------------------
-- Table structure for t_project_device_record
-- ----------------------------
DROP TABLE IF EXISTS `t_project_device_record`;
CREATE TABLE `t_project_device_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `device_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备编号',
  `type` int(11) NULL DEFAULT NULL COMMENT '设备类型（1：风机 2：升压站3：其他设施）',
  `project_id` int(11) NULL DEFAULT NULL COMMENT '项目id',
  `status` int(11) NULL DEFAULT NULL COMMENT '建设状态',
  `create_time` date NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备状态修改记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_project_device_record
-- ----------------------------
INSERT INTO `t_project_device_record` VALUES (1, 1, 'J1', 1, 3, 2, '2021-05-24');
INSERT INTO `t_project_device_record` VALUES (2, 1, 'J1', 1, 5, 4, '2021-05-24');

-- ----------------------------
-- Table structure for t_project_rate_of_progress
-- ----------------------------
DROP TABLE IF EXISTS `t_project_rate_of_progress`;
CREATE TABLE `t_project_rate_of_progress`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL COMMENT '项目id',
  `week_need_finish_num` int(11) NULL DEFAULT NULL COMMENT '本周需要完成数量',
  `week_finish_num` int(11) NULL DEFAULT NULL COMMENT '本周已完成数量',
  `info_explain` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '未完成情况说明',
  `term_of_validity` date NULL DEFAULT NULL COMMENT '任务有效期',
  `start_date` date NULL DEFAULT NULL COMMENT '任务开始时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目工程进度管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_project_rate_of_progress
-- ----------------------------
INSERT INTO `t_project_rate_of_progress` VALUES (1, 1, 20, 16, '未完成原因1', '2021-05-23', '2021-05-17');
INSERT INTO `t_project_rate_of_progress` VALUES (4, 11, 8, 2, '未完成原因', '2021-05-23', '2021-05-19');
INSERT INTO `t_project_rate_of_progress` VALUES (5, 2, 12, 12, '未完成原因', '2021-05-23', '2021-05-20');
INSERT INTO `t_project_rate_of_progress` VALUES (6, 1, 2, 0, '哈哈', '2021-05-30', '2021-05-24');
INSERT INTO `t_project_rate_of_progress` VALUES (7, 11, 100, 0, NULL, '2021-05-30', '2021-05-24');
INSERT INTO `t_project_rate_of_progress` VALUES (8, 1, 2, 0, NULL, '2021-05-30', '2021-05-24');
INSERT INTO `t_project_rate_of_progress` VALUES (9, 11, 100, 0, NULL, '2021-05-30', '2021-05-24');
INSERT INTO `t_project_rate_of_progress` VALUES (10, 5, 98, 98, '', '2021-05-30', '2021-05-24');

-- ----------------------------
-- Table structure for t_project_task_config
-- ----------------------------
DROP TABLE IF EXISTS `t_project_task_config`;
CREATE TABLE `t_project_task_config`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `project_id` int(10) NOT NULL COMMENT '项目id',
  `task_unit` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务周期',
  `need_finish_num` int(11) NULL DEFAULT NULL COMMENT '需要完成数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目任务配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_project_task_config
-- ----------------------------
INSERT INTO `t_project_task_config` VALUES (4, 1, '按周', 2);
INSERT INTO `t_project_task_config` VALUES (6, 11, '按周', 100);

-- ----------------------------
-- Table structure for t_projects
-- ----------------------------
DROP TABLE IF EXISTS `t_projects`;
CREATE TABLE `t_projects`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `finish_total` int(10) NULL DEFAULT NULL COMMENT '需完成总数量',
  `finish_num` int(10) NULL DEFAULT NULL COMMENT '已完成数量',
  `start_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '动工时间',
  `finish_cycle` int(10) NULL DEFAULT NULL COMMENT '预计完成周期',
  `finish_cycle_unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '完成周期单位',
  `finish_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '实际完成日期',
  `status` int(1) NULL DEFAULT NULL COMMENT '项目建设状态（1：未开始 2：建设中 0：已完成）',
  `unit` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目单位',
  `platform_id` int(11) NULL DEFAULT NULL COMMENT '平台id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_projects
-- ----------------------------
INSERT INTO `t_projects` VALUES (1, '道路路基', 130, 0, '2021-05-01', 12, '月', NULL, 1, 'KM', 1);
INSERT INTO `t_projects` VALUES (2, '风机基础', 98, 0, '2021-05-01', 2, '月', NULL, 1, '台', 1);
INSERT INTO `t_projects` VALUES (3, '塔筒吊装', 98, 0, '2021-05-01', 2, '月', NULL, 1, '台', 1);
INSERT INTO `t_projects` VALUES (4, '风机吊装', 98, 0, '2021-05-01', 2, '月', NULL, 1, '台', 1);
INSERT INTO `t_projects` VALUES (5, '风机电装', 98, 0, '2021-05-01', 2, '月', NULL, 1, '台', 1);
INSERT INTO `t_projects` VALUES (6, '风机静态调试', 98, 0, '2021-05-01', 2, '月', NULL, 1, '台', 1);
INSERT INTO `t_projects` VALUES (7, '风机并网', 98, 0, '2021-05-01', 2, '月', NULL, 1, '台', 1);
INSERT INTO `t_projects` VALUES (8, '集电线路施工', 14, 0, '2021-05-01', 2, '月', NULL, 1, '回', 1);
INSERT INTO `t_projects` VALUES (9, '铁塔', 14, 0, '2021-05-01', 2, '月', NULL, 1, '座', 1);
INSERT INTO `t_projects` VALUES (10, '升压站土建施工', 2, 0, '2021-05-01', 2, '月', NULL, 1, '座', 1);
INSERT INTO `t_projects` VALUES (11, '升压站设备安装调试', 2, 0, '2021-05-01', 2, '月', NULL, 1, '座', 1);
INSERT INTO `t_projects` VALUES (12, '升压站反送电', 2, 0, '2021-05-01', 2, '月', NULL, 1, '座', 1);
INSERT INTO `t_projects` VALUES (13, '升压站投运', 2, 0, '2021-05-01', 2, '月', NULL, 1, '座', 1);

-- ----------------------------
-- Table structure for t_report
-- ----------------------------
DROP TABLE IF EXISTS `t_report`;
CREATE TABLE `t_report`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报表名称',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建方式',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `file_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件',
  `evaluate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评价',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '报表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_report
-- ----------------------------
INSERT INTO `t_report` VALUES (5, 'Month(2021-05-01~2021-05-31).doc', '月报', '系统', '2021-05-20 17:34:48', '4', '暂无评价！');
INSERT INTO `t_report` VALUES (6, 'Week(2021-05-17~2021-05-23).doc', '周报', '系统', '2021-05-20 17:34:56', '5', '暂无评价！');
INSERT INTO `t_report` VALUES (7, 'Week(2021-05-24~2021-05-30).doc', '周报', '系统', '2021-05-23 23:50:03', '6', '暂无评价！');

SET FOREIGN_KEY_CHECKS = 1;
