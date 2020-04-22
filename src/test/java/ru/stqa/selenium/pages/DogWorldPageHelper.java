package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DogWorldPageHelper extends PageBase {

    @FindBy (xpath = "//div[@class='cat_title_wrapper']//h1")
    WebElement dogWorldText;

    @FindBy (xpath = "//div[contains(@class,'group_values_group_title')]//div[1]//a[1]//div[2]")
    WebElement dryDogFoodButton;

    public DogWorldPageHelper(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitUntilPageIsLoaded() {
        waitUntilElementIsVisible(dogWorldText, 20);
    }

    public void clickDryDogFoodButton() {
        dryDogFoodButton.click();
    }
}
