package utils;

/*
 * This class is used to set up the test context for Cucumber tests.
 * Cucumber injects this context into step definitions,
 * allowing them to share data and state across different steps.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.PageObjectManager;

public class TestContextSetup {

    public WebDriver driver;
    public WebDriverWait wait;
    public String landingProductName;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;

    public TestContextSetup() {
        // Initialize the PageObjectManager with the WebDriver instance
        testBase = new TestBase();
        driver = testBase.WebdriverManager();
        pageObjectManager = new PageObjectManager(driver);
        genericUtils = new GenericUtils(driver);
    }
}
