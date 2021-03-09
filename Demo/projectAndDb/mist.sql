-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               10.4.11-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for mist
CREATE DATABASE IF NOT EXISTS `mist` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `mist`;

-- Dumping structure for table mist.agent
CREATE TABLE IF NOT EXISTS `agent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parentId` int(11) NOT NULL DEFAULT -1,
  `userId` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `mobileNo` varchar(50) NOT NULL,
  `address` varchar(500) DEFAULT NULL,
  `pin` varchar(200) NOT NULL,
  `active` bit(1) DEFAULT b'1',
  `created` datetime NOT NULL,
  `createdBy` int(11) NOT NULL,
  `lastModified` datetime DEFAULT NULL,
  `lastModifiedBy` int(11) DEFAULT NULL,
  `type` tinyint(1) NOT NULL COMMENT '1 = reseller, 2 = agent',
  `rowLastUpdated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `ringId` bigint(20) DEFAULT 0,
  `coinCommission` int(11) DEFAULT 0,
  `goldCommission` int(11) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `agent_userId_unique` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mist.agent: ~3 rows (approximately)
/*!40000 ALTER TABLE `agent` DISABLE KEYS */;
INSERT IGNORE INTO `agent` (`id`, `parentId`, `userId`, `name`, `password`, `mobileNo`, `address`, `pin`, `active`, `created`, `createdBy`, `lastModified`, `lastModifiedBy`, `type`, `rowLastUpdated`, `ringId`, `coinCommission`, `goldCommission`) VALUES
	(4, -1, 'pr@yopmail.com', 'pr parent', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '123456789', 'Dhaka%20BD', '112358', b'1', '2019-04-27 11:59:46', 20, '2019-05-05 12:36:37', 4, 1, '2021-03-08 21:48:10', 0, 0, 0),
	(5, 4, 'l1r1@yopmail.com', 'l1r1 resell', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '1234', 'Not Set', '1234', b'1', '2019-04-27 12:51:47', 1, '2019-04-29 11:41:10', 1, 1, '2021-03-08 21:46:54', 0, 10, 3),
	(6, 4, 'l1a1@yopmail.com', 'l1a1 agent', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '8801719014482', 'Not Set', '1234', b'1', '2019-04-27 13:10:13', 1, '2019-07-24 15:29:42', 20, 2, '2021-03-08 21:46:56', 0, 4, 2);
/*!40000 ALTER TABLE `agent` ENABLE KEYS */;

-- Dumping structure for table mist.agentaccount
CREATE TABLE IF NOT EXISTS `agentaccount` (
  `agentId` int(11) NOT NULL,
  `coinId` int(11) NOT NULL,
  `coinAmount` int(11) NOT NULL DEFAULT 0,
  `rowLastUpdated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`agentId`,`coinId`),
  KEY `coinId` (`coinId`),
  CONSTRAINT `agentAccount_ibfk_1` FOREIGN KEY (`coinId`) REFERENCES `coin` (`coinId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mist.agentaccount: ~3 rows (approximately)
/*!40000 ALTER TABLE `agentaccount` DISABLE KEYS */;
INSERT IGNORE INTO `agentaccount` (`agentId`, `coinId`, `coinAmount`, `rowLastUpdated`) VALUES
	(4, 1, 5819, '2019-05-06 10:04:39'),
	(5, 1, 11792, '2019-05-05 16:50:11'),
	(6, 1, 2329, '2019-05-06 10:04:39');
/*!40000 ALTER TABLE `agentaccount` ENABLE KEYS */;

-- Dumping structure for table mist.agentadminapprovallog
CREATE TABLE IF NOT EXISTS `agentadminapprovallog` (
  `logId` bigint(20) NOT NULL AUTO_INCREMENT,
  `agentId` int(11) DEFAULT -1,
  `parentId` int(11) NOT NULL DEFAULT -1,
  `userId` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `mobileNo` varchar(50) NOT NULL,
  `address` varchar(500) DEFAULT NULL,
  `pin` varchar(200) NOT NULL,
  `active` bit(1) NOT NULL,
  `approvalStatus` tinyint(3) NOT NULL COMMENT '1 = pending, 2 = approved, 3 = rejected',
  `externalRemarks` varchar(1000) DEFAULT NULL,
  `adminRemarks` varchar(1000) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `createdBy` int(11) DEFAULT NULL,
  `lastModified` datetime DEFAULT NULL,
  `lastModifiedBy` int(11) DEFAULT NULL,
  `type` tinyint(1) NOT NULL COMMENT '1 = reseller, 2 = agent',
  `rowLastUpdated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `ringId` bigint(20) DEFAULT NULL,
  `coinCommission` int(11) DEFAULT 0,
  `goldCommission` int(11) DEFAULT 0,
  PRIMARY KEY (`logId`),
  UNIQUE KEY `agent_ad_app_log_userId_unique` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mist.agentadminapprovallog: ~0 rows (approximately)
/*!40000 ALTER TABLE `agentadminapprovallog` DISABLE KEYS */;
INSERT IGNORE INTO `agentadminapprovallog` (`logId`, `agentId`, `parentId`, `userId`, `name`, `password`, `mobileNo`, `address`, `pin`, `active`, `approvalStatus`, `externalRemarks`, `adminRemarks`, `created`, `createdBy`, `lastModified`, `lastModifiedBy`, `type`, `rowLastUpdated`, `ringId`, `coinCommission`, `goldCommission`) VALUES
	(1, -1, -1, 'pr@yopmail.com', 'pr reseller', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', '1234', 'Not Set', '1234', b'0', 2, NULL, '', '2019-04-27 11:56:37', -1, '2019-04-27 11:59:46', 20, 1, '2019-04-27 11:59:46', 0, 0, 0);
/*!40000 ALTER TABLE `agentadminapprovallog` ENABLE KEYS */;

-- Dumping structure for table mist.agentauditlog
CREATE TABLE IF NOT EXISTS `agentauditlog` (
  `auditId` int(11) NOT NULL AUTO_INCREMENT,
  `agentId` int(11) NOT NULL,
  `parentId` int(11) NOT NULL,
  `userId` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `mobileNo` varchar(50) NOT NULL,
  `address` varchar(500) DEFAULT NULL,
  `pin` varchar(200) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `created` datetime NOT NULL,
  `createdBy` int(11) NOT NULL,
  `lastModified` datetime DEFAULT NULL,
  `lastModifiedBy` int(11) DEFAULT NULL,
  `recordStatus` tinyint(1) DEFAULT NULL COMMENT '1 = insert, 2 = update, 3 = delete ',
  `type` tinyint(1) NOT NULL COMMENT '1 = reseller, 2 = agent',
  `rowLastUpdated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `ringId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`auditId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mist.agentauditlog: ~48 rows (approximately)
/*!40000 ALTER TABLE `agentauditlog` DISABLE KEYS */;
INSERT IGNORE INTO `agentauditlog` (`auditId`, `agentId`, `parentId`, `userId`, `name`, `password`, `mobileNo`, `address`, `pin`, `active`, `created`, `createdBy`, `lastModified`, `lastModifiedBy`, `recordStatus`, `type`, `rowLastUpdated`, `ringId`) VALUES
	(1, 1, -1, 'oly@gmail.com', 'oly', '123456', '01552300022', NULL, 'r64kb4vugf1n7m7thdu82e5835', b'0', '2017-05-06 01:33:13', 2, NULL, NULL, 1, 0, '2017-08-20 15:22:02', NULL),
	(2, 1, -1, 'oly@gmail.com', 'oly', '123456', '01552300022', NULL, 'r64kb4vugf1n7m7thdu82e5835', b'0', '2017-05-06 01:33:13', 2, '2017-05-06 01:34:31', 5, 2, 0, '2017-08-20 15:22:02', NULL),
	(3, 2, -1, 'ol2y@gmail.com', 'oly', '123456', '01552300022', NULL, 'kb64av5vbcj3hnbclo0bf5283b', b'0', '2017-05-06 03:21:47', 1, NULL, NULL, 1, 0, '2017-08-20 15:22:02', NULL),
	(4, 3, -1, 'oly111@gmail.com', 'oly', '123456', '01552300022', 'Not Set', '123', b'0', '2017-05-08 00:49:24', 9, NULL, NULL, 1, 0, '2017-08-20 15:22:02', NULL),
	(5, 5, -1, 'aaa@gmail.com', 'aaaa', '1111', '11111', 'Not Set', '111', b'0', '2017-05-08 01:08:12', 9, NULL, NULL, 1, 0, '2017-08-20 15:22:02', NULL);
/*!40000 ALTER TABLE `agentauditlog` ENABLE KEYS */;

-- Dumping structure for table mist.agentpasswordreset
CREATE TABLE IF NOT EXISTS `agentpasswordreset` (
  `agentId` int(11) NOT NULL,
  `token` varchar(256) NOT NULL,
  `created` datetime NOT NULL,
  PRIMARY KEY (`agentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mist.agentpasswordreset: ~0 rows (approximately)
/*!40000 ALTER TABLE `agentpasswordreset` DISABLE KEYS */;
/*!40000 ALTER TABLE `agentpasswordreset` ENABLE KEYS */;

-- Dumping structure for table mist.agentregistrationlog
CREATE TABLE IF NOT EXISTS `agentregistrationlog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parentId` int(11) NOT NULL DEFAULT -1,
  `userId` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `mobileNo` varchar(50) NOT NULL,
  `address` varchar(500) DEFAULT NULL,
  `pin` varchar(200) NOT NULL,
  `type` tinyint(1) NOT NULL,
  `verificationToken` varchar(256) NOT NULL,
  `created` datetime NOT NULL,
  `verificationStatus` bit(1) NOT NULL DEFAULT b'0',
  `ringId` bigint(20) DEFAULT NULL,
  `coinCommission` int(11) DEFAULT 0,
  `goldCommission` int(11) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `agent_reg_log_userId_unique` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mist.agentregistrationlog: ~3 rows (approximately)
/*!40000 ALTER TABLE `agentregistrationlog` DISABLE KEYS */;
INSERT IGNORE INTO `agentregistrationlog` (`id`, `parentId`, `userId`, `name`, `password`, `mobileNo`, `address`, `pin`, `type`, `verificationToken`, `created`, `verificationStatus`, `ringId`, `coinCommission`, `goldCommission`) VALUES
	(1, -1, 'pr@yopmail.com', 'pr reseller', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', '1234', 'Not Set', '1234', 1, 'verified', '2019-04-27 11:47:26', b'1', 0, 0, 0),
	(2, 1, 'l1r1@yopmail.com', 'l1r1 resell', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', '1234', 'Not Set', '1234', 1, 'verified', '2019-04-27 12:46:19', b'1', 0, 10, 5),
	(3, 1, 'l1a1@yopmail.com', 'l1a1 agent', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', '1234', 'Not Set', '1234', 2, 'verified', '2019-04-27 13:07:28', b'1', 0, 8, 4);
/*!40000 ALTER TABLE `agentregistrationlog` ENABLE KEYS */;

-- Dumping structure for table mist.agentwalletcoin
CREATE TABLE IF NOT EXISTS `agentwalletcoin` (
  `userId` bigint(20) NOT NULL,
  `coinId` int(11) NOT NULL,
  `earnedCoin` decimal(14,2) NOT NULL DEFAULT 0.00,
  `purchasedCoin` decimal(14,2) NOT NULL DEFAULT 0.00,
  `blockedEarnedCoin` decimal(14,2) DEFAULT 0.00,
  `commissionInPercent` decimal(8,2) NOT NULL DEFAULT 0.00,
  `commissionCoin` decimal(14,2) DEFAULT 0.00,
  `blockedCommissionCoin` decimal(14,2) DEFAULT 0.00,
  `agentType` int(11) NOT NULL DEFAULT 0,
  `lockedCoinBalance` decimal(14,2) DEFAULT 0.00,
  `soldCoin` decimal(14,2) DEFAULT 0.00,
  `rowLastUpdated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`userId`,`coinId`),
  KEY `coinId` (`coinId`),
  CONSTRAINT `agentWalletCoin_ibfk_1` FOREIGN KEY (`coinId`) REFERENCES `coin` (`coinId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table mist.agentwalletcoin: ~3 rows (approximately)
/*!40000 ALTER TABLE `agentwalletcoin` DISABLE KEYS */;
INSERT IGNORE INTO `agentwalletcoin` (`userId`, `coinId`, `earnedCoin`, `purchasedCoin`, `blockedEarnedCoin`, `commissionInPercent`, `commissionCoin`, `blockedCommissionCoin`, `agentType`, `lockedCoinBalance`, `soldCoin`, `rowLastUpdated`) VALUES
	(68719477351, 1, 70000.00, 70000.00, 0.00, 0.00, 0.00, 0.00, 0, 0.00, 0.00, '2020-03-09 00:40:43'),
	(137438953784, 1, 50000.00, 50000.00, 0.00, 0.00, 0.00, 0.00, 0, 0.00, 0.00, '2020-03-09 00:40:43'),
	(27487790694401, 1, 1150000.00, 1150000.00, 0.00, 0.00, 0.00, 0.00, 0, 0.00, 0.00, '2020-03-11 18:42:50');
/*!40000 ALTER TABLE `agentwalletcoin` ENABLE KEYS */;

-- Dumping structure for table mist.permittedipaddress
CREATE TABLE IF NOT EXISTS `permittedipaddress` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(20) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mist.permittedipaddress: ~0 rows (approximately)
/*!40000 ALTER TABLE `permittedipaddress` DISABLE KEYS */;
INSERT IGNORE INTO `permittedipaddress` (`id`, `ip`, `active`) VALUES
	(1, '127.0.0.1', 1),
	(2, '103.26.112.17', 1),
	(3, '38.102.83.48', 1),
	(4, '38.102.83.67', 1),
	(5, '192.168.8.41', 1);
/*!40000 ALTER TABLE `permittedipaddress` ENABLE KEYS */;

-- Dumping structure for table mist.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '0',
  `password` varchar(50) NOT NULL DEFAULT '0',
  `studentId` varchar(50) NOT NULL DEFAULT '0',
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table mist.user: ~2 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT IGNORE INTO `user` (`id`, `username`, `password`, `studentId`) VALUES
	(1, 'selim', 'abc123', '1234'),
	(2, 'mahmud', '123abc', '5678');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
