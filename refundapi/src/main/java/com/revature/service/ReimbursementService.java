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
        boolean valCheck1 = this.reimbursementBusinessRules.checkRefundAmount(newRequest);
        boolean valCheck2 = this.reimbursementBusinessRules.checkTitleLength(newRequest);

        if(valCheck1 && valCheck2){
            return this.reimbursementDao.addRequest(newRequest);
        }else{
            throw new InvalidUser("Incorrect amount request for refund"); //Potentially change/create new error throw method
        }
    }

    @Override
    public List<Reimbursement> serviceGetAllRequests(){
        return this.reimbursementDao.getAllRequests();
    }

    @Override
    public Reimbursement serviceUpdateRequest(Reimbursement updatedRequest){
        boolean valCheck1 = this.reimbursementBusinessRules.checkRefundAmount(newRequest);
        boolean valCheck2 = this.reimbursementBusinessRules.checkTitleLength(newRequest);

        if(valCheck1 && valCheck2){
            return this.reimbursementDao.addRequest(updatedRequest);
        }else{
            throw new InvalidUser("Incorrect amount request for refund"); //Potentially change/create new error throw method
        }
        return this.reimbursementDao.updateRequest(updatedRequest);
    }

    @Override
    public boolean serviceRemoveRequest(Reimbursement deleteRequest){
        return reimbursementDao.removeRequest(deleteRequest);
    }
    
}
