-- MySQL dump 10.13  Distrib 8.0.25, for Linux (x86_64)
--
-- Host: localhost    Database: test_task
-- ------------------------------------------------------
-- Server version	8.0.28-0ubuntu0.20.04.3

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
-- Table structure for table `form_data`
--

DROP TABLE IF EXISTS `form_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `form_data` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `agree_to_terms` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `form_data`
--

LOCK TABLES `form_data` WRITE;
/*!40000 ALTER TABLE `form_data` DISABLE KEYS */;
INSERT INTO `form_data` VALUES (26,'Reethu Das',_binary '');
/*!40000 ALTER TABLE `form_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `form_data_sector`
--

DROP TABLE IF EXISTS `form_data_sector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `form_data_sector` (
  `form_data_id` bigint NOT NULL,
  `sector_id` bigint NOT NULL,
  PRIMARY KEY (`form_data_id`,`sector_id`),
  KEY `FKf3cwrm18wgpls9ov7l241ft2v` (`sector_id`),
  CONSTRAINT `FKf3cwrm18wgpls9ov7l241ft2v` FOREIGN KEY (`sector_id`) REFERENCES `sector` (`id`),
  CONSTRAINT `FKq8ie8qnflysp239m6rhvct44p` FOREIGN KEY (`form_data_id`) REFERENCES `form_data` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `form_data_sector`
--

LOCK TABLES `form_data_sector` WRITE;
/*!40000 ALTER TABLE `form_data_sector` DISABLE KEYS */;
INSERT INTO `form_data_sector` VALUES (26,87);
/*!40000 ALTER TABLE `form_data_sector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sector`
--

DROP TABLE IF EXISTS `sector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sector` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd5ayv5oixd1jn08xf0bc7yrvn` (`type_id`),
  CONSTRAINT `FKd5ayv5oixd1jn08xf0bc7yrvn` FOREIGN KEY (`type_id`) REFERENCES `sector_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sector`
--

LOCK TABLES `sector` WRITE;
/*!40000 ALTER TABLE `sector` DISABLE KEYS */;
INSERT INTO `sector` VALUES (34,'Construction materials',17),(35,'Electronics and Optics',17),(36,'Bakery & confectionery products',18),(37,'Beverages',18),(38,'Fish & fish products',18),(39,'Meat & meat products',18),(40,'Milk & dairy products',18),(41,'Sweets & snack food',18),(42,'Other',18),(43,'Bathroom/sauna',19),(44,'Bedroom',19),(45,'Children\'s room',19),(46,'Kitchen',19),(47,'Living room',19),(48,'Office',19),(49,'Outdoor',19),(50,'Project furniture',19),(51,'Other (Furniture)',19),(52,'Machinery components',20),(53,'Machinery equipment/tools',20),(54,'Manufacture of machinery',20),(55,'Metal structures',20),(56,'Repair and maintenance service',20),(57,'Other',20),(58,'Aluminium and steel workboats',21),(59,'Boat/Yacht building',21),(60,'Ship repair and conversion',21),(61,'Construction of metal structures',22),(62,'Houses and buildings ',22),(63,'Metal products',22),(64,'CNC-machining',23),(65,'Forgings, Fasteners ',23),(66,'Gas, Plasma, Laser cutting',23),(67,'MIG, TIG, Aluminum welding',23),(68,'Packaging',24),(69,'Plastic goods',24),(70,'Plastic profiles',24),(71,'Blowing',25),(72,'Moulding',25),(73,'Plastics welding and processing',25),(74,'Advertising',10),(75,'Book/Periodicals printing ',10),(76,'Labelling and packaging printing',10),(77,'Clothing',26),(78,'Textile',26),(79,'Other (Wood)',12),(80,'Wooden building materials',12),(81,'Wooden houses',12),(82,'Business services',13),(83,'Engineering ',13),(84,'Tourism',13),(85,'Translation services',13),(86,'Data processing, Web portals, E-marketing',14),(87,'Programming, Consultancy',14),(88,'Software, Hardware',14),(89,'Telecommunications',14),(90,'Air',15),(91,'Rail ',15),(92,'Road',15),(93,'Water',15),(94,'Creative industries',16),(95,'Energy technology',16),(96,'Environment',16);
/*!40000 ALTER TABLE `sector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sector_type`
--

DROP TABLE IF EXISTS `sector_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sector_type` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sector_type`
--

LOCK TABLES `sector_type` WRITE;
/*!40000 ALTER TABLE `sector_type` DISABLE KEYS */;
INSERT INTO `sector_type` VALUES (10,'Printing'),(12,'Wood'),(13,'Service'),(14,'Information Technology and Telecommunications'),(15,'Transport and Logistics'),(16,'Other'),(17,'Manufacturing'),(18,'Food and Beverage'),(19,'Furniture'),(20,'Machinery'),(21,'Maritime'),(22,'Metalworking'),(23,'Metal works'),(24,'Plastic and Rubber'),(25,'Plastic processing technology'),(26,'Textile and Clothing');
/*!40000 ALTER TABLE `sector_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-30 12:58:45
