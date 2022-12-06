package com.firebaseapp.todolistapp.todolistapptest.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScrollHelper {
    private WebDriver driver;

    public ScrollHelper(WebDriver driver) { this.driver = driver; }

    public void scrollToMiddlePage (){
        JavascriptExecutor scrollPage = ((JavascriptExecutor)driver);
        scrollPage.executeScript("window.scrollBy(0,500)");
    }
}
