CREATE DATABASE IF NOT EXISTS groupc_kainos_recruitment_JenniferC;
USE groupc_kainos_recruitment_JenniferC;

CREATE TABLE IF NOT EXISTS capabilities (
id smallint PRIMARY KEY AUTO_INCREMENT,
name enum ('Engineering', 'Platforms', 'Data', 'Artificial Intelligence',
'Cyber Security', 'Workday', 'Experience Design', 'Product', 'Delivery', 'Operations',
'Business Development and Marketing', 'Organisational Strategy and Planning',
 'People', 'Commercial and Financial Management', 'Business Services Support') NOT NULL
);

CREATE TABLE IF NOT EXISTS bands (
id smallint PRIMARY KEY AUTO_INCREMENT,
name enum('Apprentice', 'Trainee', 'Associate', 'Senior Associate', 'Consultant', 'Manager', 'Principal', 'Leadership Community') NOT NULL
);

CREATE TABLE IF NOT EXISTS job_roles (
id smallint PRIMARY KEY AUTO_INCREMENT,
name varchar(50) NOT NULL,
description varchar(500) NOT NULL,
specification varchar(255) NOT NULL,
responsibilities varchar(500),
capability smallint NOT NULL,
band_id smallint NOT NULL,
FOREIGN KEY (capability) REFERENCES capabilities(id),
FOREIGN KEY (band_id) REFERENCES bands(id)
);

-- Capabilities
INSERT INTO capabilities (name) VALUES ('Engineering');
INSERT INTO capabilities (name) VALUES ('Platforms');
INSERT INTO capabilities (name) VALUES ('Data');
INSERT INTO capabilities (name) VALUES ('Artificial Intelligence');
INSERT INTO capabilities (name) VALUES ('Cyber Security');
INSERT INTO capabilities (name) VALUES ('Workday');
INSERT INTO capabilities (name) VALUES ('Experience Design');
INSERT INTO capabilities (name) VALUES ('Product');
INSERT INTO capabilities (name) VALUES ('Delivery');
INSERT INTO capabilities (name) VALUES ('Operations');
INSERT INTO capabilities (name) VALUES ('Business Development and Marketing');
INSERT INTO capabilities (name) VALUES ('Organisational Strategy and Planning');
INSERT INTO capabilities (name) VALUES ('People');
INSERT INTO capabilities (name) VALUES ('Commercial and Financial Management');
INSERT INTO capabilities (name) VALUES ('Business Services Support');

-- Band Levels/Management Levels
INSERT INTO bands (name) VALUES ('Apprentice');
INSERT INTO bands (name) VALUES ('Trainee');
INSERT INTO bands (name) VALUES ('Associate');
INSERT INTO bands (name) VALUES ('Senior Associate');
INSERT INTO bands (name) VALUES ('Consultant');
INSERT INTO bands (name) VALUES ('Manager');
INSERT INTO bands (name) VALUES ('Principal');
INSERT INTO bands (name) VALUES ('Leadership Community');

-- Engineering Capability
INSERT INTO job_roles (name, description, specification, responsibilities, capability, band_id)
VALUES (
        'Software Engineer',
        'You will work on projects where you can make a real difference to people’s lives – the lives of people you know. Undertake extensive training to set you off on the right foot, you will quickly work as a part of a team in developing solutions within our real projects and learn all about our development languages, projects and technologies. You will be fully supported by experienced colleagues in the team, as well as an experienced mentor, who will provide training and mentoring throughout your studies.',
        'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EbTM1UOLa0VBvOttkOL3ZNoB0sMjehxvkAaNQEj2dqKMbA?e=iXpeUf',
        'As an Apprentice Software Engineer with Kainos, you will work on projects where you can make a real difference to people’s lives – the lives of people you know. extensive training to set you off on the right foot, you will quickly work as a part of a team in developing solutions within our real projects, learning all about our development languages, projects and technologies. You will be fully supported by experienced colleagues in the team as well as an experienced mentor, who will provide trai',
        1,
        1);

