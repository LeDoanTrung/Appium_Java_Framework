package com.core.report;

import com.aventstack.extentreports.MediaEntityBuilder;

public class ReportLog {

    public static void info(String message) {
        ExtentTestManager.getTest().info(message);
    }

    public static void pass(String message) {
        ExtentTestManager.getTest().pass(message);
    }

    public static void fail(String message, String mediaPath) {
        if (mediaPath != null && !mediaPath.isEmpty()) {
            ExtentTestManager.getTest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromPath(mediaPath).build());
        } else {
            ExtentTestManager.getTest().fail(message);
        }
    }

    public static void skip(String message) {
        ExtentTestManager.getTest().skip(message);
    }
}
