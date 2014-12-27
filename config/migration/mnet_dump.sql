CREATE DATABASE  IF NOT EXISTS `mnet` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `mnet`;
-- MySQL dump 10.13  Distrib 5.6.19, for linux-glibc2.5 (x86_64)
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
  KEY `FK_es00uwstuusrmwyuethk1bdib` (`last_modified_by`),
  CONSTRAINT `FK_es00uwstuusrmwyuethk1bdib` FOREIGN KEY (`last_modified_by`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_949xwyj99lx13c3298cmfsjnm` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attachment`
--

LOCK TABLES `attachment` WRITE;
/*!40000 ALTER TABLE `attachment` DISABLE KEYS */;
/*!40000 ALTER TABLE `attachment` ENABLE KEYS */;
UNLOCK TABLES;

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
  KEY `FK_5mhlnhc24fjt7ne89m6pl7s8m` (`last_modified_by`),
  CONSTRAINT `FK_5mhlnhc24fjt7ne89m6pl7s8m` FOREIGN KEY (`last_modified_by`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_ru17orlmi6rjhpojmeqrxbiok` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit_log`
--

LOCK TABLES `audit_log` WRITE;
/*!40000 ALTER TABLE `audit_log` DISABLE KEYS */;
INSERT INTO `audit_log` VALUES (1,'2014-12-27 14:34:05','2014-12-27 14:34:05','CREATED','{\"id\":3,\"version\":0,\"fullName\":\"Mozammel Haque\",\"designation\":\"DOCTOR\",\"username\":\"mozammel\",\"password\":\"Mozammel#4321\",\"hashedPassword\":\"bd2fd911cde42e4dbd885019c7db24126643484a3ec312b24e1f5705ab790b81\",\"salt\":\"G3TKX3KKKKh8XV6f\",\"email\":\"mozammel@gmail.com\",\"phoneNumber\":\"01713409321\",\"roles\":[\"ROLE_USER\",\"ROLE_ADMIN\"],\"accountNonExpired\":true,\"accountNonLocked\":true,\"credentialsNonExpired\":true,\"enabled\":true,\"authorities\":[{\"authority\":\"ROLE_USER\"},{\"authority\":\"ROLE_ADMIN\"}]}',3,'org.jugbd.mnet.domain.User',2,2);
/*!40000 ALTER TABLE `audit_log` ENABLE KEYS */;
UNLOCK TABLES;

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
  KEY `FK_ep84ybmd4jdcv1f5fexr9p3ue` (`last_modified_by`),
  CONSTRAINT `FK_ep84ybmd4jdcv1f5fexr9p3ue` FOREIGN KEY (`last_modified_by`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_7kxu79jc5ge30f5a3hnfcxnia` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chief_complaint`
--

LOCK TABLES `chief_complaint` WRITE;
/*!40000 ALTER TABLE `chief_complaint` DISABLE KEYS */;
/*!40000 ALTER TABLE `chief_complaint` ENABLE KEYS */;
UNLOCK TABLES;

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
  KEY `FK_o6ej57iy9kynu6gvksekf5kgu` (`last_modified_by`),
  CONSTRAINT `FK_o6ej57iy9kynu6gvksekf5kgu` FOREIGN KEY (`last_modified_by`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_jl72n4pd7hu98ac0gtr4q147j` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complication_management`
--

LOCK TABLES `complication_management` WRITE;
/*!40000 ALTER TABLE `complication_management` DISABLE KEYS */;
/*!40000 ALTER TABLE `complication_management` ENABLE KEYS */;
UNLOCK TABLES;

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
  KEY `FK_40k1vr577fpqjuyqpf70l4drm` (`burns`),
  CONSTRAINT `FK_40k1vr577fpqjuyqpf70l4drm` FOREIGN KEY (`burns`) REFERENCES `diagnosis_data` (`id`),
  CONSTRAINT `FK_3gxs07x78x7e3i1letw88vbq` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_kh3otsbq8cp9lyc1r5ncujsjq` FOREIGN KEY (`last_modified_by`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diagnosis`
--

LOCK TABLES `diagnosis` WRITE;
/*!40000 ALTER TABLE `diagnosis` DISABLE KEYS */;
/*!40000 ALTER TABLE `diagnosis` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `diagnosis_data`
--

LOCK TABLES `diagnosis_data` WRITE;
/*!40000 ALTER TABLE `diagnosis_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `diagnosis_data` ENABLE KEYS */;
UNLOCK TABLES;

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
  KEY `FK_fxtt04216w7v1ilrdmrjoscu5` (`last_modified_by`),
  CONSTRAINT `FK_fxtt04216w7v1ilrdmrjoscu5` FOREIGN KEY (`last_modified_by`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_d9yn1v940wvkq55mvln7384kl` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examination`
--

LOCK TABLES `examination` WRITE;
/*!40000 ALTER TABLE `examination` DISABLE KEYS */;
/*!40000 ALTER TABLE `examination` ENABLE KEYS */;
UNLOCK TABLES;

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
  `dc` varchar(100) DEFAULT NULL,
  `esr` varchar(100) DEFAULT NULL,
  `hb` varchar(100) DEFAULT NULL,
  `pcv` varchar(100) DEFAULT NULL,
  `tc` varchar(100) DEFAULT NULL,
  `comment_blood_cs` varchar(1000) DEFAULT NULL,
  `blood_cbc_name_of_organism` varchar(100) DEFAULT NULL,
  `blood_cbc_sensitive_antibiotic` varchar(100) DEFAULT NULL,
  `c_reactive_protein` varchar(100) DEFAULT NULL,
  `d_dimer` varchar(100) DEFAULT NULL,
  `duplex_scan_doppler_study` varchar(1000) DEFAULT NULL,
  `bicarbonate` varchar(255) DEFAULT NULL,
  `calcium` varchar(255) DEFAULT NULL,
  `chlorine` varchar(255) DEFAULT NULL,
  `comment_electrolyte` varchar(255) DEFAULT NULL,
  `potassium` varchar(255) DEFAULT NULL,
  `sodium` varchar(255) DEFAULT NULL,
  `fdp` varchar(100) DEFAULT NULL,
  `fnac_histopathology` varchar(1000) DEFAULT NULL,
  `mri_mra_ct_echo_ecg` varchar(1000) DEFAULT NULL,
  `other_investigation` varchar(1000) DEFAULT NULL,
  `comment_pt` varchar(100) DEFAULT NULL,
  `control` varchar(100) DEFAULT NULL,
  `in_index` varchar(100) DEFAULT NULL,
  `patient` varchar(100) DEFAULT NULL,
  `rbs` varchar(100) DEFAULT NULL,
  `s_total_protein` varchar(100) DEFAULT NULL,
  `serum_albumin` varchar(100) DEFAULT NULL,
  `serum_creatinine` varchar(100) DEFAULT NULL,
  `sgpt` varchar(100) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `comment_wound_cs` varchar(1000) DEFAULT NULL,
  `wound_cs_name_of_organism` varchar(100) DEFAULT NULL,
  `wound_cs_sensitive_antibiotic` varchar(100) DEFAULT NULL,
  `x_ray_usg` varchar(1000) DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_gl1r9kljph48niyxyfpktotcg` (`created_by`),
  KEY `FK_7wyayv59t4d42k97i53yihesv` (`last_modified_by`),
  CONSTRAINT `FK_7wyayv59t4d42k97i53yihesv` FOREIGN KEY (`last_modified_by`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_gl1r9kljph48niyxyfpktotcg` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `investigation`
--

LOCK TABLES `investigation` WRITE;
/*!40000 ALTER TABLE `investigation` DISABLE KEYS */;
/*!40000 ALTER TABLE `investigation` ENABLE KEYS */;
UNLOCK TABLES;

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
  KEY `FK_jn6svwfc0emx0wh6tlx74a4vy` (`last_modified_by`),
  CONSTRAINT `FK_jn6svwfc0emx0wh6tlx74a4vy` FOREIGN KEY (`last_modified_by`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_5xdcddijfbm8p79kwm6ml017p` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `life_style`
--

LOCK TABLES `life_style` WRITE;
/*!40000 ALTER TABLE `life_style` DISABLE KEYS */;
/*!40000 ALTER TABLE `life_style` ENABLE KEYS */;
UNLOCK TABLES;

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
  KEY `FK_msyaqn65ljmwxalij50mtq5ho` (`last_modified_by`),
  CONSTRAINT `FK_msyaqn65ljmwxalij50mtq5ho` FOREIGN KEY (`last_modified_by`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_bah7f8mkwq3m8pl0egpvaajft` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_history`
--

LOCK TABLES `medical_history` WRITE;
/*!40000 ALTER TABLE `medical_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `medical_history` ENABLE KEYS */;
UNLOCK TABLES;

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
  KEY `FK_7g0mrp0qu57v0k28yxhfgst6j` (`register`),
  CONSTRAINT `FK_7g0mrp0qu57v0k28yxhfgst6j` FOREIGN KEY (`register`) REFERENCES `register` (`id`),
  CONSTRAINT `FK_1w7uua0ktlfs6cduuop4lh6s6` FOREIGN KEY (`last_modified_by`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_oo4et477tk7yy1ewes2ygxn2h` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operational_detail`
--

LOCK TABLES `operational_detail` WRITE;
/*!40000 ALTER TABLE `operational_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `operational_detail` ENABLE KEYS */;
UNLOCK TABLES;

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
  KEY `FK_kbknskxk7pqxna2v88mmpfn18` (`last_modified_by`),
  CONSTRAINT `FK_kbknskxk7pqxna2v88mmpfn18` FOREIGN KEY (`last_modified_by`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_f8vdg65ct6jhs6bf2nq35o6pd` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'2014-11-29 01:12:52','2014-11-29 01:12:52','SHERPUR','Dhaka','Gouripur','Sherpur Twon','Sherpur Twon','\0','O_POSITIVE','01671865012','1989-04-23','\0',NULL,'GRADUATE','MALE','DHA-SHE-DX26AMPKC','SINGLE','Bazlur Rahman Rokon','','PROFESSIONAL',0,2,2);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

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
  `investigation_id` bigint(20) DEFAULT NULL,
  `life_style_id` bigint(20) DEFAULT NULL,
  `medical_history_id` bigint(20) DEFAULT NULL,
  `patient` bigint(20) DEFAULT NULL,
  `treatment_plan_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_89wufyrntvj3y7sg0wry5t2t1` (`created_by`),
  KEY `FK_dq2iy8s2e3cjih8shycpqjae3` (`last_modified_by`),
  KEY `FK_7j5im8ewf41aga18cxih1n0x4` (`chief_complaint_id`),
  KEY `FK_odnnpoxx1lg4gfhpqn6wvjbe` (`complication_management`),
  KEY `FK_9uxqcher3y7vj0guipe8snie1` (`diagnosis_id`),
  KEY `FK_772gydsf3jveu20uge6eejcau` (`examination_id`),
  KEY `FK_fpieu8h4eq2dyxve078t6rxoo` (`investigation_id`),
  KEY `FK_1pq2919ithrseofwe6mlqxwh8` (`life_style_id`),
  KEY `FK_5eqqcfeotssu1vcm7k7jycl68` (`medical_history_id`),
  KEY `FK_3nivuqi2jkxw1ib3wmhsj51g7` (`patient`),
  KEY `FK_3dj2bf7wvt2j5t4jt6eoi9n0n` (`treatment_plan_id`),
  CONSTRAINT `FK_3dj2bf7wvt2j5t4jt6eoi9n0n` FOREIGN KEY (`treatment_plan_id`) REFERENCES `treatment_plan` (`id`),
  CONSTRAINT `FK_1pq2919ithrseofwe6mlqxwh8` FOREIGN KEY (`life_style_id`) REFERENCES `life_style` (`id`),
  CONSTRAINT `FK_3nivuqi2jkxw1ib3wmhsj51g7` FOREIGN KEY (`patient`) REFERENCES `patient` (`id`),
  CONSTRAINT `FK_5eqqcfeotssu1vcm7k7jycl68` FOREIGN KEY (`medical_history_id`) REFERENCES `medical_history` (`id`),
  CONSTRAINT `FK_772gydsf3jveu20uge6eejcau` FOREIGN KEY (`examination_id`) REFERENCES `examination` (`id`),
  CONSTRAINT `FK_7j5im8ewf41aga18cxih1n0x4` FOREIGN KEY (`chief_complaint_id`) REFERENCES `chief_complaint` (`id`),
  CONSTRAINT `FK_89wufyrntvj3y7sg0wry5t2t1` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_9uxqcher3y7vj0guipe8snie1` FOREIGN KEY (`diagnosis_id`) REFERENCES `diagnosis` (`id`),
  CONSTRAINT `FK_dq2iy8s2e3cjih8shycpqjae3` FOREIGN KEY (`last_modified_by`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_fpieu8h4eq2dyxve078t6rxoo` FOREIGN KEY (`investigation_id`) REFERENCES `investigation` (`id`),
  CONSTRAINT `FK_odnnpoxx1lg4gfhpqn6wvjbe` FOREIGN KEY (`complication_management`) REFERENCES `complication_management` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `register`
--

LOCK TABLES `register` WRITE;
/*!40000 ALTER TABLE `register` DISABLE KEYS */;
/*!40000 ALTER TABLE `register` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `register_visits`
--

LOCK TABLES `register_visits` WRITE;
/*!40000 ALTER TABLE `register_visits` DISABLE KEYS */;
/*!40000 ALTER TABLE `register_visits` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `remember_me_token`
--

LOCK TABLES `remember_me_token` WRITE;
/*!40000 ALTER TABLE `remember_me_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `remember_me_token` ENABLE KEYS */;
UNLOCK TABLES;

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
  KEY `FK_80taoeqok80lv6o72usb3pa2i` (`last_modified_by`),
  CONSTRAINT `FK_80taoeqok80lv6o72usb3pa2i` FOREIGN KEY (`last_modified_by`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_kkakkfdheifst0jpofwdw3pbc` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treatment_plan`
--

LOCK TABLES `treatment_plan` WRITE;
/*!40000 ALTER TABLE `treatment_plan` DISABLE KEYS */;
/*!40000 ALTER TABLE `treatment_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'','','','DOCTOR','anmbrr.bit0112@gmail.com','','Bazlur Rahman Rokon','71a22e0a425083a7bdb509259056072373abaccde1f7e28e7d851aa0c580e255','01671865012','4xnnVjhyx8rsyBXY','rokonoid',0),(3,'','','','DOCTOR','mozammel@gmail.com','','Mozammel Haque','bd2fd911cde42e4dbd885019c7db24126643484a3ec312b24e1f5705ab790b81','01713409321','G3TKX3KKKKh8XV6f','mozammel',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `roles` varchar(255) DEFAULT NULL,
  KEY `FK_apcc8lxk2xnug8377fatvbn04` (`user_id`),
  CONSTRAINT `FK_apcc8lxk2xnug8377fatvbn04` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (2,'ROLE_USER'),(2,'ROLE_ADMIN'),(3,'ROLE_USER'),(3,'ROLE_ADMIN');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

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
  KEY `FK_1re5ifbsfauycysh2f1ubq7dc` (`last_modified_by`),
  CONSTRAINT `FK_1re5ifbsfauycysh2f1ubq7dc` FOREIGN KEY (`last_modified_by`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_liyb8ytn2tln6kytlv8p54ono` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visit`
--

LOCK TABLES `visit` WRITE;
/*!40000 ALTER TABLE `visit` DISABLE KEYS */;
/*!40000 ALTER TABLE `visit` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Dumping data for table `vital`
--

LOCK TABLES `vital` WRITE;
/*!40000 ALTER TABLE `vital` DISABLE KEYS */;
/*!40000 ALTER TABLE `vital` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-27 14:47:00
