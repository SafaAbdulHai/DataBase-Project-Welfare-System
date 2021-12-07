CREATE TABLE employee (
    employee_id INT UNSIGNED auto_increment NOT NULL PRIMARY KEY,
    name VARCHAR(50),
    phoneNo CHAR(11),
    email VARCHAR(80),
    password VARCHAR(50),
    salary DOUBLE,
    status VARCHAR(50),
    job_id INT UNSIGNED,
    department_id INT UNSIGNED,
    CONSTRAINT fk_job_id_employee FOREIGN KEY (job_id)
        REFERENCES job (job_id) on update cascade on delete cascade,
    CONSTRAINT fk_department_id_employee FOREIGN KEY (department_id)
        REFERENCES department (department_id) on delete cascade on update cascade,
        constraint password_len check (length(password)>7),
        CONSTRAINT check_empemail CHECK (email LIKE ('%@%')),
        constraint check_empNumber CHECK (LENGTH(phoneNo) = 11 AND SUBSTRING(phoneNo,1,2) = '03'
        AND SUBSTRING(phoneNO,3,1) IN ('0','1','2','3','4','5','6','7','8','9') 
	    AND SUBSTRING(phoneNo,4,1) IN ('0','1','2','3','4','5','6','7','8','9')
        AND SUBSTRING(phoneNo,5,1) IN ('0','1','2','3','4','5','6','7','8','9')
	    AND SUBSTRING(phoneNo,6,1) IN ('0','1','2','3','4','5','6','7','8','9')
        AND SUBSTRING(phoneNo,7,1) IN ('0','1','2','3','4','5','6','7','8','9')
        AND SUBSTRING(phoneNo,8,1) IN ('0','1','2','3','4','5','6','7','8','9')
        AND SUBSTRING(phoneNo,9,1) IN ('0','1','2','3','4','5','6','7','8','9')
        AND SUBSTRING(phoneNo,10,1) IN ('0','1','2','3','4','5','6','7','8','9')
        AND SUBSTRING(phoneNo,11,1) IN ('0','1','2','3','4','5','6','7','8','9'))
);

ALTER TABLE employee DROP email;