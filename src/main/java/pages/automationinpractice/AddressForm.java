package pages.automationinpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import support.pojos.AddressInformation;

//TODO: For the sake of time only mandatory and non-populated fields are being implemented now

public class AddressForm extends BasePage {

    private CreateAccountPage createAccountPage;

    //private By firstName = new By.ById("firstname");
    //private By lastName = new By.ById("lastname");
    private By address1 = new By.ById("address1");
    private By city = new By.ById("city");
    private By state = new By.ById("id_state");
    private By zip = new By.ById("postcode");
    private By mobilePhone = new By.ById("phone_mobile");

    public AddressForm(WebDriver driver, CreateAccountPage createAccountPage) {
        super(driver);
        this.createAccountPage = createAccountPage;
    }

    public CreateAccountPage fillAddress(AddressInformation info) {

        //driver.findElement(firstName).sendKeys(info.firstName);
        //driver.findElement(lastName).sendKeys(info.lastName);
        driver.findElement(address1).sendKeys(info.getAddressLine1());
        driver.findElement(city).sendKeys(info.getCity());
        new Select(driver.findElement(state)).selectByValue(info.getState().getValue().toString());
        driver.findElement(zip).sendKeys(info.getZip());
        driver.findElement(mobilePhone).sendKeys(info.getMobilePhone());
        return createAccountPage;
    }
}
