package ru.stqa.selenium.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PurchasePageHelper extends PageBase {

    @FindBy (xpath = "//div[@id='order_show_cart']")
    WebElement tableOfOrders;

//    @FindBy (xpath = "//tr[1]//td[2]//input[1]")
//    @FindBy (xpath = "//input[@name='quantity']")
//    WebElement quantityField;
//    @FindBy (xpath = "//input[contains(@name,'quantity')]")
//    List<WebElement> quantityFields;

    @FindBy (xpath = "//tr[1]//td[2]//span[1]")
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

//    public void changeNumberOfItems(String quantity) {
//        enterValueToTheField(quantityFields.get(0), quantity);
//        enterValueToTheField(quantityField, quantity);
//    }

    public void clickUpdateButton() {
        waitUntilElementIsClickable(updateButton,10  );
        updateButton.click();
    }

    public void clickMyOrdersButton() {
        waitUntilElementIsClickable(myOrdersButton, 20);
        myOrdersButton.click();
    }

    public void clickDeleteButton() {
        waitUntilElementIsClickable(deleteButton, 20);
        deleteButton.click();
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
