Feature: Employees of our reimbursement application should be able to log out of their personal employee homepage

    Scenario: As an employee, I want to sign out so I can prevent others from accessing my information (POSITIVE)

        Given the employee is on their personal employee homepage
        When the employee clicks the logout button
        When the employee confirms they want to logout
        Then the employee should be logged out and returned back to the login homepage
    
    Scenario: If I do not confirm I want to logout, I should not logout successfully (NEGATIVE)

        Given the employee is on their personal employee homepage
        When the employee clicks the logout button
        When the employee does not confirm they want to logout
        Then the employee should stay on their current page.