package TestingTestNgAndJUnit.Pages.ShopPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Matek on 06.06.2017.
 */
public class ShopLoginPage {

    WebDriver driver;

// login i hasło to d1796899@mvrht.net

    By emailField = By.xpath("//*[@id=\"email\"]");
    By passwordField= By.xpath("//*[@id=\"passwd\"]");
    By loginButton= By.xpath("//*[@id=\"SubmitLogin\"]/span");
    By forgotPasswordButton= By.xpath("//*[@id=\"login_form\"]/div/p[1]/a");


    public ShopLoginPage(WebDriver driver) {this.driver=driver;}

    public void fillEmail()
    {
        driver.findElement(emailField).sendKeys("d1796899@mvrht.net");
    }
    public void fillPassword()
    {
        driver.findElement(passwordField).sendKeys("d1796899@mvrht.net");
    }
    public void clickSingIn()
    {
        driver.findElement(loginButton).click();
    }




}
