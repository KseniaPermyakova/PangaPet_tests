package ru.stqa.selenium;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.*;

public class PurchasePageTests extends TestBase {
    private HomePageHelper homePage;
    private LoginPageHelper loginPage;
    private CustomerPageHelper customerPage;
    private CartPageHelper cartPage;
    private StoreCategoryPageHelper storeCategoryPage;
    private ProductCategoryPageHelper productCategoryPage;
    private ProductPageHelper productPage;
    private PurchasePageHelper purchasePage;

    @BeforeMethod
    public void initPageObjects() {
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        customerPage = PageFactory.initElements(driver, CustomerPageHelper.class);
        cartPage = PageFactory.initElements(driver, CartPageHelper.class);
        storeCategoryPage = PageFactory.initElements(driver, StoreCategoryPageHelper.class);
        productCategoryPage = PageFactory.initElements(driver, ProductCategoryPageHelper.class);
        productPage = PageFactory.initElements(driver, ProductPageHelper.class);
        purchasePage = PageFactory.initElements(driver, PurchasePageHelper.class);
    }

    @BeforeMethod
    public void login() {
        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.enterLogin(LOGIN)
                 .enterPassword(PASSWORD)
                 .clickLogin();
        customerPage.waitUntilPageIsLoaded();
    }

    @Test
    public void deleteGood() {
        int items_counter_start = customerPage.getNumberOfItemsInCart();
        //----------Add good to the cart---------------
        customerPage.clickDogWorldButton();
        storeCategoryPage.waitUntilPageIsLoaded();
        storeCategoryPage.clickProductCategoryButton();
        productCategoryPage.waitUntilPageIsLoaded();
        productCategoryPage.clickProductTitle();
        productPage.waitUntilPageIsLoaded();
        productPage.clickAddToCartButton();
        //---------Delete good-------------
        cartPage.waitUntilPageIsLoaded();
        cartPage.clickGoToPurchaseButton();
        purchasePage.waitUntilPageIsLoaded();
        purchasePage.clickDeleteButton()
                    .clickOkAlertButton();
        homePage.waitUntilPageIsLoaded();
        int items_counter_end = customerPage.getNumberOfItemsInCart();

        Assert.assertTrue(items_counter_start == items_counter_end);
    }

    @Test
    public void deleteGoodCancel() {
        int items_counter_start = customerPage.getNumberOfItemsInCart();
        //----------Add good to the cart---------------
        customerPage.clickDogWorldButton();
        storeCategoryPage.waitUntilPageIsLoaded();
        storeCategoryPage.clickProductCategoryButton();
        productCategoryPage.waitUntilPageIsLoaded();
        productCategoryPage.clickProductTitle();
        productPage.waitUntilPageIsLoaded();
        productPage.clickAddToCartButton();
        //---------Delete good-------------
        cartPage.waitUntilPageIsLoaded();
        cartPage.clickGoToPurchaseButton();
        purchasePage.waitUntilPageIsLoaded();
        purchasePage.clickDeleteButton()
                    .clickCancelAlertButton();

        purchasePage.clickMyOrdersButton();
        customerPage.waitUntilPageIsLoaded();
        int items_counter_end = customerPage.getNumberOfItemsInCart();

        Assert.assertTrue(items_counter_end == items_counter_start + 1);
    }

    @Test
    public void changeNumberOfItemsInTheCart() {
        //----------Add good to the cart---------------
        customerPage.clickDogWorldButton();
        storeCategoryPage.waitUntilPageIsLoaded();
        storeCategoryPage.clickProductCategoryButton();
        productCategoryPage.waitUntilPageIsLoaded();
        productCategoryPage.clickProductTitle();
        productPage.waitUntilPageIsLoaded();
        productPage.clickAddToCartButton();
        //-----------Change number of items in the cart------------
        cartPage.waitUntilPageIsLoaded();
        cartPage.clickGoToPurchaseButton();
        purchasePage.waitUntilPageIsLoaded();
        purchasePage.changeNumberOfItems(3);

        purchasePage.clickUpdateButton();
        purchasePage.clickMyOrdersButton();
        customerPage.waitUntilPageIsLoaded();

        Assert.assertEquals(customerPage.getNumberOfItemsInCart(), 3);
    }
}
