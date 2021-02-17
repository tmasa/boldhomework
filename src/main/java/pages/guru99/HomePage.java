package pages.guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import support.helpers.DriverHelper;

public class HomePage extends BasePage {

    private By adIFrame = new By.ByName("a077aa5e");
    private By footer = new By.ByTagName("footer");

    public HomePage(WebDriver driver) {
        super(driver);
        waiter.waitForElementToBeVisible(footer);
    }

    public LiveSeleniumProjectPage clickOnAdInIFrame() {

        //click on ad to open a new tab
        WebElement iframe = driver.findElement(adIFrame);

        //must switch to frame to be able to address elements inside
        driver.switchTo().frame(iframe).findElement(new By.ByTagName("img")).click();

        //switch to new tab otherwise selenium will look for elements on the default tab
        new DriverHelper(driver).switchToTabWithIndex(1);

        return new LiveSeleniumProjectPage(driver);
    }
}
