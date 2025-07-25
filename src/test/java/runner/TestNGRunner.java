package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
                 glue = "stepDefinitions",
                 monochrome = true,
                 plugin = {"pretty", "html:target/cucumber-reports.html"},
                 // tags = "@SmokeTest", It prefer only one tag
                 // tags = "@SmokeTest and @Regression", and - It should be same in the scenario or sceqrio outline
                 tags = "@SmokeTest or @Regression") // or - It should be either in the scenario or scenario outline
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
