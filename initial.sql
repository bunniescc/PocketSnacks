SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `tb_account`;
CREATE TABLE `tb_account` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '账户编号',
  `uid` int(11) DEFAULT NULL COMMENT '用户编号',
  `money` double DEFAULT NULL COMMENT '账户金额',
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `gender` char(2) DEFAULT NULL COMMENT '性别',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `reg_time` datetime DEFAULT NULL COMMENT '注册时间',
  `account_id` int(11) DEFAULT NULL COMMENT '账户编号',
  PRIMARY KEY (`uid`),
  KEY `FK_Reference_3` (`account_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`account_id`) REFERENCES `tb_account` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `tb_address`;
CREATE TABLE `tb_address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '地址编号',
  `uid` int(11) NOT NULL COMMENT '用户编号',
  `full_address` varchar(200) NOT NULL COMMENT '详细地址',
  `phone` varchar(20) NOT NULL COMMENT '联系电话',
  `zip_code` varchar(7) NOT NULL COMMENT '邮编',
  `name` varchar(50) NOT NULL COMMENT '联系人姓名',
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  KEY `FK_Reference_4` (`uid`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`uid`) REFERENCES `tb_user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `tb_brand`;
CREATE TABLE `tb_brand` (
  `brand_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商家编号',
  `name` varchar(50) NOT NULL COMMENT '联系人姓名',
  `phone` varchar(20) NOT NULL COMMENT '电话',
  `email` varchar(50) NOT NULL COMMENT '邮箱',
  `address` varchar(200) NOT NULL COMMENT '公司详细地址',
  `state` char(1) NOT NULL COMMENT '状态0:合作,1:取消合作',
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `tb_cart`;
CREATE TABLE `tb_cart` (
  `cart_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车编号',
  `uid` int(11) DEFAULT NULL COMMENT '用户编号',
  `quantity` int(11) DEFAULT NULL COMMENT '商品名数量',
  `commodity_id` int(11) DEFAULT NULL COMMENT '商品编号',
  `fid` int(11) DEFAULT NULL COMMENT '口味编号',
  PRIMARY KEY (`cart_id`),
  KEY `FK_Reference_10` (`uid`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`uid`) REFERENCES `tb_user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类编号',
  `category_parent_id` int(11) NOT NULL COMMENT '父级编号',
  `name` varchar(20) NOT NULL COMMENT '类别名称',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `tb_commodity`;
CREATE TABLE `tb_commodity` (
  `commodity_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `category_id` int(11) NOT NULL COMMENT '类别编号',
  `brand_id` int(11) NOT NULL COMMENT '品牌编号',
  `name` varchar(50) NOT NULL COMMENT '商品名称',
  `promotional_price` double DEFAULT NULL COMMENT '促销价',
  `original_price` double NOT NULL COMMENT '原价',
  `description` varchar(500) NOT NULL COMMENT '商品描述',
  `img` varchar(30) NOT NULL COMMENT '商品图片名',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`commodity_id`),
  KEY `category_id` (`category_id`),
  KEY `store_id` (`brand_id`),
  CONSTRAINT `store_id` FOREIGN KEY (`brand_id`) REFERENCES `tb_brand` (`brand_id`),
  CONSTRAINT `tb_commodity_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `tb_category` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `tb_commodity_param`;
CREATE TABLE `tb_commodity_param` (
  `param_id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) DEFAULT NULL,
  `product_area` varchar(50) DEFAULT NULL,
  `product_place` varchar(50) DEFAULT NULL,
  `product_specification` varchar(50) DEFAULT NULL,
  `expiration_date` varchar(50) DEFAULT NULL,
  `usage` varchar(50) DEFAULT NULL,
  `storage_method` varchar(50) DEFAULT NULL,
  `standard_number` varchar(50) DEFAULT NULL,
  `license_number` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`param_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `tb_evaluate`;
CREATE TABLE `tb_evaluate` (
  `content` varchar(500) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `oid` varchar(80) DEFAULT NULL,
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `tb_flavor`;
CREATE TABLE `tb_flavor` (
  `fid` int(11) NOT NULL AUTO_INCREMENT COMMENT '口味编号',
  `name` varchar(30) NOT NULL COMMENT '口味名称',
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `tb_flavor_commodity`;
CREATE TABLE `tb_flavor_commodity` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `fid` int(11) NOT NULL COMMENT '',
  `commodity_id` int(11) NOT NULL COMMENT '',
  `stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_2` (`fid`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`fid`) REFERENCES `tb_flavor` (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `oid` varchar(80) NOT NULL COMMENT '订单编号',
  `uid` int(11) DEFAULT NULL COMMENT '用户编号',
  `total_price` double DEFAULT NULL COMMENT '总价',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `order_time` datetime DEFAULT NULL COMMENT '下单时间',
  `state` int(11) DEFAULT NULL COMMENT '订单状态:0:待付款,1:待发货,2:待收货,3:待评价',
  `address_id` int(11) DEFAULT NULL COMMENT '地址编号',
  PRIMARY KEY (`oid`),
  KEY `FK_Reference_6` (`uid`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`uid`) REFERENCES `tb_user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `tb_order_detail`;
CREATE TABLE `tb_order_detail` (
  `detail_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `commodity_id` int(11) DEFAULT NULL COMMENT '商品编号',
  `quantity` int(11) DEFAULT NULL COMMENT '商品数量',
  `price` double DEFAULT NULL COMMENT '单价',
  `fid` int(11) DEFAULT NULL COMMENT '口味编号',
  `brand_id` int(11) DEFAULT NULL COMMENT '品牌编号',
  `oid` varchar(80) DEFAULT NULL COMMENT '订单编号',
  PRIMARY KEY (`detail_id`),
  KEY `FK_Reference_1` (`fid`),
  KEY `FK_Reference_8` (`brand_id`),
  KEY `FK_Reference_9` (`oid`),
  KEY `commodity_id` (`commodity_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`fid`) REFERENCES `tb_flavor` (`fid`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`brand_id`) REFERENCES `tb_brand` (`brand_id`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`oid`) REFERENCES `tb_order` (`oid`),
  CONSTRAINT `tb_order_detail_ibfk_1` FOREIGN KEY (`commodity_id`) REFERENCES `tb_commodity` (`commodity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `tb_category` VALUES ('1', '0', '休闲食品');
INSERT INTO `tb_category` VALUES ('2', '0', '粮油调味');
INSERT INTO `tb_category` VALUES ('3', '0', '进口食品');
INSERT INTO `tb_category` VALUES ('4', '0', '营养辅食');
INSERT INTO `tb_category` VALUES ('5', '0', '饮料冲调');
INSERT INTO `tb_category` VALUES ('6', '0', '个性零食');
INSERT INTO `tb_category` VALUES ('7', '0', '价格');
INSERT INTO `tb_category` VALUES ('8', '1', '休闲零食');
INSERT INTO `tb_category` VALUES ('9', '1', '饼干蛋糕');
INSERT INTO `tb_category` VALUES ('10', '1', '肉干肉脯');
INSERT INTO `tb_category` VALUES ('11', '1', '糖果/巧克力');
INSERT INTO `tb_category` VALUES ('12', '1', '坚果炒货');
INSERT INTO `tb_category` VALUES ('13', '1', '蜜饯果干');
INSERT INTO `tb_category` VALUES ('14', '1', '熟食腊味');
INSERT INTO `tb_category` VALUES ('15', '1', '膨化食品');
INSERT INTO `tb_category` VALUES ('16', '2', '方便食品');
INSERT INTO `tb_category` VALUES ('17', '2', '食用油');
INSERT INTO `tb_category` VALUES ('18', '2', '杂粮');
INSERT INTO `tb_category` VALUES ('19', '2', '南北干货');
INSERT INTO `tb_category` VALUES ('20', '2', '调味品');
INSERT INTO `tb_category` VALUES ('21', '2', '烘焙原料');
INSERT INTO `tb_category` VALUES ('22', '2', '米');
INSERT INTO `tb_category` VALUES ('23', '2', '面');
INSERT INTO `tb_category` VALUES ('24', '3', '饼干蛋糕');
INSERT INTO `tb_category` VALUES ('25', '3', '休闲零食');
INSERT INTO `tb_category` VALUES ('26', '3', '糖果/巧克力');
INSERT INTO `tb_category` VALUES ('27', '3', '方便食品');
INSERT INTO `tb_category` VALUES ('28', '3', '咖啡豆/咖啡粉');
INSERT INTO `tb_category` VALUES ('29', '3', '冲调品');
INSERT INTO `tb_category` VALUES ('30', '3', '米面调油');
INSERT INTO `tb_category` VALUES ('31', '3', '饮料');
INSERT INTO `tb_category` VALUES ('32', '3', '牛奶');
INSERT INTO `tb_category` VALUES ('33', '3', '油');
INSERT INTO `tb_category` VALUES ('34', '4', '宝宝零食');
INSERT INTO `tb_category` VALUES ('35', '4', '果汁/果泥');
INSERT INTO `tb_category` VALUES ('36', '4', '米粉/菜粉');
INSERT INTO `tb_category` VALUES ('37', '4', '钙铁锌/维生素');
INSERT INTO `tb_category` VALUES ('38', '4', '面条/粥');
INSERT INTO `tb_category` VALUES ('39', '4', '清火/开胃');
INSERT INTO `tb_category` VALUES ('40', '4', '益生菌');
INSERT INTO `tb_category` VALUES ('41', '5', '冲饮谷物');
INSERT INTO `tb_category` VALUES ('42', '5', '饮料');
INSERT INTO `tb_category` VALUES ('43', '5', '牛奶乳品');
INSERT INTO `tb_category` VALUES ('44', '5', '咖啡/奶茶');
INSERT INTO `tb_category` VALUES ('45', '5', '成人奶粉');
INSERT INTO `tb_category` VALUES ('46', '5', '蜂蜜/柚子茶');
INSERT INTO `tb_category` VALUES ('47', '7', '0-25');
INSERT INTO `tb_category` VALUES ('48', '7', '26-50');
INSERT INTO `tb_category` VALUES ('49', '7', '50以上');
INSERT INTO `tb_category` VALUES ('50', '0', '海鲜制品');
INSERT INTO `tb_category` VALUES ('51', '0', '其他');
