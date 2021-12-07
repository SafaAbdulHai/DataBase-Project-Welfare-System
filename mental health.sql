Create table Mental_Health_Counsellor(
employee_id int unsigned,
counselling_day date,
Starting_time timestamp,
Ending_time timestamp,
Foreign key (employee_id) references employee(employee_id),
primary key(employee_id)
);

Create table Counselling_Request(
Counselling_id int not null auto_increment primary key,
Starting_time timestamp,
Ending_time timestamp,
Appointment_day date,
user_id int UNSIGNED,
Employee_id int unsigned,
Foreign Key (User_id) references ourUser(User_id),
Foreign Key (Employee_id) references Employee(Employee_id)
);
