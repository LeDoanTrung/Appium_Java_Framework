package com.test;

import com.constant.FilePathConstant;
import com.constant.SettingConstant;
import com.core.config.ConfigurationHelper;
import com.core.driver.AppiumDriverManager;
import com.core.driver.AppiumServerManager;
import com.core.emulator.AndroidEmulatorManager;
import com.core.report.ExtentReportManager;
import com.core.report.ExtentTestManager;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;

public class BaseTest {

    public static JsonNode config;
    public AndroidEmulatorManager androidEmulatorManager;

    @BeforeSuite
    public void mySetup() throws IOException, InterruptedException {
        System.out.println("====> Global one time setup");

        // Read Configuration file
        config = ConfigurationHelper.readConfiguration(FilePathConstant.APP_SETTING_PATH);
        androidEmulatorManager = new AndroidEmulatorManager(SettingConstant.DEFAULT_EMULATOR);

        //Start Emulator
        androidEmulatorManager.startEmulator();

        // Start Appium Server
        if (!AppiumServerManager.isServerRunning()){
            AppiumServerManager.startServer();
        }

    }

    @BeforeTest
    public void OneTimeSetup() throws MalformedURLException {

    }

    @BeforeClass
    public void beforeClassSetup(ITestContext context) {
        ExtentTestManager.createParentTest(context.getCurrentXmlTest().getName(), "Extent Test Report");
    }

    @BeforeMethod
    public void beforeMethodSetup() throws MalformedURLException {
        String platformName = ConfigurationHelper.getConfigurationByKey(config, "platformName");
        String platformVersion = ConfigurationHelper.getConfigurationByKey(config, "platformVersion");
        String deviceName = ConfigurationHelper.getConfigurationByKey(config, "deviceName");
        String automationName = ConfigurationHelper.getConfigurationByKey(config, "automationName");
        String appiumServerUrl = ConfigurationHelper.getConfigurationByKey(config, "appiumServerURL");

        AppiumDriverManager.initDriver(platformName, platformVersion, deviceName, automationName, appiumServerUrl);
        ExtentTestManager.createNodeTest(getClass().getName(), "");
    }

    @AfterTest
    public void afterTestTearDown() {

    }

    @AfterMethod
    public void afterMethodTearDown(ITestResult result) {
        ExtentTestManager.updateTestReport(result);
        AppiumDriverManager.quitDriver();
    }

    @AfterSuite
    public void afterSuiteTearDown() throws IOException, InterruptedException {
        AppiumServerManager.stopServer();
        ExtentReportManager.generateReport();
        androidEmulatorManager.stopEmulator();
    }
}
