ALTER TABLE `visit` ADD COLUMN  `doctors_name` varchar(255) DEFAULT NULL;
ALTER TABLE `visit` ADD COLUMN   `outdoor_register` bigint(20) DEFAULT NULL;
ALTER TABLE `visit` ADD CONSTRAINT `FK_j2oqqmbei4d4qreaj9i1w3008` FOREIGN KEY (`outdoor_register`) REFERENCES `outdoor_register` (`id`);