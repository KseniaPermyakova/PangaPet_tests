package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPageHelper extends PageBase {

    @FindBy (xpath = "//li[@class='empty_cart']")
    WebElement clearCartButton;

    @FindBy (xpath = "//div[@class='checkout']//a")
    WebElement  goToPurchaseButton;

    @FindBy (xpath = "//div[@id='bg_header']//tr[1]//td[4]")
    WebElement deleteButton;

    @FindBy (xpath = "//div[contains(@class,'cart_close_btn outl')]")
    WebElement cartCloseButton;

    @FindBy (xpath = "//tr[1]//td[1]//div[3]//a[2]")
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
//        waitUntilElementIsVisible(By.xpath("//p[contains(@class,'cart_content')]"), 20);
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
        waitUntilElementIsClickable(driver.findElement(By.xpath("//div[@id='header_cart']//div//div//a")), 20);
        driver.findElement(By.xpath("//div[@id='header_cart']//div//div//a")).click();
//        goToPurchaseButton.click();
    }
}
