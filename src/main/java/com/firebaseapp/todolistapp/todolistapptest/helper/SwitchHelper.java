package com.firebaseapp.todolistapp.todolistapptest.helper;

import org.openqa.selenium.WebDriver;

public class SwitchHelper {
    private WebDriver driver;

    public SwitchHelper(WebDriver driver) { this.driver = driver; }

    public String switchToWindow (){
        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            if (!(winHandle ==winHandleBefore)){
                driver.switchTo().window(winHandle);
            }
        }
        return winHandleBefore;
    }

    public void backToMainPage(String winHandle) {
        driver.switchTo().window(winHandle);
    }
}
