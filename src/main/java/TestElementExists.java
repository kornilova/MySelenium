import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestElementExists {

    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/nataliagordeeva/Documents/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://hh.ru/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        if(driver.findElements(By.xpath("//button[@data-qa='search-button' and @type='submit1']")).size()>0)
            System.out.println("Button exists");
        else System.out.println("Button not exists");

        driver.quit();
    }
}
