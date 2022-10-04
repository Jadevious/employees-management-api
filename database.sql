CREATE DATABASE IF NOT EXISTS groupc_kainos_recruitment_JenniferC;
USE groupc_kainos_recruitment_JenniferC;

CREATE TABLE IF NOT EXISTS job_roles (
id smallint PRIMARY KEY AUTO_INCREMENT,
name varchar(50) NOT NULL,
job_description varchar(500) NOT NULL,
capability varchar(50)
);
