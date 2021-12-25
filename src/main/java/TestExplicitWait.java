import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestExplicitWait {
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/nataliagordeeva/Documents/chromedriver");
        driver = new ChromeDriver();
        WebDriverWait wait5sec = new WebDriverWait(driver,5);
        driver.get("https://hh.ru/");
        WebElement findInput = driver.findElement(By.xpath("//input[@data-qa='search-input'][1]"));
        WebElement findButton =  driver.findElement(By.xpath("//button[@type='submit']"));
        findInput.sendKeys("qa");
        findButton.submit();
        wait5sec.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-hh-tab-id='searchVacancy']")));

        driver.quit();

    }
}
