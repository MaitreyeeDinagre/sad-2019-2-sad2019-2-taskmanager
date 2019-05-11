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

DROP TABLE IF EXISTS `users`;
CREATE TABLE `taskmanager`.`users` (
  `id` BIGINT(11) NOT NULL,
  `name` VARCHAR(50) NULL DEFAULT NULL,
  `password` VARCHAR(100) NULL DEFAULT NULL,
  `username` VARCHAR(50) NULL,
  `employeeId` INT(11) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  INDEX `employeeId_idx` (`employeeId` ASC),
  CONSTRAINT `employeeId`
    FOREIGN KEY (`employeeId`)
    REFERENCES `taskmanager`.`employee` (`employeeid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/* **************************Inserting Prepopulated Values**************************** */

/* Inserting Initiative Values */
INSERT INTO `taskmanager`.`tasktype` (`tasktypeid`, `tasktypename`, `tasktypedescription`) VALUES ('1', 'Design', 'Design Phase for Development');
INSERT INTO `taskmanager`.`tasktype` (`tasktypeid`, `tasktypename`, `tasktypedescription`) VALUES ('2', 'Development', 'Development Phase for the Task or Process');
INSERT INTO `taskmanager`.`tasktype` (`tasktypeid`, `tasktypename`, `tasktypedescription`) VALUES ('3', 'UnitTesting', 'Unit Testing for the Developed Component');
INSERT INTO `taskmanager`.`tasktype` (`tasktypeid`, `tasktypename`, `tasktypedescription`) VALUES ('4', 'Review', 'Review Phase Includes: Development Review, Testing Review and Design Review');
INSERT INTO `taskmanager`.`tasktype` (`tasktypeid`, `tasktypename`, `tasktypedescription`) VALUES ('5', 'Deployment', 'Deployment into different Environments and Orgs');
INSERT INTO `taskmanager`.`tasktype` (`tasktypeid`, `tasktypename`, `tasktypedescription`) VALUES ('6', 'QualityAnalysis', 'Quality Analysis of Development, Testing and Deployment');
INSERT INTO `taskmanager`.`tasktype` (`tasktypeid`, `tasktypename`, `tasktypedescription`) VALUES ('7', 'SmokeTesting', 'Testing the Deployed Components in the Target Environment');
INSERT INTO `taskmanager`.`tasktype` (`tasktypeid`, `tasktypename`, `tasktypedescription`) VALUES ('8', 'IntegrationTesting', 'Testing the Integration of Multiple Deployments');
INSERT INTO `taskmanager`.`tasktype` (`tasktypeid`, `tasktypename`, `tasktypedescription`) VALUES ('9', 'DataMigration', 'Movement of Data from Source Environment to Target Orgs');
INSERT INTO `taskmanager`.`tasktype` (`tasktypeid`, `tasktypename`, `tasktypedescription`) VALUES ('10', 'Release', 'Release of Inititive or Product');

/* Inserting Employee Profile Values */
INSERT INTO `taskmanager`.`employeeprofile` (`employeeprofileid`, `employeeprofilename`, `employeeprofiledescription`) VALUES ('1', 'Senior Consultant', 'Architects and Managers');
INSERT INTO `taskmanager`.`employeeprofile` (`employeeprofileid`, `employeeprofilename`, `employeeprofiledescription`) VALUES ('2', 'Junior Consultant', 'Developers and Testers');

/* Inserting Employee Role Values */
INSERT INTO `taskmanager`.`employeerole` (`employeeroleid`, `employeerolename`, `employeeroledescription`) VALUES ('1', 'Manager', 'Manager');
INSERT INTO `taskmanager`.`employeerole` (`employeeroleid`, `employeerolename`, `employeeroledescription`) VALUES ('2', 'Consultant', 'Consultant');
INSERT INTO `taskmanager`.`employeerole` (`employeeroleid`, `employeerolename`, `employeeroledescription`) VALUES ('3', 'Developer', 'Developer');
INSERT INTO `taskmanager`.`employeerole` (`employeeroleid`, `employeerolename`, `employeeroledescription`) VALUES ('4', 'Tester', 'Tester');
INSERT INTO `taskmanager`.`employeerole` (`employeeroleid`, `employeerolename`, `employeeroledescription`) VALUES ('5', 'Architect', 'Architect');

/* Inserting Status Values */
INSERT INTO `taskmanager`.`status` (`statusid`, `statusname`, `statusdescription`) VALUES ('1', 'Started', 'Started Process');
INSERT INTO `taskmanager`.`status` (`statusid`, `statusname`, `statusdescription`) VALUES ('2', 'InProgress', 'Process in Progress');
INSERT INTO `taskmanager`.`status` (`statusid`, `statusname`, `statusdescription`) VALUES ('3', 'Completed', 'Process Completed');
INSERT INTO `taskmanager`.`status` (`statusid`, `statusname`, `statusdescription`) VALUES ('4', 'Rejected', 'Process Rejected');
INSERT INTO `taskmanager`.`status` (`statusid`, `statusname`, `statusdescription`) VALUES ('5', 'NotStarted', 'Process Not Started Yet');

/* Inserting Employee Values */
INSERT INTO `taskmanager`.`employee` (`employeeid`, `employeename`, `employeedetails`, `employeeprofile`, `employeerole`, `employeeinitiative`) VALUES ('1', 'Kosko', 'Male', '1', '1', '1');
INSERT INTO `taskmanager`.`employee` (`employeeid`, `employeename`, `employeedetails`, `employeeprofile`, `employeerole`, `employeeinitiative`) VALUES ('2', 'Mubeen', 'Male', '1', '2', '2');
INSERT INTO `taskmanager`.`employee` (`employeeid`, `employeename`, `employeedetails`, `employeeprofile`, `employeerole`, `employeeinitiative`) VALUES ('3', 'Sunny', 'Male', '2', '2', '1');
INSERT INTO `taskmanager`.`employee` (`employeeid`, `employeename`, `employeedetails`, `employeeprofile`, `employeerole`, `employeeinitiative`) VALUES ('4', 'Arpitha', 'Female', '2', '2', '3');
INSERT INTO `taskmanager`.`employee` (`employeeid`, `employeename`, `employeedetails`, `employeeprofile`, `employeerole`, `employeeinitiative`) VALUES ('5', 'Maitreyee', 'Female', '2', '1', '2');
INSERT INTO `taskmanager`.`employee` (`employeeid`, `employeename`, `employeedetails`, `employeeprofile`, `employeerole`, `employeeinitiative`) VALUES ('6', 'Neveditha', 'Female', '1', '3', '1');
INSERT INTO `taskmanager`.`employee` (`employeeid`, `employeename`, `employeedetails`, `employeeprofile`, `employeerole`, `employeeinitiative`) VALUES ('7', 'Manzil', 'Male', '2', '3', '3');

/* Inserting Epic Values */
INSERT INTO `taskmanager`.`epic` (`epicid`, `epicname`, `epicdescription`, `epicinitiative`) VALUES ('1', 'City Development', 'City Construction', '1');
INSERT INTO `taskmanager`.`epic` (`epicid`, `epicname`, `epicdescription`, `epicinitiative`) VALUES ('2', 'Weather ', 'Weather Forcast', '1');
INSERT INTO `taskmanager`.`epic` (`epicid`, `epicname`, `epicdescription`, `epicinitiative`) VALUES ('3', 'Software', 'Software Dev', '2');
INSERT INTO `taskmanager`.`epic` (`epicid`, `epicname`, `epicdescription`, `epicinitiative`) VALUES ('3', 'Dhl', 'Courier Service', '2');


/* Inserting Story Values */
INSERT INTO `taskmanager`.`story` (`storyid`, `storyname`, `isstorycurrent`, `storyassignedto`, `storystatus`) VALUES ('1', 'Collection of Elements', '1', '1', '2');
INSERT INTO `taskmanager`.`story` (`storyid`, `storyname`, `isstorycurrent`, `storyassignedto`, `storystatus`) VALUES ('2', 'Date/Day', '0', '4', '5');
INSERT INTO `taskmanager`.`story` (`storyid`, `storyname`, `isstorycurrent`, `storyassignedto`, `storystatus`) VALUES ('3', 'Design', '1', '6', '3');
INSERT INTO `taskmanager`.`story` (`storyid`, `storyname`, `isstorycurrent`, `storyassignedto`, `storystatus`) VALUES ('4', 'Get Location', '1', '3', '4');
INSERT INTO `taskmanager`.`story` (`storyid`, `storyname`, `isstorycurrent`, `storyassignedto`, `storystatus`) VALUES ('5', 'Testing', '0', '3', '1');

/* Inserting task Values */
INSERT INTO `taskmanager`.`task` (`taskid`, `taskname`, `taskdescription`, `taskestimatedtime`, `taskactualtime`, `taskassignedto`, `taskstatus`) VALUES ('1', 'Roads', 'Roads Dev', '2', '1', '3', '1');
INSERT INTO `taskmanager`.`task` (`taskid`, `taskname`, `taskdescription`, `taskestimatedtime`, `taskactualtime`, `taskassignedto`, `taskstatus`) VALUES ('2', 'Parks', 'Parks Dev', '3', '2', '1', '1');
INSERT INTO `taskmanager`.`task` (`taskid`, `taskname`, `taskdescription`, `taskestimatedtime`, `taskactualtime`, `taskassignedto`, `taskstatus`) VALUES ('3', 'Implementation', 'Software Implementation', '2', '1', '2', '1');
INSERT INTO `taskmanager`.`task` (`taskid`, `taskname`, `taskdescription`, `taskestimatedtime`, `taskactualtime`, `taskassignedto`, `taskstatus`) VALUES ('4', 'Verification', 'Software Verfication', '3', '2', '3', '1');
INSERT INTO `taskmanager`.`task` (`taskid`, `taskname`, `taskdescription`, `taskestimatedtime`, `taskactualtime`, `taskassignedto`, `taskstatus`) VALUES ('5', 'Uiux', 'Design', '3', '2', '4', '1');
INSERT INTO `taskmanager`.`task` (`taskid`, `taskname`, `taskdescription`, `taskestimatedtime`, `taskactualtime`, `taskassignedto`, `taskstatus`) VALUES ('6', 'Unit Testing', 'Testing', '7', '1', '5', '1');
INSERT INTO `taskmanager`.`task` (`taskid`, `taskname`, `taskdescription`, `taskestimatedtime`, `taskactualtime`, `taskassignedto`, `taskstatus`) VALUES ('7', 'Integration Testing', 'Testing', '4', '3', '6', '1');

/* Inserting issue Values */
INSERT INTO `taskmanager`.`issue` (`issueid`, `issuename`, `issuedescription`, `issuestory`, `issuestatus`) VALUES ('1', 'collection issue', 'data cant be collected', '1', '1');
INSERT INTO `taskmanager`.`issue` (`issueid`, `issuename`, `issuedescription`, `issuestory`, `issuestatus`) VALUES ('2', 'date issue', 'not selected issue', '2', '1');
INSERT INTO `taskmanager`.`issue` (`issueid`, `issuename`, `issuedescription`, `issuestory`, `issuestatus`) VALUES ('3', 'design issue', 'design is not attractive', '3', '1');
INSERT INTO `taskmanager`.`issue` (`issueid`, `issuename`, `issuedescription`, `issuestory`, `issuestatus`) VALUES ('4', 'location issue', 'location is out of map', '4', '1');
INSERT INTO `taskmanager`.`issue` (`issueid`, `issuename`, `issuedescription`, `issuestory`, `issuestatus`) VALUES ('5', 'testing', 'djfnd', '5', '1');

/* Inserting timelog Values */
INSERT INTO `taskmanager`.`timelog` (`timelogid`, `timelogdescription`, `timelogaudit`, `timelogduration`, `timelogstory`, `timelogtask`, `timelogemployee`) VALUES ('1', 'devlopments take one months', '45', '2', '1', '1', '1');
INSERT INTO `taskmanager`.`timelog` (`timelogid`, `timelogdescription`, `timelogaudit`, `timelogduration`, `timelogstory`, `timelogtask`, `timelogemployee`) VALUES ('2', 'construction take two months', '23', '4', '2', '3', '2');
INSERT INTO `taskmanager`.`timelog` (`timelogid`, `timelogdescription`, `timelogaudit`, `timelogduration`, `timelogstory`, `timelogtask`, `timelogemployee`) VALUES ('3', 'design take 3 moths', '55', '3', '3', '6', '3');

/* Inserting epicstorytask Values */
INSERT INTO `taskmanager`.`epicstorytask` (`epicstorytaskid`, `epicstorytaskstory`, `epicstorytasktask`, `epicstorytaskepic`) VALUES ('1', '3', '4', '1');
INSERT INTO `taskmanager`.`epicstorytask` (`epicstorytaskid`, `epicstorytaskstory`, `epicstorytasktask`, `epicstorytaskepic`) VALUES ('2', '2', '3', '2');
INSERT INTO `taskmanager`.`epicstorytask` (`epicstorytaskid`, `epicstorytaskstory`, `epicstorytasktask`, `epicstorytaskepic`) VALUES ('3', '3', '4', '3');
INSERT INTO `taskmanager`.`epicstorytask` (`epicstorytaskid`, `epicstorytaskstory`, `epicstorytasktask`, `epicstorytaskepic`) VALUES ('4', '4', '2', '2');
