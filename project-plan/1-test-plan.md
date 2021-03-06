# Test Plan

A test plan is a project-wide document with information specific to the project that it is attached to.

It:
- explains what technologies are being used
- deadlines
- what is actually being developed/tested
- other project specific info

This is a more organized version of 2-project-plan:

## Goal
Our goal is to create a full-stack Employee Reimbursement Application.

We will be creating a functional user interface that works with a dynamic database, and run automated tests of every level to ensure our application meets all of our sprint requirements.

Our deadline is 7/29.

## Technologies
- HTML
    - The backbone of our webpages
- CSS
    - Styles our webpages
- Javascript
    - Helps add dynamic features to our UI
    - Methods to work with API
- Java
    - Hibernate
        - Uses object-relational mapping to connect Java code with our SQL database
    - Cucumber-Junit
        - Testing framework that integrates with Cucumber
    - Cucumber
        - Testing framework to turn acceptance criteria into executable steps
    - Selenium
        - Browser automation tool
- SQL
    - AWS (RDS: PostgreSQL)
    - DBeaver
- Mockito
    - Can create mock objects so we can run service tests without affecting our database
- Javalin
    - Supports HTTP requests
- Thundercat Client
    - Can set up API
- Postman
    - Can set up API

## Sprint Backlog
These are all the user stories we need to complete to create a minimum viable product (MVP):

- Manager
    - Managers want to sign in so they can view their custom home page
    - Managers want to sign out so they can prevent others from accessing their information
    - Managers want to view reimbursement requests so they can begin addressing them
    - Managers want to approve or deny reimbursement requests so the company knows whether to pay out or not
- Employee
    - Employees want to sign in so they can view their custom home page
    - Employees want to sign out so they can prevent others from accessing their information
    - Employees want to create a reimbursement request so they can get money back that they spent for the company
    - Employees want to view previous reimbursement requests so they can see whether to expect money back or not
- Business
    - Employees
        - Employees must ONLY see their own reimbursement requests
        - Employees may only request up to $1000 per request
        - Employees must provide a reason for the reimbursement request no longer than 500 characters
    - Managers
        - Managers must provide a reason for approving or denying a reimbursement request no longer than 500 characters
    - Both
        - Usernames must be unique

## Required Documentation
A test policy document will be provided for us.

- Test Plan
    - This is our test plan
