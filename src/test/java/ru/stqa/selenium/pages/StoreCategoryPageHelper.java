package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StoreCategoryPageHelper extends PageBase {

    @FindBy (xpath = "//div[@class='category_image_wrapper main_cat_banner']")
    WebElement categoryImageBanner;

    @FindBy (xpath = "//div[@class='category_title']")
    List<WebElement> categoryTitles;

    public StoreCategoryPageHelper(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitUntilPageIsLoaded() {
        waitUntilElementIsVisible(categoryImageBanner, 20);
    }

    public void clickProductCategoryButton() {
        waitUntilElementIsClickable(categoryTitles.get(getRandomNumber(0,15)), 20);
        categoryTitles.get(getRandomNumber(0,15)).click();
    }
}
