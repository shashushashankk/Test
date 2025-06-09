package Selenium_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class FileUploadAndDownload {
    public static void main(String[] args) throws IOException, AWTException, InterruptedException {
//        ProcessBuilder processBuilder = new ProcessBuilder();
//        processBuilder.command("notepad");
//        processBuilder.start();

    }

    public static void fileUpload() throws AWTException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.naukri.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.id("login_Layer")).click();
        driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username ']")).sendKeys("hemavijayamadhavi220@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Vijaya30@");
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        driver.findElement(By.xpath("//div[text()='UPDATE PROFILE ']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e.getLocalizedMessage());
        }

        File f = new File("./data/Resume.docx");
        String abspath = f.getAbsolutePath();
        driver.findElement(By.xpath("(//input[@class='fileUpload waves - effect waves - light btn - large '])[1]")).sendKeys(abspath);
    }

}
