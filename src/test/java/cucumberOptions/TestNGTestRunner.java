package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features/e-commerce feature",
        glue = "stepDefinitions",
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-reports.html"}
) // or - It should be either in the scenario or scenario outline
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        // This method is used to provide scenarios for parallel execution
        return super.scenarios();
    }
}