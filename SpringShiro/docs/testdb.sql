/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : testdb

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 31/08/2019 17:19:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sysauth_menu_permission
-- ----------------------------
DROP TABLE IF EXISTS `sysauth_menu_permission`;
CREATE TABLE `sysauth_menu_permission`  (
  `menu_id` int(11) NOT NULL COMMENT '菜单id',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '菜单父节点id',
  `menu_text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单内容',
  `menu_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单url',
  `permission_id` int(11) NULL DEFAULT NULL COMMENT '权限id',
  `enable_flag` tinyint(4) NULL DEFAULT NULL COMMENT '可用性标注',
  `menu_order` tinyint(11) NULL DEFAULT NULL COMMENT '菜单排序',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sysauth_menu_permission
-- ----------------------------
INSERT INTO `sysauth_menu_permission` VALUES (1, NULL, NULL, '/service', 1, NULL, NULL);
INSERT INTO `sysauth_menu_permission` VALUES (2, 1, NULL, '/getAll', 1, NULL, NULL);
INSERT INTO `sysauth_menu_permission` VALUES (3, 1, NULL, '/getAny', 1, NULL, NULL);
INSERT INTO `sysauth_menu_permission` VALUES (4, 1, NULL, '/getAny', 3, NULL, NULL);

-- ----------------------------
-- Table structure for sysauth_permission
-- ----------------------------
DROP TABLE IF EXISTS `sysauth_permission`;
CREATE TABLE `sysauth_permission`  (
  `permission_id` int(11) NOT NULL COMMENT 'id',
  `permission_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限code',
  `permission_name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `permission_order` int(11) NULL DEFAULT NULL COMMENT '权限排序',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标记',
  `menu_permission_flag` tinyint(4) NULL DEFAULT NULL COMMENT '菜单权限标注',
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sysauth_permission
-- ----------------------------
INSERT INTO `sysauth_permission` VALUES (1, '1', 'add', NULL, '新增权限', NULL);
INSERT INTO `sysauth_permission` VALUES (2, '2', 'del', NULL, '删除权限', NULL);
INSERT INTO `sysauth_permission` VALUES (3, '3', 'query', NULL, '查询权限', NULL);

-- ----------------------------
-- Table structure for sysauth_role
-- ----------------------------
DROP TABLE IF EXISTS `sysauth_role`;
CREATE TABLE `sysauth_role`  (
  `role_id` int(11) NOT NULL COMMENT 'id',
  `role_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色code',
  `role_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标记',
  `type` tinyint(4) NULL DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sysauth_role
-- ----------------------------
INSERT INTO `sysauth_role` VALUES (1, '10001', 'role_admin', '管理员', NULL);
INSERT INTO `sysauth_role` VALUES (2, '10002', 'role_user', '用户', NULL);

-- ----------------------------
-- Table structure for sysauth_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sysauth_role_permission`;
CREATE TABLE `sysauth_role_permission`  (
  `id` int(11) NOT NULL,
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
  `permission_id` int(11) NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sysauth_role_permission
-- ----------------------------
INSERT INTO `sysauth_role_permission` VALUES (1, 1, 1);
INSERT INTO `sysauth_role_permission` VALUES (2, 1, 2);
INSERT INTO `sysauth_role_permission` VALUES (3, 1, 3);
INSERT INTO `sysauth_role_permission` VALUES (4, 2, 3);

-- ----------------------------
-- Table structure for sysauth_user
-- ----------------------------
DROP TABLE IF EXISTS `sysauth_user`;
CREATE TABLE `sysauth_user`  (
  `user_id` int(11) NOT NULL COMMENT 'id',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `auth_salt` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加密值（盐值）',
  `auth_salt_num` int(11) NULL DEFAULT NULL COMMENT '加密次数',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标记',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sysauth_user
-- ----------------------------
INSERT INTO `sysauth_user` VALUES (1, '00001', 'zzw', '455d11d50914a83bfe35b4bbc4608b54', '00001zzw', 3, NULL, NULL);
INSERT INTO `sysauth_user` VALUES (2, '00002', 'yc', 'd773ef4c18f8d0fc2ad4e00211f153cb', '00002yc', 5, NULL, NULL);
INSERT INTO `sysauth_user` VALUES (3, '00003', 'yc', 'd773ef4c18f8d0fc2ad4e00211f153cb', '00002yc', 5, NULL, NULL);

-- ----------------------------
-- Table structure for sysauth_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sysauth_user_role`;
CREATE TABLE `sysauth_user_role`  (
  `id` int(11) NOT NULL,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sysauth_user_role
-- ----------------------------
INSERT INTO `sysauth_user_role` VALUES (1, 1, 1);
INSERT INTO `sysauth_user_role` VALUES (2, 1, 2);
INSERT INTO `sysauth_user_role` VALUES (3, 2, 2);

SET FOREIGN_KEY_CHECKS = 1;
