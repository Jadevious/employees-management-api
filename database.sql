CREATE DATABASE IF NOT EXISTS groupc_kainos_recruitment_JenniferC;
USE groupc_kainos_recruitment_JenniferC;

CREATE TABLE IF NOT EXISTS job_roles (
id smallint PRIMARY KEY AUTO_INCREMENT,
name varchar(50) NOT NULL,
description varchar(500) NOT NULL,
specification varchar(255) NOT NULL,
responsibilities varchar(500),
capability enum ('Engineering', 'Platforms', 'Data', 'Artificial Intelligence',
    'Cyber Security', 'Workday', 'Experience Design', 'Product', 'Delivery', 'Operations',
    'Business Development and Marketing', 'Organisational Strategy and Planning',
    'People', 'Commercial and Financial Management', 'Business Services Support'),
band_id smallint NOT NULL,
FOREIGN KEY (band_id) REFERENCES bands(id)
);

CREATE TABLE IF NOT EXISTS bands (
id smallint PRIMARY KEY AUTO_INCREMENT,
name ENUM('Apprentice', 'Trainee', 'Associate', 'Senior Associate', 'Consultant', 'Manager', 'Principal', 'Leadership Community') NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
id smallint PRIMARY KEY AUTO_INCREMENT,
username varchar(50) NOT NULL,
password varchar(100) NOT NULL
);

-- Engineering Capability
INSERT INTO job_roles (name, description, specification, responsibilities, capability, band_id)
VALUES (
        'Software Engineer',
        'You will work on projects where you can make a real difference to people’s lives – the lives of people you know. Undertake extensive training to set you off on the right foot, you will quickly work as a part of a team in developing solutions within our real projects and learn all about our development languages, projects and technologies. You will be fully supported by experienced colleagues in the team, as well as an experienced mentor, who will provide training and mentoring throughout your studies.',
        'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EbTM1UOLa0VBvOttkOL3ZNoB0sMjehxvkAaNQEj2dqKMbA?e=iXpeUf',
        'As an Apprentice Software Engineer with Kainos, you will work on projects where you can make a real difference to people’s lives – the lives of people you know. extensive training to set you off on the right foot, you will quickly work as a part of a team in developing solutions within our real projects, learning all about our development languages, projects and technologies. You will be fully supported by experienced colleagues in the team as well as an experienced mentor, who will provide training and mentoring throughout your studies. You’ll also get experience across a wide range of teams and projects, with built-in rotations to help you learn and work out which element of Software Engineering suits your interests and skills best.   You’ll have a genuine enthusiasm for anything tech and be able to really show this, both within and outside of your studies. You’ll be able to show us your teamworking skills –everyone in Kainos works in tight-knit teams, so this is crucial. Our developers are creative – you’ll be able to show us your skills for coming up with new ideas and ways of doing things, how you’ve solved problems and looked at things differently. ',
        'Engineering',
        1);
INSERT INTO job_roles (name, description, specification, responsibilities, capability, band_id)
VALUES (
        'Test Engineer',
        'You will work within a multi-skilled agile team, developing and executing functional, automated and manual tests to help the team deliver working application software that meets users needs. You’ll do this whilst learning about new technologies and approaches, with talented colleagues who will help you learn, develop and grow.',
        'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EcGbc8drFRlBoh2H2BZSeVwBV1tAiDCTwirdTmrz2EYYmQ?e=XMqXJh',
        'As a Test Engineer (Trainee) in Kainos, you’ll work within a multi-skilled agile team, developing and executing functional automated and manual tests to help the team deliver working application software that meets user needs. You’ll do this whilst learning about new technologies and approaches, with talented colleagues who will help you learn, develop and grow.',
        'Engineering',
        2);
