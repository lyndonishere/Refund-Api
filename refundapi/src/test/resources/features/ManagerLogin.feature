Feature: Managers of our reimbursement application should be able to log in to their personal manager homepage

    Scenario:   As a manager I want to login in so I can view my custom homepage (POSITIVE)

        Given  the manager is on the login page
        When   the manager enters their correct username
        When   the manager enters their correct password
        When   the manager clicks the login button
        Then   the manager should be logged in to their manager home page

    Scenario: As a manager, I want to receive an alert if I login with the incorrect credentials (NEGATIVE)

        Given the manager is on the login page
        When the manager enters in their incorrect user name
        When the manager enters in their incorrect password
        When the manager clicks the login button
        Then the manager should receive an alert that their credentials are incorrect