/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/ usersdb /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE usersdb;

DROP TABLE IF EXISTS users;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'Primary Key',
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
INSERT INTO users(id,name,email,password) VALUES(1,'harsh','harsh@harsh.com','harsh'),(2,'shivam','shivam@shivam.com','password'),(3,'ravi','ravi@ravi.com','password'),(4,'vivek','vivek@vivek.com','password'),(5,'harshit','harshit@harshit.com','password'),(6,'mohit','mohit@mohit.com','password'),(7,'ajay','ajay@ajay.com','password');