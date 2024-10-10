package com.test;

import com.constant.FilePathConstant;
import com.core.report.ReportLog;
import com.core.util.DataReaderHelper;
import com.model.Account;
import com.page.HomePage;
import com.page.MyAccountPage;
import com.page.WelcomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {

    private WelcomePage _welcomePage;
    private Account _account;


    @BeforeMethod
    public void setUp() {
        _welcomePage = new WelcomePage();
        _account = DataReaderHelper.getData(FilePathConstant.ACCOUNT_FILE_PATH, Account.class);
    }

    @Test
    public void testLogin() {

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

}
