package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageHelper extends PageBase {

    @FindBy (xpath = "//li[@class='lslide active']//img")
    WebElement productImage;

    @FindBy (xpath = "//a[@class='commit_to_real']")
    WebElement addToCartButton;

    public ProductPageHelper(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(productImage, 30);
    }

    public void clickAddToCartButton() {
        waitUntilElementIsClickable(addToCartButton, 20);
        addToCartButton.click();
    }
}
