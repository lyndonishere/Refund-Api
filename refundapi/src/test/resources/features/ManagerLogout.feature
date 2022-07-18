Feature: Managers of our reimbursement application should be able to logout of their homepage

        Scenario: As a manager, I want to sign out so I can prevent others from accessing my information (POSITIVE)

                Given the manager is on their personal manager homepage
                When the manager clicks the logout button
                When the manager confirms they want to logout
                Then the manager should be logged out and returned back to the login homepage
        
        Scenario: If I do not confirm I want to logout, I should not logout successfully (NEGATIVE)

                Given the manager is on their personal manager homepage
                When the manager clicks the logout button
                When the manager does not confirm they want to logout
                Then the manager should stay on their current page.