INSERT INTO job_roles (name, description, specification, responsibilities, capability, band_id)
VALUES (
        'Support Technician',
        'As a Support Technician in Kainos, you’ll be responsible for analysing and solving complicated technical issues. You will adhere to ITIL standards and will participate fully in the Incident Management Lifecycle. You will work closely with clients, internal teams and 3rd Party Vendors to ensure that problems are resolved. You’ll do this whilst learning about new approaches, with talented colleagues that will help you to learn, develop and grow.',
        'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20Profile%20-%20Support%20Technician%20(As).pdf?csf=1&web=1&e=2ZNeHK',
        'Providing day-to-day technical support and consultancy to clients. Proactively taking ownership for incidents and RFCs in areas of expertise and designated responsibility participating fully in the incident management lifecycle. Liaising with clients as required, presenting a professional image of Kainos, escalating, and reporting back to the Service Manager. Building, configuring and installing relevant software. Taking the lead in providing a support service to clients ensuring compliance with Service Level Agreements. Providing guidance and support to junior members of the department. Will have an awareness of overall client business requirements and impact on Kainos and client commercials. Delivering within commercial constraints that apply to the support agreement. Producing technical documentation and procedures as necessary. Ensuring that deliverables are consistent with Kainos and/or client policies, strategies and constraints. Applying all relevant standards and procedures to their own work. Taking responsibility for team leading as required. Leading by example in both technical and non-technical aspects of the job. Recognising and raising business opportunities. Maintaining a current knowledge of relevant technology developments and actively shares knowledge. Advising customers on the technical, operational and business impacts of processes, incidents and RFCs. Involving development/infrastructure team/third parties as appropriate. Contributing to service review meetings. Complying with all confidentiality and non-disclosure policies and/or agreements and ensures security of information at all times.',
        'Engineering',
        3);
INSERT INTO job_roles (name, description, specification, responsibilities, capability, band_id)
VALUES (
        'Solution Architect',
        'You’ll be accountable for successful delivery of large-scale high-quality solution, which delight our customers and impact the lives of users worldwide. You will provide assurance and support to multi-skilled agile teams by understanding the outcomes the solution is trying to achieve, the technical implications and complexity surrounding you and your teams designs and help teams make the right decisions.',
        'https://kainossoftwareltd.sharepoint.com/:b:/g/people/ESpp56fZyrhKi6uCuwpshDwB3nmo1BMkbQKYDXbNHCi_sw?e=muiHBJ',
        'As a Solution Architect (Manager) in Kainos, you’ll be responsible for leading multi-skilled agile teams to design and deliver high quality solutions which delight our customers and impact the lives of users worldwide. You’ll work with customer architects to agree functional and non-functional designs, advising customers and managers on the estimated effort, technical implications and complexity surrounding your designs.  You’ll manage, coach and develop a small number of staff, with a focus on managing employee performance and assisting in their career development. You’ll also provide direction and leadership for your team as you solve challenging problems together.  As a technical leader, you will work with your peers to develop policy and standards, share knowledge and mentor those around you. You’ll do this whilst advising about new technologies and approaches, with room to learn, develop and grow.',
        'Engineering',
        6);

-- People Capability
INSERT INTO job_roles (name, description, specification, responsibilities, capability, band_id)
VALUES (
        'People Support Consultant',
        'You will provide an excellent service across all Business Units in Kainos, globally ensuring legislative guidance is adhered to and high standards are met and maintained in all people related processes. You may be a generalist or a specialist with a continuous improvement and efficiency mindset, working with internal and external stakeholders. You will lead on a number of key people projects to maximise the value of the People Support function and support the delivery of the People Strategy.',
        'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EbzFgCOGMB5MmZ_EgYkDbAEBdYN-_IrUeyRFL3UTmdoaTg?e=roKIFd',
        'As a People Support Consultant at Kainos, you will provide an excellent service across all Business Units in Kainos globally ensuring legislative guidance is adhered to and high standards are met and maintained in all people related processes. You may be be a Generalist or a specialist with a continuous improvement and efficiency mindset, working with internal and external stakeholders. You will lead on a number of key people projects to maximise the value of the People Support function and support the delivery of the People Strategy.You may lead a team of colleages or you may act in in a standalone role as an SME. You will be responsible for some or all of the following: Building and fostering strong relationships with managers/business leaders – to become a trusted advisor on people related activities. Creating, implementing and maintaining all people support policies and procedures – you will continually review these for accuracy and that they remain fit for purpose, ensuring all collateral is maintained. Driving continual improvement of people processes utilising HRIS systems – to  ensure the data in our people system is maintained and improvements to the system are driven through to create efficiencies. Employee Relations – you will lead on a variety of Employee Relations cases (in line with Company Framework) when they arise. Developing management reporting– you will develop and provide high quality management reports to aid the business and drive success through its people. Building management capability - Ensuring our Managers have the skills and tools to effectively carry out their roles as People Managers though advice, guidance, and coaching. This will include a focus on the education and execution of HR cyclicalprocesses. Participating as a member of the People Support Team - you will share good practice and knowledge, challenge improvements and resolve common issues as well as ensuring consistency. Supporting Global Mobility – you will understand the global nuances in our different locations and embed these in processes to ensure global service is delivered.  You will also act as a point of contact for our global stakeholders. Supporting project managementactivities – you will support the execution of business projects that have a people impact. This may include (but not limited to) business growth or restructure initiatives. •Providing employee support – you willassist employees with questions and escalations,directing them to the appropriate teams and helping to resolve in a timely and accurate manner. You will also be required to partner with cross-functional teams when appropriate to drive continuous improvement initiatives.',
        'People',
        5);

