package facebook.main;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import facebook.Tests.FacebookLogin;

public class TestBase extends FacebookLogin {
	public static WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(@Optional("") String browser) 
	{
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+".//results/ExtentReport.html");
		htmlReporter.config().setEncoding("UTF-8");
		htmlReporter.config().setDocumentTitle("Facebook tests");
		htmlReporter.config().setReportName("Creating a post");
		htmlReporter.config().setTheme(Theme.DARK);
		extent =new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		browser = browser.toLowerCase();
		driver=initializeDriver(driver,browser);
		
	}
		
	@Parameters({ "url", "userID", "password" })
	@Test(retryAnalyzer = facebook.Utils.RetryAnalyzer.class)
	public void RunTests(@Optional("") String url, @Optional("") String userID, @Optional("") String password) throws Exception 
	{
		Login(driver, url, userID, password,test);
		CreatePost(driver, "New post :: @" + newFileNameEverytime());
	}

	@AfterTest
	public void tearDown() 
	{
		driver.quit();
		extent.flush();
	}
}
