/*
SQLyog Ultimate v11.3 (64 bit)
MySQL - 5.5.28 : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) DEFAULT NULL,
  `SALARY` double DEFAULT NULL,
  `GMT_CREATED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `GMT_MODIFIED` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`ID`,`NAME`,`SALARY`,`GMT_CREATED`,`GMT_MODIFIED`) values (1,'bill',20000.99,'2017-06-08 21:59:04','2017-06-08 21:59:06'),(2,'name',NULL,'2017-06-08 22:16:21','2017-06-08 22:16:17'),(3,'name',NULL,'2017-06-08 22:17:06',NULL),(4,'name',NULL,'2017-06-08 22:17:20',NULL),(5,'name',NULL,'2017-06-08 22:18:50',NULL),(6,'name1496931600160',NULL,'2017-06-08 22:20:00',NULL),(7,'name1496931603955',NULL,'2017-06-08 22:20:03',NULL),(8,'name1496931606134',NULL,'2017-06-08 22:20:06',NULL),(9,'name1496932009075',NULL,'2017-06-08 22:26:49',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
