CREATE TABLE donations_received (
    donation_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT UNSIGNED,
    amount_donated DOUBLE,
    donation_date DATE,
    FOREIGN KEY (user_id)
        REFERENCES ouruser (user_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE donations_requested (
    request_id INT UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
    amount_requested DOUBLE,
    user_id INT UNSIGNED,
    comment VARCHAR(255),
    approved VARCHAR(5),
    employee_id INT UNSIGNED,
    FOREIGN KEY (user_id)
        REFERENCES ouruser (user_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (employee_id)
        REFERENCES employee (employee_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT chk_approval CHECK (approved IN ('approved' , 'not approved', 'pending'))
);