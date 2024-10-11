package com.core.report;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.core.driver.AppiumDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReportLog {

    public static void info(String message) {
        ExtentTestManager.getTest().info(message);
    }

    public static void pass(String message) {
        ExtentTestManager.getTest().pass(message);
    }

    public static void fail(String message) {
        String screenshotPath = captureScreenshot();
        if (screenshotPath != null) {
            ExtentTestManager.getTest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            ExtentTestManager.getTest().fail(message);
        }
    }

    public static void skip(String message) {
        ExtentTestManager.getTest().skip(message);
    }

    private static String captureScreenshot() {
        TakesScreenshot ts = (TakesScreenshot) AppiumDriverManager.getDriver();
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        String destPath = System.getProperty("user.dir") + "/TestResults/Screenshots/" + System.currentTimeMillis() + ".png";
        try {
            Files.createDirectories(Paths.get(System.getProperty("user.dir") + "/TestResults/Screenshots/"));
            Files.copy(srcFile.toPath(), Paths.get(destPath));
            return destPath;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
