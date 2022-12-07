package com.firebaseapp.todolistapp.todolistapptest.pages;

import com.firebaseapp.todolistapp.todolistapptest.pageobject.PageObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthApplicationPopup extends PageObject {

    public static final Logger logger = Logger.getLogger(AuthApplicationPopup.class);

    @FindBy(css = "input[id='login_field']")
    private WebElement loginTbx;

    @FindBy(css = "input[id='password']")
    private WebElement passwordTbx;

    @FindBy(css = "input[name='commit']")
    private WebElement signInBtn;

    @FindBy(css = "button[data-octo-click='oauth_application_authorization']")
    private WebElement authBtn;

    public AuthApplicationPopup(WebDriver driver) {
        super(driver);
    }

    public String switchAuthPopup(){
        return switchHelper.switchToWindow();
    }

    public String getPopUpTitle() {
        elementHelper.waitAndCheckElementDisplayed(signInBtn);
        return driver.getTitle();
    }

    public void loginGithub(String username, String password){
        elementHelper.inputText(loginTbx, username);
        elementHelper.inputText(passwordTbx, password);
        elementHelper.click(signInBtn);
       // if (elementHelper.waitAndCheckElementDisplayed(authBtn)){
       //     elementHelper.click(authBtn);
       // }
    }

    public void selectedAuthBtn (){
        elementHelper.click(authBtn);
    }

}
