package facebook.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import facebook.Tests.CreatePost;
import facebook.Tests.FacebookLogin;
import facebook.Tests.VerifyPost;
import facebook.common.CommonMethods;

public class TestBase {
	public WebDriver driver;
	public WebDriverWait wait;
	FacebookLogin fbl = new FacebookLogin();
	CreatePost cp = new CreatePost();
	VerifyPost vp = new VerifyPost();
	// public ExtentReports extent;

	@Parameters({ "browser" })
	@BeforeTest
	public void setUp(@Optional("") String browser) {
		browser = browser.toLowerCase();
		driver=CommonMethods.initializeDriver(driver, browser);
	}

	@Parameters({ "url", "userID", "password" })
	@Test(retryAnalyzer = facebook.Utils.RetryAnalyzer.class)
	public void RunTests(@Optional("") String url, @Optional("") String userID, @Optional("") String password)
			throws Exception {
		fbl.Login(driver, url, userID, password);
		cp.CreateNewPost(driver, "New post :: @" + CommonMethods.newFileNameEverytime());
		vp.VerifyPosts(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		// extent.flush();
	}
}
