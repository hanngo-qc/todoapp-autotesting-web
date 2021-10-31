package automationweb.automationwebtest.pages;

import automationweb.automationwebtest.pageobject.PageObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends PageObject {
    public static final Logger logger = Logger.getLogger(WelcomePage.class);

    @FindBy(id = "lblLoggedinSuccessfully")
    private WebElement loggedInSuccessfullyLabel;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }


    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getLoginSuccessfullyNotify(){
        return elementHelper.getText(loggedInSuccessfullyLabel);
    }
}
