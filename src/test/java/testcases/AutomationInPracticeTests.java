package testcases;

import dataproviders.ErrorMessageProvider;
import dataproviders.RegistrationInformationJsonProvider;
import dataproviders.ListOfElements;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.automationinpractice.HomePage;
import support.helpers.DriverHelper;
import support.pojos.RegistrationForm;

import java.util.List;
import java.util.Random;

public class AutomationInPracticeTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    /*
    RegistrationInformationJsonProvider reads test data in JSON file
    RegistrationInformationProvider reads test data in provider code
     */
    //@Test(dataProviderClass = RegistrationInformationProvider.class, dataProvider = "registrationData")
    @Test(dataProviderClass = RegistrationInformationJsonProvider.class, dataProvider = "registrationData")
    public void testRegistration(RegistrationForm registrationForm) {

        String accountInformationText = new HomePage(driver)
                .clickOnSignInLink()
                .enterEmailAddress(registrationForm.getPersonalInformation().getEmail())
                .clickOnCreateAccountButton()
                .fillRegistrationForm(registrationForm)
                .clickOnRegisterButton()
                .getAccountInformationText();

        Assert.assertTrue(accountInformationText.contains("Welcome to your account"));
    }

    @Test(dataProviderClass = ErrorMessageProvider.class, dataProvider = "mandatoryErrors")
    public void testMandatoryFields(ListOfElements listOfErrors) {

        List<String> expectedErrors = listOfErrors.getListOfStrings();

        List<String> errorMessages = new HomePage(driver)
                .clickOnSignInLink()
                .enterEmailAddress(String.format("random%s@random.com", new Random().nextInt()))
                .clickOnCreateAccountButton()
                .clickOnRegisterButtonWithError()
                .getErrors();

        Assert.assertEquals(expectedErrors, errorMessages);
    }

    @Test()
    public void testScrollDown() {

        HomePage homePage = new HomePage(driver);
        DriverHelper driverHelper = new DriverHelper(driver);

        //Setting browser to full screen, otherwise WebDriver returns a different height than browser's actual height
        driver.manage().window().fullscreen();

        int screenBottomCoordinate = driver.manage().window().getSize().getHeight();
        int footerTopCoordinate = homePage.getFooterTopCoordinate();
        int scrollByPixel = 100;
        do {
            driverHelper.scrollDownByPixel(scrollByPixel);
            //Deliberately added a small wait to see actual scrolling action
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            screenBottomCoordinate += scrollByPixel;
        } while(screenBottomCoordinate < footerTopCoordinate);
    }
}

