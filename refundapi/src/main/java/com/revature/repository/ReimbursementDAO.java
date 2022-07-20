package com.revature.repository;

import java.util.List;

import com.revature.entities.Reimbursement;
import com.revature.utils.HibernateUtil;

public class ReimbursementDAO implements ReimbursementDAOInterface {
    
    private static final Reimbursement deniedRequest = null;
    private Reimbursement approvedRequest;
    @Override
    public Reimbursement addRequest(Reimbursement newRequest){
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(newRequest);
        HibernateUtil.endTransaction();
        return newRequest;
    }

    @Override
    public List<Reimbursement> getAllRequests(){
        HibernateUtil.beginTransaction();
        List<Reimbursement> requestList = HibernateUtil.getSession().createQuery("from Reimbursement", Reimbursement.class).getResultList();
        HibernateUtil.endTransaction();
        return requestList;
    }

    @Override
    public Reimbursement updateRequest(Reimbursement updatedRequest){
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().update(updatedRequest);
        HibernateUtil.endTransaction();
        return updatedRequest;
    }
    
    @Override
    public boolean removeRequest (Reimbursement requestToBeDeleted){
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().delete(requestToBeDeleted);
        HibernateUtil.endTransaction();
        return true;
    }

    @Override
    public Reimbursement approveRequest (Reimbursement requestToBeApproved){
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().update(requestToBeApproved);
        HibernateUtil.endTransaction();
        return approvedRequest;
}

@Override
    public Reimbursement denyRequest (Reimbursement requestToBeDenied){
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().update(requestToBeDenied);
        HibernateUtil.endTransaction();
        return deniedRequest;

    }


}

