-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: konyvtar
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `author`
--

/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (1,'Szendrei Ágnes'),(2,'Ablonczy Péter'),(3,'Móricz Ferenc'),(4,'Hajnal Péter'),(5,'Terjéki József'),(6,'Megyesi László'),(7,'Totik Vilmos'),(8,'Kérchy László'),(9,'Németh József'),(10,'Kurusa Árpád'),(11,'Fülöp Zoltán'),(12,'Klukovits Lajos'),(13,'Hatvani László'),(14,'Szabó László'),(15,'Bajalinov Erik'),(16,'Leindler László'),(17,'Csákány Béla'),(18,'Gécseg Ferenc'),(19,'Stacho László'),(20,'Vármonostory Endre');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;

--
-- Dumping data for table `book`
--

/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'2004-01-01 00:00:00','magyar','Diszkrét matematika'),(2,'1997-01-01 00:00:00','magyar','Infor - Matek'),(3,'1997-01-01 00:00:00','magyar','Numerikus módszerek az algebrában és analízisben'),(4,'1997-01-01 00:00:00','magyar','Összeszámlálási problémák '),(5,'1997-01-01 00:00:00','magyar','Differenciálegyenletek '),(6,'2005-01-01 00:00:00','magyar','Bevezetés a számelméletbe'),(7,'1997-01-01 00:00:00','magyar','Halmazelméleti feladatok és tételek'),(8,'1997-01-01 00:00:00','magyar','Bevezetés a véges dimenziós vektorterek elméletébe'),(9,'1998-01-01 00:00:00','magyar','Integrálszámítás példatár'),(10,'1998-01-01 00:00:00','magyar','Bevezetés a differenciálgeometriába '),(11,'2005-01-01 00:00:00','magyar','Formális nyelvek és szintaktikus elemzésük'),(12,'1999-01-01 00:00:00','magyar','A számítógépes ábrázoló geoemtria alapjai '),(13,'1998-01-01 00:00:00','magyar','Differenciálegyenletek numerikus módszerei'),(14,'2000-01-01 00:00:00','magyar','Klasszikus és lineáris algebra '),(15,'2001-01-01 00:00:00','magyar','Dinamikus modellek a közgazdaságban '),(16,'2001-01-01 00:00:00','magyar','Az életbiztosítás alapjai '),(17,'2005-01-01 00:00:00','magyar','Operációkutatás'),(18,'2004-01-01 00:00:00','magyar','Analízis'),(19,'2002-01-01 00:00:00','magyar','Halmazrendszerek'),(20,'2003-01-01 00:00:00','magyar','Bevezetés a lineáris algebrába');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;

--
-- Dumping data for table `book_authors`
--

/*!40000 ALTER TABLE `book_authors` DISABLE KEYS */;
INSERT INTO `book_authors` VALUES (1,1),(3,3),(2,2),(20,20),(19,19),(18,18),(17,17),(16,16),(15,15),(14,14),(13,13),(12,12),(11,11),(10,10),(9,9),(8,8),(7,7),(6,6),(5,5),(4,4);
/*!40000 ALTER TABLE `book_authors` ENABLE KEYS */;

--
-- Dumping data for table `book_categories`
--

/*!40000 ALTER TABLE `book_categories` DISABLE KEYS */;
INSERT INTO `book_categories` VALUES (1,1),(1,8),(2,1),(3,2),(4,2),(5,1),(6,2),(7,1),(8,2),(9,1),(10,2),(11,1),(12,1),(13,2),(14,1),(15,2),(16,1),(17,2),(18,1),(19,2),(20,1);
/*!40000 ALTER TABLE `book_categories` ENABLE KEYS */;

--
-- Dumping data for table `category`
--

/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'matematika'),(2,'informatika'),(3,'sci-fi'),(4,'fantasy'),(5,'dráma'),(6,'romantikus'),(7,'tudományos'),(8,'horror');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

--
-- Dumping data for table `keyword`
--

/*!40000 ALTER TABLE `keyword` DISABLE KEYS */;
INSERT INTO `keyword` VALUES (1,'analizis'),(2,'informatika'),(3,'formalis'),(4,'nyelvek'),(5,'algebra'),(6,'kalkulus'),(7,'adatbazis'),(8,'halmaz'),(9,'matematika');
/*!40000 ALTER TABLE `keyword` ENABLE KEYS */;

--
-- Dumping data for table `keywords`
--

/*!40000 ALTER TABLE `keywords` DISABLE KEYS */;
INSERT INTO `keywords` VALUES (1,9),(2,9),(3,5),(4,9),(5,9),(6,9),(7,8),(8,9),(9,9),(10,9),(11,3),(12,1),(13,9),(14,5),(15,9),(16,1),(17,1),(18,1),(19,8),(20,5);
/*!40000 ALTER TABLE `keywords` ENABLE KEYS */;

--
-- Dumping data for table `token`
--

/*!40000 ALTER TABLE `token` DISABLE KEYS */;
/*!40000 ALTER TABLE `token` ENABLE KEYS */;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,_binary '','$2a$10$JTvK6gIwI3MvC30hUJE6h.ULDb3LuQitk25MsJKedoi1MR1txEhJO','ADMIN','admin',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed
