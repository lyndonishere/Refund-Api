package com.automation.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeLogoutSteps {
    
    // scenarios 1 and 2
    @Given("the employee is on their personal employee homepage")
        public void the_employee_is_on_their_personal_employee_homepage(){
        }

    // scenarios 1 and 2
    @When("the employee clicks the logout button")
        public void the_employee_clicks_the_logout_button(){
        }

    // scenario 1
    @When("the employee confirms they want to logout")
        public void the_employee_confirms_they_want_to_logout(){
        }

    @Then("the employee should be logged out and returned back to the login homepage")
        public void the_employee_should_be_logged_out_and_returned_back_to_the_login_homepage(){
        }

    // scenario 2
    @When("the employee does not confirm they want to logout")
        public void the_employee_does_not_confirm_they_want_to_logout(){ 
        }
        
    @Then("the employee should stay on their current page")
        public void the_employee_should_stay_on_their_current_page(){
        }
}
