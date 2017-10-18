package StoreWebsiteTest;

import POM.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by Matek on 27.09.2017.
 */
public class SetUpTest {

    protected WebDriver driver;
    protected ShopMainPage shopMainPage;
    protected final String URL_TO_TEST = "http://automationpractice.com/index.php";
    protected ShopLoginPage shopLoginPage;
    protected ShopContactUsPage shopContactUsPage;
    protected ShopWomenPage shopWomenPage;
    protected ShopBlousesPage shopBlousesPage;
    protected ShopTopsPage shopTopsPage;
    protected ShopCartPage shopCartPage;
    protected ShopFadedShortTshirt shopFadedShortTshirt;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\test jsava\\TestsByMK\\src\\test\\java\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get(URL_TO_TEST);
    }

    @AfterClass
    public void shutDown(){
        driver.quit();
    }

}
