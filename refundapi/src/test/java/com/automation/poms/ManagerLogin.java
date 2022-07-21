package com.automation.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerLogin {
    
    public ManagerLogin(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login-button")
    public WebElement managerLoginButton;
    
    public void managerClickLoginButton(){
        this.managerLoginButton.click();
    }

    @FindBy(id = "username")
    public WebElement managerUsernameInput;

    public void managerEnterUsername(String username){
        this.managerUsernameInput.sendKeys(username);
    }

    public void managerWrongUsername(String username){
        this.managerUsernameInput.sendKeys(username);
    }

    @FindBy(id = "password")
    public WebElement managerPasswordInput;

    public void managerEnterPassword(String password){
        this.managerPasswordInput.sendKeys(password);
    }

    public void managerWrongPassword(String password){
        this.managerPasswordInput.sendKeys(password);
    }
}


