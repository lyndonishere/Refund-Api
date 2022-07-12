Feature:    Managers of the Refund - API should be able to login to access 
            their home page

    Scenario:   As a manager I want to login in so I can view my custom homepage

        Given:  the manager is on the login page
        When:   the manager enters his correct username
        When:   the manager enters his correct password
        When:   the manager clicks the login button
        Then:   the manager should be logged in to the manager home page


Feature:    Managers of the Refund - API should be able to approve to access 
            their home page


    Scenario:   As a manager I want be able to approve Reimbursement requests 

        Given:  the manager is on the manager page
        When:   the manger views the Reimbursement requests
        When:   the manager analyses the Reimbursement requests
        Then:   the manager should be able to approve the Reimbursement requests 


Feature:    Managers of the Refund - API should be able to deny to access 
            their home page 


    Scenario:   As a manager I want be able to deny Reimbursement requests 

        Given:  the manager is on the manager page
        When:   the manger views the Reimbursement requests
        When:   the manager analyses the Reimbursement requests
        Then:   the manager should be able to deny the Reimbursement requests



Feature:    Managers of the Refund - API should be able to logout to access 
            their home page


    Scenario:   As a manager I want to logout of the home page so as tp prevent
                others from sccessing my

        Given:  the manager is on the home page
        When:   the manager has finished has apporoved Reimbursement requests
        When:   the manager has finished has denied Reimbursement requests
        When:   the manager clicks the logout button
        Then:   the manager should be logged out of the manager home page

