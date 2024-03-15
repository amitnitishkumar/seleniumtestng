package com.example.assignment.page;

import com.automation.core.enums.DynamicLocatorType;
import com.automation.core.enums.LogType;
import com.automation.core.enums.WaitStrategy;
import com.automation.core.reports.FrameworkLogger;
import com.automation.core.utils.CommonUtils;
import com.example.assignment.locatorepos.McPizzaAgentLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class McPizzaWelcomePage extends BasePage implements McPizzaAgentLocators {
    private McPizzaWelcomePage(){}

    public McPizzaWelcomePage enterQueryToBot(String query){
        FrameworkLogger.log(LogType.INFO,"Enter the query to bot");
        webDriverUtils.sendKey(QUERYTEXTAREA,query, WaitStrategy.VISIBLE);
        return this;
    }

    public McPizzaWelcomePage hitSend(){
        webDriverUtils.click(SENDQUERYLABEL,WaitStrategy.NONE);
        webDriverUtils.waitUntilLocatorAppearAndDisAppear(TRIPLEDOT,2);
        return this;
    }

    public McPizzaWelcomePage logBotResponse(){
        List<WebElement> botResponseObj = webDriverUtils.getElements(BOTRESPONSE,true);
        String lastResponse = botResponseObj.get(botResponseObj.size()-1).getText();
        FrameworkLogger.log(LogType.INFO, "bot response is--> "+ CommonUtils.cleanInput(lastResponse));
        return this;
    }

    public McPizzaWelcomePage selectBotOptions(String value){
        webDriverUtils.click(
                CommonUtils.modifyDynamicLocator(
                        DynamicLocatorType.XPATH,SELECTBOTOPTIONS,value),WaitStrategy.VISIBLE);
        FrameworkLogger.log(LogType.INFO,"Select "+value);
        webDriverUtils.waitUntilLocatorAppearAndDisAppear(TRIPLEDOT,2);
        return this;
    }

    private String getLastBotMessage(){
        List<WebElement> botResponseObj = webDriverUtils.getElements(BOTRESPONSE,true);
        return botResponseObj.get(botResponseObj.size()-1).getText();
    }

    public McPizzaWelcomePage verifyOrderPlaced(){
        String lastResponse = CommonUtils.cleanInput(getLastBotMessage());
        FrameworkLogger.log(LogType.INFO,CommonUtils.cleanInput(lastResponse));
        if(lastResponse.contains("CONGRATS ORDER PLACED"))
            FrameworkLogger.log(LogType.PASS,"order placed successfully");
        else
            FrameworkLogger.log(LogType.FAIL,"some problem occurred while placing the order");
        return this;
    }

    public McPizzaWelcomePage selectToping(String value){
        webDriverUtils.actionClickElement(
                CommonUtils.modifyDynamicLocator(DynamicLocatorType.XPATH,TOPPINGCHKBOX,value),
                WaitStrategy.VISIBLE
        );
        FrameworkLogger.log(LogType.INFO,"selected topping '"+value+"'");
        return this;
    }

    public McPizzaWelcomePage clickSubmit(String action){
        webDriverUtils.click(
                CommonUtils.modifyDynamicLocator(DynamicLocatorType.XPATH,SUBMITBTN,action),
                WaitStrategy.VISIBLE
        );
        return this;
    }

    public McPizzaWelcomePage verifyPizzaSubmitted(){
        webDriverUtils.waitUntilLocatorAppear(
                CommonUtils.modifyDynamicLocator(DynamicLocatorType.XPATH,SUBMITBTN,"Submitted successfully"),
                5
        );
        if (webDriverUtils.getElement.apply(WaitStrategy.NONE,CommonUtils.modifyDynamicLocator(DynamicLocatorType.XPATH,SUBMITBTN,"Submitted successfully")).isDisplayed())
            FrameworkLogger.log(LogType.PASS, "Choice Submitted");
        else
            FrameworkLogger.log(LogType.FAIL, "Failed to select your choice");
        return this;
    }

    public McPizzaWelcomePage selectCrust(String value){
        FrameworkLogger.log(LogType.INFO,"select crust");
        webDriverUtils.click(
                CommonUtils.modifyDynamicLocator(DynamicLocatorType.XPATH,CRUSTLABEL,value),
                WaitStrategy.VISIBLE
        );
        return this;
    }

    public McPizzaWelcomePage clickFeedBackIcon(String feedbackType){
        webDriverUtils.click(
                CommonUtils.modifyDynamicLocator(DynamicLocatorType.CSS,FEEDBACKICON,feedbackType),
                WaitStrategy.VISIBLE
        );
        return this;
    }

    public McPizzaWelcomePage selectFeedback(String pickFeedback){
        webDriverUtils.actionClickElement(PICKCOMBOBOX,WaitStrategy.VISIBLE);
        webDriverUtils.click(
                CommonUtils.modifyDynamicLocator(DynamicLocatorType.XPATH,COMBOXOPTION,pickFeedback),
        WaitStrategy.VISIBLE);
        return this;
    }

    public McPizzaWelcomePage verifyFeedBackSubmition(String msg){
        By loc = CommonUtils.modifyDynamicLocator(DynamicLocatorType.XPATH,FEEDBACKSUMITIONMSG,msg);
        if (webDriverUtils.getElement.apply(WaitStrategy.VISIBLE,loc).isDisplayed())
            FrameworkLogger.log(LogType.PASS,"Feedback msg verified");
        else FrameworkLogger.log(LogType.FAIL,"Could not read feedback");
        return this;
    }

    public McPizzaWelcomePage verifyRejectedQuery(String expResponse){
        String lastResponse = CommonUtils.cleanInput(getLastBotMessage());
        FrameworkLogger.log(LogType.INFO,CommonUtils.cleanInput(lastResponse));
        if(lastResponse.equalsIgnoreCase(expResponse))
            FrameworkLogger.log(LogType.PASS,expResponse);
        else
            FrameworkLogger.log(LogType.FAIL,"some problem occurred");
        return this;
    }


    public static McPizzaWelcomePage getInstance(){
        FrameworkLogger.log(LogType.INFO,"creating a new instance of McPizzaWelcomePage class" );
        return new McPizzaWelcomePage();
    }


}
