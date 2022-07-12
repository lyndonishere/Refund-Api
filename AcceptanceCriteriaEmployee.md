NOTE:
Each should be a SEPARATE feature file when copied into Cucumber.
This is just all on one file for the markdown

Feature: Employees of our reimbursement application should be able to log in to their personal employee homepage

    Scenario: As an employee, I want to sign in so I can view my custom homepage

        Given: the employee is on the login page
        When: the employee enters in their correct user name
        When: the employee enters in their correct password
        When: the employee clicks the login button
        Then: the employee should be logged into the employee homepage

Feature: Employees of our reimbursement application should be able to log out of their personal employee homepage

    Scenario: As an employee, I want to sign out so I can prevent others from accessing my information

        Given: the employee is on their personal employee homepage
        When: the employee clicks the logout button
        When: the employee confirms they want to logout
        Then: the employee should be logged out and returned back to the login homepage

Feature: Employees of our reimbursement application should be able to view their previous reimbursement requests

    Scenario: As an employee, I want to view my previous reimbursement requests so I can see whether to expect money back or not

        Given: the employee is on their personal employee homepage
        When: their personal employee homepage loads
        When: a table generates with their personal reimbursement request history
        Then: the employee should be able to view their previous reimbursement requests

Feature: Employees of our reimbursement application should be able to create a reimbursement request

    Scenario: As an employee, I want to create a reimbursement request so I can get money back I spent for the company

        Given: the employee is on their personal employee homepage
        When: the employee enters a new reimbursement request title
        When: the employee enters in a new reimbursement request amount
        When: the employee enters in a new reimbursement request description
        When: the employee presses submit
        Then: the employee should have created a new reimbursement request

