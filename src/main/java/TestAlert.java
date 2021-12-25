import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestAlert {

    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/nataliagordeeva/Documents/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        JavascriptExecutor jse = (JavascriptExecutor)driver;
       // jse.executeScript("alert(\"Hello! I am an alert box!!\");");
        jse.executeScript("confirm(\"Hello! I am an alert box!!\");");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().dismiss();

        driver.quit();
    }
}
