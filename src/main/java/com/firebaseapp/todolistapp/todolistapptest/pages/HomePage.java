package com.firebaseapp.todolistapp.todolistapptest.pages;

import com.firebaseapp.todolistapp.todolistapptest.pageobject.PageObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends PageObject {
    public static final Logger logger = Logger.getLogger(HomePage.class);

    @FindBy(css = "div[class*='brownhill']")
    private WebElement todoListsHeader;
    @FindBy(css = "button[ng-click*='home.add()']")
    private WebElement addListBtn;

    @FindBy(css = "input[ng-model='home.list']")
    private WebElement taskContextTbx;

    @FindBy(css = "button[ng-click*='home.delete']")
    private List<WebElement> listDeleteBtnElements;

    @FindBy(css = "button[ng-click='home.signOut()']")
    private WebElement signOutBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public String getTodoListsHeader() {
        elementHelper.waitAndCheckElementDisplayed(signOutBtn);
        return elementHelper.getText(todoListsHeader);
    }

    public void addTask(){
        elementHelper.inputText(taskContextTbx, String.valueOf(Math.random()));
        elementHelper.click(addListBtn);
    }

    public int countListTask(){
        return listDeleteBtnElements.size();
    }

    public void deleteTask(int i){
        elementHelper.click(listDeleteBtnElements.get(i));
    }

    public void signOut(){
        elementHelper.click(signOutBtn);
    }
}
