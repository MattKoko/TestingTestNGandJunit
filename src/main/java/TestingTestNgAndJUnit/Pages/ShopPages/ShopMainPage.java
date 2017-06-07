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

    public ShopMainPage(WebDriver driver) {this.driver=driver;}


    public void clickSingInButton()
    {
        driver.findElement(singInButton).click();
    }

    public void clickContactUsButton()
    {
        driver.findElement(contactUsButton).click();
    }

    public void fillNewsletterField()
    {
        driver.findElement(newsletterField).sendKeys("test1email@gmail.com");
    }
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


}
