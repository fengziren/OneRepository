/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : kaohe

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 28/04/2021 17:59:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `m_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `m_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`m_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (12, '消息发送测试标题', '消息发送测试内容**********************\n消息发送测试内容******************', '2021-04-20 11:47:41');
INSERT INTO `message` VALUES (13, '消息2', '消息2发送测试内容**********************\n消息2发送测试内容******************', '2021-04-21 13:53:26');
INSERT INTO `message` VALUES (14, '消息3', '消息3发送测试内容**********************\n消息3发送测试内容******************', '2021-04-21 13:54:22');
INSERT INTO `message` VALUES (15, '消息4', '消息4发送测试内容**********************\n消息4发送测试内容******************', '2021-04-21 13:54:41');
INSERT INTO `message` VALUES (16, '消息5', '消息5发送测试内容**********************\n消息5发送测试内容******************', '2021-04-21 14:39:53');
INSERT INTO `message` VALUES (17, '消息6', '消息6发送测试内容**********************\n消息6发送测试内容******************', '2021-04-20 14:40:21');
INSERT INTO `message` VALUES (18, '消息7', '消息7发送测试内容**********************\n消息7发送测试内容******************', '2021-04-20 14:40:41');
INSERT INTO `message` VALUES (19, '消息8', '消息8发送测试内容**********************\n消息8发送测试内容******************', '2021-04-21 14:41:00');
INSERT INTO `message` VALUES (20, '消息9', '消息9发送测试内容**********************\n消息9发送测试内容******************', '2021-04-20 14:41:24');
INSERT INTO `message` VALUES (21, '消息10', '消息10发送测试内容**********************\n消息10发送测试内容******************', '2021-04-21 14:41:45');
INSERT INTO `message` VALUES (22, '消息11', '消息11发送测试内容**********************\n消息11发送测试内容******************', '2021-04-21 14:42:12');
INSERT INTO `message` VALUES (23, '消息12', '消息12发送测试内容**********************\n消息12发送测试内容******************', '2021-04-20 14:42:25');
INSERT INTO `message` VALUES (24, '消息13', '消息13发送测试内容**********************\n消息13发送测试内容******************', '2021-04-20 14:42:37');
INSERT INTO `message` VALUES (25, '消息14', '消息14发送测试内容**********************\n消息14发送测试内容******************', '2021-04-21 14:42:56');
INSERT INTO `message` VALUES (26, '消息15', '消息15发送测试内容**********************\n消息15发送测试内容******************', '2021-04-20 14:43:08');
INSERT INTO `message` VALUES (27, '消息16', '消息16发送测试内容**********************\n消息16发送测试内容******************', '2021-04-21 14:43:25');
INSERT INTO `message` VALUES (28, '消息1', '消息1_2发送测试内容**********************\n消息1_2发送测试内容******************', '2021-04-21 16:34:51');
INSERT INTO `message` VALUES (29, '消息1', '消息1_1发送测试内容**********************\n消息1_1发送测试内容******************', '2021-04-21 16:36:34');
INSERT INTO `message` VALUES (30, '消息1', '消息1_3发送测试内容**********************\n消息1_3发送测试内容******************', '2021-04-21 16:36:47');
INSERT INTO `message` VALUES (31, '你好', 'val() 方法返回或设置被选元素的值。元素的值是通过 value 属性设置的。该方法大多用于 input 元素。如果该方法未设置参数，则返回被选元素的当前值。', '2021-04-28 16:07:12');
INSERT INTO `message` VALUES (32, '你好2', '定义和用法当点击元素时，会发生 click 事件。当鼠标指针停留在元素上方，然后按下并松开鼠标左键时，就会发生一次 click。click() 方法触发 click 事件，或规定当发生 click 事件时运行的函数。', '2021-04-28 16:12:53');

-- ----------------------------
-- Table structure for msg
-- ----------------------------
DROP TABLE IF EXISTS `msg`;
CREATE TABLE `msg`  (
  `msg_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `f_id` bigint(20) NULL DEFAULT NULL COMMENT '发件人',
  `s_id` bigint(20) NULL DEFAULT NULL COMMENT '收件人',
  `m_id` bigint(20) NULL DEFAULT NULL COMMENT '消息',
  `status` int(1) NULL DEFAULT NULL COMMENT '读取状态',
  `del_status` int(1) NULL DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`msg_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 80 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of msg
-- ----------------------------
INSERT INTO `msg` VALUES (1, 1, 2, 12, 1, 0);
INSERT INTO `msg` VALUES (2, 1, 3, 12, 0, 3);
INSERT INTO `msg` VALUES (3, 1, 4, 12, 1, 0);
INSERT INTO `msg` VALUES (4, 1, 5, 12, 1, 0);
INSERT INTO `msg` VALUES (5, 1, 6, 12, 0, 0);
INSERT INTO `msg` VALUES (6, 1, 7, 12, 0, 0);
INSERT INTO `msg` VALUES (7, 2, 1, 13, 1, 0);
INSERT INTO `msg` VALUES (8, 2, 4, 13, 1, 0);
INSERT INTO `msg` VALUES (9, 2, 5, 13, 1, 0);
INSERT INTO `msg` VALUES (10, 2, 6, 13, 1, 0);
INSERT INTO `msg` VALUES (11, 2, 7, 13, 1, 0);
INSERT INTO `msg` VALUES (12, 3, 1, 14, 0, 0);
INSERT INTO `msg` VALUES (13, 3, 4, 14, 0, 0);
INSERT INTO `msg` VALUES (14, 3, 5, 14, 0, 0);
INSERT INTO `msg` VALUES (15, 3, 6, 14, 0, 0);
INSERT INTO `msg` VALUES (16, 3, 7, 14, 0, 0);
INSERT INTO `msg` VALUES (17, 3, 1, 15, 0, 0);
INSERT INTO `msg` VALUES (18, 3, 3, 15, 0, 0);
INSERT INTO `msg` VALUES (19, 3, 5, 15, 0, 0);
INSERT INTO `msg` VALUES (20, 3, 6, 15, 0, 0);
INSERT INTO `msg` VALUES (21, 3, 7, 15, 0, 0);
INSERT INTO `msg` VALUES (22, 7, 1, 16, 0, 0);
INSERT INTO `msg` VALUES (23, 7, 3, 16, 0, 0);
INSERT INTO `msg` VALUES (24, 7, 5, 16, 0, 0);
INSERT INTO `msg` VALUES (25, 7, 6, 16, 0, 0);
INSERT INTO `msg` VALUES (26, 7, 2, 16, 0, 0);
INSERT INTO `msg` VALUES (27, 7, 3, 17, 0, 0);
INSERT INTO `msg` VALUES (28, 7, 6, 17, 0, 0);
INSERT INTO `msg` VALUES (29, 7, 2, 17, 0, 0);
INSERT INTO `msg` VALUES (30, 5, 3, 18, 1, 0);
INSERT INTO `msg` VALUES (31, 5, 6, 18, 0, 0);
INSERT INTO `msg` VALUES (32, 5, 2, 18, 0, 0);
INSERT INTO `msg` VALUES (33, 5, 3, 19, 0, 0);
INSERT INTO `msg` VALUES (34, 5, 6, 19, 0, 0);
INSERT INTO `msg` VALUES (35, 5, 2, 19, 0, 0);
INSERT INTO `msg` VALUES (36, 8, 3, 20, 0, 0);
INSERT INTO `msg` VALUES (37, 8, 6, 20, 0, 0);
INSERT INTO `msg` VALUES (38, 8, 2, 20, 0, 0);
INSERT INTO `msg` VALUES (39, 8, 1, 20, 0, 0);
INSERT INTO `msg` VALUES (40, 8, 3, 21, 0, 3);
INSERT INTO `msg` VALUES (41, 8, 6, 21, 0, 0);
INSERT INTO `msg` VALUES (42, 8, 2, 21, 0, 0);
INSERT INTO `msg` VALUES (43, 8, 1, 21, 0, 0);
INSERT INTO `msg` VALUES (44, 1, 3, 22, 1, 3);
INSERT INTO `msg` VALUES (45, 1, 6, 22, 1, 0);
INSERT INTO `msg` VALUES (46, 1, 2, 22, 0, 2);
INSERT INTO `msg` VALUES (47, 1, 5, 22, 1, 0);
INSERT INTO `msg` VALUES (48, 1, 3, 23, 0, 3);
INSERT INTO `msg` VALUES (49, 1, 6, 23, 0, 0);
INSERT INTO `msg` VALUES (50, 1, 2, 23, 0, 2);
INSERT INTO `msg` VALUES (51, 1, 5, 23, 0, 2);
INSERT INTO `msg` VALUES (52, 1, 3, 24, 1, 2);
INSERT INTO `msg` VALUES (53, 1, 6, 24, 1, 0);
INSERT INTO `msg` VALUES (54, 1, 2, 24, 1, 2);
INSERT INTO `msg` VALUES (55, 1, 5, 24, 1, 0);
INSERT INTO `msg` VALUES (56, 1, 3, 25, 1, 0);
INSERT INTO `msg` VALUES (57, 1, 6, 25, 0, 0);
INSERT INTO `msg` VALUES (58, 1, 2, 25, 1, 0);
INSERT INTO `msg` VALUES (59, 1, 5, 25, 0, 0);
INSERT INTO `msg` VALUES (60, 1, 3, 26, 0, 0);
INSERT INTO `msg` VALUES (61, 1, 6, 26, 0, 0);
INSERT INTO `msg` VALUES (62, 1, 2, 26, 0, 0);
INSERT INTO `msg` VALUES (63, 1, 5, 26, 0, 0);
INSERT INTO `msg` VALUES (64, 1, 3, 27, 0, 0);
INSERT INTO `msg` VALUES (65, 1, 6, 27, 0, 0);
INSERT INTO `msg` VALUES (66, 1, 2, 27, 0, 0);
INSERT INTO `msg` VALUES (67, 1, 5, 27, 0, 0);
INSERT INTO `msg` VALUES (68, 1, 5, 28, 0, 0);
INSERT INTO `msg` VALUES (69, 1, 4, 28, 0, 0);
INSERT INTO `msg` VALUES (70, 1, 3, 28, 0, 0);
INSERT INTO `msg` VALUES (71, 1, 2, 28, 0, 0);
INSERT INTO `msg` VALUES (72, 1, 5, 29, 0, 0);
INSERT INTO `msg` VALUES (73, 1, 4, 29, 0, 0);
INSERT INTO `msg` VALUES (74, 1, 3, 29, 0, 0);
INSERT INTO `msg` VALUES (75, 1, 2, 29, 0, 0);
INSERT INTO `msg` VALUES (76, 1, 5, 30, 1, 0);
INSERT INTO `msg` VALUES (77, 1, 4, 30, 1, 0);
INSERT INTO `msg` VALUES (78, 1, 3, 30, 1, 0);
INSERT INTO `msg` VALUES (79, 1, 2, 30, 1, 0);
INSERT INTO `msg` VALUES (80, 7, 1, 31, 0, 0);
INSERT INTO `msg` VALUES (81, 7, 2, 31, 0, 0);
INSERT INTO `msg` VALUES (82, 7, 3, 31, 0, 0);
INSERT INTO `msg` VALUES (83, 7, 9, 31, 0, 0);
INSERT INTO `msg` VALUES (84, 7, 10, 31, 0, 0);
INSERT INTO `msg` VALUES (85, 7, 1, 32, 0, 0);
INSERT INTO `msg` VALUES (86, 7, 2, 32, 0, 0);
INSERT INTO `msg` VALUES (87, 7, 3, 32, 0, 0);
INSERT INTO `msg` VALUES (88, 7, 4, 32, 0, 0);
INSERT INTO `msg` VALUES (89, 7, 5, 32, 0, 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `u_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`u_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '玛卡巴卡', '玛卡', '123456', '12308036657', '2021-04-20 09:10:04', NULL);
INSERT INTO `user` VALUES (2, '唔西迪西', '唔西', '123456', '10254135124', '2021-04-20 09:17:12', NULL);
INSERT INTO `user` VALUES (3, '铁甲小宝', '张三', '123456', '10214015201', '2021-04-20 13:59:57', NULL);
INSERT INTO `user` VALUES (4, '蟑螂恶霸', '林风', '123456', '24105104205', '2021-04-20 14:00:42', NULL);
INSERT INTO `user` VALUES (5, '鲨鱼辣椒', '林祥', '123456', '41254105012', '2021-04-20 14:01:29', NULL);
INSERT INTO `user` VALUES (6, '飞飞鱼', '林辉', '123456', '25001220350', '2021-04-20 14:01:52', NULL);
INSERT INTO `user` VALUES (7, '风之刃', '罗宇', '123456', '12345678910', '2021-04-20 16:34:26', '追风少年');
INSERT INTO `user` VALUES (8, '小灰灰', '罗浩', '123456', '2410452004125', '2021-04-20 16:40:07', '芜湖起飞');
INSERT INTO `user` VALUES (9, '阳光大男孩', '赵金', '123456', '1234872025651', '2021-04-20 16:42:09', '快乐的飞起');
INSERT INTO `user` VALUES (10, '富贵花开', '王芳', '123456', '1251005205512', '2021-04-28 14:26:44', NULL);

SET FOREIGN_KEY_CHECKS = 1;
