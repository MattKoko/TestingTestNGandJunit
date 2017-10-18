package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Matek on 18.10.2017.
 */
public class ShopFadedShortTshirt {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"quantity_wanted\"]")
    WebElement quantityField;

    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button/span")
    WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    WebElement proceedToCheckoutButton;


    public ShopFadedShortTshirt(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }




    public ShopFadedShortTshirt fillQuantityFieldTo3(){
        quantityField.clear();
        quantityField.click();
        quantityField.sendKeys("3");
        return this;
    }

    public ShopFadedShortTshirt fillQuantityFieldTo1003(){
        quantityField.clear();
        quantityField.click();
        quantityField.sendKeys("1003");
        return this;
    }

    public ShopFadedShortTshirt clickAddtoCartButton(){
        addToCartButton.click();
        return this;
    }
    public ShopCartPage clickProceedToCheckoutButton(){
        proceedToCheckoutButton.click();
        return new ShopCartPage(driver);
    }

}
