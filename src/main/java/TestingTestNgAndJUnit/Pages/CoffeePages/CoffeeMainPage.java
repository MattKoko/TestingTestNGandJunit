package TestingTestNgAndJUnit.Pages.CoffeePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Matek on 02.05.2017.
 */
public class CoffeeMainPage {

    WebDriver driver;

    By numberOfCups = By.xpath("/html/body/form[1]/p/input");
    By extraArea = By.xpath("/html/body/form[1]/div");
    By coffeeAmount = By.xpath("/html/body/form[1]/p/input");



    public CoffeeMainPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //A. czy jak jest 0 cups of coffee to nie ma tych dodatkowych pół do liczenia
    public int getCountFieldSizeNotHidden()
    {
        List<WebElement> warningTextElement = driver.findElements(By.xpath("/html/body/form[1]/div[not(@style='display: none;')]/p[1]/input"));
        return warningTextElement.size();
    }

    //B jak wpisze 1 to sie pojawiają dodatkowe pola

    public void fillCoffeeWindow()
    {
        //driver.findElement(coffeeAmount).sendKeys(Keys.DELETE);   -useless
        driver.findElement(coffeeAmount).sendKeys("1");
    }

    public int checkWhatPopOut()
    {
        List<WebElement> warningTextElement = driver.findElements(By.xpath("/html/body/form[1]/div[@style='display: none;']/p[1]/input"));
        return warningTextElement.size();
    }

    //C. czy działa dodawanie liczby cups of coffee myszką klikanie na +-
        //IDK


    //E. czy jak przekroczę 400mg of caffeine to wyswietla się warning
    public void fillCoffeeWindowWarning()
    {
        //driver.findElement(coffeeAmount).sendKeys(Keys.DELETE);   -useless
        driver.findElement(coffeeAmount).sendKeys("100");
    }

    public  int checkWarning()
    {
        List<WebElement> warningTextElement = driver.findElements(By.xpath("/html/body/form[1]/div[@style='display: none;']/p[3]"));
        return warningTextElement.size(); //

    }

    //F. zaprojektuj jakis test z przecinkiem cups of coffee 1,5 np, i sprawdz czy dobrze liczy kofeine


}
