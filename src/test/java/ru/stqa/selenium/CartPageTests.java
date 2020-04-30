package ru.stqa.selenium;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.*;

public class CartPageTests extends TestBase {
    private HomePageHelper homePage;
    private LoginPageHelper loginPage;
    private CustomerPageHelper customerPage;
    private CartPageHelper cartPage;
    private StoreCategoryPageHelper storeCategoryPage;
    private ProductCategoryPageHelper productCategoryPage;
    private ProductPageHelper productPage;

    @BeforeMethod
    public void initPageObjects() {
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        customerPage = PageFactory.initElements(driver, CustomerPageHelper.class);
        cartPage = PageFactory.initElements(driver, CartPageHelper.class);
        storeCategoryPage = PageFactory.initElements(driver, StoreCategoryPageHelper.class);
        productCategoryPage = PageFactory.initElements(driver, ProductCategoryPageHelper.class);
        productPage = PageFactory.initElements(driver, ProductPageHelper.class);
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
    public void addGoodToCart() {
        int items_counter_start = customerPage.getNumberOfItemsInCart();
        //----------Add good to the cart---------------
//        customerPage.clickDogWorldButton();
        customerPage.clickCatWorldButton();
        storeCategoryPage.waitUntilPageIsLoaded();
        storeCategoryPage.clickProductCategoryButton();
        productCategoryPage.waitUntilPageIsLoaded();
        productCategoryPage.clickProductTitle();
        productPage.waitUntilPageIsLoaded();
        productPage.clickAddToCartButton();
        cartPage.waitUntilPageIsLoaded();
        int items_counter_end = customerPage.getNumberOfItemsInCart();

        Assert.assertTrue(items_counter_end == items_counter_start + 1);

    }

    @Test
    public void clearCart() {
        //----------Add good to the cart---------------
        customerPage.clickDogWorldButton();
        storeCategoryPage.waitUntilPageIsLoaded();
        storeCategoryPage.clickProductCategoryButton();
        productCategoryPage.waitUntilPageIsLoaded();
        productCategoryPage.clickProductTitle();
        productPage.waitUntilPageIsLoaded();
        productPage.clickAddToCartButton();
        //----------Clear cart-----------------
        cartPage.clearCart();

        Assert.assertTrue(customerPage.getNumberOfItemsInCart() == 0);
    }

    @Test
    public void deleteGoodFromTheCart() {
        int items_counter_start = customerPage.getNumberOfItemsInCart();
        //----------Add good to the cart---------------
        customerPage.clickDogWorldButton();
        storeCategoryPage.waitUntilPageIsLoaded();
        storeCategoryPage.clickProductCategoryButton();
        productCategoryPage.waitUntilPageIsLoaded();
        productCategoryPage.clickProductTitle();
        productPage.waitUntilPageIsLoaded();
        productPage.clickAddToCartButton();
        //---------Delete good from the cart-------------
        cartPage.clickDeleteButton();
        cartPage.clickCartCloseButton();

        int items_counter_end = customerPage.getNumberOfItemsInCart();

        Assert.assertTrue(items_counter_start == items_counter_end);
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
        int items_counter_start = customerPage.getNumberOfItemsInCart();
        //-----------Change number of items in the cart------------
        cartPage.waitUntilPageIsLoaded();
        cartPage.clickPlusButton();
        cartPage.clickCartCloseButton();
        int items_counter_end = customerPage.getNumberOfItemsInCart();

        System.out.println(items_counter_start);
        System.out.println(items_counter_end);

        Assert.assertTrue(items_counter_end == items_counter_start + 1);
    }
}
