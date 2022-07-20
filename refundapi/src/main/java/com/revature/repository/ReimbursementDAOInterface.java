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

    //approve request method

    boolean approveRequest(Reimbursement requestApproved);

    // Deny request
    boolean denyRequest (Reimbursement requestDenied);
}
