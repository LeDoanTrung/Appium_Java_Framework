package com.page;

import com.core.element.Element;
import io.appium.java_client.AppiumBy;

public class LoginPage extends BasePage{
    //Element
    private Element _username = new Element(AppiumBy.xpath("//android.widget.EditText[@text='Email']"));
    private Element _password = new Element(AppiumBy.xpath("//android.widget.EditText[@text='Password']"));
    private Element _loginButton = new Element(AppiumBy.xpath("//android.widget.Button[@text='LOGIN']"));
    private Element _registerButton = new Element(AppiumBy.xpath("//android.widget.TextView[@text='Not Registered ? Register Now !']"));

    //Method

    public void inputUsername(String username) {
        _username.clearText();
        _username.inputText(username);
    }

    public void inputPassword(String password) {
        _password.clearText();
        _password.inputText(password);
    }

    public void clickLoginButton() {
        _loginButton.click();
    }

    public void login(String username, String password) {
        inputUsername(username);
        inputPassword(password);
        clickLoginButton();
    }

    public RegisterPage clickRegisterButton() {
        _registerButton.click();
        return new RegisterPage();
    }
}
