-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.18-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema restaurant_ms
--

CREATE DATABASE IF NOT EXISTS restaurant_ms;
USE restaurant_ms;

--
-- Definition of table `tbl_admin`
--

DROP TABLE IF EXISTS `tbl_admin`;
CREATE TABLE `tbl_admin` (
  `adminID` int(10) unsigned NOT NULL auto_increment,
  `adminName` varchar(45) NOT NULL,
  `adminPhone` varchar(45) default NULL,
  `adminGender` varchar(45) default NULL,
  `adminPassword` varchar(45) NOT NULL,
  PRIMARY KEY  (`adminID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_admin`
--

/*!40000 ALTER TABLE `tbl_admin` DISABLE KEYS */;
INSERT INTO `tbl_admin` (`adminID`,`adminName`,`adminPhone`,`adminGender`,`adminPassword`) VALUES 
 (6,'test','','','test');
/*!40000 ALTER TABLE `tbl_admin` ENABLE KEYS */;


--
-- Definition of table `tbl_category`
--

DROP TABLE IF EXISTS `tbl_category`;
CREATE TABLE `tbl_category` (
  `catID` int(10) unsigned NOT NULL auto_increment,
  `catName` varchar(45) NOT NULL,
  `catDescription` varchar(45) NOT NULL,
  `adminID` int(10) unsigned default NULL,
  PRIMARY KEY  USING BTREE (`catID`),
  KEY `FK_tbl_category_1` (`adminID`),
  CONSTRAINT `FK_tbl_category_1` FOREIGN KEY (`adminID`) REFERENCES `tbl_admin` (`adminID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_category`
--

/*!40000 ALTER TABLE `tbl_category` DISABLE KEYS */;
INSERT INTO `tbl_category` (`catID`,`catName`,`catDescription`,`adminID`) VALUES 
 (13,'Dessert','sweets',NULL),
 (14,'Traditional','',NULL),
 (17,'Soft Drinks','drinks',NULL),
 (18,'Fasting','ye tsom',NULL),
 (19,'Fruits','Fresh',NULL);
/*!40000 ALTER TABLE `tbl_category` ENABLE KEYS */;


--
-- Definition of table `tbl_customer`
--

DROP TABLE IF EXISTS `tbl_customer`;
CREATE TABLE `tbl_customer` (
  `customerID` int(10) unsigned NOT NULL auto_increment,
  `customerName` varchar(45) NOT NULL,
  `customerPhone` varchar(45) default NULL,
  `customerGender` varchar(45) default NULL,
  `customerPassword` varchar(45) NOT NULL,
  PRIMARY KEY  (`customerID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_customer`
--

/*!40000 ALTER TABLE `tbl_customer` DISABLE KEYS */;
INSERT INTO `tbl_customer` (`customerID`,`customerName`,`customerPhone`,`customerGender`,`customerPassword`) VALUES 
 (6,'test','','','test'),
 (7,'test1','','','test'),
 (8,'e','666768','male','123'),
 (9,'B','','','7'),
 (10,'eyob','','','ey'),
 (11,'eyoba','','','123');
/*!40000 ALTER TABLE `tbl_customer` ENABLE KEYS */;


--
-- Definition of table `tbl_item`
--

DROP TABLE IF EXISTS `tbl_item`;
CREATE TABLE `tbl_item` (
  `itemID` int(10) unsigned NOT NULL auto_increment,
  `itemName` varchar(45) NOT NULL,
  `itemPrice` varchar(45) NOT NULL,
  `catID` int(10) unsigned NOT NULL,
  `itemQuan` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`itemID`),
  KEY `FK_tbl_item_1` (`catID`),
  CONSTRAINT `FK_tbl_item_1` FOREIGN KEY (`catID`) REFERENCES `tbl_category` (`catID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_item`
--

/*!40000 ALTER TABLE `tbl_item` DISABLE KEYS */;
INSERT INTO `tbl_item` (`itemID`,`itemName`,`itemPrice`,`catID`,`itemQuan`) VALUES 
 (3,'Cakes','40',13,1),
 (4,'Orange','40',14,9),
 (11,'Coca Cola','12',17,11),
 (12,'Black Forest','52',13,41),
 (14,'Doro Wot','200',14,12),
 (15,'Beyaynet ','30',18,12),
 (16,'sprite','15',17,90),
 (17,'Apple','12',19,100);
/*!40000 ALTER TABLE `tbl_item` ENABLE KEYS */;


--
-- Definition of table `tbl_order`
--

DROP TABLE IF EXISTS `tbl_order`;
CREATE TABLE `tbl_order` (
  `itemID` int(10) unsigned NOT NULL,
  `total` int(10) unsigned NOT NULL,
  `quantity` int(10) unsigned NOT NULL,
  `orderID` int(10) unsigned NOT NULL auto_increment,
  PRIMARY KEY  (`orderID`),
  KEY `FK_tbl_order_2` (`itemID`),
  CONSTRAINT `FK_tbl_order_2` FOREIGN KEY (`itemID`) REFERENCES `tbl_item` (`itemID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_order`
--

/*!40000 ALTER TABLE `tbl_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_order` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
