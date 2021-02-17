package pages.automationinpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import support.pojos.PersonalInformation;

public class PersonalInformationForm extends BasePage {

    private CreateAccountPage createAccountPage;

    private By firstName = new By.ById("customer_firstname");
    private By lastName = new By.ById("customer_lastname");
    private By email = new By.ById("email");
    private By password = new By.ById("passwd");
    private By newsletter = new By.ById("newsletter");
    private By offer = new By.ById("optin");

    private By dayOfBirth = new By.ById("days");
    private By monthOfBirth = new By.ById("months");
    private By yearOfBirth = new By.ById("years");

    public PersonalInformationForm(WebDriver driver, CreateAccountPage createAccountPage) {
        super(driver);
        this.createAccountPage = createAccountPage;
    }

    public CreateAccountPage fillPersonalInformation(PersonalInformation info) {

        String titlePartialId = info.getTitle().getIdSuffix().toString();
        driver.findElement(new By.ById(String.format("id_gender%s", titlePartialId))).click();

        driver.findElement(firstName).sendKeys(info.getFirstName());
        driver.findElement(lastName).sendKeys(info.getLastName());
        WebElement email = driver.findElement(this.email);

        if (!email.getText().equals(info.getEmail()))
        {
            //TODO: Possible bug - this should never happen, shall we throw an Exception at this point?
            email.clear();
            email.sendKeys(info.getEmail());
        }
        driver.findElement(password).sendKeys(info.getPassword());

        new Select(driver.findElement(dayOfBirth)).selectByValue(info.getDayOfBirth());
        new Select(driver.findElement(monthOfBirth)).selectByValue(info.getMonthOfBirth());
        new Select(driver.findElement(yearOfBirth)).selectByValue(info.getYearOfBirth());

        if (info.isNewsletterRequested()) {
            driver.findElement(newsletter).click();
        }
        if (info.isPartnerOfferRequested()) {
            driver.findElement(offer).click();
        }

        return createAccountPage;
    }

}
