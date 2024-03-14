package com.automation.core.testbase;

import com.automation.core.driver.Driver;
import com.automation.core.enums.LogType;
import com.automation.core.reports.FrameworkLogger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

public abstract class BaseTest {
    protected BaseTest() {}


    @SuppressWarnings("unchecked")
    @BeforeMethod
    protected void setUp(Object[] data) { //Map<String,String>
        Map<String,String> map = (Map<String,String>)data[0];
        Driver.initDriver(map.get("browser"));
    }

    @AfterMethod
    protected void tearDown(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE){
            FrameworkLogger.log(LogType.FAIL, result.getThrowable().getMessage());
            throw new RuntimeException(result.getThrowable().getMessage());
        }
        Driver.quitDriver();
    }
}
