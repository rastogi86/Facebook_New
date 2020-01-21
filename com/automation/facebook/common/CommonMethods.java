package facebook.common;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonMethods {
	public static WebDriver driver;
	public static WebDriverWait wait;

	public static WebDriver initializeDriver(WebDriver driver, String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			String[] arguments = { "--incognito", "--start-maximized", "--disable-infobars", "--disable-extensions" };
			options.addArguments(arguments);

			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		}
		wait = new WebDriverWait(driver, 20);
		return driver;
	}

	public static String newFileNameEverytime() {
		Date d = new Date();
		String filename = d.toString().replace(":", "_").replace(" ", "_");
		return filename;
	}

	public static void screenshot(WebDriver driver) throws IOException {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,
				new File(System.getProperty("user.dir") + "\\screenshot\\" + newFileNameEverytime() + ".jpeg"));

	}

	public static boolean waitandclick(WebDriverWait wait, WebDriver driver, By locator) {

		if (wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed()) {
			driver.findElement(locator).click();
			return true;
		} else
			return false;

	}

}
