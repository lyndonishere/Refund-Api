package com.automation.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeLogin {

    public EmployeeLogin(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login-button")
    public WebElement employeeLoginButton;
    
    public void employeeClickLoginButton(){
        this.employeeLoginButton.click();
    }

    @FindBy(id = "username")
    public WebElement employeeUsernameInput;

    public void employeeEnterUsername(String username){
        this.employeeUsernameInput.sendKeys(username);
    }

    public void employeeWrongUsername(String username){
        this.employeeUsernameInput.sendKeys(username);
    }

    @FindBy(id = "password")
    public WebElement employeePasswordInput;

    public void employeeEnterPassword(String password){
        this.employeePasswordInput.sendKeys(password);
    }

    public void employeeWrongPassword(String password){
        this.employeePasswordInput.sendKeys(password);
    }
}
