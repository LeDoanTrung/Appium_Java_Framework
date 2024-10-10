package com.core.report;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentReportManager {
    private static ExtentReports extentReports;

    public static ExtentReports getInstance() {
        if (extentReports == null) {
            extentReports = new ExtentReports();
            initReport();
        }
        return extentReports;
    }


    private static void initReport() {

        String projectPath = System.getProperty("user.dir");
        String reportPath = projectPath + File.separator + "TestResults";

        File reportDir = new File(reportPath);
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }

        ExtentSparkReporter htmlReporter = createHtmlReporter(reportPath);
        extentReports.attachReporter(htmlReporter);
    }


    private static ExtentSparkReporter createHtmlReporter(String reportPath) {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath + File.separator + "result.html");

        htmlReporter.config().setReportName("Test Automation Report");
        htmlReporter.config().setEncoding("UTF-8");
        htmlReporter.config().setDocumentTitle("Test Automation Report");
        htmlReporter.config().setTheme(Theme.STANDARD);

        return htmlReporter;
    }


    public static void generateReport() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }
}

