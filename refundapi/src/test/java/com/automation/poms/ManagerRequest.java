package com.automation.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ManagerRequest {

    public ManagerRequest(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
}
