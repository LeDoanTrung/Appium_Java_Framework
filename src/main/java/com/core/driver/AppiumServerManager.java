package com.core.driver;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServerManager {
    private static AppiumDriverLocalService service;

    public static void startServer() {
        service = new AppiumServiceBuilder().usingAnyFreePort().build();
        service.start();
    }

    public static void stopServer() {
        if (service != null) {
            service.stop();
        }
    }

    public static boolean isServerRunning() {
        return service != null && service.isRunning();
    }
}
