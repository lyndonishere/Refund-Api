Feature: Managers of our reimbursement application should be able to deny reimbursement requessts

    Scenario: As a manager I want be able to deny reimbursement requests (POSITIVE) 

        Given the manager is on their personal manager homepage
        When the manager inputs a pending reimbursement request ID number
        When the manager inputs a reason description
        When the manager selects deny
        When the manager clicks submit
        Then the reimbursement request status should change from pending to denied 

    Scenario: Reimbursement request statuses should not change if they are not denied successfully (NEGATIVE) 

        Given the manager is on their personal manager homepage
        When the manager clicks submit
        Then the reimbursement request status should remain pending