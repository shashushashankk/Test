package Testing;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Gourav_Test {
	public static void main(String[] args) throws InterruptedException, AWTException {
		for (int i = 0; i < 1; i++) {
			System.out.println("Execution number: " + i);
			main();
		}
	}

	public static void main() throws InterruptedException, AWTException {
		System.out.println("Hello, World!");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		driver.get("https://www.embark.org/?ref=madewithvuejs.com");

		WebElement registerBtn = driver.findElement(By.xpath("//div[@class='menu-item']/a[text()='Register']"));
		registerBtn.click();
		String userName = generateRandonString(5);
		WebElement firstName = driver
				.findElement(By.xpath("//div[@class='form-group']/label[text()='Name']/following-sibling::input"));
		firstName.sendKeys(userName);
		WebElement userNameTextfield = driver
				.findElement(By.xpath("//div[@class='form-group']/label[text()='Username']/following-sibling::input"));
		userNameTextfield.sendKeys(userName);
		WebElement email = driver
				.findElement(By.xpath("//div[@class='form-group']/label[text()='E-mail']/following-sibling::input"));
		email.sendKeys(userName + "125@yopmail.com");
		WebElement password = driver
				.findElement(By.xpath("//div[@class='form-group']/label[text()='Password']/following-sibling::input"));
		password.sendKeys(userName + "@123456");
		WebElement confirmPassword = driver.findElement(
				By.xpath("//div[@class='form-group']/label[text()='Password confirmation']/following-sibling::input"));
		confirmPassword.sendKeys(userName + "@123456");
		WebElement location = driver
				.findElement(By.xpath("//div[@class='form-group']/label[text()='Location']/following-sibling::input"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		location.click();
		location.sendKeys("In");
		Thread.sleep(1000);
//		confirmPassword.click();
//		location.click();	
		WebElement locationDropdown = driver.findElement(By.xpath(
				"//div[contains(@class,'pac-container')]/div/span[@class='pac-item-query']/following-sibling::span"));
		js.executeScript("arguments[0].scrollIntoView(true);", locationDropdown);
		try {
			driver.findElement(By.xpath(
					"//div[contains(@class,'pac-container')]/div/span[@class='pac-item-query']/following-sibling::span"))
					.click();
		} catch (ElementNotInteractableException e) {
			try {
				confirmPassword.click();
				location.click();
				driver.findElement(By.xpath(
						"//div[contains(@class,'pac-container')]/div/span[@class='pac-item-query']/following-sibling::span"))
						.click();
			} catch (StaleElementReferenceException e1) {
				driver.findElement(By.xpath(
						"//div[contains(@class,'pac-container')]/div/span[@class='pac-item-query']/following-sibling::span"))
						.click();
			}
		} catch (StaleElementReferenceException e) {
			driver.findElement(By.xpath(
					"//div[contains(@class,'pac-container')]/div/span[@class='pac-item-query']/following-sibling::span"))
					.click();
		}

		WebElement tnc = driver.findElement(By.xpath("//input[@id='terms_and_conditions']"));
		js.executeScript("arguments[0].scrollIntoView(true);", tnc);
		js.executeScript("arguments[0].click();", tnc);
		System.out.println(tnc);
		Thread.sleep(2000);
		WebElement submitRegistration = driver.findElement(By.xpath("//button[text()='Register']"));
		submitRegistration.click();
		WebElement hostLink = driver.findElement(By.xpath("//a[text()='Host an Adventure']"));
		wait.until(ExpectedConditions.elementToBeClickable(hostLink));
		hostLink.click();
		WebElement categoryDropdown = driver.findElement(
				By.xpath("//label[text()='Category']/following-sibling::div//div[@class='multiselect__select']"));
		categoryDropdown.click();
		List<WebElement> categoriesOptions = driver
				.findElements(By.xpath("//label[text()='Category']/following-sibling::div//ul/li/span/span"));
		for (WebElement coption : categoriesOptions) {
			js.executeScript("arguments[0].click()", coption);
			break;
		}
		WebElement difficultyDropdown = driver.findElement(
				By.xpath("//label[text()='Difficulty']/following-sibling::div//div[@class='multiselect__select']"));
		difficultyDropdown.click();
		List<WebElement> difficultiesOptions = driver
				.findElements(By.xpath("//label[text()='Difficulty']/following-sibling::div//ul/li/span/span"));
		for (WebElement doption : difficultiesOptions) {
			js.executeScript("arguments[0].click()", doption);
			break;
		}

		WebElement groupSizeMin = driver.findElement(
				By.xpath("//label[text()='Group Size']/following-sibling::div//input[@placeholder='Min']"));
		groupSizeMin.sendKeys("5");
		WebElement groupSizeMax = driver.findElement(
				By.xpath("//label[text()='Group Size']/following-sibling::div//input[@placeholder='Max']"));
		groupSizeMax.sendKeys("10");
		WebElement nextButton = driver.findElement(By.xpath("//button[text()='Next']"));
		js.executeScript("arguments[0].scrollIntoView(false)", nextButton);
		WebElement cityText = driver.findElement(By.xpath("//label[text()='City']/following-sibling::div/input"));
		cityText.click();
		cityText.sendKeys("In");
		List<WebElement> cityOptions = driver.findElements(By.xpath(
				"//div[contains(@class,'pac-container')]/div/span[@class='pac-item-query']/following-sibling::span"));

		try {
			System.out.println("Entered try block");
			driver.findElement(By.xpath(
					"//div[contains(@class,'pac-container')]/div/span[@class='pac-item-query']/following-sibling::span"))
					.click();
		} catch (ElementNotInteractableException e) {
			System.out.println("Entered catch block");
			groupSizeMin.click();
			cityText.click();
			driver.findElement(By.xpath(
					"//div[contains(@class,'pac-container')]/div/span[@class='pac-item-query']/following-sibling::span"))
					.click();
		} catch (StaleElementReferenceException e) {
			System.out.println("Entered catch stale block");
			driver.findElement(By.xpath(
					"//div[contains(@class,'pac-container')]/div/span[@class='pac-item-query']/following-sibling::span"))
					.click();
		}
		Thread.sleep(2000);
		nextButton = driver.findElement(By.xpath("//button[text()='Next']"));
		nextButton.click();

		Thread.sleep(2000);
		WebElement title = driver.findElement(By.xpath(
				"//label[text()='Title']/following-sibling::div/input[@placeholder='Enter the name of your tour']"));
		wait.until(ExpectedConditions.visibilityOf(title));
		String titleText = "Test Tour kj";
		title.sendKeys(titleText);
		Thread.sleep(500);
		WebElement summaryTextArea = driver
				.findElement(By.xpath("//label[text()='Summary']/following-sibling::div/textarea"));
		wait.until(ExpectedConditions.elementToBeClickable(summaryTextArea));
		summaryTextArea.sendKeys("Brief summary of the tour and other helpful details kbhjgu");
		WebElement includedDetails = driver
				.findElement(By.xpath("//label[text()='Included']/following-sibling::div/textarea"));
		wait.until(ExpectedConditions.elementToBeClickable(includedDetails));
		includedDetails.sendKeys(
				"List of things that are included in the tour. Enter each item on a new line to display as a bulleted list.");
		WebElement notIncludedDetails = driver
				.findElement(By.xpath("//label[text()='Not included']/following-sibling::div/textarea"));
		wait.until(ExpectedConditions.elementToBeClickable(notIncludedDetails));
		notIncludedDetails.sendKeys(
				"List of things that are not included in the tour. Enter each item on a new line to display as a bulleted list.");
		Thread.sleep(2000);
		WebElement saveBtn = driver.findElement(By.xpath("//button[text()='Save']"));
		saveBtn.click();
		WebElement successSaveMsg = driver.findElement(By.xpath("//div[@class='notification-title']"));
		String successMsg = successSaveMsg.getDomProperty("textContent");
		System.out.println("Success message: " + successMsg);
		Assert.assertEquals(successMsg, "Tour updated successfully");
		WebElement locationCity = driver.findElement(By.xpath("//label[text()='City']/following-sibling::div/input"));
		wait.until(ExpectedConditions.visibilityOf(locationCity));
		Thread.sleep(2000);
		WebElement locationSaveBtn = driver.findElement(By.xpath("//button[text()='Save']"));
		locationSaveBtn.click();
		WebElement locationSuccessSaveMsg = driver.findElement(By.xpath("//div[@class='notification-title']"));
		String locationSuccessMsg = locationSuccessSaveMsg.getDomProperty("textContent");
		System.out.println("Success message: " + locationSuccessMsg);
		Assert.assertEquals(locationSuccessMsg, "Tour updated successfully");
		Thread.sleep(2000);
//		WebElement imgBtn = driver.findElement(By.xpath("//label[text()='PHOTOS']/following-sibling::div/input"));
		WebElement imgBtn = driver.findElement(By.xpath("//label[text()='PHOTOS']"));
		wait.until(ExpectedConditions.visibilityOf(imgBtn));
		WebElement imgSaveBtn = driver.findElement(By.xpath("//button[text()='Save']"));
		imgSaveBtn.click();
		String imgSuccessText = driver.findElement(By.xpath("//div[@class='notification-title']"))
				.getDomProperty("textContent");
		System.out.println("Success message: " + imgSuccessText);
		Assert.assertEquals(imgSuccessText, "Tour updated successfully");
		Thread.sleep(2000);
		WebElement durationTextfield = driver
				.findElement(By.xpath("//label[text()='Duration']/following-sibling::div//input"));
		durationTextfield.sendKeys("2");
		WebElement durationDropdown = driver.findElement(
				By.xpath("//label[text()='Duration']/following-sibling::div//div[@class=\"multiselect__select\"]"));
		durationDropdown.click();
		List<WebElement> durationDropdownOptions = driver
				.findElements(By.xpath("//label[text()='Duration']/following-sibling::div//ul/li/span/span"));
		for (WebElement option : durationDropdownOptions) {
			String optionText = option.getDomProperty("textContent");
			if (optionText.equalsIgnoreCase("days")) {
				option.click();
			}
		}

		WebElement priceTextfield = driver
				.findElement(By.xpath("//label[text()='Price']/following-sibling::div//input"));
		priceTextfield.sendKeys("1000");
		WebElement priceDropdown = driver.findElement(
				By.xpath("//label[text()='Price']/following-sibling::div//div[@class=\"multiselect__select\"]"));
		priceDropdown.click();
		List<WebElement> priceDropdownOptions = driver.findElements(By
				.xpath("//label[text()='Price']/following-sibling::div//div[@class=\"group-input\"]//ul/li/span/span"));
		for (WebElement option : priceDropdownOptions) {
			String optionText = option.getDomProperty("textContent");
			if (optionText.equalsIgnoreCase("USD")) {
				option.click();
			}
		}

		WebElement priceCategory = driver.findElement(By.xpath(
				"//label[text()='Price']/following-sibling::div/div/div[contains(@class,\"multiselect select\")]/div[@class=\"multiselect__select\"]"));
		priceCategory.click();
		List<WebElement> priceCategoryOption = driver.findElements(By.xpath(
				"//label[text()='Price']/following-sibling::div/div/div[contains(@class,\"multiselect select\")]//ul/li[@class=\"multiselect__element\"]/span/span"));
		for (WebElement option : priceCategoryOption) {
			String optionText = option.getDomProperty("textContent");
			if (optionText.equalsIgnoreCase("Per Person")) {
				option.click();
			}
		}
		WebElement availabilityTextarea = driver
				.findElement(By.xpath("//label[text()='Availability']/following-sibling::div/textarea"));
		availabilityTextarea.sendKeys("Every Monday");
		WebElement qualifiesTextArea = driver.findElement(
				By.xpath("//label[text()='What qualifies you to give this tour?']/following-sibling::div/textarea"));
		qualifiesTextArea.sendKeys("Something");

		WebElement additionaInfoTextarea = driver
				.findElement(By.xpath("//label[text()='Additional info']/following-sibling::div/textarea"));
		additionaInfoTextarea.sendKeys("Something");
		WebElement cancellationTextarea = driver
				.findElement(By.xpath("//label[text()='Cancellation']/following-sibling::div/textarea"));
		cancellationTextarea.sendKeys("Something");
		Thread.sleep(2000);
		WebElement saveBtnDetails = driver.findElement(By.xpath("//button[text()='Save']"));
		saveBtnDetails.click();
		WebElement successMsgDetails = driver.findElement(By.xpath("//div[@class='notification-title']"));
		String successMsgDetailsText = successMsgDetails.getDomProperty("textContent");
		System.out.println("Success message: " + successMsgDetailsText);
		Assert.assertEquals(successMsgDetailsText, "Tour updated successfully");
		Thread.sleep(2000);
		WebElement meetupLocation = driver.findElement(
				By.xpath("//div[@class='form-group']/label[text()='Meetup Location']/following-sibling::div/input"));
		meetupLocation.click();
		meetupLocation.sendKeys("In");
		meetupLocation.sendKeys(Keys.ARROW_DOWN);
		meetupLocation.sendKeys(Keys.ENTER);

		WebElement day1Textarea = driver
				.findElement(By.xpath("//p[@class=\"day-count\" and text()='Day 1']/following-sibling::textarea"));
		day1Textarea.sendKeys("Something");
		WebElement day2Textarea = driver
				.findElement(By.xpath("//p[@class=\"day-count\" and text()='Day 2']/following-sibling::textarea"));
		day2Textarea.sendKeys("Something");
		WebElement saveBtnItinerary = driver.findElement(By.xpath("//button[text()='Save']"));
		saveBtnItinerary.click();
		WebElement successMsgItinerary = driver.findElement(By.xpath("//div[@class='notification-title']"));
		String successMsgItineraryText = successMsgItinerary.getDomProperty("textContent");
		System.out.println("Success message: " + successMsgItineraryText);
		Assert.assertEquals(successMsgItineraryText, "Tour updated successfully");
		WebElement viewTourLink = driver.findElement(By.xpath("//a[text()='View Tour']"));
		wait.until(ExpectedConditions.elementToBeClickable(viewTourLink));
		viewTourLink.click();
		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
			String browserTitle = driver.getTitle();
			System.out.println("Title is " + titleText);
			if (browserTitle.equals(titleText)) {
				System.out.println("Window switched successfully");
				break;
			}
		}
		WebElement testTourText = driver.findElement(By.xpath("//h3[text()='" + titleText + "']"));
		Assert.assertTrue(testTourText.isDisplayed());
//        WebElement hostExperienceText = driver.findElement(By.xpath("//label[contains(text(),'Host Experience')]/following-sibling::div"));
		WebElement dateDrpdwn = driver
				.findElement(By.xpath("//label[contains(text(),'Date')]/following-sibling::div//input"));
		dateDrpdwn.click();
		WebElement frstAvailableDate = driver.findElement(By.xpath(
				"//section[@id=\"book-it-box\"]//div[contains(@class,'datepicker__calendar')]//span[contains(@class,'cell day disabled')]/following-sibling::span[@class=\"cell day\"][1]"));
		frstAvailableDate.click();
		WebElement timeDrpdwn = driver.findElement(By.xpath(
				"//section[@id=\"book-it-box\"]//label[text()='Time']/following-sibling::div/div[@class='multiselect__select']"));
		timeDrpdwn.click();
		WebElement timeOpt = driver
				.findElement(By.xpath("//label[text()='Time']/following-sibling::div//ul/li/span/span"));
		timeOpt.click();
		WebElement peopleDrpdwn = driver.findElement(By.xpath(
				"//section[@id=\"book-it-box\"]//label[text()='People']/following-sibling::div/div[@class='multiselect__select']"));
		peopleDrpdwn.click();
		WebElement peopleOpt = driver
				.findElement(By.xpath("//label[text()='People']/following-sibling::div//ul/li/span/span"));
		peopleOpt.click();
		WebElement requestTobookBtn = driver
				.findElement(By.xpath("//section[@id=\"book-it-box\"]//div[contains(text(),'Request to book')]"));
		requestTobookBtn.click();

		// Payment Pending

		WebElement saveToWishListBtn = driver
				.findElement(By.xpath("//section[@id=\"book-it-box\"]//span[text()='Save to Wish List']/.."));
		saveToWishListBtn.click();
//		WebElement savedToWishListBtn = driver
//				.findElement(By.xpath("//section[@id=\"book-it-box\"]//span[text()='Saved to Wish List']/.."));

	}

	public static String generateRandonString(int length) {
		String alphabet = "qwertyuiopasdfghjklzxcvbnm1234567890";
		String random = "";
		for (int i = 0; i < length; i++) {
			int randNumber = Integer.parseInt(Math.round(Math.random() * 34) + "");
			System.out.println(randNumber + " random number");
			random += alphabet.charAt(randNumber);
		}
		return random;
	}
}