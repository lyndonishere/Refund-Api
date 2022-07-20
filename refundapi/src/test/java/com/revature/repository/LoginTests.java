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

         Login setupUpdateUser = new Login(-3, "to be updated username", "to be updated password", "to be updated person name", "to be updated user role");
         loginDao.updateUser(setupUpdateUser);

    }

    @Test   // make sure to add this @Test annotation
    public void addUserPositiveTest(){   // this is a positive test, so I note it in the test name
        Login testLogin = new Login("test username", "test user password", "test person name", "test user role");
        Login result = loginDao.addUser(testLogin);
        Assert.assertNotNull(result.getId());
    }

    @Test
    public void updateUsersPositiveTest(){
        Login updatedUser = new Login(-3, "updated", "updated", "updated", "updated");
        Login result = loginDao.updateUser(updatedUser);
        Assert.assertEquals("updated", result.getUsername());
    }

    @Test
    public void getAllUsersPositiveTest(){
        List<Login> loginList = loginDao.getAllUsers();
        Assert.assertTrue(loginList.size() >= 2);
    }

    @Test
    public void removeUserPositiveTest(){
        Login userToBeDeleted = new Login(-4, "to be deleted username", "to be deleted password", "to be deleted person name", "to be deleted user role");
        loginDao.addUser(userToBeDeleted);  // tech this is not a TRUE unit test with this, but it is making it so we don't have to manually add in the above user every time. it tested correctly before adding user
        boolean result = loginDao.removeUser(userToBeDeleted);
        Assert.assertTrue(result);
    }

}
