create table medicine_request(
request_id int not null auto_increment primary key,
user_id int unsigned,
date_of_request date,
foreign key (user_id) references ouruser(user_id) ON DELETE CASCADE ON UPDATE CASCADE
);

create table medicines(
medicine_id int not null auto_increment primary key,
stock varchar(15),
medicine_name varchar(50),
production varchar(50),
manufacture_date date,
expiry_date date,
prescription varchar(100)
);

create table user_medicine(
request_id int unsigned,
medicine_id int unsigned,
quantity int,
foreign key (request_id) references medicine_request(request_id) on update cascade on delete cascade,
foreign key (medicine_id) references medicines(medicine_id) on update cascade on delete cascade,
primary key(request_id, medicine_id)
);

create table medicine_donation(
donation_id int unsigned not null auto_increment primary key,
date_of_donation date,
user_id int unsigned,
foreign key (user_id) references ouruser(user_id) on update cascade on delete cascade
);

create table medicine_donation_detail(
donation_id int unsigned,
medicine_id int unsigned,
quantity int,
foreign key (medicine_id) references medicines(medicine_id) on update cascade on delete cascade,
foreign key (donation_id) references medicine_donation(donation_id) on update cascade on delete cascade,
primary key(medicine_id, donation_id)
);