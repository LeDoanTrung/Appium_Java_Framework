package com.page;

import com.constant.MessageConstant;
import com.core.element.Element;
import io.appium.java_client.AppiumBy;

public class MyAccountPage extends BasePage{
    //Elements
    private Element _emailTxtBox = new Element(AppiumBy.xpath("//android.widget.EditText[@text='Email']"));
    private Element _passwordTxtBox = new Element(AppiumBy.xpath("//android.widget.EditText[@text='Password']"));
    private Element _loginButton = new Element(AppiumBy.xpath("//android.widget.Button[@text='LOGIN']"));
    private Element _registerButton = new Element(AppiumBy.xpath("//android.widget.TextView[@text='Not Registered ? Register Now !']"));

    private Element _itemName (String name) {
        return new Element(AppiumBy.xpath(String.format("//android.widget.Button[@text='%s']", name)));
    }
    //Methods
    public void enterEmail(String email) {
        _emailTxtBox.inputText(email);
    }

    public void enterPassword(String password) {
        _passwordTxtBox.inputText(password);
    }

    public void clickLoginButton() {
        _loginButton.click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public void clickOnItem(String itemName) {
        _itemName(itemName).click();
    }

    public boolean isLogin(){
        String [] itemName = {"MY DETAILS", "MY ORDERS", "PRODUCT RETURNS", "TRACK MY ORDERS", "CHANGE PASSWORD", "LOGOUT"};
        for (String name : itemName) {
            if (!_itemName(name).isElementDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public void clickRegisterButton() {
        _registerButton.click();
    }

    public boolean isErrorMessageDisplay() {
        return _message(MessageConstant.INVALID_ACCOUNT_MESSAGE).isElementDisplayed();
    }

}
