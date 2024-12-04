-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: ada-technical-test
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `application`
--

DROP TABLE IF EXISTS `application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `application` (
  `app_id` int NOT NULL AUTO_INCREMENT,
  `app_code` varchar(255) DEFAULT NULL,
  `app_description` varchar(255) DEFAULT NULL,
  `app_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`app_id`),
  UNIQUE KEY `UKh6et38eb8ftmeyht0s9ba7m2m` (`app_code`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application`
--

LOCK TABLES `application` WRITE;
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
INSERT INTO `application` VALUES (1,'appc001','aplicacion administrativa 1','aplicacion 1'),(2,'appc002','aplicacion asistencial','aplicacion 2');
/*!40000 ALTER TABLE `application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `id_company` int NOT NULL AUTO_INCREMENT,
  `codigo_company` varchar(255) DEFAULT NULL,
  `description_company` varchar(255) DEFAULT NULL,
  `name_company` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_company`),
  UNIQUE KEY `UK9gamds6xubum1cnbuqn4qyuov` (`codigo_company`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'CMPNY01','Compañia 1 produccion','Compañia 1'),(2,'CMPNY02','Esta es la compañia 2','Compañia2'),(3,'CMPNY03','Esta es la compañia 3','Compañia3'),(4,'CMPNY04','Esta es la compañia 4','Compañia4'),(12,'CMPNY09','Compañia api a produccion','Compañia api');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tmp_llenar_campos`
--

DROP TABLE IF EXISTS `tmp_llenar_campos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tmp_llenar_campos` (
  `id_company` int DEFAULT NULL,
  `codigo_company` varchar(1000) DEFAULT NULL,
  `name_company` varchar(1000) DEFAULT NULL,
  `description_company` varchar(1000) DEFAULT NULL,
  `version_id` int DEFAULT NULL,
  `app_id` int DEFAULT NULL,
  `version` varchar(1000) DEFAULT NULL,
  `version_description` varchar(1000) DEFAULT NULL,
  `version_company_id` int DEFAULT NULL,
  `version_company_description` varchar(1000) DEFAULT NULL,
  `app_code` varchar(1000) DEFAULT NULL,
  `app_name` varchar(1000) DEFAULT NULL,
  `app_description` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tmp_llenar_campos`
--

LOCK TABLES `tmp_llenar_campos` WRITE;
/*!40000 ALTER TABLE `tmp_llenar_campos` DISABLE KEYS */;
INSERT INTO `tmp_llenar_campos` VALUES (1,'CMPNY01','Compañia1','Esta es la compañia 1',1,1,'Version de prueba 1','Descripcion de la version de prueba 1',1,'Version de prueba 1 para la compañia 1','appc001','aplicacion 1','aplicacion administrativa 1'),(2,'CMPNY02','Compañia2','Esta es la compañia 2',1,1,'Version de prueba 1','Descripcion de la version de prueba 1',2,'Version de prueba 1 para la compañia 2','appc001','aplicacion 1','aplicacion administrativa 1'),(3,'CMPNY03','Compañia3','Esta es la compañia 3',1,1,'Version de prueba 1','Descripcion de la version de prueba 1',3,'Version de prueba 1 para la compañia 3','appc001','aplicacion 1','aplicacion administrativa 1'),(4,'CMPNY04','Compañia4','Esta es la compañia 4',2,2,'Version de produccion','Descripcion de la version de produccion de la aplicacion 2',4,'Version de produccion de la aplicacion 2 para la compañia 4','appc002','aplicacion 2','aplicacion asistencial');
/*!40000 ALTER TABLE `tmp_llenar_campos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `version`
--

DROP TABLE IF EXISTS `version`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `version` (
  `version_id` int NOT NULL AUTO_INCREMENT,
  `app_id` int DEFAULT NULL,
  `version` varchar(255) DEFAULT NULL,
  `version_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`version_id`),
  UNIQUE KEY `UKpwq5msba96ikqmjd4mda9tfr5` (`app_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `version`
--

LOCK TABLES `version` WRITE;
/*!40000 ALTER TABLE `version` DISABLE KEYS */;
INSERT INTO `version` VALUES (1,1,'Version de prueba 1','Descripcion de la version de prueba 1'),(2,2,'Version de produccion','Descripcion de la version de produccion de la aplicacion 2');
/*!40000 ALTER TABLE `version` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `version_company`
--

DROP TABLE IF EXISTS `version_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `version_company` (
  `version_company_id` int NOT NULL AUTO_INCREMENT,
  `company_id` int DEFAULT NULL,
  `version_company_description` varchar(255) DEFAULT NULL,
  `version_id` int DEFAULT NULL,
  PRIMARY KEY (`version_company_id`),
  UNIQUE KEY `UKi7wwqxyou8j3k3splwukciirl` (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `version_company`
--

LOCK TABLES `version_company` WRITE;
/*!40000 ALTER TABLE `version_company` DISABLE KEYS */;
INSERT INTO `version_company` VALUES (1,1,'paso a produccion compania1',2),(2,2,'Version de prueba 1 para la compañia 2',1),(3,3,'Version de prueba 1 para la compañia 3',1),(4,4,'Version de produccion de la aplicacion 2 para la compañia 4',2),(9,0,'paso a produccion compania api',2);
/*!40000 ALTER TABLE `version_company` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-04 15:30:46
