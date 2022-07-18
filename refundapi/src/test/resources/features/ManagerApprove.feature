Feature: Managers of our reimbursement application should be able to approve reimbursement requests

    Scenario: As a manager I want be able to approve reimbursement requests (POSITIVE) 

        Given the manager is on the manager page
        When the manager views the reimbursement requests
        When the manager inputs a pending reimbursement request ID number
        When the manager inputs a reason description
        When the manager selects approve
        When the manager clicks submit
        Then the reimbursement request status should change from pending to approved 

    Scenario: Reimbursement request statuses should not change if they are not approved successfully (NEGATIVE) 

        Given the manager is on the manager page
        When the manager views the reimbursement requests
        When the manager clicks submit
        Then the reimbursement request status should remain pending