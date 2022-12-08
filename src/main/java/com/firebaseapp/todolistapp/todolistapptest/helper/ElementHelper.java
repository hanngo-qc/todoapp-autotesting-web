package com.firebaseapp.todolistapp.todolistapptest.helper;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementHelper {
    private WaitHelper waitUtil;

    public ElementHelper(WebDriver driver) {
        this.waitUtil = new WaitHelper(driver);
    }

    public void click(WebElement element) {
        waitUtil.waitUntilElementCanBeClicked(element).click();
    }

    public void inputText(WebElement element, String text) {
        waitUtil.waitUntilElementDisplayed(element).sendKeys(text);
    }

    public String getText(WebElement element) {
        return waitUtil.waitUntilElementDisplayed(element).getText();
    }

    public boolean waitAndCheckElementDisplayed(WebElement element) {
        try {
            return waitUtil.waitUntilElementDisplayed(element).isDisplayed();
        } catch (NoSuchElementException | NoSuchWindowException ex) {
            return false;
        }
    }
}
