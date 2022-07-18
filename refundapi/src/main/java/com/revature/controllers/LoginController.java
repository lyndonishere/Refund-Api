package com.revature.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.revature.entities.Login;
import com.revature.service.LoginServiceInterface;

import io.javalin.http.Handler;

public class LoginController {
   
   private LoginServiceInterface loginService;
   private Gson gson;

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
      // the toJson metod provided by Gson turns our collection of Book objects into a formatted string
      String loginJSON = this.gson.toJson(login);
      // we use the ctx.result() method to attack the loginJSON to the response body
      ctx.result(loginJSON);
      ctx.status(200);
     };

     public Handler removeUser = ctx -> {
      // the ctx.body() method creates a java string object from the content of the request body
      String json = ctx.body();
      // we then use Gson to convert the json string into the java class we are working with
      Login userToBeDeleted = this.gson.fromJson(json, Login.class);
      // we then pass the java object we created into the appropriate service method for validation
      this.loginService.serviceRemoveUser(userToBeDeleted);
      // because I am not returning any special entity with this method I will use a Map to create my key/value pair mesage for the json
      Map<String, String> message =  new HashMap<>();
      message.put("message", "user was deleted");
      // once the map is made we convert it into a json
      String messageJson = this.gson.toJson(message);
      // then we attach it into the response body and set the status code
      ctx.result(messageJson);
      ctx.status(203);    // need to double check this tho
     };
}
