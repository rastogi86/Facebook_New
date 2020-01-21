package facebook.Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener
{

	public void onStart(ITestContext context) 
	{
		System.out.println("Test named "+context.getName()+" has started");
	}

	public void onTestStart(ITestResult result) {
		System.out.println("The following test has started :: "+result.getMethod().getMethodName());
	}

	public void onFinish(ITestContext context) {
		System.out.println("The following test has completed :: "+context.getName());
	}
	

}
