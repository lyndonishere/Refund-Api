select * from history;

-- id is good
-- username
-- employee name
-- title
-- amount
-- desc

select * from reimbursement


create table reimbursement (reimbursement_id serial primary key, 
employee_username varchar(50), 
employee_name varchar(50), 
reimbursement_title varchar(50), 
amount integer, 
reimbursement_reason varchar(500),
request_date date,
status varchar(50),
decision_reason varchar(500));