CREATE DATABASE IF NOT EXISTS groupc_kainos_recruitment_JadeN;
USE groupc_kainos_recruitment_JadeN;

CREATE TABLE IF NOT EXISTS job_roles (
id smallint PRIMARY KEY AUTO_INCREMENT,
name varchar(50),
job_description varchar(500)
);

INSERT INTO job_roles (name, job_description) VALUES ('Software Engineer', 'Develops code on behalf of Kainos')
INSERT INTO job_roles (name, job_description) VALUES ('QA Engineer', 'Tests code on behalf of Kainos')