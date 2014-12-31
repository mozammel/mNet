-- MySQL dump 10.13  Distrib 5.6.19, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mnet
-- ------------------------------------------------------
-- Server version	5.6.19-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `attachment`
--

DROP TABLE IF EXISTS `attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attachment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `comment` varchar(3000) DEFAULT NULL,
  `data` longblob NOT NULL,
  `file_name` varchar(255) NOT NULL,
  `mime_type` varchar(255) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_949xwyj99lx13c3298cmfsjnm` (`created_by`),
  KEY `FK_es00uwstuusrmwyuethk1bdib` (`last_modified_by`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `audit_log`
--

DROP TABLE IF EXISTS `audit_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `audit_log` (
  `audit_log_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `action` varchar(20) DEFAULT NULL,
  `detail` text,
  `entity_id` bigint(20) DEFAULT NULL,
  `entity_name` varchar(255) DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`audit_log_id`),
  KEY `FK_ru17orlmi6rjhpojmeqrxbiok` (`created_by`),
  KEY `FK_5mhlnhc24fjt7ne89m6pl7s8m` (`last_modified_by`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `chief_complaint`
--

DROP TABLE IF EXISTS `chief_complaint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chief_complaint` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `breast_related_complaint` varchar(1000) DEFAULT NULL,
  `child_born_with` varchar(20) DEFAULT NULL,
  `comments` varchar(1000) DEFAULT NULL,
  `days_of_burns` int(11) DEFAULT NULL,
  `days_of_infection` int(11) DEFAULT NULL,
  `days_of_trauma` int(11) DEFAULT NULL,
  `days_of_ulcer_or_swelling_for` int(11) DEFAULT NULL,
  `hours_of_burn` int(11) DEFAULT NULL,
  `hours_of_infection` int(11) DEFAULT NULL,
  `hours_of_trauma` int(11) DEFAULT NULL,
  `month_of_ulcer_or_swelling_for` int(11) DEFAULT NULL,
  `present_illness` varchar(1000) DEFAULT NULL,
  `years_of_ulcer_or_swelling_for` int(11) DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_7kxu79jc5ge30f5a3hnfcxnia` (`created_by`),
  KEY `FK_ep84ybmd4jdcv1f5fexr9p3ue` (`last_modified_by`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `complication_management`
--

DROP TABLE IF EXISTS `complication_management`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `complication_management` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `case_summery` varchar(2000) DEFAULT NULL,
  `comment` varchar(100) DEFAULT NULL,
  `hospital_stays` int(11) NOT NULL,
  `management_of_complication` varchar(2000) DEFAULT NULL,
  `outcome` varchar(12) NOT NULL,
  `post_operative_complication` varchar(2000) NOT NULL,
  `version` bigint(20) DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_jl72n4pd7hu98ac0gtr4q147j` (`created_by`),
  KEY `FK_o6ej57iy9kynu6gvksekf5kgu` (`last_modified_by`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `diagnosis`
--

DROP TABLE IF EXISTS `diagnosis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diagnosis` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `aesthetic` varchar(1000) DEFAULT NULL,
  `comment` varchar(1000) DEFAULT NULL,
  `congenital_anomaly` varchar(1000) DEFAULT NULL,
  `icd10` varchar(100) DEFAULT NULL,
  `neoplastic` varchar(1000) DEFAULT NULL,
  `post_infective` varchar(1000) DEFAULT NULL,
  `traumatic` varchar(1000) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `burns` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_3gxs07x78x7e3i1letw88vbq` (`created_by`),
  KEY `FK_kh3otsbq8cp9lyc1r5ncujsjq` (`last_modified_by`),
  KEY `FK_40k1vr577fpqjuyqpf70l4drm` (`burns`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `diagnosis_data`
--

DROP TABLE IF EXISTS `diagnosis_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diagnosis_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `conditions` varchar(12) DEFAULT NULL,
  `days_old` bigint(20) DEFAULT NULL,
  `percentage` bigint(20) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `examination`
--

DROP TABLE IF EXISTS `examination`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `examination` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `accessible_lymph_node` bit(1) DEFAULT NULL,
  `anaemia` bit(1) DEFAULT NULL,
  `cardiovascular_system` varchar(1000) DEFAULT NULL,
  `comments` varchar(1000) DEFAULT NULL,
  `dehydration` bit(1) DEFAULT NULL,
  `g_examination_comments` varchar(1000) DEFAULT NULL,
  `gisystem` varchar(1000) DEFAULT NULL,
  `jaundice` bit(1) DEFAULT NULL,
  `listening_examination` varchar(1000) DEFAULT NULL,
  `neck_vein` bit(1) DEFAULT NULL,
  `nervous_system` varchar(1000) DEFAULT NULL,
  `oelema` bit(1) DEFAULT NULL,
  `respiratory_system` varchar(1000) DEFAULT NULL,
  `urogenital_system` varchar(1000) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_d9yn1v940wvkq55mvln7384kl` (`created_by`),
  KEY `FK_fxtt04216w7v1ilrdmrjoscu5` (`last_modified_by`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `investigation`
--

DROP TABLE IF EXISTS `investigation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `investigation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `albumin_globulin_ratio` varchar(100) DEFAULT NULL,
  `alphos` varchar(100) DEFAULT NULL,
  `aptt` varchar(100) DEFAULT NULL,
  `comment_blood_cbc` varchar(1000) DEFAULT NULL,
  `date_inv_blood_cbc` date DEFAULT NULL,
  `dc` varchar(100) DEFAULT NULL,
  `esr` varchar(100) DEFAULT NULL,
  `hb` varchar(100) DEFAULT NULL,
  `pcv` varchar(100) DEFAULT NULL,
  `tc` varchar(100) DEFAULT NULL,
  `comment_blood_cs` varchar(1000) DEFAULT NULL,
  `date_inv_blood_cs` date DEFAULT NULL,
  `blood_cbc_name_of_organism` varchar(100) DEFAULT NULL,
  `blood_cbc_sensitive_antibiotic` varchar(100) DEFAULT NULL,
  `c_reactive_protein` varchar(100) DEFAULT NULL,
  `d_dimer` varchar(100) DEFAULT NULL,
  `date_albumin_globulin_ratio` date DEFAULT NULL,
  `date_alphos` date DEFAULT NULL,
  `date_aptt` date DEFAULT NULL,
  `datecreactive_protein` date DEFAULT NULL,
  `dateddimer` date DEFAULT NULL,
  `date_fdp` date DEFAULT NULL,
  `date_of_duplex_scan_doppler_study` date DEFAULT NULL,
  `date_of_fnac_histopathology` date DEFAULT NULL,
  `date_of_mri_mra_ct_echo_ecg` date DEFAULT NULL,
  `date_ofxray_usg` date DEFAULT NULL,
  `date_rbs` date DEFAULT NULL,
  `datestotal_protein` date DEFAULT NULL,
  `date_serum_albumin` date DEFAULT NULL,
  `date_serum_creatinine` date DEFAULT NULL,
  `date_sgpt` date DEFAULT NULL,
  `duplex_scan_doppler_study` varchar(1000) DEFAULT NULL,
  `bicarbonate` varchar(255) DEFAULT NULL,
  `calcium` varchar(255) DEFAULT NULL,
  `chlorine` varchar(255) DEFAULT NULL,
  `comment_electrolyte` varchar(255) DEFAULT NULL,
  `date_inv_electrolyte` date DEFAULT NULL,
  `potassium` varchar(255) DEFAULT NULL,
  `sodium` varchar(255) DEFAULT NULL,
  `fdp` varchar(100) DEFAULT NULL,
  `fnac_histopathology` varchar(1000) DEFAULT NULL,
  `mri_mra_ct_echo_ecg` varchar(1000) DEFAULT NULL,
  `other_investigation` varchar(1000) DEFAULT NULL,
  `comment_pt` varchar(100) DEFAULT NULL,
  `control` varchar(100) DEFAULT NULL,
  `date_inv_pt` date DEFAULT NULL,
  `in_index` varchar(100) DEFAULT NULL,
  `patient` varchar(100) DEFAULT NULL,
  `rbs` varchar(100) DEFAULT NULL,
  `s_total_protein` varchar(100) DEFAULT NULL,
  `serum_albumin` varchar(100) DEFAULT NULL,
  `serum_creatinine` varchar(100) DEFAULT NULL,
  `sgpt` varchar(100) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `comment_wound_cs` varchar(1000) DEFAULT NULL,
  `date_inv_wound_cs` date DEFAULT NULL,
  `wound_cs_name_of_organism` varchar(100) DEFAULT NULL,
  `wound_cs_sensitive_antibiotic` varchar(100) DEFAULT NULL,
  `x_ray_usg` varchar(1000) DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `register` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_gl1r9kljph48niyxyfpktotcg` (`created_by`),
  KEY `FK_7wyayv59t4d42k97i53yihesv` (`last_modified_by`),
  KEY `FK_f260kitdrcbcb3c3y1ot01d8n` (`register`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `life_style`
--

DROP TABLE IF EXISTS `life_style`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `life_style` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `economical_status` varchar(50) DEFAULT NULL,
  `habit` varchar(20) DEFAULT NULL,
  `other_habit` varchar(255) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_5xdcddijfbm8p79kwm6ml017p` (`created_by`),
  KEY `FK_jn6svwfc0emx0wh6tlx74a4vy` (`last_modified_by`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `medical_history`
--

DROP TABLE IF EXISTS `medical_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medical_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `comments` varchar(1000) DEFAULT NULL,
  `days` int(11) DEFAULT NULL,
  `drug_history` varchar(1000) DEFAULT NULL,
  `family_history` varchar(1000) DEFAULT NULL,
  `menstrual_cycle` varchar(10) DEFAULT NULL,
  `past_medical_history` varchar(6) DEFAULT NULL,
  `past_surgical_history` varchar(1000) DEFAULT NULL,
  `period` int(11) DEFAULT NULL,
  `present_illness` varchar(1000) DEFAULT NULL,
  `similar_diseases_in_family` bit(1) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_bah7f8mkwq3m8pl0egpvaajft` (`created_by`),
  KEY `FK_msyaqn65ljmwxalij50mtq5ho` (`last_modified_by`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `operational_detail`
--

DROP TABLE IF EXISTS `operational_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operational_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `anaesthesia` varchar(255) NOT NULL,
  `blood_transfusion` varchar(15) NOT NULL,
  `comment` varchar(1000) DEFAULT NULL,
  `date_time` datetime NOT NULL,
  `donor_site` varchar(255) DEFAULT NULL,
  `drain` varchar(5) NOT NULL,
  `findings` varchar(255) DEFAULT NULL,
  `incision` varchar(255) DEFAULT NULL,
  `indication` varchar(255) DEFAULT NULL,
  `name_of_anaesthetist` varchar(255) NOT NULL,
  `name_of_operation` varchar(255) NOT NULL,
  `name_of_surgeon` varchar(255) NOT NULL,
  `plasty` varchar(255) DEFAULT NULL,
  `recipient_site` varchar(255) DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `register` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_oo4et477tk7yy1ewes2ygxn2h` (`created_by`),
  KEY `FK_1w7uua0ktlfs6cduuop4lh6s6` (`last_modified_by`),
  KEY `FK_7g0mrp0qu57v0k28yxhfgst6j` (`register`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `district` varchar(32) DEFAULT NULL,
  `division` varchar(32) DEFAULT NULL,
  `home_address` varchar(256) DEFAULT NULL,
  `police_station` varchar(32) DEFAULT NULL,
  `post_office` varchar(32) DEFAULT NULL,
  `birthdate_estimated` bit(1) NOT NULL,
  `blood_type` varchar(16) DEFAULT NULL,
  `contact_number` varchar(32) NOT NULL,
  `date_of_birth` date DEFAULT NULL,
  `dead` bit(1) DEFAULT NULL,
  `death_date` date DEFAULT NULL,
  `education_level` varchar(20) DEFAULT NULL,
  `gender` varchar(6) NOT NULL,
  `health_id` varchar(32) DEFAULT NULL,
  `marital_status` varchar(12) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `nid` varchar(255) DEFAULT NULL,
  `occupation` varchar(20) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_f8vdg65ct6jhs6bf2nq35o6pd` (`created_by`),
  KEY `FK_kbknskxk7pqxna2v88mmpfn18` (`last_modified_by`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `picture_information`
--

DROP TABLE IF EXISTS `picture_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picture_information` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `version` bigint(20) DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_39g89kcccgp57cu0fpw5pg44` (`created_by`),
  KEY `FK_eo8lbgximqfqsvg0t3gn04a3d` (`last_modified_by`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `picture_information_day_one_attachments`
--

DROP TABLE IF EXISTS `picture_information_day_one_attachments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picture_information_day_one_attachments` (
  `picture_information` bigint(20) NOT NULL,
  `day_one_attachments` bigint(20) NOT NULL,
  PRIMARY KEY (`picture_information`,`day_one_attachments`),
  UNIQUE KEY `UK_ox410kwafs3f7qc7un652ybrv` (`day_one_attachments`),
  CONSTRAINT `FK_eikvnh1qghlqwqhip8545s7fy` FOREIGN KEY (`picture_information`) REFERENCES `picture_information` (`id`),
  CONSTRAINT `FK_ox410kwafs3f7qc7un652ybrv` FOREIGN KEY (`day_one_attachments`) REFERENCES `attachment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `picture_information_on_discharge_attachments`
--

DROP TABLE IF EXISTS `picture_information_on_discharge_attachments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picture_information_on_discharge_attachments` (
  `picture_information` bigint(20) NOT NULL,
  `on_discharge_attachments` bigint(20) NOT NULL,
  PRIMARY KEY (`picture_information`,`on_discharge_attachments`),
  UNIQUE KEY `UK_otbqr9ejwrf63kej0q9nqmrmt` (`on_discharge_attachments`),
  CONSTRAINT `FK_ygqjl6242tjflds5v6kbg6yn` FOREIGN KEY (`picture_information`) REFERENCES `picture_information` (`id`),
  CONSTRAINT `FK_otbqr9ejwrf63kej0q9nqmrmt` FOREIGN KEY (`on_discharge_attachments`) REFERENCES `attachment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `picture_information_post_operative_attachments`
--

DROP TABLE IF EXISTS `picture_information_post_operative_attachments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picture_information_post_operative_attachments` (
  `picture_information` bigint(20) NOT NULL,
  `post_operative_attachments` bigint(20) NOT NULL,
  PRIMARY KEY (`picture_information`,`post_operative_attachments`),
  UNIQUE KEY `UK_gu9c625eycj7fb55tete27l7l` (`post_operative_attachments`),
  CONSTRAINT `FK_m8e4txs1h64ugsxqrdo9h5r6i` FOREIGN KEY (`picture_information`) REFERENCES `picture_information` (`id`),
  CONSTRAINT `FK_gu9c625eycj7fb55tete27l7l` FOREIGN KEY (`post_operative_attachments`) REFERENCES `attachment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `picture_information_pre_operation_attachments`
--

DROP TABLE IF EXISTS `picture_information_pre_operation_attachments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picture_information_pre_operation_attachments` (
  `picture_information` bigint(20) NOT NULL,
  `pre_operation_attachments` bigint(20) NOT NULL,
  PRIMARY KEY (`picture_information`,`pre_operation_attachments`),
  UNIQUE KEY `UK_a5yit4hlpwu55oofd4ecehk21` (`pre_operation_attachments`),
  CONSTRAINT `FK_7eh53gqw09066uclqlwn2pg6t` FOREIGN KEY (`picture_information`) REFERENCES `picture_information` (`id`),
  CONSTRAINT `FK_a5yit4hlpwu55oofd4ecehk21` FOREIGN KEY (`pre_operation_attachments`) REFERENCES `attachment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `picture_information_pre_operative_attachments`
--

DROP TABLE IF EXISTS `picture_information_pre_operative_attachments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picture_information_pre_operative_attachments` (
  `picture_information` bigint(20) NOT NULL,
  `pre_operative_attachments` bigint(20) NOT NULL,
  PRIMARY KEY (`picture_information`,`pre_operative_attachments`),
  UNIQUE KEY `UK_3mkk726tpmlertqb3pubikok1` (`pre_operative_attachments`),
  CONSTRAINT `FK_5qgr0ejbl3r7qw82yro349roj` FOREIGN KEY (`picture_information`) REFERENCES `picture_information` (`id`),
  CONSTRAINT `FK_3mkk726tpmlertqb3pubikok1` FOREIGN KEY (`pre_operative_attachments`) REFERENCES `attachment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `register`
--

DROP TABLE IF EXISTS `register`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `register` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `admission_date` date NOT NULL,
  `bed_number` varchar(32) NOT NULL,
  `comments` varchar(100) DEFAULT NULL,
  `contact_person` varchar(100) DEFAULT NULL,
  `emergency_contact_number` varchar(32) DEFAULT NULL,
  `relationship` varchar(10) DEFAULT NULL,
  `registration_id` varchar(255) NOT NULL,
  `start_datetime` datetime DEFAULT NULL,
  `status` varchar(6) DEFAULT NULL,
  `stop_datetime` datetime DEFAULT NULL,
  `unit` varchar(32) NOT NULL,
  `version` bigint(20) DEFAULT NULL,
  `ward` varchar(10) NOT NULL,
  `ward_other` varchar(100) DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `chief_complaint_id` bigint(20) DEFAULT NULL,
  `complication_management` bigint(20) DEFAULT NULL,
  `diagnosis_id` bigint(20) DEFAULT NULL,
  `examination_id` bigint(20) DEFAULT NULL,
  `life_style_id` bigint(20) DEFAULT NULL,
  `medical_history_id` bigint(20) DEFAULT NULL,
  `patient` bigint(20) DEFAULT NULL,
  `picture_information_id` bigint(20) DEFAULT NULL,
  `treatment_plan_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_89wufyrntvj3y7sg0wry5t2t1` (`created_by`),
  KEY `FK_dq2iy8s2e3cjih8shycpqjae3` (`last_modified_by`),
  KEY `FK_7j5im8ewf41aga18cxih1n0x4` (`chief_complaint_id`),
  KEY `FK_odnnpoxx1lg4gfhpqn6wvjbe` (`complication_management`),
  KEY `FK_9uxqcher3y7vj0guipe8snie1` (`diagnosis_id`),
  KEY `FK_772gydsf3jveu20uge6eejcau` (`examination_id`),
  KEY `FK_1pq2919ithrseofwe6mlqxwh8` (`life_style_id`),
  KEY `FK_5eqqcfeotssu1vcm7k7jycl68` (`medical_history_id`),
  KEY `FK_3nivuqi2jkxw1ib3wmhsj51g7` (`patient`),
  KEY `FK_t66imy1xjry17t88htx0l1k4q` (`picture_information_id`),
  KEY `FK_3dj2bf7wvt2j5t4jt6eoi9n0n` (`treatment_plan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `register_visits`
--

DROP TABLE IF EXISTS `register_visits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `register_visits` (
  `register` bigint(20) NOT NULL,
  `visits` bigint(20) NOT NULL,
  PRIMARY KEY (`register`,`visits`),
  UNIQUE KEY `UK_j2g9w595nen1q8404l0j5bwfs` (`visits`),
  CONSTRAINT `FK_e6p7rdygo8jq6lb3ho5jr3f6d` FOREIGN KEY (`register`) REFERENCES `register` (`id`),
  CONSTRAINT `FK_j2g9w595nen1q8404l0j5bwfs` FOREIGN KEY (`visits`) REFERENCES `visit` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `remember_me_token`
--

DROP TABLE IF EXISTS `remember_me_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `remember_me_token` (
  `series` varchar(255) NOT NULL,
  `last_used_date` datetime DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `treatment_plan`
--

DROP TABLE IF EXISTS `treatment_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `treatment_plan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `comment` varchar(1000) DEFAULT NULL,
  `fasciotomy_or_escharotomy` bit(1) DEFAULT NULL,
  `flap_pedicled` bit(1) DEFAULT NULL,
  `free_flap` bit(1) DEFAULT NULL,
  `implant_insertion` bit(1) DEFAULT NULL,
  `repair_reconstruction_part` bit(1) DEFAULT NULL,
  `stsg_or_ftsg` bit(1) DEFAULT NULL,
  `tissue_expansion` bit(1) DEFAULT NULL,
  `treatment_plan_type` varchar(16) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_kkakkfdheifst0jpofwdw3pbc` (`created_by`),
  KEY `FK_80taoeqok80lv6o72usb3pa2i` (`last_modified_by`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `account_non_expired` bit(1) NOT NULL,
  `account_non_locked` bit(1) NOT NULL,
  `credentials_non_expired` bit(1) NOT NULL,
  `designation` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `hashed_password` varchar(280) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `salt` varchar(16) DEFAULT NULL,
  `username` varchar(30) NOT NULL,
  `version` bigint(20) DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`),
  KEY `FK_90va3gtpnkq1jr6lbb2048dfi` (`created_by`),
  KEY `FK_618tfe6b91hd765jt637l4um0` (`last_modified_by`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `roles` varchar(255) DEFAULT NULL,
  KEY `FK_apcc8lxk2xnug8377fatvbn04` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `visit`
--

DROP TABLE IF EXISTS `visit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `visit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `comment` varchar(3000) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `visit_time` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_liyb8ytn2tln6kytlv8p54ono` (`created_by`),
  KEY `FK_1re5ifbsfauycysh2f1ubq7dc` (`last_modified_by`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vital`
--

DROP TABLE IF EXISTS `vital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vital` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `blood_oxygen_saturation` double DEFAULT NULL,
  `bmi` double DEFAULT NULL,
  `diastolic` int(11) NOT NULL,
  `height` double DEFAULT NULL,
  `pulse` int(11) DEFAULT NULL,
  `respiratory_rate` int(11) DEFAULT NULL,
  `status` varchar(6) DEFAULT NULL,
  `systolic` int(11) NOT NULL,
  `temperature` double NOT NULL,
  `version` bigint(20) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `patient` bigint(20) DEFAULT NULL,
  `register` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_24uymd0e201q3tkcf3eljym3f` (`created_by`),
  KEY `FK_cc2k0hejb79oas0joeu9deq9p` (`last_modified_by`),
  KEY `FK_bqdgtjehrrqykn1a2jnvh1fop` (`patient`),
  KEY `FK_7r1j73oq27oq1iuopc6nih9c9` (`register`),
  CONSTRAINT `FK_7r1j73oq27oq1iuopc6nih9c9` FOREIGN KEY (`register`) REFERENCES `register` (`id`),
  CONSTRAINT `FK_24uymd0e201q3tkcf3eljym3f` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_bqdgtjehrrqykn1a2jnvh1fop` FOREIGN KEY (`patient`) REFERENCES `patient` (`id`),
  CONSTRAINT `FK_cc2k0hejb79oas0joeu9deq9p` FOREIGN KEY (`last_modified_by`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-31 23:30:01
