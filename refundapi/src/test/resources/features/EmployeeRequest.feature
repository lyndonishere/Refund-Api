Feature: Employees of our reimbursement application should be able to create a reimbursement request

    Scenario: As an employee, I want to create a reimbursement request so I can get money back I spent for the company (POSITIVE)

        Given the employee is on their personal employee homepage
        When the employee enters in a new reimbursement request title
        When the employee enters in a new reimbursement request amount
        When the employee enters in a new reimbursement request description
        When the employee presses submit
        Then the employee should have created a new reimbursement request with a pending status
