package com.page;


import com.core.element.Element;
import io.appium.java_client.AppiumBy;
import com.model.Account;
import static org.assertj.core.api.Assertions.assertThat;

public class MyDetailsPage extends BasePage{

    //Element
    private Element _nameTxtBox = new Element(AppiumBy.id("et_myaccount_username"));
    private Element _emailTxtBox = new Element(AppiumBy.id("et_myaccount_email"));
    private Element _mobileTxtBox = new Element(AppiumBy.id("et_myaccount_mob"));

    //Method
    public void verifyMyAccount(Account account) {
        assertThat(_nameTxtBox.getText()).isEqualTo(account.getName());
        assertThat(_emailTxtBox.getText()).isEqualTo(account.getEmail());
        assertThat(_mobileTxtBox.getText()).isEqualTo(account.getMobile());
    }

}
