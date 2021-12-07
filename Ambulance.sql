CREATE TABLE ambulance (
    plate_no VARCHAR(300) NOT NULL PRIMARY KEY,
    ambulance_availaible VARCHAR(2),
    employee_id INT UNSIGNED,
    FOREIGN KEY (employee_id)
        REFERENCES employee (employee_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT CHECK (ambulance_availaible IN ('yes' , 'no'))
);

CREATE TABLE ambulance_request (
    request_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    location_address VARCHAR(50),
    number_of_patients INT UNSIGNED,
    user_id INT UNSIGNED,
    plate_no VARCHAR(300),
    employee_id INT UNSIGNED,
    FOREIGN KEY (user_id)
        REFERENCES ouruser (user_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (plate_no)
        REFERENCES ambulance (plate_no)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (employee_id)
        REFERENCES employee (employee_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE area_of_service (
    service_id INT UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
    description VARCHAR(255)
);

CREATE TABLE ambulance_aos (
    service_id INT UNSIGNED,
    plate_no VARCHAR(300),
    FOREIGN KEY (service_id)
        REFERENCES area_of_service (service_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (plate_no)
        REFERENCES ambulance (plate_no)
        ON UPDATE CASCADE ON DELETE CASCADE
);
