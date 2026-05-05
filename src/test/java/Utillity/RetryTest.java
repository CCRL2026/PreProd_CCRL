package Utillity;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer {

	private int retryCount = 0;
	private static final int MaxretryCount = 3;

	@Override
	public boolean retry(ITestResult result) {

		if (retryCount < MaxretryCount) {
			retryCount++;
			return true;
		}
		return false;
	}
}
