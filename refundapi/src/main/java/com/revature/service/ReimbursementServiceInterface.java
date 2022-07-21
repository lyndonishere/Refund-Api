package com.revature.service;

import java.util.List;

import com.revature.entities.Reimbursement;

public interface ReimbursementServiceInterface {
    
    //EMPLOYEE
    // creates
    Reimbursement serviceAddRequest(Reimbursement newRequest);

    // reads
    List<Reimbursement> serviceGetAllRequests();

    // updates
    Reimbursement serviceUpdateRequest(Reimbursement updatedRequest);
    
    // deletes
    boolean serviceRemoveRequest(Reimbursement requestToBeDeleted);

    //MANAGER
    // accepts
    Reimbursement serviceAcceptedRequest(Reimbursement acceptedRequest);

    //Denies
    Reimbursement serviceRejectedRequest(Reimbursement rejectedRequest);
}
