package facebook.main;

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

import facebook.Tests.FacebookLogin;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public volatile static WebDriver driver;

	
	@Parameters("browser")
	@BeforeTest
	public void setUp(@Optional("") String browser) {
		browser = browser.toLowerCase();

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			/*
			 * SetChromeOptions sct=new SetChromeOptions(); sct.SetChromeOptions(options);
			 */
			options.addArguments("incognito");
			options.addArguments("start-maximized");
			options.addArguments("window-size=1680,1050");
			options.addArguments("disable-infobars");
			options.addArguments("disable-extensions");
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
	}

	public static String newFileNameEverytime()
	{
		Date d=new Date();
		String filename=d.toString().replace(":", "_").replace(" ", "_");
		return filename;
	}
	public static void TakesScreenshot() throws IOException
	{
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"\\screenshot\\"+newFileNameEverytime()+".jpeg"));
	}
	@Parameters({ "url", "userID", "password" })
	@Test
	public void RunTests(String url, String userID, String password) throws IOException, InterruptedException {
		FacebookLogin fbl = new FacebookLogin();
		fbl.Login(driver, url, userID, password);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
