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
    private DogWorldPageHelper dogWorldPage;
    private DryDogFoodPageHelper dryDogFoodPage;
    private ProductPageHelper productPage;

    @BeforeMethod
    public void initPageObjects() {
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        customerPage = PageFactory.initElements(driver, CustomerPageHelper.class);
        cartPage = PageFactory.initElements(driver, CartPageHelper.class);
        dogWorldPage = PageFactory.initElements(driver, DogWorldPageHelper.class);
        dryDogFoodPage = PageFactory.initElements(driver, DryDogFoodPageHelper.class);
        productPage = PageFactory.initElements(driver, ProductPageHelper.class);
    }

    @Test
    public void addGoodToCart() {
        //--------Login----------------
        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.enterLogin(LOGIN);
        loginPage.enterPassword(PASSWORD);
        loginPage.clickLogin();
        customerPage.waitUntilPageIsLoaded();
        int items_counter_start = customerPage.getNumberOfItemsInCart();
        //----------Add good to the cart---------------
        customerPage.clickDogWorldButton();
        dogWorldPage.waitUntilPageIsLoaded();
        dogWorldPage.clickDryDogFoodButton();
        dryDogFoodPage.waitUntilPageIsLoaded();
        dryDogFoodPage.clickProductTitle();
        productPage.waitUntilPageIsLoaded();
        productPage.clickAddToCartButton();
        int items_counter_end = customerPage.getNumberOfItemsInCart();

        Assert.assertTrue(items_counter_end == items_counter_start + 1);

    }

    @Test
    public void clearCart() {
        //---------Login----------------
        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.enterLogin(LOGIN);
        loginPage.enterPassword(PASSWORD);
        loginPage.clickLogin();
        customerPage.waitUntilPageIsLoaded();
        //----------Add good to the cart---------------
        customerPage.clickDogWorldButton();
        dogWorldPage.waitUntilPageIsLoaded();
        dogWorldPage.clickDryDogFoodButton();
        dryDogFoodPage.waitUntilPageIsLoaded();
        dryDogFoodPage.clickProductTitle();
        productPage.waitUntilPageIsLoaded();
        productPage.clickAddToCartButton();
        //----------Clear cart-----------------
        cartPage.clearCart();

        Assert.assertTrue(customerPage.getNumberOfItemsInCart() == 0);
    }

    @Test
    public void deleteGoodFromTheCart() {
        //--------Login----------------
        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.enterLogin(LOGIN);
        loginPage.enterPassword(PASSWORD);
        loginPage.clickLogin();
        customerPage.waitUntilPageIsLoaded();
        int items_counter_start = customerPage.getNumberOfItemsInCart();
        //----------Add good to the cart---------------
        customerPage.clickDogWorldButton();
        dogWorldPage.waitUntilPageIsLoaded();
        dogWorldPage.clickDryDogFoodButton();
        dryDogFoodPage.waitUntilPageIsLoaded();
        dryDogFoodPage.clickProductTitle();
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
        //--------Login----------------
        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.enterLogin(LOGIN);
        loginPage.enterPassword(PASSWORD);
        loginPage.clickLogin();
        customerPage.waitUntilPageIsLoaded();
        //----------Add good to the cart---------------
        customerPage.clickDogWorldButton();
        dogWorldPage.waitUntilPageIsLoaded();
        dogWorldPage.clickDryDogFoodButton();
        dryDogFoodPage.waitUntilPageIsLoaded();
        dryDogFoodPage.clickProductTitle();
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
