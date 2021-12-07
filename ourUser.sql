CREATE TABLE ourUser (
    user_id INT UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
    phone_number CHAR(11),
    username VARCHAR(100),
    age INT UNSIGNED,
    email VARCHAR(80),
    password VARCHAR(100),
    gender VARCHAR(60),
    CONSTRAINT check_email CHECK (email LIKE ('%@%')),
    CONSTRAINT check_gender CHECK (gender IN ('male' , 'female', 'not specified'))
);

ALTER TABLE ourUser add constraint check_Number CHECK (LENGTH(phone_number) = 11);
ALTER TABLE ourUser add constraint check_Number2 CHECK (SUBSTRING(phone_number,1, 2) = '03');
alter table ourUser add CONSTRAINT check_phoneNumber3 CHECK( SUBSTRING(phone_number,3,1) IN ('0','1','2','3','4','5','6','7','8','9'));
ALTER TABLE ourUser ADD
CONSTRAINT check_phoneNumber CHECK (
SUBSTRING(phone_number,4,1) IN ('0','1','2','3','4','5','6','7','8','9')
AND SUBSTRING(phone_number,5,1) IN ('0','1','2','3','4','5','6','7','8','9')
AND SUBSTRING(phone_number,6,1) IN ('0','1','2','3','4','5','6','7','8','9')
AND SUBSTRING(phone_number,7,1) IN ('0','1','2','3','4','5','6','7','8','9')
AND SUBSTRING(phone_number,8,1) IN ('0','1','2','3','4','5','6','7','8','9')
AND SUBSTRING(phone_number,9,1) IN ('0','1','2','3','4','5','6','7','8','9')
AND SUBSTRING(phone_number,10,1) IN ('0','1','2','3','4','5','6','7','8','9')
AND SUBSTRING(phone_number,11,1) IN ('0','1','2','3','4','5','6','7','8','9'));

ALTER TABLE ourUser add constraint un_em UNIQUE(email);