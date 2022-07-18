package com.revature.service;

import java.util.List;

import com.revature.entities.Reimbursement;
import com.revature.exceptions.InvalidUser;
import com.revature.repository.ReimbursementDAOInterface;
import com.revature.utils.ReimbursementBusinessRules;

public class ReimbursementService implements ReimbursementServiceInterface {

    private ReimbursementDAOInterface reimbursementDao;
    private ReimbursementBusinessRules reimbursementBusinessRules;
    

    public ReimbursementService(ReimbursementDAOInterface reimbursementDAOInterface, ReimbursementBusinessRules reimbursementBusinessRules){
        this.reimbursementDao = reimbursementDao;
        this.reimbursementBusinessRules = reimbursementBusinessRules;
    }

    @Override
    public Reimbursement serviceAddRequest(Reimbursement newRequest){
        if(this.reimbursementBusinessRules.checkRefundAmount(newRequest)){
            return this.reimbursementDao.addRequest(newRequest);
        }
            throw new InvalidUser("Incorrect amoun request for refund");
    }

    @Override
    public List<Reimbursement> serviceGetAllRequests(){
        return this.reimbursementDao.getAllRequests();
    }

    @Override
    public Reimbursement serviceUpdateRequest(Reimbursement updatedRequest){
        return this.reimbursementDao.updateRequest(updatedRequest);
    }

    @Override
    public boolean serviceRemoveRequest(Reimbursement deleteRequest){
        return reimbursementDao.removeRequest(deleteRequest);
    }
    
}
