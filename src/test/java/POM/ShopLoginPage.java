package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Matek on 06.06.2017.
 */
public class ShopLoginPage {

    WebDriver driver;

// login i hasło to d1796899@mvrht.net

    @FindBy(xpath="//*[@id='email']")
    WebElement emailField ;

    @FindBy(xpath="//*[@id='passwd']")
    WebElement passwordField ;

    @FindBy(xpath="//*[@id='SubmitLogin']/span")
    WebElement loginButton ;



    public ShopLoginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public ShopLoginPage fillEmail() {
        emailField.sendKeys("d1796899@mvrht.net");
        return this;
    }
    public ShopLoginPage fillPassword() {
        passwordField.sendKeys("d1796899@mvrht.net");
        return this;
    }

    public ShopMyAccountPage clickSingIn() {
        loginButton.click();
        return new ShopMyAccountPage(driver);
    }



}
