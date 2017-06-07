package TestingTestNgAndJUnit.ShopTests;

import TestingTestNgAndJUnit.Pages.ShopPages.ShopContactUsPage;
import TestingTestNgAndJUnit.Pages.ShopPages.ShopLoginPage;
import TestingTestNgAndJUnit.Pages.ShopPages.ShopMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Matek on 06.06.2017.
 */
public class ShopTestNG {

    WebDriver driver;
    ShopMainPage shopMainPage;
    ShopLoginPage shopLoginPage;
    ShopContactUsPage shopContactUsPage;


    @BeforeClass
    public void beforeClass()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        shopLoginPage = new ShopLoginPage(driver);
        shopMainPage = new ShopMainPage(driver);
        shopContactUsPage = new ShopContactUsPage(driver);

    }

    @AfterClass
    public void afterClass()
    {
        driver.quit();
    }


    @Test
    public void LoginToShopPage()
    {
        shopMainPage.clickSingInButton();
        shopLoginPage.fillEmail();
        shopLoginPage.fillPassword();
        shopLoginPage.clickSingIn();
    }

    @Test
    public void ChooseSubject() throws InterruptedException {
        shopMainPage.clickContactUsButton();
        shopContactUsPage.chooseSubject();
        shopContactUsPage.fillEmailContactUsField();
        shopContactUsPage.fillOrderContactUsField();
        shopContactUsPage.fillMessageField();
        shopContactUsPage.clickSendMessageButton();
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + "Your message has been successfully sent to our team." + "')]"));
        Assert.assertTrue(list.size() > 0, "Text not found!");
        Thread.sleep(3000);
    }

    @Test
    public void NewsletterSubscribtion()
    {
        shopMainPage.fillNewsletterField();
        shopMainPage.clickNewsletterButton();
        // List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + " Newsletter : You have successfully subscribed to this newsletter." + "')]"));
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + " Newsletter : This email address is already registered." + "')]"));
        Assert.assertTrue(list.size() > 0, "Text not found!");
    }

    @Test
    public void SearchingWorking()
    {
        shopMainPage.fillSearchField();
        shopMainPage.clickSearchButton();
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + "Showing 1 - 7 of 7 items" + "')]"));
        Assert.assertTrue(list.size() > 0, "Text not found!");
    }



}
