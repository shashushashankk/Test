package Testing;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class LaunchAmazon {
	@Test
	private void LaunchAmazonApp() throws MalformedURLException, URISyntaxException {
		// TODO Auto-generated method stub
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("appium:platformName", "android");
//		caps.setCapability("deviceName", "RZ8T50D55XW");
		caps.setCapability("appium:newCommandTimeout", 300);
		caps.setCapability("appium:appPackage", "in.amazon.mShop.android.shopping");
		caps.setCapability("appium:appActivity", "com.amazon.mShop.home.HomeActivity");
		caps.setCapability("appium:noReset", true);
		caps.setCapability("appium:autoGrantPermissions", true);

		AndroidDriver driver = new AndroidDriver(new URI("http://0.0.0.0:4723/wd/hub").toURL(), caps);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		System.out.println("Amazon application launched");

	}
}
