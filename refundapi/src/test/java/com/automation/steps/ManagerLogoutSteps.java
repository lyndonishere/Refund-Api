package com.automation.steps;

import com.automation.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManagerLogoutSteps {
    
    // scenarios 1 and 2
    @Given("the manager is on their personal manager homepage")
        public void the_manager_is_on_their_personal_manager_homepage(){
            TestRunner.driver.get("File:///Users/mauricekabeireho/_dev/Refund-Api/refundapi/src/test/resources/web-pages/ManagerPage.html");
        }

    // scenarios 1 and 2
    @When("the manager clicks the logout button")
        public void the_manager_clicks_the_logout_button(){
        }

    // scenario 1
    @When("the manager confirms they want to logout")
        public void the_manager_confirms_they_want_to_logout(){
        }

    @Then("the manager should be logged out and returned back to the login homepage")
        public void the_manager_should_be_logged_out_and_returned_back_to_the_login_homepage(){
            
        }

    // scenario 2
    @When("the manager does not confirm they want to logout")
        public void the_manager_does_not_confirm_they_want_to_logout(){ 
        }
        
    @Then("the manager should stay on their current page")
        public void the_manager_should_stay_on_their_current_page(){
        }
}
