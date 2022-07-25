package com.revature.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.revature.entities.Login;
import com.revature.exceptions.InvalidUser;
import com.revature.repository.LoginDAOInterface;
import com.revature.service.LoginServiceInterface;

import io.javalin.http.Handler;

public class LoginController {
   
   private LoginServiceInterface loginService;
   private Gson gson;
   private LoginDAOInterface loginDaoInterface;

   public LoginController(LoginServiceInterface loginService){
      this.loginService = loginService;
      this.gson = new Gson();
   }

    /*
     * This LoginController is going to parse the info received in HTTP request bodies, send the information to the appropriate service method, and craft an HTTP
     * response for us based upon the data received from the service methods
     */

     /*
      * This is the basic setup for how to handle HTTP requests via Javalin: you create a variable that is a reference to a lambda, provide an argument called ctx
      (stands for context, provided by Javalin), and then write your code to handle the request
      */

     public Handler loginUser = ctx -> {
      try {
         // get json from request body
         String json = ctx.body();

         // convert json to our java object
         Login userToLogin = this.gson.fromJson(json, Login.class);

         // pass the data into the service layer and get method result back
         Login result = this.loginService.loginUser(userToLogin);

         // convert the result into a json
         String resultJson = this.gson.toJson(result);

         // set the response body and status code
         ctx.result(resultJson);
         ctx.status(200);

      } catch(InvalidUser e) {
         // create a map to easily make key/value pair for json
         Map<String, String> message =  new HashMap<>();

         // place the exception message into the map
         message.put("message", e.getMessage());

         // convert the map into a json
         String messageJson = this.gson.toJson(message);

         // attach the json to the response body and set the status code
         ctx.result(messageJson);
         ctx.status(400); 
      }
     };

     public Handler getAllUsers = ctx -> {
      List<Login> login =  this.loginService.serviceGetAllUsers();

      /*
     * The reimbursement arrayList above contains multiple Java reimbursement objects: these need to turn into JSON formatting to be able to attach them to the HTTP Response Body
     * We can use the GSON library we acquired from the Maven repository to handle this conversion process for us
     */
      // the toJson metod provided by Gson turns our collection of Book objects into a formatted string
      String loginJSON = this.gson.toJson(login);
      // we use the ctx.result() method to attack the loginJSON to the response body
      ctx.result(loginJSON);
      ctx.status(200);
   };
};
