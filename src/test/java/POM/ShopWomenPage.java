package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Matek on 02.10.2017.
 */
public class ShopWomenPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id='subcategories']/ul/li[1]/div[1]/a/img")
    WebElement topsButton;


    public ShopWomenPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public ShopTopsPage clickTopsButton() {
        topsButton.click();
        return new ShopTopsPage(driver);
    }
}
