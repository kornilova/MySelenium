import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestWindow {

    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/nataliagordeeva/Documents/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://hh.ru/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/div/div/div/button")).click();


        String mainTab = driver.getWindowHandle();

        driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div[1]/div/div[2]/div[1]/button")).click();
        driver.findElement(By.xpath("/html/body/div[7]/div/div[2]/div/div[1]/a[1]")).click();

        for (String tab : driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }
        driver.switchTo().window(mainTab);
        driver.quit();
    }
}
