package com.page;

import com.core.element.Element;
import io.appium.java_client.AppiumBy;

public class MenuBar {

    private Element _menuBar = new Element(AppiumBy.accessibilityId("App"));
    private  Element _myAccount = new Element(AppiumBy.xpath("//android.widget.CheckedTextView[@text='My Account']"));

    public void clickMenuBar() {
        _menuBar.click();
    }

    public void clickMyAccount() {
        _myAccount.click();
    }
}
