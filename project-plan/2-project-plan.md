# Project Plan (ROUGH)

This is a rough draft for our project of everything we've been doing. The 1-test-plan is the better version lol

GOAL: Create an employee reimbursement application

We need to build a full-stack application, so:
- Create UI framework (html/css/javascript)
    - Login page
    - Manager page
    - Employee page
    *NOTE: refer to wireframes for structure, elements, and layout
- Build a dynamic Java/SQL database
    - Set up an AWS database
    - Create a database connection in DBeaver
    - Dynamically add/edit/delete/etc. database with Java (follow Hibernate Demo)
- Connect UI to Java/SQL database (following API examples essentially)
    - When you interact with HTML pages, it should update the SQL database
    - We still need to learn Javalin, Thundercat Client, and Postman
- Create Cucumber/Selenium automated tests
    - Should test all acceptance criteria pass
    - Need to do unit, service, and E2E tests
- Present our project


- Create our test documentation
    - Wireframes (DONE)
    - Acceptance Criteria (DONE)
        - Manager Acceptance Criteria (DONE)
        - Employee Acceptance Criteria (DONE)
        - Business Rules Need to Have Acceptance Criteria (DONE)
        - Organized into 14 features, each feature with a positive and negative test scenario
    - Test Plan
        - keeps track of required technologies
        - start writing test cases
        - Should include all of the planned test cases
        - Test cases should be organized into test suites
        - Unit testing assignments should be dictated here
    - Basic Requirement Traceability Matrix
        - Keeps track of testing/development process
        - Lists who is working on what
        - Used to keep track of what has been accomplished
            - Used to track bugs and blockers
            - Used to see where a team member might need help

Testing Requirements
- Unit testing
    - Repository layer
        - all methods must have one positive test
    - Service Layer
        - all methods must have one negative test per business rule enforced
            - use Mockito to stub the methods for your tests
- Integration testing
    - API
        - all routes must have one positive test
        - all routes must have a negative test for each business rule
- End to End Testing
    - all acceptance criteria must be tested via Cucumber and Selenium


Timeline:
- 7/12 - 7/15
    - Create wireframes (DONE)
    - Turn user stories into acceptance criteria (DONE)
    - Create basic requirement traceability matrix (DONE)
    - Create test plan document
    - Create database with correct tables
    - Confirm project can successfully connect to the database
    - Write unit tests for repo and service layer of application
    - Start implementing repo and service layer interfaces to pass unit tests
- 7/18 - 7/22
    - All repo and service unit tests should be implemented
    - All repo and service interfaces should be implemented to pass unit tests
    - Work should be started on project API
        - Javalin should be utilized
        - Thundercat Client or Postman should be used to handle integration tests for the API
    - Work should be started on project UI
        - Use basic html/css/javascript
    - E2E tests should be designed
        - Use the Server Mocking capabilities of Postman to get a head start on E2E tests
- 7/25 - 7/28
    - API should be finished
    - E2E tests should be finished
    - Final debugging should be finished by end of day 7/28, ideally on 7/27
    - Code freeze should be implemented on 7/28 (no more editing code)
    - Practice presentation 2-3 times to hit your 10 minute mark
    - Make sure final documentation is prepared
- 7/29
    - Project presentations today!