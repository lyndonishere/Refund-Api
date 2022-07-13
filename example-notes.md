- Have test plan
- Made wireframe

- entities tracker
    - books
        - id (int) (primary identifier)
        - title (string)
        - author (string)

user stories and associated unit/service tests
- under unit tests in test plan, eric made

as a user i want to take abook so i can read it
    UNIT TESTS (POSITIVE TESTS)
    - remove book from database
        - method: removeBook()
    - see available books in database
        - method: getAllBooks()
    SERVICE TESTS (NEGATIVE TESTS)
    - N/A

as a user i want to edit a book so i can correct a mistake
    UNIT TESTS (POSITIVE TESTS)
    - update book in database
        - method: updateBook()
    SERVICE TESTS (NEGATIVE TESTS)
    - J.R.R. Tolkien is not allowed
        - method: checkBookForTolkien()

as a user i want to give a book so i can give back to the community
    UNIT TESTS (POSITIVE TESTS)
    - add book to database
        - method: addBook()
    SERVICE TESTS (NEGATIVE TESTS)
    - books should have unique identifiers
        - method: addBook() --> database will handle this
    - J.R.R. Tolkien is not allowed
        - method: checkBookForTolkien()

need an assignment section too to assign tasks to each person



---------

write out acceptance criteria

write out feature file

reimbursement-kitties
username: keyboardkitties
password: ilikekitties

keyboard-kitties-access

our dbeaver database is now set up, we just need to add tables





we will make our http requests with javalin

http means take info from one location and send and interact with another layer
