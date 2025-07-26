package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestContextSetup;

import java.time.Duration;

public class LandingPageStepDefinition {
    public WebDriver driver;
    public WebDriverWait wait;
    public String landingProductName;
    public TestContextSetup testContextSetup;

    // cucumber-picocontainer use dependency injection to inject the TestContextSetup instance

    public LandingPageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                + "/SeleniumDrivers/chromedriver");
        testContextSetup.driver = new ChromeDriver();
        testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        testContextSetup.driver.manage().window().maximize();
        testContextSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        testContextSetup.wait = new WebDriverWait(testContextSetup.driver, Duration.ofSeconds(10));
    }

    @When("user searched with shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String string) {
        // Write code here that turns the phrase above into concrete actions
        testContextSetup.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.search-keyword")));
        testContextSetup.driver.findElement(By.cssSelector("input.search-keyword")).sendKeys(string);
        try {
            Thread.sleep(Duration.ofSeconds(2));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String productText = testContextSetup.driver.findElement(By.cssSelector(".product h4")).getText();
        System.out.println("Product Text: " + productText);
        testContextSetup.landingProductName = productText.split("-")[0].trim();
        System.out.println("Extracted Product Name: " + testContextSetup.landingProductName);
    }
}
