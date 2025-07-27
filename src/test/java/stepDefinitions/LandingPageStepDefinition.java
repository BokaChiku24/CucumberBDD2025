package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.LandingPage;
import pageobjects.PageObjectManager;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
    public WebDriver driver;
    public WebDriverWait wait;
    public TestContextSetup testContextSetup;
    public PageObjectManager pageObjectManager;

    // cucumber-picocontainer use dependency injection to inject the TestContextSetup instance

    public LandingPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("^user searched with shortname (.+) and extracted actual name of product$")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String string) {
        // Write code here that turns the phrase above into concrete actions
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        testContextSetup.genericUtils.visibilityOfElementLocatedByLocator(landingPage.search);
        landingPage.searchItem(string);
        testContextSetup.genericUtils.hardWait();
        testContextSetup.landingProductName = testContextSetup.genericUtils.splitString(landingPage.getProductName());
        System.out.println("Extracted Product Name: " + testContextSetup.landingProductName);

    }
}
