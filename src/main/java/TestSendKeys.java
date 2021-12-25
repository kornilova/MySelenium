import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestSendKeys {
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/nataliagordeeva/Documents/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://hh.ru/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        WebElement searchInput = driver.findElement(By.xpath("//form/div/div/div/input[@data-qa='search-input' and @type='text' and @name='text']"));
        String select = Keys.chord(Keys.CONTROL, "a"); //зажатие клавиш
        String cut = Keys.chord(Keys.CONTROL, "x");
        String paste = Keys.chord(Keys.CONTROL, "v");

        searchInput.sendKeys("test text");
        searchInput.sendKeys(select);
        searchInput.sendKeys(cut);
        searchInput.sendKeys(paste);
        searchInput.sendKeys(Keys.ENTER);

        driver.quit();
    }
}
