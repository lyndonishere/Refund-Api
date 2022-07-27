Feature: Employees of our reimbursement application should add a 500 character maximum reimbursement request description

    Scenario: As an employee, I want to add a reimbursement request description so my request is more organized (POSITIVE)

        Given the employee is on their personal employee homepage
        When the employee enters in a new reimbursement request title
        When the employee enters in a 500 character maximum reimbursement request description
        When the employee enters in a new reimbursement request amount
        When the employee presses submit
        Then the employee should have created a new reimbursement request with a pending status

    Scenario: I should be blocked from inputting more text if I try to enter a reimbursement request description over 500 characters (NEGATIVE)

        Given the employee is on their personal employee homepage
        When the employee tries to enter more than 500 characters in the reimbursement request description
        Then the employee should not be able to type any more characters in the description input box

    Scenario: I should receive an alert if I do not put a reimbursement request description (NEGATIVE)

        Given the employee is on their personal employee homepage
        When the employee enters in a new reimbursement request title
        When the employee enters in a new reimbursement request amount
        When the employee presses submit
        Then the employee should receive an alert that they need to enter a reimbursement description