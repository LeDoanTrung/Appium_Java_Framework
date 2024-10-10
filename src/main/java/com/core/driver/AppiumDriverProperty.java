package com.core.driver;

import com.constant.SettingConstant;
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
        this.desiredCapabilities.setCapability(MobileCapabilityTypeExtends.APP_PACKAGE, SettingConstant.APP_PACKAGE);
        this.desiredCapabilities.setCapability(MobileCapabilityTypeExtends.APP_ACTIVITY, SettingConstant.APP_ACTIVITY);
        this.platformName = platformName;
        this.platformVersion = platformVersion;
        this.deviceName = deviceName;
        this.automationName = automationName;
        this.appiumServerUrl = new URL(appiumServerUrl);
    }

    public DesiredCapabilities getDesiredCapabilities() {
        return desiredCapabilities;
    }

    public URL getAppiumServerUrl() {
        return appiumServerUrl;
    }

    public String getPlatformName() {
        return platformName;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getAutomationName() {
        return automationName;
    }

    public String getCommandTimeout() {
        return commandTimeout;
    }

}
