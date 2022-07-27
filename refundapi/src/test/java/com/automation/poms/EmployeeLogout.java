package com.automation.poms;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeeLogout {
    private WebDriver driver;

    public EmployeeLogout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id ="logout-button")
    public WebElement employeeLogoutButton;
    public void employeeClickLogoutButton(){
        this.employeeLogoutButton.click();

        WebDriverWait waitEmployeeLogout = new WebDriverWait(driver,10);
        waitEmployeeLogout.until(ExpectedConditions.alertIsPresent());
        Alert alertEmployeeLogout = driver.switchTo().alert();
        alertEmployeeLogout.accept();

        WebDriverWait waitEmployeeLogoutAgain = new WebDriverWait(driver,10);
        waitEmployeeLogoutAgain.until(ExpectedConditions.alertIsPresent());
        Alert alertEmployeeLogoutAgain = driver.switchTo().alert();
        alertEmployeeLogoutAgain.accept();
    }
    
}
