package com.revature.utils;

import com.revature.entities.Reimbursement;

public class ReimbursementBusinessRules {
    
    public boolean checkRefundAmount(Reimbursement amountToCheck) {
        
        if(amountToCheck.getAmount() > 1000){        
            return false;   // if the business rule is broken, we return false
        } else {
            return true;    // if the business rule is being followed, we return true
        }
    }

    public boolean checkTitleLength(Reimbursement titleToCheck){

        if(titleToCheck.getReimbursement_title().length() > 50){
            return false;
        }else{
            return true;
        }
    }
}
