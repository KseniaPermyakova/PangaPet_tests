package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageHelper extends PageBase {

  @FindBy (xpath = "//div[@id='header_logo']//a")
  WebElement headerLogo;

  @FindBy (xpath = "//ul[@class='mainnav_links']//span[@class='link_customer']")
  WebElement loginIcon;

  public HomePageHelper(WebDriver webDriver) {
    super(webDriver);
  }

  @Override
  public void waitUntilPageIsLoaded() {
    waitUntilElementIsVisible(headerLogo, 30);
  }

  public boolean isHomePage() {
    return headerLogo.getAttribute("title").equals("pangapet");
  }

  public void openLoginPage() {
    loginIcon.click();
  }
}
