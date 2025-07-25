package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
                 glue = "stepDefinitions",
                 monochrome = true,
                 plugin = {"pretty", "html:target/cucumber-reports.html"},
                 tags = "@SmokeTest")
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
