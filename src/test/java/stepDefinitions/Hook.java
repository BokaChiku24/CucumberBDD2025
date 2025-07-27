package stepDefinitions;

import io.cucumber.java.After;
import utils.TestContextSetup;

public class Hook {
    public TestContextSetup testContextSetup;

    public Hook(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @After
    public void AfterScenario() {
        testContextSetup.testBase.closeBrowser();
        System.out.println("Browser closed and driver reset to null after scenario.");
    }
}
