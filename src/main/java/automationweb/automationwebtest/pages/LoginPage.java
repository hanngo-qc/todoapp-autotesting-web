package automationweb.automationwebtest.pages;

import automationweb.automationwebtest.pageobject.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(id = "txtEmail")
    private WebElement emailTxt;

    @FindBy(id = "lblEmailErr")
    private WebElement emailErrorLabel;

    @FindBy(id = "txtPassword")
    private WebElement passwordTxt;

    @FindBy(id = "lblPasswordErr")
    private WebElement passwordErrorLabel;

    @FindBy(id = "dbtnLogin")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void loginAccount(String email, String password) {
        elementHelper.inputText(emailTxt, email);
        elementHelper.inputText(passwordTxt, password);
        elementHelper.click(loginBtn);
    }

    public String getErrorEmailPasswordMessage() {
        return elementHelper.getText(passwordErrorLabel);
    }
}
