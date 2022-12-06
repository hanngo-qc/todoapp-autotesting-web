package com.firebaseapp.todolistapp.todolistapptest.pageobject;

import com.firebaseapp.todolistapp.todolistapptest.helper.ElementHelper;
import com.firebaseapp.todolistapp.todolistapptest.helper.SwitchHelper;
import com.firebaseapp.todolistapp.todolistapptest.helper.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject {
    protected WebDriver driver;
    protected WaitHelper waitHelper;
    protected ElementHelper elementHelper;
    protected SwitchHelper switchHelper;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        waitHelper = new WaitHelper(driver);
        elementHelper = new ElementHelper(driver);
        PageFactory.initElements(this.driver, this);
    }
}
