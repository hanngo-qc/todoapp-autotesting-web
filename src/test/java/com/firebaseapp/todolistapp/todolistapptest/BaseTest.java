package com.firebaseapp.todolistapp.todolistapptest;

import com.firebaseapp.todolistapp.todolistapptest.common.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.firebaseapp.todolistapp.todolistapptest.utils.ConvertUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.Map;

public class BaseTest {
    private static final Logger logger = Logger.getLogger(BaseTest.class);
    protected static Map<Object, Object> data;
    protected WebDriver driver;

    @BeforeSuite(groups = {"Major", "Medium", "Minor"})
    public void setupTestData() {
        logger.info("Initializing Staging env");
        driver = WebDriverManager.chromedriver().create();
        data = ConvertUtil.convertJsonFileToMap(Constants.STAGE_TEST_DATA_NAME);
    }

    @BeforeMethod(alwaysRun = true)
    public void accessPage() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://todo-list-login.firebaseapp.com/");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Fail to wait for page load.");
        }
    }

    @AfterMethod(alwaysRun = true)
    public void afterFinishTest() {
        driver.quit();
    }
}
