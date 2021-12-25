import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Action;

import java.util.concurrent.TimeUnit;

public class TestAction {

    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/nataliagordeeva/Documents/chromedriver");
        driver = new ChromeDriver();
        WebDriverWait wait5sec = new WebDriverWait(driver,5);
        driver.get("https://www.ebay.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);

        WebElement link = driver.findElement(By.xpath("//div/ul/li//a[text()='Мода'][1]"));
        WebElement link2 = driver.findElement(By.xpath("//div/ul/li//a[text()='Мода'][1]"));

        actions.moveToElement(link).build().perform(); //навести курсор


        actions.doubleClick(link);
        actions.contextClick(link); //вызов контекстного меню правой кнопкой мыши

       // Action action = actions.clickAndHold(link).moveToElement(link2).release().build();
        //навести курсор на элемент захватить его, перетащить, отпустить кнопку мыши
        //action.perform();

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0, 1000)", "");
        jse.executeScript("window.scrollBy(0, -1000)", "");

        jse.executeScript("var btn=document.createElement('button');" +
                "btn.innerText = 'the long text...';"
                + "document.body.appendChild(btn);");
       // jse.executeScript("alert('Welcome To Selenium Testing');");
        driver.quit();

    }
}
