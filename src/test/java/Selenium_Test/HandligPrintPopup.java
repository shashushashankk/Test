package Selenium_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

public class HandligPrintPopup {
    public static void main(String[] args) throws AWTException, InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.Test.com");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_P);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(3000);
        Set<String> windows = driver.getWindowHandles();
        System.out.println("Successfullt gt the window handles\n"+windows);
        for(String window: windows){
            driver.switchTo().window(window);
            System.out.println(driver.getTitle());
        }
        WebElement printButton = driver.findElement(By.xpath("//button[.='Print']"));
//        WebElement printButton = driver.findElement(By.xpath("//print-preview-app"));
        printButton.click();
        robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_H);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_H);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyPress(KeyEvent.VK_K);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_P);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }
}
