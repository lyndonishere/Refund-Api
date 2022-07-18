Feature: Managers of our reimbursement application should be able to log in to their personal manager homepage

    Scenario:   As a manager I want to login in so I can view my custom homepage (POSITIVE)

        Given:  the manager is on the login page
        When:   the manager enters their correct username
        When:   the manager enters their correct password
        When:   the manager clicks the login button
        Then:   the manager should be logged in to their manager home page

    Scenario: As a manager, I want to receive an alert if I login with the incorrect credentials (NEGATIVE)

        Given: the manager is on the login page
        When: the manager enters in their incorrect user name
        When: the manager enters in their incorrect password
        When: the manager clicks the login button
        Then: the manager should be receive an alert that their credentials are incorrect.


Feature: Managers of our reimbursement application should be able to approve reimbursement requests

    Scenario: As a manager I want be able to approve reimbursement requests (POSITIVE) 

        Given: the manager is on the manager page
        When: the manger views the reimbursement requests
        When: the manager inputs a pending reimbursement request ID number
        When: the manager inputs a reason description
        When: the manager selects approve
        When: the manager clicks submit
        Then: the reimbursement request status should change from pending to approved 

    Scenario: Reimbursement request statuses should not change if they are not approved successfully (NEGATIVE) 

        Given: the manager is on the manager page
        When: the manger views the reimbursement requests
        When: the manager clicks submit
        Then: the reimbursement request status should not change from pending to approved


Feature: Managers of our reimbursement application should be able to deny reimbursement requessts

    Scenario: As a manager I want be able to deny reimbursement requests (POSITIVE) 

        Given: the manager is on the manager page
        When: the manger views the reimbursement requests
        When: the manager inputs a pending reimbursement request ID number
        When: the manager inputs a reason description
        When: the manager selects deny
        When: the manager clicks submit
        Then: the reimbursement request status should change from pending to denied 

    Scenario: Reimbursement request statuses should not change if they are not denied successfully (NEGATIVE) 

        Given: the manager is on the manager page
        When: the manger views the reimbursement requests
        When: the manager clicks submit
        Then: the reimbursement request status should not change from pending to denied



Feature: Managers of our reimbursement application should be able to logout of their homepage

        Scenario: As a manager, I want to sign out so I can prevent others from accessing my information (POSITIVE)

                Given: the manager is on their personal manager homepage
                When: the manager clicks the logout button
                When: the manager confirms they want to logout
                Then: the manager should be logged out and returned back to the login homepage
        
        Scenario: If I do not confirm I want to logout, I should not logout successfully (NEGATIVE)

                Given: the manager is on their personal manager homepage
                When: the manager clicks the logout button
                When: the manager does not confirm they want to logout
                Then: the manager should stay on their current page.


Feature: Manager of our reimbursement application should be able to view all employee reimbursement requests

    Scenario: As a manager, I want to view all employee reimbursement requests so I can see if I need to approve or deny requests (POSITIVE)

        Given: the manager is on their personal manager homepage
        When: their personal manager homepage loads
        When: a table generates with employee reimbursement requests
        Then: the manager should be able to view employee reimbursement requests

     Scenario: I should receive an alert if my I cannot view employee reimbursement requests (NEGATIVE)

        Given: the manager is on their personal manager homepage
        When: their personal manager homepage loads
        When: a table does not generate with employee reimbursement requests
        Then: the manager should receive an alert that there are no reimbursement requests available

Feature: Managers of our reimbursement application should add a 500 character maximum reimbursement request reason description

    Scenario: As a manager, I want to add a reimbursement request reason description so I can tell my employee why I approved or denied their request (POSITIVE)

        Given: the manager is on their personal manager homepage
        When: the manger views the reimbursement requests
        When: the manager inputs a pending reimbursement request ID number
        When: the manager inputs in a 500 character maximum reimbursement request reason description
        When: the manager selects accept
        When: the manager clicks submit
        Then: the manager should have approved a request alongside a reason

    Scenario: I should be blocked from inputting more text if I try to enter a reimbursement request reason description over 500 characters (NEGATIVE)

        Given: the manager is on their personal manager homepage
        When: the manager tries to enter more than 500 characters in the reimbursement request reason description
        Then: the manager should not be able to type any more characters in the input box

    Scenario: I should receive an alert if I do not put a reimbursement request reason description (NEGATIVE)

        Given: the manager is on their personal manager homepage
        When: the manager views the reimbursement requests
        When: the manager inputs a pending reimbursement request ID number
        When: the manager selects accept
        When: the manager clicks submit
        Then: the manager should receive an alert that they need to enter a reimbursement reason description