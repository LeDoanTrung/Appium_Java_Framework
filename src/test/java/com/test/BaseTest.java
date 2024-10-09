package com.test;

import com.core.config.ConfigurationHelper;
import com.core.driver.AppiumDriverManager;
import com.hook.Hooks;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;

public class BaseTest {

    @BeforeTest
    public void OneTimeSetup() throws MalformedURLException {
        String platformName = ConfigurationHelper.getConfigurationByKey(Hooks.config, "platformName");
        String platformVersion = ConfigurationHelper.getConfigurationByKey(Hooks.config, "platformVersion");
        String deviceName = ConfigurationHelper.getConfigurationByKey(Hooks.config, "deviceName");
        String automationName = ConfigurationHelper.getConfigurationByKey(Hooks.config, "automationName");
        String appiumServerUrl = ConfigurationHelper.getConfigurationByKey(Hooks.config, "appiumServerUrl");

        AppiumDriverManager.initDriver(platformName, platformVersion, deviceName, automationName, appiumServerUrl);

    }

    // Add @AfterTest here
    @AfterTest
    public void tearDown() {
        AppiumDriverManager.quitDriver();
    }


}
