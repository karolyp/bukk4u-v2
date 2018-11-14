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

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (1,'Szendrei Ágnes'),(2,'Ablonczy Péter'),(3,'Móricz Ferenc'),(4,'Hajnal Péter'),(5,'Terjéki József'),(6,'Megyesi László'),(7,'Totik Vilmos'),(8,'Kérchy László'),(9,'Németh József'),(10,'Kurusa Árpád'),(11,'Fülöp Zoltán'),(12,'Klukovits Lajos'),(13,'Hatvani László'),(14,'Szabó László'),(15,'Bajalinov Erik'),(16,'Leindler László'),(17,'Csákány Béla'),(18,'Gécseg Ferenc'),(19,'Stacho László'),(20,'Vármonostory Endre');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'2004-01-01 00:00:00','Az ítéletkalkulus elemei, Halmazok, leképezések,Relációk, gráfok, Összeszámlálási alapfeladatok,Mûveletek, mûveleti tulajdonságok, Komplex számok, Euklideszi gyûrûk, egyértelmû irreducibilis felbontás,Számelméleti kongruenciák, Polinomok,Absztrakt algebrai konstrukciók, Félcsoportok, Csoportok ,Gyûrûk, testek ,A predikátumkalkulus elemei; levezetés,Gráfok,Halmazok számossága.       ','magyar','Diszkrét matematika'),(2,'1997-01-01 00:00:00','Logikai algebra, Kombinatorikai alapismeretek, A valós számok struktúrája,Halmazok számossága,Boole-algebra, gyûrû, test,Háló , Csoport,Vektoralgebra. Analitikus geometria, Komplex számok,Mátrixalgebra. Determinánsok,   Lineáris egyenletrendszerek, Lineáris tér ,Lineáris operátorok,Számelmélet , Polinomok,     ','magyar','Infor - Matek'),(3,'1997-01-01 00:00:00','A SAJÁTÉRTÉK FELADAT, MÁTRIXOK ÁLTALÁNOSÍTOTT INVERZE,NEMLINEÁRIS EGYENLETEK ÉS EGYENLETRENDSZEREK MEGOLDÁSA, FÜGGVÉNYEK MINIMALIZÁLÁSA,  FÜGGVÉNYEK KÖZELÍTÉSE , INTEGRÁLOK KÖZELÍTÕ KISZÁMÍTÁSA . ','magyar','Numerikus módszerek az algebrában és analízisben'),(4,'1997-01-01 00:00:00','Formális hatványsorok, Részhalmazok, Sorbaállítások, permutációk,Halmazok osztályozásai,Egész számok partíciói ,Leképezések összeszámlálása, Racionális generátorfüggvények, lineáris rekurziók, Algebrai generátorfüggvények, polinomiális rekurziók,  Szita módszerek. ','magyar','Összeszámlálási problémák '),(5,'1997-01-01 00:00:00','Lineáris differenciálegyenlet-rendszerek,Nemlineáris differenciálegyenlet-rendszerek,Autonóm rendszerek,Peremérték-feladatok   ','magyar','Differenciálegyenletek '),(6,'2005-01-01 00:00:00',' Oszthatóság integritástartományokban. Egységek. ,Kongruenciák,Számelméleti függvények,   A tökéletes számok. Barátságos számpárok. Fibonacci- és Lucas-számok ,Primitív gyök,Négyzetes maradékok, Természetes számok felbontása négyzetszámok összegére.  ','magyar','Bevezetés a számelméletbe'),(7,'1997-01-01 00:00:00','1. Alapmûveletek,  2. Ekvivalencia, 3. A megszámlálható és kontinuum számosság,4. Rendezett halmazok és rendtípusok,5. Rendszámok,6. Számosságok, 7. Végtelen kombinatorika, 8. Kiválasztási axióma,9. Kontinuum hipotézis ,10. Vegyes feladatok.      ','magyar','Halmazelméleti feladatok és tételek'),(8,'1997-01-01 00:00:00',' Halmazok, relációk, leképezések,Valós és komplex számok,Polinomgyûrûk, oszthatóság,A vektorterekkel kapcsolatos alapvetõ fogalmak ,Mátrixok,Véges dimenziós vektortér operátorainak osztályozása, operátorok kanonikus mátrixai,  Euklideszi és unitér terek,Másodrendû hiperfelületek euklideszi pontterekben     ','magyar','Bevezetés a véges dimenziós vektorterek elméletébe'),(9,'1998-01-01 00:00:00','Határozatlan integrál; primitív függvény,Határozott integrál. ','magyar','Integrálszámítás példatár'),(10,'1998-01-01 00:00:00','Görbék a síkon és a térben,Differenciálható felületek,Differenciálható sokaságok,Riemann-sokaságok.   ','magyar','Bevezetés a differenciálgeometriába '),(11,'2005-01-01 00:00:00','Fogalmak, jelölések, Generatív nyelvtanok,Reguláris nyelvek,Környezetfüggetlen nyelvek, Az elemzés alapfeladatáról,Felülrõl lefelé haladó elemzési algoritmusok ,Alulról felfelé haladó elemzési algoritmusok    ','magyar','Formális nyelvek és szintaktikus elemzésük'),(12,'1999-01-01 00:00:00','Klasszikus ábrázoló geometria,Görbemodellezés,Felületek modellezése.  ','magyar','A számítógépes ábrázoló geoemtria alapjai '),(13,'1998-01-01 00:00:00','Közönséges differenciálegyenletek kezdetiérték feladata. Analitikus módszerek,Közönséges differenciálegyenletek kezdetiérték feladata. Egylépéses módszerek, Állandó együtthatójú differenciaegyenletek,Közönséges differenciálegyenletek kezdetiérték feladata. Lineáris többlépéses módszerekMátrixelméleti elõismeretek, Közönséges differenciálegyenletek peremérték feladata,Parciális differenciálegyenletek.    ','magyar','Differenciálegyenletek numerikus módszerei'),(14,'2000-01-01 00:00:00','Halmazelméleti alapok, Véges halmazok permutációi,Az általános algebra elemei,A komplex számok teste Számtest fölötti vektortér,Lineáris egyenletrendszerek,Számtest fölötti polinomok,Polinomok zérushelyeinek kiszámítása,Számtest fölötti többhatározatlanos polinomok,  Determinánsok, Polinomok többszörös és közös zéróhelyei ,Kvadratikus formák.     ','magyar','Klasszikus és lineáris algebra '),(15,'2001-01-01 00:00:00',' I. rész. Differenciálegyenletek és folytonos idejû modellek,II. rész. Differenciaegyenletek és diszkrét idejû modellek. ','magyar','Dinamikus modellek a közgazdaságban '),(16,'2001-01-01 00:00:00','Kamatszámítás, Járadékszámítás, KölcsöntörlesztésA biztosítási díj számításának alapelvei,  ','magyar','Az életbiztosítás alapjai '),(17,'2005-01-01 00:00:00','Optimumszámítási modellek és elemeik,Lineáris programozás,Konvex poliéderek és dualitás, Egészértékû programozás, Hiperbolikus programozás,Konvex programozás   ','magyar','Operációkutatás'),(18,'2004-01-01 00:00:00','Az analízis történetének rövid áttekintése,A valós számok,Számsorozatok,Egyváltozós függvények,Függvények differenciálása,   Magasabbrendû differenciálhányadosok,Függvénydiszkusszió,Primitív függvény,  Határozott integrál    ','magyar','Analízis'),(19,'2002-01-01 00:00:00','Halmazrendszerek, Halmazrendszerek lefogása és páronként diszjunkt részrendszerek keresése, Halmazrendszerek színezése, Halmazrendszerek Vapnyik---Cservonyenkisz-dimenziója,Halmazrendszerek diszkrepanciája,Extremális halmazrendszerek,A halmazrendszerekkel kapcsolatos problémák egymáshoz való viszonya, Blokkrendszerek,Hibajavító kódok, Matroidok       ','magyar','Halmazrendszerek'),(20,'2003-01-01 00:00:00',' Mátrixok, Az n-edrendû determináns,Inverzmárix,Lineáris egyenletrendszerek,Vektortér, altér, generálás, Lineárisan független és függõ vektorrendszerek,  Véges dimenziós vektorterek,Mátrixok rangja.    ','magyar','Bevezetés a lineáris algebrába');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `book_authors`
--

