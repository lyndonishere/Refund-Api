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

    // Manager Approve Scenarios: 1
    // Manager Deny Scenarios: 1
    // Manager Desc Scenarios: 1, 3
    @When("the manager inputs a pending reimbursement request ID number")
        public void the_manager_inputs_a_pending_reimbursement_request_ID_number(){
            TestRunner.managerCommon.enterReimbursementId("9");
        }

    // Manager Approve Scenarios: 1
    // Manager Deny Scenarios: 1
    @When("the manager inputs a reason description")
        public void the_manager_inputs_a_reason_description(){
            TestRunner.managerCommon.enterDecisionReason("This is to show our E2E test works!");
        }

    // Manager Approve Scenarios: 1, 2
    // Manager Deny Scenarios: 1, 2
    // Manager Desc Scenarios: 1, 3
    @When("the manager clicks submit")
        public void the_manager_clicks_submit(){
            TestRunner.managerCommon.submitDecision();
        }


    // Manager Approve Scenarios: 1
    // Manager Desc Scenarios: 1, 3
    @When("the manager selects approve")
        public void the_manager_selects_approve(){
            TestRunner.managerCommon.dropdownApprove();
        }
}