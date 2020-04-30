package ru.stqa.selenium.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PurchasePageHelper extends PageBase {

    @FindBy (xpath = "//div[@id='order_show_cart']")
    WebElement tableOfOrders;

    @FindBy (xpath = "//input[@name='quantity']")
    List<WebElement> quantityFields;

    @FindBy (xpath = "(//td[@class='col2']//span)[1]")
    WebElement updateButton;

    @FindBy (xpath = "//div[@id='header_mainnav']//a[@id='customer_login']")
    WebElement myOrdersButton;

    @FindBy (xpath = "//a[contains(@class,'remove')]")
    WebElement deleteButton;

    Alert alert;

    public PurchasePageHelper(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitUntilPageIsLoaded() {
        waitUntilElementIsVisible(tableOfOrders, 30);
    }

    public void changeNumberOfItems(int quantity) {
        enterValueToAutoCompleteField(quantityFields.get(0), Integer.toString(quantity));
    }

    public void clickUpdateButton() {
        waitUntilElementIsClickable(updateButton,10  );
        updateButton.click();
    }

    public void clickMyOrdersButton() {
        waitUntilElementIsClickable(myOrdersButton, 20);
        myOrdersButton.click();
    }

    public PurchasePageHelper clickDeleteButton() {
        waitUntilElementIsClickable(deleteButton, 20);
        deleteButton.click();
        return this;
    }

    public void clickOkAlertButton() {
        alert = driver.switchTo().alert();
        alert.accept();
    }

    public void clickCancelAlertButton() {
        alert = driver.switchTo().alert();
        alert.dismiss();
    }
}
