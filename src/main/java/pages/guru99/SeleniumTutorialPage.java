package pages.guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class SeleniumTutorialPage extends BasePage {

    By joinNowButton = new By.ByName("providence-submit");

    public SeleniumTutorialPage(WebDriver driver) {
        super(driver);
        waiter.waitForElementToBeVisible(joinNowButton);
    }

    public boolean isJoinNowButtonVisible() {
        return driver.findElement(joinNowButton).isDisplayed();
    }




}
