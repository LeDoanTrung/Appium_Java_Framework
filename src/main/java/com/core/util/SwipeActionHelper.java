package com.core.util;

import com.core.driver.AppiumDriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.awt.*;
import java.time.Duration;
import java.util.Collections;

public class SwipeActionHelper {
    private AppiumDriver appiumDriver = AppiumDriverManager.getDriver();
    private Dimension windowSize = appiumDriver.manage().window().getSize();

    public void swipeToBottom() {

        int startX = windowSize.width / 2;
        int endX = startX;
        int startY = (int) (windowSize.height * 0.8);
        int endY = (int) (windowSize.height * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipeToLeft = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(300))) // Optional pause
                .addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        this.appiumDriver.perform(Collections.singletonList(swipeToLeft));
    }

    public void swipeToBottom(int time){
        for (int i = 0; i < time; i++) {
            this.swipeToBottom();
        }
    }

    public void swipeToTop() {
        int startX = windowSize.width / 2;
        int endX = startX;
        int startY = (int) (windowSize.height * 0.2);
        int endY = (int) (windowSize.height * 0.8);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipeToLeft = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(300))) // Optional pause
                .addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        this.appiumDriver.perform(Collections.singletonList(swipeToLeft));
    }

    public void swipeToTop(int time){
        for (int i = 0; i < time; i++) {
            this.swipeToTop();
        }
    }

    public  void swipeToRight(){
        int startX = (int) (windowSize.width * 0.5);
        int endX = (int) (windowSize.width * 0.1);
        int startY = (int) (windowSize.height * 0.5);
        int endY = startY;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipeToLeft = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(300))) // Optional pause
                .addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        this.appiumDriver.perform(Collections.singletonList(swipeToLeft));
    }

    public void swipeToRight(int time){
        for (int i = 0; i < time; i++) {
            this.swipeToRight();
        }
    }

    public void swipeToLeft(){
        int startX = (int) (windowSize.width * 0.1);
        int endX = (int) (windowSize.width * 0.5);
        int startY = (int) (windowSize.height * 0.5);
        int endY = startY;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipeToLeft = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(300))) // Optional pause
                .addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        this.appiumDriver.perform(Collections.singletonList(swipeToLeft));
    }

    public void swipeToLeft(int time){
        for (int i = 0; i < time; i++) {
            this.swipeToLeft();
        }
    }
}
