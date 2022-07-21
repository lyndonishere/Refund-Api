package com.revature.repository;

import java.util.List;

import com.revature.entities.Reimbursement;

public interface ReimbursementDAOInterface {
    
    // creates
    Reimbursement addRequest(Reimbursement newRequest);

    // reads
    List<Reimbursement> getAllRequests();

    // updates
    Reimbursement updateRequest(Reimbursement updatedRequest);
    
    // deletes
    boolean removeRequest(Reimbursement requestToBeDeleted);

     // boolean denyRequest (Reimbursement requestDenied);
}
