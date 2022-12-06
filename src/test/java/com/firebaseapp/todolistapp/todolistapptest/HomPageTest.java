package com.firebaseapp.todolistapp.todolistapptest;

import com.firebaseapp.todolistapp.todolistapptest.common.TestConstants;
import com.firebaseapp.todolistapp.todolistapptest.pages.HomePage;
import com.firebaseapp.todolistapp.todolistapptest.pages.LoginPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomPageTest extends BaseTest{
    public static final Logger logger = Logger.getLogger(LoginPageTest.class);

    @Test(groups = {"Major"})
    public void create10TaskList (){
        LoginPage loginPage = new LoginPage(driver);
        LoginPageTest loginPageTest = new LoginPageTest();
        HomePage homePage = new HomePage(driver);

        loginPageTest.loginWithGithub();
        for (int i = 0; i<10; i++){
            homePage.addTask();
        }
        int j = (homePage.countListTask());
        if (j == 10){
            System.out.println("User added 10 To Do lists successfully.");
        }
        homePage.signOut();
        Assert.assertEquals(loginPage.getPageHeader(), TestConstants.LOGIN_PAGE_HEADER);
    }
    @Test(groups = {"Major"})
    public void deleteTaskListFrom5To10 (){
        LoginPage loginPage = new LoginPage(driver);
        LoginPageTest loginPageTest = new LoginPageTest();
        HomePage homePage = new HomePage(driver);

        loginPageTest.loginWithGithub();
        for (int i = 0; i<10; i++){
            homePage.addTask();
        }
        homePage.signOut();
        Assert.assertEquals(loginPage.getPageHeader(), TestConstants.LOGIN_PAGE_HEADER);
        loginPageTest.loginWithGithub();
        int j;
        do {
            j = homePage.countListTask();
            homePage.deleteTask(j-1);
        } while (j >= 5);
        if(homePage.countListTask()==5){
            System.out.println("User deleted Task list rom 5 to 10 successfully");
        }
        homePage.signOut();
        Assert.assertEquals(loginPage.getPageHeader(), TestConstants.LOGIN_PAGE_HEADER);
    }
}
