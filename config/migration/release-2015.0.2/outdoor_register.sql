CREATE TABLE IF NOT EXISTS `outdoor_register` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `follow_up_advice` longtext,
  `outcome` longtext,
  `comments` varchar(100) DEFAULT NULL,
  `contact_person` varchar(100) DEFAULT NULL,
  `emergency_contact_number` varchar(32) DEFAULT NULL,
  `relationship` varchar(10) DEFAULT NULL,
  `registration_id` varchar(255) NOT NULL,
  `remarks` longtext,
  `start_datetime` datetime NOT NULL,
  `status` varchar(6) DEFAULT NULL,
  `stop_datetime` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `chief_complaint_id` bigint(20) DEFAULT NULL,
  `diagnosis_id` bigint(20) DEFAULT NULL,
  `examination_id` bigint(20) DEFAULT NULL,
  `patient` bigint(20) DEFAULT NULL,
  `picture_information_id` bigint(20) DEFAULT NULL,
  `treatment_plan_id` bigint(20) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_baejggcd9ewmju29la1fl0ka0` (`created_by`),
  KEY `FK_ht4bkdenpylw5irhpc3sedq1l` (`last_modified_by`),
  KEY `FK_ey8qbt76pcmwpgfsfvehhigoa` (`chief_complaint_id`),
  KEY `FK_tcm11h7grpkqtyqj2qdqlbo3f` (`diagnosis_id`),
  KEY `FK_8xotbig47m53ka17b7nq67527` (`examination_id`),
  KEY `FK_sqlf1jw1bwrgo4repr5thnwox` (`patient`),
  KEY `FK_bh1yyk525o6k3w0onl5g6kaq7` (`picture_information_id`),
  KEY `FK_c1yyfxhpoirn8ka2qwiib0brl` (`treatment_plan_id`)
);

--
-- Constraints for table `outdoor_register`
--
ALTER TABLE `outdoor_register`
ADD CONSTRAINT `FK_8xotbig47m53ka17b7nq67527` FOREIGN KEY (`examination_id`) REFERENCES `examination` (`id`),
ADD CONSTRAINT `FK_baejggcd9ewmju29la1fl0ka0` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`),
ADD CONSTRAINT `FK_bh1yyk525o6k3w0onl5g6kaq7` FOREIGN KEY (`picture_information_id`) REFERENCES `picture_information` (`id`),
ADD CONSTRAINT `FK_c1yyfxhpoirn8ka2qwiib0brl` FOREIGN KEY (`treatment_plan_id`) REFERENCES `treatment_plan` (`id`),
ADD CONSTRAINT `FK_ey8qbt76pcmwpgfsfvehhigoa` FOREIGN KEY (`chief_complaint_id`) REFERENCES `chief_complaint` (`id`),
ADD CONSTRAINT `FK_ht4bkdenpylw5irhpc3sedq1l` FOREIGN KEY (`last_modified_by`) REFERENCES `user` (`id`),
ADD CONSTRAINT `FK_sqlf1jw1bwrgo4repr5thnwox` FOREIGN KEY (`patient`) REFERENCES `patient` (`id`),
ADD CONSTRAINT `FK_tcm11h7grpkqtyqj2qdqlbo3f` FOREIGN KEY (`diagnosis_id`) REFERENCES `diagnosis` (`id`);
