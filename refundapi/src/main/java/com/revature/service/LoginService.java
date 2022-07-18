package com.revature.service;

import java.util.List;

import com.revature.entities.Login;
import com.revature.repository.LoginDAOInterface;
import com.revature.utils.LoginBusinessRules;

public class LoginService implements LoginServiceInterface {

    /*
     * Because my service class is gatekeeping for the repo layer, it needs to have some way of sending data that has been validated to the repo layer.
     * This is accomplished by using dependency injection: I create a field of the proper data access object interface, and then I used the constructor
     * at runtime to create the proper implementation object for said interface
     */
    private LoginDAOInterface loginDao;
    private LoginBusinessRules loginBusinessRules;

    public LoginService(LoginDAOInterface loginDao, LoginBusinessRules mockLoginRules){
        // the loginDao field is part of the object scope, so make sure to use the this keyword
        this.loginDao = loginDao;
    }

    @Override
    public Login serviceAddUser(Login newUser) {
        if(this.loginBusinessRules.checkUsernameMatch(newUser)){
            return this.loginDao.addUser(newUser);
        } else {
            return null; // null is temporary       // we want an alert("Your username matches another user. Please contact IT for support.")
        }
    }

    @Override
    public List<Login> serviceGetAllUsers() {
        /*
         * Because there are no business rules associated with this service method, because we have already tested the getAllBooks method in the repo layer,
         * we can skip writing any unit tests for this service method and just return the results of the dao method
         */
        return this.loginDao.getAllUsers();
    }

    @Override
    public Login serviceUpdateUser(Login updatedUser) {
        if(this.loginBusinessRules.checkUsernameMatch(updatedUser)){
            return this.loginDao.updateUser(updatedUser);
        } else {
            return null;
        }
    }

    @Override
    public boolean serviceRemoveUser(Login userToBeDeleted) {
        return this.loginDao.removeUser(userToBeDeleted);
    }
    
    /*
     * SEE THE SECTION BELOW TO GET EXAMPLES OF HOW MOCKING/STUBBING WORKS, AND HOW YOU CAN DO POSITIVE/NEGATIVE TESTS FOR YOUR SERVICE LAYER
     */

    /*
     * While your projects only require negative tests for any business logic, you service layer must validate. It is unreasonable to think that you will only
     * ever need to make negative tests in your service layer.
     * 
     * Any complex application will have multiple checks and possible return values in a service layer, and often times you will need to make positive/negative
     * tests for all the possibilities. This is where mocking comes into play.
     * 
     * Mocking is a process of creating classes that you control the return value of: by pre-determining the return values of methods you are not trying to test (this
     * is called stubbing), you can check specific pieces of functionality in your code, and therefore, create true unit tests in your service layer!
     */





}


