package com.automation.facebook.Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	static int counter = 0;
	static int retryLimit = 3;

	public boolean retry(ITestResult result) 
	{
		if (counter < retryLimit) {
			counter++;
			return true;
		}

		return false;
	}

}
