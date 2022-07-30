package com.revature.service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.revature.entities.Login;
import com.revature.repository.LoginDAO;
import com.revature.repository.LoginDAOInterface;
import com.revature.utils.LoginBusinessRules;

public class LoginServiceTests {
    
    public static LoginDAOInterface loginDao;
    public static LoginServiceInterface loginService;
    public static LoginBusinessRules loginBusinessRules;

    /*
     * The fields below are going to be ued for our mock tests: we will use Mockito create mock objects of the DAO and rules classes in order to be able to
     * pre-determine their method results in order to perform both positive and negative tests for the service methods
     */
    public static LoginDAOInterface mockLoginDao;
    public static LoginBusinessRules mockLoginRules;
    public static LoginServiceInterface loginServiceWithMocks;


    @BeforeClass
    public static void setup(){

        /*
         * If we were to use these three fields our service tests would be integration tests: the database would need to be set up with the correct test data,
         * the business rules would need to be implemented correctly, and we would need to reset that data every time. This is not a bad thing, but not the best
         * 
         */

        // loginDao = new LoginDAO();
        loginBusinessRules = new LoginBusinessRules();
        // loginService = new LoginService(loginDao, loginBusinessRules);

        // the mock() method creates a mock object we can control
        mockLoginDao = Mockito.mock(LoginDAO.class); // creates a mock dao object we can control
        mockLoginRules = Mockito.mock(LoginBusinessRules.class); // this creates a mock rules object we can control
        loginServiceWithMocks = new LoginService(mockLoginDao, mockLoginRules);

    }

    /*
     * This is a positive test because we are checking that our service method correctly identifies that all relevant business rules are being adhered
     * to and responds with the appropriate return value
     */

    @Test
    public void checkUsernameMatchPositiveTest(){ // this test is saying that the user put into here DOESN'T match what is in the database. it does not break biz rules
        Login nonMatchUser = new Login("nonmatch");
        boolean result = loginBusinessRules.checkUsernameMatch(nonMatchUser, "spongebob");
        Assert.assertTrue(result); // assert true because it is true and does NOT break biz rules
    }
// make for loop to go through all // for login check full string credentials
    @Test
    public void checkUsernameMatchNegativeTest(){ // this test is negative because it DOES break biz rules. spongebob is already in the databae
        Login matchUser = new Login("spongebob");
        boolean result = loginBusinessRules.checkUsernameMatch(matchUser, "spongebob");
        Assert.assertFalse(result); // assert false because it is false and DOES break biz rules
    }

    @Test   // this means that my login credentials DO match login credentials in the system
    public void checkLoginCredentialsPositiveTest(){
        Login successUser = new Login("spongebob", "krabbypatties");
        boolean result = loginBusinessRules.checkLoginCredentials(successUser, "spongebob", "krabbypatties");
        Assert.assertTrue(result);
    }

    @Test // this means that NEITHER of my login credentials match login credentials in the system
    public void checkLoginCredentialsNegativeTestBoth(){
        Login unsuccessUser = new Login("incorrectUsername", "incorrectPassword");
        boolean result = loginBusinessRules.checkLoginCredentials(unsuccessUser,"spongebob", "krabbypatties");
        Assert.assertFalse(result);
    }

    @Test // this means that my USERNAME of my login credentials DOES NOT match login credentials in the system
    public void checkLoginCredentialsNegativeTestUsername(){
        Login unsuccessUsername = new Login("incorrectUsername", "krabbypatties");
        boolean result = loginBusinessRules.checkLoginCredentials(unsuccessUsername,"spongebob", "krabbypatties");
        Assert.assertFalse(result);
    }

    @Test // this means that my PASSWORD of my login credentials DOES NOT match login credentials in the system
    public void checkLoginCredentialsNegativeTestPassword(){
        Login unsuccessPassword = new Login("spongebob", "incorrect password");
        boolean result = loginBusinessRules.checkLoginCredentials(unsuccessPassword, "spongebob", "krabbypatties");
        Assert.assertFalse(result);
    }
}

    /*
     * THE TESTS BELOW ARE TO SHOW OFF MOCKING AND STUBBING
     * 
     * At the moment, these tests below are integration tests because they require 1 or more methods to work in order for the tests to pass. 
     * for (Login loginInfo : storedLogins){
        if (checkUsernameMatch(loginProvided, loginInfo.getUsername){
        ...}

     * 
     * VOCAB:
     * 
     * Mock: a fake object that you can use to control return values of associated methods
     * Stub: a faked return value
     */

     // don't need add user and update user: future stretch goals/sprints

//    @Test
//     public void mockExampleAddUserPositive(){   // i am successfully adding a user to the database
//         Login goodUser = new Login("add user", "password", "person name", "user role");
//         /*
//          * This is a positive test, so we know that the business rule needs to return true, and the dao needs to return the book with a newly minted ID number.
//          * We need to tell our mocked objects to do just that
//          * 
//          * When() is the method used to determine what mock object and associated method is being faked
//          * thenReturn() is the method used to determine what the return value is for our faked method
//          */
//         Mockito.when(mockLoginRules.checkUsernameMatch(goodUser, "spongebob")).thenReturn(true); // i am comparing the new username to an actual username to see if it matche
//         Mockito.when(mockLoginDao.addUser(goodUser)).thenReturn(new Login(-2, "add user", "password", "person name", "user role"));
        
//         Login result = loginServiceWithMocks.serviceAddUser(goodUser);
//         Assert.assertNotNull(result.getId());
//     }

    /*
     * When testing for exceptions, an easy way to validate you have the correct exception is to check that the exception message is correct. You will need to use a
     * try/catch block for this
     */

//    @Test
//     public void mockExampleAddUserNegative(){
//         try {
//             Login badUser = new Login("spongebob", "bad password", "bad person name", "bad user role");
//             /* for this negative test i dont need to mock the results of the dao because the dao should never be reached with this test */
//             Mockito.when(mockLoginRules.checkUsernameMatch(badUser, "spongebob")).thenReturn(false);
//             Login result = loginServiceWithMocks.serviceAddUser(badUser);
//             // if no exception is thrown by the serviceCreateBook method, then the line below will make our test fail
//             Assert.fail();
//         } catch(InvalidUser e) {
//             // here we check that we get both the exception and correct message
//             Assert.assertEquals("Invalid user: please try again", e.getMessage());
//         }
//     }

//    @Test
//     public void mockExampleUpdateUserPositive(){
//         Login goodUser = new Login(0, "goodusername", "good password", "good person name", "good user role");

//         Mockito.when(mockLoginRules.checkUsernameMatch(goodUser, "spongebob")).thenReturn(true);
//         Mockito.when(mockLoginDao.updateUser(goodUser)).thenReturn(goodUser);

//         Login result = loginServiceWithMocks.serviceUpdateUser(goodUser);
//         Assert.assertEquals("goodusername", result.getUsername());

//     } 

//     @Test
//     public void mockExampleUpdateUserNegative(){
//         try {
//             Login badUser = new Login("spongebob", "bad password", "bad person name", "bad user role");

//             Mockito.when(mockLoginRules.checkUsernameMatch(badUser, "spongebob")).thenReturn(true);
//             Mockito.when(mockLoginDao.updateUser(badUser)).thenReturn(badUser);

//             Login result = loginServiceWithMocks.serviceUpdateUser(badUser);
//             Assert.fail();
//         } catch(InvalidUser e) {
//             // getMessage() method comes from the parent Exception class
//             Assert.assertEquals("Invalid user: please try again", e.getMessage());
//         }

