drop database if exists book_store;
 create database book_store;
 use book_store;
 CREATE TABLE `author` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `discount` (
  `id` int NOT NULL AUTO_INCREMENT,
  `percent` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;
CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `description` longtext,
  `dimension` varchar(255) DEFAULT NULL,
  `image` longtext,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `release_date` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `total_page` int DEFAULT NULL,
  `translator` varchar(255) DEFAULT NULL,
  `author_id` int DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  `discount_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKklnrv3weler2ftkweewlky958` (`author_id`),
  KEY `FKam9riv8y6rjwkua1gapdfew4j` (`category_id`),
  KEY `FKh602ahsjpusnkvli2askfuj3s` (`discount_id`),
  CONSTRAINT `FKam9riv8y6rjwkua1gapdfew4j` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FKh602ahsjpusnkvli2askfuj3s` FOREIGN KEY (`discount_id`) REFERENCES `discount` (`id`),
  CONSTRAINT `FKklnrv3weler2ftkweewlky958` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`)
);

CREATE TABLE `users` (
  `username` varchar(255) NOT NULL,
  `flag` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
);

CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKixgo6lw7snw8ctly9at6t2g8` (`username`),
  CONSTRAINT `FKixgo6lw7snw8ctly9at6t2g8` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
);
CREATE TABLE `cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date_create` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdebwvad6pp1ekiqy5jtixqbaj` (`customer_id`),
  CONSTRAINT `FKdebwvad6pp1ekiqy5jtixqbaj` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
);
CREATE TABLE `cart_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantity` int DEFAULT NULL,
  `book_id` int DEFAULT NULL,
  `cart_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKflpu1psdex9le27p7owju2piw` (`book_id`),
  KEY `FKrg4yopd2252nwj8bfcgq5f4jp` (`cart_id`),
  CONSTRAINT `FKflpu1psdex9le27p7owju2piw` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `FKrg4yopd2252nwj8bfcgq5f4jp` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`)
);
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role` int DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfhq23r1o3cqe0n8jdi4vyv4s8` (`role`),
  KEY `FK2svos04wv92op6gs17m9omli1` (`username`),
  CONSTRAINT `FK2svos04wv92op6gs17m9omli1` FOREIGN KEY (`username`) REFERENCES `users` (`username`),
  CONSTRAINT `FKfhq23r1o3cqe0n8jdi4vyv4s8` FOREIGN KEY (`role`) REFERENCES `roles` (`id`)
);
