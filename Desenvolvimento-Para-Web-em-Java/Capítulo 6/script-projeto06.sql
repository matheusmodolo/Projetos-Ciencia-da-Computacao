-- MariaDB dump 10.19  Distrib 10.4.20-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: locacao_dvds
-- ------------------------------------------------------
-- Server version	10.4.20-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ator`
--

DROP TABLE IF EXISTS `ator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  `sobrenome` varchar(30) NOT NULL,
  `dataEstreia` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ator`
--

LOCK TABLES `ator` WRITE;
/*!40000 ALTER TABLE `ator` DISABLE KEYS */;
INSERT INTO `ator` VALUES (1,'Leonardo','DiCaprio','1991-01-01'),(2,'Brad','Pitt','1987-02-01'),(4,'Angelina','Jolie','1975-06-04'),(6,'Samuel','L. Jackson','1948-12-21'),(7,'Denzel','Washington','1954-12-28'),(8,'Keanu','Reeves','1964-12-02'),(9,'Viola','Davis','1965-07-11'),(10,'Joaquin','Phoenix','1974-10-28'),(11,'Tilda','Swinton','1960-11-05'),(12,'Michael','B. Jordan','1987-02-09');
/*!40000 ALTER TABLE `ator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classificacao`
--

DROP TABLE IF EXISTS `classificacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classificacao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classificacao`
--

LOCK TABLES `classificacao` WRITE;
/*!40000 ALTER TABLE `classificacao` DISABLE KEYS */;
INSERT INTO `classificacao` VALUES (1,'+16'),(2,'+14'),(3,'+12'),(4,'+10'),(5,'Livre'),(6,'+18');
/*!40000 ALTER TABLE `classificacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dvds`
--

DROP TABLE IF EXISTS `dvds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dvds` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  `anoLancamento` int(4) NOT NULL,
  `dataLancamento` date NOT NULL,
  `duracao` int(3) NOT NULL,
  `genero_id` int(11) NOT NULL,
  `classificacao_id` int(11) NOT NULL,
  `atorPrincipal_id` int(11) NOT NULL,
  `atorCoadjuvante_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_dvd_genero_idx` (`genero_id`),
  KEY `fk_dvd_classificacao_idx` (`classificacao_id`),
  KEY `fk_dvd_atorPrincipal_idx` (`atorPrincipal_id`),
  KEY `fk_dvd_atorCoadjuvante_idx` (`atorCoadjuvante_id`),
  CONSTRAINT `fk_dvd_atorCoadjuvante` FOREIGN KEY (`atorCoadjuvante_id`) REFERENCES `ator` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_dvd_atorPrincipal` FOREIGN KEY (`atorPrincipal_id`) REFERENCES `ator` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_dvd_classificacao` FOREIGN KEY (`classificacao_id`) REFERENCES `classificacao` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_dvd_genero` FOREIGN KEY (`genero_id`) REFERENCES `genero` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dvds`
--

LOCK TABLES `dvds` WRITE;
/*!40000 ALTER TABLE `dvds` DISABLE KEYS */;
INSERT INTO `dvds` VALUES (2,'As Tranças do Rei Careca',2019,'2019-03-22',150,5,4,2,1),(3,'excluir',2020,'2020-06-28',180,2,4,2,2),(5,'novo dvd',2005,'2005-02-02',170,9,5,1,2);
/*!40000 ALTER TABLE `dvds` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genero` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,'Aventura'),(2,'Ação'),(5,'Romance'),(6,'Suspense'),(7,'Terror'),(9,'Comédia'),(11,'Animação'),(12,'Documentário'),(13,'Drama'),(14,'Ficção Científica'),(15,'Musical');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-30 18:23:18
