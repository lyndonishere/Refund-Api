Feature: Employees of our reimbursement application should add a request amount up to $1000 in a request

    Scenario: As an employee, I want to add a reimbursement request amount so I can inform my manager how much I'd like to be reimbursed (POSITIVE)

        Given the employee is on their personal employee homepage
        When the employee enters in a new reimbursement request title
        When the employee enters in a new reimbursement request description
        When the employee enters in a new reimbursement request amount up to $1000
        When the employee presses submit
        Then the employee should have created a new reimbursement request with a pending status

    Scenario: I should receive an alert if I try to enter a reimbursement request description over $1000 (NEGATIVE)

        Given the employee is on their personal employee homepage
        When the employee tries to enter more than $1000 in the reimbursement request amount
        Then the employee should receive an alert that they cannot enter more than $1000 in the reimbursement request amount

    Scenario: I should receive an alert if I do not put a reimbursement request amount (NEGATIVE)

        Given the employee is on their personal employee homepage
        When the employee enters in a new reimbursement request title
        When the employee enters in a new reimbursement request description
        When the employee presses submit
        Then the employee should receive an alert that they need to enter a reimbursement amount