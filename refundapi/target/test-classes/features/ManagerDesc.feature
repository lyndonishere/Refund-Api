Feature: Managers of our reimbursement application should add a 500 character maximum reimbursement request reason description

    Scenario: As a manager, I want to add a reimbursement request reason description so I can tell my employee why I approved or denied their request (POSITIVE)

        Given the manager is on their personal manager homepage
        When the manager inputs a pending reimbursement request ID number
        When the manager inputs in a 500 character maximum reimbursement request reason description
        When the manager selects approve
        When the manager clicks submit
        Then the reimbursement request status should change from pending to approved
