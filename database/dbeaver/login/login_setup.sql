create table login (
	id serial primary key, -- serials sets the column so it auto increments, primary key adds the unique id
	username varchar(50),
	user_password varchar(50),
	user_role varchar(50)
);

-- create and save a startup sql script in your github repo
