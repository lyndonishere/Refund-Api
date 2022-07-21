package com.automation.steps;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManagerLoginSteps {

    private WebDriver driver;

    // done
    @Given("the manager is on the login page")
        public void the_manager_is_on_the_login_page(){
            TestRunner.driver.get("File://C:/Users/orian/Refund-Api/refundapi/src/test/resources/web-pages/LoginPage.html");
        }
    
    // done
    @When("the manager enters their correct username")
        public void the_manager_enters_their_correct_username(){
            TestRunner.managerLogin.managerEnterUsername("mrkrabs");
        }

    // done
    @When("the manager enters their correct password")
        public void the_manager_enters_their_correct_password(){
            TestRunner.managerLogin.managerEnterPassword("ilikemoney");
        }

    // done
    @When("the manager clicks the login button")
        public void the_manager_clicks_the_login_button(){
            TestRunner.managerLogin.managerClickLoginButton();
        }

    // done
    @When("the manager enters in their incorrect user name")
        public void the_manager_enters_in_their_incorrect_user_name(){
            TestRunner.managerLogin.managerWrongUsername("misterkrabs");
        }

    // done
    @When("the manager enters in their incorrect password")
        public void the_manager_enters_in_their_incorrect_password(){
            TestRunner.managerLogin.managerEnterPassword("ienjoy$");
        }

    // done
    @Then("the manager should be logged in to their manager home page")
        public void the_manager_should_be_logged_in_to_their_manager_home_page(){
            TestRunner.wait.until(ExpectedConditions.titleIs("Manager Page"));
            String title = TestRunner.driver.getTitle();
            Assert.assertEquals("Manager Page", title);
        }

    // done
    @Then("the manager should receive an alert that their credentials are incorrect")
        public void the_manager_should_receive_an_alert_that_their_credentials_are_incorrect(){
            WebDriverWait waitManagerIncorrect = new WebDriverWait(driver, 10);
            waitManagerIncorrect.until(ExpectedConditions.alertIsPresent());
            Alert alertIncorrectCredentials = driver.switchTo().alert();
            alertIncorrectCredentials.accept();
        }
    
}
