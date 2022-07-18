select * from login;

insert into login values (-3, 'to be updated username', 'to be updated password', 'to be updated person name', 'to be updated user role');

-- i need to execute this script each time i run my tests to make sure my test data is set up
update login set username = 'to be updated', user_password  = 'to be updated', person_name = 'to be updated', user_role = 'to be updated' where id = -3;

insert into login values (-4, 'to be deleted username', 'to be deleted password', 'to be deleted person name', 'to be deleted user role');

