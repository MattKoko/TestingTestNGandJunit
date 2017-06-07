package TestingTestNgAndJUnit.CoffeeTests;


import TestingTestNgAndJUnit.Pages.CoffeePages.CoffeeMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Matek on 02.05.2017.
 */
public class CoffeeTestNG {

    WebDriver driver;
    CoffeeMainPage coffeeMainPage;

    @BeforeClass
    public void beforeClass()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.globalsqa.com/angularJs-protractor/ConsumptionCalculator/");
        coffeeMainPage = new CoffeeMainPage(driver);
    }

    @AfterClass
    public void afterClass()
    {
        driver.quit();
    }


    @Test
    public void checkZeroCupsOfCofee()
    {
        Assert.assertEquals(coffeeMainPage.getCountFieldSizeNotHidden(), 0);
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



