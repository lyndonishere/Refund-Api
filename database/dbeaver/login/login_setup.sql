create table login (
	id serial primary key, -- serials sets the column so it auto increments, primary key adds the unique id
	username varchar(50),
	user_password varchar(50),
	person_name varchar(50),
	user_role varchar(50)
);

-- create and save a startup sql script in your github repo

select * from reimbursement;
select * from login;

-- service tests
insert into login values(-2, 'spongebob', 'krabbypatties', 'Spongebob', 'employee');
update login set person_name = 'Spongebob Squarepants' where person_name = 'Spongebob';

-- for my own sake
insert into login values(-4, 'mrkrabs', 'ilikemoney', 'Eugene Krabs', 'manager');

-- repo update test
insert into login values(-1, 'squinkward', 'clairnet', 'Squidward Tortellini', 'manager');

-- api remove
insert into login values(-6, 'kevin', 'jellyfishing', 'Kevin the Cucumber', 'employee');

-- api update
insert into login values(-7, 'mrspuff', 'helpme', 'Mrs. Poppy Puff', 'employee');
update login set username  = 'mspuff' where username  = 'mrspuff';


insert into reimbursement values(default, 'squidward', 'Squidward Tentacles', 'E2E Test', 999, 'Use this for Manager E2E Test', '2017-12-12', 'Pending', 'TBA');
update reimbursement set employee_username = 'spongebob' where employee_username = 'imready420';

delete from reimbursement where reimbursement_id = 65;
select * from reimbursement;