package StoreWebsiteTest;

import POM.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Matek on 06.06.2017.
 */
public class ShopTestNG extends SetUpTest {




    @Test
    public void loginToShopPage() {
        shopMainPage = new ShopMainPage(driver);
        shopLoginPage = shopMainPage.clickSingInButton();
        shopLoginPage.fillEmail().fillPassword().clickSingIn();

        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + "Welcome to your account." + "')]"));
        Assert.assertTrue(list.size() > 0, "Text not found!");

       
        //        shopLoginPage.clickSingIn();
        //        ShopMyAccountPage shopMyAccountPage = new ShopMyAccountPage(driver);

    }

    @Test
    public void ContactUsTest() {
        shopMainPage = new ShopMainPage(driver);
        shopContactUsPage = shopMainPage.clickContactUsButton();
        shopContactUsPage.chooseSubject().fillEmailContactUsField().fillOrderContactUsField().fillMessageField().clickSendMessageButton();

        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + "Your message has been successfully sent to our team." + "')]"));
        Assert.assertTrue(list.size() > 0, "Text not found!");
    }

    @Test
    public void NewsletterSubscription() {
        shopMainPage = new ShopMainPage(driver);
        shopMainPage.fillNewsletterField().clickNewsletterButton();

        // List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + " Newsletter : You have successfully subscribed to this newsletter." + "')]"));
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + " Newsletter : This email address is already registered." + "')]"));
        Assert.assertTrue(list.size() > 0, "Text not found!");
    }

    @Test
    public void SearchingWorking() {
        shopMainPage = new ShopMainPage(driver);
        shopMainPage.fillSearchField();
        shopMainPage.clickSearchButton();
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + "Showing 1 - 7 of 7 items" + "')]"));
        Assert.assertTrue(list.size() > 0, "Text not found!");
    }

    @Test//(priority = 0, dependsOnMethods = "SearchingWorking")
    public void AddingToCart() throws InterruptedException {
        shopMainPage = new ShopMainPage(driver);
        shopMainPage.clickWomenButton();
        shopTopsPage = shopWomenPage.clickTopsButton();
        shopBlousesPage = shopTopsPage.clickBlousesButton();

        //hover
        WebElement ele=driver.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img"));
        Actions act=new Actions(driver);
        act.moveToElement(ele).perform();
        Thread.sleep(3000);
        //end of hover

        //Scroll down
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        // end of scroll down

        shopBlousesPage.clickAddToCartButton();
        Thread.sleep(3000);
        shopBlousesPage.clickContinueShoppingButton();

        //Scroll up
        jse.executeScript("window.scrollBy(0,-250)", "");
        //end of scroll up

        shopBlousesPage.clickCartButton();

        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + "Blouse" + "')]"));
        Assert.assertTrue(list.size() > 0, "Text not found!");
    }



}
