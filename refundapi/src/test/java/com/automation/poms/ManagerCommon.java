package com.automation.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ManagerCommon {

    public ManagerCommon(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
}
