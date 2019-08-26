CREATE DATABASE  IF NOT EXISTS `management` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `management`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: management
-- ------------------------------------------------------
-- Server version	5.7.26-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `db_class_subject`
--

DROP TABLE IF EXISTS `db_class_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `db_class_subject` (
  `id_class_sub` varchar(20) NOT NULL,
  `nameidclass` varchar(10) DEFAULT NULL,
  `nameidsub` varchar(10) DEFAULT NULL,
  `room` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_class_sub`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_class_subject`
--

LOCK TABLES `db_class_subject` WRITE;
/*!40000 ALTER TABLE `db_class_subject` DISABLE KEYS */;
INSERT INTO `db_class_subject` VALUES ('﻿18HCB_CTT011','﻿18HCB','CTT011','C32'),('﻿18HCB_CTT012','﻿18HCB','CTT012','C32');
/*!40000 ALTER TABLE `db_class_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `db_student_class_subject`
--

DROP TABLE IF EXISTS `db_student_class_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `db_student_class_subject` (
  `iddb_student_class_subject` varchar(30) NOT NULL,
  `nameidstudent` varchar(10) DEFAULT NULL,
  `nameidclass_subject` varchar(20) DEFAULT NULL,
  `pointmid` int(11) DEFAULT NULL,
  `pointfinal` int(11) DEFAULT NULL,
  `pointdifferent` int(11) DEFAULT NULL,
  `pointsum` float DEFAULT NULL,
  PRIMARY KEY (`iddb_student_class_subject`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_student_class_subject`
--

