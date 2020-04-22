package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerPageHelper extends PageBase {

    @FindBy (id = "customer_logout")
    WebElement logoutButton;

    @FindBy (xpath = "//a[@class='cart']//div[@class='icon_wrapper']")
    WebElement iconCart;

    @FindBy (partialLinkText = "עולם הכלב")
    WebElement dogWorldButton;

    @FindBy (xpath = "//span[@class='cart_with_items_counter']")
    WebElement itemsCounterInTheCart;

    public CustomerPageHelper(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(logoutButton, 30);
    }

    public boolean verifyIfCustomerPage() {
        return logoutButton.getText().contains("יציאה מהמערכת");
    }

    public void clickIconCart() {
        iconCart.click();
    }

    public void clickDogWorldButton() {
        dogWorldButton.click();
    }

    public int getNumberOfItemsInCart() {
        return Integer.parseInt(itemsCounterInTheCart.getText());
    }
}
