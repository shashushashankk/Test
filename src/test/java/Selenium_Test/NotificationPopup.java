package Selenium_Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class NotificationPopup {
    @Test
    void handleNotificationpopup(){


    }
    @Test
    void multipleTab() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.in");
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.google.com");
        Set<String> windows = driver.getWindowHandles();
        Iterator allWindows=windows.iterator();
        while(allWindows.hasNext()){
            String window = (String)allWindows.next();
            System.out.println(window);
            driver.switchTo().window(window);
            Thread.sleep(Duration.ofSeconds(2));
            driver.close();
        }
    }
}
