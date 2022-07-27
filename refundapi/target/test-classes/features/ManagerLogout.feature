Feature: Managers of our reimbursement application should be able to logout of their homepage

        Scenario: As a manager, I want to sign out so I can prevent others from accessing my information

                Given the manager is on their personal manager homepage and ready to logout
                When the manager clicks the logout button and confirms they want to logout
                Then the manager should be logged out and returned back to the login homepage