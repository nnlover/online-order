/*
  数据库 表结构
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_activity
-- ----------------------------
DROP TABLE IF EXISTS `t_activity`;
CREATE TABLE `t_activity` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'id',
  `activity_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '活动名称',
  `preferential_type` int(11) NOT NULL COMMENT '优惠方式 打折；减钱',
  `discount` int(10) unsigned NOT NULL COMMENT '打折多少',
  `on_sale` int(10) unsigned NOT NULL COMMENT '减钱多少',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_address
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(10) unsigned NOT NULL COMMENT '用户ID',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户地址表';

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `user_icon` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户头像',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登陆密码',
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `rank` int(11) NOT NULL DEFAULT '1' COMMENT '用户等级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Table structure for t_collection
-- ----------------------------
DROP TABLE IF EXISTS `t_collection`;
CREATE TABLE `t_collection` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `shop_id` int(11) NOT NULL COMMENT '店铺ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户收藏店铺表';

-- ----------------------------
-- Table structure for t_food
-- ----------------------------
DROP TABLE IF EXISTS `t_food`;
CREATE TABLE `t_food` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `shop_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '商家ID',
  `category` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '店长推荐' COMMENT '展示目录',
  `item_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '菜名',
  `item_title` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '菜品说明',
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '菜品图片，多个以;分割',
  `count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '库存',
  `praise_num` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '赞数量',
  `month_sale` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '月售',
  `price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '价格',
  `orgin_price` decimal(10,2) unsigned NOT NULL COMMENT '原价',
  `activity_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '参加的活动ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4456 DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Table structure for t_food
-- ----------------------------
DROP TABLE IF EXISTS `t_food`;
CREATE TABLE `t_food` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `shop_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '商家ID',
  `category` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '店长推荐' COMMENT '展示目录',
  `item_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '菜名',
  `item_title` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '菜品说明',
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '菜品图片，多个以;分割',
  `count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '库存',
  `praise_num` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '赞数量',
  `month_sale` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '月售',
  `price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '价格',
  `orgin_price` decimal(10,2) unsigned NOT NULL COMMENT '原价',
  `activity_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '参加的活动ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4456 DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id ',
  `order_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单编号',
  `user_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '用户ID',
  `item_ids` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '所有商品ID，用;分割',
  `total_price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '总价',
  `addr_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '地址ID',
  `pay_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '支付时间',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delivery_time` datetime NOT NULL COMMENT '送餐时间',
  `pay_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '支付方式，支付宝，微信，银行卡',
  `comments` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注信息',
  `shop_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '店铺名称',
  `shop_id` int(10) unsigned NOT NULL COMMENT '店铺 Id',
  `delivery_pay` decimal(10,2) DEFAULT NULL COMMENT '配送费用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Table structure for t_shop
-- ----------------------------
DROP TABLE IF EXISTS `t_shop`;
CREATE TABLE `t_shop` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `shop_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '商家名字',
  `title` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商家简介',
  `dispatch_pay` int(11) NOT NULL DEFAULT '0' COMMENT '配送费用',
  `dispatch_time` int(11) NOT NULL DEFAULT '0' COMMENT '配送时间',
  `assess_rate` decimal(10,1) unsigned NOT NULL DEFAULT '1.0' COMMENT '评价星级1-5',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '商家地址',
  `dispatch_price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '最低价',
  `salesroom_price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '门市价',
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '18702904814' COMMENT '商家电话',
  `business_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '营业时间',
  `main_picture` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '商家图',
  `average` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '人均价',
  `month_pay` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '月售',
  `shop_type` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '店铺类型（1.蛋糕甜点 2.火锅 3.小吃快餐 4.日韩料理 5.西餐 6. 烧烤烤肉 7.东北菜 8.川湘菜 9.浙江菜 10. 香锅烤鱼 11.粤菜 12.素食 13.粥/汤/炖菜 14.其他美食）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COMMENT='店铺表';


SET FOREIGN_KEY_CHECKS = 1;
