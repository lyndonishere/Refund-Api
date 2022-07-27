package com.automation.poms;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManagerRequest {

    private WebDriver driver;

    public ManagerRequest(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    // View

        // table generate WITH requests

        // manager should be able to view

        // NO table generates

        // manager should receive alert

    // Desc

        // manager inputs 500 char reason
            @FindBy(id = "enter-decision-reason")
            public WebElement enterDecisionReason;

            public void enterDecisionReason(String reason){
                this.enterDecisionReason.sendKeys(reason);
            }

        // manager should have approved request

        // manager inputs 500+ char reason
            public void excessiveDecisionReason(String reason){
                this.enterDecisionReason.sendKeys(reason);
            }

        // manager should receive alert
            public void reasonAlert(){
                WebDriverWait waitAccept = new WebDriverWait(driver,10);
                waitAccept.until(ExpectedConditions.alertIsPresent());
                Alert alertAccept = driver.switchTo().alert();
                alertAccept.accept();
            }

    // Approve

        // status should be approved

    // Deny

        // manager selects deny
            public void dropdownDeny(){
                Select dropdownDenyChoice = new Select(driver.findElement(By.id("select-decision")));
                String dropdownDenyOption = "Denied";
                dropdownDenyChoice.selectByValue(dropdownDenyOption);
        
                List<WebElement> dropdownDenyOptions = dropdownDenyChoice.getAllSelectedOptions();
                assertEquals(1, dropdownDenyOptions.size());
                assertEquals(dropdownDenyOption, dropdownDenyOptions.get(0).getAttribute("value"));
            }

        // status should be denied
}
