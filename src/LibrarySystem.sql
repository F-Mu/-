/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.28-log : Database - librarysystem
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`librarysystem` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `librarysystem`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `admin_id` char(10) NOT NULL,
  `admin_name` varchar(10) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`admin_id`,`admin_name`) values ('1001','江野'),('1002','顾浪行');

/*Table structure for table `alogin` */

DROP TABLE IF EXISTS `alogin`;

CREATE TABLE `alogin` (
  `admin_id` char(10) NOT NULL,
  `admin_password` char(10) NOT NULL,
  PRIMARY KEY (`admin_id`),
  CONSTRAINT `FK_alogin_admin` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `alogin` */

insert  into `alogin`(`admin_id`,`admin_password`) values ('1001','123456'),('1002','123456');

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `b_id` char(10) NOT NULL,
  `b_name` varchar(50) NOT NULL,
  `ISBN` char(17) NOT NULL,
  `bt_id` char(10) NOT NULL,
  `b_author` varchar(25) NOT NULL,
  `b_publish` varchar(50) NOT NULL,
  `b_intr` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`b_id`),
  KEY `FK_book_booktype` (`bt_id`),
  CONSTRAINT `FK_book_booktype` FOREIGN KEY (`bt_id`) REFERENCES `booktype` (`bt_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`b_id`,`b_name`,`ISBN`,`bt_id`,`b_author`,`b_publish`,`b_intr`) values ('100001','数据库系统概论','978-7-04-040664-1','1','王珊，萨师煊','高等教育出版社',NULL),('100002','算法设计与分析','978-7-302-30752-5','1','王红梅，胡明','清华大学出版社',NULL),('100003','概率论与数理统计','978-7-113-26635-6','5','崔学慧','中国铁道出版社',NULL),('100004','Java程序设计实用教程','978-7-121-34441-1','1','叶核亚','电子工业出版社',NULL),('100005','Python程序设计基础','978-7-302-40526-9','1','周元哲','清华大学出版社',NULL),('100006','数字逻辑','978-7-5609-3947-6','1','欧阳星明','华中科技大学出版社',NULL),('100007','C#程序设计教程','978-7-302-52999-6','1','蒙祖强','清华大学出版社',NULL),('100008','Swift入门经典','978-7-115-44439-4','1','BJ Miller','人民邮电出版社',NULL),('100009','渗透力学基础','7-5021-5704-2','6','王晓冬','石油工业出版社',NULL),('100010','日语阅读教程','978-7-5135-4354-5','7','曹铁英','外语教学于研究出版社',NULL),('100011','山月记','978-7-5518-1925-1','2','中岛敦','三秦出版社',NULL),('100012','百年孤独','978-7-5442-9117-0','2','加西亚·马尔克斯','南海出版公司',NULL),('100013','玛尔戈王后','978-7-5133-2630-8','2','大仲马','新星出版社',NULL),('100014','流动的圣节','978-7-5339-5193-1','3','欧内斯特·海明威','浙江文艺出版社',NULL),('100015','萨特文集','978-7-02-013288-1','4','沈志明，夏玟','人民文学出版社',NULL),('100016','罗生门','978-7-210-09362-6','2','芥川龙之介','江西人民出版社',NULL),('100017','博弈论','978-7-300-11785-0','8','朱·弗登博格，让·梯若尔','中国人民大学出版社',NULL),('100018','机器学习','978-7-302-42328-7','1','周志华','清华大学出版社',''),('100019','西班牙语基础语法与练习','978-7-301-06526-6','7','常福良','北京大学出版社',''),('100020','统计学习方法','978-7-302-27595-4','1','李航','清华大学出版社',''),('100021','数学建模','978-7-115-50497-5','5','梁进','人民邮电出版社',''),('100022','十日谈','978-7-5063-8021-8','4','乔万尼·薄伽丘','作家出版社','');

/*Table structure for table `booktype` */

DROP TABLE IF EXISTS `booktype`;

CREATE TABLE `booktype` (
  `bt_id` char(10) NOT NULL,
  `bt_name` varchar(10) NOT NULL,
  PRIMARY KEY (`bt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `booktype` */

insert  into `booktype`(`bt_id`,`bt_name`) values ('1','计算机'),('2','小说'),('3','传记'),('4','文学'),('5','数学'),('6','物理'),('7','语言'),('8','经济');

/*Table structure for table `borrow` */

DROP TABLE IF EXISTS `borrow`;

CREATE TABLE `borrow` (
  `r_id` char(10) NOT NULL,
  `b_id` char(10) NOT NULL,
  `borrow_date` date NOT NULL,
  `expect_return_date` date NOT NULL,
  PRIMARY KEY (`r_id`,`b_id`),
  KEY `FK_borrow_book` (`b_id`),
  CONSTRAINT `FK_borrow_book` FOREIGN KEY (`b_id`) REFERENCES `book` (`b_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_borrow_reader` FOREIGN KEY (`r_id`) REFERENCES `reader` (`r_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `borrow` */

insert  into `borrow`(`r_id`,`b_id`,`borrow_date`,`expect_return_date`) values ('2017010537','100016','2020-07-04','2020-08-04'),('2017010537','100019','2020-07-02','2020-08-02'),('2017035232','100002','2020-06-29','2020-07-29'),('2017035232','100006','2020-06-29','2020-07-29'),('2018011137','100008','2020-07-04','2020-08-04'),('2018011137','100010','2020-07-04','2020-08-04'),('2018011160','100001','2020-07-01','2020-08-01'),('2018011160','100012','2020-07-03','2020-08-03'),('2018011160','100019','2020-07-01','2020-08-01'),('2018015558','100012','2020-07-02','2020-08-02'),('2019021341','100017','2020-06-01','2020-07-01');

/*Table structure for table `bpenalty` */

DROP TABLE IF EXISTS `bpenalty`;

CREATE TABLE `bpenalty` (
  `r_id` char(10) NOT NULL,
  `b_id` char(10) NOT NULL,
  `over_date` int(11) NOT NULL,
  `penalty` float NOT NULL,
  KEY `FK_bpenalty_book` (`b_id`),
  KEY `index_rid_bid3` (`r_id`,`b_id`),
  CONSTRAINT `FK_bpenalty_book` FOREIGN KEY (`b_id`) REFERENCES `book` (`b_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_bpenalty_reader` FOREIGN KEY (`r_id`) REFERENCES `reader` (`r_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bpenalty` */

insert  into `bpenalty`(`r_id`,`b_id`,`over_date`,`penalty`) values ('2016003217','100001',59,5.9),('2016003217','100010',41,4.1),('2017035232','100010',31,3.1),('2018011137','100011',31,3.1),('2018011136','100011',1,0.1),('2018011136','100017',30,3),('2017051401','100012',1,0.1),('2019021341','100011',3,0.3),('2018014354','100008',20,2),('2019014213','100015',4,0.4);

/*Table structure for table `bquantity` */

DROP TABLE IF EXISTS `bquantity`;

CREATE TABLE `bquantity` (
  `b_id` char(10) NOT NULL,
  `b_num` int(11) NOT NULL,
  `b_remain` int(11) NOT NULL,
  PRIMARY KEY (`b_id`),
  CONSTRAINT `FK_bquantity_book` FOREIGN KEY (`b_id`) REFERENCES `book` (`b_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bquantity` */

insert  into `bquantity`(`b_id`,`b_num`,`b_remain`) values ('100001',21,20),('100002',10,8),('100003',7,7),('100004',5,5),('100005',5,5),('100006',10,9),('100007',1,1),('100008',7,5),('100009',4,4),('100010',7,6),('100011',6,6),('100012',6,5),('100013',8,8),('100014',9,9),('100015',10,10),('100016',4,3),('100017',2,1),('100018',5,5),('100019',7,5),('100020',9,9),('100021',5,5),('100022',4,4);

/*Table structure for table `reader` */

DROP TABLE IF EXISTS `reader`;

CREATE TABLE `reader` (
  `r_id` char(10) NOT NULL,
  `r_name` varchar(10) NOT NULL,
  `r_sex` bit(1) NOT NULL,
  `r_dept` char(20) NOT NULL,
  `r_grade` char(10) NOT NULL,
  PRIMARY KEY (`r_id`),
  KEY `index_rname` (`r_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `reader` */

insert  into `reader`(`r_id`,`r_name`,`r_sex`,`r_dept`,`r_grade`) values ('2016003217','吕晨','','数学','2016'),('2016003225','廖思源','','数学','2016'),('2017010537','沈建颖','','石油工程','2017'),('2017010564','苏元洲','','石油工程','2017'),('2017017530','陆念之','\0','计算机科学与技术','2017'),('2017017537','韩立轩','','计算机科学与技术','2017'),('2017017582','邓蕴和','','计算机科学与技术','2017'),('2017035216','叶贤','\0','管理','2017'),('2017035232','金溢','','管理','2017'),('2017051401','漕俊喆','','数学','2017'),('2017051422','李想','','数学','2017'),('2017051453','袁允','\0','数学','2017'),('2018011136','赵欣冉','\0','计算机科学与技术','2018'),('2018011137','陈若朋','','计算机科学与技术','2018'),('2018011138','冯泽云','','计算机科学与技术','2018'),('2018011160','刘柠','\0','计算机科学与技术','2018'),('2018011725','张三','','数学','2018'),('2018014328','贾情','\0','数学','2018'),('2018014354','江晗日','','数学','2018'),('2018015533','祁旭','','石油工程','2018'),('2018015558','田子悦','\0','石油工程','2018'),('2018015836','徐嘉勋','','管理','2018'),('2018015893','文庄','\0','管理','2018'),('2018042030','卢方彤','\0','英语','2018'),('2018042037','萧竣','','英语','2018'),('2019014205','汤澜','\0','管理','2019'),('2019014213','孔元白','','管理','2019'),('2019021324','段盈','\0','计算机科学与技术','2019'),('2019021341','姜天韵','','计算机科学与技术','2019'),('2019021377','贺乐音','\0','计算机科学与技术','2019');

/*Table structure for table `revert` */

DROP TABLE IF EXISTS `revert`;

CREATE TABLE `revert` (
  `r_id` char(10) NOT NULL,
  `b_id` char(10) NOT NULL,
  `borrow_date` date NOT NULL,
  `revert_date` date NOT NULL,
  PRIMARY KEY (`r_id`,`b_id`,`revert_date`),
  KEY `FK_return_book` (`b_id`),
  KEY `index_rid_bid2` (`r_id`,`b_id`),
  CONSTRAINT `FK_return_book` FOREIGN KEY (`b_id`) REFERENCES `book` (`b_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_return_reader` FOREIGN KEY (`r_id`) REFERENCES `reader` (`r_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `revert` */

insert  into `revert`(`r_id`,`b_id`,`borrow_date`,`revert_date`) values ('2016003217','100001','2020-03-31','2020-06-29'),('2016003217','100002','2020-06-18','2020-06-29'),('2016003217','100010','2020-04-18','2020-06-29'),('2016003217','100022','2020-07-03','2020-07-04'),('2017035232','100002','2020-06-27','2020-06-29'),('2017035232','100010','2020-04-28','2020-06-29'),('2017035232','100012','2020-06-27','2020-06-29'),('2017051401','100012','2020-05-31','2020-07-02'),('2018011136','100005','2020-07-04','2020-07-04'),('2018011136','100006','2020-06-30','2020-07-01'),('2018011136','100007','2020-06-30','2020-07-04'),('2018011136','100008','2020-06-30','2020-07-01'),('2018011136','100011','2020-05-31','2020-07-01'),('2018011136','100014','2020-07-01','2020-07-04'),('2018011136','100015','2020-07-03','2020-07-04'),('2018011136','100017','2020-04-30','2020-07-01'),('2018011137','100001','2020-06-24','2020-06-26'),('2018011137','100001','2020-06-25','2020-06-29'),('2018011137','100001','2020-07-04','2020-07-04'),('2018011137','100002','2020-06-25','2020-06-29'),('2018011137','100006','2020-06-28','2020-06-29'),('2018011137','100006','2020-07-03','2020-07-04'),('2018011137','100008','2020-07-03','2020-07-04'),('2018011137','100009','2020-06-28','2020-06-29'),('2018011137','100010','2020-06-28','2020-06-29'),('2018011137','100010','2020-07-03','2020-07-04'),('2018011137','100011','2020-04-28','2020-06-29'),('2018011137','100012','2020-07-04','2020-07-04'),('2018011137','100014','2020-07-03','2020-07-04'),('2018011137','100017','2020-06-30','2020-07-01'),('2018011137','100018','2020-06-30','2020-07-01'),('2018011137','100020','2020-06-30','2020-07-01'),('2018011137','100021','2020-07-01','2020-07-02'),('2018011137','100021','2020-07-03','2020-07-04'),('2018011137','100022','2020-07-03','2020-07-04'),('2018011138','100001','2020-07-03','2020-07-04'),('2018011138','100008','2020-07-04','2020-07-04'),('2018011160','100006','2020-06-30','2020-07-01'),('2018014354','100008','2020-05-13','2020-07-04'),('2018015533','100002','2020-06-28','2020-06-29'),('2018015533','100010','2020-06-28','2020-06-29'),('2019014213','100015','2020-05-29','2020-07-04'),('2019021341','100011','2020-05-28','2020-07-02');

/*Table structure for table `rlogin` */

DROP TABLE IF EXISTS `rlogin`;

CREATE TABLE `rlogin` (
  `r_id` char(10) NOT NULL,
  `r_password` char(10) NOT NULL,
  PRIMARY KEY (`r_id`),
  CONSTRAINT `FK_rlogin_reader` FOREIGN KEY (`r_id`) REFERENCES `reader` (`r_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `rlogin` */

insert  into `rlogin`(`r_id`,`r_password`) values ('2016003217','654321'),('2016003225','123456'),('2017010537','123456'),('2017010564','123456'),('2017017530','123456'),('2017017537','123456'),('2017017582','123456'),('2017035216','123456'),('2017035232','123456'),('2017051401','123456'),('2017051422','123456'),('2017051453','123456'),('2018011136','111111'),('2018011137','123456'),('2018011138','shabi'),('2018011160','123456'),('2018011725','213'),('2018014328','123456'),('2018014354','123456'),('2018015533','123456'),('2018015558','123456'),('2018015836','123456'),('2018015893','123456'),('2018042030','123456'),('2018042037','123456'),('2019014205','123456'),('2019014213','123456'),('2019021324','123456'),('2019021341','123456'),('2019021377','123456');

/*Table structure for table `book_b_v` */

DROP TABLE IF EXISTS `book_b_v`;

/*!50001 DROP VIEW IF EXISTS `book_b_v` */;
/*!50001 DROP TABLE IF EXISTS `book_b_v` */;

/*!50001 CREATE TABLE  `book_b_v`(
 `r_dept` char(20) ,
 `r_grade` int(11) ,
 `b_id` char(10) ,
 `b_name` varchar(50) ,
 `b_type` varchar(10) 
)*/;

/*Table structure for table `book_r_v` */

DROP TABLE IF EXISTS `book_r_v`;

/*!50001 DROP VIEW IF EXISTS `book_r_v` */;
/*!50001 DROP TABLE IF EXISTS `book_r_v` */;

/*!50001 CREATE TABLE  `book_r_v`(
 `r_dept` char(20) ,
 `r_grade` int(11) ,
 `b_id` char(10) ,
 `b_name` varchar(50) ,
 `b_type` varchar(10) 
)*/;

/*Table structure for table `book_v` */

DROP TABLE IF EXISTS `book_v`;

/*!50001 DROP VIEW IF EXISTS `book_v` */;
/*!50001 DROP TABLE IF EXISTS `book_v` */;

/*!50001 CREATE TABLE  `book_v`(
 `r_dept` char(20) ,
 `r_grade` int(11) ,
 `b_id` char(10) ,
 `b_name` varchar(50) ,
 `b_type` varchar(10) 
)*/;

/*Table structure for table `borrow_v` */

DROP TABLE IF EXISTS `borrow_v`;

/*!50001 DROP VIEW IF EXISTS `borrow_v` */;
/*!50001 DROP TABLE IF EXISTS `borrow_v` */;

/*!50001 CREATE TABLE  `borrow_v`(
 `r_id` char(10) ,
 `b_id` char(10) ,
 `r_name` varchar(10) ,
 `b_name` varchar(50) ,
 `borrow_date` date ,
 `expect_return_date` date 
)*/;

/*Table structure for table `reader_b_r_v` */

DROP TABLE IF EXISTS `reader_b_r_v`;

/*!50001 DROP VIEW IF EXISTS `reader_b_r_v` */;
/*!50001 DROP TABLE IF EXISTS `reader_b_r_v` */;

/*!50001 CREATE TABLE  `reader_b_r_v`(
 `r_id` char(10) ,
 `b_id` char(10) ,
 `r_name` varchar(10) ,
 `b_name` varchar(50) ,
 `borrow_date` date ,
 `revert_date` date 
)*/;

/*Table structure for table `reader_g_v` */

DROP TABLE IF EXISTS `reader_g_v`;

/*!50001 DROP VIEW IF EXISTS `reader_g_v` */;
/*!50001 DROP TABLE IF EXISTS `reader_g_v` */;

/*!50001 CREATE TABLE  `reader_g_v`(
 `r_id` char(10) ,
 `r_name` varchar(10) ,
 `gradenum` int(11) 
)*/;

/*View structure for view book_b_v */

/*!50001 DROP TABLE IF EXISTS `book_b_v` */;
/*View structure for view book_r_v */

/*!50001 DROP TABLE IF EXISTS `book_r_v` */;
/*View structure for view book_v */

/*!50001 DROP TABLE IF EXISTS `book_v` */;
/*View structure for view borrow_v */

/*!50001 DROP TABLE IF EXISTS `borrow_v` */;

/*!50001 DROP TABLE IF EXISTS `reader_b_r_v` */;
/*View structure for view reader_g_v */

/*!50001 DROP TABLE IF EXISTS `reader_g_v` */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
