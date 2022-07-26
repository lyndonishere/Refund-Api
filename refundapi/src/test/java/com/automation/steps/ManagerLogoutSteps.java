package com.automation.steps;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManagerLogoutSteps {
    
    // scenarios 1 and 2
    @Given("the manager is on their personal manager homepage")
        public void the_manager_is_on_their_personal_manager_homepage(){
            TestRunner.driver.get("C:/Users/orian/Refund-Api/refundapi/src/test/resources/web-pages/ManagerPage.html");
        }

    // scenarios 1 and 2
    @When("the manager clicks the logout button")
        public void the_manager_clicks_the_logout_button(){
            TestRunner.managerLogout.managerClickLogoutButton();
        }

    // scenario 1
    @When("the manager confirms they want to logout")
        public void the_manager_confirms_they_want_to_logout(){
            TestRunner.managerLogout.managerConfirmLogout();
        }

    @Then("the manager should be logged out and returned back to the login homepage")
        public void the_manager_should_be_logged_out_and_returned_back_to_the_login_homepage(){
            TestRunner.driver.get("C:/Users/orian/Refund-Api/refundapi/src/test/resources/web-pages/LoginPage.html");
        }

    // scenario 2
    @When("the manager does not confirm they want to logout")
        public void the_manager_does_not_confirm_they_want_to_logout(){ 
            TestRunner.managerLogout.noLogout();
        }
        
    @Then("the manager should stay on their current page")
        public void the_manager_should_stay_on_their_current_page(){
            TestRunner.wait.until(ExpectedConditions.titleIs("Manager Page"));
            String title = TestRunner.driver.getTitle();
            Assert.assertEquals("Manager Page", title);
        }
}
