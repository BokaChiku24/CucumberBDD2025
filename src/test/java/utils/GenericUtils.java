package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class GenericUtils extends TestBase {

    public WebDriver driver;
    public WebDriverWait wait;

    public GenericUtils(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void switchToChildWindow() {
        if (!Objects.requireNonNull(driver.getCurrentUrl()).
                equalsIgnoreCase(getProperties().getProperty("offerURL"))) {
            Set<String> windowHandles = driver.getWindowHandles();
            Iterator<String> itr = windowHandles.iterator();
            String parentWindow = itr.next();
            String childWindow = itr.next();
            driver.switchTo().window(childWindow);
        }
    }

    public void visibilityOfElementLocatedByLocator(By locator){
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String splitString(String str) {
        String split = str.split("-")[0].trim();
        return split;
    }

    public void hardWait(){
        try {
            Thread.sleep(Duration.ofSeconds(2));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
