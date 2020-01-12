package facebook.main;

import facebook.Tests.FacebookLogin;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase extends FacebookLogin {
	public static WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void setUp(@Optional("") String browser) {
		browser = browser.toLowerCase();

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			String[] arguments = {"incognito", "start-maximized", "disable-infobars","disable-extensions"};
			options.addArguments(arguments);
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;
			
		/*SetChromeOptions sct=new SetChromeOptions(); sct.SetChromeOptions(options);
			options.addArguments("incognito");
			options.addArguments("start-maximized");
			options.addArguments("window-size=1680,1050");
			options.addArguments("disable-infobars");
			options.addArguments("disable-extensions");*/
		
			

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
	}

	public static String newFileNameEverytime() 
	{
		Date d = new Date();
		String filename = d.toString().replace(":", "_").replace(" ", "_");
		return filename;
	}

	public static void TakesScreenshot() throws IOException 
	{
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,
				new File(System.getProperty("user.dir") + "\\screenshot\\" + newFileNameEverytime() + ".jpeg"));
	}

	@Parameters({ "url", "userID", "password" })
	@Test(retryAnalyzer = facebook.Utils.RetryAnalyzer.class)
	public void RunTests(@Optional("") String url, @Optional("") String userID, @Optional("") String password) throws Exception 
	{
		Login(driver, url, userID, password);
		CreatePost(driver, "New post :: @" + newFileNameEverytime());
	}

	@AfterTest
	public void tearDown() 
	{
		driver.quit();
	}
}
