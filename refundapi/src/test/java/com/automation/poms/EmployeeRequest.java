package com.automation.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeRequest {

    public EmployeeRequest(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // 50 char title
    @FindBy(id = "enter-request-title")
    public WebElement enterRequestTitle;

    public void enterRequestTitle(String title){
        this.enterRequestTitle.sendKeys(title);
    }

    // request amount up to $1000
    @FindBy(id = "enter-request-amount")
    public WebElement enterRequestAmount;

    public void enterRequestAmount(String amount){
        this.enterRequestAmount.sendKeys(amount);
    }

    // 500 char desc
    @FindBy(id = "enter-request-reason")
    public WebElement enterRequestReason;

    public void enterRequestReason(String reason){
        this.enterRequestReason.sendKeys(reason);
    }
    
}
