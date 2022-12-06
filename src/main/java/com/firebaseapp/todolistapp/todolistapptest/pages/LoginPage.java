package com.firebaseapp.todolistapp.todolistapptest.pages;

import com.firebaseapp.todolistapp.todolistapptest.pageobject.PageObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    public static final Logger logger = Logger.getLogger(LoginPage.class);

    @FindBy(css = "h1[class='login-head']")
    private WebElement loginHeader;

    @FindBy(css = "a[ng-click='login.loginWithGithub()']")
    private WebElement loginWithGithubBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getPageHeader() {
        return elementHelper.getText(loginHeader);
    }

    public void loginWithGithub() {
        elementHelper.click(loginWithGithubBtn);
    }

}
