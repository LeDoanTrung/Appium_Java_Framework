package com.core.driver;

import com.core.enumobj.EnumObject.MOBILE_PLATFORM;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class AppiumDriverCreator {
    public static AppiumDriver startDriver(AppiumDriverProperty appiumDriverProperty) {
        AppiumDriver driver;

         if (appiumDriverProperty.getDesiredCapabilities().getPlatformName().toString().toUpperCase().equals(MOBILE_PLATFORM.ANDROID)){
            driver = new AndroidDriver(appiumDriverProperty.getAppiumServerUrl(), appiumDriverProperty.getDesiredCapabilities());
         }
         else if (appiumDriverProperty.getDesiredCapabilities().getPlatformName().toString().toUpperCase().equals(MOBILE_PLATFORM.IOS)){
            driver = new IOSDriver(appiumDriverProperty.getAppiumServerUrl(), appiumDriverProperty.getDesiredCapabilities());
         }
         else {
            throw new IllegalArgumentException("Invalid platform name");
         }
         return driver;
    }
}
