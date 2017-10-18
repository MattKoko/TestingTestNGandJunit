package StoreWebsiteTest;

import POM.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
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

    }

    @Test
    public void contactUsTest() {
        shopMainPage = new ShopMainPage(driver);
        shopContactUsPage = shopMainPage.clickContactUsButton();
        shopContactUsPage.chooseSubjectToCustomer().fillEmailContactUsField().fillOrderContactUsField().fillMessageField().clickSendMessageButton();

        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + "Your message has been successfully sent to our team." + "')]"));
        Assert.assertTrue(list.size() > 0, "Text not found!");
    }

    @Test
    public void newsletterSubscription() {
        shopMainPage = new ShopMainPage(driver);
        shopMainPage.fillNewsletterField().clickNewsletterButton();

        // List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + " Newsletter : You have successfully subscribed to this newsletter." + "')]"));
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + " Newsletter : This email address is already registered." + "')]"));
        Assert.assertTrue(list.size() > 0, "Text not found!");
    }

    @Test
    public void searchingWorking() {
        shopMainPage = new ShopMainPage(driver);
        shopMainPage.fillSearchField();
        shopMainPage.clickSearchButton();
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + "Showing 1 - 7 of 7 items" + "')]"));
        Assert.assertTrue(list.size() > 0, "Text not found!");
    }

    @Test
    public void addingToCart() throws InterruptedException {
        shopMainPage = new ShopMainPage(driver);
        shopWomenPage = shopMainPage.clickWomenButton();
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

    @Test
    public void changeSubjectToCustomer() {
        shopMainPage = new ShopMainPage(driver);
        shopContactUsPage = shopMainPage.clickContactUsButton();
        shopContactUsPage.chooseSubjectToCustomer();

        List<WebElement> list = driver.findElements(By.xpath("//*[@id='desc_contact2' and not(contains(@style,'display: none'))]"));
        Assert.assertEquals(list.size(), 1);
    }

    @Test
    public void changeSubjectToWebmaster() {
        shopMainPage = new ShopMainPage(driver);
        shopContactUsPage = shopMainPage.clickContactUsButton();
        shopContactUsPage.chooseSubjectToWebmaster();

        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + "If a technical problem occurs on this website" + "')]"));
        Assert.assertTrue(list.size() > 0, "Text not found!");
    }


    @DataProvider(name = "URLL")

    public static Object[][] credentials(){
        return  new Object[][] {{"https://www.facebook.com/groups/525066904174158/", "DataProvider 1st loop"},{"https://www.facebook.com/groups/525066904174158/", "DataProvider 2nd loop"}};
    }

    @Test(dataProvider = "URLL")
    public void checkingFollowUsFacebookURL(String url, String message) {
        shopMainPage = new ShopMainPage(driver);
        shopMainPage.clickFollowUsFacebookButton();
        String parentWindow = driver.getTitle();
        String newWindow = "";
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());

        //Get new window handle
        for (int i = 0; i < browserTabs.size(); i++) {
            if (browserTabs.get(i) != parentWindow) {
                newWindow = browserTabs.get(i);
            }
        }

        driver.switchTo().window(newWindow);
        String URLofFacebookTab = driver.getCurrentUrl();
        Assert.assertTrue(URLofFacebookTab.equals(url), message);
        System.out.println(message);

    }

    @Test
    public void checkingFollowUsTwitterURL(){
        shopMainPage = new ShopMainPage(driver);
        shopMainPage.clickFollowUsTwitterButton();
    }

    @Test
    public void checkingFollowUsYouTubeURL(){
        shopMainPage = new ShopMainPage(driver);
        shopMainPage.clickFollowUsYouTubeButton();
    }

    @Test
    public void checkingFollowUsGoogleURL(){
        shopMainPage = new ShopMainPage(driver);
        shopMainPage.clickFollowUsGoogleButton();
    }

    @Test
    public void checkingFollowUsFacebookNewTabOpening(){
        shopMainPage = new ShopMainPage(driver);
        shopMainPage.clickFollowUsFacebookButton();
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        Assert.assertTrue(browserTabs.size()==2, "There is no new tab");
    }

    @Test
    public void checkingFollowUsTwitterNewTabOpening(){
        shopMainPage = new ShopMainPage(driver);
        shopMainPage.clickFollowUsTwitterButton();
        String parentWindow = driver.getTitle();
        String newWindow = "";
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());

        //Get new window handle
        for (int i = 0; i < browserTabs.size(); i++) {
            if (browserTabs.get(i) != parentWindow) {
                newWindow = browserTabs.get(i);
            }
        }

        driver.switchTo().window(newWindow);
        System.out.println("New Window Title: " + driver.getTitle());
        String expectedNewWindowTitle = "Selenium Framework (@seleniumfrmwrk) | Twitter";
        Assert.assertEquals(expectedNewWindowTitle, driver.getTitle());

    }

    @Test
    public void checkingFollowUsYouTubeNewTabOpening(){
        shopMainPage = new ShopMainPage(driver);
        shopMainPage.clickFollowUsYouTubeButton();
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        Assert.assertTrue(browserTabs.size()==2, "There is no new tab");
    }

    @Test
    public void checkingFollowUsGoogleNewTabOpening(){
        shopMainPage = new ShopMainPage(driver);
        shopMainPage.clickFollowUsGoogleButton();
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        Assert.assertTrue(browserTabs.size()==2, "There is no new tab");
    }

    @Test
    public void checkingAddingToCart3() throws InterruptedException {
        shopMainPage = new ShopMainPage(driver);

        shopFadedShortTshirt = shopMainPage.clickOpenPageOfFadedShortTshirtButton();
        shopFadedShortTshirt.fillQuantityFieldTo3().clickAddtoCartButton();
        Thread.sleep(3000);
        shopCartPage = shopFadedShortTshirt.clickProceedToCheckoutButton();

        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + "3 Products" + "')]"));
        Assert.assertTrue(list.size() > 0, "Text not found!");


    }

    @Test
    public void checkingAddingToCart1003() throws InterruptedException {
        shopMainPage = new ShopMainPage(driver);
        shopFadedShortTshirt = shopMainPage.clickOpenPageOfFadedShortTshirtButton();
        shopFadedShortTshirt.fillQuantityFieldTo1003().clickAddtoCartButton();
        Thread.sleep(3000);
        shopCartPage = shopFadedShortTshirt.clickProceedToCheckoutButton();
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + "3 Products" + "')]"));
        Assert.assertTrue(list.size() > 0, "Text not found!");

    }




}
