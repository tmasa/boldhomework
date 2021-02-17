package support.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

    WebDriver driver;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeVisible(By locator) {
        waitForElementToBeVisible(locator, 5);
    }

    public void waitForElementToBeVisible(By locator, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
