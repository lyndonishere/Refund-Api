package com.revature.exceptions;

public class InvalidReimbursement extends RuntimeException {
    
    public InvalidReimbursement (String message){
        // super is a reference to the parent class's constructor
        super(message);
    }

    /*
     * Because the example below is a RunTimeException, we do not need to place it inside of a try/catch block, but if the class extended Exception instead then
     * our main method would need a try/catch block
     */

    public static void main(String[] args){
        // to throw your exception, you can use the throw keyword and then create your exception object with your message
        throw new InvalidReimbursement("This is how you throw an exception! This could be a message for the end user, or just for a dev working on code");

        /* 
         * A try catch block is used when you know how your code might fail and you want your software to handle the failure gracefully. This code be anything
         * from a custom exception to a built-in one: if the code in the try block triggers an exception you are expecting in one or more catch blocks you created,
         * then the code in the associated catch block will execute intead of your application crashing
         */

        /*
         *         try{
            throw new InvalidUser("This is how you throw an exception! This could be a message for the end user, or just for a dev working on code");
        } catch(InvalidUser e) {
            System.out.println(e.getMessage());
        }
         */
    }
}

