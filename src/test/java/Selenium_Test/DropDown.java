package Selenium_Test;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DropDown {
    @Test
    void singleLevelDropdown(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("file:///C:/Users/ER/Desktop/Java%20Script/Dropdown.html");
        WebElement dropdpwn = driver.findElement(By.id("country"));
        Select select = new Select(dropdpwn);
        select.selectByIndex(4);
        sleep(2);
        select.selectByValue("israel");
//        sleep(2);
        select.selectByVisibleText("USA");
        sleep(2);
        select.selectByContainsVisibleText("Shri");
        sleep(2);
        List<WebElement> options = select.getOptions();
        for(WebElement option : options){
            String value = option.getDomAttribute("value");
            System.out.println(value);
        }
        if(select.isMultiple()){
            System.out.println("The dropdown is multi selector");
        } else {
            System.out.println("The dropdown is single selector");
        }
        WebElement firstSelect = select.getFirstSelectedOption();
        String firstSelectText = firstSelect.getDomAttribute("value");
        System.out.println("First Selected text is "+firstSelectText);

        List<WebElement> allseleOpt = select.getAllSelectedOptions();
        for(WebElement opt : allseleOpt){
            System.out.println("All sel options are "+opt.getDomAttribute("value"));
        }
        driver.quit();
    }
    void sleep(long seconds){
        try{
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e){
            e.printStackTrace();
            System.out.println(e.getLocalizedMessage());
        }
    }
}
