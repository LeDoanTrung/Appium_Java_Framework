package com.core.driver;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServerManager {
    private static AppiumDriverLocalService service;
    private static final Object lock = new Object();

    public static void startServer() {
        synchronized (lock) {
            if (service == null || !service.isRunning()) {
                service = new AppiumServiceBuilder().usingPort(4723).build();
                service.start();
            }
        }
    }

    public static void stopServer() {
        synchronized (lock) {
            if (service != null && service.isRunning()) {
                service.stop();
            }
        }
    }

    public static boolean isServerRunning() {
        synchronized (lock) {
            return service != null && service.isRunning();
        }
    }
}