INSERT INTO job_roles (name, description, specification, responsibilities, capability, band_id)
VALUES (
        'Test Engineer',
        'You will work within a multi-skilled agile team, developing and executing functional, automated and manual tests to help the team deliver working application software that meets users needs. You’ll do this whilst learning about new technologies and approaches, with talented colleagues who will help you learn, develop and grow.',
        'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EcGbc8drFRlBoh2H2BZSeVwBV1tAiDCTwirdTmrz2EYYmQ?e=XMqXJh',
        'As a Test Engineer (Trainee) in Kainos, you’ll work within a multi-skilled agile team, developing and executing functional automated and manual tests to help the team deliver working application software that meets user needs. You’ll do this whilst learning about new technologies and approaches, with talented colleagues who will help you learn, develop and grow.',
        1,
        2);

INSERT INTO job_roles (name, description, specification, responsibilities, capability, band_id)
VALUES (
        'Support Technician',
        'As a Support Technician in Kainos, you’ll be responsible for analysing and solving complicated technical issues. You will adhere to ITIL standards and will participate fully in the Incident Management Lifecycle. You will work closely with clients, internal teams and 3rd Party Vendors to ensure that problems are resolved. You’ll do this whilst learning about new approaches, with talented colleagues that will help you to learn, develop and grow.',
        'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20Profile%20-%20Support%20Technician%20(As).pdf?csf=1&web=1&e=2ZNeHK',
        'Providing day-to-day technical support and consultancy to clients. Proactively taking ownership for incidents and RFCs in areas of expertise and designated responsibility participating fully in the incident management lifecycle. Liaising with clients as required, presenting a professional image of Kainos, escalating, and reporting back to the Service Manager. Building, configuring and installing relevant software. Taking the lead in providing a support service to clients ensuring compliance with',
        1,
        3);

INSERT INTO job_roles (name, description, specification, responsibilities, capability, band_id)
VALUES (
        'Solution Architect',
        'You’ll be accountable for successful delivery of large-scale high-quality solution, which delight our customers and impact the lives of users worldwide. You will provide assurance and support to multi-skilled agile teams by understanding the outcomes the solution is trying to achieve, the technical implications and complexity surrounding you and your teams designs and help teams make the right decisions.',
        'https://kainossoftwareltd.sharepoint.com/:b:/g/people/ESpp56fZyrhKi6uCuwpshDwB3nmo1BMkbQKYDXbNHCi_sw?e=muiHBJ',
        'As a Solution Architect (Manager) in Kainos, you’ll be responsible for leading multi-skilled agile teams to design and deliver high quality solutions which delight our customers and impact the lives of users worldwide. You’ll work with customer architects to agree functional and non-functional designs, advising customers and managers on the estimated effort, technical implications and complexity surrounding your designs. You’ll manage, coach and develop a small number of staff, with a focus on ',
        1,
        6);

-- People Capability
INSERT INTO job_roles (name, description, specification, responsibilities, capability, band_id)
VALUES (
        'People Support Consultant',
        'You will provide an excellent service across all Business Units in Kainos, globally ensuring legislative guidance is adhered to and high standards are met and maintained in all people related processes. You may be a generalist or a specialist with a continuous improvement and efficiency mindset, working with internal and external stakeholders. You will lead on a number of key people projects to maximise the value of the People Support function and support the delivery of the People Strategy.',
        'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EbzFgCOGMB5MmZ_EgYkDbAEBdYN-_IrUeyRFL3UTmdoaTg?e=roKIFd',
        'As a People Support Consultant at Kainos, you will provide an excellent service across all Business Units in Kainos globally ensuring legislative guidance is adhered to and high standards are met and maintained in all people related processes. You may be be a Generalist or a specialist with a continuous improvement and efficiency mindset, working with internal and external stakeholders. You will lead on a number of key people projects to maximise the value of the People Support function and supp',
        13,
        5);

-- Business Development and Marketing Capability
INSERT INTO job_roles (name, description, specification, responsibilities, capability, band_id)
VALUES (
        'Business Development Manager',
        'You will be responsible for delivering the business development strategy by leading and generating activity in your sector/region and building an extensive network of industry contacts.  You will be accountable for building relevant stakeholder relationships with customers and industry partners to ensure cross-selling opportunities are maximised. You will be working collaboratively with other members of the Business Development team as well as colleagues from other areas of the business.',
        'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EQSrLdP-NpJJlnx-bJwSMloBPENhV7n1-5oTGGYu7Fm03Q?e=w2Eb0E',
        'Our vision is to create a world-class business development and marketing capability for Kainos, fuelled by a diverse range of highly talented and motivated professionals working collaboratively and innovatively to ensure we continue our growth trajectory.We do this via an open and supportive environment where colleagues can share information, learn from one another and excel in their own career. With consistent ways of working aligned to industry best practice, we build sustainable and predicta',
        11,
        6);

