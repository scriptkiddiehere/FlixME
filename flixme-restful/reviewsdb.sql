/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/ reviewsdb /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE reviewsdb;

DROP TABLE IF EXISTS reviews;
CREATE TABLE `reviews` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'Primary Key',
  `userId` int DEFAULT NULL,
  `movieId` int DEFAULT NULL,
  `movieName` varchar(255) DEFAULT NULL,
  `review` varchar(255) DEFAULT NULL,
  `rating` decimal(4,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
INSERT INTO reviews(id,userId,movieId,movieName,review,rating) VALUES(1,1,2,'JOKER','nice movie',4),(2,2,2,'JOKER','awesome movie',5),(3,2,1,'john wick','great movie',5),(4,4,3,'spiderman','Must watch movie',5),(5,3,4,'dolittle','Average movie',3),(6,6,5,'deadpool','Nice movie',4);