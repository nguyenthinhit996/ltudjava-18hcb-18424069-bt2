CREATE DATABASE  IF NOT EXISTS `management` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `management`;
-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: management
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.18.04.1

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
-- Table structure for table `db_class_subject`
--

DROP TABLE IF EXISTS `db_class_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40000 ALTER TABLE `db_class_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `db_student_class-subject`
--

DROP TABLE IF EXISTS `db_student_class-subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `db_student_class-subject` (
  `iddb_student_class-subject` varchar(30) NOT NULL,
  `nameidstudent` varchar(10) DEFAULT NULL,
  `nameidclass_subject` varchar(20) DEFAULT NULL,
  `pointmid` int(11) DEFAULT NULL,
  `pointfinal` int(11) DEFAULT NULL,
  `pointdifferent` int(11) DEFAULT NULL,
  `pointsum` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iddb_student_class-subject`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_student_class-subject`
--

LOCK TABLES `db_student_class-subject` WRITE;
/*!40000 ALTER TABLE `db_student_class-subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `db_student_class-subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbaccount`
--

DROP TABLE IF EXISTS `dbaccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbclass` (
  `idclass` varchar(10) NOT NULL,
  `nameclass` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idclass`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbclass`
--

LOCK TABLES `dbclass` WRITE;
/*!40000 ALTER TABLE `dbclass` DISABLE KEYS */;
INSERT INTO `dbclass` VALUES ('12sdas','sdfdsf'),('19HB','lớp chất lượng cao'),('2343','srwdfdsf');
/*!40000 ALTER TABLE `dbclass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbcontructorpk`
--

DROP TABLE IF EXISTS `dbcontructorpk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbstudent` (
  `idstudent` int(11) NOT NULL,
  `namestudent` varchar(45) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `identity` int(11) DEFAULT NULL,
  `idclass` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idstudent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbstudent`
--

LOCK TABLES `dbstudent` WRITE;
/*!40000 ALTER TABLE `dbstudent` DISABLE KEYS */;
INSERT INTO `dbstudent` VALUES (1,'nguyễn văn thịnh','',NULL,NULL);
/*!40000 ALTER TABLE `dbstudent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbsubject`
--

DROP TABLE IF EXISTS `dbsubject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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

-- Dump completed on 2019-08-22  1:07:12
