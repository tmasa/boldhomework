package support.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class DriverHelper {

    WebDriver driver;

    public DriverHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void closeCurrentTab() {
        driver.close();
    }

    public void switchToTabWithIndex(int index) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
    }

    public void closeTabWithIndex(int index) {
        switchToTabWithIndex(index);
        driver.close();
    }

    public void hoverOverElement(By locator, String textToFind) {
        Actions action = new Actions(driver);
        List<WebElement> candidates = driver.findElements(locator);
        WebElement foundElement = candidates.stream()
                .filter(actual -> actual.getText().trim().equals(textToFind))
                .findFirst()
                .get();

        action.moveToElement(foundElement).build().perform();

        /*
        TODO: Test seemingly works without Thread.Sleep as well, but it is closer to real life behavior.
          There should be a way to wait for animation to finish - but seemingly there are no changes on the UI
           other than a new attribute on the selected LI tag.
           Another way could be to check the underlying UL and wait for "g-fade" attribute, but that does not
           related to the animation.
         */
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrollDownByPixel(int numberOfPixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(String.format("window.scrollBy(0,%s)", numberOfPixels));
    }
}
