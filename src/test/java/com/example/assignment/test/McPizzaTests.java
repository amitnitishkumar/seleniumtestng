package com.example.assignment.test;

import com.automation.core.customannotations.TestMetaData;
import com.automation.core.enums.CategoryType;
import com.automation.core.reports.ExtentManager;
import com.automation.core.testbase.BaseTest;
import com.example.assignment.module.McPizzaAgentModule;
import org.testng.annotations.Test;

import java.util.Map;

public class McPizzaTests extends BaseTest {

    @Test(dataProvider = "serial")
    @TestMetaData(author = "Nitish",category = CategoryType.REGRESSION)
    public void placeOrderMcPizza(Map<String,String> testData){
        ExtentManager.getExtentTest().getModel().setName(testData.get("testdescription"));
        McPizzaAgentModule.getInstance()
                .loginToMcPizzaAgent(testData)
                .placeAnOrder(testData)
                .giveFeedback(testData);
    }

    @Test(dataProvider = "serial")
    @TestMetaData(author = "Nitish",category = CategoryType.REGRESSION)
    public void unFullfilledQuery(Map<String,String> testData){
        ExtentManager.getExtentTest().getModel().setName(testData.get("testdescription"));
        McPizzaAgentModule.getInstance()
                .loginToMcPizzaAgent(testData)
                .makeUnfullfilledQuery(testData);
    }


}
