import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver driver;
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "/Users/nataliagordeeva/Documents/chromedriver");
        driver = new ChromeDriver();
       // driver.get("https://hh.ru/");
        driver.get("https://www.w3schools.com/sql/sql_distinct.asp");
       /* driver.navigate().back();
        driver.navigate().forward();*/
        /*Ожидание*/
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        /*WebElement link =  driver.findElement(By.xpath("//a[@data-qa='mainmenu_expertresume']"));
        link.click();
        driver.navigate().back();
        */
/*
        WebElement findInput = driver.findElement(By.xpath("//input[@data-qa='search-input'][1]"));
        WebElement findButton =  driver.findElement(By.xpath("//button[@type='submit']"));

        findInput.sendKeys("qa");
        System.out.println("Find button text: "+findButton.getText());
        String valuefind = findInput.getAttribute("value");
        System.out.println(valuefind);

        findButton.submit();
        checkAllCheckBoxByType("Тип занятости");*/

/*
        driver.navigate().to("https://vk.com/?lang=en");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        chooseDropDownOption("Day", "11");
        chooseDropDownOption("Month", "2");
        chooseDropDownOption("Year", "2000");
        */

        WebElement tableElement = driver.findElement(By.xpath("//table"));

        Table table = new Table(tableElement, driver);

        System.out.println("Rows number is: " + table.getRows().size());

        System.out.println(table.getValueFromCell(2, 3));
        System.out.println(table.getValueFromCell(4, 1));

        System.out.println(table.getValueFromCell(4, "ContactName"));
        System.out.println(table.getValueFromCell(1, "Address"));
        System.out.println(table.getValueFromCell(2, "Country"));

        driver.quit();
    }

    public static void checkCheckBox(WebElement checkBox)
    {
        if(!checkBox.isSelected()) checkBox.click();
    }

    public static void unCheckCheckBox(String text)
    {
        WebElement checkBox=driver.findElement(By.xpath("//span[text()='"+text+"']/../../span"));
        if(checkBox.isSelected()) checkBox.click();
    }

    public static void chooseDropDownOption(String listName, String option)
    {
        String dropDownListXPath = String.format("//div[@class='JoinForm__birthdate%s']",listName);
        String optionListXPath = String.format("%s/div/table/following-sibling::div//li[@val='%s']", dropDownListXPath, option);
        driver.findElement(By.xpath(dropDownListXPath)).click();
        driver.findElement(By.xpath(optionListXPath)).click();
    }

    public static void checkAllCheckBoxByType(String type)
    {
        String xpath = String.format("//span[text()='%s']/../../following-sibling::div//span[@class='bloko-checkbox__text']", type);
        for (WebElement webElement : driver.findElements(By.xpath(xpath))) {
            checkCheckBox(webElement);
        }

    }
}
