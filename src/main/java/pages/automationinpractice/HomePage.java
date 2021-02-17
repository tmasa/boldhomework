package pages.automationinpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class HomePage extends BasePage {

    private By signInLink = new By.ByClassName("login");
    private By footer = new By.ByClassName("footer-container");

    public HomePage(WebDriver driver) {
        super(driver);
        waiter.waitForElementToBeVisible(signInLink);
    }

    public AuthenticationPage clickOnSignInLink() {
        driver.findElement(signInLink).click();
        return new AuthenticationPage(driver);
    }

    public int getFooterTopCoordinate() {
        WebElement ftr = driver.findElement(footer);
        return ftr.getLocation().getY();
    }
}
