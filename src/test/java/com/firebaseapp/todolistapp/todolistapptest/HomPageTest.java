package com.firebaseapp.todolistapp.todolistapptest;

import com.firebaseapp.todolistapp.todolistapptest.common.TestConstants;
import com.firebaseapp.todolistapp.todolistapptest.helper.SwitchHelper;
import com.firebaseapp.todolistapp.todolistapptest.pages.AuthApplicationPopup;
import com.firebaseapp.todolistapp.todolistapptest.pages.HomePage;
import com.firebaseapp.todolistapp.todolistapptest.pages.LoginPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomPageTest extends BaseTest{
    public static final Logger logger = Logger.getLogger(LoginPageTest.class);

    private String validUsername = "";
    private String validPassword = "";

    @BeforeTest(groups = {"Major","Medium", "Minor"})
    public void setUpTestData() {
        validUsername = data.get("username").toString();
        validPassword = data.get("password").toString();
    }

    @Test
    public void createTask (){
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

        logger.info("Add a Task on TodoLists and Sign out after that");
        homePage.addTask();
        homePage.signOut();
        Assert.assertEquals(loginPage.getPageHeader(), TestConstants.LOGIN_PAGE_HEADER);
    }

    @Test
    public void deleteAllTask(){
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

        logger.info("Delete Task on TodoLists and Sign out after that");
        homePage.addTask();
        int numberOfTask = homePage.countTaskNumber();
        if (numberOfTask>0){
            for (int i = 0; i < numberOfTask - 1; i++) {
                homePage.deleteTask(numberOfTask);
            }
        }
        homePage.signOut();
        Assert.assertEquals(loginPage.getPageHeader(), TestConstants.LOGIN_PAGE_HEADER);
    }

    @Test
    public void deleteTaskListFrom5To10 (){
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

        logger.info("Add 10 Task on TodoLists and Sign out after that");
        for (int i = 0; i<10; i++){
            homePage.addTask();
        }
        homePage.signOut();
        Assert.assertEquals(loginPage.getPageHeader(), TestConstants.LOGIN_PAGE_HEADER);

        logger.info("Sign in with github and Access HomePage again");
        loginPage.loginWithGithub();
        Assert.assertEquals(homePage.getTodoListsHeader(), TestConstants.HOME_PAGE_HEADER);

        logger.info("Delete Task from 5-10 on TodoLists and Sign out after that");
        int numberOfTask = homePage.countTaskNumber();
        Assert.assertEquals(numberOfTask, 10);
        do {
            homePage.deleteTask(numberOfTask-1);
            numberOfTask--;
        } while (numberOfTask >= 5);
        if(homePage.countTaskNumber()==5){
            System.out.println("User deleted Task list rom 5 to 10 successfully");
        }
        homePage.signOut();
        Assert.assertEquals(loginPage.getPageHeader(), TestConstants.LOGIN_PAGE_HEADER);
    }

    @AfterMethod
    public void afterFinishCase(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.loginWithGithub();
        int numberOfTask = homePage.countTaskNumber();
        if (numberOfTask>0){
            for (int i = 0; i < numberOfTask - 1; i++) {
                homePage.deleteTask(numberOfTask);
            }
        }
    }
}
