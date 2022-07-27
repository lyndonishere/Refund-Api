package com.automation.steps;

import io.cucumber.java.en.When;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.runner.TestRunner;

import io.cucumber.java.en.Then;

public class ManagerRequestSteps {

    // View Specific Feature Steps

        // scenario 1
        @When("a table generates with employee reimbursement requests")
        public void a_table_generates_with_employee_reimbursement_requests(){
        }

        @Then("the manager should be able to view employee reimbursement requests")
        public void the_manager_should_be_able_to_view_employee_reimbursement_requests(){
        }
        
        // scenario 2
        @When("a table does not generate with employee reimbursement requests")
        public void a_table_does_not_generate_with_employee_reimbursement_requests(){
        }

        @Then("the manager should receive an alert that there are no reimbursement requests available")
        public void the_manager_should_receive_an_alert_that_there_are_no_reimbursement_requests_available(){
        }

    // Desc Specific Feature Steps

        // scenario 1
        @When("the manager inputs in a 500 character maximum reimbursement request reason description")
        public void the_manager_inputs_in_a_500_character_maximum_reimbursement_request_reason_description(){
            TestRunner.managerRequest.enterDecisionReason("Don't become greedy, I got bills to pay!");
        }

        @Then("the manager should have approved a request alongside a reason")
        public void the_manager_should_have_approved_a_request_alongside_a_reason(){
            TestRunner.wait.until(ExpectedConditions.attributeContains(status9, "textContent", "Approved"));
        }

        // scenario 2
        @When("the manager tries to enter more than 500 characters in the reimbursement request reason description")
        public void the_manager_tries_to_enter_more_than_500_characters_in_the_reimbursement_request_reason_description(){
            TestRunner.managerRequest.excessiveDecisionReason("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate");
        }

        @Then("the manager should not be able to type any more characters in the input box")
        public void the_manager_should_not_be_able_to_type_any_more_characters_in_the_input_box(){
        }

        // scenario 3
        @Then("the manager should receive an alert that they need to enter a reimbursement reason description")
        public void the_manager_should_receive_an_alert_that_they_need_to_enter_a_reimbursement_reason_description(){
            TestRunner.managerRequest.reasonAlert();
        }

    // Approve Specific Feature Steps

        // scenario 1

        @FindBy(id = "status9")
        public WebElement status9;

        @Then("the reimbursement request status should change from pending to approved")
        public void the_reimbursement_request_status_should_change_from_pending_to_approved(){
            TestRunner.wait.until(ExpectedConditions.attributeContains(status9, "textContent", "Approved"));
        }

    // Deny Specific Feature Steps

        // scenario 1
        @When("the manager selects deny")
        public void the_manager_selects_deny(){
            TestRunner.managerRequest.dropdownDeny();
        }

        @Then("the reimbursement request status should change from pending to denied")
        public void the_reimbursement_request_status_should_change_from_pending_to_denied(){
            TestRunner.wait.until(ExpectedConditions.attributeContains(status9, "textContent", "Denied"));
        }

}
