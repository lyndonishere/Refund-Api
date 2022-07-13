Feature: All users of our reimbursement application should have a unique username.

    Scenario: As a user, I want to login successfully (POSITIVE)
    
        Given the employee is on the login page
        When the employee enters in their correct user name
        When the employee enters in their correct password
        When the employee clicks the login button
        Then the employee should be logged into the employee homepage

    Scenario: I should receive an alert if my username matches another username and not be able to login (NEGATIVE)

        Given the user is on the login page
        When the user enters in their correct yet duplicate username
        When the user enters in their correct pasword
        Then the user should receive a notice that their username matches another user and to contact IT