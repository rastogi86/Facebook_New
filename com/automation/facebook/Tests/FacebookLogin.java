package facebook.Tests;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import facebook.objectproperties.FacebookLoginPageProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookLogin extends FacebookLoginPageProperties 
{
	public static WebDriver driver;
	static volatile WebDriverWait wait;
	
	public WebDriver initializeDriver(WebDriver driver,String browser)
	{
		if(browser.equals("chrome"))
			{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			String[] arguments = {"incognito", "start-maximized", "disable-infobars","disable-extensions"};
			options.addArguments(arguments);
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
			}
		else if(browser.equals("firefox"))
			{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
			}

		return driver;
	}

	public void Login(WebDriver driver, String url, String userID, String password, ExtentTest test) throws Exception {
		driver.get(url);
		test.info(url +" has been entered");
		driver.findElement(eleEmailID).sendKeys(userID);
		test.info(eleEmailID +" has been entered");
		driver.findElement(elePassword).sendKeys(password);
		test.info(elePassword +" has been entered");
		driver.findElement(btnLogin).click();
		test.info(btnLogin +" has been clicked");

	}
	public static String newFileNameEverytime() 
	{
		Date d = new Date();
		String filename = d.toString().replace(":", "_").replace(" ", "_");
		return filename;
	}

	public static void TakesScreenshot(WebDriver driver) throws IOException 
	{
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,
				new File(System.getProperty("user.dir") + "\\screenshot\\" + newFileNameEverytime() + ".jpeg"));
	}
	
	public void CreatePost(WebDriver driver, String post) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(imgfacebookGotoHomeImage));   //wait for facebook home page to load
		waitandclick(wait,driver,txtEnterPost);       //click to create a new post and wait for the pop-up to load
		driver.findElement(txtPostWindow).sendKeys(post);   //Enter a post
		driver.findElement(btnPostWindow).click();   //Click on Post to submit creating a post
		TakesScreenshot(driver);

		// p[contains(text(),'WhatIsThis')]

	}
	
	public boolean waitandclick(WebDriverWait wait,WebDriver driver,By locator)
	{
		if(wait.until(ExpectedConditions.visibilityOfElementLocated((locator))).isDisplayed())
		{
		driver.findElement(locator).click();
		return true;
		}
		else
		return false;
		
	}
}
