package com.revature.service;

import java.util.List;

import com.revature.controllers.Login;
import com.revature.entities.Reimbursement;

public interface ReimbursementServiceInterface {
    
    // creates
    Reimbursement serviceAddRequest(Reimbursement newRequest);

    // reads
    List<Reimbursement> serviceGetAllRequests();

    // updates
    Reimbursement serviceUpdateRequest(Reimbursement updatedRequest);
    
    // deletes
    boolean serviceRemoveRequest(Reimbursement requestToBeDeleted);

    List<Reimbursement> serviceGetAllReimbursements();

    void serviceRemoveReimbursement(Reimbursement reimbursementToBeDeleted);

    Reimbursement serviceUpdateReimbursement(Reimbursement updatedReimbursement);

    Reimbursement serviceAddReimbursement(Reimbursement newReimbursement);

}
