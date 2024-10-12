package com.page;

import com.core.element.Element;
import io.appium.java_client.AppiumBy;

public class RegisterPage extends BasePage{

    //Element
    private Element _username = new Element(AppiumBy.xpath("//android.widget.EditText[@text='Name']"));
    private Element _mobileNumber = new Element(AppiumBy.xpath("//android.widget.EditText[@text='Mobile Number']"));
    private Element _email = new Element(AppiumBy.xpath("//android.widget.EditText[@text='Email']"));
    private Element _password = new Element(AppiumBy.xpath("//android.widget.EditText[@text='Password']"));
    private Element _registerButton = new Element(AppiumBy.xpath("//android.widget.Button[@text='REGISTER']"));


    //Method
    public void inputUsername(String username) {
        _username.clearText();
        _username.inputText(username);
    }

    public void inputMobileNumber(String mobileNumber) {
        _mobileNumber.clearText();
        _mobileNumber.inputText(mobileNumber);
    }

    public void inputEmail(String email) {
        _email.clearText();
        _email.inputText(email);
    }

    public void inputPassword(String password) {
        _password.clearText();
        _password.inputText(password);
    }

    public void clickRegisterButton() {
        _registerButton.click();
    }

    public void register(String username, String mobileNumber, String email, String password) {
        inputUsername(username);
        inputMobileNumber(mobileNumber);
        inputEmail(email);
        inputPassword(password);
        clickRegisterButton();
    }




}
