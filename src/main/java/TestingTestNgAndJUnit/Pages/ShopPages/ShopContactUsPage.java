package TestingTestNgAndJUnit.Pages.ShopPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Matek on 06.06.2017.
 */
public class ShopContactUsPage {

    WebDriver driver;

    By subjectChoice = By.xpath("//*[@id=\"id_contact\"]");
    By emailContactField= By.xpath("//*[@id=\"email\"]");
    By orderReferencesField= By.xpath("//*[@id=\"id_order\"]");
    //By attachFileButton= By.xpath("");
    By messageField= By.xpath("//*[@id=\"message\"]");
    By sendCounactUsButton = By.xpath("//*[@id=\"submitMessage\"]/span");


    public ShopContactUsPage(WebDriver driver) {this.driver=driver;}

    public void chooseSubject()
    {
        //driver.findElement(subjectChoice);
        Select dropdown = new Select(driver.findElement(subjectChoice));
        dropdown.selectByVisibleText("Customer service");

    }

    public void fillEmailContactUsField()
    {
        driver.findElement(emailContactField).sendKeys("testemail@gmail.com");
    }
    public void fillOrderContactUsField()
    {
        driver.findElement(orderReferencesField).sendKeys("blablabla");
    }
    public void fillMessageField()
    {
        driver.findElement(messageField).sendKeys("TEST MESSAGE");
    }
    public void clickSendMessageButton()
    {
        driver.findElement(sendCounactUsButton).click();
    }



}
