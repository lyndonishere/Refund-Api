Feature: Manager of our reimbursement application should be able to view all employee reimbursement requests

    Scenario: As a manager, I want to view all employee reimbursement requests so I can see if I need to approve or deny requests (POSITIVE)

        Given the manager is on their personal manager homepage
        When their personal manager homepage loads
        When a table generates with employee reimbursement requests
        Then the manager should be able to view employee reimbursement requests

     Scenario: I should receive an alert if my I cannot view employee reimbursement requests (NEGATIVE)

        Given the manager is on their personal manager homepage
        When their personal manager homepage loads
        When a table does not generate with employee reimbursement requests
        Then the manager should receive an alert that there are no reimbursement requests available