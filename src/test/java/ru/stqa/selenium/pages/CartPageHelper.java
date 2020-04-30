package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPageHelper extends PageBase {

    @FindBy (xpath = "//li[@class='empty_cart']")
    WebElement clearCartButton;

    @FindBy (xpath = "//div[@class='checkout']//a")
    WebElement  goToPurchaseButton;

    @FindBy (xpath = "(//td[@class='delete_btn'])[1]")
    WebElement deleteButton;

    @FindBy (xpath = "//div[contains(@class,'cart_close_btn outl')]")
    WebElement cartCloseButton;

    @FindBy (xpath = "(//a[@class='plus'])[1]")
    WebElement plusButton;

    public CartPageHelper(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(goToPurchaseButton, 20);
    }

    public void clearCart() {
        waitUntilElementIsClickable(clearCartButton, 10);
        clearCartButton.click();
    }

    public void clickCartCloseButton() {
        waitUntilElementIsClickable(cartCloseButton, 10);
        cartCloseButton.click();
    }

    public void clickDeleteButton() {
        waitUntilElementIsClickable(deleteButton, 10);
        deleteButton.click();
        waitUntilElementIsClickable(goToPurchaseButton,10);
    }

    public void clickPlusButton() {
        waitUntilElementIsClickable(plusButton, 10);
        plusButton.click();
    }

    public void clickGoToPurchaseButton() {
        waitUntilElementIsClickable(goToPurchaseButton, 20);
        goToPurchaseButton.click();
    }
}
