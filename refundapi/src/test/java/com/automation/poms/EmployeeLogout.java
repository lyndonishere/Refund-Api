package com.automation.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EmployeeLogout {

    public EmployeeLogout(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
}
