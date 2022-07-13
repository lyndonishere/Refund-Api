package com.revature.repository;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.entities.Login;

public class LoginTests {
    
    // here is where I am going to test my LoginDAO

    // I declared the type as an Interface here...
    public static LoginDAOInterface loginDao;

    @BeforeClass
    public static void setup(){
        // ...but I initialized the field as a LoginDAO object here
        // this is called coding to the interface: it makes our code more modular and easier to adjust if necessary
        loginDao = new LoginDAO();
    }

    @Test   // make sure to add this @Test annotation
    public void addUserPositiveTest(){   // this is a positive test, so I note it in the test name
        Login testLogin = new Login("test username", "test user password", "test person name", "test user role");
        Login result = loginDao.addUser(testLogin);
        Assert.assertNotNull(result.getId());
    }
}
