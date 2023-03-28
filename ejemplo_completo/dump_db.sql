-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: turnos
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autor` (
  `codigo_autor` bigint NOT NULL,
  `nombre_autor` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo_autor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autor_seq`
--

DROP TABLE IF EXISTS `autor_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autor_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor_seq`
--

LOCK TABLES `autor_seq` WRITE;
/*!40000 ALTER TABLE `autor_seq` DISABLE KEYS */;
INSERT INTO `autor_seq` VALUES (1);
/*!40000 ALTER TABLE `autor_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `codigo_cliente` bigint NOT NULL,
  `apellido_contacto` varchar(30) DEFAULT NULL,
  `ciudad` varchar(50) DEFAULT NULL,
  `codigo_empleado_rep_ventas` int DEFAULT NULL,
  `codigo_postal` varchar(10) DEFAULT NULL,
  `fax` varchar(15) DEFAULT NULL,
  `limite_credito` float DEFAULT NULL,
  `limite_credito_max` float DEFAULT NULL,
  `limite_credito_max_1` float DEFAULT NULL,
  `limite_credito_min` float DEFAULT NULL,
  `linea_direccion1` varchar(50) DEFAULT NULL,
  `linea_direccion2` varchar(50) DEFAULT NULL,
  `nombre_cliente` varchar(50) DEFAULT NULL,
  `nombre_contacto` varchar(30) DEFAULT NULL,
  `pais` varchar(50) DEFAULT NULL,
  `region` varchar(50) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `codigo_empleado` bigint DEFAULT NULL,
  PRIMARY KEY (`codigo_cliente`),
  KEY `FKpiba14hrq83g9m7w8ahw63h2d` (`codigo_empleado`),
  CONSTRAINT `FKpiba14hrq83g9m7w8ahw63h2d` FOREIGN KEY (`codigo_empleado`) REFERENCES `empleado` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'GoldFish','San Francisco',0,'24006','5556901746',3000.45,NULL,NULL,NULL,'False Street 52 2 A','','GoldFish Garden','Daniel G F','USA','','5556901745',5),(3,'Wright','Miami',19,'24010','5557410346',6000,NULL,NULL,NULL,'Wall-e Avenue',NULL,'Gardening Associates','Anne','USA','Miami','5557410345',19),(4,'Flaute','New York',22,'85495','5552323128',12000,NULL,NULL,NULL,'Oaks Avenue nº22',NULL,'Gerudo Valley','Link','USA',NULL,'5552323129',22),(5,'Tendo','Miami',22,'696969','55591233211',600000,NULL,NULL,NULL,'Null Street nº69',NULL,'Tendo Garden','Akane','USA',NULL,'55591233210',22),(6,'Lasas','Fuenlabrada',8,'28945','34914851312',154310,NULL,NULL,NULL,'C/Leganes 15',NULL,'Lasas S.A.','Antonio','Spain','Madrid','34916540145',8),(7,'Bermejo','Madrid',11,'28942','916549872',20000,NULL,NULL,NULL,'C/pintor segundo','Getafe','Beragua','Jose','Spain','Madrid','654987321',11),(8,'Lopez','Madrid',11,'28930','919535678',40000,NULL,NULL,NULL,'C/sinesio delgado','Madrid','Club Golf Puerta del hierro','Paco','Spain','Madrid','62456810',11),(9,'Rengifo','Madrid',11,'28947','916428956',32000,NULL,NULL,NULL,'C/majadahonda','Boadilla','Naturagua','Guillermo','Spain','Madrid','689234750',11),(10,'Serrano','Madrid',11,'28946','916421756',50000,NULL,NULL,NULL,'C/azores','Fuenlabrada','DaraDistribuciones','David','Spain','Madrid','675598001',11),(11,'Tacaño','Madrid',11,'28943','916689215',20000,NULL,NULL,NULL,'C/Lagañas','Fuenlabrada','Madrileña de riegos','Jose','Spain','Madrid','655983045',11),(12,'Lasas','Fuenlabrada',8,'28945','34914851312',154310,NULL,NULL,NULL,'C/Leganes 15',NULL,'Lasas S.A.','Antonio','Spain','Madrid','34916540145',8),(13,'Camunas','San Lorenzo del Escorial',8,'28145','34914871541',16481,NULL,NULL,NULL,'C/Virgenes 45','C/Princesas 2 1ºB','Camunas Jardines S.L.','Pedro','Spain','Madrid','34914873241',8),(14,'Rodriguez','Madrid',8,'28003','34912484764',321000,NULL,NULL,NULL,'C/Nueva York 74',NULL,'Dardena S.A.','Juan','Spain','Madrid','34912453217',8),(15,'Villar','Madrid',30,'28950','914538776',40000,NULL,NULL,NULL,'C/ Oña 34',NULL,'Jardin de Flores','Javier','Spain','Madrid','654865643',30),(16,'Rodriguez','Fuenlabrada',5,'28945','912458657',1500,NULL,NULL,NULL,'C/Leganes24',NULL,'Flores Marivi','Maria','Spain','Madrid','666555444',5),(17,'Fernandez','Montornes del valles',5,'24586','978453216',3500,NULL,NULL,NULL,'C/Luis Salquillo4',NULL,'Flowers, S.A','Beatriz','Spain','Barcelona','698754159',5),(18,'Cruz','Madrid',30,'28011','916548735',5050,NULL,NULL,NULL,'Plaza Magallón 15',NULL,'Naturajardin','Victoria','Spain','Madrid','612343529',30),(19,'Martinez','Santa cruz de Tenerife',12,'38297','912354475',30000,NULL,NULL,NULL,'C/Estancado',NULL,'Golf S.A.','Luis','Spain','Islas Canarias','916458762',12),(20,'Suarez','Barcelona',12,'12320','964493063',20000,NULL,NULL,NULL,'C/Letardo',NULL,'Americh Golf Management SL','Mario','Spain','Cataluña','964493072',12),(21,'Rodrigez','Canarias',12,'35488','914489898',50000,NULL,NULL,NULL,'C/Roman 3',NULL,'Aloha','Cristian','Spain','Canarias','916485852',12),(22,'Camacho','Barcelona',12,'12320','916493211',30000,NULL,NULL,NULL,'Avenida Tibidabo',NULL,'El Prat','Francisco','Spain','Cataluña','916882323',12),(23,'Santillana','Sotogrande',12,'11310','914825645',60000,NULL,NULL,NULL,'C/Paseo del Parque',NULL,'Sotogrande','Maria','Spain','Cadiz','915576622',12),(24,'Gomez','Humanes',30,'28970','916040875',7430,NULL,NULL,NULL,'C/Miguel Echegaray 54',NULL,'Vivero Humanes','Federico','Spain','Madrid','654987690',30),(25,'Muñoz Mena','Fuenlabrada',5,'28574','915483754',4500,NULL,NULL,NULL,'C/Callo 52',NULL,'Fuenla City','Tony','Spain','Madrid','675842139',5),(26,'Sánchez','Madrid',9,'29874','914477777',76000,NULL,NULL,NULL,'Polígono Industrial Maspalomas, Nº52','Móstoles','Jardines y Mansiones Cactus SL','Eva María','Spain','Madrid','916877445',9),(27,'San Martín','Madrid',9,'37845','917897474',100500,NULL,NULL,NULL,'C/Francisco Arce, Nº44','Bustarviejo','Jardinerías Matías SL','Matías','Spain','Madrid','916544147',9),(28,'Lopez','Getafe',30,'28904','916549264',8040,NULL,NULL,NULL,'C/Mar Caspio 43',NULL,'Agrojardin','Benito','Spain','Madrid','675432926',30),(29,'Sanchez','Humanes',5,'28574','974315924',5500,NULL,NULL,NULL,'C/Ibiza 32',NULL,'Top Campo','Joseluis','Spain','Madrid','685746512',5),(30,'Marquez','Fuenlabrada',5,'27584','912475843',7500,NULL,NULL,NULL,'C/Lima 1',NULL,'turnos Sara','Sara','Spain','Madrid','675124537',5),(31,'Jimenez','Fuenlabrada',30,'28945','916159116',3250,NULL,NULL,NULL,'C/Peru 78',NULL,'Campohermoso','Luis','Spain','Madrid','645925376',30),(32,'Toulou','Paris',16,'75010','(33)5120578961',10000,NULL,NULL,NULL,'6 place d Alleray 15Ã¨me',NULL,'france telecom','FraÃ§ois','France',NULL,'(33)5120578961',16),(33,'Delacroux','Paris',16,'75058','(33)0140205442',30000,NULL,NULL,NULL,'Quai du Louvre',NULL,'Musée du Louvre','Pierre','France',NULL,'(33)0140205050',16),(35,'Jones','Sydney',31,'2000','2 9283-1695',10000,NULL,NULL,NULL,'level 24, St. Martins Tower.-31 Market St.',NULL,'Tutifruti S.A','Jacob','Australia','Nueva Gales del Sur','2 9261-2433',31),(36,'Romero','Madrid',18,'29643','685249700',6000,NULL,NULL,NULL,'Avenida España',NULL,'Flores S.L.','Antonio','Spain','Fuenlabrada','654352981',18),(37,'Mcain','London',18,'65930','9364875882',10000,NULL,NULL,NULL,'Lihgting Park',NULL,'The Magic Garden','Richard','United Kingdom','London','926523468',18),(38,'Smith','Sydney',31,'2003','2 8005-7162',8000,NULL,NULL,NULL,'176 Cumberland Street The rocks',NULL,'El Jardin Viviente S.L','Justin','Australia','Nueva Gales del Sur','2 8005-7161',31);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_seq`
--

DROP TABLE IF EXISTS `cliente_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_seq`
--

LOCK TABLES `cliente_seq` WRITE;
/*!40000 ALTER TABLE `cliente_seq` DISABLE KEYS */;
INSERT INTO `cliente_seq` VALUES (1);
/*!40000 ALTER TABLE `cliente_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compras` (
  `pk` bigint NOT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `cliente_codigo_cliente` bigint DEFAULT NULL,
  PRIMARY KEY (`pk`),
  KEY `FKgc3s7ed8ysl1syjpfnseyf8yi` (`cliente_codigo_cliente`),
  CONSTRAINT `FKgc3s7ed8ysl1syjpfnseyf8yi` FOREIGN KEY (`cliente_codigo_cliente`) REFERENCES `cliente` (`codigo_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras_seq`
--

DROP TABLE IF EXISTS `compras_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compras_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras_seq`
--

LOCK TABLES `compras_seq` WRITE;
/*!40000 ALTER TABLE `compras_seq` DISABLE KEYS */;
INSERT INTO `compras_seq` VALUES (1);
/*!40000 ALTER TABLE `compras_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comprasimplificada`
--

DROP TABLE IF EXISTS `comprasimplificada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comprasimplificada` (
  `pk` bigint NOT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`pk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprasimplificada`
--

LOCK TABLES `comprasimplificada` WRITE;
/*!40000 ALTER TABLE `comprasimplificada` DISABLE KEYS */;
/*!40000 ALTER TABLE `comprasimplificada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comprasimplificada_seq`
--

DROP TABLE IF EXISTS `comprasimplificada_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comprasimplificada_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprasimplificada_seq`
--

LOCK TABLES `comprasimplificada_seq` WRITE;
/*!40000 ALTER TABLE `comprasimplificada_seq` DISABLE KEYS */;
INSERT INTO `comprasimplificada_seq` VALUES (1);
/*!40000 ALTER TABLE `comprasimplificada_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuentas`
--

DROP TABLE IF EXISTS `cuentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuentas` (
  `cuenta_id` bigint NOT NULL,
  `sucursal_fk` bigint NOT NULL,
  `titular` varchar(255) DEFAULT NULL,
  `sucursal_id` bigint NOT NULL,
  PRIMARY KEY (`cuenta_id`,`sucursal_fk`),
  UNIQUE KEY `UK_jhusbce88vui143qumunh7gko` (`sucursal_fk`),
  CONSTRAINT `FKblvupqh1vh6ysh3s1ufp6iayl` FOREIGN KEY (`sucursal_fk`) REFERENCES `sucursal` (`nsucursal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentas`
--

LOCK TABLES `cuentas` WRITE;
/*!40000 ALTER TABLE `cuentas` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_compra`
--

DROP TABLE IF EXISTS `detalle_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_compra` (
  `pk` bigint NOT NULL,
  `cantidad` bigint DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  `compra_pk` bigint DEFAULT NULL,
  `producto_pk` bigint DEFAULT NULL,
  PRIMARY KEY (`pk`),
  KEY `FKmmhe2ygbe3b9ca76so8v7e1ks` (`compra_pk`),
  KEY `FKjmi6lfjg3dkv34luyre1a19tu` (`producto_pk`),
  CONSTRAINT `FKjmi6lfjg3dkv34luyre1a19tu` FOREIGN KEY (`producto_pk`) REFERENCES `productos` (`pk`),
  CONSTRAINT `FKmmhe2ygbe3b9ca76so8v7e1ks` FOREIGN KEY (`compra_pk`) REFERENCES `compras` (`pk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_compra`
--

LOCK TABLES `detalle_compra` WRITE;
/*!40000 ALTER TABLE `detalle_compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_compra_seq`
--

DROP TABLE IF EXISTS `detalle_compra_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_compra_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_compra_seq`
--

LOCK TABLES `detalle_compra_seq` WRITE;
/*!40000 ALTER TABLE `detalle_compra_seq` DISABLE KEYS */;
INSERT INTO `detalle_compra_seq` VALUES (1);
/*!40000 ALTER TABLE `detalle_compra_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `ID` bigint NOT NULL,
  `apellido1` varchar(50) DEFAULT NULL,
  `apellido2` varchar(50) DEFAULT NULL,
  `codigo_jefe` int DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `extension` varchar(10) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `puesto` varchar(50) DEFAULT NULL,
  `codigo_oficina` bigint DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKkanhvmrgoe1usiohdvxa9j0p3` (`codigo_oficina`),
  CONSTRAINT `FKkanhvmrgoe1usiohdvxa9j0p3` FOREIGN KEY (`codigo_oficina`) REFERENCES `oficina` (`codigo_oficina`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'Magaña','Perez',NULL,'marcos@turnos.es','3897','Marcos','Director General',5),(2,'López','Martinez',1,'rlopez@turnos.es','2899','Ruben','Subdirector Marketing',5),(3,'Soria','Carrasco',2,'asoria@turnos.es','2837','Alberto','Subdirector Ventas',5),(4,'Solís','Jerez',2,'msolis@turnos.es','2847','Maria','Secretaria',5),(5,'Rosas','Marquez',3,'frosas@turnos.es','2844','Felipe','Representante Ventas',5),(6,'Ortiz','Serrano',3,'cortiz@turnos.es','2845','Juan Carlos','Representante Ventas',5),(7,'Soria','Jimenez',3,'csoria@turnos.es','2444','Carlos','Director Oficina',1),(8,'López','Murcia',7,'mlopez@turnos.es','2442','Mariano','Representante Ventas',1),(9,'Campoamor','Martín',7,'lcampoamor@turnos.es','2442','Lucio','Representante Ventas',1),(10,'Rodriguez','Huertas',7,'hrodriguez@turnos.es','2444','Hilario','Representante Ventas',1),(11,'Magaña','Perez',3,'manu@turnos.es','2518','Emmanuel','Director Oficina',2),(12,'Martinez','De la Osa',11,'jmmart@hotmail.es','2519','José Manuel','Representante Ventas',2),(13,'Palma','Aceituno',11,'dpalma@turnos.es','2519','David','Representante Ventas',2),(14,'Palma','Aceituno',11,'opalma@turnos.es','2519','Oscar','Representante Ventas',2),(15,'Fignon','',3,'ffignon@gardening.com','9981','Francois','Director Oficina',3),(16,'Narvaez','',15,'lnarvaez@gardening.com','9982','Lionel','Representante Ventas',3),(17,'Serra','',15,'lserra@gardening.com','9982','Laurent','Representante Ventas',3),(18,'Bolton','',3,'mbolton@gardening.com','7454','Michael','Director Oficina',3),(19,'Sanchez','Lopez',18,'wssanchez@gardening.com','7454','Walter Santiago','Representante Ventas',3),(20,'Washington','',3,'hwashington@gardening.com','7565','Hilary','Director Oficina',5),(21,'Paxton','',20,'mpaxton@gardening.com','7565','Marcus','Representante Ventas',5),(22,'Paxton','',20,'lpaxton@gardening.com','7665','Lorena','Representante Ventas',5),(23,'Nishikori','',3,'nnishikori@gardening.com','8734','Nei','Director Oficina',6),(24,'Riko','',23,'nriko@gardening.com','8734','Narumi','Representante Ventas',6),(25,'Nomura','',23,'tnomura@gardening.com','8735','Takuma','Representante Ventas',6),(26,'Johnson','',3,'ajohnson@gardening.com','3321','Amy','Director Oficina',7),(27,'Westfalls','',26,'lwestfalls@gardening.com','3322','Larry','Representante Ventas',7),(28,'Walton','',26,'jwalton@gardening.com','3322','John','Representante Ventas',7),(29,'Fallmer','',3,'kfalmer@gardening.com','3210','Kevin','Director Oficina',7),(30,'Bellinelli','',29,'jbellinelli@gardening.com','3211','Julian','Representante Ventas',7),(31,'Kishi','',29,'mkishi@gardening.com','3211','Mariko','Representante Ventas',7);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado_seq`
--

DROP TABLE IF EXISTS `empleado_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado_seq`
--

LOCK TABLES `empleado_seq` WRITE;
/*!40000 ALTER TABLE `empleado_seq` DISABLE KEYS */;
INSERT INTO `empleado_seq` VALUES (1);
/*!40000 ALTER TABLE `empleado_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etiqueta`
--

DROP TABLE IF EXISTS `etiqueta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `etiqueta` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=253 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etiqueta`
--

LOCK TABLES `etiqueta` WRITE;
/*!40000 ALTER TABLE `etiqueta` DISABLE KEYS */;
INSERT INTO `etiqueta` VALUES (102,'Rural'),(152,'Urbano a medias'),(153,'Montaña'),(154,'Montaña de nuevo'),(251,'Montaña de nuevo'),(252,'Bares por la noche');
/*!40000 ALTER TABLE `etiqueta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etiqueta_embeddable`
--

DROP TABLE IF EXISTS `etiqueta_embeddable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `etiqueta_embeddable` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=253 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etiqueta_embeddable`
--

LOCK TABLES `etiqueta_embeddable` WRITE;
/*!40000 ALTER TABLE `etiqueta_embeddable` DISABLE KEYS */;
INSERT INTO `etiqueta_embeddable` VALUES (102,'Rural'),(152,'Urbano a medias'),(153,'Montaña'),(154,'Montaña de nuevo'),(251,'Montaña de nuevo'),(252,'Bares por la noche');
/*!40000 ALTER TABLE `etiqueta_embeddable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etiqueta_mientidad`
--

DROP TABLE IF EXISTS `etiqueta_mientidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `etiqueta_mientidad` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etiqueta_mientidad`
--

LOCK TABLES `etiqueta_mientidad` WRITE;
/*!40000 ALTER TABLE `etiqueta_mientidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `etiqueta_mientidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etiqueta_seq`
--

DROP TABLE IF EXISTS `etiqueta_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `etiqueta_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etiqueta_seq`
--

LOCK TABLES `etiqueta_seq` WRITE;
/*!40000 ALTER TABLE `etiqueta_seq` DISABLE KEYS */;
INSERT INTO `etiqueta_seq` VALUES (252);
/*!40000 ALTER TABLE `etiqueta_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `galeria`
--

DROP TABLE IF EXISTS `galeria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `galeria` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) DEFAULT NULL,
  `url_img` varchar(255) DEFAULT NULL,
  `codigo_empleado` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1k686fh4ktrwow78h4a9abw2` (`codigo_empleado`),
  CONSTRAINT `FK1k686fh4ktrwow78h4a9abw2` FOREIGN KEY (`codigo_empleado`) REFERENCES `empleado` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `galeria`
--

LOCK TABLES `galeria` WRITE;
/*!40000 ALTER TABLE `galeria` DISABLE KEYS */;
INSERT INTO `galeria` VALUES (5,'img1','/img/team-1.jpg',20),(6,'img1','/img/team-2.jpg',12),(7,'img3','/img/team-3.jpg',5),(8,'elemento 4','/img/team-4.jpg',17),(9,'test alta','/img/team_2.jpg',16);
/*!40000 ALTER TABLE `galeria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `galeria_embeddable`
--

DROP TABLE IF EXISTS `galeria_embeddable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `galeria_embeddable` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) DEFAULT NULL,
  `url_img` varchar(255) DEFAULT NULL,
  `codigo_empleado` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb9tmok1s4lvhpbdh2mxdqrm6p` (`codigo_empleado`),
  CONSTRAINT `FKb9tmok1s4lvhpbdh2mxdqrm6p` FOREIGN KEY (`codigo_empleado`) REFERENCES `empleado` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `galeria_embeddable`
--

LOCK TABLES `galeria_embeddable` WRITE;
/*!40000 ALTER TABLE `galeria_embeddable` DISABLE KEYS */;
INSERT INTO `galeria_embeddable` VALUES (12,'adadad','/img/team-3.jpg',9),(13,'otro','/img/team-2.jpg',8),(14,'Carmen','/img/team-4.jpg',4),(15,'1','/img/team-1.jpg',19),(16,'dos de nuevo','/img/team-2.jpg',2);
/*!40000 ALTER TABLE `galeria_embeddable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `galeria_etiqueta_embeddable`
--

DROP TABLE IF EXISTS `galeria_etiqueta_embeddable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `galeria_etiqueta_embeddable` (
  `etiqueta_embed_id` bigint NOT NULL,
  `galeria_embed_id` bigint NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_alta` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`etiqueta_embed_id`,`galeria_embed_id`),
  KEY `FKe240190funefm5gdrcw6ipsao` (`galeria_embed_id`),
  CONSTRAINT `FKe240190funefm5gdrcw6ipsao` FOREIGN KEY (`galeria_embed_id`) REFERENCES `galeria_embeddable` (`id`),
  CONSTRAINT `FKiflcick7ba6qmof9uubfmd1of` FOREIGN KEY (`etiqueta_embed_id`) REFERENCES `etiqueta_embeddable` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `galeria_etiqueta_embeddable`
--

LOCK TABLES `galeria_etiqueta_embeddable` WRITE;
/*!40000 ALTER TABLE `galeria_etiqueta_embeddable` DISABLE KEYS */;
INSERT INTO `galeria_etiqueta_embeddable` VALUES (102,12,'Doy de modifico la relacion con:102','2023-02-17 11:40:29.701266'),(102,13,'Doy de modifico la relacion con:102','2023-02-17 11:40:48.808347'),(102,15,'Doy de alta la relacion con:102','2023-02-07 19:13:31.631096'),(152,12,'Doy de modifico la relacion con:152','2023-02-17 11:40:29.701266'),(152,13,'Doy de modifico la relacion con:152','2023-02-17 11:40:48.808347'),(152,16,'Doy de alta la relacion con:152','2023-02-07 20:59:49.519534'),(153,12,'Doy de modifico la relacion con:153','2023-02-17 11:40:29.701266'),(153,13,'Doy de modifico la relacion con:153','2023-02-17 11:40:48.808347'),(153,14,'Doy de modifico la relacion con:153','2023-02-09 16:35:33.769490'),(154,13,'Doy de modifico la relacion con:154','2023-02-17 11:40:48.808347'),(154,14,'Doy de modifico la relacion con:154','2023-02-09 16:35:33.769490'),(154,16,'Doy de alta la relacion con:154','2023-02-07 20:59:49.519534'),(251,13,'Doy de modifico la relacion con:251','2023-02-17 11:40:48.808347'),(251,15,'Doy de alta la relacion con:251','2023-02-07 19:13:31.631096'),(252,13,'Doy de modifico la relacion con:252','2023-02-17 11:40:48.808347');
/*!40000 ALTER TABLE `galeria_etiqueta_embeddable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `galeria_etiqueta_mientidad`
--

DROP TABLE IF EXISTS `galeria_etiqueta_mientidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `galeria_etiqueta_mientidad` (
  `id` int NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_alta` datetime(6) DEFAULT NULL,
  `etiqueta_mient_id` bigint DEFAULT NULL,
  `galeria_mient_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcyn4g544ffan9wk8pd88ihvph` (`etiqueta_mient_id`),
  KEY `FK3owanh6yvfj4ydg2cgt6y9b97` (`galeria_mient_id`),
  CONSTRAINT `FK3owanh6yvfj4ydg2cgt6y9b97` FOREIGN KEY (`galeria_mient_id`) REFERENCES `galeria_mientidad` (`id`),
  CONSTRAINT `FKcyn4g544ffan9wk8pd88ihvph` FOREIGN KEY (`etiqueta_mient_id`) REFERENCES `etiqueta_mientidad` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `galeria_etiqueta_mientidad`
--

LOCK TABLES `galeria_etiqueta_mientidad` WRITE;
/*!40000 ALTER TABLE `galeria_etiqueta_mientidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `galeria_etiqueta_mientidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `galeria_etiquetas`
--

DROP TABLE IF EXISTS `galeria_etiquetas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `galeria_etiquetas` (
  `galeria_id` bigint NOT NULL,
  `etiqueta_id` bigint NOT NULL,
  PRIMARY KEY (`galeria_id`,`etiqueta_id`),
  KEY `FKi4ynasfd6b40pth6yww4e6ax5` (`etiqueta_id`),
  CONSTRAINT `FKctgeq2yja9pkmdaws4n066pll` FOREIGN KEY (`galeria_id`) REFERENCES `galeria` (`id`),
  CONSTRAINT `FKi4ynasfd6b40pth6yww4e6ax5` FOREIGN KEY (`etiqueta_id`) REFERENCES `etiqueta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `galeria_etiquetas`
--

LOCK TABLES `galeria_etiquetas` WRITE;
/*!40000 ALTER TABLE `galeria_etiquetas` DISABLE KEYS */;
INSERT INTO `galeria_etiquetas` VALUES (6,102),(7,152),(8,152),(9,152),(8,153),(9,153),(6,154),(7,154);
/*!40000 ALTER TABLE `galeria_etiquetas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `galeria_mientidad`
--

DROP TABLE IF EXISTS `galeria_mientidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `galeria_mientidad` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) DEFAULT NULL,
  `url_img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `galeria_mientidad`
--

LOCK TABLES `galeria_mientidad` WRITE;
/*!40000 ALTER TABLE `galeria_mientidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `galeria_mientidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lector`
--

DROP TABLE IF EXISTS `lector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lector` (
  `id_lector` bigint NOT NULL,
  `nombrelector` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_lector`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lector`
--

LOCK TABLES `lector` WRITE;
/*!40000 ALTER TABLE `lector` DISABLE KEYS */;
INSERT INTO `lector` VALUES (1,'Luis');
/*!40000 ALTER TABLE `lector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lector_seq`
--

DROP TABLE IF EXISTS `lector_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lector_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lector_seq`
--

LOCK TABLES `lector_seq` WRITE;
/*!40000 ALTER TABLE `lector_seq` DISABLE KEYS */;
INSERT INTO `lector_seq` VALUES (1);
/*!40000 ALTER TABLE `lector_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro` (
  `id` bigint NOT NULL,
  `nombrelibro` varchar(50) DEFAULT NULL,
  `codigo_autor` bigint DEFAULT NULL,
  `localizacion_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3uqlfgj2v0vdfc7er29lplofr` (`codigo_autor`),
  KEY `FK82wfselu5qksllctpqyvq8lwy` (`localizacion_id`),
  CONSTRAINT `FK3uqlfgj2v0vdfc7er29lplofr` FOREIGN KEY (`codigo_autor`) REFERENCES `autor` (`codigo_autor`),
  CONSTRAINT `FK82wfselu5qksllctpqyvq8lwy` FOREIGN KEY (`localizacion_id`) REFERENCES `localizacionlibros` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro_lector`
--

DROP TABLE IF EXISTS `libro_lector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro_lector` (
  `libro_id` bigint NOT NULL,
  `lector_id` bigint NOT NULL,
  KEY `FKrqqou67btmguuem7gndhkgp72` (`lector_id`),
  KEY `FKslvmmeyu738ax2t40ov01a7oe` (`libro_id`),
  CONSTRAINT `FKrqqou67btmguuem7gndhkgp72` FOREIGN KEY (`lector_id`) REFERENCES `lector` (`id_lector`),
  CONSTRAINT `FKslvmmeyu738ax2t40ov01a7oe` FOREIGN KEY (`libro_id`) REFERENCES `libro` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro_lector`
--

LOCK TABLES `libro_lector` WRITE;
/*!40000 ALTER TABLE `libro_lector` DISABLE KEYS */;
/*!40000 ALTER TABLE `libro_lector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro_seq`
--

DROP TABLE IF EXISTS `libro_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro_seq`
--

LOCK TABLES `libro_seq` WRITE;
/*!40000 ALTER TABLE `libro_seq` DISABLE KEYS */;
INSERT INTO `libro_seq` VALUES (1);
/*!40000 ALTER TABLE `libro_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localizacionlibros`
--

DROP TABLE IF EXISTS `localizacionlibros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `localizacionlibros` (
  `id` bigint NOT NULL,
  `balda` varchar(50) DEFAULT NULL,
  `estanteria` varchar(50) DEFAULT NULL,
  `numero` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localizacionlibros`
--

LOCK TABLES `localizacionlibros` WRITE;
/*!40000 ALTER TABLE `localizacionlibros` DISABLE KEYS */;
/*!40000 ALTER TABLE `localizacionlibros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localizacionlibros_seq`
--

DROP TABLE IF EXISTS `localizacionlibros_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `localizacionlibros_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localizacionlibros_seq`
--

LOCK TABLES `localizacionlibros_seq` WRITE;
/*!40000 ALTER TABLE `localizacionlibros_seq` DISABLE KEYS */;
INSERT INTO `localizacionlibros_seq` VALUES (1);
/*!40000 ALTER TABLE `localizacionlibros_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `active` int DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `app_order` int DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `parent_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgeupubdqncc1lpgf2cn4fqwbc` (`parent_id`),
  CONSTRAINT `FKgeupubdqncc1lpgf2cn4fqwbc` FOREIGN KEY (`parent_id`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,1,'Inicio',0,'/',NULL),(2,1,'Login',1,'/usuarios/login',NULL),(3,1,'General',10,'',NULL),(4,0,'Books',20,'/books',3),(5,0,'Books read',30,'/booksreads',NULL),(6,0,'Books sold',40,'/bookssolds',NULL),(7,1,'Usuarios',50,'',NULL),(8,0,'Lista de usuarios',51,'/usuarios',7),(9,0,'Registrar usarios',52,'/usuarios/registro',7),(10,1,'Clientes',60,NULL,NULL),(11,0,'Lista de clientes',61,'/clientes',10),(12,0,'Registrar cliente',62,'/clientes/registro',10),(13,1,'Etiquetas',70,NULL,NULL),(14,0,'Lista de etiquetas',71,'/etiquetas',13),(15,0,'Registro',72,'/etiquetas/registro',13),(16,1,'Catálogo',80,NULL,NULL),(17,1,'Mookup',81,'/galeria/embed',16),(18,1,'Registro',82,'/galeria/embed/registro',16),(19,1,'Logout',9999,'/logout',NULL);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_roles`
--

DROP TABLE IF EXISTS `menu_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu_roles` (
  `menu_id` int NOT NULL,
  `roles_id` int NOT NULL,
  PRIMARY KEY (`menu_id`,`roles_id`),
  KEY `FKauv6mbpeo296vhbm7avtoi3o8` (`roles_id`),
  CONSTRAINT `FKauv6mbpeo296vhbm7avtoi3o8` FOREIGN KEY (`roles_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKq7k54hb6f3ngdbfpblwj68bhg` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_roles`
--

LOCK TABLES `menu_roles` WRITE;
/*!40000 ALTER TABLE `menu_roles` DISABLE KEYS */;
INSERT INTO `menu_roles` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(11,1),(13,1),(14,1),(15,1),(16,1),(17,1),(18,1),(19,1),(1,2),(2,2),(4,2),(5,2),(6,2),(8,2),(9,2),(10,2),(11,2),(13,2),(14,2),(15,2),(16,2),(17,2),(18,2),(19,2),(1,3),(2,3);
/*!40000 ALTER TABLE `menu_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oficina`
--

DROP TABLE IF EXISTS `oficina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `oficina` (
  `codigo_oficina` bigint NOT NULL,
  `ciudad` varchar(30) DEFAULT NULL,
  `codigo_postal` varchar(10) DEFAULT NULL,
  `linea_direccion1` varchar(50) DEFAULT NULL,
  `linea_direccion2` varchar(50) DEFAULT NULL,
  `pais` varchar(50) DEFAULT NULL,
  `region` varchar(50) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codigo_oficina`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oficina`
--

LOCK TABLES `oficina` WRITE;
/*!40000 ALTER TABLE `oficina` DISABLE KEYS */;
INSERT INTO `oficina` VALUES (1,'Barcelona','España','Barcelona','08019','+34 93 3561182','Avenida Diagonal, 38','3A escalera Derecha'),(2,'Boston','EEUU','MA','02108','+1 215 837 0825','1550 Court Place','Suite 102'),(3,'Londres','Inglaterra','EMEA','EC2N 1HN','+44 20 78772041','52 Old Broad Street','Ground Floor'),(4,'Madrid','España','Madrid','28032','+34 91 7514487','Bulevar Indalecio Prieto, 32',''),(5,'Paris','Francia','EMEA','75017','+33 14 723 4404','29 Rue Jouffroy d\'abbans',''),(6,'San Francisco','EEUU','CA','94080','+1 650 219 4782','100 Market Street','Suite 300'),(7,'Sydney','Australia','APAC','NSW 2010','+61 2 9264 2451','5-11 Wentworth Avenue','Floor #2'),(8,'Talavera de la Reina','España','Castilla-LaMancha','45632','+34 925 867231','Francisco Aguirre, 32','5º piso (exterior)'),(10,'Tokyo','Japón','Chiyoda-Ku','102-8578','+81 33 224 5000','4-1 Kioicho','');
/*!40000 ALTER TABLE `oficina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `pk` bigint NOT NULL,
  `cantidad` bigint DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `ruta_imagen` varchar(255) DEFAULT NULL,
  `id` bigint DEFAULT NULL,
  PRIMARY KEY (`pk`),
  KEY `FKsl284xn13wlxyl7mbg1kh4nkw` (`id`),
  CONSTRAINT `FKp6pofhkhp1p4lg7msbsriyru4` FOREIGN KEY (`id`) REFERENCES `compras` (`pk`),
  CONSTRAINT `FKsl284xn13wlxyl7mbg1kh4nkw` FOREIGN KEY (`id`) REFERENCES `comprasimplificada` (`pk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,6,'Desc 1','uno',5,'',NULL),(2,2,'Desc 2','dos',6,NULL,NULL),(3,7,'Desc 3','tres',9,NULL,NULL),(4,8,'Desc 4','cuatrro',3,NULL,NULL);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos_seq`
--

DROP TABLE IF EXISTS `productos_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos_seq`
--

LOCK TABLES `productos_seq` WRITE;
/*!40000 ALTER TABLE `productos_seq` DISABLE KEYS */;
INSERT INTO `productos_seq` VALUES (1);
/*!40000 ALTER TABLE `productos_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER'),(3,'ROLE_ANONIMOUS'),(4,'ROLE_VENTAS'),(5,'ROLE_ENTRENADOR'),(6,'ROLE_JUGADOR');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sucursal`
--

DROP TABLE IF EXISTS `sucursal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sucursal` (
  `cuenta_id` bigint NOT NULL,
  `sucursal_fk` bigint NOT NULL,
  `titular` varchar(255) DEFAULT NULL,
  `nsucursal` bigint NOT NULL,
  `direcion` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nsucursal`),
  UNIQUE KEY `UK_cq8c74nvhnnd82mnobtg7uuqi` (`sucursal_fk`),
  CONSTRAINT `FKlne3gg2r4kej5ri43xjbxlgw3` FOREIGN KEY (`sucursal_fk`) REFERENCES `sucursal` (`nsucursal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sucursal`
--

LOCK TABLES `sucursal` WRITE;
/*!40000 ALTER TABLE `sucursal` DISABLE KEYS */;
/*!40000 ALTER TABLE `sucursal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` bigint NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `nombre_usuario` varchar(30) DEFAULT NULL,
  `password` varchar(250) DEFAULT NULL,
  `active` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'anonimo@anonimo','anonimo','ttt',_binary '\0'),(2,'jose.manuel.aroca@gmail.es','jma223333','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(3,'ddd@juan.com','JUan','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(4,'nombre4@eoi.com','nombre4','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(5,'nombre5@eoi.com','nombre5','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(6,'nombre6@eoi.com','nombre6','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(7,'nombre7@eoi.com','nombre7','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(8,'nombre8@eoi.com','nombre8','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(9,'nombre9@eoi.com','nombre9','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(10,'nombre10@eoi.com','nombre10','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(11,'nombre11@eoi.com','nombre11','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(12,'nombre12@eoi.com','nombre12','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(13,'nombre13@eoi.com','nombre13','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(14,'nombre14@eoi.com','nombre14','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(15,'nombre15@eoi.com','nombre15','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(16,'nombre16@eoi.com','nombre16','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(17,'nombre17@eoi.com','nombre17','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(18,'nombre18@eoi.com','nombre18','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(19,'nombre19@eoi.com','nombre19','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(20,'nombre20@eoi.com','nombre20','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(21,'nombre21@eoi.com','nombre21','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(22,'nombre22@eoi.com','nombre22','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(23,'nombre23@eoi.com','nombre23','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(24,'nombre24@eoi.com','nombre24','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(25,'nombre25@eoi.com','nombre25','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(26,'nombre26@eoi.com','nombre26','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(27,'nombre27@eoi.com','nombre27','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(28,'nombre28@eoi.com','nombre28','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(29,'nombre29@eoi.com','nombre29','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(30,'nombre30@eoi.com','nombre30','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(31,'nombre31@eoi.com','nombre31','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(32,'nombre32@eoi.com','nombre32','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(33,'nombre33@eoi.com','nombre33','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(34,'nombre34@eoi.com','nombre34','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(35,'nombre35@eoi.com','nombre35','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(36,'nombre36@eoi.com','nombre36','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(37,'nombre37@eoi.com','nombre37','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(38,'nombre38@eoi.com','nombre38','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(39,'nombre39@eoi.com','nombre39','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(40,'nombre40@eoi.com','nombre40','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(41,'nombre41@eoi.com','nombre41','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(42,'nombre42@eoi.com','nombre42','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(43,'nombre43@eoi.com','nombre43','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(44,'nombre44@eoi.com','nombre44','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(45,'nombre45@eoi.com','nombre45','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(46,'nombre46@eoi.com','nombre46','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(47,'nombre47@eoi.com','nombre47','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(48,'nombre48@eoi.com','nombre48','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(49,'nombre49@eoi.com','nombre49','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(50,'nombre50@eoi.com','nombre50','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(51,'nombre51@eoi.com','nombre51','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(52,'nombre52@eoi.com','nombre52','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(53,'nombre53@eoi.com','nombre53','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(54,'nombre54@eoi.com','nombre54','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(55,'nombre55@eoi.com','nombre55','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(56,'nombre56@eoi.com','nombre56','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(57,'nombre57@eoi.com','nombre57','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(58,'nombre58@eoi.com','nombre58','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(59,'nombre59@eoi.com','nombre59','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(60,'nombre60@eoi.com','nombre60','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(61,'nombre61@eoi.com','nombre61','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(62,'nombre62@eoi.com','nombre62','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(63,'nombre63@eoi.com','nombre63','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(64,'nombre64@eoi.com','nombre64','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(65,'nombre65@eoi.com','nombre65','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(66,'nombre66@eoi.com','nombre66','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(67,'nombre67@eoi.com','nombre67','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(68,'nombre68@eoi.com','nombre68','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(69,'nombre69@eoi.com','nombre69','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(70,'nombre70@eoi.com','nombre70','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(71,'nombre71@eoi.com','nombre71','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(72,'nombre72@eoi.com','nombre72','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(73,'nombre73@eoi.com','nombre73','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(74,'nombre74@eoi.com','nombre74','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(75,'nombre75@eoi.com','nombre75','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(76,'nombre76@eoi.com','nombre76','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(77,'nombre77@eoi.com','nombre77','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(78,'nombre78@eoi.com','nombre78','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(79,'nombre79@eoi.com','nombre79','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(80,'nombre80@eoi.com','nombre80','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(81,'nombre81@eoi.com','nombre81','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(82,'nombre82@eoi.com','nombre82','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(83,'nombre83@eoi.com','nombre83','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(84,'nombre84@eoi.com','nombre84','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(85,'nombre85@eoi.com','nombre85','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(86,'nombre86@eoi.com','nombre86','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(87,'nombre87@eoi.com','nombre87','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(88,'nombre88@eoi.com','nombre88','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(89,'nombre89@eoi.com','nombre89','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(90,'nombre90@eoi.com','nombre90','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(91,'nombre91@eoi.com','nombre91','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(92,'nombre92@eoi.com','nombre92','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(93,'nombre93@eoi.com','nombre93','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(94,'nombre94@eoi.com','nombre94','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(95,'nombre95@eoi.com','nombre95','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(96,'nombre96@eoi.com','nombre96','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(97,'nombre97@eoi.com','nombre97','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(98,'nombre98@eoi.com','nombre98','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(99,'nombre99@eoi.com','nombre99','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(100,'nombre100@eoi.com','nombre100','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(101,'nombre101@eoi.com','nombre101','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(102,'nombre102@eoi.com','nombre102','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(103,'nombre103@eoi.com','nombre103','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(104,'nombre104@eoi.com','nombre104','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(105,'nombre105@eoi.com','nombre105','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(106,'nombre106@eoi.com','nombre106','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(107,'nombre107@eoi.com','nombre1072112','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(108,'nombre108@eoi.com','nombre108','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(109,'nombre109@eoi.com','nombre109','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(110,'nombre110@eoi.com','nombre110','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(111,'nombre111@eoi.com','nombre111','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(112,'nombre112@eoi.com','nombre112','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(113,'nombre113@eoi.com','nombre113','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(114,'nombre114@eoi.com','nombre114','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(115,'nombre115@eoi.com','nombre115fsfwsf','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(116,'nombre116@eoi.com','nombre116','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(117,'nombre117@eoi.com','nombre117ssasas','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(118,'nombre118@eoi.com','nombre118','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(119,'nombre119@eoi.com','nombre119','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(120,'nombre120@eoi.com','nombre120','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(121,'nombre121@eoi.com','nombre121','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(122,'nombre122@eoi.com','nombre122','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(123,'nombre123@eoi.com','nombre123','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(124,'nombre124@eoi.com','nombre124','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(125,'nombre125@eoi.com','nombre125','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(126,'nombre126@eoi.com','nombre126','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(127,'nombre127@eoi.com','nombre127','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(128,'nombre128@eoi.com','nombre128','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(129,'nombre129@eoi.com','nombre129','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(130,'nombre130@eoi.com','nombre130','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(131,'nombre131@eoi.com','nombre131','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(132,'nombre132@eoi.com','nombre132','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(133,'nombre133@eoi.com','nombre133','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(134,'nombre134@eoi.com','nombre134','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(135,'nombre135@eoi.com','nombre135','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(136,'nombre136@eoi.com','nombre136','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(137,'nombre137@eoi.com','nombre137','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(138,'nombre138@eoi.com','nombre138','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(139,'nombre139@eoi.com','nombre139','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(140,'nombre140@eoi.com','nombre140','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(141,'nombre141@eoi.com','nombre141','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(142,'nombre142@eoi.com','nombre142','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(143,'nombre143@eoi.com','nombre143','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(144,'nombre144@eoi.com','nombre144','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(145,'nombre145@eoi.com','nombre145','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(146,'nombre146@eoi.com','nombre146','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(147,'nombre147@eoi.com','nombre147','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(148,'nombre148@eoi.com','nombre148','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(149,'nombre149@eoi.com','nombre149','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(150,'nombre150@eoi.com','nombre150','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(151,'nombre151@eoi.com','nombre151','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(152,'nombre152@eoi.com','nombre152','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(153,'nombre153@eoi.com','nombre153','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(154,'nombre154@eoi.com','nombre154','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(155,'nombre155@eoi.com','nombre155','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(156,'nombre156@eoi.com','nombre156','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(157,'nombre157@eoi.com','nombre157','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(158,'nombre158@eoi.com','nombre158','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(159,'nombre159@eoi.com','nombre159','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(160,'nombre160@eoi.com','nombre160','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(161,'nombre161@eoi.com','nombre161','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(162,'nombre162@eoi.com','nombre162','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(163,'nombre163@eoi.com','nombre163','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(164,'nombre164@eoi.com','nombre164','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(165,'nombre165@eoi.com','nombre165','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(166,'nombre166@eoi.com','nombre166','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(167,'admin@a','admin','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(352,'','','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(402,'','','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(552,'adminj@app.com','adminj','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(602,'adming@g.com','adming','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(652,'adming@g.com','adming','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(702,'admingg@dd','admingg','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(752,'adminfff@e','adminfff','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(802,'adminaa@aa','adminaa','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(852,'adminhh@gg','adminhh','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(902,'admin_kk@kk','admin_kk','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(1102,'pepe@p','pepe','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(1103,'lola@eoi.com','lola','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(1252,'pepe@gmail.com','pepe1','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(1302,'pepe2@gmail.com','pepe2','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(1352,'pepe3@gmail.com','pepe3','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '\0'),(1402,'pepe6@g','pepe6','$2a$10$VnbcpNUAaV/VGziEXGzneOTq1G8Y561v/S84.GPFu.rh2/RfD130W',_binary '\0'),(1403,'pepe7@g','pepe7','$2a$10$4FwOPF5DBPYQ7IuhmU/ud.KKDBs1GSU8UOdlime5K2Is0VzvUcDMi',_binary '\0'),(1404,'pepe8@gmail.com','pepe8','$2a$10$4FwOPF5DBPYQ7IuhmU/ud.KKDBs1GSU8UOdlime5K2Is0VzvUcDMi',_binary '\0'),(1452,'pepe9@gmail.com','pepe9','$2a$10$If7OYCcZB5U32VJeJL76se/Ibs8HU4DatwYNJXX7KEZGU8hUjXWCK',_binary '\0'),(1552,'jma@g','jma','$2a$10$Zj4fvo..jfT5vJIqeYwsW.zJaQn1Ev75gquz3xMvTAnfbCs6zXKTO',_binary '\0'),(1602,'a@a','a','$2a$10$Pb/GEo1iKLWO8oO5TKAdpuQHm.Xit0KqDIO.1YAtkOlR/BsaQRcg.',_binary '\0');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_roles`
--

DROP TABLE IF EXISTS `usuario_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_roles` (
  `usuarios_id` bigint NOT NULL,
  `roles_id` int NOT NULL,
  PRIMARY KEY (`usuarios_id`,`roles_id`),
  KEY `FKr5p0u8r15jjo6u7xr1928hsld` (`roles_id`),
  CONSTRAINT `FKli6wslofo9n7han07s8iiwyub` FOREIGN KEY (`usuarios_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FKr5p0u8r15jjo6u7xr1928hsld` FOREIGN KEY (`roles_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_roles`
--

LOCK TABLES `usuario_roles` WRITE;
/*!40000 ALTER TABLE `usuario_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_seq`
--

DROP TABLE IF EXISTS `usuario_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_seq`
--

LOCK TABLES `usuario_seq` WRITE;
/*!40000 ALTER TABLE `usuario_seq` DISABLE KEYS */;
INSERT INTO `usuario_seq` VALUES (1701);
/*!40000 ALTER TABLE `usuario_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `usuariosadmin`
--

DROP TABLE IF EXISTS `usuariosadmin`;
/*!50001 DROP VIEW IF EXISTS `usuariosadmin`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `usuariosadmin` AS SELECT 
 1 AS `id`,
 1 AS `email`,
 1 AS `nombre_usuario`,
 1 AS `password`,
 1 AS `active`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `usuariosadmin`
--

/*!50001 DROP VIEW IF EXISTS `usuariosadmin`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `usuariosadmin` AS select `u`.`id` AS `id`,`u`.`email` AS `email`,`u`.`nombre_usuario` AS `nombre_usuario`,`u`.`password` AS `password`,`u`.`active` AS `active` from ((`usuario` `u` join `usuario_roles` `ur` on((`ur`.`usuarios_id` = `u`.`id`))) join `role` `r` on(((`r`.`id` = `r`.`id`) = `ur`.`roles_id`))) where (`r`.`role_name` = 'ROLE_ADMIN') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-28 12:05:47
