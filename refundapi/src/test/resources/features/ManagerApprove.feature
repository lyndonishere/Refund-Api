Feature: Managers of our reimbursement application should be able to approve reimbursement requests

    Scenario: As a manager I want be able to approve reimbursement requests (POSITIVE) 

        Given the manager is on their personal manager homepage
        When the manager inputs a pending reimbursement request ID number
        When the manager inputs a reason description
        When the manager selects approve
        When the manager clicks submit
        Then the reimbursement request status should change from pending to approved 
