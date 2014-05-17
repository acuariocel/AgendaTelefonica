CREATE DATABASE  IF NOT EXISTS `dbcontactos`;
USE `dbcontactos`;
DROP TABLE IF EXISTS `persona`;
CREATE TABLE `persona` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `cedula` varchar(10) DEFAULT NULL,
  `nombres` varchar(32) NOT NULL,
  `appPaterno` varchar(32) NOT NULL,
  `appMaterno` varchar(32) DEFAULT NULL,
  `mail` varchar(32) DEFAULT '@gmail.com',
  `edad` int(11) DEFAULT NULL,
  `celular` varchar(10) DEFAULT '09',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
LOCK TABLES `persona` WRITE;
INSERT INTO `persona` VALUES (1,NULL,'Diego','Romero','Armijos','diegoacuario11@gmail.com',24,'09'),(2,NULL,'Yoder','cajas','rivadeneira','tu_correo@gmail.com',NULL,'09'),(3,NULL,'JOSE LUIS','ALVARADO','TORRES','tu_correo@gmail.com',NULL,'09');
UNLOCK TABLES;