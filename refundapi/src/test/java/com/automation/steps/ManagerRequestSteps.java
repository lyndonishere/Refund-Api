package com.automation.steps;

import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.runner.TestRunner;

import io.cucumber.java.en.Then;

public class ManagerRequestSteps {



    // Desc Specific Feature Steps

        // scenario 1
        @When("the manager inputs in a 500 character maximum reimbursement request reason description")
        public void the_manager_inputs_in_a_500_character_maximum_reimbursement_request_reason_description(){
            TestRunner.managerRequest.enterDecisionReason("Don't become greedy, I got bills to pay!");
        }

    // Approve Specific Feature Steps

        // scenario 1

        @FindBy(id = "status9")
        public WebElement status9;

        @Then("the reimbursement request status should change from pending to approved")
        public void the_reimbursement_request_status_should_change_from_pending_to_approved(){
            TestRunner.wait.until(ExpectedConditions.titleIs("Manager Page"));
            String title = TestRunner.driver.getTitle();
            Assert.assertEquals("Manager Page", title);
        }

    // Deny Specific Feature Steps

        // scenario 1
        @When("the manager selects deny")
        public void the_manager_selects_deny(){
            TestRunner.managerRequest.dropdownDeny();
        }

        @Then("the reimbursement request status should change from pending to denied")
        public void the_reimbursement_request_status_should_change_from_pending_to_denied(){
            TestRunner.wait.until(ExpectedConditions.titleIs("Manager Page"));
            String title = TestRunner.driver.getTitle();
            Assert.assertEquals("Manager Page", title);
        }

}
