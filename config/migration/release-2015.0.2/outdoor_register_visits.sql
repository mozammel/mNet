CREATE TABLE IF NOT EXISTS `outdoor_register_visits` (
  `outdoor_register` bigint(20) NOT NULL,
  `visits` bigint(20) NOT NULL,
  PRIMARY KEY (`outdoor_register`,`visits`),
  UNIQUE KEY `UK_2j3i29cxl0pe35hbcc542mo3k` (`visits`)
);

-- Constraints for table `outdoor_register_visits`
--
ALTER TABLE `outdoor_register_visits`
ADD CONSTRAINT `FK_1tm7jlf5dy8u0aqlaikgr24cs` FOREIGN KEY (`outdoor_register`) REFERENCES `outdoor_register` (`id`),
ADD CONSTRAINT `FK_2j3i29cxl0pe35hbcc542mo3k` FOREIGN KEY (`visits`) REFERENCES `visit` (`id`);
