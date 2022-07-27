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

public class EmployeeLoginSteps {

    private WebDriver driver;

    // done
    @Given("the employee is on the login page")
        public void the_employee_is_on_the_login_page(){
            
            TestRunner.driver.get("File://C:/Users/lyndo/Revature-Training/RefundAPIFiles/Refund-Api/refundapi/src/test/resources/web-pages/LoginPage.html");
        }
    
    // done
    @When("the employee enters their correct user name")
        public void the_employee_enters_their_correct_user_name(){
            TestRunner.employeeLogin.employeeEnterUsername("spongebob");
        }

    // done
    @When("the employee enters their correct password")
        public void the_employee_enters_their_correct_password(){
            TestRunner.employeeLogin.employeeEnterPassword("krabbypatties");
        }

    // done
    @When("the employee clicks the login button")
        public void the_employee_clicks_the_login_button(){
            TestRunner.employeeLogin.employeeClickLoginButton();
        }

    // done
    @When("the employee enters in their incorrect user name")
        public void the_employee_enters_in_their_incorrect_user_name(){
            TestRunner.employeeLogin.employeeWrongUsername("beepbop");
        }

    // done
    @When("the employee enters in their incorrect password")
        public void the_employee_enters_in_their_incorrect_password(){
            TestRunner.employeeLogin.employeeWrongPassword("boopbop");
        }

    // done
    @Then("the employee should be logged in to their employee home page")
        public void the_employee_should_be_logged_in_to_their_employee_home_page(){
            TestRunner.wait.until(ExpectedConditions.titleIs("Employee Page"));
            String title = TestRunner.driver.getTitle();
            Assert.assertEquals("Employee Page", title);
        }

    // done
    @Then("the employee should receive an alert that their credentials are incorrect")
        public void the_employee_should_receive_an_alert_that_their_credentials_are_incorrect(){
            WebDriverWait waitEmployeeIncorrect = new WebDriverWait(driver, 10);
            waitEmployeeIncorrect.until(ExpectedConditions.alertIsPresent());
            Alert alertIncorrectCredentials = driver.switchTo().alert();
            alertIncorrectCredentials.accept();
        }
    
}
