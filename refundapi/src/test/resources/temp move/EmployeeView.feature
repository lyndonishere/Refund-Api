Feature: Employees of our reimbursement application should be only able to view their previous reimbursement requests

    Scenario: As an employee, I want to only view my previous reimbursement requests so I can see whether to expect money back or not (POSITIVE)

        Given the employee is on their personal employee homepage
        When their personal employee homepage loads
        When a table generates with their personal reimbursement request history
        Then the employee should be able to view their previous reimbursement requests

     Scenario: I should receive an alert if my I cannot view my reimbursement requests (NEGATIVE)

        Given the employee is on their personal employee homepage
        When their personal employee homepage loads
        When a table does not generate with their personal reimbursement request history
        Then the employee should receive an alert that there are no reimbursement requests available