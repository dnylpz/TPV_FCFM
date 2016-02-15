CREATE DATABASE  IF NOT EXISTS `tpv_fcfm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tpv_fcfm`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tpv_fcfm
-- ------------------------------------------------------
-- Server version	5.6.17

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
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `loginUsuario` varchar(45) NOT NULL,
  `passwordUsuario` varchar(45) NOT NULL,
  `ultimoAccesoUsuario` datetime DEFAULT NULL,
  `fotoUsuario` int(11) DEFAULT NULL,
  `administrador` tinyint(1) DEFAULT NULL,
  `nombreUsuario` varchar(45) DEFAULT NULL,
  `apellidosUsuario` varchar(45) DEFAULT NULL,
  `sexo` tinyint(4) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `nivelDeEstudios` varchar(45) DEFAULT NULL,
  `Domicilio` int(11) DEFAULT NULL,
  `RFC` varchar(13) DEFAULT 'XAXX010101000',
  `CURP` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `loginUsuario_UNIQUE` (`loginUsuario`),
  KEY `imagenUsuario_idx` (`fotoUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'dnylpz','c3e662d0b048cfe1f2bf38a785380b75','2015-11-13 15:15:21',1,1,'Daniel','Espinoza',NULL,NULL,NULL,1,'XAXX010101000',NULL),(10,'efaustinos','5fa7452891a3470919d86b5252b0914a','2015-11-11 18:09:26',12,1,'Esdras','Faustinos',NULL,NULL,NULL,NULL,'XAXX010101000',NULL),(11,'slopezp','ea4b708cd29b4b9514d4460a48aae067','2015-11-13 12:52:16',16,0,'Sonia','Lopez',0,'1975-11-02','preparatoria',6,'LOPS751102001','LOPS751102MPLPLN05');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-13 15:20:12
