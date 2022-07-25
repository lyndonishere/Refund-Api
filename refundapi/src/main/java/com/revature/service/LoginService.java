package com.revature.service;

import java.util.List;

import com.revature.entities.Login;
import com.revature.exceptions.InvalidUser;
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

    public LoginService(LoginDAOInterface loginDao, LoginBusinessRules loginBusinessRules){
        // the loginDao field is part of the object scope, so make sure to use the this keyword
        this.loginDao = loginDao;
        this.loginBusinessRules = loginBusinessRules;
    }

    @Override
    public Login loginUser(Login loginUser) {
        List<Login> loginArray = this.loginDao.getAllUsers();
        for(int x = 0; x < loginArray.size(); x++ ){
            Login pulledUser = loginArray.get(x);
            if(this.loginBusinessRules.checkLoginCredentials(pulledUser, loginUser.getUsername(), loginUser.getUser_password())){
                loginUser.setUser_role(pulledUser.getUser_role());
                return loginUser;
            }
        }
        throw new InvalidUser("Incorrect login: please try again!");
    }
    
    @Override
    public List<Login> serviceGetAllUsers(){
        return this.loginDao.getAllUsers();
    }

}




