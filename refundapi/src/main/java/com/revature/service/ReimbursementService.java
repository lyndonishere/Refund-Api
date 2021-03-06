package com.revature.service;

import java.util.List;

import com.revature.entities.Reimbursement;
import com.revature.exceptions.InvalidReimbursement;
import com.revature.repository.ReimbursementDAOInterface;
import com.revature.utils.ReimbursementBusinessRules;

public class ReimbursementService implements ReimbursementServiceInterface {

    private ReimbursementDAOInterface reimbursementDao;
    private ReimbursementBusinessRules reimbursementBusinessRules;
    

    public ReimbursementService(ReimbursementDAOInterface reimbursementDao, ReimbursementBusinessRules reimbursementBusinessRules){
        this.reimbursementBusinessRules = reimbursementBusinessRules;
        this.reimbursementDao = reimbursementDao;
    }

    @Override
    public Reimbursement serviceAddRequest(Reimbursement newRequest){
        boolean valCheck1 = this.reimbursementBusinessRules.checkRefundAmount(newRequest);
        boolean valCheck2 = this.reimbursementBusinessRules.checkTitleLength(newRequest);
        boolean valCheck3 = this.reimbursementBusinessRules.checkDescriptionLength(newRequest);

        if(valCheck1 && valCheck2 && valCheck3){
            return this.reimbursementDao.addRequest(newRequest);
        }else{
            throw new InvalidReimbursement("Could not make request!"); //Potentially change/create new error throw method
        }
    }

    @Override
    public List<Reimbursement> serviceGetAllRequests(){
        return this.reimbursementDao.getAllRequests();
    }

    @Override
    public Reimbursement serviceUpdateRequest(Reimbursement updatedRequest){
        boolean valCheck4 = this.reimbursementBusinessRules.checkManagerDescLength(updatedRequest);

        if(valCheck4){
            return this.reimbursementDao.updateRequest(updatedRequest);
        }else{
            throw new InvalidReimbursement("Incorrect manager decription"); //Potentially change/create new error throw method
        }
    }

    @Override
    public boolean serviceRemoveRequest(Reimbursement deleteRequest){
        return reimbursementDao.removeRequest(deleteRequest);
    }
    
    @Override
    public Reimbursement serviceAcceptedRequest(Reimbursement acceptedRequest){
        boolean valCheck2 = this.reimbursementBusinessRules.checkManagerDescLength(acceptedRequest);

        List<Reimbursement> reimbursementArray = this.reimbursementDao.getAllRequests();
        for(int x=0; x<reimbursementArray.size(); x++){
            Reimbursement pulledRequest = reimbursementArray.get(x);
            if(pulledRequest.getReimbursement_id() == acceptedRequest.getReimbursement_id() && valCheck2){
                acceptedRequest.setStatus("Accepted");
                return acceptedRequest;
            }
        }
        throw new InvalidReimbursement("Something has gone wrong");
    }

    @Override
    public Reimbursement serviceRejectedRequest(Reimbursement rejectedRequest){
        boolean valCheck2 = this.reimbursementBusinessRules.checkManagerDescLength(rejectedRequest);

        List<Reimbursement> reimbursementArray = this.reimbursementDao.getAllRequests();
        for(int x=0; x<reimbursementArray.size(); x++){
            Reimbursement pulledRequest = reimbursementArray.get(x);
            if(pulledRequest.getReimbursement_id() == rejectedRequest.getReimbursement_id() && valCheck2){
                rejectedRequest.setStatus("Rejected");
                return rejectedRequest;
            }
        }
        throw new InvalidReimbursement("Something has gone wrong");
    }
}
