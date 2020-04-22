package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageHelper extends PageBase {

    @FindBy (xpath = "//div[contains(@class,'smallButton')]")
    WebElement loginButton;

    @FindBy (id = "customer_session_username")
    WebElement emailField;

    @FindBy (id = "customer_session_password")
    WebElement passwordField;

    @FindBy (xpath = "//div[@class='error dontTakeSpace']//p")
    WebElement loginPassError;

    public LoginPageHelper(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(loginButton, 30);
    }

    public void enterLogin(String login) {

        enterValueToTheField(emailField, login);
    }

    public void enterPassword(String password) {

        enterValueToTheField(passwordField, password);
    }

    public void clickLogin() {
        waitUntilElementIsClickable(loginButton, 3);
        loginButton.click();
    }

    public void waitPassLogError() {
        waitUntilElementIsVisible(loginPassError, 20);
    }

    public boolean verifyIfPassLogErrorIsCorrect() {
        return loginPassError.getText().contains("שם משתמש או סיסמה לא מתאימים");
    }

    public String getLoginPassError() {
        return  loginPassError.getText();
    }
}
