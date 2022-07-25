package com.revature.repository;

import java.util.List;

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

        /*
         * Once I know that my methods are working, I can add them to my setup method to programatically set up my tests:
         * Hibernate is successfully setting up updating user for us programatically, but we still need to manually add in user for delete
         * 
         */

         Login setupUpdateUser = new Login(-1, "squinkward", "clairnet", "Squidward Tennisballs", "manager");
         loginDao.updateUser(setupUpdateUser);

    }

    // note: the add user test is not following service rule to make sure username added doesn't add duplicate user bcuz this is separate test of just adding a user
    @Test   // make sure to add this @Test annotation
    public void addUserPositiveTest(){   // this is a positive test, so I note it in the test name
        Login testLogin = new Login("patrick", "donuts", "Patrick Star", "employee");
        Login result = loginDao.addUser(testLogin);
        Assert.assertNotNull(result.getId());
    }

    @Test
    public void updateUsersPositiveTest(){
        Login updatedUser = new Login(-1, "squidward", "clarinet", "Squidward Tentacles", "employee");
        Login result = loginDao.updateUser(updatedUser);
        Assert.assertEquals("squidward", result.getUsername());
    }

    @Test
    public void getAllUsersPositiveTest(){
        List<Login> loginList = loginDao.getAllUsers();
        Assert.assertTrue(loginList.size() >= 2);
    }

    @Test
    public void removeUserPositiveTest(){
        Login userToBeDeleted = new Login(-3, "plankton", "givemeformula", "Sheldon J. Plankton", "employee");
        loginDao.addUser(userToBeDeleted);  // tech this is not a TRUE unit test with this, but it is making it so we don't have to manually add in the above user every time. it tested correctly before adding user
        boolean result = loginDao.removeUser(userToBeDeleted);
        Assert.assertTrue(result);
    }

}
