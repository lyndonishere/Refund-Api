package com.automation.steps;

import com.automation.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManagerLogoutSteps {

    // scenario 1
    @Given("the manager is on their personal manager homepage and ready to logout")
        public void the_manager_is_on_their_personal_manager_homepage_and_ready_to_logout(){
            TestRunner.driver.get("File:///Users/mauricekabeireho/_dev/Refund-Api/refundapi/src/test/resources/web-pages/ManagerPage.html");
        }

    @When("the manager clicks the logout button and confirms they want to logout")
        public void the_manager_clicks_the_logout_button_and_confirms_they_want_to_logout(){
            TestRunner.managerLogout.managerConfirmLogout();
        }

    @Then("the manager should be logged out and returned back to the login homepage")
        public void the_manager_should_be_logged_out_and_returned_back_to_the_login_homepage(){
            TestRunner.driver.get("File:///Users/mauricekabeireho/_dev/Refund-Api/refundapi/src/test/resources/web-pages/LoginPage.html");
        }

}
