package Selenium_Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class ProductNameWithPrice {
    @Test
    void flipkartProductDetails() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.flipkart.com");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(10000));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Set<String> logTypes = driver.manage().logs().getAvailableLogTypes();
        System.out.println(logTypes);
        WebElement searchTextfield = driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
        searchTextfield.sendKeys(Keys.chord("iPhone 15", Keys.ENTER));
        List<WebElement> productNames = driver.findElements(By.xpath("//span[contains(text(),'results for')]/../../../following-sibling::div//a[@rel='noopener noreferrer']//div[contains(@class,'col col-7-12')]/div[1]"));
        List<WebElement> productPrices = driver.findElements(By.xpath("//span[contains(text(),'results for')]/../../../following-sibling::div//a[@rel='noopener noreferrer']//div[contains(@class,'col col-5-12')]/div[1]//div[contains(text(),'₹')][1]"));
        Map<String, String> map = new LinkedHashMap<>();
        for (int i = 1; i < productNames.size(); i++) {
            String productName = productNames.get(i).getDomProperty("textContent");
            String productPrice = productPrices.get(i).getDomProperty("textContent").replaceAll("[^0-9.]", "");
//            System.out.println("Product name is "+productName +" and Product price is "+productPrice);
            map.put(productName, productPrice);
        }
        System.out.println("completed");
//        System.out.println(map);
        Map<String,String> treeMap = new TreeMap<>(map);
        Set<String> keys = treeMap.keySet();
        for (String key : keys) {
            System.out.println(key + " = " + map.get(key));
        }
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("prompt(\"Shashank\")");
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        System.out.println("Alert text is "+text);
        alert.sendKeys("Suppi");
        alert.accept();
//        driver.quit();
    }
}