LOCK TABLES `book_authors` WRITE;
/*!40000 ALTER TABLE `book_authors` DISABLE KEYS */;
INSERT INTO `book_authors` VALUES (1,1),(3,3),(2,2),(20,20),(19,19),(18,18),(17,17),(16,16),(15,15),(14,14),(13,13),(12,12),(11,11),(10,10),(9,9),(8,8),(7,7),(6,6),(5,5),(4,4);
/*!40000 ALTER TABLE `book_authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `book_categories`
--

LOCK TABLES `book_categories` WRITE;
/*!40000 ALTER TABLE `book_categories` DISABLE KEYS */;
INSERT INTO `book_categories` VALUES (1,1),(2,1),(3,2),(4,2),(5,1),(6,2),(7,1),(8,2),(9,1),(10,2),(11,1),(12,1),(13,2),(14,1),(15,2),(16,1),(17,2),(18,1),(19,2),(20,1);
/*!40000 ALTER TABLE `book_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'matematika'),(2,'informatika'),(3,'sci-fi'),(4,'fantasy'),(5,'dráma'),(6,'romantikus'),(7,'tudományos'),(8,'horror');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `keyword`
--

LOCK TABLES `keyword` WRITE;
/*!40000 ALTER TABLE `keyword` DISABLE KEYS */;
INSERT INTO `keyword` VALUES (1,'analizis'),(2,'informatika'),(3,'formalis'),(4,'nyelvek'),(5,'algebra'),(6,'kalkulus'),(7,'adatbazis'),(8,'halmaz'),(9,'matematika');
/*!40000 ALTER TABLE `keyword` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `keywords`
--

LOCK TABLES `keywords` WRITE;
/*!40000 ALTER TABLE `keywords` DISABLE KEYS */;
INSERT INTO `keywords` VALUES (1,9),(2,9),(3,5),(4,9),(5,9),(6,9),(7,8),(8,9),(9,9),(10,9),(11,3),(12,1),(13,9),(14,5),(15,9),(16,1),(17,1),(18,1),(19,8),(20,5);
/*!40000 ALTER TABLE `keywords` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
INSERT INTO `rating` VALUES (1,4,'Tetszett!',1,1),(2,3,'Elment egynek..',1,2),(3,4,'Tetszett!',2,3),(4,5,'Kiváló!',2,4),(5,2,'Tetszett!',3,5),(6,4,'Kiváló!',3,4),(7,5,'Tetszett!',4,3),(8,3,'Elment egynek..',4,2),(9,2,'Elment egynek..',5,1),(10,4,'Kiváló!',5,2),(11,5,'Tetszett!',6,3),(12,2,'Elment egynek..',6,4),(13,3,'Elment egynek..',7,5),(14,2,'Elment egynek..',7,4),(15,1,'Nem értettem belőle semmit!',8,3),(16,2,'Elment egynek..',8,2),(17,4,'Tetszett!',9,1),(18,5,'Tetszett!',9,2),(19,5,'Tetszett!',10,3),(20,5,'Tetszett!',10,4),(21,4,'Tetszett!',11,5),(22,3,'Elment egynek..',11,4),(23,2,'Elment egynek..',12,3),(24,3,'Elment egynek..',12,2),(25,4,'Egész jó!',13,1),(26,5,'Tetszett!',13,2),(27,2,'Elment egynek..',14,3),(28,3,'Elment egynek..',14,4),(29,1,'Nem értettem belőle semmit!',15,5),(30,5,'Tetszett!',15,4),(31,2,'Elment egynek..',16,3),(32,3,'Elment egynek..',16,2),(33,4,'Tetszett!',17,1),(34,5,'Tetszett!',17,2),(35,2,'Nem értettem belőle semmit!',18,3),(36,3,'Elment egynek..',18,4),(37,4,'Tetszett!',19,5),(38,5,'Tetszett!',19,4),(39,2,'Nem értettem belőle semmit!',20,3),(40,1,'Nem értettem belőle semmit!',20,2);
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `rating`
--

/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-15 21:38:19
