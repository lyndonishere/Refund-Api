Feature: Managers of our reimbursement application should add a 500 character maximum reimbursement request reason description

    Scenario: As a manager, I want to add a reimbursement request reason description so I can tell my employee why I approved or denied their request (POSITIVE)

        Given the manager is on their personal manager homepage
        When the manager views the reimbursement requests
        When the manager inputs a pending reimbursement request ID number
        When the manager inputs in a 500 character maximum reimbursement request reason description
        When the manager selects approve
        When the manager clicks submit
        Then the manager should have approved a request alongside a reason

    Scenario: I should be blocked from inputting more text if I try to enter a reimbursement request reason description over 500 characters (NEGATIVE)

        Given the manager is on their personal manager homepage
        When the manager tries to enter more than 500 characters in the reimbursement request reason description
        Then the manager should not be able to type any more characters in the input box

    Scenario: I should receive an alert if I do not put a reimbursement request reason description (NEGATIVE)

        Given the manager is on their personal manager homepage
        When the manager views the reimbursement requests
        When the manager inputs a pending reimbursement request ID number
        When the manager selects approve
        When the manager clicks submit
        Then the manager should receive an alert that they need to enter a reimbursement reason description