/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 8.0.22 : Database - shardingsphere_jdbc_test
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shardingsphere_jdbc_test` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `shardingsphere_jdbc_test`;

/*Table structure for table `t_account_01` */

DROP TABLE IF EXISTS `t_account_01`;

CREATE TABLE `t_account_01` (
  `id` bigint unsigned NOT NULL COMMENT 'id',
  `account_name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号名',
  `account_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号简称',
  `area_id` int NOT NULL COMMENT '大区id',
  `site_id` int NOT NULL COMMENT '站点id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_by_user_id` int DEFAULT NULL COMMENT '创建人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='账号表';

/*Table structure for table `t_area` */

DROP TABLE IF EXISTS `t_area`;

CREATE TABLE `t_area` (
  `id` int NOT NULL AUTO_INCREMENT,
  `area_code` varchar(10) NOT NULL COMMENT '大区编码',
  `area_name` varchar(10) NOT NULL COMMENT '大区名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人',
  `create_by_user_id` int NOT NULL COMMENT '创建人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='大区表';

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_no` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单号',
  `order_qty` int NOT NULL COMMENT '订单数量',
  `order_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单日期',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建人',
  `create_by_user_id` int NOT NULL COMMENT '创建人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='订单表';

/*Table structure for table `t_order_202104` */

DROP TABLE IF EXISTS `t_order_202104`;

CREATE TABLE `t_order_202104` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单号',
  `order_qty` int NOT NULL COMMENT '订单数量',
  `order_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单日期',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建人',
  `create_by_user_id` int NOT NULL COMMENT '创建人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='订单表';

/*Table structure for table `t_order_202105` */

DROP TABLE IF EXISTS `t_order_202105`;

CREATE TABLE `t_order_202105` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单号',
  `order_qty` int NOT NULL COMMENT '订单数量',
  `order_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单日期',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建人',
  `create_by_user_id` int NOT NULL COMMENT '创建人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='订单表';

/*Table structure for table `t_site` */

DROP TABLE IF EXISTS `t_site`;

CREATE TABLE `t_site` (
  `id` int NOT NULL AUTO_INCREMENT,
  `site_code` varchar(4) NOT NULL COMMENT '站点编码',
  `site_name` varchar(10) NOT NULL COMMENT '站点名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人',
  `create_by_user_id` int NOT NULL COMMENT '创建人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='站点表';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
