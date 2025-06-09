package Selenium_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class MakeMyTrip {
    @Test
    void getAllFlightandDepartureTime() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String fromCity = "BLR";
        String destCity = "GOI";
        String date = "20 December 2025".toLowerCase();
        String day = date.split(" ")[0];
        WebElement closeIcon = driver.findElement(By.xpath("//span[@class='commonModal__close']"));
        closeIcon.click();
        WebElement fromCityDiv = driver.findElement(By.id("fromCity"));
        fromCityDiv.click();
        WebElement fromCityTextfield = driver.findElement(By.xpath("//input[@placeholder='From']"));
        fromCityTextfield.sendKeys(fromCity);
        WebElement suggettionBox = driver.findElement(By.xpath("//ul[contains(@class,'suggestions-list')]/li//div[text()='" + fromCity + "']"));
        suggettionBox.click();
        WebElement toCityDiv = driver.findElement(By.id("toCity"));
        toCityDiv.click();
        WebElement toCityTextfield = driver.findElement(By.xpath("//input[@placeholder='To']"));
        toCityTextfield.sendKeys(destCity);
        suggettionBox = driver.findElement(By.xpath("//ul[contains(@class,'suggestions-list')]/li//div[text()='" + destCity + "']"));
        suggettionBox.click();
        boolean isSelected = false;
        while (!isSelected) {
            WebElement monthHeader = driver.findElement(By.xpath("//div[@class='DayPicker-Caption' and @role='heading']/div"));
            String monthname = monthHeader.getDomProperty("textContent");
            if (date.contains(monthname.toLowerCase())) {
                driver.findElement(By.xpath("//div[@class='dateInnerCell']/p[text()='"+day+"']")).click();
                isSelected=true;
            } else {
                WebElement nextArrowIcon = driver.findElement(By.xpath("//span[contains(@class,'DayPicker-NavButton--next')]"));
                nextArrowIcon.click();
            }
        }
        WebElement searchbutton = driver.findElement(By.xpath("//a[text()='Search']"));
        wait.until(ExpectedConditions.elementToBeClickable(searchbutton));
        searchbutton.click();

    }
}