LOCK TABLES `db_student_class_subject` WRITE;
/*!40000 ALTER TABLE `db_student_class_subject` DISABLE KEYS */;
INSERT INTO `db_student_class_subject` VALUES ('1842001_﻿18HCB_CTT011','1842001','﻿18HCB_CTT011',5,6,7,6),('1842001_﻿18HCB_CTT012','1842001','﻿18HCB_CTT012',0,0,0,0),('184240162_﻿18HCB_CTT011','184240162','﻿18HCB_CTT011',0,0,0,0),('184240162_﻿18HCB_CTT012','184240162','﻿18HCB_CTT012',0,0,0,0),('18424016_﻿18HCB_CTT011','18424016','﻿18HCB_CTT011',1,10,10,7),('18424016_﻿18HCB_CTT012','18424016','﻿18HCB_CTT012',0,0,0,0),('184240172_﻿18HCB_CTT011','184240172','﻿18HCB_CTT011',0,0,0,0),('18424017_﻿18HCB_CTT011','18424017','﻿18HCB_CTT011',2,8,9,6),('18424017_﻿18HCB_CTT012','18424017','﻿18HCB_CTT012',0,0,0,0),('184240182_﻿18HCB_CTT011','184240182','﻿18HCB_CTT011',0,0,0,0),('184240182_﻿18HCB_CTT012','184240182','﻿18HCB_CTT012',0,0,0,0),('18424018_﻿18HCB_CTT011','18424018','﻿18HCB_CTT011',0,0,0,0),('18424018_﻿18HCB_CTT012','18424018','﻿18HCB_CTT012',0,0,0,0),('18424019_﻿18HCB_CTT011','18424019','﻿18HCB_CTT011',3,7,9,6),('18424019_﻿18HCB_CTT012','18424019','﻿18HCB_CTT012',0,0,0,0),('18424020_﻿18HCB_CTT011','18424020','﻿18HCB_CTT011',5,5,9,5),('18424020_﻿18HCB_CTT012','18424020','﻿18HCB_CTT012',0,0,0,0),('18424021_﻿18HCB_CTT011','18424021','﻿18HCB_CTT011',6,4,9,5),('18424021_﻿18HCB_CTT012','18424021','﻿18HCB_CTT012',0,0,0,0),('18424022_﻿18HCB_CTT011','18424022','﻿18HCB_CTT011',7,3,9,5),('18424022_﻿18HCB_CTT012','18424022','﻿18HCB_CTT012',0,0,0,0),('18424023_﻿18HCB_CTT011','18424023','﻿18HCB_CTT011',8,2,9,5),('18424023_﻿18HCB_CTT012','18424023','﻿18HCB_CTT012',0,0,0,0),('18424024_﻿18HCB_CTT011','18424024','﻿18HCB_CTT011',9,1,9,4),('18424024_﻿18HCB_CTT012','18424024','﻿18HCB_CTT012',0,0,0,0),('18424025_﻿18HCB_CTT011','18424025','﻿18HCB_CTT011',10,10,9,10),('18424025_﻿18HCB_CTT012','18424025','﻿18HCB_CTT012',0,0,0,0),('18424026_﻿18HCB_CTT011','18424026','﻿18HCB_CTT011',9,3,7,5),('18424026_﻿18HCB_CTT012','18424026','﻿18HCB_CTT012',0,0,0,0),('18424027_﻿18HCB_CTT011','18424027','﻿18HCB_CTT011',8,4,6,5),('18424027_﻿18HCB_CTT012','18424027','﻿18HCB_CTT012',0,0,0,0),('18424028_﻿18HCB_CTT011','18424028','﻿18HCB_CTT011',7,5,5,6),('18424028_﻿18HCB_CTT012','18424028','﻿18HCB_CTT012',0,0,0,0),('18424029_﻿18HCB_CTT011','18424029','﻿18HCB_CTT011',6,6,4,6),('18424029_﻿18HCB_CTT012','18424029','﻿18HCB_CTT012',0,0,0,0),('18424030_﻿18HCB_CTT011','18424030','﻿18HCB_CTT011',5,7,3,6),('18424030_﻿18HCB_CTT012','18424030','﻿18HCB_CTT012',0,0,0,0),('18424031_﻿18HCB_CTT011','18424031','﻿18HCB_CTT011',4,8,2,6),('18424031_﻿18HCB_CTT012','18424031','﻿18HCB_CTT012',0,0,0,0),('18424032_﻿18HCB_CTT011','18424032','﻿18HCB_CTT011',3,9,4,7),('18424032_﻿18HCB_CTT012','18424032','﻿18HCB_CTT012',0,0,0,0),('18424033_﻿18HCB_CTT011','18424033','﻿18HCB_CTT011',2,7,2,5),('18424033_﻿18HCB_CTT012','18424033','﻿18HCB_CTT012',0,0,0,0),('18424034_﻿18HCB_CTT011','18424034','﻿18HCB_CTT011',1,6,9,5),('18424034_﻿18HCB_CTT012','18424034','﻿18HCB_CTT012',0,0,0,0),('18424035_﻿18HCB_CTT011','18424035','﻿18HCB_CTT011',2,5,9,5),('18424035_﻿18HCB_CTT012','18424035','﻿18HCB_CTT012',0,0,0,0),('18424036_﻿18HCB_CTT011','18424036','﻿18HCB_CTT011',3,4,9,4),('18424036_﻿18HCB_CTT012','18424036','﻿18HCB_CTT012',0,0,0,0),('18424037_﻿18HCB_CTT011','18424037','﻿18HCB_CTT011',8,6,3,6),('18424037_﻿18HCB_CTT012','18424037','﻿18HCB_CTT012',0,0,0,0),('18424038_﻿18HCB_CTT011','18424038','﻿18HCB_CTT011',6,6,6,6),('18424038_﻿18HCB_CTT012','18424038','﻿18HCB_CTT012',0,0,0,0);
/*!40000 ALTER TABLE `db_student_class_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbaccount`
--

DROP TABLE IF EXISTS `dbaccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dbaccount` (
  `idacc` varchar(45) NOT NULL,
  `pass` varchar(45) DEFAULT NULL,
  `nameview` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idacc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbaccount`
--

LOCK TABLES `dbaccount` WRITE;
/*!40000 ALTER TABLE `dbaccount` DISABLE KEYS */;
INSERT INTO `dbaccount` VALUES ('1842001','1842001','StudentA'),('18424020','18424020','Vũ Phương Hoài'),('18424040','18424040','Huỳnh Anh change'),('giaovu','giaovu','Name\'s Teacher');
/*!40000 ALTER TABLE `dbaccount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbclass`
--

DROP TABLE IF EXISTS `dbclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dbclass` (
  `idclass` varchar(10) NOT NULL,
  `nameclass` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idclass`),
  UNIQUE KEY `idclass_UNIQUE` (`idclass`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbclass`
--

LOCK TABLES `dbclass` WRITE;
/*!40000 ALTER TABLE `dbclass` DISABLE KEYS */;
INSERT INTO `dbclass` VALUES ('18HCB',NULL);
/*!40000 ALTER TABLE `dbclass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbcontructorpk`
--

DROP TABLE IF EXISTS `dbcontructorpk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dbcontructorpk` (
  `idcontructorpk` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `timestart` timestamp(3) NULL DEFAULT NULL,
  `timefinish` timestamp(3) NULL DEFAULT NULL,
  PRIMARY KEY (`idcontructorpk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbcontructorpk`
--

LOCK TABLES `dbcontructorpk` WRITE;
/*!40000 ALTER TABLE `dbcontructorpk` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbcontructorpk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbregistrypk`
--

DROP TABLE IF EXISTS `dbregistrypk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dbregistrypk` (
  `iddbregistrypk` int(11) NOT NULL AUTO_INCREMENT,
  `idstudent` varchar(10) DEFAULT NULL,
  `idsubject` varchar(10) DEFAULT NULL,
  `namepoint` varchar(45) DEFAULT NULL,
  `hopepoint` int(11) DEFAULT NULL,
  `becauses` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`iddbregistrypk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbregistrypk`
--

LOCK TABLES `dbregistrypk` WRITE;
/*!40000 ALTER TABLE `dbregistrypk` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbregistrypk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbstudent`
--

DROP TABLE IF EXISTS `dbstudent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dbstudent` (
  `idstudent` bigint(11) NOT NULL,
  `namestudent` varchar(45) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `identity` bigint(11) DEFAULT NULL,
  `idclass` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idstudent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbstudent`
--

LOCK TABLES `dbstudent` WRITE;
/*!40000 ALTER TABLE `dbstudent` DISABLE KEYS */;
INSERT INTO `dbstudent` VALUES (1842001,'Vũ Phương Hoài','Nu',343234534,'18HCB'),(18424016,'Lê Đức','Nu',30124016,'18HCB'),(18424017,'Nguyễn Minh','Nu',30124017,'18HCB'),(18424018,'Võ Minh','Nu',30124018,'18HCB'),(18424019,'Hoàng Đình Sơn','Nu',30124018,'18HCB'),(18424020,'Vũ Phương Hoài','Nu',30124020,'18HCB'),(18424021,'Nguyễn Huy','Nu',30124021,'18HCB'),(18424022,'Hà Tiến','Nam',30124022,'18HCB'),(18424023,'Huỳnh Văn','Nam',30124023,'18HCB'),(18424024,'Trương Châu','Nam',30124024,'18HCB'),(18424025,'Trần Hoàng','Nam',30124025,'18HCB'),(18424026,'Nguyễn Xuân','Nam',30124026,'18HCB'),(18424027,'Lê Mạnh','Nam',30124027,'18HCB'),(18424028,'Vũ Mạnh','Nu',30124028,'18HCB'),(18424029,'Đặng Thị Như','Nu',30124029,'18HCB'),(18424030,'Thái Quang','Nu',30124030,'18HCB'),(18424031,'Trần Quốc','Nu',30124031,'18HCB'),(18424032,'Võ Lê Bảo','Nu',30124032,'18HCB'),(18424033,'Huỳnh Anh change','Nu',30124035,'18HCB'),(18424034,'Huỳnh Anh q ','Nu',30124023,'18HCB'),(18424035,'Huỳnh Anh 22','Nu',301240124,'18HCB'),(18424036,'Huỳnh Anh ertr','Nu',30124034,'18HCB'),(18424037,'Huỳnh Anh 22','Nu',301240333,'18HCB'),(18424038,'Huỳnh Anh ertr','Nu',3012403343,'18HCB'),(184240162,'Lê Đức','Nu',30124016,'18HCB'),(184240172,'Nguyễn Minh','Nu',30124017,'18HCB'),(184240182,'Võ Minh','Nu',30124018,'18HCB');
/*!40000 ALTER TABLE `dbstudent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbsubject`
--

DROP TABLE IF EXISTS `dbsubject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dbsubject` (
  `idsubject` varchar(10) NOT NULL,
  `namesubject` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idsubject`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbsubject`
--

LOCK TABLES `dbsubject` WRITE;
/*!40000 ALTER TABLE `dbsubject` DISABLE KEYS */;
INSERT INTO `dbsubject` VALUES ('CTT011','Thiết kế giao diện'),('CTT012','Kiểm chứng phần mềm');
/*!40000 ALTER TABLE `dbsubject` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-26  9:51:35
