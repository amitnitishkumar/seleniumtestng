package com.example.assignment.page;

import com.automation.core.enums.LogType;
import com.automation.core.enums.WaitStrategy;
import com.automation.core.reports.FrameworkLogger;
import com.example.assignment.locatorepos.McPizzaAgentLocators;
import org.openqa.selenium.WebElement;

import java.util.List;

public final class McPizzaAgentLoginPage extends BasePage implements McPizzaAgentLocators {
    private McPizzaAgentLoginPage(){}
    public McPizzaAgentLoginPage clickOnAgent(){
        FrameworkLogger.log(LogType.INFO,"user clicks on McPizza Agent");
        webDriverUtils.click(CHATAGENTBTN, WaitStrategy.CLICKABLE);
        return this;
    }

    public McPizzaAgentLoginPage enterFirstName(String name){
        FrameworkLogger.log(LogType.INFO,"user enters first name");
        webDriverUtils.switchInIframe(FRAMENAME);
        webDriverUtils.sendKey(FIRSTNAMEINPUT,name,WaitStrategy.NONE);
        return this;
    }

    public McPizzaAgentLoginPage enterEmail(String email){
        FrameworkLogger.log(LogType.INFO,"user enters email");
        webDriverUtils.sendKey(EMAILINPUT,email,WaitStrategy.NONE);
        return this;
    }

    public McPizzaAgentLoginPage clickNext(){
        FrameworkLogger.log(LogType.INFO, "user hits on next");
        webDriverUtils.click(NEXTBTN,WaitStrategy.NONE);
        webDriverUtils.switchToDefaultContent();
        return this;
    }

    public McPizzaAgentLoginPage getStarted(){
        if (!webDriverUtils.getElements(GETSTARTEDBTN,true, 3).isEmpty()){
            FrameworkLogger.log(LogType.INFO, "user hits on Get-Started btn");
            webDriverUtils.click(GETSTARTEDBTN,WaitStrategy.VISIBLE);
        }
        return this;
    }

    public McPizzaAgentLoginPage verifyWelcomePage(){
        webDriverUtils.switchInIframe(FRAMENAME);
        List<WebElement> welcomePageChats = webDriverUtils.getElements(BOTRESPONSE,true);
        if(!welcomePageChats.isEmpty())
            FrameworkLogger.log(LogType.PASS, "successful login to chat box");
        webDriverUtils.switchToDefaultContent();
        return this;
    }

    public static McPizzaAgentLoginPage getInstance(){
        FrameworkLogger.log(LogType.INFO,"creating a new isntance of McPizzaAgentLoginPage class" );
        return new McPizzaAgentLoginPage();
    }


}
