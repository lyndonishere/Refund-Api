package com.automation.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EmployeeRequest {

    public EmployeeRequest(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
}
