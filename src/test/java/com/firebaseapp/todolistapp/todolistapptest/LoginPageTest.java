package com.firebaseapp.todolistapp.todolistapptest;

import com.firebaseapp.todolistapp.todolistapptest.common.TestConstants;
import com.firebaseapp.todolistapp.todolistapptest.helper.SwitchHelper;
import com.firebaseapp.todolistapp.todolistapptest.pages.AuthApplicationPopup;
import com.firebaseapp.todolistapp.todolistapptest.pages.LoginPage;
import com.firebaseapp.todolistapp.todolistapptest.pages.HomePage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LoginPageTest extends BaseTest {
    public static final Logger logger = Logger.getLogger(LoginPageTest.class);

    private String validUsername = "";
    private String validPassword = "";

    @BeforeTest(groups = {"Major","Medium", "Minor"})
    public void setUpTestData() {
        validUsername = data.get("username").toString();
        validPassword = data.get("password").toString();
    }

    @Test(description = "Login with GitHub")
    public void loginWithGitHub() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AuthApplicationPopup authApplicationPopup = new AuthApplicationPopup(driver);
        SwitchHelper switchHelper = new SwitchHelper(driver);

        logger.info("Access Login Page and Sign in with github");
        Assert.assertEquals(loginPage.getPageHeader(), TestConstants.LOGIN_PAGE_HEADER);
        loginPage.loginWithGithub();

        logger.info("Switch to Authenticate Popup");
        authApplicationPopup.switchAuthPopup();
        Assert.assertEquals(authApplicationPopup.getPopUpTitle(), TestConstants.SIGN_IN_GITHUB_TITLE);
        authApplicationPopup.loginGithub(validUsername,validPassword);
        String winHandleBefore = driver.getWindowHandles().iterator().next();
        switchHelper.backToMainPage(winHandleBefore);
        Assert.assertEquals(homePage.getTodoListsHeader(), TestConstants.HOME_PAGE_HEADER);
    }
}