- Requirement Traceability Matrix
    - [This is the link to the Google Sheets](
https://docs.google.com/spreadsheets/d/1Ke8h42b2Zyedi_cq4acFyu1z83YQvTtp6nRNMTYnyRs/edit?usp=sharing)
- Acceptance Criteria
    - See Feature folder in refundapi Java folder
    - There is a positive AND negative test for each feature so we can make sure it's solid and bug-free

## Testing Requirements
See Sprint Backlog for what user stories we will be testing for, or look at Acceptance Criteria above.

- Unit Tests
    - "Repository Layer"
        - All methods must have a positive test
            - This is where we will take a single piece of the application's code logic and test it in isolation
            - The goal of this is to check the logic of the code we have written
    - "Service Layer"
        - All methods must have a negative test per business rule
            - We can use Mockito to stub the methods for these tests
            - This is where we will confirm that we have handled any business logic that has specifically been requested

- Integration Tests
    - API
        - All routes must have a positive test
            - NOTE: I believe each CRUD is a route, needs to be clarified
        - All routes must have a negative test per business rue

- End to End Tests
    - All acceptance criteria must be tested via Cucumber and Selenium
        - Look at each feature file within the refundapi java folder. You will see each feature has a positive scenario and a negative scenario. 
        - NOTE: We organized each user story into a separate feature file, and each feature file has 2-3 scenarios it will test for. This will help us see exactly which Manager and Employee user stories pass and fail.

    - Manager Features:
        - ManagerLogin.feature (E2E TEST)
            - Positive: (9.1) Scenario: Login with Correct Credentials (REPO LAYER)
                - 
            - Negative: (9.2) Scenario: Login with Incorrect Credentials (SERVICE LAYER)
        - ManagerLogout.feature (E2E TEST)
            - Positive: (10.1) Scenario: Logout Successful (REPO LAYER)
            - Negative: (10.2) Scenario: Logout Unsuccessful (SERVICE LAYER)
        - ManagerView.feature (E2E TEST)
            - Positive: (11.1) Scenario: Table of reimbursement requests shows successfully (REPO LAYER)
            - Negative: (11.2) Scenario: Manager receives an alert if table of reimbursement requests does not show successfully (SERVICE LAYER)
        - ManagerApprove.feature (E2E TEST)
            - Positive: (12.1) Scenario: Manager successfully changes reimbursement pending status to approved (REPO LAYER)
            - Negative: (12.2) Scenario: Reimbursement status does not change to approved (SERVICE LAYER)
        - ManagerDeny.feature (E2E TEST)
            - Positive: (13.1) Scenario: Manager successfully changes reimbursement pending status to denied (REPO LAYER)
            - Negative: (13.2) Scenario: Reimbursement status does not change to denied (SERVICE LAYER)

    - Employee Features:
        - EmployeeLogin.feature (E2E TEST)
            - Positive: (1.1) Scenario: Login with Correct Credentials (REPO LAYER)
            - Negative: (1.2) Scenario: Login with Incorrect Credentials (SERVICE LAYER)
        - EmployeeLogout.feature (E2E TEST)
            - Positive: (2.1) Scenario: Logout Successful (REPO LAYER)
            - Negative: (2.2) Scenario: Logout Unsuccessful (SERVICE LAYER)
        - EmployeeRequest.feature (E2E TEST)
            - Positive: (3.1) Scenario: Reimbursement request made successfully (new entry on reimbursement history table with a pending status) (REPO LAYER)
            - Negative: (3.2) Scenario: Employee receives alert if reimbursement request made unsuccessfully (SERVICE LAYER)
        - EmployeeView.feature (also a business feature) (E2E TEST)
            - Positive: (4.1) Scenario: Employee can view only their previous reimbursement requests (REPO LAYER)
            - Negative: (4.2) Scenario: Employee receives alert if cannot view previous reimbursement requests (SERVICE LAYER)
        - EmployeeTitle.feature (E2E TEST)
            - Positive: (5.1) Scenario: Employee adds a 50 character max description of reimbursement title (REPO LAYER)
            - Negative: (5.2) Scenario: Employees should be blocked from trying to put a title over 50 characters.  (SERVICE LAYER) 
                        (5.3) Scenario: Employee receives an alert if they don't put any title. (SERVICE LAYER)

    - Business Features:
        - EmployeeAmount.feature (E2E TEST)
            - Positive: (6.1) Scenario: Employee can request up to $1000 per request (REPO LAYER)
            - Negative: (6.2) Scenario: Employee receives an alert if trying to request over $1000 in a request. (SERVICE LAYER)
                        (6.3) Scenario: Employees receive an alert if they don't enter any amount for a reimbursement request (SERVICE LAYER)
        - EmployeeDesc.feature (E2E TEST)
            - Positive: (7.1) Scenario: Employee must provide a description of reimbursement reason up to 500 characters (REPO LAYER)
            - Negative: (7.2) Scenario: Employee should be blocked from trying to put a description of reimbursement reason over 500 characters. (SERVICE LAYER) 
                        (7.3) Scenario: Employee receives an alert if they don't put any description. (SERVICE LAYER)
        - EmployeeView.feature (also a regular employee feature) (E2E TEST)
            - Positive: (4.1) Scenario: Employee can view only their previous reimbursement requests (REPO LAYER)
            - Negative: (4.2) Scenario: Employee receives alert if cannot view previous reimbursement requests (SERVICE LAYER)
        - ManagerDesc.feature (E2E TEST)
            - Positive: (14.1) Scenario: Manager must provide a description of reimbursement approval or denial reason up to 500 characters (REPO LAYER)
            - Negative: (14.2) Scenario: Manager receives an alert if trying to put a description of reimbursement approval or denial reason over 500 characters. (SERVICE LAYER)
                        (14.3) Scenario: Manager receives an alert if they don't put any description. (SERVICE LAYER)
        - UsernameMatch.feature (E2E TEST)
            - Positive: (8.1) Scenario: No users have the same username (REPO LAYER)
            - Negative: (8.2) Scenario: User receives alert and cannot login if their username matches another (SERVICE LAYER)
            -  NOTE FROM ORIANA: Refactoring UsernameMatch feature so on login page you can register as a new user. This is where the username match business rule will be tested. This will be where the addUser() repo test can be, removeUser() if you want to delete your account, updateUser() if you need to change info can be. Maybe on the manager page they can pull all users up


## Brief Steps
See more elaborated steps in 3-step-by-step-tasks.

- Create UI framework with HTML
- Create AWS RDS
    - Set it up with PostgreSQL
    - Creator, make sure to write down username and password
    - Ensure to set up security rules
- Set up Hibernate with Java
- Connect Database to Java
- Connect UI to Java
- Make all of our user stories run
- Perform all of our tests manually
- Perform all of our tests automatically

## Timeline
- Week of 7/12 - 7/15
    - Create wireframes (DONE)
    - Turn user stories into acceptance criteria (DONE)
    - Create basic requirement traceability matrix (DONE)
    - Create test plan document (DONE *add on more as time goes on)
    - Create database with correct tables (DONE)
    - Confirm project can successfully connect to the database (DONE)
    - Write unit tests for repo and service layer of application (DONE)
    - Start implementing repo and service layer interfaces to pass unit tests

- Week of 7/18 - 7/22
    - All repo and service unit tests should be implemented
    - All repo and service interfaces should be implemented to pass unit tests
    - Work should be started on project API
        - Javalin should be utilized
        - Thundercat Client or Postman should be used to handle integration tests for the API
    - Work should be started on project UI
        - Use basic html/css/javascript
    - E2E tests should be designed
        - Use the Server Mocking capabilities of Postman to get a head start on E2E tests

- Week of 7/25 - 7/28
    - API should be finished
    - E2E tests should be finished
    - Final debugging should be finished by end of day 7/28, ideally on 7/27
    - Code freeze should be implemented on 7/28 (no more editing code)
    - Practice presentation 2-3 times to hit your 10 minute mark
    - Make sure final documentation is prepared
- 7/29
    - Project presentations today! (10 min)