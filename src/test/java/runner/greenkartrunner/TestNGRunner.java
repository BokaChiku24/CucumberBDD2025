package runner.greenkartrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/e-commerce feature",
                 glue = "stepDefinitions",
                 monochrome = true,
                 plugin = {"pretty", "html:target/cucumber-reports.html"},
                 tags = "@GreenCartTest",
                 dryRun = true) // or - It should be either in the scenario or scenario outline
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
