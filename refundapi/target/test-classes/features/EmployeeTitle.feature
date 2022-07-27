Feature: Employees of our reimbursement application should add a 50 character maximum reimbursement request title

    Scenario: As an employee, I want to add a reimbursement request title so my request is more organized (POSITIVE)

        Given the employee is on their personal employee homepage
        When the employee enters in a 50 character maximum reimbursement request title
        When the employee enters in a new reimbursement request amount
        When the employee enters in a new reimbursement request description
        When the employee presses submit
        Then the employee should have created a new reimbursement request with a pending status
