package com.automation.poms;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManagerLogout {

    private WebDriver driver;

    public ManagerLogout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    

    @FindBy(id = "logout-button")
        public WebElement managerLogoutButton;

    public void managerConfirmLogout(){
        this.managerLogoutButton.click();

        WebDriverWait waitManagerLogout = new WebDriverWait(driver,10);
        waitManagerLogout.until(ExpectedConditions.alertIsPresent());
        Alert alertManagerLogout = driver.switchTo().alert();
        alertManagerLogout.accept();

        WebDriverWait waitManagerLogoutNow = new WebDriverWait(driver,10);
        waitManagerLogoutNow.until(ExpectedConditions.alertIsPresent());
        Alert alertManagerLogoutNow = driver.switchTo().alert();
        alertManagerLogoutNow.accept();
    }
}
