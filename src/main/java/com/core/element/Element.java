package com.core.element;

import com.core.driver.AppiumDriverManager;
import com.core.util.SwipeActionHelper;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Element {
    private static SwipeActionHelper swipeActionHelper;

    private By appiumBy;

    public Element(By appiumBy) {
        this.appiumBy = appiumBy;
        this.swipeActionHelper = new SwipeActionHelper();
    }

     public WebElement waitForElementToBeVisible() {
         return AppiumDriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(this.appiumBy));
     }

     public WebElement waitForElementToBeClickable() {
         return AppiumDriverManager.getWait().until(ExpectedConditions.elementToBeClickable(this.appiumBy));
     }

     public WebElement waitForElementToBePresent() {
        return AppiumDriverManager.getWait().until(ExpectedConditions.presenceOfElementLocated(this.appiumBy));
     }

    public boolean isElementDisplayed() {
        try {
            WebElement element = waitForElementToBeVisible();
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementEnabled() {
        try {
            WebElement element = AppiumDriverManager.getDriver().findElement(this.appiumBy);
            return element.isDisplayed() && element.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void click() {
        WebElement element = waitForElementToBeClickable();
        element.click();
    }

    public void clickWithSwipe() {
        WebElement element = waitForElementToBeClickable();
        if (!element.isDisplayed()) {
            swipeActionHelper.swipeToBottom();
        }
        element.click();
    }

    public void inputText(String text) {
        WebElement element = waitForElementToBeVisible();
        element.sendKeys(text);
    }

    public String getText() {
        WebElement element = waitForElementToBeVisible();
        return element.getText();
    }

    public void clearText() {
        WebElement element = waitForElementToBeVisible();
        element.clear();
    }

    public static void swipeToBottom() {
        swipeActionHelper.swipeToBottom();
    }

    public static void swipeToBottom(int time) {
        swipeActionHelper.swipeToBottom(time);
    }

    public static void swipeToTop() {
        swipeActionHelper.swipeToTop();
    }

    public static void swipeToTop(int time) {
        swipeActionHelper.swipeToTop(time);
    }

    public static void swipeToRight() {
        swipeActionHelper.swipeToRight();
    }

    public static void swipeToLeft() {
        swipeActionHelper.swipeToLeft();
    }

    public static void swipeToLeft(int time) {
        swipeActionHelper.swipeToLeft(time);
    }

    public static void swipeToRight(int time) {
        swipeActionHelper.swipeToRight(time);
    }

    public void selectOptionByText(String text) {
        WebElement element = waitForElementToBeVisible();
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

}
