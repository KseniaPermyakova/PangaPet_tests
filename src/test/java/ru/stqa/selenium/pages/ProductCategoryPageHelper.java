package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductCategoryPageHelper extends PageBase {

    @FindBy (xpath = "//div[@id='category_group3']")
    WebElement productGroup;

    @FindBy (xpath = "//h3[@class='title  text-center']")
    List<WebElement> productTitles;

    public ProductCategoryPageHelper(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(productGroup, 40);
    }

    public void clickProductTitle() {
        waitUntilElementIsClickable(productTitles.get(getRandomNumber(0,11)), 20);
        productTitles.get(getRandomNumber(0,11)).click();
    }
}
