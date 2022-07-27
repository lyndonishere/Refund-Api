package com.revature.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.revature.entities.Reimbursement;
import com.revature.exceptions.InvalidReimbursement;
import com.revature.service.ReimbursementServiceInterface;

import io.javalin.http.Handler;

public class ReimbursementController {
    
    private ReimbursementServiceInterface reimbursementService;
    private Gson gson;
    

    public ReimbursementController(ReimbursementServiceInterface reimbursementService){
        this.reimbursementService = reimbursementService;
        this.gson = new Gson();
    }

     public Handler getAllReimbursements = ctx -> {
        List<Reimbursement> reimbursement =  this.reimbursementService.serviceGetAllRequests();

        /*
       * The reimbursement arrayList above contains multiple Java reimbursement objects: these need to turn into JSON formatting to be able to attach them to the HTTP Response Body
       * We can use the GSON library we acquired from the Maven repository to handle this conversion process for us
       */
        // the toJson metod provided by Gson turns our collection of Book objects into a formatted string
        String reimbursementsJSON = this.gson.toJson(reimbursement);
        // we use the ctx.result() method to attack the loginJSON to the response body
        ctx.result(reimbursementsJSON);
        ctx.status(200);
     };
  
       public Handler updateReimbursement = ctx -> {
        try {
           // get json from request body
           String json = ctx.body();
           // convert json to our java object
           Reimbursement updatedReimbursement = this.gson.fromJson(json, Reimbursement.class);
           // make it pull with id
           updatedReimbursement.setReimbursement_id(Integer.parseInt(ctx.pathParam("id")));
           // pass the data into the service layer and get method result back
           Reimbursement result = this.reimbursementService.serviceUpdateRequest(updatedReimbursement);
           // convert the result into a json
           String resultJson = this.gson.toJson(result);
           // Set the response body and status code
           ctx.result(resultJson);
           ctx.status(200);
        } catch(InvalidReimbursement e) {
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
  
       public Handler createReimbursement = ctx -> {
        try{
           String json = ctx.body();
           Reimbursement newReimbursement = this.gson.fromJson(json, Reimbursement.class);
           Reimbursement result = this.reimbursementService.serviceAddRequest(newReimbursement);
           String resultJson = this.gson.toJson(result);
           ctx.result(resultJson);
           ctx.status(201);
       } catch(InvalidReimbursement e){
           Map<String, String> message =  new HashMap<>();
           message.put("message", e.getMessage());
           String messageJson = this.gson.toJson(message);
           ctx.result(messageJson);
           ctx.status(400); 
       }
     };

}
