package com.automation.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ManagerLogout {

    public ManagerLogout(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
}
