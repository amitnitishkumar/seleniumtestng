package com.automation.core.listners;

import com.automation.core.customannotations.TestMetaData;
import com.automation.core.reports.ExtentReport;
import org.testng.*;

import java.util.Arrays;

import static com.automation.core.enums.LogType.*;
import static com.automation.core.reports.FrameworkLogger.log;

public class ListenerClass implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {

        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();

    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentReport.createTest(result.getMethod().getDescription());
        ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TestMetaData.class)
                .author());
        ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TestMetaData.class)
                .category());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //ExtentLogger.pass(result.getMethod().getMethodName() +" is passed");
        log(PASS,result.getMethod().getMethodName() +" is passed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        log(FAIL,result.getMethod().getMethodName() +" is failed");
        log(FAIL,result.getThrowable().toString());
        log(FAIL, Arrays.toString(result.getThrowable().getStackTrace()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        //ExtentLogger.skip(result.getMethod().getMethodName() +" is skipped");
        log(SKIP,result.getMethod().getMethodName() +" is skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        /*
         * For now, we are not using this.
         */
    }

    @Override
    public void onStart(ITestContext context) {
        /*
         * We are having just one test in our suite. So we dont have any special implementation as of now
         */
    }

    @Override
    public void onFinish(ITestContext context) {
        /*
         * We are having just one test in our suite. So we dont have any special implementation as of now
         */

    }

}
