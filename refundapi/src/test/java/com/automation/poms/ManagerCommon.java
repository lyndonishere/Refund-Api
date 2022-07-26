package com.automation.poms;

import java.util.List;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManagerCommon {

    private WebDriver driver;

    public ManagerCommon(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    

    // Entering in request ID
    @FindBy(id = "enter-reimbursement-id")  
    public WebElement enterReimbursementId; 

    public void enterReimbursementId(String reimbursementId){
        this.enterReimbursementId.sendKeys(reimbursementId);
    }

    // Select approve
    public void dropdownApprove(){
        Select dropdownApproveChoice = new Select(driver.findElement(By.id("select-decision")));
        String dropdownApproveOption = "Approved";
        dropdownApproveChoice.selectByValue(dropdownApproveOption);

        List<WebElement> dropdownApproveOptions = dropdownApproveChoice.getAllSelectedOptions();
        assertEquals(1, dropdownApproveOptions.size());
        assertEquals(dropdownApproveOption, dropdownApproveOptions.get(0).getAttribute("value"));
    }

    // Entering in reason description
    @FindBy(id = "enter-decision-reason")
    public WebElement enterDecisionReason;

    public void enterDecisionReason(String reason){
        this.enterDecisionReason.sendKeys(reason);
    }

    // Click Submit
    @FindBy(id = "submit-button")
    public WebElement submitDecision;

    public void submitDecision(){
        this.submitDecision.click();
        WebDriverWait waitAccept = new WebDriverWait(driver,10);
        waitAccept.until(ExpectedConditions.alertIsPresent());
        Alert alertAccept = driver.switchTo().alert();
        alertAccept.accept();
    }
    
}
