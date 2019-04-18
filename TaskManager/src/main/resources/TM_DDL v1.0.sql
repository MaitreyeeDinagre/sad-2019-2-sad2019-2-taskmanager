CREATE DATABASE  IF NOT EXISTS `taskmanager`;
USE `taskmanager`;

/* Level 1 Tables */

DROP TABLE IF EXISTS `initiative`;
CREATE TABLE `initiative` (
  `initiativeid` int(11) NOT NULL AUTO_INCREMENT,
  `initiativename` varchar(45) NOT NULL,
  `initiativedescription` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`initiativeid`),
  UNIQUE KEY `initiativename_UNIQUE` (`initiativename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `employeeprofile`;
CREATE TABLE `employeeprofile` (
  `employeeprofileid` int(11) NOT NULL AUTO_INCREMENT,
  `employeeprofilename` varchar(45) NOT NULL,
  `employeeprofiledescription` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employeeprofileid`),
  UNIQUE KEY `employeeprofilename_UNIQUE` (`employeeprofilename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `employeerole`;
CREATE TABLE `employeerole` (
  `employeeroleid` int(11) NOT NULL AUTO_INCREMENT,
  `employeerolename` varchar(45) NOT NULL,
  `employeeroledescription` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employeeroleid`),
  UNIQUE KEY `employeerolename_UNIQUE` (`employeerolename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `tasktype`;
CREATE TABLE `tasktype` (
  `tasktypeid` int(11) NOT NULL AUTO_INCREMENT,
  `tasktypename` varchar(45) NOT NULL,
  `tasktypedescription` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tasktypeid`),
  UNIQUE KEY `tasktypename_UNIQUE` (`tasktypename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `statusid` int(11) NOT NULL AUTO_INCREMENT,
  `statusname` varchar(45) DEFAULT NULL,
  `statusdescription` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`statusid`),
  UNIQUE KEY `statusname_UNIQUE` (`statusname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/* Level 2 Tables */

DROP TABLE IF EXISTS `epic`;
CREATE TABLE `epic` (
 `epicid` int(11) NOT NULL AUTO_INCREMENT,
 `epicname` varchar(45) NOT NULL,
 `epicdescription` varchar(255) DEFAULT NULL,
 `epicinitiative` int(11),
 PRIMARY KEY (`epicid`),
 UNIQUE KEY `epicname_UNIQUE` (`epicname`),
 KEY `epicinitiative_fk_idx` (`epicinitiative`),
 CONSTRAINT `epicinitiative_fk` FOREIGN KEY (`epicinitiative`) REFERENCES `initiative` (`initiativeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `employeeid` int(11) NOT NULL AUTO_INCREMENT,
  `employeename` varchar(45) NOT NULL,
  `employeedetails` varchar(255) NOT NULL,
  `employeeprofile` int(11),
  `employeerole` int(11),
  `employeeinitiative` int(11),
  PRIMARY KEY (`employeeid`),
  UNIQUE KEY `employeename_UNIQUE` (`employeename`),
  KEY `employeeprofile_fk_idx` (`employeeprofile`),
  KEY `employeerole_fk_idx` (`employeerole`),
  KEY `employeeinitiative_fk_idx` (`employeeinitiative`),
  CONSTRAINT `employeeinitiative_fk` FOREIGN KEY (`employeeinitiative`) REFERENCES `initiative` (`initiativeid`),
  CONSTRAINT `employeeprofile_fk` FOREIGN KEY (`employeeprofile`) REFERENCES `employeeprofile` (`employeeprofileid`),
  CONSTRAINT `employeerole_fk` FOREIGN KEY (`employeerole`) REFERENCES `employeerole` (`employeeroleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/* Level 3 Tables */

DROP TABLE IF EXISTS `story`;
CREATE TABLE `story` (
  `storyid` int(11) NOT NULL AUTO_INCREMENT,
  `storyname` varchar(45) NOT NULL,
  `storyestimatedgrand` int(11) DEFAULT NULL,
  `storyactualgrand` int(11) DEFAULT NULL,
  `isstorycurrent` tinyint(4) DEFAULT NULL,
  `storyassignedto` int(11),
  `storystatus` int(11),
  PRIMARY KEY (`storyid`),
  UNIQUE KEY `storyname_UNIQUE` (`storyname`),
  KEY `storyassignedto_fk_idx` (`storyassignedto`),
  KEY `storystatus_fk_idx` (`storystatus`),
  CONSTRAINT `storyassignedto_fk` FOREIGN KEY (`storyassignedto`) REFERENCES `employee` (`employeeid`),
  CONSTRAINT `storystatus_fk` FOREIGN KEY (`storystatus`) REFERENCES `status` (`statusid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `taskid` int(11) NOT NULL AUTO_INCREMENT,
  `taskname` varchar(45) NOT NULL,
  `taskdescription` varchar(255) DEFAULT NULL,
  `taskestimatedtime` int(11) DEFAULT NULL,
  `taskactualtime` int(11) DEFAULT NULL,
  `taskassignedto` int(11),
  `taskstatus` int(11),
  PRIMARY KEY (`taskid`),
  UNIQUE KEY `taskname_UNIQUE` (`taskname`),
  KEY `taskassignedto_fk_idx` (`taskassignedto`),
  KEY `taskstatus_fk_idx` (`taskstatus`),
  CONSTRAINT `taskassignedto_fk` FOREIGN KEY (`taskassignedto`) REFERENCES `employee` (`employeeid`),
  CONSTRAINT `taskstatus_fk` FOREIGN KEY (`taskstatus`) REFERENCES `status` (`statusid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/* Level 4 Tables */

DROP TABLE IF EXISTS `issue`;
CREATE TABLE `issue` (
  `issueid` int(11) NOT NULL AUTO_INCREMENT,
  `issuename` varchar(45) NOT NULL,
  `issuedescription` varchar(255) DEFAULT NULL,
  `issuestory` int(11),
  `issuestatus` int(11),
  PRIMARY KEY (`issueid`),
  UNIQUE KEY `issuename_UNIQUE` (`issuename`),
  KEY `issuestory_fk_idx` (`issuestory`),
  KEY `issuestatus_fk_idx` (`issuestatus`),
  CONSTRAINT `issuestatus_fk` FOREIGN KEY (`issuestatus`) REFERENCES `status` (`statusid`),
  CONSTRAINT `issuestory_fk` FOREIGN KEY (`issuestory`) REFERENCES `story` (`storyid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `timelog`;
CREATE TABLE `timelog` (
  `timelogid` int(11) NOT NULL AUTO_INCREMENT,
  `timelogdescription` varchar(45) NOT NULL,
  `timelogaudit` varchar(45) NOT NULL,
  `timelogduration` int(11) NOT NULL,
  `timelogstory` int(11) NOT NULL,
  `timelogtask` int(11) NOT NULL,
  `timelogemployee` int(11) NOT NULL,
  PRIMARY KEY (`timelogid`),
  UNIQUE KEY `timelogaudit_UNIQUE` (`timelogaudit`),
  UNIQUE KEY `timelogdescription_UNIQUE` (`timelogdescription`),
  KEY `timelogstory_fk_idx` (`timelogstory`),
  KEY `timelogtask_fk_idx` (`timelogtask`),
  KEY `timelogemployee_fk_idx` (`timelogemployee`),
  CONSTRAINT `timelogemployee_fk` FOREIGN KEY (`timelogemployee`) REFERENCES `employee` (`employeeid`),
  CONSTRAINT `timelogstory_fk` FOREIGN KEY (`timelogstory`) REFERENCES `story` (`storyid`),
  CONSTRAINT `timelogtask_fk` FOREIGN KEY (`timelogtask`) REFERENCES `task` (`taskid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `storytask`;
CREATE TABLE `storytask` (
  `storytaskid` int(11) NOT NULL AUTO_INCREMENT,
  `storytaskstory` int(11) NOT NULL,
  `storytasktask` int(11) NOT NULL,
  PRIMARY KEY (`storytaskid`),
  KEY `storytaskstory_fk_idx` (`storytaskstory`),
  KEY `storytasktask_fk_idx` (`storytasktask`),
  CONSTRAINT `storytaskstory_fk` FOREIGN KEY (`storytaskstory`) REFERENCES `story` (`storyid`),
  CONSTRAINT `storytasktask_fk` FOREIGN KEY (`storytasktask`) REFERENCES `task` (`taskid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;