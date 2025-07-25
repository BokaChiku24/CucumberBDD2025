package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
                 glue = "stepDefinitions",
                 monochrome = true,
                 plugin = {"pretty", "html:target/cucumber-reports.html","json:target/cucumber-reports.json"},
                 // tags = "@SmokeTest", It prefer only one tag
                 // tags = "@SmokeTest and @Regression", and - It should be same in the scenario or sceqrio outline
                 tags = "@SmokeTest or @Regression or @NetBanking") // or - It should be either in the scenario or scenario outline
public class TestNGRunnerJSON extends AbstractTestNGCucumberTests {

}
