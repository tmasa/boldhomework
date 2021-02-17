package pages.guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import support.helpers.DriverHelper;

import java.util.List;

public class LiveSeleniumProjectPage extends BasePage {

    By navBar = new By.ById("g-navigation");
    By title = new By.ByTagName("h1");

    By menuItems = new By.ByClassName("g-menu-item-title");

    public LiveSeleniumProjectPage(WebDriver driver) {
        super(driver);
        waiter.waitForElementToBeVisible(navBar);
    }

    public String getLiveSeleniumProjectPageTitle() {
        return driver.findElement(title).getText();
    }

    public SeleniumTutorialPage clickOnSeleniumMenu() {
        clickOnSubMenu("Testing", "Selenium");
        return new SeleniumTutorialPage(driver);
    }

    private void clickOnSubMenu(String mainMenuName, String subMenuName) {
        DriverHelper h = new DriverHelper(driver);
        h.hoverOverElement(menuItems, mainMenuName);
        clickOnMenuItem(subMenuName);
    }

    private void clickOnMenuItem(String subMenuName) {
        List<WebElement> items = driver.findElements(menuItems);
        items.stream()
            .filter(actual -> actual.getText().trim().equals(subMenuName))
            .findFirst()
            .get()
            .click();
    }
}