-- Business Development and Marketing Capability
INSERT INTO job_roles (name, description, specification, responsibilities, capability, band_id)
VALUES (
        'Business Development Manager',
        'You will be responsible for delivering the business development strategy by leading and generating activity in your sector/region and building an extensive network of industry contacts.  You will be accountable for building relevant stakeholder relationships with customers and industry partners to ensure cross-selling opportunities are maximised. You will be working collaboratively with other members of the Business Development team as well as colleagues from other areas of the business.',
        'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EQSrLdP-NpJJlnx-bJwSMloBPENhV7n1-5oTGGYu7Fm03Q?e=w2Eb0E',
        'Our vision is to create a world-class business development and marketing capability for Kainos, fuelled by a diverse range of highly talented and motivated professionals working collaboratively and innovatively to ensure we continue our growth trajectory.We do this via an open and supportive environment where colleagues can share information, learn from one another and excel in their own career.  With consistent ways of working aligned to industry best practice, we build sustainable and predictable sales pipelines for our market-leading offerings. As a Business Development Manager in Kainos, you will be responsible for building Kainos’ new business by forging into new accounts, based on building an extensive network of industry contacts.  You will be accountable for building relevant stakeholder relationships with customers and industry partners to ensure cross-selling opportunities are maximised. You will be working collaboratively with other members of the Business Development team as well as colleagues from other areas of the business including delivery, legal, marketing and operations.Your key responsibilities will include: Developing Kainos as a business –using on a combination of new and existing accounts (where applicable), you will build and maintain a rich pipeline of opportunities which will enable you to forecast accurately across future quarters, achieve agreed sales targets and maintaining predictability of future revenue. Providing Business development Leadership – utilising best industry practice and processes, you will develop prospect and account plans, forming and managingpursuit teams (where applicable) to develop pipeline and deliver revenue. Putting deals together – these deals will need to meet sales, revenue and profitability objectives, and ensure that the work contracted is compatible with Kainos’ strategy and goals. Being a trusted advisor for our customers–you will be expected to apply a consultative selling approach based on taking the time to properly understand ourcustomers and their challenges/opportunities. Empathy, active listening, being responsive and creativity all play a part here.•Building and developing strategic partnerships – you will build and maintain successful partnerships with both our strategic partners and other businesses in our ecosystem to enable Kainos to be positioned as go-to partner that is trusted and continually adds value. ',
        'Business Development and Marketing Capability',
        6);
INSERT INTO job_roles (name, description, specification, responsibilities, capability, band_id)
VALUES (
        'Customer Success Manager',
        'You will be responsible for leading and managing a team to achieve regional OKRs, such as client retention and customer satisfaction targets, as set by the BU Leadership. In addition to team management, the Customer Success Manager will be responsible for managing a small number of strategic clients for the region. You will be the bridge between our Professional Services, Operational Support, Product and Business Development teams.',
        'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Business%20Development%20and%20Marketing/Client%20Management/Job%20Profile%20-%20Customer%20Success%20Director%20(Principal).pdf?csf=1&web=1&e=PbeeNQ',
        'As a Customer Success Director (Principal) at Kainos, you will partner with our customers post-sale to drive adoption and ensure customer satisfaction, growth, and retention. You will manage a team of Customer Success Managers responsible for achieving a set of OKRs set by BU Leadership.  You will be the bridge between our Services,Services & productand Business Developmentteams. You willwork directly with CustomerSuccess Managers, setting their career direction, goals and enabling them to work with all our Workday customers to achieve a high level of success and satisfaction.',
        'Business Development and Marketing Capability',
        6);

