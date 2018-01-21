-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: db_lone
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(45) NOT NULL,
  `item_info` varchar(256) NOT NULL,
  `item_price` double NOT NULL,
  `item_img` varchar(256) DEFAULT NULL,
  `fk_cat` int(11) NOT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12124667 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'Thai dame?','M-K person.. Lettere brugt...',25000,'thailady1.png',1),(2,'Russisk dame','Ung kvinde.. billig...',999.99,'russiangirl1.png',1),(3,'Heroin','Den hvide løve...',5000,'heroin1.png',2),(4,'Kokain','Hvid sne.. snow?',3999.96,'cocain1.png',2),(5,'Ruffies','Drug rape når du er i byen...',5,'noimg.png',2),(6,'Ak-47','Når der skal ryddes op i gaden...',50000,'ak47.png',3),(7,'Colt Peacemaker','En gammel klassiker går aldrig af mode...',99.98,'coltpeace1.png',3),(8,'Pump shot','Når du skal hæve over...',45000,'pumpshot1.png',3),(9,'Bean gun','Den du kan have med i flyet...',600000,'noimg.png',3),(10,'Fiat 500','Fiat 500.. lettere brugt.. et røverkøb',3999.95,'fiat500.png',4),(11,'Bærbar MSI','Nyere bærbar fra Christiania',6999.99,'msilaptop1.png',4),(12,'Christiania Lod','Vind en ny bil ved at være med!',10000,'lod1.png',4),(13,'Helikopter','Lettere brugt fra Peru...',1000000,'noimg.png',4),(14,'Lones ex. mand lig','Lone\'s første ex. mand...',149.99,'corpse1.png',4),(15,'Fake rolex','Købt fra sort person i NY',4999.99,'fakerolex1.png',4),(16,'Taint rat','Import fra New Zealand',499,'taintrat1.png',4),(17,'Taint bird','Import fra New Zealand',399,'taintbird1.png',4),(18,'Jason Voorhees','Når du gerne vil dø!',75000,'jason1.png',1),(19,'Holsk DVD afspiller','En dejlig brugt DVD afspiller!',2999,'holskdvd1.png',4),(20,'Kim G. Ryge styr','Køb den nu og ryg imorgen..!!',599,'bicyclesteer1.png',4),(21,'Lejemorder','Køb ydelsen i gave til din mor eller svigermor...',3000000,'hitman1.png',4),(22,'Wazzk','Laver en Wazzk sammen.. det siger fandma meget om en person...',50000,'jeppek1.png',4),(23,'JeppeK Orgie','Kom og være med i samlejet... Kvælertag og spyt i munden... nyt nyt',1000000,'jeppek2.png',4),(12124,'GGGGHHASFKBAF','GGHHGASFKJBASKFJB',1000.55,'item_img.img',1);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-17 16:49:47
