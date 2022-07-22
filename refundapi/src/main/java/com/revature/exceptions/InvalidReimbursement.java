package com.revature.exceptions;

public class InvalidReimbursement extends RuntimeException {
    public InvalidReimbursement (String message){
        // super is a reference to the parent class's constructor
        super(message);
    }
    
    public static void main(String[] args){
        // to throw your exception, you can use the throw keyword and then create your exception object with your message
        throw new InvalidReimbursement("This is how you throw an exception! This could be a message for the end user, or just for a dev working on code");
    }
}
