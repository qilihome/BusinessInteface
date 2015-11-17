-- MySQL dump 10.13  Distrib 5.1.62, for debian-linux-gnu (i486)
--
-- Host: localhost    Database: weichat
-- ------------------------------------------------------
-- Server version	5.1.62-0ubuntu0.10.04.1

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
-- Table structure for table `t_customer_album`
--

DROP TABLE IF EXISTS `t_customer_album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_customer_album` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` text CHARACTER SET utf8,
  `albumName` text CHARACTER SET utf8 COMMENT '相册名称',
  `albumSummary` text CHARACTER SET utf8 COMMENT '相册描述',
  `albumAuthor` text CHARACTER SET utf8 COMMENT '相册作者',
  `shootTime` text CHARACTER SET utf8 COMMENT '拍摄时间',
  `shootAddress` text CHARACTER SET utf8 COMMENT '拍摄地点',
  `albumStyle` text CHARACTER SET utf8 COMMENT '拍摄风格',
  `savePath` text CHARACTER SET utf8 COMMENT '存放路径',
  `createTime` text CHARACTER SET utf8 COMMENT '添加时间',
  `backup1` text CHARACTER SET utf8 COMMENT '备用字段1',
  `backup2` text CHARACTER SET utf8 COMMENT '备用字段2',
  `backup3` text CHARACTER SET utf8 COMMENT '备用字段3',
  `backup4` text CHARACTER SET utf8 COMMENT '备用字段4',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_customer_album_photo`
--

DROP TABLE IF EXISTS `t_customer_album_photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_customer_album_photo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` text CHARACTER SET utf8 COMMENT '客户ID',
  `albumId` int(11) DEFAULT NULL COMMENT '相集ID',
  `photoName` text COLLATE utf8_unicode_ci COMMENT '相片名称',
  `photoSummary` text CHARACTER SET utf8 COMMENT '相片备注',
  `saveFile` text CHARACTER SET utf8 COMMENT '相片保存的文件名称',
  `createtime` text COLLATE utf8_unicode_ci COMMENT '相片上传时间',
  `backup1` text CHARACTER SET utf8 COMMENT '备用字段',
  `backup2` text CHARACTER SET utf8 COMMENT '备用字段',
  `backup3` text CHARACTER SET utf8 COMMENT '备用字段',
  `backup4` text CHARACTER SET utf8 COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=159 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_customer_template_content`
--

DROP TABLE IF EXISTS `t_customer_template_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_customer_template_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `customer_Id` text CHARACTER SET utf8 COMMENT '客户编号,32位UUID字符串',
  `template_id` int(11) DEFAULT NULL COMMENT '模块ID',
  `template_area_id` int(11) DEFAULT NULL COMMENT '模板区域ID',
  `template_area_name` text CHARACTER SET utf8 COMMENT '模板区域名称',
  `title` text COLLATE utf8_unicode_ci COMMENT '客户设置的区域标题',
  `content` text COLLATE utf8_unicode_ci COMMENT '客户设置的区域内容',
  `summary` text COLLATE utf8_unicode_ci COMMENT '客户设置的区域备注',
  `contentType` int(11) DEFAULT NULL COMMENT '内容类型',
  `backup1` text COLLATE utf8_unicode_ci COMMENT '备用字段',
  `backup2` text COLLATE utf8_unicode_ci COMMENT '备用字段',
  `backup3` text COLLATE utf8_unicode_ci COMMENT '备用字段',
  `backup4` text COLLATE utf8_unicode_ci COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=615 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_expert_review`
--

DROP TABLE IF EXISTS `t_expert_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_expert_review` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` tinytext CHARACTER SET utf8 COMMENT '专家名称',
  `headSculpture` tinytext CHARACTER SET utf8 COMMENT '专家头像',
  `title` tinytext CHARACTER SET utf8 COMMENT '专家头衔',
  `honor` text COLLATE utf8_unicode_ci COMMENT '专家荣誉',
  `reviewSubject` tinytext CHARACTER SET utf8 COMMENT '点评主题',
  `reviewContent` text COLLATE utf8_unicode_ci COMMENT '点评内容',
  `customerId` tinytext CHARACTER SET utf8 COMMENT '客户编号',
  `templateId` int(11) DEFAULT NULL COMMENT '模板编号',
  `templateAreaId` int(11) DEFAULT NULL COMMENT '模板区域编号',
  `backup1` tinytext CHARACTER SET utf8,
  `backup2` tinytext CHARACTER SET utf8,
  `backup3` tinytext CHARACTER SET utf8,
  `backup4` tinytext CHARACTER SET utf8,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_template`
--

DROP TABLE IF EXISTS `t_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` text COLLATE utf8_unicode_ci NOT NULL COMMENT '模板名称',
  `type` text CHARACTER SET utf8 COMMENT '模板类型，一般保持与名称相同',
  `summary` text CHARACTER SET utf8 COMMENT '模板描述',
  `areaNum` int(11) DEFAULT NULL COMMENT '模板区域数量',
  `backup1` text CHARACTER SET utf8 COMMENT '备用字段',
  `backup2` text CHARACTER SET utf8 COMMENT '备用字段',
  `backup3` text CHARACTER SET utf8 COMMENT '备用字段',
  `backup4` text CHARACTER SET utf8 COMMENT '备用字段',
  `addtime` text CHARACTER SET utf8 COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_template_area`
