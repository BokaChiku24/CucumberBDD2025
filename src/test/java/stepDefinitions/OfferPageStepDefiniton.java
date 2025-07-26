package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefiniton {
    TestContextSetup testContextSetup;
    String offerProductName;

    // cucumber-picocontainer use dependency injection to inject the TestContextSetup instance

    public OfferPageStepDefiniton(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @Then("user searched for {string} shortnmae in offer page")
    public void user_searched_for_shortnmae_in_offer_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.testContextSetup.driver.findElement(By.cssSelector("div.cart a:nth-child(2)")).click();
        Set<String> windowHandles = this.testContextSetup.driver.getWindowHandles();
        Iterator<String> itr = windowHandles.iterator();
        String parentWindow = itr.next();
        String childWindow = itr.next();
        this.testContextSetup.driver.switchTo().window(childWindow);
        testContextSetup.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='search']")));
        this.testContextSetup.driver.findElement(By.cssSelector("input[type='search']")).click();
        this.testContextSetup.driver.findElement(By.cssSelector("input[type='search']")).sendKeys(string);
        testContextSetup.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tbody tr td:nth-child(1)")));
        offerProductName = this.testContextSetup.driver.findElement(By.cssSelector("tbody tr td:nth-child(1)")).getText();
        System.out.println(offerProductName);
    }

    @Then("validate name in offer page matches with landing pages")
    public void validate_name_in_offer_page_matches_with_landing_pages() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(offerProductName, testContextSetup.landingProductName);
        this.testContextSetup.driver.quit();
    }
}
