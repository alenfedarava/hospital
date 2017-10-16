SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema hospital
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hospital
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS myhospital DEFAULT CHARACTER SET utf8 ;
USE myhospital ;

-- -----------------------------------------------------
-- Table Administration
-- -----------------------------------------------------
DROP TABLE IF EXISTS Administration ;

CREATE TABLE IF NOT EXISTS Administration (
  ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
  salaryRate INT NOT NULL,
  personalRoom TINYINT NOT NULL,
  ChiefAccountant_ID INT UNSIGNED NOT NULL,
  ChiefMedical_ID INT UNSIGNED NOT NULL,
  PRIMARY KEY (ID, ChiefAccountant_ID, ChiefMedical_ID),
  UNIQUE INDEX idAdministration_UNIQUE (ID ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Medical
-- -----------------------------------------------------
DROP TABLE IF EXISTS Medical ;

CREATE TABLE IF NOT EXISTS Medical (
  ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
  specialization TINYINT NOT NULL,
  nightShift TINYINT NOT NULL,
  medicalExp INT NOT NULL,
  GeneralPractice_ID INT UNSIGNED NOT NULL,
  PRIMARY KEY (ID, GeneralPractice_ID),
  UNIQUE INDEX idMedical_UNIQUE (ID ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Address
-- -----------------------------------------------------
DROP TABLE IF EXISTS Address ;

CREATE TABLE IF NOT EXISTS Address (
  ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
  street VARCHAR(45) NOT NULL,
  houseNumber INT NOT NULL,
  phone VARCHAR(45) NOT NULL,
  cities VARCHAR(45) NOT NULL,
  PRIMARY KEY (ID),
  UNIQUE INDEX idAddress_UNIQUE (ID ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table HospitalStaff
-- -----------------------------------------------------
DROP TABLE IF EXISTS HospitalStaff ;

CREATE TABLE IF NOT EXISTS HospitalStaff (
  ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
  FirstName VARCHAR(45) NOT NULL,
  LastName VARCHAR(45) NOT NULL,
  age INT NOT NULL,
  jobTitle VARCHAR(45) NOT NULL,
  address INT NOT NULL,
  dateBirth DATETIME NOT NULL,
  CREATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  MODIFIED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  Medical_ID INT UNSIGNED NOT NULL,
  GeneralPractice_ID INT UNSIGNED NOT NULL,
  Address_ID INT UNSIGNED NOT NULL,
  Administration_ID INT UNSIGNED NOT NULL,
  ChiefAccountant_ID INT UNSIGNED NOT NULL,
  ChiefMedical_ID INT UNSIGNED NOT NULL,
  PRIMARY KEY (ID),
  INDEX fk_HospitalStaff_Administration1_idx (Administration_ID ASC, ChiefAccountant_ID ASC, ChiefMedical_ID ASC),
  INDEX fk_HospitalStaff_Medical1_idx (Medical_ID ASC, GeneralPractice_ID ASC),
  UNIQUE INDEX idHospitalStaff_UNIQUE (ID ASC),
  INDEX fk_HospitalStaff_Address1_idx (Address_ID ASC),
  CONSTRAINT fk_HospitalStaff_Administration1
    FOREIGN KEY (Administration_ID , ChiefAccountant_ID , ChiefMedical_ID)
    REFERENCES Administration (ID , ChiefAccountant_ID , ChiefMedical_ID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_HospitalStaff_Medical1
    FOREIGN KEY (Medical_ID , GeneralPractice_ID)
    REFERENCES Medical (ID , GeneralPractice_ID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_HospitalStaff_Address1
    FOREIGN KEY (Address_ID)
    REFERENCES Address (ID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Support
-- -----------------------------------------------------
DROP TABLE IF EXISTS Support ;

CREATE TABLE IF NOT EXISTS Support (
  ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
  relatedEducation TINYINT(1) NOT NULL,
  privileges TINYINT(1) NOT NULL,
  HospitalStaff_ID INT UNSIGNED NOT NULL,
  PRIMARY KEY (ID),
  UNIQUE INDEX idSupport_UNIQUE (ID ASC),
  INDEX fk_Support_HospitalStaff1_idx (HospitalStaff_ID ASC),
  CONSTRAINT fk_Support_HospitalStaff1
    FOREIGN KEY (HospitalStaff_ID)
    REFERENCES HospitalStaff (ID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table ChiefAccountant
-- -----------------------------------------------------
DROP TABLE IF EXISTS ChiefAccountant ;

CREATE TABLE IF NOT EXISTS ChiefAccountant (
  ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
  economicEducation TINYINT NOT NULL,
  Administration_ID INT UNSIGNED NOT NULL,
  ChiefAccountant_ID INT UNSIGNED NOT NULL,
  ChiefMedical_ID INT UNSIGNED NOT NULL,
  PRIMARY KEY (ID),
  INDEX fk_ChiefAccountant_Administration1_idx (Administration_ID ASC, ChiefAccountant_ID ASC, ChiefMedical_ID ASC),
  UNIQUE INDEX idChiefAccountant_UNIQUE (ID ASC),
  CONSTRAINT fk_ChiefAccountant_Administration1
    FOREIGN KEY (Administration_ID , ChiefAccountant_ID , ChiefMedical_ID)
    REFERENCES Administration (ID , ChiefAccountant_ID , ChiefMedical_ID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table ChiefMedical
-- -----------------------------------------------------
DROP TABLE IF EXISTS ChiefMedical ;

CREATE TABLE IF NOT EXISTS ChiefMedical (
  ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
  phD TINYINT(1) NOT NULL,
  awards VARCHAR(45) NOT NULL,
  Administration_ID INT UNSIGNED NOT NULL,
  ChiefAccountant_ID INT UNSIGNED NOT NULL,
  ChiefMedical_ID INT UNSIGNED NOT NULL,
  PRIMARY KEY (ID),
  INDEX fk_ChiefMedical_Administration1_idx (Administration_ID ASC, ChiefAccountant_ID ASC, ChiefMedical_ID ASC),
  UNIQUE INDEX idChiefMedical_UNIQUE (ID ASC),
  CONSTRAINT fk_ChiefMedical_Administration1
    FOREIGN KEY (Administration_ID , ChiefAccountant_ID , ChiefMedical_ID)
    REFERENCES Administration (ID , ChiefAccountant_ID , ChiefMedical_ID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table GeneralPractice
-- -----------------------------------------------------
DROP TABLE IF EXISTS GeneralPractice ;

CREATE TABLE IF NOT EXISTS GeneralPractice (
  ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
  surgicalPractice TINYINT(1) NOT NULL,
  Medical_ID INT UNSIGNED NOT NULL,
  GeneralPractice_ID INT UNSIGNED NOT NULL,
  PRIMARY KEY (ID),
  INDEX fk_GeneralPractice_Medical1_idx (Medical_ID ASC, GeneralPractice_ID ASC),
  UNIQUE INDEX idGeneralPractice_UNIQUE (ID ASC),
  CONSTRAINT fk_GeneralPractice_Medical1
    FOREIGN KEY (Medical_ID , GeneralPractice_ID)
    REFERENCES Medical (ID , GeneralPractice_ID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Driver
-- -----------------------------------------------------
DROP TABLE IF EXISTS Driver ;

CREATE TABLE IF NOT EXISTS Driver (
  ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
  drivingExp TINYINT(1) NOT NULL,
  Support_ID INT UNSIGNED NOT NULL,
  PRIMARY KEY (ID),
  UNIQUE INDEX idDriver_UNIQUE (ID ASC),
  INDEX fk_Driver_Support1_idx (Support_ID ASC),
  CONSTRAINT fk_Driver_Support1
    FOREIGN KEY (Support_ID)
    REFERENCES Support (ID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Janitor
-- -----------------------------------------------------
DROP TABLE IF EXISTS Janitor ;

CREATE TABLE IF NOT EXISTS Janitor (
  ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
  useInstruments TINYINT(1) NOT NULL,
  Support_ID INT UNSIGNED NOT NULL,
  PRIMARY KEY (ID),
  UNIQUE INDEX idJanitor_UNIQUE (ID ASC),
  INDEX fk_Janitor_Support1_idx (Support_ID ASC),
  CONSTRAINT fk_Janitor_Support1
    FOREIGN KEY (Support_ID)
    REFERENCES Support (ID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
