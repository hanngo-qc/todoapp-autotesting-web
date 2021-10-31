package automationweb.automationwebtest.helper;

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
}
