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

/*Data for the table `t_area` */

insert  into `t_area`(`id`,`area_code`,`area_name`,`create_time`,`create_by`,`create_by_user_id`) values (1,'EU','欧洲站点','2021-04-12 22:12:03','system',0),(2,'US','北美站点','2021-04-12 22:17:39','system',0);

/*Data for the table `t_site` */

insert  into `t_site`(`id`,`site_code`,`site_name`,`create_time`,`create_by`,`create_by_user_id`) values (1,'US','美国','2021-04-12 22:10:46','system',0),(2,'UK','英国','2021-04-12 22:11:10','system',0),(3,'FR','法国','2021-04-12 22:12:27','system',0),(4,'CA','加拿大','2021-04-12 22:14:01','system',0),(5,'MX','墨西哥','2021-04-12 22:14:24','system',0),(6,'DE','德国','2021-04-12 22:24:02','system',0),(7,'IT','意大利','2021-04-12 22:24:16','system',0),(8,'ES','西班牙','2021-04-12 22:24:34','system',0),(9,'NL','荷兰','2021-04-12 22:24:50','system',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
