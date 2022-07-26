package com.automation.steps;

import com.automation.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class ManagerCommonSteps {
    
    // Manager Approve Scenarios: 1, 2
    // Manager Deny Scenarios: 1, 2
    // Manager Desc Scenarios: 1, 2, 3
    // Manager View Scenarios: 1, 2
    // Manager Logout Scenarios: 1, 2
    @Given("the manager is on their personal manager homepage")
        public void the_manager_is_on_their_personal_manager_homepage(){
            TestRunner.driver.get("File:///Users/mauricekabeireho/_dev/Refund-Api/refundapi/src/test/resources/web-pages/ManagerPage.html");
        }

    // Manager Approve Scenarios: 1, 2
    // Manager Deny Scenarios: 1, 2
    // Manager Desc Scenarios: 1, 3
    @When("the manager views the reimbursement requests")
        public void the_manager_views_the_reimbursement_requests(){
        }

    // Manager Approve Scenarios: 1
    // Manager Deny Scenarios: 1
    // Manager Desc Scenarios: 1, 3
    @When("the manager inputs a pending reimbursement request ID number")
        public void the_manager_inputs_a_pending_reimbursement_request_ID_number(){
        }

    // Manager Approve Scenarios: 1
    // Manager Deny Scenarios: 1
    @When("the manager inputs a reason description")
        public void the_manager_inputs_a_reason_description(){
        }

    // Manager Approve Scenarios: 1, 2
    // Manager Deny Scenarios: 1, 2
    // Manager Desc Scenarios: 1, 3
    @When("the manager clicks submit")
        public void the_manager_clicks_submit(){
        }

    // Manager Approve Scenarios: 2
    // Manager Deny Scenarios: 2
    @When("the reimbursement request status should remain pending")
        public void the_reimbursement_request_status_should_remain_pending(){
        }

    // Manager Approve Scenarios: 1
    // Manager Desc Scenarios: 1, 3
    @When("the manager selects approve")
        public void the_manager_selects_approve(){
        }

    // Manager View Scenarios: 1, 2
    @When("their personal manager homepage loads")
        public void their_personal_manager_homepage_loads(){
        }

}