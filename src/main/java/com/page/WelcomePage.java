package com.page;

import com.core.element.Element;
import io.appium.java_client.AppiumBy;

public class WelcomePage extends BasePage{

    //Element

    private Element _skipButton = new Element(AppiumBy.xpath("//android.widget.Button[@text='SKIP']"));
    private Element _nextButton = new Element(AppiumBy.xpath("//android.widget.Button[@text='NEXT']"));

    //Method
    public HomePage clickSkipButton() {
        _skipButton.click();
        return new HomePage();
    }

    public void clickNextButton() {
        _nextButton.click();
    }

}
