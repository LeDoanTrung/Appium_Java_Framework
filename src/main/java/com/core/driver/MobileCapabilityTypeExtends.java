package com.core.driver;

import io.appium.java_client.remote.MobileCapabilityType;

public interface MobileCapabilityTypeExtends extends MobileCapabilityType {
    String AUTOMATION_NAME = "automationName";
    String DEVICE_NAME = "deviceName";
    String PLATFORM_NAME = "platformName";
    String PLATFORM_VERSION = "platformVersion";
    String APP_PACKAGE = "appPackage";
    String APP_ACTIVITY = "appActivity";
    String APP = "app";
    String BROWSER_NAME = "browserName";
    String NEW_COMMAND_TIMEOUT = "newCommandTimeout";
    String LANGUAGE = "language";
    String LOCALE = "locale";
    String UDID = "udid";
    String ORIENTATION = "orientation";
    String AUTO_WEBVIEW = "autoWebview";
    String NO_RESET = "noReset";
    String FULL_RESET = "fullReset";
    String EVENT_TIMINGS = "eventTimings";
    String ENABLE_PERFORMANCE_LOGGING = "enablePerformanceLogging";
    String PRINT_PAGE_SOURCE_ON_FIND_FAILURE = "printPageSourceOnFindFailure";
    String DEFAULT_DEVICE = "defaultDevice";
    String SHOW_XCODE_LOG = "showXcodeLog";
    String SEND_KEY_STRATEGY = "sendKeyStrategy";
    String SCREENSHOT_PATH = "screenshotPath";
    String IMAGE_MATCH_THRESHOLD = "imageMatchThreshold";
    String CLEAR_SYSTEM_FILES = "clearSystemFiles";
    String IGNORE_UNIMPORTANT_VIEWS = "ignoreUnimportantViews";
    String SCREEN_RECORD = "screenRecord";
    String LOCATION_SERVICES_ENABLED = "locationServicesEnabled";
    String LOCATION_SERVICES_ALLOWED = "locationServicesAllowed";
    String AUTO_ACCEPT_ALERTS = "autoAcceptAlerts";
}
