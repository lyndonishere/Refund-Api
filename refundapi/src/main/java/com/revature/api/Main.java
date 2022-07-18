package com.revature.api;

import com.revature.controllers.LoginController;
import com.revature.repository.LoginDAO;
import com.revature.repository.LoginDAOInterface;
import com.revature.service.LoginService;
import com.revature.service.LoginServiceInterface;
import com.revature.utils.LoginBusinessRules;

import io.javalin.Javalin;

public class Main {
    // reminder: the main method is the entry point for your application
    public static void main(String[] args){

        // inside of the create method we call a lambda that Javalin can use to configure our web server
        // referencing a lambda (a method defined in an interface that you can redefine and implement on the fly)
        Javalin app = Javalin.create(config ->{
            config.enableCorsForAllOrigins();  
            config.enableDevLogging();
        });  

        /* 
         * For our controller class to be able to send info to the service layer for validation it must be given a service object. However, that service object requires
         * its own dependencies to work correctly, so this is where we create our official objects for our repo and service layers so that our API can correctly
         * send information where it needs to go
         */
        LoginDAOInterface loginDao = new LoginDAO();
        LoginBusinessRules loginBusinessRules = new LoginBusinessRules();
        LoginServiceInterface loginService = new LoginService(loginDao, loginBusinessRules);
        LoginController loginController = new LoginController(loginService);
        
        app.get("/hello", loginController.getHelloWorld);
        app.get("/getAllUsers", loginController.getAllUsers);

        // app.post();

        // app.delete();

        app.start();
    }
}
