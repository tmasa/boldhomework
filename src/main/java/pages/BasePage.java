package pages;

import org.openqa.selenium.WebDriver;
import support.helpers.WaitHelper;

public class BasePage {

    protected WebDriver driver;
    public WaitHelper waiter;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WaitHelper(driver);
    }

}
