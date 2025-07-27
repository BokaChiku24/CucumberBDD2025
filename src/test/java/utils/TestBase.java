package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBase {

    public WebDriver driver;

    public WebDriver WebdriverManager() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                    + "/SeleniumDrivers/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            return driver;
        }
        return driver;
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null; // Set driver to null after closing to allow reinitialization
        }
    }

}
