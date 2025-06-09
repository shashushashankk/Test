package Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import java.io.IOException;

public class WebScreenRecording {
	public static void main(String[] args) {
		Process ffmpegProcess = null;
		WebDriver driver = null;

		try {
			// Start screen recording using FFmpeg
			String ffmpegCommand = "C:\\Users\\ER\\Downloads\\ffmpeg-master-latest-win64-gpl-shared\\ffmpeg-master-latest-win64-gpl-shared\\bin\\ffmpeg.exe -y -video_size 1366X768 -framerate 30 -f gdigrab -i desktop screen_recording.mp4";
			ffmpegProcess = new ProcessBuilder(ffmpegCommand.split(" ")).start();
			System.out.println("Screen recording started...");

			// Set up Selenium WebDriver (make sure ChromeDriver is installed)
			System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
			driver = new ChromeDriver();

			// Automate browser actions
			driver.get("https://www.example.com");
			WebElement element = driver.findElement(By.id("some-element-id"));
			element.click(); // Perform some actions

			// Wait for a few seconds to simulate interaction
			Thread.sleep(5000);

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		} finally {
			// Stop FFmpeg recording
			if (ffmpegProcess != null) {
				ffmpegProcess.destroy();
				System.out.println("Screen recording stopped.");
			}

			// Quit the WebDriver
			if (driver != null) {
				driver.quit();
			}
		}
	}
}
