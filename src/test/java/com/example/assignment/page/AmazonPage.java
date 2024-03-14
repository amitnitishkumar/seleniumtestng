package com.example.assignment.page;

import com.automation.core.enums.LogType;
import com.automation.core.enums.WaitStrategy;
import com.automation.core.reports.FrameworkLogger;
import com.example.assignment.locatorepos.AmazonLocators;

public final class AmazonPage extends BasePage implements AmazonLocators {

    private AmazonPage(){}
    public AmazonPage setsSearchProduct(String productName){
        FrameworkLogger.log(LogType.INFO, "Search product '"+productName+"'");
        webDriverUtils.sendKey(AmazonLocators.SEARCHINPUTBOX,productName, WaitStrategy.VISIBLE);
        return this;
    }

    public AmazonPage clickSearchBtn(){
        webDriverUtils.click(AmazonLocators.SEARCHBTN,WaitStrategy.NONE);
        return this;
    }

    public static AmazonPage getInstance(){
        FrameworkLogger.log(LogType.INFO,"created new instance of AmazonPage");
        return new AmazonPage();
    }


}
