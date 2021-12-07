
create table db_project.medicine_request(request_id int not null auto_increment primary key,
user_id int unsigned,
date_of_request date,
foreign key (user_id) references ouruser(user_id)
);

create table db_project.medicines(medicine_id int not null auto_increment primary key,
stock varchar(15),
medicine_name varchar(50),
production varchar(50),
manufacture_date date,
expiry_date date,
prescription varchar(100)
);


create table db_project.user_medicine(request_id int,
medicine_id int,
quantity int,
foreign key (request_id) references medicine_request(request_id),
foreign key (medicine_id) references medicines(medicine_id),
primary key(request_id, medicine_id)
);


create table db_project.medicine_donation(donation_id int not null auto_increment primary key,
date_of_donation date,
user_id int unsigned,
foreign key (user_id) references ouruser(user_id)
);

create table db_project.medicine_donation_detail(donation_id int,
medicine_id int,
quantity int,
foreign key (medicine_id) references medicines(medicine_id),
foreign key (donation_id) references medicine_donation(donation_id),
primary key(medicine_id, donation_id)
);




Create table db_project.Mental_Health_Counsellor(
employee_id int unsigned,
Counselling_day date,
Starting_time timestamp,
Ending_time timestamp,
Foreign key (employee_id) references employee(employee_id),
primary key(employee_id)
);

Create table db_project.Counselling_Request(
Counselling_id int not null auto_increment primary key,
Starting_time timestamp,
Ending_time timestamp,
Appointment_day date,
user_id int UNSIGNED,
Employee_id int unsigned,
Foreign Key (User_id) references ourUser(User_id),
Foreign Key (Employee_id) references Employee(Employee_id)
);

alter table employee add column job_id int;
alter table employee add
CONSTRAINT fk foreign key(job_id) references job(job_id);
alter table employee add column department_id int;
 alter table employee add constraint fk2 foreign key(department_id) references department(department_id);

alter table employee add column employee_id int unsigned not null auto_increment primary key;
alter table employee add
CONSTRAINT check_phoneNumber CHECK (character_length(phone_number)=11 and substr(phone_number,1,2)='03');
alter table employee add
CONSTRAINT checknumber2 check (substring(phone_number,3,11) LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]');
alter table employee add constraint password_len 
check (character_length(password)>7);


