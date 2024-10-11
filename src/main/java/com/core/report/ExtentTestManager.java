package com.core.report;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestResult;

public class ExtentTestManager {
    // ThreadLocal for each thread's parent test
    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<>();

    // ThreadLocal for each thread's child test (i.e., node test)
    private static ThreadLocal<ExtentTest> childTest = new ThreadLocal<>();

    // Create the parent test (this represents the main test method)
    public static ExtentTest createParentTest(String testName, String description) {
        ExtentTest parent = ExtentReportManager.getInstance().createTest(testName, description);
        parentTest.set(parent);
        return parentTest.get();
    }

    // Create a node for finer control over the test steps
    public static ExtentTest createNodeTest(String testName, String description) {
        String simpleName = testName.substring(testName.lastIndexOf(".") + 1);
        ExtentTest child = parentTest.get().createNode(simpleName, description);
        childTest.set(child);
        return childTest.get();
    }

    // Get the current child test (node test)
    public static ExtentTest getTest() {
        return childTest.get();
    }

    // Update the test report based on the result of the test
    public static void updateTestReport(ITestResult result) {
        switch (result.getStatus()) {
            case ITestResult.FAILURE:
                getTest().fail("Stacktrace: " + result.getThrowable());
                ReportLog.fail("Test failed with message: " + result.getThrowable().getMessage());
                break;
            case ITestResult.SKIP:
                ReportLog.skip("Test skipped with message: " + result.getThrowable().getMessage());
                break;
            case ITestResult.SUCCESS:
                ReportLog.pass("Test passed");
                break;
            default:
                getTest().log(Status.WARNING, "Test finished with unknown status");
                break;
        }
    }
}