NOTE:
Each should be a SEPARATE feature file when copied into Cucumber.
This is just all on one file for the markdown

Feature: Employees of our reimbursement application should be able to log in to their personal employee homepage

    Scenario: As an employee, I want to sign in so I can view my custom homepage when I enter the correct credentials (POSITIVE)

        Given: the employee is on the login page
        When: the employee enters in their correct user name
        When: the employee enters in their correct password
        When: the employee clicks the login button
        Then: the employee should be logged into the employee homepage

    Scenario: As an employee, I want to receive an alert if I login with the incorrect credentials (NEGATIVE)

        Given: the employee is on the login page
        When: the employee enters in their incorrect user name
        When: the employee enters in their incorrect password
        When: the employee clicks the login button
        Then: the employee should be receive an alert that their credentials are incorrect.

Feature: Employees of our reimbursement application should be able to log out of their personal employee homepage

    Scenario: As an employee, I want to sign out so I can prevent others from accessing my information (POSITIVE)

        Given: the employee is on their personal employee homepage
        When: the employee clicks the logout button
        When: the employee confirms they want to logout
        Then: the employee should be logged out and returned back to the login homepage
    
    Scenario: If I do not confirm I want to logout, I should not logout successfully (NEGATIVE)

        Given: the employee is on their personal employee homepage
        When: the employee clicks the logout button
        When: the employee does not confirm they want to logout
        Then: the employee should stay on their current page.

Feature: Employees of our reimbursement application should be able to only view their previous reimbursement requests

    Scenario: As an employee, I want to view my previous reimbursement requests so I can see whether to expect money back or not (POSITIVE)

        Given: the employee is on their personal employee homepage
        When: their personal employee homepage loads
        When: a table generates with their personal reimbursement request history
        Then: the employee should be able to view their previous reimbursement requests

     Scenario: I should receive an alert if my I cannot view my reimbursement requests (NEGATIVE)

        Given: the employee is on their personal employee homepage
        When: their personal employee homepage loads
        When: a table does not generate with their personal reimbursement request history
        Then: the employee should receive an alert that there are no reimbursement requests available

Feature: Employees of our reimbursement application should be able to create a reimbursement request

    Scenario: As an employee, I want to create a reimbursement request so I can get money back I spent for the company (POSITIVE)

        Given: the employee is on their personal employee homepage
        When: the employee enters a new reimbursement request title
        When: the employee enters in a new reimbursement request amount
        When: the employee enters in a new reimbursement request description
        When: the employee presses submit
        Then: the employee should have created a new reimbursement request with a pending status

    Scenario: I should receive an alert if my reimbursement request was not made successfully (NEGATIVE)

        Given: the employee is on their personal employee homepage
        When: the employee does not enter in a new reimbursement request title
        When: the employee does not enter in a new reimbursement request amount
        When: the employee does not enter in a new reimbursement request description
        When: the employee presses submit
        Then: the employee should receive an alert that their request could not be made

Feature: Employees of our reimbursement application should add a 50 character maximum reimbursement request title

    Scenario: As an employee, I want to add a reimbursement request title so my request is more organized (POSITIVE)

        Given: the employee is on their personal employee homepage
        When: the employee enters in a 50 character maximum reimbursement request title
        When: the employee enters in a new reimbursement request amount
        When: the employee enters in a new reimbursement request description
        When: the employee presses submit
        Then: the employee should have created a new reimbursement request with a pending status

    Scenario: I should be blocked from inputting more text if I try to enter a reimbursement request title over 50 characters (NEGATIVE)

        Given: the employee is on their personal employee homepage
        When: the employee tries to enter more than 50 characters in the reimbursement request title
        Then: the employee should not be able to type any more characters in the input box

    Scenario: I should receive an alert if I do not put a reimbursement request title (NEGATIVE)

        Given: the employee is on their personal employee homepage
        When: the employee enters in a new reimbursement request amount
        When: the employee enters in a new reimbursement request description
        When: the employee presses submit
        Then: the employee should receive an alert that they need to enter a reimbursement title

Feature: Employees of our reimbursement application should add a 500 character maximum reimbursement request description

    Scenario: As an employee, I want to add a reimbursement request description so my request is more organized (POSITIVE)

        Given: the employee is on their personal employee homepage
        When: the employee enters in a new reimbursement request title
        When: the employee enters in a 500 character maximum reimbursement request description
        When: the employee enters in a new reimbursement request amount
        When: the employee presses submit
        Then: the employee should have created a new reimbursement request with a pending status

    Scenario: I should be blocked from inputting more text if I try to enter a reimbursement request description over 500 characters (NEGATIVE)

        Given: the employee is on their personal employee homepage
        When: the employee tries to enter more than 500 characters in the reimbursement request description
        Then: the employee should not be able to type any more characters in the input box

    Scenario: I should receive an alert if I do not put a reimbursement request description (NEGATIVE)

        Given: the employee is on their personal employee homepage
        When: the employee enters in a new reimbursement request title
        When: the employee enters in a new reimbursement request amount
        When: the employee presses submit
        Then: the employee should receive an alert that they need to enter a reimbursement description

Feature: Employees of our reimbursement application should add a request amount up to $1000 in a request

    Scenario: As an employee, I want to add a reimbursement request amount so I can inform my manager how much I'd like to be reimbursed (POSITIVE)

        Given: the employee is on their personal employee homepage
        When: the employee enters in a new reimbursement request title
        When: the employee enters in a new request description
        When: the employee enters in a new reimbursement request amount up to $1000
        When: the employee presses submit
        Then: the employee should have created a new reimbursement request with a pending status

    Scenario: I should receive an alert if I try to enter a reimbursement request description over $100 (NEGATIVE)

        Given: the employee is on their personal employee homepage
        When: the employee tries to enter more than $1000 characters in the reimbursement request amount
        Then: the employee should receive an alert that they cannot enter more than $1000 in the reimbursement request amount

    Scenario: I should receive an alert if I do not put a reimbursement request amount (NEGATIVE)

        Given: the employee is on their personal employee homepage
        When: the employee enters in a new reimbursement request title
        When: the employee enters in a new reimbursement request description
        When: the employee presses submit
        Then: the employee should receive an alert that they need to enter a reimbursement amount