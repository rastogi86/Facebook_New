package facebook.Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener
{

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test named "+result.getMethod().getMethodName()+" has passed");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test named "+result.getName()+" has failed");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test named "+result.getName()+" has skipped");
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test named "+context.getName()+" has started");
	}
	

}
