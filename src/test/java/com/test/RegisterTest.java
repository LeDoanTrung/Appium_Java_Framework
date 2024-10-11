package com.test;

import com.dataprovider.AccountDataProvider;
import com.model.Account;
import com.page.HomePage;
import com.page.WelcomePage;
import jdk.jfr.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    private WelcomePage _welcomePage;
    private AccountDataProvider _accountDataProvider;
    private Account _account;

    public RegisterTest() {
        _accountDataProvider = new AccountDataProvider();
    }

    @BeforeMethod
    public void setUp() {
        _welcomePage = new WelcomePage();
        _account = _accountDataProvider.generateRandomAccount();
    }

//    @Test
//    @Description("Register with valid account")
//    public void testRegister() {
//        HomePage homePage = _welcomePage.clickSkipButton();
//    }


}
