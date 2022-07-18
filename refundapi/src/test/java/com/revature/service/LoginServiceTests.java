package com.revature.service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.revature.entities.Login;
import com.revature.exceptions.InvalidUser;
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

    @Test
    public void checkUsernameMatchNegativeTest(){
        Login badUser = new Login("badusername", "bad password", "bad person name", "bad user role");
        boolean result = loginBusinessRules.checkUsernameMatch(badUser);
        Assert.assertFalse(result);
    }

    /*
     * This is a positive test because we are checking that our service method correctly identifies that all relevant business rules are being adhered
     * to and responds with the appropriate return value
     */

    @Test
    public void checkUsernameMatchPositiveTest(){
        Login goodUser = new Login("goodusername", "good password", "good person name", "good user role");
        boolean result = loginBusinessRules.checkUsernameMatch(goodUser);
        Assert.assertTrue(result);
    }

    /*
     * THE TESTS BELOW ARE TO SHOW OFF MOCKING AND STUBBING
     * 
     * At the moment, these tests below are integration tests because they require 1 or more methods to work in order for the tests to pass.
     * 
     * VOCAB:
     * 
     * Mock: a fake object that you can use to control return values of associated methods
     * Stub: a faked return value
     */

   @Test
    public void mockExampleAddUserPositive(){
        Login goodUser = new Login("goodusername", "good password", "good person name", "good user role");
        /*
         * This is a positive test, so we know that the business rule needs to return true, and the dao needs to return the book with a newly minted ID number.
         * We need to tell our mocked objects to do just that
         * 
         * When() is the method used to determine what mock object and associated method is being faked
         * thenReturn() is the method used to determine what the return value is for our faked method
         */
        Mockito.when(mockLoginRules.checkUsernameMatch(goodUser)).thenReturn(true);
        Mockito.when(mockLoginDao.addUser(goodUser)).thenReturn(new Login(-2, "goodusername", "good password", "good person name", "good user role"));
        
        Login result = loginServiceWithMocks.serviceAddUser(goodUser);
        Assert.assertNotNull(result.getId());
    }

    /*
     * When testing for exceptions, an easy way to validate you have the correct exception is to check that the exception message is correct. You will need to use a
     * try/catch block for this
     */

   @Test
    public void mockExampleAddUserNegative(){
        try {
            Login badUser = new Login("badusername", "bad password", "bad person name", "bad user role");
            /* for this negative test i dont need to mock the results of the dao because the dao should never be reached with this test */
            Mockito.when(mockLoginRules.checkUsernameMatch(badUser)).thenReturn(false);
            Login result = loginServiceWithMocks.serviceAddUser(badUser);
            // if no exception is thrown by the serviceCreateBook method, then the line below will make our test fail
            Assert.fail();
        } catch(InvalidUser e) {
            // here we check that we get both the exception and correct message
            Assert.assertEquals("Invalid user: please try again", e.getMessage());
        }
    }

   @Test
    public void mockExampleUpdateUserPositive(){
        Login goodUser = new Login(0, "goodusername", "good password", "good person name", "good user role");

        Mockito.when(mockLoginRules.checkUsernameMatch(goodUser)).thenReturn(true);
        Mockito.when(mockLoginDao.updateUser(goodUser)).thenReturn(goodUser);

        Login result = loginServiceWithMocks.serviceUpdateUser(goodUser);
        Assert.assertEquals("goodusername", result.getUsername());

    } 

    @Test
    public void mockExampleUpdateUserNegative(){
        try {
            Login badUser = new Login("badusername", "bad password", "bad person name", "bad user role");
            Login result = loginServiceWithMocks.serviceUpdateUser(badUser);
            Assert.fail();
        } catch(InvalidUser e) {
            // getMessage() method comes from the parent Exception class
            Assert.assertEquals("Invalid user: please try again", e.getMessage());
        }

    } 
}
