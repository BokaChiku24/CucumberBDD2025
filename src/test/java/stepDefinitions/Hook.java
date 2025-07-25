package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

    // This class is used to define hooks that run before or after scenarios
    // or scenario outlines in Cucumber tests.
    // Before -> Background -> Scenario/Scenario Outline -> After

    // backgroundFeature.feature
    @Before("@NetBanking")
    public void beforeSmokeTest() {
        System.out.println("Executing before Smoke Test");
    }

    @After
    public void tearDown() {
        System.out.println("Clear the entries");
    }

}
