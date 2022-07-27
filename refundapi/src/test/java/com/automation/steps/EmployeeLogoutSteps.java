package com.automation.steps;

import com.automation.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeLogoutSteps {
    
    // scenarios 1 and 2
    @Given("the employee is on their personal employee homepage and ready to logout")
        public void the_employee_is_on_their_personal_employee_homepage_and_ready_to_logout(){
            TestRunner.driver.get("File://C:/Users/orian/Refund-Api/refundapi/src/test/resources/web-pages/EmployeePage.html");
        }

    // scenarios 1 
    @When("the employee clicks the logout button")
        public void the_employee_clicks_the_logout_button(){
            TestRunner.employeeLogout.employeeClickLogoutButton();
        }

    // scenario 1
    @When("the employee confirms they want to logout")
        public void the_employee_confirms_they_want_to_logout(){
            TestRunner.employeeLogout.employeeConfirmLogout();
        }

    @Then("the employee should be logged out and returned back to the login homepage")
        public void the_employee_should_be_logged_out_and_returned_back_to_the_login_homepage(){
            TestRunner.driver.get("File:///Users/mauricekabeireho/_dev/Refund-Api/refundapi/src/test/resources/web-pages/LoginPage.html");
       
    }


}
