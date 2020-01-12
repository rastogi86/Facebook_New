package facebook.Utils;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener
{

	public void onTestSuccess(ITestResult result) 
	{
		if(result.getStatus()==ITestResult.SUCCESS)
			Assert.assertTrue(result.getStatus()==ITestResult.SUCCESS, "What");
	}

	public void onTestFailure(ITestResult result) 
	{
		System.out.println("Test named "+result.getMethod().getMethodName()+" has failed");
	}

	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("Test named "+result.getMethod().getMethodName()+" has skipped");
	}

	public void onStart(ITestContext context) 
	{
		System.out.println("Test named "+context.getName()+" has started");
	}
	

}
