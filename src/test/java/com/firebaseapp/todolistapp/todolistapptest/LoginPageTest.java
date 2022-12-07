package com.firebaseapp.todolistapp.todolistapptest;

import com.firebaseapp.todolistapp.todolistapptest.common.TestConstants;
import com.firebaseapp.todolistapp.todolistapptest.helper.SwitchHelper;
import com.firebaseapp.todolistapp.todolistapptest.pages.AuthApplicationPopup;
import com.firebaseapp.todolistapp.todolistapptest.pages.LoginPage;
import com.firebaseapp.todolistapp.todolistapptest.pages.HomePage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    public static final Logger logger = Logger.getLogger(LoginPageTest.class);

    @Test(groups = {"Major"})
    public void getPageTitle(){
        LoginPage loginPage= new LoginPage(driver);

        logger.info("Access Login Page");
        Assert.assertEquals(loginPage.getPageHeader(), TestConstants.LOGIN_PAGE_HEADER);
    }

    @Test(groups = {"Medium"})
    public void loginWithGitHubInFirst(){
        LoginPage loginPage = new LoginPage(driver);
        AuthApplicationPopup authApplicationPopup = new AuthApplicationPopup(driver);
        HomePage homePage = new HomePage(driver);
        SwitchHelper switchHelper = new SwitchHelper(driver);

        logger.info("Access Login Page");
        Assert.assertEquals(loginPage.getPageHeader(), TestConstants.LOGIN_PAGE_HEADER);
        logger.info("Sign in with github");
        loginPage.loginWithGithub();
        logger.info("Accept Auth on the first");

        authApplicationPopup.switchAuthPopup();
        Assert.assertEquals(authApplicationPopup.getPopUpTitle(), TestConstants.SIGN_IN_GITHUB_TITLE);
        authApplicationPopup.loginGithub("hanngo-qc1","HoaiHan9742");
        logger.info("Verified to sign in successfully");
        String winHandleBefore = driver.getWindowHandle();
        driver.switchTo().window(winHandleBefore);
        //switchHelper.backToMainPage(winHandleBefore);
        Assert.assertEquals(homePage.getTodoListsHeader(), TestConstants.HOME_PAGE_HEADER);
        logger.info("Verified to sign in successfully");
    }
    @Test(groups = {"Major"})
    public void loginWithGithub(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        logger.info("Access Login Page");
        Assert.assertEquals(loginPage.getPageHeader(), TestConstants.LOGIN_PAGE_HEADER);
        logger.info("Sign in with github");
        loginPage.loginWithGithub();
        logger.info("Verified to sign in successfully");
        Assert.assertEquals(homePage.getTodoListsHeader(), TestConstants.HOME_PAGE_HEADER);
        System.out.println("Signed in successfully with Github account");
    }

}
