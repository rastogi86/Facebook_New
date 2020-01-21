package com.automation.facebook.Utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.facebook.common.CommonMethods;
import com.automation.facebook.main.TestBase;
import com.relevantcodes.extentreports.LogStatus;


public class ListenerClass extends TestBase implements ITestListener
{
	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, "This test has passed "+result.getName().toUpperCase());
		rep.endTest(TestBase.test);
		rep.flush();
	}

	
	public void onTestFailure(ITestResult result) {
		TestBase.test.log(LogStatus.FAIL, "This test has failed "+result.getName().toUpperCase());
		try {
			CommonMethods.screenshot(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rep.endTest(test);
		rep.flush();
	}

	public void onStart(ITestContext context) 
	{
		test.log(LogStatus.INFO, context.getName()+" has started");
		rep.endTest(test);
		rep.flush();
	}

	public void onTestStart(ITestResult result) {
		test.log(LogStatus.INFO, "This test has started "+result.getMethod().getMethodName());
		
	}

	public void onFinish(ITestContext context) {
		test.log(LogStatus.INFO, "This test has passed "+context.getName());
		rep.endTest(TestBase.test);
		rep.flush();
	}
	

}
