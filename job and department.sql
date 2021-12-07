CREATE TABLE job (
    job_id INT UNSIGNED auto_increment not NULL PRIMARY KEY,
    job_title VARCHAR(50)
);

CREATE TABLE department (
    department_id INT UNSIGNED auto_increment Not NULL PRIMARY KEY,
    department_name VARCHAR(50)
);
