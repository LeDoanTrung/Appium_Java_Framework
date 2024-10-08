package com.core.driver;

public class AppiumDriverProperty {
    private String platformName;
    private String platformVersion;
    private String deviceName;
    private String appPackage;
    private String appActivity;
    private String automationName;
    private String commandTimeout;

    public AppiumDriverProperty(String platformName, String platformVersion, String deviceName, String appPackage, String appActivity, String automationName, String commandTimeout) {
        this.platformName = platformName;
        this.platformVersion = platformVersion;
        this.deviceName = deviceName;
        this.appPackage = appPackage;
        this.appActivity = appActivity;
        this.automationName = automationName;
        this.commandTimeout = commandTimeout;
    }



}
