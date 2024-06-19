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
    ('user1', 'pwd', 'Doctor'),
    ('john_d', 'pwd', 'Patient'),
    ('drsmith', 'pwd', 'Doctor'),
    ('mary_j', 'pwd', 'Nurse'),
    ('drjones', 'pwd', 'Doctor'),
    ('alex_p', 'pwd', 'Patient'),
    ('drbrown', 'pwd', 'Doctor'),
    ('lisa_k', 'pwd', 'Nurse'),
    ('drlee', 'pwd', 'Doctor'),
    ('emma_r', 'pwd', 'Patient');

-- Insert Connections
INSERT INTO medbook_db.Connection (user1_id, user2_id, created_at) VALUES
    (101, 102, NOW()),
    (101, 103, NOW()),
    (104, 101, NOW()),
    (101, 105, NOW()),
    (103, 104, NOW()),
    (105, 106, NOW()),
    (107, 101, NOW()),
    (109, 101, NOW()),
    (102, 106, NOW()),
    (103, 106, NOW()),
    (104, 107, NOW()),
    (105, 108, NOW()),
    (106, 109, NOW()),
    (107, 110, NOW()),
    (108, 101, NOW()),
    (109, 102, NOW());


-- Insert Images
INSERT INTO medbook_db.Image (user_id, image_reference, device, bodypart, diagnosis, description, is_private, created_at) VALUES
    (101, './assets/ct1.png', 'CT', 'Lung', 'Mild Inflammation', 'CT scan of lung', 1, '2023-06-01 10:00:00'),
    (101, './assets/xray1.png', 'X-ray', 'Chest', 'Fractured Rib', 'X-ray of chest', 0, '2023-06-01 10:30:00'),
    (101, './assets/mri1.png', 'MRI', 'Brain', 'Tumor', 'MRI scan of brain', 1, '2023-06-01 11:00:00'),
    (101, './assets/ct2.png', 'CT', 'Abdomen', 'Appendicitis', 'CT scan of abdomen', 1, '2023-06-01 11:30:00'),
    (101, './assets/xray2.png', 'X-ray', 'Hand', 'Sprain', 'X-ray of hand', 0, '2023-06-01 12:00:00'),
    (101, './assets/mri2.png', 'MRI', 'Knee', 'Meniscus Tear', 'MRI scan of knee', 1, '2023-06-01 12:30:00'),
    (102, './assets/ct1.png', 'CT', 'Lung', 'Pneumonia', 'CT scan of lung', 1, '2023-06-02 09:00:00'),
    (102, './assets/xray1.png', 'X-ray', 'Chest', 'Collapsed Lung', 'X-ray of chest', 1, '2023-06-02 09:30:00'),
    (102, './assets/mri1.png', 'MRI', 'Brain', 'Aneurysm', 'MRI scan of brain', 0, '2023-06-02 10:00:00'),
    (102, './assets/ct3.png', 'CT', 'Knee', 'Arthritis', 'CT scan of knee', 0, '2023-06-02 10:30:00'),
    (102, './assets/xray3.png', 'X-ray', 'Foot', 'Fracture', 'X-ray of foot', 0, '2023-06-02 11:00:00'),
    (102, './assets/mri2.png', 'MRI', 'Knee', 'Ligament Tear', 'MRI scan of knee', 0, '2023-06-02 11:30:00'),
    (103, './assets/ct1.png', 'CT', 'Lung', 'Pulmonary Edema', 'CT scan of lung', 1, '2023-06-03 08:00:00'),
    (103, './assets/xray1.png', 'X-ray', 'Chest', 'Heart Enlargement', 'X-ray of chest', 0, '2023-06-03 08:30:00'),
    (103, './assets/mri1.png', 'MRI', 'Brain', 'Stroke', 'MRI scan of brain', 1, '2023-06-03 09:00:00'),
    (103, './assets/ct2.png', 'CT', 'Abdomen', 'Kidney Stones', 'CT scan of abdomen', 0, '2023-06-03 09:30:00'),
    (103, './assets/xray2.png', 'X-ray', 'Hand', 'Arthritis', 'X-ray of hand', 1, '2023-06-03 10:00:00'),
    (103, './assets/mri3.png', 'MRI', 'Abdomen', 'Liver Lesion', 'MRI scan of abdomen', 1, '2023-06-03 10:30:00'),
    (104, './assets/ct1.png', 'CT', 'Lung', 'Bronchitis', 'CT scan of lung', 1, '2023-06-04 11:00:00'),
    (104, './assets/xray1.png', 'X-ray', 'Chest', 'Pneumothorax', 'X-ray of chest', 0, '2023-06-04 11:30:00'),
    (104, './assets/mri1.png', 'MRI', 'Brain', 'Multiple Sclerosis', 'MRI scan of brain', 1, '2023-06-04 12:00:00'),
    (104, './assets/ct3.png', 'CT', 'Knee', 'ACL Tear', 'CT scan of knee', 1, '2023-06-04 12:30:00'),
    (104, './assets/xray2.png', 'X-ray', 'Hand', 'Dislocation', 'X-ray of hand', 0, '2023-06-04 13:00:00'),
    (104, './assets/mri2.png', 'MRI', 'Knee', 'Tendonitis', 'MRI scan of knee', 1, '2023-06-04 13:30:00'),
    (105, './assets/ct1.png', 'CT', 'Lung', 'Lung Cancer', 'CT scan of lung', 1, '2023-06-01 13:00:00'),
    (105, './assets/xray1.png', 'X-ray', 'Chest', 'Pleurisy', 'X-ray of chest', 1, '2023-06-01 13:30:00'),
    (105, './assets/mri1.png', 'MRI', 'Brain', 'Cerebral Hemorrhage', 'MRI scan of brain', 0, '2023-06-01 14:00:00'),
    (105, './assets/ct2.png', 'CT', 'Abdomen', 'Gallstones', 'CT scan of abdomen', 1, '2023-06-01 14:30:00'),
    (105, './assets/xray2.png', 'X-ray', 'Hand', 'Carpal Tunnel', 'X-ray of hand', 0, '2023-06-01 15:00:00'),
    (105, './assets/mri3.png', 'MRI', 'Abdomen', 'Pancreatitis', 'MRI scan of abdomen', 1, '2023-06-01 15:30:00'),
    (106, './assets/ct1.png', 'CT', 'Lung', 'Asthma', 'CT scan of lung', 0, '2023-06-02 12:00:00'),
    (106, './assets/xray1.png', 'X-ray', 'Chest', 'Pneumonia', 'X-ray of chest', 1, '2023-06-02 12:30:00'),
    (106, './assets/mri1.png', 'MRI', 'Brain', 'Epilepsy', 'MRI scan of brain', 0, '2023-06-02 13:00:00'),
    (106, './assets/ct2.png', 'CT', 'Abdomen', 'Hernia', 'CT scan of abdomen', 1, '2023-06-02 13:30:00'),
    (106, './assets/xray2.png', 'X-ray', 'Hand', 'Fracture', 'X-ray of hand', 0, '2023-06-02 14:00:00'),
    (106, './assets/mri3.png', 'MRI', 'Abdomen', 'Liver Disease', 'MRI scan of abdomen', 1, '2023-06-02 14:30:00'),
    (107, './assets/ct1.png', 'CT', 'Lung', 'Pulmonary Embolism', 'CT scan of lung', 1, '2023-06-03 14:00:00'),
    (107, './assets/xray1.png', 'X-ray', 'Chest', 'COPD', 'X-ray of chest', 0, '2023-06-03 14:30:00'),
    (107, './assets/mri1.png', 'MRI', 'Brain', 'Alzheimer\'s Disease', 'MRI scan of brain', 1, '2023-06-03 15:00:00'),
    (107, './assets/ct2.png', 'CT', 'Abdomen', 'Diverticulitis', 'CT scan of abdomen', 1, '2023-06-03 15:30:00'),
    (107, './assets/xray2.png', 'X-ray', 'Hand', 'Osteoporosis', 'X-ray of hand', 0, '2023-06-03 16:00:00'),
    (107, './assets/mri2.png', 'MRI', 'Knee', 'Bursitis', 'MRI scan of knee', 1, '2023-06-03 16:30:00'),
    (108, './assets/ct1.png', 'CT', 'Lung', 'Tuberculosis', 'CT scan of lung', 1, '2023-06-04 16:00:00'),
    (108, './assets/xray1.png', 'X-ray', 'Chest', 'Emphysema', 'X-ray of chest', 0, '2023-06-04 16:30:00'),
    (108, './assets/mri1.png', 'MRI', 'Brain', 'Parkinson\'s Disease', 'MRI scan of brain', 1, '2023-06-04 17:00:00'),
    (108, './assets/ct3.png', 'CT', 'Knee', 'Chondromalacia', 'CT scan of knee', 0, '2023-06-04 17:30:00'),
    (108, './assets/xray2.png', 'X-ray', 'Hand', 'Tendonitis', 'X-ray of hand', 1, '2023-06-04 18:00:00'),
    (108, './assets/mri3.png', 'MRI', 'Abdomen', 'Hepatitis', 'MRI scan of abdomen', 1, '2023-06-04 18:30:00'),
    (109, './assets/ct1.png', 'CT', 'Lung', 'Pulmonary Fibrosis', 'CT scan of lung', 0, '2023-06-01 15:00:00'),
    (109, './assets/xray1.png', 'X-ray', 'Chest', 'Pleural Effusion', 'X-ray of chest', 1, '2023-06-01 15:30:00'),
    (109, './assets/mri1.png', 'MRI', 'Brain', 'Hydrocephalus', 'MRI scan of brain', 0, '2023-06-01 16:00:00'),
    (109, './assets/ct2.png', 'CT', 'Abdomen', 'Crohn\'s Disease', 'CT scan of abdomen', 1, '2023-06-01 16:30:00'),
    (109, './assets/xray2.png', 'X-ray', 'Hand', 'Gout', 'X-ray of hand', 0, '2023-06-01 17:00:00'),
    (109, './assets/mri2.png', 'MRI', 'Knee', 'Patellar Tendonitis', 'MRI scan of knee', 1, '2023-06-01 17:30:00'),
    (110, './assets/ct1.png', 'CT', 'Lung', 'Lung Abscess', 'CT scan of lung', 1, '2023-06-02 17:00:00'),
    (110, './assets/xray1.png', 'X-ray', 'Chest', 'Cardiomegaly', 'X-ray of chest', 0, '2023-06-02 17:30:00'),
    (110, './assets/mri1.png', 'MRI', 'Brain', 'Meningitis', 'MRI scan of brain', 1, '2023-06-02 18:00:00'),
    (110, './assets/ct3.png', 'CT', 'Knee', 'Torn Meniscus', 'CT scan of knee', 0, '2023-06-02 18:30:00'),
    (110, './assets/xray2.png', 'X-ray', 'Hand', 'Rheumatoid Arthritis', 'X-ray of hand', 1, '2023-06-02 19:00:00'),
    (110, './assets/mri3.png', 'MRI', 'Abdomen', 'Fatty Liver Disease', 'MRI scan of abdomen', 1, '2023-06-02 19:30:00');


-- Drop user if exists and create a new one
DROP USER IF EXISTS 'app_user'@'localhost';
CREATE USER 'app_user'@'localhost' IDENTIFIED BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE ON medbook_db.* TO 'app_user'@'localhost';
FLUSH PRIVILEGES;

-- Verify the data
SELECT * FROM medbook_db.User;
SELECT * FROM medbook_db.Connection;
SELECT * FROM medbook_db.Image;