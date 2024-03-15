package com.example.assignment.module;

import com.automation.core.enums.LogType;
import com.automation.core.reports.FrameworkLogger;
import com.example.assignment.locatorepos.McPizzaAgentLocators;
import com.example.assignment.page.McPizzaAgentLoginPage;
import com.example.assignment.page.McPizzaWelcomePage;

import java.util.Map;

public final class McPizzaAgentModule {

    private McPizzaAgentModule(){}
    public McPizzaAgentModule loginToMcPizzaAgent(Map<String,String> testData){
        McPizzaAgentLoginPage.getInstance()
                .clickOnAgent()
                .getStarted()
                .enterFirstName(testData.get("firstname"))
                .enterEmail(testData.get("email"))
                .clickNext()
                .verifyWelcomePage();
        return this;
    }

    public McPizzaAgentModule placeAnOrder(Map<String,String> testData){
        McPizzaWelcomePage welcomePage = McPizzaWelcomePage.getInstance();
        welcomePage.switchToFrame(McPizzaAgentLocators.FRAMENAME);
        welcomePage.enterQueryToBot(testData.get("query1"))
                .hitSend()
                .logBotResponse()
                .enterQueryToBot(testData.get("query2"))
                .hitSend()
                .logBotResponse()
                .selectToping(testData.get("topping"))
                .clickSubmit("Submit")
                .verifyPizzaSubmitted()
                .logBotResponse()
                .selectCrust(testData.get("crust"))
                .logBotResponse()
                .selectBotOptions(testData.get("pizza_size"))
                .logBotResponse()
                .selectBotOptions("Yes")
                .verifyOrderPlaced();
        welcomePage.switchToDefaultContent();
        return this;
    }

    public McPizzaAgentModule giveFeedback(Map<String,String> testData){
        McPizzaWelcomePage welcomePage = McPizzaWelcomePage.getInstance();
        welcomePage.switchToFrame(McPizzaAgentLocators.FRAMENAME);
        welcomePage.clickFeedBackIcon(testData.get("feedback_icon"))
                .selectFeedback(testData.get("feedback_pick"))
                .clickSubmit("Submit")
                .verifyFeedBackSubmition(testData.get("feedback_msg"));
        welcomePage.switchToDefaultContent();
        return this;
    }

    public McPizzaAgentModule makeUnfullfilledQuery(Map<String,String> testData) {
        McPizzaWelcomePage welcomePage = McPizzaWelcomePage.getInstance();
        welcomePage.switchToFrame(McPizzaAgentLocators.FRAMENAME);
        welcomePage.enterQueryToBot(testData.get("query1"))
                .hitSend()
                .verifyRejectedQuery(testData.get("unfullfilled_msg"));
        welcomePage.switchToDefaultContent();
        return this;
    }



    public static McPizzaAgentModule getInstance(){
        FrameworkLogger.log(LogType.INFO, "create a new instance of McPizzaAgentModule class");
        return new McPizzaAgentModule();
    }



}
