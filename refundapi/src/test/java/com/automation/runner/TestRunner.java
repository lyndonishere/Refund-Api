package com.automation.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.poms.EmployeeLogin;
import com.automation.poms.ManagerLogin;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", glue = "com/automation/steps")

public class TestRunner {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public static ManagerLogin managerLogin;
    public static EmployeeLogin employeeLogin;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, 5);

        managerLogin = new ManagerLogin(driver);
        // employeeLogin = new EmployeeLogin(driver);
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }



    
}