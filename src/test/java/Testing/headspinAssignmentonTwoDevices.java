package Testing;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class headspinAssignmentonTwoDevices {
    private AndroidDriver driverAmazon, driverFlipkart;

    public Integer amazonPrice;
    public Integer flipkartPrice;
    public Integer amazonDeliveryTime;
    public Integer flipkartDeliveryTime;
    public String searchProduct = "iPhone 16 Black 256 GB";
    public Integer Pincode = 831003;

    public String amazonPricetext;

    @BeforeClass
    public void setup() throws Exception {
        // Set up desired capabilities for both devices (Device 1: Amazon, Device 2: Flipkart)

        // Set up Amazon Device (Device 1)
        DesiredCapabilities capsAmazon = new DesiredCapabilities();
        capsAmazon.setCapability("appium:platformName", "android");
        capsAmazon.setCapability("appium:udid", "emulator-5554");  // Change device ID for Device 1
        capsAmazon.setCapability("appium:newCommandTimeout", 300);
        capsAmazon.setCapability("appium:noReset", true);
        capsAmazon.setCapability("appium:autoGrantPermissions", true);
        capsAmazon.setCapability("appium:appPackage", "com.amazon.mShop.android.shopping");
        capsAmazon.setCapability("appium:appActivity", "com.amazon.mShop.home.HomeActivity");

        driverAmazon = new AndroidDriver(new URI("http://localhost:4723/wd/hub").toURL(), capsAmazon);
        driverAmazon.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       

        // Set up Flipkart Device (Device 2)
        DesiredCapabilities capsFlipkart = new DesiredCapabilities();
        capsFlipkart.setCapability("appium:platformName", "android");
        capsFlipkart.setCapability("appium:udid", "RZCTA152EMN");  // Change device ID for Device 2
        capsFlipkart.setCapability("appium:newCommandTimeout", 300);
        capsFlipkart.setCapability("appium:noReset", true);
        capsFlipkart.setCapability("appium:autoGrantPermissions", true);
        capsFlipkart.setCapability("appium:appPackage", "com.flipkart.android");
        capsFlipkart.setCapability("appium:appActivity", "com.flipkart.android.SplashActivity");

        driverFlipkart = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capsFlipkart);
        driverFlipkart.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        System.out.println("Both Amazon and Flipkart applications launched on separate devices.");
    }

    @Test
    public void testAmazonFlipkartComparison() throws InterruptedException, MalformedURLException {
        // Run the Amazon part in parallel with Flipkart
        Thread amazonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    searchProductInAmazon();
                    getProductDetailsInAmazon();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread flipkartThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    searchProductInFlipkart();
                    getProductDetailsInFlipkart();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start both threads to run simultaneously
        amazonThread.start();
        flipkartThread.start();

        // Wait for both threads to finish
        amazonThread.join();
        flipkartThread.join();

        // Now compare the extracted data
        compareAndDecide();
    }

    public void searchProductInAmazon() throws InterruptedException {
		// Code to search for iPhone 16 Black 256GB in Amazon app and to select midnight color 
		
		
		
		
    	driverAmazon.findElement(By.xpath("//android.widget.ImageView[@resource-id=\"in.amazon.mShop.android.shopping:id/chrome_action_bar_search_icon\"]")).click();
		WebElement searchBoxAmazon =driverAmazon.findElement(By.xpath("//android.widget.EditText[@text=\"Search Amazon.in\"]"));
		searchBoxAmazon.sendKeys(searchProduct);
		
		
		driverAmazon.findElement(By.xpath("//android.widget.Button[@text='iphone 16 black 256gb']")).click();
		
		
		Thread.sleep(5000);
		TouchAction action=new TouchAction(driverAmazon);
		action.press(PointOption.point(500,900))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(500,500))
		.release()
		.perform();
	
		
		
		driverAmazon.findElement(By.xpath("//android.widget.TextView[contains(@text,\"iPhone 16 256 GB\")]")).click();
		
		
		
		amazonPricetext =driverAmazon.findElement(By.xpath("//android.widget.TextView[contains(@text,'₹')]")).getText();
		System.out.println(amazonPricetext);
		Thread.sleep(3000);

		
		action.press(PointOption.point(500,1500))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(500,500))
		.release()
		.perform();
		
		Thread.sleep(2000);
		WebElement Black=driverAmazon.findElement(By.xpath("//android.widget.RadioButton[@text=\"Black\"]"));

		Black.click();
		
		Thread.sleep(2000);
		
		
		
