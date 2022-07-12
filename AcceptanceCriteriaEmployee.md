Feature:    Users of my Refund -API should be able to login to access their homepages


    Scenario:   As a manager I want to login in so I can view my custom homepage
        Given:  the manager is on the login page
        When:   the manager enters his correct username  
        When:   the manager enters his correct password
        When:   the manager clicks the login button
        Then:   the manager should be logged in to the manager home page

    Scenario:   As a manager I want perform my actions on the manager page amd log out successfully 
        Given:  the manager is on the manager home page
        When:   the manager views the Reimbursement requests 
        When:   the manager has aproved the Reimbursement requests
        When:   the manager has denied the Reimbursement requests
        Then:   the manager should be able to log out of his home page
