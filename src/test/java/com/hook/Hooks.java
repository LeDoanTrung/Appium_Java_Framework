package com.hook;

import com.core.config.ConfigurationHelper;
import com.core.driver.AppiumServerManager;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Hooks {
    public static JsonNode config;

    private static final String APP_SETTING_PATH = "setting/appSettings.json";

    @BeforeSuite
    public void mySetup(ITestContext context) {
        System.out.println("====> Global one time setup");

        // Read Configuration file
        config = ConfigurationHelper.readConfiguration(APP_SETTING_PATH);

        // Start Appium Server
        AppiumServerManager.startServer();

    }

    @AfterSuite
    public void tearDown() {
        System.out.println("====> Global one time teardown");
        // Stop Appium Server
        AppiumServerManager.stopServer();
    }
}
