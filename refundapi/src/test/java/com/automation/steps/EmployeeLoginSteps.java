package com.automation.steps;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeLoginSteps {

    // done
    @Given("the employee is on the login page")
        public void the_employee_is_on_the_login_page(){
            
            TestRunner.driver.get("File:///Users/mauricekabeireho/_dev/Refund-Api/refundapi/src/test/resources/web-pages/LoginPage.html");
        }
    
    // done
    @When("the employee enters in their correct user name")
        public void the_employee_enters_in_their_correct_user_name(){
            TestRunner.employeeLogin.employeeEnterUsername("spongebob");
        }

    // done
    @When("the employee enters in their correct password")
        public void the_employee_enters_in_their_correct_password(){
            TestRunner.employeeLogin.employeeEnterPassword("krabbypatties");
        }

    // done
    @When("the employee clicks the login button")
        public void the_employee_clicks_the_login_button(){
            TestRunner.employeeLogin.employeeClickLoginButton();
        }

    // done
    @Then("the employee should be logged into the employee homepage")
        public void the_employee_should_be_logged_into_the_employee_homepage(){
            TestRunner.wait.until(ExpectedConditions.titleIs("Employee Page"));
            String title = TestRunner.driver.getTitle();
            Assert.assertEquals("Employee Page", title);
        }
    
}
