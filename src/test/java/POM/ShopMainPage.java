package POM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Matek on 06.06.2017.
 */
public class ShopMainPage {

    WebDriver driver;

    @FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
    WebElement singInButton;

    @FindBy(xpath="//*[@id='block_top_menu']/ul/li[1]/a")
    WebElement womenButton;

    @FindBy(xpath="//*[@id='search_query_top']")
    WebElement searchField;

    @FindBy(xpath="//*[@id='searchbox']/button")
    WebElement searchButton;

    @FindBy(xpath="//*[@id='newsletter-input']")
    WebElement newsletterField;

    @FindBy(xpath="//*[@id='newsletter_block_left']/div/form/div/button")
    WebElement newsletterButton;

    @FindBy(xpath="//*[@id='contact-link']/a")
    WebElement contactUsButton;

    @FindBy(xpath="//*[@id='social_block']/ul/li[1]/a")
    WebElement followUsFacebookButton;

    @FindBy(xpath="//*[@id='social_block']/ul/li[2]/a")
    WebElement followUsTwitterButton;

    @FindBy(xpath="//*[@id='social_block']/ul/li[3]/a")
    WebElement followUsYouTubeButton;

    @FindBy(xpath="//*[@id='social_block']/ul/li[4]/a")
    WebElement followUsGoogleButton;

    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]/div/div[2]/h5/a")
    WebElement openPageOfFadedShortTshirt;




    public ShopMainPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public ShopLoginPage clickSingInButton() {
        singInButton.click();
        return new ShopLoginPage(driver);
    }

    public ShopContactUsPage clickContactUsButton() {
        contactUsButton.click();
        return new ShopContactUsPage(driver);
    }


    public ShopMainPage fillNewsletterField() {
        newsletterField.sendKeys("test1email@gmail.com");
        return this;
    }

    public ShopMainPage clickNewsletterButton()
    {
        newsletterButton.click();
        return new ShopMainPage(driver);
    }

    public void fillSearchField()
    {
        searchField.sendKeys("dress");
    }

    public ShopSearchPage clickSearchButton()
    {
        searchButton.click();
        return new ShopSearchPage(driver);
    }

    public ShopWomenPage clickWomenButton() {
        womenButton.click();
        return new ShopWomenPage(driver);
    }

    public void clickFollowUsFacebookButton(){
        followUsFacebookButton.click();
    }

    public void clickFollowUsTwitterButton(){
        followUsTwitterButton.click();
    }

    public void clickFollowUsYouTubeButton(){
        followUsYouTubeButton.click();
    }

    public void clickFollowUsGoogleButton(){
        followUsGoogleButton.click();
    }

    public ShopFadedShortTshirt clickOpenPageOfFadedShortTshirtButton(){
        openPageOfFadedShortTshirt.click();
        return new ShopFadedShortTshirt(driver);
    }

}
