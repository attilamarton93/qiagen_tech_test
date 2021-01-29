package web;

import com.pageObjects.HomePage;
import com.pageObjects.ResultsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class FindPackageTest {
    WebDriver driver;

    @Before
    public void setup() {
        String baseUrl = "http://www.hotwire.com/";
        System.setProperty("webdriver.chrome.driver", "/Users/attilamarton/IdeaProjects/qiagen_tech_test/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void findPackage() {
        HomePage homePage = new HomePage(driver);
        ResultsPage resultsPage = new ResultsPage(driver);
        homePage.clickFlightHotelCarButton();
        homePage.sendTextToFlyFromField("SFO");
        homePage.sendTextToFlyToField("LAX");
        LocalDate departingDate = LocalDate.now().plusDays(1);
        LocalDate returningDate = departingDate.plusDays(20);
        homePage.pickDepartingDate(departingDate);
        homePage.pickReturningDate(returningDate);
        homePage.clickSubmitButton();
        Assert.assertTrue(resultsPage.isResultsEmpty());
    }

    @After
    public void close() {
        driver.close();
    }
}