--

DROP TABLE IF EXISTS `t_template_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_template_area` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `template_id` int(11) NOT NULL COMMENT '模板ID',
  `name` text CHARACTER SET utf8 NOT NULL COMMENT '区域名称',
  `contentType` int(11) NOT NULL COMMENT '区域类型',
  `backup1` text CHARACTER SET utf8 COMMENT '备用字段',
  `backup2` text CHARACTER SET utf8 COMMENT '备用字段',
  `backup3` text CHARACTER SET utf8 COMMENT '备用字段',
  `backup4` text CHARACTER SET utf8 COMMENT '备用字段',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_vote`
--

DROP TABLE IF EXISTS `t_vote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_vote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` tinytext CHARACTER SET utf8 COMMENT '客户编号',
  `name` tinytext CHARACTER SET utf8 COMMENT '投票活动名称',
  `templateId` int(11) DEFAULT NULL COMMENT '模板编号',
  `templateAreaId` int(11) DEFAULT NULL COMMENT '模板区域编号',
  `backup1` tinytext CHARACTER SET utf8,
  `backup2` tinytext CHARACTER SET utf8,
  `backup3` tinytext CHARACTER SET utf8,
  `backup4` tinytext CHARACTER SET utf8,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_vote_option`
--

DROP TABLE IF EXISTS `t_vote_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_vote_option` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` tinytext CHARACTER SET utf8,
  `templateId` int(11) DEFAULT NULL,
  `templateAreaId` int(11) DEFAULT NULL,
  `voteId` int(11) DEFAULT NULL,
  `name` tinytext CHARACTER SET utf8 COMMENT '选项名称',
  `votes` int(11) DEFAULT NULL COMMENT '投票数',
  `backup1` tinytext COLLATE utf8_unicode_ci,
  `backup2` tinytext COLLATE utf8_unicode_ci,
  `backup3` tinytext COLLATE utf8_unicode_ci,
  `backup4` tinytext COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_vote_record`
--

DROP TABLE IF EXISTS `t_vote_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_vote_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `voteId` int(11) DEFAULT NULL,
  `voteOptionId` int(11) DEFAULT NULL,
  `userId` tinytext CHARACTER SET utf8,
  `voteTime` tinytext CHARACTER SET utf8,
  `backup1` tinytext CHARACTER SET utf8,
  `backup2` tinytext CHARACTER SET utf8,
  `backup3` tinytext CHARACTER SET utf8,
  `backup4` tinytext CHARACTER SET utf8,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-07-06 19:11:33
