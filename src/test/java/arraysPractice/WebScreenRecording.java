package arraysPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.Principal;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebScreenRecording {
	public static void main(String[] args) throws InterruptedException {
		// Start recording thread
		Thread thread1 = new Thread(new VdoRec());
		// Start browser automation thread
		Thread thread2 = new Thread(new RunBrowser());

		// Start both threads
		thread1.start();
		Thread.sleep(Duration.ofSeconds(10));
		thread2.start();
	}
}

// Class for video recording
class VdoRec implements Runnable {
	private Process process;

	@Override
	public void run() {
		System.out.println("Video recording started...");
		try {
			// FFmpeg command
			String ffmpegCommand = "C:\\Users\\ER\\Downloads\\ffmpeg-master-latest-win64-gpl-shared\\ffmpeg-master-latest-win64-gpl-shared\\bin\\ffmpeg.exe -y -rtbufsize 200M -video_size 1280x720 -framerate 30 -f gdigrab -i desktop C:\\Users\\ER\\Videos\\screen_recording_new.mp4";

			// Start the FFmpeg process
			ProcessBuilder processBuilder = new ProcessBuilder(ffmpegCommand.split(" "));
			processBuilder.environment().put("PATH",
					"C:\\Users\\ER\\Downloads\\ffmpeg-master-latest-win64-gpl-shared\\bin");
			process = processBuilder.start();

			System.out.println("FFmpeg recording in progress...");

			// Keep recording while the browser automation runs
//            Thread.sleep(Duration.ofSeconds(60)); // Adjust duration as needed
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String errorLine;
			boolean stopRec = false;
			while ((errorLine = errorReader.readLine()) != null) {
				System.out.println("FFmpeg Log: " + errorLine);
				String[] errorArray = errorLine.split(" ");
				if (errorLine.contains("bitrate") && errorLine.contains("time") && errorLine.contains("speed")) {
					for (String val : errorArray) {
						if (val.contains("KiB")) {
							System.out.println("value is " + val);
							System.out.println("size is " + val.replaceAll("[^0-9.]", ""));
							double size = Double.parseDouble(val.replaceAll("[^0-9.]", ""));
							if (size > 3000) {
								stopRec = true;
								break;
							}
						}
					}
				}
				if (stopRec) {
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Stop recording
			if (process != null) {
				try {
					// Send the 'q' command to FFmpeg to stop recording cleanly
					process.getOutputStream().write("q".getBytes());
					process.getOutputStream().flush();

					// Wait for the FFmpeg process to terminate
					process.waitFor();
					System.out.println("Video recording stopped gracefully.");
				} catch (Exception e) {
					e.printStackTrace();
				}
//				process.destroy();
				System.out.println("Video recording stopped.");
			}
		}
	}

	private void stopRecordingGracefully() {
		try {
			System.out.println("Attempting to stop recording gracefully...");
			if (process != null) {
				// Send the 'q' command to FFmpeg to stop recording cleanly
				process.getOutputStream().write("q".getBytes());
				process.getOutputStream().flush();

				// Wait for the FFmpeg process to terminate
				process.waitFor();
				System.out.println("Video recording stopped gracefully.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

// Class for browser automation
class RunBrowser implements Runnable {

	@Override
	public void run() {
		WebDriver driver = null;
		try {
//            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ER\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

			driver = new ChromeDriver();
			driver.manage().window().maximize();

			// Perform browser actions
			driver.get("https://www.google.com");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			for (int i = 0; i < 5; i++) {
				WebElement element = driver.findElement(By.tagName("a"));
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click(); // Perform click
				Thread.sleep(2000); // Wait after each interaction
				driver.navigate().back(); // Go back
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (driver != null) {
				driver.quit();
				System.out.println("Browser automation completed and driver closed.");
			}
		}
	}
}