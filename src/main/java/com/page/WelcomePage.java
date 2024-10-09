package com.page;

import com.core.element.Element;
import io.appium.java_client.AppiumBy;

public class WelcomePage extends BasePage {

    //Element
    private Element _skipButton = new Element(AppiumBy.xpath("//android.widget.Button[@text='SKIP']"));
    private Element _nextButton = new Element(AppiumBy.xpath("//android.widget.Button[@text='NEXT']"));

    //Method
    public void clickSkipButton() {
        _skipButton.click();
    }

    public void clickNextButton() {
        _nextButton.click();
    }

}
