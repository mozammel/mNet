ALTER TABLE `vital` ADD COLUMN `outdoor_register` bigint(20) DEFAULT NULL;
ALTER TABLE `vital` ADD CONSTRAINT `FK_omwsucimdxqqlqs99qs5jhxvg` FOREIGN KEY (`outdoor_register`) REFERENCES `outdoor_register` (`id`);