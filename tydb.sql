-- MySQL dump 10.13  Distrib 5.7.21, for Win64 (x86_64)
--
-- Host: localhost    Database: ty_dbs
-- ------------------------------------------------------
-- Server version	5.7.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ty_configs`
--
DROP DATABASE if exists tydbs ;
CREATE DATABASE tydbs default character set 'utf8';
use tydbs;
DROP TABLE IF EXISTS `ty_configs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ty_configs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '参数名',
  `value` varchar(50) DEFAULT NULL COMMENT '参数值',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='配置管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_configs`
--

LOCK TABLES `ty_configs` WRITE;
/*!40000 ALTER TABLE `ty_configs` DISABLE KEYS */;
INSERT INTO `ty_configs` VALUES (4,'uploadPath','/upload/images','上传路径','2018-04-22 17:39:55','2018-04-22 17:39:55',NULL,NULL),(5,'downloadPath','/downloads/','文件下载路径','2018-04-22 17:40:41','2018-04-22 17:40:41',NULL,NULL);
/*!40000 ALTER TABLE `ty_configs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_depts`
--

DROP TABLE IF EXISTS `ty_depts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ty_depts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `parentId` int(11) DEFAULT NULL COMMENT '上级部门',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='部门管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_depts`
--

LOCK TABLES `ty_depts` WRITE;
/*!40000 ALTER TABLE `ty_depts` DISABLE KEYS */;
INSERT INTO `ty_depts` VALUES (2,'dept-a',NULL,1,'dept-a ..','2018-04-19 18:59:09','2018-04-19 18:59:09','admin','admin'),(3,'dept-b',NULL,2,'1111','2018-04-19 19:15:05','2018-04-19 19:15:05',NULL,NULL),(4,'dept-aa',2,1,'','2018-04-22 18:10:58','2018-04-22 22:11:47',NULL,NULL);
/*!40000 ALTER TABLE `ty_depts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_dicts`
--

DROP TABLE IF EXISTS `ty_dicts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ty_dicts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '名字',
  `type` varchar(20) DEFAULT NULL COMMENT '类型',
  `code` varchar(20) DEFAULT NULL COMMENT '字典码',
  `value` varchar(100) DEFAULT NULL COMMENT '字典值',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `valid` tinyint(4) DEFAULT '1' COMMENT '有效',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_dicts`
--

LOCK TABLES `ty_dicts` WRITE;
/*!40000 ALTER TABLE `ty_dicts` DISABLE KEYS */;
/*!40000 ALTER TABLE `ty_dicts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_logs`
--

DROP TABLE IF EXISTS `ty_logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ty_logs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='系统日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_logs`
--

LOCK TABLES `ty_logs` WRITE;
/*!40000 ALTER TABLE `ty_logs` DISABLE KEYS */;
INSERT INTO `ty_logs` VALUES (9,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',3,'0:0:0:0:0:0:0:1','2018-04-17 19:53:38'),(10,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',2,'0:0:0:0:0:0:0:1','2018-04-17 19:54:05'),(11,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',1,'0:0:0:0:0:0:0:1','2018-04-17 19:54:36'),(12,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',155,'0:0:0:0:0:0:0:1','2018-04-18 15:14:44'),(13,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',165,'0:0:0:0:0:0:0:1','2018-04-19 18:52:35'),(14,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',75,'0:0:0:0:0:0:0:1','2018-04-19 19:10:36'),(15,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',69,'0:0:0:0:0:0:0:1','2018-04-19 19:12:46'),(16,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',187,'0:0:0:0:0:0:0:1','2018-04-19 23:27:14'),(17,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',103,'0:0:0:0:0:0:0:1','2018-04-20 13:11:37'),(18,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',85,'0:0:0:0:0:0:0:1','2018-04-20 13:55:04'),(19,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',89,'0:0:0:0:0:0:0:1','2018-04-20 13:57:12'),(20,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',69,'0:0:0:0:0:0:0:1','2018-04-20 13:58:32'),(21,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',291,'0:0:0:0:0:0:0:1','2018-04-20 15:22:55'),(22,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',158,'0:0:0:0:0:0:0:1','2018-04-22 16:20:56'),(23,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',94,'0:0:0:0:0:0:0:1','2018-04-22 17:05:34'),(24,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',138,'0:0:0:0:0:0:0:1','2018-04-22 17:20:32'),(25,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',124,'0:0:0:0:0:0:0:1','2018-04-22 17:24:12'),(26,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',75,'0:0:0:0:0:0:0:1','2018-04-22 17:31:51'),(27,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',148,'0:0:0:0:0:0:0:1','2018-04-22 17:33:25'),(28,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',69,'0:0:0:0:0:0:0:1','2018-04-22 17:39:26'),(29,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',120,'0:0:0:0:0:0:0:1','2018-04-22 19:10:28'),(30,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',104,'0:0:0:0:0:0:0:1','2018-04-22 19:23:56'),(31,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',79,'0:0:0:0:0:0:0:1','2018-04-22 19:42:40'),(32,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',71,'0:0:0:0:0:0:0:1','2018-04-22 19:58:49'),(33,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',201,'0:0:0:0:0:0:0:1','2018-04-22 20:02:01'),(34,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',119,'0:0:0:0:0:0:0:1','2018-04-22 20:26:31'),(35,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',131,'0:0:0:0:0:0:0:1','2018-04-22 20:58:21'),(36,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',9,'192.168.43.1','2018-04-22 21:32:25'),(37,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',6,'192.168.43.183','2018-04-22 21:34:40'),(38,'admin','登陆操作','com.jt.ty.service.impl.tyUserServiceImpl.login()','\"admin\"',4,'192.168.43.211','2018-04-22 22:10:04');
/*!40000 ALTER TABLE `ty_logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_menus`
--

DROP TABLE IF EXISTS `ty_menus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ty_menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `url` varchar(200) DEFAULT NULL COMMENT '资源URL',
  `type` int(11) DEFAULT NULL COMMENT '类型     1：菜单   2：按钮',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  `parentId` int(11) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `permission` varchar(500) DEFAULT NULL COMMENT '授权(如：user:create)',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8 COMMENT='资源管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_menus`
--

LOCK TABLES `ty_menus` WRITE;
/*!40000 ALTER TABLE `ty_menus` DISABLE KEYS */;
INSERT INTO `ty_menus` VALUES (8,'系统管理','请求路径',1,8,NULL,NULL,'ty:list','2017-07-12 15:15:59','2017-07-21 11:16:00','admin','admin'),(24,'系统配置','请求路径',1,24,NULL,8,NULL,'2017-07-12 15:15:59','2017-07-12 15:15:59','admin','admin'),(25,'日志管理','请求路径',1,25,NULL,8,NULL,'2017-07-12 15:15:59','2017-07-12 15:15:59','admin','admin'),(45,'用户管理','user/listUI.do',1,45,NULL,8,'ty:user:view','2017-07-12 15:15:59','2017-07-21 17:36:01','admin','admin'),(46,'菜单管理','menu/listUI.do',1,46,NULL,8,'ty:menu:view','2017-07-12 15:15:59','2017-07-21 17:36:16','admin','admin'),(47,'角色管理','role/listUI.do',1,47,NULL,8,'ty:role:view','2017-07-12 15:15:59','2017-07-21 17:38:03','admin','admin'),(48,'组织管理','请求路径',1,48,NULL,8,'ty:org:view','2017-07-12 15:15:59','2017-07-21 18:37:57','admin','admin'),(115,'查看','',2,1,NULL,46,'ty:menu:view','2017-07-13 16:33:41','2017-07-21 11:09:05',NULL,NULL),(116,'新增','',2,2,NULL,46,'ty:menu:add','2017-07-13 16:34:02','2017-07-21 11:09:22',NULL,NULL),(117,'修改','',2,3,NULL,46,'ty:menu:update','2017-07-13 16:34:25','2017-07-21 11:09:45',NULL,NULL),(118,'删除','',2,4,NULL,46,'ty:menu:delete','2017-07-13 16:34:46','2017-07-21 11:10:12',NULL,NULL),(119,'查看','',2,1,NULL,45,'ty:user:view','2017-07-13 16:35:05','2017-07-21 11:12:46',NULL,NULL),(120,'查看','',2,1,NULL,47,'ty:role:view','2017-07-13 16:35:26','2017-07-21 11:13:43',NULL,NULL),(126,'新增','',2,2,NULL,45,'ty:user:add','2017-07-21 11:11:34','2017-07-21 11:11:34',NULL,NULL),(127,'修改','',2,3,NULL,45,'ty:user:update','2017-07-21 11:11:56','2017-07-21 11:11:56',NULL,NULL),(128,'新增','',2,2,NULL,47,'ty:role:add','2017-07-21 11:14:24','2017-07-21 11:14:24',NULL,NULL),(129,'修改','',2,3,NULL,47,'ty:role:update','2017-07-21 11:14:48','2017-07-21 11:14:48',NULL,NULL),(130,'删除','',2,4,NULL,47,'ty:role:delete','2017-07-21 11:15:09','2017-07-21 11:15:09',NULL,NULL);
/*!40000 ALTER TABLE `ty_menus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_role_menus`
--

DROP TABLE IF EXISTS `ty_role_menus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ty_role_menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `menu_id` int(11) DEFAULT NULL COMMENT 'ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1250 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_role_menus`
--

LOCK TABLES `ty_role_menus` WRITE;
/*!40000 ALTER TABLE `ty_role_menus` DISABLE KEYS */;
INSERT INTO `ty_role_menus` VALUES (1232,1,8),(1233,1,24),(1234,1,25),(1235,1,45),(1236,1,119),(1237,1,126),(1238,1,127),(1239,1,46),(1240,1,115),(1241,1,116),(1242,1,117),(1243,1,118),(1244,1,47),(1245,1,120),(1246,1,128),(1247,1,129),(1248,1,130),(1249,1,48);
/*!40000 ALTER TABLE `ty_role_menus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_roles`
--

DROP TABLE IF EXISTS `ty_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ty_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COMMENT='角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_roles`
--

LOCK TABLES `ty_roles` WRITE;
/*!40000 ALTER TABLE `ty_roles` DISABLE KEYS */;
INSERT INTO `ty_roles` VALUES (1,'系统管理员','系统管理员','2017-07-13 17:44:11','2018-04-22 20:53:32','admin','admin'),(45,'运维经理','运维经理..','2018-04-22 20:51:43','2018-04-22 20:51:43',NULL,NULL);
/*!40000 ALTER TABLE `ty_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_user_roles`
--

DROP TABLE IF EXISTS `ty_user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ty_user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_user_roles`
--

LOCK TABLES `ty_user_roles` WRITE;
/*!40000 ALTER TABLE `ty_user_roles` DISABLE KEYS */;
INSERT INTO `ty_user_roles` VALUES (65,1,1),(66,16,45),(67,15,45);
/*!40000 ALTER TABLE `ty_user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ty_users`
--

DROP TABLE IF EXISTS `ty_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ty_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(50) DEFAULT NULL COMMENT '盐  密码加密时前缀，使加密后的值不同',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `valid` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常  默认值 ：1',
  `deptId` int(11) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='系统用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_users`
--

LOCK TABLES `ty_users` WRITE;
/*!40000 ALTER TABLE `ty_users` DISABLE KEYS */;
INSERT INTO `ty_users` VALUES (1,'admin','4ebd394fbd25e495e0753a7dc9889a8e','7adb778c-e7d3-4dd3-a3c5-5f80a158006d','admin@t.cn','13624356789',1,3,NULL,'2018-04-22 20:53:48',NULL,'admin'),(2,'zhangli','bdcf69375bdb532e50279b91eb00940d','5e7cbd36-e897-4951-b42b-19809caf3caa','zhangli@t.cn','13678909876',0,3,'2017-07-18 10:01:51','2018-04-22 20:49:19',NULL,'admin'),(3,'wangke','c5dc32ec66041aeddf432b3146bd2257','5e3e1475-1ea9-4a6a-976e-b07545827139','wangke@t.cn','18678900987',1,3,'2017-07-18 11:40:53','2018-04-22 20:48:52',NULL,NULL),(4,'zhangql','+HBpqtPuj9KLBIpneR5X0A==','ed487fac-9952-45c9-acaa-21dab9c689cc','zhangql@t.cn','13678909876',1,2,'2017-07-18 12:17:30','2018-04-22 20:48:04',NULL,NULL),(5,'fanwei','1acab7425d6dfae670f26bd160518902','34fbedb2-e135-4f8d-b595-24360edc348d','fanwei@t.cn','13876545678',1,3,'2017-07-20 17:03:22','2018-04-22 20:47:49',NULL,NULL),(6,'wumei','431ebdcccf3404787a144f9ba669a8e2','8a14f46f-7a17-4dfe-85ab-08e63cb618ce','wumei@t.cn','13567898765',1,2,'2017-07-21 10:57:40','2018-04-22 20:46:49',NULL,NULL),(7,'user-003','689c673a0d8bda7ee795dd45a126ae96','3faa1d2b-a99f-4ffb-9d29-0e71563258af','t@t.com','123',1,3,'2018-01-12 23:19:58','2018-04-22 20:46:07',NULL,'admin'),(9,'user-002','e10adc3949ba59abbe56e057f20f883e',NULL,'t@t.com','123',1,3,'2018-01-12 23:20:31','2018-04-22 20:45:55',NULL,NULL),(12,'user-001','5bf6593afd106aa544000d559f0c2241','9528e727-2901-4746-8558-9010d9607da2','t@t.com','123',1,3,'2018-01-13 01:48:32','2018-04-22 20:45:37',NULL,NULL),(13,'user-c','2630d8bd50c76abf001a9daceeae97e6','30fff766-e245-4a93-9f5e-6eb2c2cec494','t@t.com','123456',0,3,'2018-01-13 02:01:56','2018-04-22 20:43:58',NULL,'admin'),(15,'user-b','2ce586af95c6431112092f653659c85f','eaedbaee-d760-40e4-b71e-ccecf01b6187','t@t.com','123456',1,3,'2018-01-13 02:02:06','2018-04-22 20:54:10',NULL,'admin'),(16,'user-a','710058cf374a38d76510d009f63bf28d','e8e35b96-bbdd-4090-81ee-b71a36141760','1@t.com','121212',NULL,2,'2018-04-22 19:43:11','2018-04-22 20:54:02',NULL,NULL);
/*!40000 ALTER TABLE `ty_users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-23  8:36:18
