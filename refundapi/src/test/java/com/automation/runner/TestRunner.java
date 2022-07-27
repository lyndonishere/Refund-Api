package com.automation.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.poms.EmployeeCommon;
import com.automation.poms.EmployeeLogin;
import com.automation.poms.EmployeeLogout;
import com.automation.poms.EmployeeRequest;
import com.automation.poms.ManagerCommon;
import com.automation.poms.ManagerLogin;
import com.automation.poms.ManagerLogout;
import com.automation.poms.ManagerRequest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", glue = "com/automation/steps", plugin = "pretty")

public class TestRunner {

    public static WebDriver driver;
    public static WebDriverWait wait;

    // login
    public static ManagerLogin managerLogin;
    //public static EmployeeLogin employeeLogin;

    // logout
    public static ManagerLogout managerLogout;
   // public static EmployeeLogout employeeLogout;

    // employee page
   // public static EmployeeCommon employeeCommon;
   // public static EmployeeRequest employeeRequest;

    // manager page
   // public static ManagerCommon managerCommon;
   // public static ManagerRequest managerRequest;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");   // may need to add a plugin
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, 5);

        managerLogin = new ManagerLogin(driver);
       // employeeLogin = new EmployeeLogin(driver);

       managerLogout = new ManagerLogout(driver);
       // employeeLogout = new EmployeeLogout(driver);

       // employeeCommon = new EmployeeCommon(driver);
       // employeeRequest = new EmployeeRequest(driver);

      // managerCommon = new ManagerCommon(driver);
      //  managerRequest = new ManagerRequest(driver);
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }



    
}