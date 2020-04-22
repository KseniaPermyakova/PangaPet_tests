package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DryDogFoodPageHelper extends PageBase {

    @FindBy (xpath = "//div[contains(@class,'cat_title_wrapper')]")
    WebElement dryDogFoodText;

    @FindBy (xpath = "//div[@id='item_id_2533170']//h3[contains(@class,'text-center')]")
    WebElement productTitle;

    public DryDogFoodPageHelper(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitUntilPageIsLoaded() {
        waitUntilElementIsVisible(dryDogFoodText, 20);
    }

    public void clickProductTitle() {
        productTitle.click();
    }
}
