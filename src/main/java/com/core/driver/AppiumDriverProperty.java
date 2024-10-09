package com.core.driver;

import com.core.constant.Constant;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class AppiumDriverProperty {

    private String platformName;
    private String platformVersion;
    private String deviceName;
    private String appPackage;
    private String appActivity;
    private String automationName;
    private String commandTimeout;

    private DesiredCapabilities desiredCapabilities;
    private URL appiumServerUrl;

    public AppiumDriverProperty(String platformName, String platformVersion, String deviceName, String automationName, String appiumServerUrl) throws MalformedURLException {
        this.desiredCapabilities = new DesiredCapabilities();
        this.appiumServerUrl = new URL(appiumServerUrl);
        this.desiredCapabilities.setCapability(MobileCapabilityTypeExtends.PLATFORM_NAME, platformName);
        this.desiredCapabilities.setCapability(MobileCapabilityTypeExtends.PLATFORM_VERSION, platformVersion);
        this.desiredCapabilities.setCapability(MobileCapabilityTypeExtends.DEVICE_NAME, deviceName);
        this.desiredCapabilities.setCapability(MobileCapabilityTypeExtends.AUTOMATION_NAME, automationName);
        this.desiredCapabilities.setCapability(MobileCapabilityTypeExtends.NEW_COMMAND_TIMEOUT, 300);
        this.desiredCapabilities.setCapability(MobileCapabilityTypeExtends.APP_PACKAGE, Constant.APP_PACKAGE);
        this.desiredCapabilities.setCapability(MobileCapabilityTypeExtends.APP_ACTIVITY, Constant.APP_ACTIVITY);
    }

    public DesiredCapabilities getDesiredCapabilities() {
        return desiredCapabilities;
    }

    public URL getAppiumServerUrl() {
        return appiumServerUrl;
    }
}
