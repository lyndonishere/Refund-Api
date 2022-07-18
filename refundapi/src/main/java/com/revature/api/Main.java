package com.revature.api;

import com.revature.controllers.LoginController;

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

        LoginController loginController = new LoginController();
        
        app.get("/hello", loginController.getHelloWorld);

        // app.post();

        // app.delete();

        app.start();
    }
}
