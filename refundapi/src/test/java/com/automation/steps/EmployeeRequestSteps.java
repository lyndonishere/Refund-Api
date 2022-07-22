package com.automation.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeRequestSteps {
    
    // View-Specific Features
        
        // scenario 1, 2
        @When("their personal employee homepage loads")
            public void their_personal_employee_homepage_loads(){
            }

        // scenario 1
        @When("a table generates with their personal reimbursement request history")
            public void a_table_generates_with_their_personal_reimbursement_request_history(){
            }

        // scenario 2
        @When("a table does not generate with their personal reimbursement request history")
            public void a_table_does_not_generate_with_their_personal_reimbursement_request_history(){
            }

        // scenario 1
        @Then("the employee should be able to view their previous reimbursement requests")
            public void the_employee_should_be_able_to_view_their_previous_reimbursement_requests(){
            }

        // scenario 2
        @Then("the employee should receive an alert that there are no reimbursement requests available")
            public void the_employee_should_receive_an_alert_that_there_are_no_reimbursement_requests_available(){
            }

    // Title-Specific Features

        // scenario 1
        @When("the employee enters in a 50 character maximum reimbursement request title")
            public void the_employee_enters_in_a_50_character_maximum_reimbursement_request_title(){
            }

        // scenario 2
        @When("the employee tries to enter more than 50 characters in the reimbursement request title")
            public void the_employee_tries_to_enter_more_than_50_characters_in_the_reimbursement_request_title(){
            }

        // scenario 2
        @Then("the employee should not be able to type any more characters in the input box")
            public void the_employee_should_not_be_able_to_type_any_more_characters_in_the_input_box(){
            }

        // scenario 3
        @Then("the employee should receive an alert that they need to enter a reimbursement title")
            public void the_employee_should_receive_an_alert_that_they_need_to_enter_a_reimbursement_title(){
            }

    // Amount-Specific Features

        // scenario 1
        @When("the employee enters in a new reimbursement request amount up to $1000")
            public void the_employee_enters_in_a_new_reimbursement_request_amount_up_to_$1000(){
            }

        // scenario 2
        @When("the employee tries to enter more than $1000 in the reimbursement request amount")
            public void the_employee_tries_to_enter_more_than_$1000_in_the_reimbursement_request_amount(){
            }

        // scenario 2
        @Then("the employee should receive an alert that they cannot enter more than $1000 in the reimbursement request amount")
            public void the_employee_should_receive_an_alert_that_they_cannot_enter_more_than_$1000_in_the_reimbursement_request_amount(){
            }

        // scenario 3
        @Then("the employee should receive an alert that they need to enter a reimbursement amount")
            public void the_employee_should_receive_an_alert_that_they_need_to_enter_a_reimbursement_amount(){
            }

    // Desc-Specific Features

        // scenario 1
        @When("the employee enters in a 500 character maximum reimbursement request description")
            public void the_employee_enters_in_a_500_character_maximum_reimbursement_request_description(){
            }

        // scenario 2
        @When("the employee tries to enter more than 500 characters in the reimbursement request description")
            public void the_employee_tries_to_enter_more_than_500_characters_in_the_reimbursement_request_description(){
            }

        // scenario 2
        @Then("the employee should not be able to type any more characters in the description input box")
            public void the_employee_should_not_be_able_to_type_any_more_characters_in_the_description_input_box(){
            }

        // scenario 3
        @Then("the employee should receive an alert that they need to enter a reimbursement description")
            public void the_employee_should_receive_an_alert_that_they_need_to_enter_a_reimbursement_description(){
            }

    // Request-Specific Features

        // scenario 2
        @When("the employee does not enter in a new reimbursement request title")
            public void the_employee_does_not_enter_in_a_new_reimbursement_request_title(){
            }

        // scenario 2
        @When("the employee does not enter in a new reimbursement request amount")
            public void the_employee_does_not_enter_in_a_new_reimbursement_request_amount(){
            }

        // scenario 2
        @When("the employee does not enter in a new reimbursement request description")
            public void the_employee_does_not_enter_in_a_new_reimbursement_request_description(){
            }

        // scenario 2
        @Then("the employee should receive an alert that their request could not be made")
            public void the_employee_should_receive_an_alert_that_their_request_could_not_be_made(){
            }


}
