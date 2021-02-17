package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.guru99.HomePage;
import pages.guru99.LiveSeleniumProjectPage;
import pages.guru99.SeleniumTutorialPage;
import support.helpers.DriverHelper;

public class Guru99Tests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/guru99home/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test()
    public void testGuru99() {
        HomePage homePage = new HomePage(driver);

        //open ad in IFrame, verify title of new tab
        LiveSeleniumProjectPage liveSelProjPage = homePage.clickOnAdInIFrame();
        Assert.assertEquals("Selenium Live Project: FREE Real Time Project for Practice", liveSelProjPage.getLiveSeleniumProjectPageTitle());

        DriverHelper h = new DriverHelper(driver);

        //Close first tab
        h.closeTabWithIndex(0);
        //Switch to new first tab
        h.switchToTabWithIndex(0);
        //Hover over and click on item, verify join now button
        SeleniumTutorialPage selTutPage = liveSelProjPage.clickOnSeleniumMenu();
        Assert.assertTrue(selTutPage.isJoinNowButtonVisible());
    }
}

