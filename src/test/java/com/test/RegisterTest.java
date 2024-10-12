package com.test;

import com.constant.MenuBarConstant;
import com.core.report.ReportLog;
import com.core.util.TestHelper;
import com.dataprovider.AccountDataProvider;
import com.model.Account;
import com.page.*;
import jdk.jfr.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    private WelcomePage _welcomePage;
    private MyDetailsPage _myDetailsPage;
    private AccountDataProvider _accountDataProvider;
    private Account _account;

    public RegisterTest() {
        _accountDataProvider = new AccountDataProvider();
    }

    @BeforeMethod
    public void setUp() {
        _welcomePage = new WelcomePage();
        _myDetailsPage = new MyDetailsPage();
        _account = _accountDataProvider.generateRandomAccount();
    }

    @Test(retryAnalyzer = TestHelper.class)
    @Description("Register with valid account")
    public void testRegister() {

        ReportLog.info("Go to Home Page");
        HomePage homePage = _welcomePage.clickSkipButton();

        ReportLog.info("Go to My Account Page");
        MyAccountPage myAccountPage = homePage.goToMyAccountPage();

        ReportLog.info("Go to Register Page");
        RegisterPage registerPage = myAccountPage.clickRegisterButton();

        ReportLog.info("Register with valid account");
        registerPage.register(_account.getName(), _account.getMobile(), _account.getEmail(), _account.getPassword());

        ReportLog.info("Go to My Detail page");
        myAccountPage.goToItem(MenuBarConstant.MY_DETAILS);

        ReportLog.info("Verify My Account");
        _myDetailsPage.verifyMyAccount(_account);
    }


}
