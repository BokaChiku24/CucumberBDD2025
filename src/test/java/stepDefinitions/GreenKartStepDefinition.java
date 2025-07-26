/*
package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class GreenKartStepDefinition {
    public WebDriver driver;
    public WebDriverWait wait;
    public String landingProductName;
    public String offerProductName;

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                + "/SeleniumDrivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("user searched with shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String string) {
        // Write code here that turns the phrase above into concrete actions
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.search-keyword")));
        driver.findElement(By.cssSelector("input.search-keyword")).sendKeys(string);
        try {
            Thread.sleep(Duration.ofSeconds(2));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String productText = driver.findElement(By.cssSelector(".product h4")).getText();
        System.out.println("Product Text: " + productText);
        landingProductName = productText.split("-")[0].trim();
        System.out.println("Extracted Product Name: " + landingProductName);
    }

    @Then("user searched for {string} shortnmae in offer page")
    public void user_searched_for_shortnmae_in_offer_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.cssSelector("div.cart a:nth-child(2)")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> itr = windowHandles.iterator();
        String parentWindow = itr.next();
        String childWindow = itr.next();
        driver.switchTo().window(childWindow);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='search']")));
        driver.findElement(By.cssSelector("input[type='search']")).click();
        driver.findElement(By.cssSelector("input[type='search']")).sendKeys(string);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tbody tr td:nth-child(1)")));
        offerProductName = driver.findElement(By.cssSelector("tbody tr td:nth-child(1)")).getText();
        System.out.println(offerProductName);
    }

    @Then("validate name in offer page matches with landing pages")
    public void validate_name_in_offer_page_matches_with_landing_pages() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(landingProductName, offerProductName);
        driver.quit();
    }

}
*/