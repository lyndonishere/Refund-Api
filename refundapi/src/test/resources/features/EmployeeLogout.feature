Feature: Employees of our reimbursement application should be able to log out of their personal employee homepage

    Scenario: As an employee, I want to sign out so I can prevent others from accessing my information (POSITIVE)

        Given the employee is on their personal employee homepage and ready to logout
        When the employee clicks the logout button and confirm they want to logout
        Then the employee should be logged out and returned back to the login homepage