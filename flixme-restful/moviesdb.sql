/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/ moviesdb /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE moviesdb;

DROP TABLE IF EXISTS movies;
CREATE TABLE `movies` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'Primary Key',
  `name` varchar(255) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `releaseYear` varchar(255) DEFAULT NULL,
  `duration` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
INSERT INTO movies(id,name,genre,releaseYear,duration) VALUES(1,'john wick','action','2016','167'),(2,'JOKER','thriller','2020','182'),(3,'spiderman','action','2022','175'),(4,'dolittle','drama','2020','179'),(5,'deadpool','comedy','2018','172');