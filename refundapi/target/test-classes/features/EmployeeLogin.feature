Feature: Employees of our reimbursement application should be able to log in to their personal employee homepage

    Scenario: As an employee, I want to sign in so I can view my custom homepage when I enter the correct credentials (POSITIVE)

        Given the employee is on the login page
        When the employee enters in their correct user name
        When the employee enters in their correct password
        When the employee clicks the login button
        Then the employee should be logged into the employee homepage

    Scenario: As an employee, I want to receive an alert if I login with the incorrect credentials (NEGATIVE)

        Given the employee is on the login page
        When the employee enters in their incorrect user name
        When the employee enters in their incorrect password
        When the employee clicks the login button
        Then the employee should be receive an alert that their credentials are incorrect.