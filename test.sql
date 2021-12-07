INSERT INTO ourUser (phone_number, username, age, email, password, gender)
VALUES ('03005298951','Huda',45,'huda.mumtazchanna@gmail.com','iba@2123','female');

INSERT INTO blood_group VALUES (1,'A+',0);
INSERT INTO blood_group VALUES (2,'A-',0);
INSERT INTO blood_group VALUES (3,'B+',0);
INSERT INTO blood_group VALUES (4,'B-',0);
INSERT INTO blood_group VALUES (5,'AB+',0);
INSERT INTO blood_group VALUES (6,'AB-',0);
INSERT INTO blood_group VALUES (7,'O+',0);
INSERT INTO blood_group VALUES (8,'O-',0);

SELECT * FROM ourUser;
SELECT * FROM blood_group;

INSERT INTO job (job_title) VALUES ('Driver');

Insert INTO employee (name, phoneNo, password, salary,job_id)
VALUES ('ABC','03123456732','iba12345',500,1);

SELECT * FROM employee;
-- Blood tables will be properly tested after the completion of triggers

SELECT * FROM ourUser;