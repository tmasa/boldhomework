package pages.automationinpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class MyAccountPage extends BasePage {

    By accountButtons = new By.ByClassName("myaccount-link-list");
    By accountInformation = new By.ByClassName("info-account");

    public MyAccountPage(WebDriver driver) {
        super(driver);
        waiter.waitForElementToBeVisible(accountButtons);
    }

    public String getAccountInformationText() {
        return driver.findElement(accountInformation).getText();
    }
}
