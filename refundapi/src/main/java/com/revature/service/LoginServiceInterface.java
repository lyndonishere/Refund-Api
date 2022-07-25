package com.revature.service;

import java.util.List;

import com.revature.entities.Login;

public interface LoginServiceInterface {
    
    /*
     * We have several business rules to accomodate for.
     * 
     *  Employees
            Employees must ONLY see their own reimbursement requests
            Employees may only request up to $1000 per request
            Employees must provide a reason for the reimbursement request no longer than 500 characters
        Managers
            Managers must provide a reason for approving or denying a reimbursement request no longer than 500 characters
        Both
            Usernames must be unique
     * 
     * We are going to make a method that returns a boolean indicating whether or not the business rule is being followed.
     * If the rule is being followed, I then allow the data to be passed to the repo layer, but if the business rule is not being followed
     * then I do not allow the data into the repo layer
     * 
     * Let's start with this one:
     * Usernames must be unique
     * 
     * checkUsernameMatch()
     */


    // boolean checkUsernameMatch(Login userToCheck);   movd to business rules in utils

    /*
     * When you set up an application that has a repo layer and a service layer you want to have a service method for each of your repo methods
     */

    // log in
    Login loginUser(Login loginUser); 
    
    List<Login> serviceGetAllUsers();

}
