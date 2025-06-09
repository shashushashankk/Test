package Testing;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
	int initialCount = 0;
	int retryCount = 2;

	@Override
	public boolean retry(ITestResult result) {
		if (initialCount < retryCount) {
			initialCount++;
			return true;
		}
		return false;
	}

}
