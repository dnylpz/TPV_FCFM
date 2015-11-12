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
-- Table structure for table `detalle`
--

DROP TABLE IF EXISTS `detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle` (
  `idDetalle` int(11) NOT NULL AUTO_INCREMENT,
  `FormasDePago_idformaDePago` int(11) NOT NULL,
  `Impuestos_idImpuestos` int(11) NOT NULL,
  `Promociones_idPromocion` int(11) NOT NULL,
  `Usuarios_idUsuario` int(11) NOT NULL,
  `clientes_idCliente` int(11) NOT NULL,
  `fechaDetalle` date DEFAULT NULL,
  `horaDetalle` time DEFAULT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`idDetalle`),
  KEY `fk_Transacciones_FormasDePago1_idx` (`FormasDePago_idformaDePago`),
  KEY `fk_Transacciones_Impuestos1_idx` (`Impuestos_idImpuestos`),
  KEY `fk_Transacciones_Promociones1_idx` (`Promociones_idPromocion`),
  KEY `fk_Detalle_Usuarios1_idx` (`Usuarios_idUsuario`),
  KEY `fk_Detalle_clientes1_idx` (`clientes_idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle`
--

LOCK TABLES `detalle` WRITE;
/*!40000 ALTER TABLE `detalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-11 17:57:04
