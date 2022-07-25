package com.revature.service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.revature.entities.Reimbursement;
import com.revature.repository.ReimbursementDAO;
import com.revature.repository.ReimbursementDAOInterface;
import com.revature.utils.ReimbursementBusinessRules;

public class ReimbursementServiceTests {
    
    
    public static ReimbursementDAOInterface reimbursementDao;
    public static ReimbursementServiceInterface reimbursementService;
    public static ReimbursementBusinessRules reimbursementBusinessRules;

    /*
        the fields below are going to be used for our mock tests: we will use Mockito to create mock objects of
        the dao and rules classes in order to be able to pre-determine their method results in order to perform
        both positive and negative tests for the service methods.
    */
    public static ReimbursementDAOInterface mockDao;
    public static ReimbursementBusinessRules mockRules;
    public static ReimbursementServiceInterface serviceWithMocks;

    @BeforeClass
    public static void setup(){

        reimbursementBusinessRules = new ReimbursementBusinessRules(); 
        reimbursementDao = new ReimbursementDAO();
        reimbursementService = new ReimbursementService(reimbursementDao, reimbursementBusinessRules);

        mockDao = Mockito.mock(ReimbursementDAO.class); // this creates a mock dao object we can control
        mockRules = Mockito.mock(ReimbursementBusinessRules.class); // this creates a mock rules object we control
        serviceWithMocks = new ReimbursementService(mockDao, mockRules);
    }

    @Test
    public void checkRefundAmountNegativeTest(){
        Reimbursement badRequest = new Reimbursement("plankton", "Sheldon J. Plankton", "Give me the formula!", 1001, "Foiled by Krabs!", "Pending");
        boolean result = reimbursementBusinessRules.checkRefundAmount(badRequest);
        Assert.assertFalse(result);
    }


    @Test
    public void checkRefundAmountPositiveTest(){
        Reimbursement goodRequest = new Reimbursement("plankton", "Sheldon J. Plankton", "Give me the formula!", 999, "Foiled by Krabs!", "Pending");
        boolean result = reimbursementBusinessRules.checkRefundAmount(goodRequest);
        Assert.assertTrue(result);
    }

    @Test
    public void checkTitleLengthNegativeTest(){
        Reimbursement badRequest = new Reimbursement("plankton", "Sheldon J. Plankton", "Give me the formula! You have ruined my life and stolen my livelihood. Also, you are much taller than me and it makes me feel small", 999, "Foiled by Krabs!", "Pending");
        boolean result = reimbursementBusinessRules.checkTitleLength(badRequest);
        Assert.assertFalse(result);
    }

    @Test
    public void checkTitleLengthPositiveTest(){
        Reimbursement goodRequest = new Reimbursement("plankton", "Sheldon J. Plankton", "Give me the formula!", 999, "Foiled by Krabs!", "Pending");
        boolean result = reimbursementBusinessRules.checkTitleLength(goodRequest);
        Assert.assertTrue(result);
    }

    @Test
    public void checkEmployeeDescLengthNegativeTest(){
        Reimbursement badRequest = new Reimbursement("plankton", 
        "Sheldon J. Plankton", 
        "Give me the formula!", 
        999,
        "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus", 
        "Pending");
        boolean result = reimbursementBusinessRules.checkDescriptionLength(badRequest);
        Assert.assertFalse(result);
    }

    @Test
    public void checkEmployeeDescLengthPositiveTest(){
        Reimbursement goodRequest = new Reimbursement("plankton", "Sheldon J. Plankton", "Give me the formula!", 999, "Foiled by Krabs!", "Pending");
        boolean result = reimbursementBusinessRules.checkDescriptionLength(goodRequest);
        Assert.assertTrue(result);
    }

  
    @Test
    public void checkManagerDescLengthNegativeTest(){
        Reimbursement badRequest = new Reimbursement("plankton", 
        "Sheldon J. Plankton", 
        "Give me the formula!", 
        999, 
        "You foiled me, Krabs!", 
        "Pending",
        "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus");
        boolean result = reimbursementBusinessRules.checkManagerDescLength(badRequest);
        Assert.assertFalse(result);
    }

    @Test
    public void checkManagerDescLengthPositiveTest(){
        Reimbursement goodRequest = new Reimbursement("plankton", 
        "Sheldon J. Plankton", 
        "Give me the formula!", 
        999, 
        "Foiled by Krabs!", 
        "Denied",
        "No.");
        boolean result = reimbursementBusinessRules.checkManagerDescLength(goodRequest);
        Assert.assertTrue(result);
    }


    // mock tests:
    // update request positive
    // update request negative
    // add request negative


    @Test
    public void mockExampleCreateRequestPositive(){
        Reimbursement goodRequest = new Reimbursement("plankton", "Sheldon J. Plankton", "Give me the formula!", 9, "Foiled by Krabs!", "Pending");
      
        // need to mock everything (given these assumed results, does my serviceAddRequest work as I'm expecting it to?)
        Mockito.when(mockRules.checkRefundAmount(goodRequest)).thenReturn(true);
        Mockito.when(mockRules.checkDescriptionLength(goodRequest)).thenReturn(true);
        Mockito.when(mockRules.checkTitleLength(goodRequest)).thenReturn(true);

        Reimbursement greatRequest = new Reimbursement(-100, "plankton", "Sheldon J. Plankton", "Give me the formula!", 9, "Foiled by Krabs!", "Pending");
        Mockito.when(mockDao.addRequest(goodRequest)).thenReturn(greatRequest);

        Reimbursement result = serviceWithMocks.serviceAddRequest(goodRequest);
        Assert.assertNotNull(result.getReimbursement_id());
    }

   
    // @Test
    // public void mockExampleCreateBookNegative(){
    //     try{
    //         Book badBook = new Book("The Fellowship of the Ring","J. R. R. Tolkien");
    //         /*
    //             for this negative test I don't need to mock the results of the dao because the dao should never be
    //             reached with this test
    //         */
    //         Mockito.when(mockRules.checkBookForTolkien(badBook)).thenReturn(false);

    //         // the serviceCreateBook method below SHOULD, based on the input, throw the InvalidBook exception
    //         Book result = serviceWithMocks.serviceCreateBook(badBook);
    //         // if no exception is thrown by the serviceCreateBook method then the line below will make our test fail
    //         Assert.fail();          
    //     } catch(InvalidBook e){
    //         // here we check that we get both the expected exception and the correct message
    //         Assert.assertEquals("invalid book: please try again", e.getMessage());
    //     }

    // }

    // @Test
    // public void mockExampleUpdateBookPositive(){
    //     Book goodBook = new Book(0,"Crime and Punishment", "I cant spell this name");
    //     Mockito.when(mockRules.checkBookForTolkien(goodBook)).thenReturn(true);
    //     Mockito.when(mockDao.updateBook(goodBook)).thenReturn(goodBook);
    //     Book result = serviceWithMocks.serviceUpdateBook(goodBook);
    //     Assert.assertEquals("Crime and Punishment", result.getTitle());
    // }

    // @Test
    // public void mockExampleUpdateBookNegative(){
    //     try{
    //         Book badBook = new Book("The Fellowship of the Ring","J. R. R. Tolkien");
    //         Mockito.when(mockRules.checkBookForTolkien(badBook)).thenReturn(false);
    //         Book result = serviceWithMocks.serviceUpdateBook(badBook);
    //         Assert.fail();
    //     } catch(InvalidBook e){
    //         // the getMessage() method comes from the parent Exception class
    //         Assert.assertEquals("invalid book: please try again", e.getMessage());
    //     }

    // }
}
