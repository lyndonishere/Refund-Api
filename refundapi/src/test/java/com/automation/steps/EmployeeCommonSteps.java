package com.automation.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeCommonSteps {
    
    // Employee Amount Scenarios: 1, 2, 3
    // Employee Desc Scenarios: 1, 2, 3
    // Employee View Scenaros: 1, 2
    // Employee Request Scenarios: 1, 2
    // Employee Title Scenarios: 1, 2, 3
    // Employee Logout Scenarios: 1, 2
    @Given("the employee is on their personal employee homepage")
        public void the_employee_is_on_their_personal_employee_homepage(){
            TestRunner.driver.get("File://C:/Users/lyndo/Revature-Training/RefundAPIFiles/Refund-Api/refundapi/src/test/resources/web-pages/EmployeePage.html");
        }

    // Employee Amount Scenarios: 1, 3
    // Employee Desc Scenarios: 1, 3
    // Employee Request Scenarios: 1, 2
    @When("the employee enters in a new reimbursement request title")
        public void the_employee_enters_in_a_new_reimbursement_request_title(){
            TestRunner.employeeCommon.employeeEnterReimbursementTitle("Travel Allowance");

        }

    // Employee Amount Scenarios: 1, 3
    // Employee Request Scenarios: 1, 3
    // Employee Title Scenarios: 1, 3
    @When("the employee enters in a new reimbursement request description")
        public void the_employee_enters_in_a_new_reimbursement_request_description(){
            TestRunner.employeeCommon.employeeEnterRequestDescription("Ticket Fee");
        }

    // Employee Desc Scenarios: 1, 3
    // Employee Request Scenarios: 1, 2
    // Employee Title Scenarios: 1, 3
    @When("the employee enters in a new reimbursement request amount")
        public void the_employee_enters_in_a_new_reimbursement_request_amount(){
            TestRunner.employeeCommon.employeeEnterRequestAmount("900");

        }
        
    // Employee Amount Scenarios: 1, 3
    // Employee Desc Scenarios: 1, 3
    // Employee Request Scenarios: 1, 2
    // Employee Title Scenarios: 1, 3
    @When("the employee presses submit")
        public void the_employee_presses_submit(){
            TestRunner.employeeCommon.employeeClickSubmitButton();
            
        }

    // Employee Amount Scenarios: 1
    // Employee Desc Scenarios: 1
    // Employee Request Scenarios: 1
    // Employee Title Scenarios: 1
    @Then("the employee should have created a new reimbursement request with a pending status")
        public void the_employee_should_have_created_a_new_reimbursement_request_with_a_pending_status(){

            // TestRunner.employeeCommon.employeeCreateRequest();
            // return "Pending";
        }
    
}
