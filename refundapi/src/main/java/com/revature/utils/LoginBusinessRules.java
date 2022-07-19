package com.revature.utils;

import com.revature.entities.Login;

public class LoginBusinessRules {

    /*
     * This class currently contains only the one business rule, but anymore that are added can then be utilized in any classes that have a field for this class
     */

    public boolean checkUsernameMatch(Login userToCheck, String actualUsername) {

        /*
         * This method is checking to see if the book being entered/updated is following business rules: if it is, a true is returned because it is
         * following the rules and the data can be sent into the repo layer. If the book is not following business rules, a false is returned and the
         * data should NOT be sent to the repo layer
         */

         
        // make sure to use the equals method when comparing strings

        if(userToCheck.getUsername().equals(actualUsername)){        
            // !!!!!!! this logic is just checking if username matches "badusername", need to find a method to check matching usernames
            
            return false;   // if the business rule is broken, we return false
        } else {
            return true;    // if the business rule is being followed, we return true
        }
    }

    
}
