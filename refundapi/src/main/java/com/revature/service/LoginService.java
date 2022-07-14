package com.revature.service;

import java.util.List;

import com.revature.entities.Login;
import com.revature.repository.LoginDAOInterface;

public class LoginService implements LoginServiceInterface {

    /*
     * Because my service class is gatekeeping for the repo layer, it needs to have some way of sending data that has been validated to the repo layer.
     * This is accomplished by using dependency injection: I create a field of the proper data access object interface, and then I used the constructor
     * at runtime to create the proper implementation object for said interface
     */
    private LoginDAOInterface loginDao;

    public LoginService(LoginDAOInterface loginDao){
        // the loginDao field is part of the object scope, so make sure to use the this keyword
        this.loginDao = loginDao;
    }

    @Override
    public boolean checkUsernameMatch(Login userToCheck) {

        /*
         * This method is checking to see if the book being entered/updated is following business rules: if it is, a true is returned because it is
         * following the rules and the data can be sent into the repo layer. If the book is not following business rules, a false is returned and the
         * data should NOT be sent to the repo layer
         */

        // make sure to use the equals method when comparing strings
        if(userToCheck.getUsername().equals("badusername")){        
            // !!!!!!! this logic is just checking if username matches "badusername", need to find a method to check matching
            return false;   // if the business rule is broken, we return false
        } else {
            return true;    // if the business rule is being followed, we return true
        }
    }

    @Override
    public Login serviceAddUser(Login newUser) {
        if(this.checkUsernameMatch(newUser)){
            return this.loginDao.addUser(newUser);
        } else {
            return null; // null is temporary       // we want an alert("Your username matches another user. Please contact IT for support.")
        }
    }

    @Override
    public List<Login> serviceGetAllUsers() {
        /*
         * Because there are no business rules assocaited with this service method, because we have already tested the getAllBooks method in the repo layer,
         * we can skip writing any unit tests for this service method and just return the results of the dao method
         */
        return this.loginDao.getAllUsers();
    }

    @Override
    public Login serviceUpdateUser(Login updatedUser) {
        if(this.checkUsernameMatch(updatedUser)){
            return this.loginDao.updateUser(updatedUser);
        } else {
            return null;
        }
    }

    @Override
    public boolean serviceRemoveUser(Login userToBeDeleted) {
        return this.loginDao.removeUser(userToBeDeleted);
    }
    
}
