Feature:    Managers of the Refund - API should be able to login to access their home page

    Scenario:   As a manager I want to login in so I can view my custom homepage

        Given:  the manager is on the login page
        When:   the manager enters his correct username
        When:   the manager enters his correct password
        When:   the employee clicks the login button
        Then:   the manager should be logged in to the manager home page

    Scenario:   As a manager I want be on my home page so as to perform duties 

        Given:  the manager is on the manager page
        When:   the manger views the Reimbursement requests
        When:   the manager has approved the Reimbursement requests
        When:   the manager has denied the Reimbursement requests
        Then:   the manager should be able to log out of the manager page successfully 
