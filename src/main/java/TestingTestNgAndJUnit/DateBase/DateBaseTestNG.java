package TestingTestNgAndJUnit.DateBase;

import TestingTestNgAndJUnit.Pages.DateBasePages.DateBaseMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

/**
 * Created by Matek on 02.05.2017.
 */
public class DateBaseTestNG {


        WebDriver driver;
        DateBaseMainPage dateBaseMainPage;

        @BeforeClass
        public void beforeClass()
        {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("http://www.globalsqa.com/angularJs-protractor/SearchFilter/");
            dateBaseMainPage = new DateBaseMainPage(driver);
        }

        @AfterClass
        public void afterClass()
        {
            driver.quit();
        }


        //@Test
}
