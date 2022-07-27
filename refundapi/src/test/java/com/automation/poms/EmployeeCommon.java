package com.automation.poms;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class EmployeeCommon {

    private WebDriver driver;

    public EmployeeCommon(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(id = "enter-request-title")
    public WebElement employeeRequestInput;
    
    public void employeeEnterReimbursementTitle(String Title){
        this.employeeRequestInput.sendKeys(Title);
    }
    @FindBy(id = "enter-request-reason")
    public WebElement employeeDescriptionInput;

    public void employeeEnterRequestDescription(String Description){
        this.employeeDescriptionInput.sendKeys(Description);
    }
    
    @FindBy(id = "enter-request-amount")
        public WebElement employeeAmountInput;
    
        public void employeeEnterRequestAmount(String amount){
            this.employeeAmountInput.sendKeys(amount);
        }

    @FindBy(id = "submit-button")
    public WebElement employeeSubmitButton;

        public void employeeClickSubmitButton(){
            this.employeeSubmitButton.click();

            WebDriverWait waitAccept = new WebDriverWait(driver,15);
            waitAccept.until(ExpectedConditions.alertIsPresent());
            Alert alertAccept = driver.switchTo().alert();
            alertAccept.accept();

        }

        
}

