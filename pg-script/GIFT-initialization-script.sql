-- CREATE A DATABASE NAMED "GIFTProject" AND PASTE THIS SCRIPT INSIDE

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE SEQUENCE Tutor_seq;

CREATE TABLE Tutor(
        id_tutor  Int  Default nextval ('Tutor_seq')  NOT NULL ,
        email     Varchar (50) NOT NULL ,
        password  Varchar (200) NOT NULL ,
        firstname Varchar (50) NOT NULL ,
        lastname  Varchar (50) NOT NULL,
        role     Varchar  (50) DEFAULT 'tutor_role'
	,CONSTRAINT Tutor_PK PRIMARY KEY (id_tutor)
);

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE SEQUENCE Evaluations_seq;

CREATE TABLE Evaluations(
        id_evaluations      Int  Default nextval ('Evaluations_seq')  NOT NULL ,
        oral_presentation   Bool NOT NULL ,
        technical_grade     Double precision NOT NULL ,
        communication_grade Double precision NOT NULL
	,CONSTRAINT Evaluations_PK PRIMARY KEY (id_evaluations)
);

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE SEQUENCE Internship_seq;

CREATE TABLE Internship(
        id_internship      Int  Default nextval ('Internship_seq')  NOT NULL ,
        is_visit_planified Bool NOT NULL ,
        is_visit_done      Bool NOT NULL ,
        start_date         Date NOT NULL ,
        end_date           Date NOT NULL ,
        company_name       Varchar (50) NOT NULL ,
        company_address    Varchar (200) NOT NULL ,
        mission            Text NOT NULL ,
        company_tutor      Varchar (50) NOT NULL
	,CONSTRAINT Internship_PK PRIMARY KEY (id_internship)
);

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE SEQUENCE Documents_seq;

CREATE TABLE Documents(
        id_documents              Int  Default nextval ('Documents_seq')  NOT NULL ,
        is_specs_done             Bool NOT NULL ,
        is_visit_form_done        Bool NOT NULL ,
        is_company_eval_form_done Bool NOT NULL ,
        is_web_poll_done          Bool NOT NULL ,
        is_report_done            Bool NOT NULL
	,CONSTRAINT Documents_PK PRIMARY KEY (id_documents)
);

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE SEQUENCE Student_seq;

CREATE TABLE Student(
        id             Int  Default nextval ('Student_seq')  NOT NULL ,
        firstname      Varchar (50) NOT NULL ,
        lastname       Varchar (50) NOT NULL ,
        student_group          Varchar (50) NOT NULL ,
        comments       Text NOT NULL ,
        id_tutor       Int NOT NULL ,
        id_internship  Int NOT NULL ,
        id_evaluations Int NOT NULL ,
        id_documents   Int NOT NULL
	,CONSTRAINT Student_PK PRIMARY KEY (id)

	,CONSTRAINT Student_Tutor_FK FOREIGN KEY (id_tutor) REFERENCES Tutor(id_tutor)
	,CONSTRAINT Student_Internship0_FK FOREIGN KEY (id_internship) REFERENCES Internship(id_internship)
	,CONSTRAINT Student_Evaluations1_FK FOREIGN KEY (id_evaluations) REFERENCES Evaluations(id_evaluations)
	,CONSTRAINT Student_Documents2_FK FOREIGN KEY (id_documents) REFERENCES Documents(id_documents)
);


INSERT INTO Tutor (email, password, firstname, lastname)
VALUES ('john@example.com', 'password123', 'John', 'Doe');

INSERT INTO Tutor (email, password, firstname, lastname)
VALUES ('jane@example.com', 'password456', 'Jane', 'Smith');

INSERT INTO Tutor (email, password, firstname, lastname)
VALUES ('mark@example.com', 'password789', 'Mark', 'Johnson');

INSERT INTO Evaluations (oral_presentation, technical_grade, communication_grade)
VALUES (TRUE, 15.8, 19.5);

INSERT INTO Evaluations (oral_presentation, technical_grade, communication_grade)
VALUES (FALSE, 17.2, 18.9);

INSERT INTO Evaluations (oral_presentation, technical_grade, communication_grade)
VALUES (TRUE, 18.5, 16.2);

INSERT INTO Internship (is_visit_planified, is_visit_done, start_date, end_date, company_name, company_address, mission, company_tutor)
VALUES (TRUE, TRUE, '2022-06-01', '2022-09-30', 'Acme Inc.', '123 Main St., Anytown, USA', 'Developed new software features', 'Alice Johnson');

INSERT INTO Internship (is_visit_planified, is_visit_done, start_date, end_date, company_name, company_address, mission, company_tutor)
VALUES (FALSE, TRUE, '2022-05-01', '2022-08-31', 'Widget Co.', '456 Oak St., Anytown, USA', 'Improved user interface', 'Bob Smith');

INSERT INTO Internship (is_visit_planified, is_visit_done, start_date, end_date, company_name, company_address, mission, company_tutor)
VALUES (TRUE, FALSE, '2022-06-15', '2022-10-15', 'Gadget Corp.', '789 Maple St., Anytown, USA', 'Optimized database queries', 'Charlie Brown');

INSERT INTO Documents (is_specs_done, is_visit_form_done, is_company_eval_form_done, is_web_poll_done, is_report_done)
VALUES (TRUE, TRUE, TRUE, TRUE, TRUE);

INSERT INTO Documents (is_specs_done, is_visit_form_done, is_company_eval_form_done, is_web_poll_done, is_report_done)
VALUES (TRUE, TRUE, FALSE, TRUE, FALSE);

INSERT INTO Documents (is_specs_done, is_visit_form_done, is_company_eval_form_done, is_web_poll_done, is_report_done)
VALUES (FALSE, TRUE, TRUE, FALSE, TRUE);

INSERT INTO Student (firstname, lastname, student_group, comments, id_tutor, id_internship, id_evaluations, id_documents)
VALUES ('John', 'Smith', 'L3', 'Excellent work', 1, 1, 1, 1);

INSERT INTO Student (firstname, lastname, student_group, comments, id_tutor, id_internship, id_evaluations, id_documents)
VALUES ('Jane', 'Doe', 'M1', 'Needs improvement', 2, 2, 2, 2);

INSERT INTO Student (firstname, lastname, student_group, comments, id_tutor, id_internship, id_evaluations, id_documents)
VALUES ('Mark', 'Johnson', 'M2', 'Great potential', 3, 3, 3, 3);
