package com.automation.steps;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManagerLoginSteps {

    @Given("the manager is on the login page")
        public void the_manager_is_on_the_login_page(){
            TestRunner.driver.get("File://C:/Users/orian/Refund-Api/refundapi/src/test/resources/web-pages/LoginPage.html");
        }
    
    @When("the manager enters their correct username")
        public void the_manager_enters_their_correct_username(){
            TestRunner.managerLogin.managerEnterUsername("mrkrabs");
        }

    @When("the manager enters their correct password")
        public void the_manager_enters_their_correct_password(){
            TestRunner.managerLogin.managerEnterPassword("ilikemoney");
        }

    @When("the manager clicks the login button")
        public void the_manager_clicks_the_login_button(){
            TestRunner.managerLogin.managerClickLoginButton();
        }

    @Then("the manager should be logged in to their manager home page")
        public void the_manager_should_be_logged_in_to_their_manager_home_page(){
            TestRunner.wait.until(ExpectedConditions.titleIs("Manager Page"));
            String title = TestRunner.driver.getTitle();
            Assert.assertEquals("Manager Page", title);
        }
}
