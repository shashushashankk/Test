package Testing;

import Selenium_Test.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class clickAndDrag extends BaseClass {
//    @Test
    void clickAndHoldDrag() throws InterruptedException {

        driver.get("https://demoqa.com/resizable");
        WebElement textBox = driver.findElement(By.xpath("//div[@class='box react-resizable']"));
        Rectangle rect = textBox.getRect();
        JavascriptExecutor jse= (JavascriptExecutor)driver;
        jse.executeAsyncScript("arguments[0].scrollIntoView(true)",textBox);
        int x = rect.width;
        int y = rect.height;
        System.out.println(rect.x + " " + rect.y + " " + rect.width + " " + rect.height);
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.moveToElement(textBox, x, y).build().perform();
        actions.clickAndHold().build().perform();
        actions.moveByOffset(100, 100).build().perform();
        actions.release().build().perform();
    }
    @Test
    void dragAndDrop() throws InterruptedException {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/droppable");
        WebElement dragMeButton = driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
        WebElement dropHereButton = driver.findElement(By.xpath("//div[@id=\"droppable\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dragMeButton).build().perform();
        actions.clickAndHold().build().perform();
        actions.moveToElement(dropHereButton).build().perform();
        Thread.sleep(2000);
        actions.release().build().perform();

    }
}
