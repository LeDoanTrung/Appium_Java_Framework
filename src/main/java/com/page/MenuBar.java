package com.page;

import com.core.element.Element;
import io.appium.java_client.AppiumBy;

public class MenuBar {

    private Element _menuBar = new Element(AppiumBy.accessibilityId("App"));
    private  Element _section(String sectionName) {
        return new Element(AppiumBy.xpath(String.format("//android.widget.CheckedTextView[@text='%s']", sectionName)));
    }

    public void clickMenuBar() {
        _menuBar.click();
    }

    public void clickOnSection(String sectionName) {
        _section(sectionName).click();
    }

}
