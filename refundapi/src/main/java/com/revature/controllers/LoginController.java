package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.entities.Login;
import com.revature.service.LoginServiceInterface;

import io.javalin.http.Handler;

public class LoginController {
   
   private LoginServiceInterface loginService;

   public LoginController(LoginServiceInterface loginService){
      this.loginService = loginService;
   }

    /*
     * This LoginController is going to parse the info received in HTTP request bodies, send the information to the appropriate service method, and craft an HTTP
     * response for us based upon the data received from the service methods
     */

     /*
      * This is the basic setup for how to handle HTTP requests via Javalin: you create a variable that is a reference to a lambda, provide an argument called ctx
      (stands for context, provided by Javalin), and then write your code to handle the request
      */
     public Handler getHelloWorld = ctx -> {
        ctx.result("Hello world!");
        ctx.status(200);
     };

     // API -> service -> repo -> service -> API
     public Handler getAllUsers = ctx -> {
      List<Login> login =  this.loginService.serviceGetAllUsers();
      /*
       * The login arrayList above contains multiple Java login objects: these need to turn into JSON formatting to be able to attach them to the HTTP Response Body
       * We can use the GSON library we acquired from the Maven repository to handle this conversion process for us
       */
      Gson gson = new Gson();
      // the toJson metod provided by Gson turns our collection of Book objects into a formatted string
      String loginJSON = gson.toJson(login);
      // we use the ctx.result() method to attack the loginJSON to the response body
      ctx.result(loginJSON);
      ctx.status(200);
     };
}
