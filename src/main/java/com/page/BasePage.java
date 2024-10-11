package com.page;

import com.core.element.Element;
import io.appium.java_client.AppiumBy;

public class BasePage {
    //Common element
    protected Element _message (String contentMessage){
        return new Element(AppiumBy.xpath(String.format("//android.widget.TextView[@text='%s']", contentMessage)));
    }
    //Common method for all pages

}
