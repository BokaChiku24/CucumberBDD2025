package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class OffersPage {

    public WebDriver driver;

    public OffersPage(WebDriver driver){
        this.driver = driver;
    }

    By offerLink = By.cssSelector("div.cart a:nth-child(2)");
    By searchTextbox = By.cssSelector("input[type='search']");
    By offerProduct = By.cssSelector("tbody tr td:nth-child(1)");

    public void clickOnOfferLink(){
        driver.findElement(offerLink).click();
    }

    public String goToChildWindow(){
        if(!Objects.requireNonNull(driver.getCurrentUrl()).equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers")) {
            clickOnOfferLink();
            Set<String> windowHandles = driver.getWindowHandles();
            Iterator<String> itr = windowHandles.iterator();
            String parentWindow = itr.next();
            return itr.next();
        }
        return "";
    }

    public void clickSearchTextbox(){
        driver.findElement(searchTextbox).click();
    }

    public void sendKeyToSearchBox(String string){
        driver.findElement(searchTextbox).sendKeys(string);
    }

    public String getOfferProductName(){
        return driver.findElement(offerProduct).getText();
    }

}
