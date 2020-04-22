package ru.stqa.selenium;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.CustomerPageHelper;
import ru.stqa.selenium.pages.HomePageHelper;
import ru.stqa.selenium.pages.LoginPageHelper;
import util.DataProviders;

public class LoginPageTest extends TestBase {

    private HomePageHelper homePage;
    private LoginPageHelper loginPage;
    private CustomerPageHelper customerPage;

    @BeforeMethod
    public void initPageObjects() {
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        customerPage = PageFactory.initElements(driver, CustomerPageHelper.class);
    }

    @Test
    public void testLoginPositive() {
        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.enterLogin(LOGIN);
        loginPage.enterPassword(PASSWORD);
        loginPage.clickLogin();
        customerPage.waitUntilPageIsLoaded();

        Assert.assertTrue(customerPage.verifyIfCustomerPage());
    }

    @Test (dataProviderClass = DataProviders.class, dataProvider = "dataProviderFirst2")
    public void loginIncorrectPassNegative(String login, String password) {
        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        loginPage.waitPassLogError();

        Assert.assertTrue(loginPage.verifyIfPassLogErrorIsCorrect(), "Error message is not correct");
    }

    @Test (dataProviderClass = DataProviders.class, dataProvider = "dataProviderFirst")
    public void loginIncorrectLoginNegative(String login, String password, String message) {
        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        loginPage.waitPassLogError();

        Assert.assertEquals(message, loginPage.getLoginPassError());
    }
}
