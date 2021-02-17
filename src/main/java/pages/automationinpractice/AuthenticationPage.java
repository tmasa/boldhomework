package pages.automationinpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class AuthenticationPage extends BasePage {

    private By createAccountEmailField = new By.ById("email_create");
    private By createAccountButton = new By.ById("SubmitCreate");

    public AuthenticationPage(WebDriver driver) {
        super(driver);
        waiter.waitForElementToBeVisible(createAccountButton);
    }

    public AuthenticationPage enterEmailAddress(String emailAddress) {
        waiter.waitForElementToBeVisible(createAccountEmailField);
        driver.findElement(createAccountEmailField).sendKeys(emailAddress);
        return this;
    }

    public CreateAccountPage clickOnCreateAccountButton() {
        driver.findElement(createAccountButton).click();
        return new CreateAccountPage(driver);
    }
}
