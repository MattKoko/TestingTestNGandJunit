package TestingTestNgAndJUnit.Pages.ShopPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Matek on 06.06.2017.
 */
public class ShopMainPage {

    WebDriver driver;

    By singInButton = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
    By womenButton = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a");
    By dressesButton = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
    By tShirtsButton = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a");
    By searchField = By.xpath("//*[@id=\"search_query_top\"]");
    By searchButton = By.xpath("//*[@id=\"searchbox\"]/button");
    By newsletterField = By.xpath("//*[@id=\"newsletter-input\"]");
    By newsletterButton = By.xpath("//*[@id=\"newsletter_block_left\"]/div/form/div/button");
    By contactUsButton = By.xpath("//*[@id=\"contact-link\"]/a");
    By topsButton = By.xpath("//*[@id=\"subcategories\"]/ul/li[1]/div[1]/a/img");
    By blousesButton = By.xpath("//*[@id=\"subcategories\"]/ul/li[2]/div[1]/a/img");
    //By blouseViewButton = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img");
    By addToCartBlouse = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span");
    By continueShoppingButton = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span");
    By cartButton = By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a");


    public ShopMainPage(WebDriver driver) {this.driver=driver;}

    public void clickSingInButton() { driver.findElement(singInButton).click(); }

    public void clickContactUsButton() { driver.findElement(contactUsButton).click(); }

    public void fillNewsletterField() { driver.findElement(newsletterField).sendKeys("test1email@gmail.com"); }

    public void clickNewsletterButton()
    {
        driver.findElement(newsletterButton).click();
    }

    public void fillSearchField()
    {
        driver.findElement(searchField).sendKeys("dress");
    }

    public void clickSearchButton()
    {
        driver.findElement(searchButton).click();
    }

    public void clickWomenButton() { driver.findElement(womenButton).click(); }

    public void clickTopsButton() { driver.findElement(topsButton).click(); }

    public void clickBlousesButton() { driver.findElement(blousesButton).click(); }

    //public void clickBlouseViewButton() { driver.findElement(blouseViewButton).click(); }

    public void clickAddToCartButton() { driver.findElement(addToCartBlouse).click(); }

    public void clickContinueShoppingButton() {driver.findElement(continueShoppingButton).click(); }

    public void clickCartButton() { driver.findElement(cartButton).click(); }




}
