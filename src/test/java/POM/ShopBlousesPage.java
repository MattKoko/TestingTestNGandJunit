package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Matek on 02.10.2017.
 */
public class ShopBlousesPage {

    WebDriver driver;

    @FindBy(css ="#center_column > ul > li > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span")
    WebElement addToCartBlouse;

    @FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/span")
    WebElement continueShoppingButton;

    @FindBy(xpath = "//*[@id='header']/div[3]/div/div/div[3]/div/a")
    WebElement cartButton;



    public ShopBlousesPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public ShopBlousesPage clickAddToCartButton() {
        addToCartBlouse.click();
        return this;
    }


    public ShopBlousesPage clickContinueShoppingButton() {

//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));

        continueShoppingButton.click();
        return this;
    }

    public ShopCartPage clickCartButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        element.click();
        //cartButton.click();
        return new ShopCartPage(driver);
    }

}
