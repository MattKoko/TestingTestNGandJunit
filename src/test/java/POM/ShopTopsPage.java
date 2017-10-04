package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Matek on 02.10.2017.
 */
public class ShopTopsPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id='subcategories']/ul/li[2]/div[1]/a/img")
    WebElement blousesButton;


    public ShopTopsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public ShopBlousesPage clickBlousesButton() {
        blousesButton.click();
        return new ShopBlousesPage(driver);
    }
}