INSERT INTO job_roles (name, description, specification, responsibilities, capability, band_id)
VALUES (
        'Customer Success Manager',
        'You will be responsible for leading and managing a team to achieve regional OKRs, such as client retention and customer satisfaction targets, as set by the BU Leadership. In addition to team management, the Customer Success Manager will be responsible for managing a small number of strategic clients for the region. You will be the bridge between our Professional Services, Operational Support, Product and Business Development teams.',
        'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Business%20Development%20and%20Marketing/Client%20Management/Job%20Profile%20-%20Customer%20Success%20Director%20(Principal).pdf?csf=1&web=1&e=PbeeNQ',
        'As a Customer Success Director (Principal) at Kainos, you will partner with our customers post-sale to drive adoption and ensure customer satisfaction, growth, and retention. You will manage a team of Customer Success Managers responsible for achieving a set of OKRs set by BU Leadership. You will be the bridge between our Services,Services & product and Business Development teams. You will work directly with CustomerSuccess Managers, setting their career direction, goals and enabling them to work on',
        11,
        6);

-- Workday Capability
INSERT INTO job_roles (name, description, specification, responsibilities, capability, band_id)
VALUES (
        'HCM Solution Architect',
        'You’ll be fully accountable for the quality of how we deliver Workday deployments across your capability or capabilities. You’ll use your expertise to engage directly on high profile projects, to handle any significant functional challenges, and will be an important senior liaison and escalation for our clients.',
        'https://kainossoftwareltd.sharepoint.com/:b:/g/people/ETN6IRUxm-tAqLj5w_6uwaMBMmhSBV7gAqp1Wo1a-YBEgA?e=ajBqC9',
        'As a Workday HCM Solution Architect / Consultant (Principal) in Kainos, you’ll be fully accountable for the quality of how we deliver Workday deployments across your capability or capabilities. You’ll use your expertise to engage directly on high profile projects, to handle any significant functional challenges, and will be an important senior liaison and escalation for our clients. You’ll take part in business development activities, working with the sales team on opportunities within your are paramount',
        6,
        7);

INSERT INTO job_roles (name, description, specification, responsibilities, capability, band_id)
VALUES (
        'Financials Consultant',
        'You’ll work in a team to implement and configure enterprise-scale Workday solutions for our global customer base, typically leading a project work-stream. You will build relationships with our customers, shaping and delivering solutions that are aligned to customer needs, fit for purpose and commercially viable. You’ll provide excellent guidance to customers, understanding their business and requirements. You’ll support more junior members of the team and share your knowledge with them.',
        'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EZ5wK3j4YsNDlTDEqmGdjasBockuTVjgdtpdfY5dlIQX9w?e=rqJBTM',
        'As a Workday Financials Consultant (Consultant) in Kainos, you’ll work in a team to implement and configure enterprise-scale Workday solutions for our global customer base, typically leading a project workstream. You will build relationships with our customers, shaping and delivering solutions that are aligned to customer needs, fit for purpose and commercially viable. You’ll provide excellent guidance to customers, understanding their business and requirements. You’ll support more junior members',
        6,
        4);

INSERT INTO job_roles (name, description, specification, responsibilities, capability, band_id)
VALUES (
        'Data Consultants',
        'You’ll work as part of a team to support the implementation and configuration of enterprise-scale Workday solutions for our global customer base, focusing on checking, validating and transforming the customer’s organizational and employee data, and organizing it prior to loading in to the Workday tenants. You will work cooperatively with team members to understand customer requirements around the area of data, and with the guidance from senior consultants, deliver solutions that are aligned to customer needs.',
        'https://kainossoftwareltd.sharepoint.com/:b:/g/people/ERIWOy4Imy9PtzkGhRZXWA8Bpv9I0TCqs819FM7n19ZP1g?e=b5eCU2',
        'As a Workday Data Consultant (Senior Associate) in Kainos, you’ll work as part of a team to support the implementation and configuration of enterprise-scale Workday solutions for our global customer base, focusing on checking, validating and transforming the customer’s organizational and employee data, and organizing it prior to loading in to the Workday tenants. You will work co-operatively with team members to understand customer requirements around the area of data, and with the guidance from',
        6,
        5);
