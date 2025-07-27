package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobjects.OffersPage;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
    TestContextSetup testContextSetup;
    String offerProductName;

    // cucumber-picocontainer use dependency injection to inject the TestContextSetup instance

    public OfferPageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @Then("user searched for {string} shortnmae in offer page")
    public void user_searched_for_shortnmae_in_offer_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        OffersPage offersPage = testContextSetup.pageObjectManager.getOfferPage();
        offersPage.clickOnOfferLink();
        testContextSetup.genericUtils.switchToChildWindow();
        testContextSetup.genericUtils.
                visibilityOfElementLocatedByLocator(offersPage.searchTextbox);
        offersPage.clickSearchTextbox();
        offersPage.sendKeyToSearchBox(string);
        testContextSetup.genericUtils.
                visibilityOfElementLocatedByLocator(offersPage.offerProduct);
        offerProductName = offersPage.getOfferProductName();
    }

    @Then("validate name in offer page matches with landing pages")
    public void validate_name_in_offer_page_matches_with_landing_pages() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(offerProductName, testContextSetup.landingProductName);
        testContextSetup.testBase.closeBrowser();
    }
}
