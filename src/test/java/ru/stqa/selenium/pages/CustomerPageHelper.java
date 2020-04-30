package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerPageHelper extends PageBase {

    @FindBy (id = "customer_logout")
    WebElement logoutButton;

    @FindBy (xpath = "//div[@id='show_custmer_orders']")
    WebElement customerOrders;

    @FindBy (partialLinkText = "עולם הכלב")
    WebElement dogWorldButton;

    @FindBy (partialLinkText = "עולם החתולים")
    WebElement catWorldButton;

    @FindBy (partialLinkText = "עולם הזוחלים")
    WebElement reptileWorldButton;

    @FindBy (xpath = "//span[@class='cart_with_items_counter']")
    WebElement itemsCounterInTheCart;

    public CustomerPageHelper(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(customerOrders, 30);
    }

    public boolean verifyIfCustomerPage() {
        return logoutButton.getText().contains("יציאה מהמערכת");
    }

    public void clickDogWorldButton() {
        waitUntilElementIsClickable(dogWorldButton, 20);
        dogWorldButton.click();
    }

    public void clickCatWorldButton() {
        waitUntilElementIsClickable(catWorldButton, 20);
        catWorldButton.click();
    }

    public void clickReptileWorldButton() {
        waitUntilElementIsClickable(reptileWorldButton, 20);
        reptileWorldButton.click();
    }

    public int getNumberOfItemsInCart() {
        return Integer.parseInt(itemsCounterInTheCart.getText());
    }
}
