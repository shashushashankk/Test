package Selenium_Test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public class ActionsTest extends BaseClass{
    @Test
    void mouseOver() throws IOException {
        driver.get("https://www.vtiger.com/");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        TakesScreenshot sc = (TakesScreenshot) driver;
        WebElement resourcesLink = driver.findElement(By.xpath("//a[normalize-space(text())='Company']"));
        Actions actions = new Actions(driver);
//        actions.contextClick(resourcesLink);
        actions.moveToElement(resourcesLink).build().perform();
        WebElement contactUsLink = driver.findElement(By.xpath("//a[normalize-space(text())='Contact Us']"));
        actions.click(contactUsLink).build().perform();
        WebElement bengaluruIndiaPhoneNumberText = driver.findElement(By.xpath("//p[normalize-space(text())='Bengaluru, India']/following-sibling::p"));
        actions.scrollToElement(bengaluruIndiaPhoneNumberText).build().perform();
        jse.executeScript("arguments[0].scrollIntoView(true)",bengaluruIndiaPhoneNumberText);
        File temp = sc.getScreenshotAs(OutputType.FILE);
        File dest = new File("./src/screenshot.png");
//        Files.copy(temp.toPath(),dest.toPath());
        FileUtils.copyFile(temp,dest);
        System.out.println(dest.getAbsolutePath());
        String phoneNumber = bengaluruIndiaPhoneNumberText.getDomProperty("textContent");
        phoneNumber = phoneNumber.trim();
        System.out.println(phoneNumber);
    }
}
