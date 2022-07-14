package com.revature.service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.entities.Login;
import com.revature.repository.LoginDAO;
import com.revature.repository.LoginDAOInterface;

public class LoginServiceTests {
    
    public static LoginDAOInterface loginDao;
    public static LoginServiceInterface loginService;

    /*
     * This is a negative test because we are checking that our service method correctly identifies that a business rule is being broken and responds
     * with the appropriate return valur
     */
    @BeforeClass
    public static void setup(){
        loginDao = new LoginDAO();
        loginService = new LoginService(loginDao);
    }

    @Test
    public void checkUsernameMatchNegativeTest(){
        Login badUser = new Login("badusername", "bad password", "bad person name", "bad user role");
        boolean result = loginService.checkUsernameMatch(badUser);
        Assert.assertFalse(result);
    }

    /*
     * This is a positive test because we are checking that our service method correctly identifies that all relevant business rules are being adhered
     * to and responds with the appropriate return value
     */

    @Test
    public void checkUsernameMatchPositiveTest(){
        Login goodUser = new Login("goodusername", "good password", "good person name", "good user role");
        boolean result = loginService.checkUsernameMatch(goodUser);
        Assert.assertTrue(result);
    }
}
