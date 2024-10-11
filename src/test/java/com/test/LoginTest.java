package com.test;

import com.constant.FilePathConstant;
import com.core.driver.AppiumDriverManager;
import com.core.driver.AppiumDriverProperty;
import com.core.report.ReportLog;
import com.core.util.DataReaderHelper;
import com.core.util.TestHelper;
import com.dataprovider.AccountDataProvider;
import com.model.Account;
import com.page.HomePage;
import com.page.MyAccountPage;
import com.page.WelcomePage;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {

    private WelcomePage _welcomePage;
    private AccountDataProvider _accountDataProvider;
    private Account _account;


    @BeforeMethod
    public void setUp() {
        _welcomePage = new WelcomePage();
        _accountDataProvider = new AccountDataProvider();
    }

    @Test(retryAnalyzer = TestHelper.class)
    @Description("Login with valid account")
    public void testLogin() {
        _account = DataReaderHelper.getData(FilePathConstant.ACCOUNT_FILE_PATH, Account.class);
       ReportLog.info("Go to Home Page");
       HomePage homePage = _welcomePage.clickSkipButton();

       ReportLog.info("Go to My Account Page");
       MyAccountPage myAccountPage = homePage.goToMyAccountPage();

       ReportLog.info("Login with valid account");
       myAccountPage.login(_account.getEmail(), _account.getPassword());

        // Assert that the login was successful
        ReportLog.info("Assert that the login was successful");
        assertThat(myAccountPage.isLogin()).isTrue();
    }

    @Test(retryAnalyzer = TestHelper.class)
    @Description("Login with invalid account")
    public void testLoginWithInvalidAccount() {
        //Create new random account
        _account = _accountDataProvider.generateRandomAccount();

       ReportLog.info("Go to Home Page");
       HomePage homePage = _welcomePage.clickSkipButton();

       ReportLog.info("Go to My Account Page");
       MyAccountPage myAccountPage = homePage.goToMyAccountPage();

       ReportLog.info("Login with invalid account");
       myAccountPage.login(_account.getEmail(), _account.getPassword());

        // Assert that the login was unsuccessful
        ReportLog.info("Assert that the error message is displayed");
        assertThat(myAccountPage.isErrorMessageDisplay()).isTrue();

    }

    @AfterMethod
    public void tearDown() {
        AppiumDriverManager.quitDriver();
    }

}
