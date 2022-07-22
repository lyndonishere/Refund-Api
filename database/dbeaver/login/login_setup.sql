create table login (
	id serial primary key, -- serials sets the column so it auto increments, primary key adds the unique id
	username varchar(50),
	user_password varchar(50),
	person_name varchar(50),
	user_role varchar(50)
);

-- create and save a startup sql script in your github repo

select * from login;


insert into login values(-5, 'spongebob', 'krabbypatties', 'Spongebob Squarepants', 'employee');

-- do this manually for delete
insert into login values(-4, 'to be deleted username', 'to be deleted password', 'to be deleted person name', 'to be deleted user role');
