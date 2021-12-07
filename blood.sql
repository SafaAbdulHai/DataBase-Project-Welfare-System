CREATE TABLE blood_group (
    blood_group_id INT UNSIGNED NOT NULL PRIMARY KEY,
    blood_group_description VARCHAR(255),
    blood_group_qty INT UNSIGNED
);

CREATE TABLE blood_donor (
    blood_id INT UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
    User_id INT UNSIGNED NOT NULL,
    blood_group_id INT UNSIGNED NOT NULL,
    donor_comment VARCHAR(255),
    CONSTRAINT fk_user_id_ouruser FOREIGN KEY (user_id)
        REFERENCES ouruser (user_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_blood_group_id_blood_donor FOREIGN KEY (blood_group_id)
        REFERENCES blood_group (blood_group_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE blood_reciever (
    blood_id INT UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
    Receiving_Date DATE,
    receiver_comment VARCHAR(255),
    user_id INT UNSIGNED,
    blood_group_id INT UNSIGNED,
    CONSTRAINT fk_blood_group_id_blood_receiver FOREIGN KEY (blood_group_id)
        REFERENCES blood_group (blood_group_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE blood_donation_details (
    blood_donation_date DATE NOT NULL,
    blood_id INT UNSIGNED NOT NULL,
    blood_qty INT UNSIGNED,
    CONSTRAINT fk_blood_id_blood_donation FOREIGN KEY (blood_id)
        REFERENCES blood_donor (blood_id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (blood_donation_date , blood_id)
);