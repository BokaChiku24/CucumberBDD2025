package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageobjects.OffersPage;
import utils.TestContextSetup;

public class OfferPageStepDefiniton {
    TestContextSetup testContextSetup;
    String offerProductName;

    // cucumber-picocontainer use dependency injection to inject the TestContextSetup instance

    public OfferPageStepDefiniton(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    public void switchToOfferPage(String s) {
        testContextSetup.driver.switchTo().window(s);
        testContextSetup.wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector("input[type='search']")));
    }


    @Then("user searched for {string} shortnmae in offer page")
    public void user_searched_for_shortnmae_in_offer_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        OffersPage offersPage = testContextSetup.pageObjectManager.getOfferPage();
        switchToOfferPage(offersPage.goToChildWindow());
        offersPage.clickSearchTextbox();
        offersPage.sendKeyToSearchBox(string);
        testContextSetup.wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector("tbody tr td:nth-child(1)")));
        offerProductName = offersPage.getOfferProductName();
        System.out.println(offerProductName);
    }

    @Then("validate name in offer page matches with landing pages")
    public void validate_name_in_offer_page_matches_with_landing_pages() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(offerProductName, testContextSetup.landingProductName);
        this.testContextSetup.driver.quit();
    }
}
