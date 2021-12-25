import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestEnabled {

    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/nataliagordeeva/Documents/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://hh.ru/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebElement findInput = driver.findElement(By.xpath("//input[@data-qa='search-input'][1]"));
        WebElement findButton =  driver.findElement(By.xpath("//button[@type='submit']"));

        findInput.sendKeys("qa");
        findButton.submit();

        WebElement rdBt1 = driver.findElement(By.xpath("//span[@data-qa='serp__novafilter-title' and text()='Не имеет значения']"));
        if(!rdBt1.isSelected()) rdBt1.click();
        WebElement rdBt2 = driver.findElement(By.xpath("//span[@data-qa='serp__novafilter-title' and text()='Нет опыта']"));
        if(!rdBt2.isSelected()) rdBt2.click();

        driver.quit();

    }
}
