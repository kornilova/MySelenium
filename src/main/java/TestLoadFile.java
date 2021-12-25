import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class TestLoadFile {

    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/nataliagordeeva/Documents/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/Users/nataliagordeeva/Documents/geckodriver");
       // driver = new ChromeDriver();
        driver= new FirefoxDriver();
        driver.get("https://images.google.com/?hl=en");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//div[@aria-label='Search by image']/span")).click();

        WebElement uploadTab = driver.findElement(By.xpath("//a[text()='Upload an image']"));
        uploadTab.click();

        driver.findElement(By.xpath("//input[@id='awyMjb' and @type='file']"))
                        .sendKeys("/Users/nataliagordeeva/Documents/gitlocal/MySelenium/ScreenShotsSelenium/07_22_46.png");

        driver.quit();
    }
}
