package com.automation.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EmployeeCommon {

    public EmployeeCommon(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
}
