package pages.automationinpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import support.pojos.RegistrationForm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CreateAccountPage extends BasePage {

    //TODO: Possible improvement -> Page factory to remove findElement calls
    private By errorFields = new By.ByCssSelector(".alert.alert-danger li");
    private By registerButton = new By.ById("submitAccount");

    public PersonalInformationForm personalInformationForm;
    public AddressForm addressForm;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        waiter.waitForElementToBeVisible(registerButton);
        personalInformationForm = new PersonalInformationForm(driver, this);
        addressForm = new AddressForm(driver, this);
    }

    public List<String> getErrors() {
        List<WebElement> errorLocators = driver.findElements(errorFields);
        return errorLocators.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public CreateAccountPage clickOnRegisterButtonWithError() {
        driver.findElement(registerButton).click();
        return this;
    }

    public MyAccountPage clickOnRegisterButton() {
        driver.findElement(registerButton).click();
        return new MyAccountPage(driver);
    }

    public CreateAccountPage fillRegistrationForm(RegistrationForm form) {
        personalInformationForm.fillPersonalInformation(form.getPersonalInformation());
        addressForm.fillAddress(form.getAddressInformation());
        return this;
    }

}
