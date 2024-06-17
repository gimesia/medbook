-- Drop existing tables if they exist
DROP TABLE IF EXISTS medbook_db.Connection;
DROP TABLE IF EXISTS medbook_db.Image;
DROP TABLE IF EXISTS medbook_db.User;

-- Recreate the schema and tables
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS medbook_db DEFAULT CHARACTER SET utf8;
USE medbook_db;

CREATE TABLE IF NOT EXISTS medbook_db.User (
                                               user_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                               username VARCHAR(45) NOT NULL,
    password_hash VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    role VARCHAR(45) BINARY NOT NULL,
    PRIMARY KEY (user_id),
    UNIQUE INDEX username_UNIQUE (username ASC)
    ) ENGINE = InnoDB AUTO_INCREMENT = 101;

CREATE TABLE IF NOT EXISTS medbook_db.Connection (
                                                     connection_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                     user1_id INT UNSIGNED NOT NULL,
                                                     user2_id INT UNSIGNED NOT NULL,
                                                     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                                     PRIMARY KEY (connection_id),
    INDEX user1_id_IDX (user1_id ASC),
    INDEX user2_id_IDX (user2_id ASC),
    CONSTRAINT fk_user1_id
    FOREIGN KEY (user1_id)
    REFERENCES medbook_db.User (user_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT fk_user2_id
    FOREIGN KEY (user2_id)
    REFERENCES medbook_db.User (user_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    ) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS medbook_db.Image (
                                                image_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                user_id INT UNSIGNED NOT NULL,
                                                image_reference VARCHAR(200) NOT NULL,
    device VARCHAR(45) NOT NULL,
    bodypart VARCHAR(45) NOT NULL,
    diagnosis VARCHAR(45),
    description VARCHAR(200),
    is_private TINYINT(1) UNSIGNED NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (image_id),
    INDEX user_id_IDX (user_id ASC),
    CONSTRAINT fk_image_user_id
    FOREIGN KEY (user_id)
    REFERENCES medbook_db.User (user_id)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
    ) ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;

INSERT INTO medbook_db.User (username, password_hash, role) VALUES
                                                                ('user1', 'pwd', 'MD'),
                                                                ('user2', 'pwd', 'Patient'),
                                                                ('user3', 'pwd', 'MD'),
                                                                ('user4', 'pwd', 'Patient'),
                                                                ('user5', 'pwd', 'MD'),
                                                                ('user6', 'pwd', 'Patient'),
                                                                ('user7', 'pwd', 'MD'),
                                                                ('user8', 'pwd', 'Patient'),
                                                                ('user9', 'pwd', 'MD'),
                                                                ('user10', 'pwd', 'Patient');


-- Insert Connections
INSERT INTO medbook_db.Connection (user1_id, user2_id, created_at) VALUES
                                                                       (101, 102, NOW()),
                                                                       (101, 103, NOW()),
                                                                       (104, 101, NOW()),
                                                                       (101, 105, NOW()),
                                                                       (103, 104, NOW()),
                                                                       (105, 106, NOW()),
                                                                       (107, 101, NOW()),
                                                                       (109, 101, NOW());


-- Insert Images
INSERT INTO medbook_db.Image (user_id, image_reference, device, bodypart, diagnosis, description, is_private, created_at) VALUES
                                                                                                                              (101, './assets/ct1.png', 'CT', 'Head', 'Normal', 'CT scan of head', 1, NOW()),
                                                                                                                              (101, './assets/ct2.png', 'CT', 'Head', 'Normal', 'CT scan of head', 1, NOW()),
                                                                                                                              (102, './assets/xray1.png', 'X-ray', 'Chest', 'Normal', 'X-ray of chest', 1, NOW()),
                                                                                                                              (102, './assets/xray2.png', 'X-ray', 'Chest', 'Normal', 'X-ray of chest', 1, NOW()),
                                                                                                                              (103, './assets/mri1.png', 'MRI', 'Brain', 'Normal', 'MRI scan of brain', 1, NOW()),
                                                                                                                              (103, './assets/mri2.png', 'MRI', 'Brain', 'Normal', 'MRI scan of brain', 1, NOW()),
                                                                                                                              (104, './assets/ct1.png', 'CT', 'Abdomen', 'Normal', 'CT scan of abdomen', 1, NOW()),
                                                                                                                              (104, './assets/ct2.png', 'CT', 'Abdomen', 'Normal', 'CT scan of abdomen', 1, NOW()),
                                                                                                                              (105, './assets/xray1.png', 'X-ray', 'Leg', 'Normal', 'X-ray of leg', 1, NOW()),
                                                                                                                              (105, './assets/xray2.png', 'X-ray', 'Leg', 'Normal', 'X-ray of leg', 1, NOW()),
                                                                                                                              (106, './assets/mri1.png', 'MRI', 'Spine', 'Normal', 'MRI scan of spine', 1, NOW()),
                                                                                                                              (106, './assets/mri2.png', 'MRI', 'Spine', 'Normal', 'MRI scan of spine', 1, NOW()),
                                                                                                                              (107, './assets/ct1.png', 'CT', 'Chest', 'Normal', 'CT scan of chest', 1, NOW()),
                                                                                                                              (107, './assets/ct2.png', 'CT', 'Chest', 'Normal', 'CT scan of chest', 1, NOW()),
                                                                                                                              (108, './assets/xray1.png', 'X-ray', 'Arm', 'Normal', 'X-ray of arm', 1, NOW()),
                                                                                                                              (108, './assets/xray2.png', 'X-ray', 'Arm', 'Normal', 'X-ray of arm', 1, NOW()),
                                                                                                                              (109, './assets/mri1.png', 'MRI', 'Knee', 'Normal', 'MRI scan of knee', 1, NOW()),
                                                                                                                              (109, './assets/mri2.png', 'MRI', 'Knee', 'Normal', 'MRI scan of knee', 1, NOW()),
                                                                                                                              (110, './assets/ct1.png', 'CT', 'Pelvis', 'Normal', 'CT scan of pelvis', 1, NOW()),
                                                                                                                              (110, './assets/ct2.png', 'CT', 'Pelvis', 'Normal', 'CT scan of pelvis', 1, NOW());

-- Drop user if exists and create a new one
DROP USER IF EXISTS 'app_user'@'localhost';
CREATE USER 'app_user'@'localhost' IDENTIFIED BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE ON medbook_db.* TO 'app_user'@'localhost';
FLUSH PRIVILEGES;

-- Verify the data
SELECT * FROM medbook_db.User;
SELECT * FROM medbook_db.Connection;
SELECT * FROM medbook_db.Image;