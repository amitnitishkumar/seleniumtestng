package com.automation.core.listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import com.automation.core.utils.PropertyUtils;
import com.automation.core.enums.ConfigProperties;


public class RetryFailedTests implements IRetryAnalyzer {

    private int count=0;
    private int retries = 1;
    @Override
    public boolean retry(ITestResult result) {
        boolean value =false;

        if(PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
            value = count<retries ;
            count++;
        }
        return value;
    }
}
