package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    public WebDriver driver;

    public LandingPage(WebDriver driver){
            this.driver = driver;
    }

    public By search = By.cssSelector("input.search-keyword");
    By productName = By.cssSelector(".product h4");

    public void searchItem(String name){
        driver.findElement(search).sendKeys(name);
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }

}
