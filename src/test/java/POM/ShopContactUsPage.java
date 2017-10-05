package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Matek on 06.06.2017.
 */
public class ShopContactUsPage {

    WebDriver driver;
    @FindBy(xpath="//*[@id='id_contact']")
    WebElement subjectChoice ;

    @FindBy(xpath="//*[@id='email']")
    WebElement emailContactField ;

    @FindBy(xpath="//*[@id='id_order']")
    WebElement orderReferencesField ;

    @FindBy(xpath="//*[@id='message']")
    WebElement messageField ;

    @FindBy(xpath="//*[@id='submitMessage']/span")
    WebElement sendCounactUsButton ;



    public ShopContactUsPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public ShopContactUsPage chooseSubject() {
        Select dropdown = new Select(subjectChoice);
        dropdown.selectByVisibleText("Customer service");
        return this;
    }

    public ShopContactUsPage fillEmailContactUsField() {
        emailContactField.sendKeys("testemail@gmail.com");
        return this;
    }

    public ShopContactUsPage fillOrderContactUsField() {
        orderReferencesField.sendKeys("blablabla");
        return this;
    }

    public ShopContactUsPage fillMessageField() {
        messageField.sendKeys("TEST MESSAGE");
        return this;
    }

    public ShopContactUsPage clickSendMessageButton() {
        sendCounactUsButton.click();
        return this;
    }


}
