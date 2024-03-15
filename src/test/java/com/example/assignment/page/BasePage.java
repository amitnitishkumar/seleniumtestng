package com.example.assignment.page;

import com.automation.core.driver.DriverManager;
import com.automation.core.utils.WebDriverUtils;

public abstract class BasePage {
    protected WebDriverUtils webDriverUtils;

    protected BasePage(){
        webDriverUtils = new WebDriverUtils(DriverManager.getDriver());
    }

    public void switchToFrame(String nameOrId){
        webDriverUtils.switchInIframe(nameOrId);
    }

    public void switchToDefaultContent(){
        webDriverUtils.switchToDefaultContent();
    }
}