-- Workday Capability
INSERT INTO job_roles (name, description, specification, responsibilities, capability, band_id)
VALUES (
        'HCM Solution Architect',
        'You’ll be fully accountable for the quality of how we deliver Workday deployments across your capability or capabilities. You’ll use your expertise to engage directly on high profile projects, to handle any significant functional challenges, and will be an important senior liaison and escalation for our clients.',
        'https://kainossoftwareltd.sharepoint.com/:b:/g/people/ETN6IRUxm-tAqLj5w_6uwaMBMmhSBV7gAqp1Wo1a-YBEgA?e=ajBqC9',
        'As a Workday HCM Solution Architect / Consultant (Principal) in Kainos, you’ll be fully accountable for the quality of how we deliver Workday deployments across your capability or capabilities. You’ll use your expertise to engage directly on high profile projects, to handle any significant functional challenges, and will be an important senior liaison and escalation for our clients.  You’ll take part in business development activities, working with the sales team on opportunities within your area and will be jointly accountable for achieving sales targets, providing commercially competitive estimates and content to support the sales process. ',
        'Workday',
        7);

INSERT INTO job_roles (name, description, specification, responsibilities, capability, band_id)
VALUES (
        'Financials Consultant',
        'You’ll work in a team to implement and configure enterprise-scale Workday solutions for our global customer base, typically leading a project work-stream. You will build relationships with our customers, shaping and delivering solutions that are aligned to customer needs, fit for purpose and commercially viable. You’ll provide excellent guidance to customers, understanding their business and requirements. You’ll support more junior members of the team and share your knowledge with them.',
        'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EZ5wK3j4YsNDlTDEqmGdjasBockuTVjgdtpdfY5dlIQX9w?e=rqJBTM',
        'As a Workday Financials Consultant (Consultant) in Kainos, you’ll work in a team to implement and configure enterprise-scale Workday solutions for our global customer base, typically leading a project workstream. You will build relationships with our customers, shaping and delivering solutions that are aligned to customer needs, fit for purpose and commercially viable.  You’ll provide excellent guidance to customers, understanding their business and requirements. You’ll support more junior members of the team and share your knowledge with them.',
        'Workday',
        4);
INSERT INTO job_roles (name, description, specification, responsibilities, capability, band_id)
VALUES (
        'Data Consultants',
        'You’ll work as part of a team to support the implementation and configuration of enterprise-scale Workday solutions for our global customer base, focusing on checking, validating and transforming the customer’s organizational and employee data, and organizing it prior to loading in to the Workday tenants. You will work cooperatively with team members to understand customer requirements around the area of data, and with the guidance from senior consultants, deliver solutions that are aligned to customer needs.',
        'https://kainossoftwareltd.sharepoint.com/:b:/g/people/ERIWOy4Imy9PtzkGhRZXWA8Bpv9I0TCqs819FM7n19ZP1g?e=b5eCU2',
        'As a Workday Data Consultant (Senior Associate) in Kainos, you’ll work as part of a team to support the implementation and configuration of enterprise-scale Workday solutions for our global customer base, focusing on checking, validating and transforming the customer’s organizational and employee data, and organizing it prior to loading in to the Workday tenants.  You will work co-operatively with team members to understand customer requirements around the area of data, and with the guidance from senior consultants, deliver solutions that are aligned to customer needs. You’ll know when to appropriately escalate issues and seek support from your more experienced team members. You’ll use your knowledge to present and explain the Kainos data gathering workbooks and process to customers and will work towards becoming a specialist in the Workday Data Consulting capability.  ',
        'Workday',
        5);

-- Band Levels/Management Levels
INSERT INTO bands (name) VALUES ('Apprentice');
INSERT INTO bands (name) VALUES ('Trainee');
INSERT INTO bands (name) VALUES ('Associate');
INSERT INTO bands (name) VALUES ('Senior Associate');
INSERT INTO bands (name) VALUES ('Consultant');
INSERT INTO bands (name) VALUES ('Manager');
INSERT INTO bands (name) VALUES ('Principal');
INSERT INTO bands (name) VALUES ('Leadership Community');

INSERT INTO users (username, password) VALUES ('Abiye', '$2a$10$tRi9MgRYZv0gC./N6owdxua9FNqoPmbjIMwH6yWR92i5ruW1gZrJm');
