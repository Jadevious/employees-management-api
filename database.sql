CREATE DATABASE IF NOT EXISTS groupc_kainos_recruitment_JenniferC;
USE groupc_kainos_recruitment_JenniferC;

CREATE TABLE IF NOT EXISTS job_roles (
id smallint PRIMARY KEY AUTO_INCREMENT,
name varchar(50),
job_description varchar(500),
band_id smallint NOT NULL,
FOREIGN KEY (band_id) REFERENCES band_levels(band_id)
);

CREATE TABLE IF NOT EXISTS bands (
id smallint PRIMARY KEY AUTO_INCREMENT,
name varchar(25)
);

-- Engineering Capability
INSERT INTO job_roles (name, job_description, band_id) VALUES ('Software Engineer', 'You will work on projects where you can make a real difference to people’s lives – the lives of people you know. Undertake extensive training to set you off on the right foot, you will quickly work as a part of a team in developing solutions within our real projects and learn all about our development languages, projects and technologies. You will be fully supported by experienced colleagues in the team, as well as an experienced mentor, who will provide training and mentoring throughout your studies.', 1);
INSERT INTO job_roles (name, job_description, band_id) VALUES ('Test Engineer', 'You will work within a multi-skilled agile team, developing and executing functional, automated and manual tests to help the team deliver working application software that meets users needs. You’ll do this whilst learning about new technologies and approaches, with talented colleagues who will help you learn, develop and grow.', 2);
INSERT INTO job_roles (name, job_description, band_id) VALUES ('Support Technician','As a Support Technician in Kainos, you’ll be responsible for analysing and solving complicated technical issues. You will adhere to ITIL standards and will participate fully in the Incident Management Lifecycle. You will work closely with clients, internal teams and 3rd Party Vendors to ensure that problems are resolved. You’ll do this whilst learning about new approaches, with talented colleagues that will help you to learn, develop and grow.', 3);
INSERT INTO job_roles (name, job_description, band_id) VALUES ('Solution Architect',"You’ll be accountable for successful delivery of large-scale high-quality solution, which delight our customers and impact the lives of users worldwide. You will provide assurance and support to multi-skilled agile teams by understanding the outcomes the solution is trying to achieve, the technical implications and complexity surrounding you and your teams designs and help teams make the right decisions.", 6);

 -- People Capability
INSERT INTO job_roles (name, job_description) VALUES ('People Support Consultant', 'You will provide an excellent service across all Business Units in Kainos, globally ensuring legislative guidance is adhered to and high standards are met and maintained in all people related processes. You may be a generalist or a specialist with a continuous improvement and efficiency mindset, working with internal and external stakeholders. You will lead on a number of key people projects to maximise the value of the People Support function and support the delivery of the People Strategy.', 5);

 -- Business Development and Marketing Capability
INSERT INTO job_roles (name, job_description) VALUES ('Business Development Manager', 'You will be responsible for delivering the business development strategy by leading and generating activity in your sector/region and building an extensive network of industry contacts.  You will be accountable for building relevant stakeholder relationships with customers and industry partners to ensure cross-selling opportunities are maximised. You will be working collaboratively with other members of the Business Development team as well as colleagues from other areas of the business.', 6);
INSERT INTO job_roles (name, job_description) VALUES ('Customer Success Manager','You will be responsible for leading and managing a team to achieve regional OKRs, such as client retention and customer satisfaction targets, as set by the BU Leadership. In addition to team management, the Customer Success Manager will be responsible for managing a small number of strategic clients for the region. You will be the bridge between our Professional Services, Operational Support, Product and Business Development teams.', 6);

 -- Workday Capability
INSERT INTO job_roles (name, job_description) VALUES ('HCM Solution Architect','You’ll be fully accountable for the quality of how we deliver Workday deployments across your capability or capabilities. You’ll use your expertise to engage directly on high profile projects, to handle any significant functional challenges, and will be an important senior liaison and escalation for our clients.', 7);
INSERT INTO job_roles (name, job_description) VALUES ('Financials Consultant','You’ll work in a team to implement and configure enterprise-scale Workday solutions for our global customer base, typically leading a project work-stream. You will build relationships with our customers, shaping and delivering solutions that are aligned to customer needs, fit for purpose and commercially viable. You’ll provide excellent guidance to customers, understanding their business and requirements. You’ll support more junior members of the team and share your knowledge with them.', 4);
INSERT INTO job_roles (name, job_description) VALUES ('Data Consultants','You’ll work as part of a team to support the implementation and configuration of enterprise-scale Workday solutions for our global customer base, focusing on checking, validating and transforming the customer’s organizational and employee data, and organizing it prior to loading in to the Workday tenants. You will work cooperatively with team members to understand customer requirements around the area of data, and with the guidance from senior consultants, deliver solutions that are aligned to customer needs.', 5);

-- Band Levels/Management Levels
INSERT INTO bands(name) VALUES ("Apprentice");
INSERT INTO bands(name) VALUES ("Trainee");
INSERT INTO bands(name) VALUES ("Associate");
INSERT INTO bands(name) VALUES ("Senior Associate");
INSERT INTO bands(name) VALUES ("Consultant");
INSERT INTO bands(name) VALUES ("Manager");
INSERT INTO bands(name) VALUES ("Principal");
INSERT INTO bands(name) VALUES ("Leadership Community");
