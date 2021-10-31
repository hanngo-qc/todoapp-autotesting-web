package automationweb.automationwebtest;

import automationweb.automationwebtest.common.TestConstants;
import automationweb.automationwebtest.pages.LoginPage;
import automationweb.automationwebtest.pages.WelcomePage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LoginTest extends BaseTest {
    public static final Logger logger = Logger.getLogger(LoginTest.class);

    private HashMap testDataSuccess = new HashMap();
    private HashMap testDataFailed = new HashMap();
    private String validEmail = "";
    private String invalidEmail = "";
    private String validPassword = "";
    private String invalidPassword = "";

    @BeforeTest(groups = {"Major","Medium", "Minor"})
    public void setUpTestData() {
        testDataSuccess = (HashMap) data.get("testDataSuccess");
        testDataFailed = (HashMap) data.get("testDataFailed");
        validEmail = testDataSuccess.get("email").toString();
        invalidEmail = testDataFailed.get("email").toString();
        validPassword = testDataSuccess.get("password").toString();
        invalidPassword = testDataFailed.get("password").toString();
    }

    @Test(groups = {"Major"})
    public void loginEmailSuccessfully(){
        LoginPage loginPage = new LoginPage(driver);
        WelcomePage welcomePage = new WelcomePage(driver);

        logger.info("Access Login page");
        Assert.assertEquals(TestConstants.LOGIN_PAGE_TITLE, loginPage.getPageTitle());
        loginPage.loginAccount(validEmail, validPassword);
        Assert.assertEquals(TestConstants.WELCOME_PAGE_TITLE, welcomePage.getPageTitle());
        Assert.assertEquals(TestConstants.LOGIN_SUCCESS_NOTIFY, welcomePage.getLoginSuccessfullyNotify());
        logger.info("User can login successfully");
    }

    @Test(groups = {"Medium"})
    public void loginFailedByNotExistedEmail() {
        LoginPage loginPage = new LoginPage(driver);

        logger.info("Access Login page");
        Assert.assertEquals(TestConstants.LOGIN_PAGE_TITLE, loginPage.getPageTitle());
        loginPage.loginAccount(invalidEmail, validPassword);
        Assert.assertEquals(TestConstants.INCORRECT_PASSWORD_MESSAGE, loginPage.getErrorEmailPasswordMessage());
        logger.info("User cannot login when entering a wrong email address");
    }

    @Test(groups = {"Medium"})
    public void loginFailedByWrongPassword() {
        LoginPage loginPage = new LoginPage(driver);

        logger.info("Access Login page");
        Assert.assertEquals(TestConstants.LOGIN_PAGE_TITLE, loginPage.getPageTitle());
        loginPage.loginAccount(validEmail, invalidPassword);
        Assert.assertEquals(TestConstants.INCORRECT_PASSWORD_MESSAGE, loginPage.getErrorEmailPasswordMessage());
        logger.info("User cannot login when entering a wrong password");
    }

    @Test(groups = {"Minor"})
    public void loginFailedByWrongEmailAndPassword() {
        LoginPage loginPage = new LoginPage(driver);

        logger.info("Access Login page");
        Assert.assertEquals(TestConstants.LOGIN_PAGE_TITLE, loginPage.getPageTitle());
        loginPage.loginAccount(invalidEmail, invalidPassword);
        Assert.assertEquals(TestConstants.INCORRECT_PASSWORD_MESSAGE, loginPage.getErrorEmailPasswordMessage());
        logger.info("User cannot login when entering a wrong email address or password");
    }

}
