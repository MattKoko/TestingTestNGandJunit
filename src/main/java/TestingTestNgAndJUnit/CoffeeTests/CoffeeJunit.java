package TestingTestNgAndJUnit.CoffeeTests;

import TestingTestNgAndJUnit.Pages.CoffeePages.CoffeeMainPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Matek on 02.05.2017.
 */
public class CoffeeJunit {

    static WebDriver driver;
    static CoffeeMainPage coffeeMainPage;

    @BeforeClass
    public static void beforeClass()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.globalsqa.com/angularJs-protractor/ConsumptionCalculator/");
        coffeeMainPage = new CoffeeMainPage(driver);
    }

    @AfterClass
    public static void afterClass()
    {
        driver.quit();
    }


    @Test
    public void checkZeroCupsOfCofee()
    {
        Assert.assertEquals(0, coffeeMainPage.getCountFieldSizeNotHidden());
    }

    @Test
    public void CheckCoffeeAmountInfo()
    {
        coffeeMainPage.fillCoffeeWindow();
        coffeeMainPage.checkWhatPopOut();
    }

    @Test

    public void CheckWarningPopOut()
    {
        coffeeMainPage.fillCoffeeWindowWarning();
        coffeeMainPage.checkWarning();
    }
}
