package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.LandingPage;
import pageobjects.PageObjectManager;
import utils.TestContextSetup;

import java.time.Duration;

public class LandingPageStepDefinition {
    public WebDriver driver;
    public WebDriverWait wait;
    public TestContextSetup testContextSetup;
    public PageObjectManager pageObjectManager;

    // cucumber-picocontainer use dependency injection to inject the TestContextSetup instance

    public LandingPageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("user searched with shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String string) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        testContextSetup.wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector("input.search-keyword")));
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.searchItem(string);
        Thread.sleep(Duration.ofSeconds(2));
        testContextSetup.landingProductName = landingPage.getProductName().split("-")[0].trim();
        System.out.println("Extracted Product Name: " + testContextSetup.landingProductName);

    }
}
