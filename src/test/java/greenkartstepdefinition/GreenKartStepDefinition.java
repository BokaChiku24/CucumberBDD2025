package greenkartstepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GreenKartStepDefinition {
    public WebDriver driver;
    public WebDriverWait wait;

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                + "/SeleniumDrivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @When("user searched with shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String string) {
        // Write code here that turns the phrase above into concrete actions
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.search-keyword")));
        driver.findElement(By.cssSelector("input.search-keyword")).click();
        driver.findElement(By.cssSelector("input.search-keyword")).sendKeys(string);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product h4")));
        String productText = driver.findElement(By.cssSelector(".product h4")).getText();
        System.out.println("Product Text: " + productText);
    }

    @Then("user searched for same shortnmae in offer page to check if product exist")
    public void user_searched_for_same_shortnmae_in_offer_page_to_check_if_product_exist() {
        // Write code here that turns the phrase above into concrete actions
        // driver.quit();
    }

}
