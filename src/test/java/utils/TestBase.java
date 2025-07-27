package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    public WebDriver driver;
    public Properties prop;
    public FileInputStream fis;

    public Properties getProperties() {
        if (prop != null) {
            return prop; // Return existing properties if already loaded
        } else {
            prop = new Properties();
            try {
                fis = new FileInputStream(System.getProperty("user.dir")
                        + "/src/test/resources/properties/Global.properties");
                prop.load(fis);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return prop;
        }
    }

    public WebDriver WebdriverManager() {
        prop = getProperties();
        if (prop.getProperty("browser").equalsIgnoreCase("Chrome")) {
            if (driver == null) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                        + "/SeleniumDrivers/chromedriver");
                driver = new ChromeDriver();
                driver.get(prop.getProperty("url"));
                driver.manage().window().maximize();
                driver.manage().timeouts().
                        implicitlyWait(Duration.ofSeconds(Long.parseLong(prop.getProperty("implicitWait"))));
                return driver;
            }
            return driver;
        } else {
            throw new RuntimeException("Browser not supported: " + prop.getProperty("browser"));
        }
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null; // Set driver to null after closing to allow reinitialization
        }
    }

}
