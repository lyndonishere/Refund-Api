package com.revature.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.entities.Reimbursement;


public class ReimbursementTests {

    public static ReimbursementDAOInterface reimbursementDao;

    @BeforeClass
    public static void setup(){
        reimbursementDao = new ReimbursementDAO();

        Reimbursement setupUpdateRequest = new Reimbursement(-3, "to be updated username", "to be updated name", "to be updated title", 100, "to be updated reason", java.sql.Date.valueOf("2020-11-15"), "to be updated status", "to be updated reason");
        reimbursementDao.updateRequest(setupUpdateRequest);
    }

    @Test
    public void addRequestPositiveTest(){
        Reimbursement testRequest = new Reimbursement("test username", "test name", "test title", 100, "test reason", java.sql.Date.valueOf("2017-11-15"), "test status", "test reason");
        Reimbursement result = reimbursementDao.addRequest(testRequest);
        Assert.assertNotNull(result.getReimbursement_id());
    }

    @Test
    public void updateRequestPositiveTest(){
        Reimbursement updatedRequest = new Reimbursement(-3, "updated username", "updated name", "updated title", 300, "updated reason", java.sql.Date.valueOf("2021-11-15"), "updated status", "updated reason");
        Reimbursement result =  reimbursementDao.updateRequest(updatedRequest);
        Assert.assertEquals("updated title", result.getReimbursement_title());
    }

    @Test
    public void getAllRequestsPositiveTest(){
        List<Reimbursement> reimbursementList = reimbursementDao.getAllRequests();
        Assert.assertTrue(reimbursementList.size() >= 2);
    }

    @Test
    public void removeRequestPositiveTest(){
        
        Reimbursement requestToBeDeleted = new Reimbursement(-4, "to be deleted username", "to be deleted name", "to be deleted title", 500, "to be deleted reason", java.sql.Date.valueOf("1993-12-25"), "to be deleted status", "to be deleted reason");
        reimbursementDao.addRequest(requestToBeDeleted);
        boolean result = reimbursementDao.removeRequest(requestToBeDeleted);
        Assert.assertTrue(result);
    }
    
}
