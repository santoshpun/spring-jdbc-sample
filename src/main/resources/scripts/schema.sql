use pms;

DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `department`;
--
-- Table structure for table `department`
--
CREATE TABLE `department` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `name` varchar(255) NOT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `users`
--
CREATE TABLE `users` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `username` varchar(20) NOT NULL,
                         `password` varchar(50) NOT NULL,
                         `name` varchar(255) NOT NULL,
                         `added_date` datetime NOT NULL,
                         `department_id` int DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         KEY `department_id` (`department_id`),
                         CONSTRAINT `users_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;