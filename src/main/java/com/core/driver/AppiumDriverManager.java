package com.core.driver;

import com.constant.SettingConstant;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AppiumDriverManager {

    private static ThreadLocal<AppiumDriver> drivers = new ThreadLocal<>();
    private static ThreadLocal<WebDriverWait> waits = new ThreadLocal<>();

    public static AppiumDriver getDriver() {
        return drivers.get();
    }

    public static WebDriverWait getWait() {
        return waits.get();
    }

    public static void initDriver(String platformName, String platformVersion, String deviceName, String automationName, String appiumServerUrl) throws MalformedURLException {
            AppiumDriverProperty appiumDriverProperty = new AppiumDriverProperty(platformName, platformVersion, deviceName, automationName, appiumServerUrl);
            AppiumDriver driver = AppiumDriverCreator.startDriver(appiumDriverProperty);
            driver.manage().timeouts().implicitlyWait(SettingConstant.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
            drivers.set(driver);
            waits.set(new WebDriverWait(driver, Duration.ofSeconds(SettingConstant.DEFAULT_TIMEOUT)));
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            drivers.remove();
        }
    }
}
