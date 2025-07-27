package utils;

/*
 * This class is used to set up the test context for Cucumber tests.
 * Cucumber injects this context into step definitions,
 * allowing them to share data and state across different steps.
 */

import org.openqa.selenium.WebDriver;
import pageobjects.PageObjectManager;

public class TestContextSetup {

    public WebDriver driver;
    public String landingProductName;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;

    public TestContextSetup() {
        testBase = new TestBase();
        driver = testBase.WebdriverManager();
        pageObjectManager = new PageObjectManager(driver);
        genericUtils = new GenericUtils(driver);
    }
}
