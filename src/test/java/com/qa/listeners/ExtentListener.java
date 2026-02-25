package com.qa.listeners;

import com.aventstack.extentreports.*;
import com.qa.listeners.ExtentManager;
import org.testng.*;

public class ExtentListener implements ITestListener, IConfigurationListener {

    private static final ExtentReports extent = ExtentManager.getExtentReports();
    private static final ThreadLocal<ExtentTest> tlTest = new ThreadLocal<>();

    private ExtentTest getOrCreateTest(ITestResult result) {
        ExtentTest test = tlTest.get();
        if (test == null) {
            // create it if failure happened before onTestStart
            String name = result.getMethod().getMethodName();
            test = extent.createTest(name);
            tlTest.set(test);
        }
        return test;
    }

    @Override
    public void onTestStart(ITestResult result) {
        String name = result.getMethod().getMethodName();
        ExtentTest test = extent.createTest(name);
        tlTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        getOrCreateTest(result).pass("PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        getOrCreateTest(result).fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        getOrCreateTest(result).skip(result.getThrowable());
    }

    // IMPORTANT: catches @BeforeMethod / config failures
    @Override
    public void onConfigurationFailure(ITestResult itr) {
        ExtentTest test = getOrCreateTest(itr);
        test.fail("CONFIGURATION FAILED (e.g., @BeforeMethod/@AfterMethod)");
        test.fail(itr.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        tlTest.remove();
    }
}