//		driver.findElement(By.xpath("//android.widget.Button[@text='256 GB']")).click();
		Thread.sleep(2000);
		
		
}

    public void getProductDetailsInAmazon() throws InterruptedException {
    	
    	Thread.sleep(3000);
    	TouchAction action1=new TouchAction(driverAmazon);
    	
    	action1.press(PointOption.point(500,1400))
    	.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
    	.moveTo(PointOption.point(500,500))
    	.release()
    	.perform();
    	
    	Thread.sleep(2000);
    	action1.press(PointOption.point(500,1700))
    	.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
    	.moveTo(PointOption.point(500,500))
    	.release()
    	.perform();
    	
    	
    		// Code to get the  delivery time for Amazon
    		Thread.sleep(5000);
    		
    		
    		
    		//WebElement amazonproductprice=driver.findElement(By.xpath("//android.widget.TextView[@text='₹']//following-sibling::android.widget.TextView"));
    		
    		 
    		
       		String price="";

       		for(int i=0;i<amazonPricetext.length();i++)
       		{
       			if(amazonPricetext.charAt(i)=='.')
       			{
       				break;
       			}
       			else if(amazonPricetext.charAt(i)>='0' && amazonPricetext.charAt(i)<='9')
       			{
       				price=price+amazonPricetext.charAt(i);
       						
       			}
       		}
       		amazonPrice=Integer.parseInt(price);
       		//amazonprice variable consists price of the product in amazon
       		System.out.println(searchProduct+" Price in amazon - "+amazonPrice);
    		
       		Thread.sleep(2000);
    		
    		
    		//String amazonDeliveryTimeText = driver.findElement(By.xpath("(//android.widget.TextView[contains(@text,\"delivery\")]/../android.widget.TextView)[3]")).getText();
    		
       		String amazonDeliveryTimeText = driverAmazon.findElement(By.xpath("(//android.widget.TextView[contains(@text,\"delivery\")]/../..//android.widget.TextView)[3]")).getText();
       		
    		System.out.println(amazonDeliveryTimeText);
    		
    		if(amazonDeliveryTimeText.contains("Tomorrow"))
    		{
    			amazonDeliveryTime=1;
    		}
    		
    		else if(amazonDeliveryTimeText.contains("Today")){
    			amazonDeliveryTime=(int)amazonDeliveryTime;
    			amazonDeliveryTime=0;
    		}
    		
    		else {
    		
    		String []str=amazonDeliveryTimeText.split(",");
    		amazonDeliveryTimeText=str[1];
    		amazonDeliveryTimeText=amazonDeliveryTimeText.trim();
    		System.out.println(amazonDeliveryTimeText);
    				
    		 try {
    	            // Date string to be parsed
    	            String dateString =amazonDeliveryTimeText ;

    	            // Print the date string to debug
    	            //System.out.println("Date string to be parsed: " + dateString);

    	            // Parse the date string to TemporalAccessor
    	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM", Locale.ENGLISH);
    	            TemporalAccessor temporalAccessor = formatter.parse(dateString);

    	            // Construct the LocalDate with the current year
    	            LocalDate parsedDate = LocalDate.of(LocalDate.now().getYear(),
    	                                                temporalAccessor.get(java.time.temporal.ChronoField.MONTH_OF_YEAR),
    	                                                temporalAccessor.get(java.time.temporal.ChronoField.DAY_OF_MONTH));

    	            // Print the parsed date to debug
    	            System.out.println("Parsed date: " + parsedDate);

    	            // Get the current date
    	            LocalDate currentDate = LocalDate.now();

    	            // Print the current date to debug
    	            System.out.println("Current date: " + currentDate);

    	            // Check if the parsed date is before the current date, adjust the year if necessary
    	            if (parsedDate.isBefore(currentDate)) {
    	                parsedDate = parsedDate.plusYears(1);
    	            }

    	            // Calculate the difference in days
    	            long daysBetween = ChronoUnit.DAYS.between(currentDate, parsedDate);

    	            // Print the result
    	            System.out.println("Days between " + currentDate + " and " + parsedDate + ": " + daysBetween);

    	            // Assign to amazonDeliveryTime
    	           amazonDeliveryTime = (int) daysBetween;
    	            System.out.println("Amazon delivery time in days: " + amazonDeliveryTime);
    	        } catch (Exception e) {
    	            System.out.println("An error occurred: " + e.getMessage());
    	            e.printStackTrace();
    	        }
    		
    		
    		
    		}
    		
    		System.out.println("In amazon Product can be delivered in "+amazonDeliveryTime+" day");
    		
    		
    		Thread.sleep(4000);
    		
    		
    }

    public void searchProductInFlipkart() throws InterruptedException {
		// Code to search for iPhone 14 Black 256 GB in Flipkart app
	  driverFlipkart.findElement(By.xpath("//android.widget.TextView[@text=\"Categories\"]")).click();
      Thread.sleep(2000);
      Thread.sleep(2000);
      driverFlipkart.findElement(By.xpath("//android.widget.ImageView[@resource-id=\"com.flipkart.android:id/search_icon\"]")).click();
      Thread.sleep(2000);
      WebElement searchBoxFlipkart = driverFlipkart.findElement(By.xpath("//android.widget.EditText[@text=\"Search for products\"]"));
      searchBoxFlipkart.sendKeys(searchProduct);
      driverFlipkart.findElement(By.xpath("//android.widget.TextView[contains(@text,\"iphone 16\")]")).click();
      
      Thread.sleep(2000);
      driverFlipkart.findElement(By.xpath("//android.widget.TextView[contains(@text,'Apple iPhone 16 ')]")).click();
    
      Thread.sleep(3000);
   
      driverFlipkart.findElement(By.xpath("//android.widget.TextView[contains(@text,'Color:')]")).click();
    
      Thread.sleep(2000);
      driverFlipkart.findElement(By.xpath("//android.widget.TextView[@text='Black']")).click();
      

      Thread.sleep(2000);
      driverFlipkart.findElement(By.xpath("//android.widget.TextView[@text='256 GB']")).click();
     
      
      	TouchAction action1=new TouchAction(driverFlipkart);
//	    Thread.sleep(2000);
//		action1.press(PointOption.point(500,800))
//		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
//		.moveTo(PointOption.point(500,500))
//		.release()
//		.perform();
      
      Thread.sleep(3000);
      WebElement flipkartproductprice=driverFlipkart.findElement(By.xpath(" //android.widget.TextView[contains(@text,'₹')]"));
     String productprice= flipkartproductprice.getText();
   //Fetching price of the product
     		flipkartPrice=0;
     		String price="";

     		for(int i=0;i<productprice.length();i++)
     		{
     			if(productprice.charAt(i)>='0' && productprice.charAt(i)<='9')
     			{
     				price=price+productprice.charAt(i);
     						
     			}
     		}
     		flipkartPrice=Integer.parseInt(price);
     		//amazonprice variable consists price of the product in amazon
     		System.out.println(searchProduct+" Product price in flipkart is - "+ flipkartPrice);
     		
     		 Thread.sleep(2000);
     		driverFlipkart.findElement(By.xpath(" //android.widget.TextView[@text='Apply']")).click();
     		
     		Thread.sleep(4000);
     		
     		action1.press(PointOption.point(400,1400))
  		  .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
  		  .moveTo(PointOption.point(500,500))
  		  .release()
  		  .perform();
     		
     		
     	Thread.sleep(3000);
     	action1.press(PointOption.point(400,600))
		  .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		  .moveTo(PointOption.point(500,500))
		  .release()
		  .perform();
		
     	Thread.sleep(2000);
}

    public void getProductDetailsInFlipkart() throws InterruptedException {
    	
    	
		// Code to get the delivery time for Flipkart
	
		Thread.sleep(3000);
	
		 boolean outofstock=false;
	
		
		 try {
			  outofstock=driverFlipkart.findElement(By.xpath("//android.widget.TextView[@text='Currently out of stock for ']")).isDisplayed();
		} catch (Exception e) {
			
		}
		
		
		if(outofstock)
		{
			flipkartDeliveryTime=Integer.MAX_VALUE;
			Thread.sleep(3000);
			System.out.println("Product can not be delivered to the selected pincode in flipkart");
		}
		else
		{
			String flipkartDeliveryTimeText =driverFlipkart.findElement(By.xpath("(//android.widget.TextView[contains(@text,'Delivery by')]//following-sibling::android.widget.TextView)[1]")).getText();
			 //Fetching Delivery Time in flipkart
			System.out.println(flipkartDeliveryTimeText);
		
			if(flipkartDeliveryTimeText.contains("Tomorrow"))
			{
				flipkartDeliveryTime=1;
			}
			else if(flipkartDeliveryTimeText.contains("Today"))
			{
				
				flipkartDeliveryTime=(int)flipkartDeliveryTime;
				flipkartDeliveryTime=0;
			}
			else
			{
					
					String str[]=flipkartDeliveryTimeText.split(",");
					flipkartDeliveryTimeText=str[0];
					flipkartDeliveryTimeText=flipkartDeliveryTimeText.trim();
		     		

		     		
		     		
		     		
		     		 try {
		 	            // Date string to be parsed
		 	            String dateString =flipkartDeliveryTimeText ;

		 	            // Print the date string to debug
		 	            System.out.println("Date string to be parsed: " + dateString);

		 	            // Parse the date string to TemporalAccessor
		 	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM", Locale.ENGLISH);
		 	            TemporalAccessor temporalAccessor = formatter.parse(dateString);

		 	            // Construct the LocalDate with the current year
		 	            LocalDate parsedDate = LocalDate.of(LocalDate.now().getYear(),
		 	                                                temporalAccessor.get(java.time.temporal.ChronoField.MONTH_OF_YEAR),
		 	                                                temporalAccessor.get(java.time.temporal.ChronoField.DAY_OF_MONTH));

		 	            // Print the parsed date to debug
		 	            System.out.println("Parsed date: " + parsedDate);

		 	            // Get the current date
		 	            LocalDate currentDate = LocalDate.now();

		 	            // Print the current date to debug
		 	            System.out.println("Current date: " + currentDate);

		 	            // Check if the parsed date is before the current date, adjust the year if necessary
		 	            if (parsedDate.isBefore(currentDate)) {
		 	                parsedDate = parsedDate.plusYears(1);
		 	            }

		 	            // Calculate the difference in days
		 	            long daysBetween = ChronoUnit.DAYS.between(currentDate, parsedDate);

		 	            // Print the result
		 	            System.out.println("Days between " + currentDate + " and " + parsedDate + ": " + daysBetween);

		 	            // Assign to amazonDeliveryTime
		 	           flipkartDeliveryTime = (int) daysBetween;
		 	            System.out.println("Flipkart delivery time in days: " + flipkartDeliveryTime );
		 	        } catch (Exception e) {
		 	            System.out.println("An error occurred: " + e.getMessage());
		 	            e.printStackTrace();
		 	        }
		     		
		     	
		     		 
		     		
			}
			
			Thread.sleep(2000);
			System.out.println(searchProduct+" delivery time in flipkart is - "+ flipkartDeliveryTime+" days");
		}
		
}

    public void compareAndDecide() throws MalformedURLException, InterruptedException {

    	flipkartPrice=(int)flipkartPrice;
    	amazonPrice=(int)amazonPrice;
    	flipkartDeliveryTime=(int)flipkartDeliveryTime;
    	amazonDeliveryTime=(int)amazonDeliveryTime;
    	
    		if (flipkartPrice > amazonPrice && flipkartDeliveryTime>amazonDeliveryTime) {
    			System.out.println("Amazon price is lower and can deliver early");
    			// Launch Amazon app again
    			
    		} else if (amazonPrice >flipkartPrice && amazonDeliveryTime>flipkartDeliveryTime) {
    			System.out.println("Flipkart price is lower and can deliver early");
    			System.out.println("Launching Flipkart application");
    			// Launch Flipkart app again
    			
    			
    		} else if (amazonPrice ==flipkartPrice && amazonDeliveryTime==flipkartDeliveryTime) {
    				System.out.println("Go for any app of your choice");
    		} else if (flipkartPrice < amazonPrice && amazonDeliveryTime<flipkartDeliveryTime) {
    				System.out.println("Amazon will deliver faster and price is higher in amazon");
    				System.out.println("Launching amazon application");
    				// Launch Amazon app again
    				
    		} else if (amazonPrice >flipkartPrice && flipkartDeliveryTime<amazonDeliveryTime) {
    				System.out.println("Flipkart will deliver faster");
    				// Launch Flipkart app again
    				
    		}
    }

    @AfterClass
    public void teardown() {
        if (driverAmazon != null) {
            driverAmazon.quit();
        }
        if (driverFlipkart != null) {
            driverFlipkart.quit();
        }
    }
}