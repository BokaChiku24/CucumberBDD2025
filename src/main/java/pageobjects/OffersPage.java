package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {

    public WebDriver driver;

    public OffersPage(WebDriver driver) {
        this.driver = driver;
    }

    By offerLink = By.cssSelector("div.cart a:nth-child(2)");
    public By searchTextbox = By.cssSelector("input[type='search']");
    public By offerProduct = By.cssSelector("tbody tr td:nth-child(1)");

    public void clickOnOfferLink() {
        driver.findElement(offerLink).click();
    }

    public void clickSearchTextbox() {
        driver.findElement(searchTextbox).click();
    }

    public void sendKeyToSearchBox(String string) {
        driver.findElement(searchTextbox).sendKeys(string);
    }

    public String getOfferProductName() {
        return driver.findElement(offerProduct).getText();
    }

}
