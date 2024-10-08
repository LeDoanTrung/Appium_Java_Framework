package com.core.driver;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumDriverManager {

    private static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();

    private static ThreadLocal<AppiumDriverManager> driver = new ThreadLocal<>();

    public static void initDriver(String driverName) {



    }
}
