package com.core.report;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestResult;

public class ExtentTestManager {
    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<>();
    private static ThreadLocal<ExtentTest> childTest = new ThreadLocal<>();


    public static ExtentTest createParentTest(String testName, String description) {
        ExtentTest parent = ExtentReportManager.getInstance().createTest(testName, description);
        parentTest.set(parent);
        return parentTest.get();
    }


    public static ExtentTest createTest(String testName, String description) {
        String simpleName = testName.substring(testName.lastIndexOf(".") + 1);
        ExtentTest child = parentTest.get().createNode(simpleName, description);
        childTest.set(child);
        return childTest.get();
    }


    public static ExtentTest getTest() {
        return childTest.get();
    }


    public static void updateTestReport(ITestResult result) {
        switch (result.getStatus()) {
            case ITestResult.FAILURE:
                getTest().fail("Test failed with message: " + result.getThrowable().getMessage());
                getTest().fail("Stacktrace: " + result.getThrowable());
                break;
            case ITestResult.SKIP:
                getTest().skip("Test skipped with message: " + result.getThrowable().getMessage());
                break;
            case ITestResult.SUCCESS:
                getTest().pass("Test passed");
                break;
            default:
                getTest().log(Status.WARNING, "Test finished with unknown status");
                break;
        }
    }
}
