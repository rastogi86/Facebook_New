package com.automation.facebook.main;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automation.facebook.Tests.CreatePost;
import com.automation.facebook.Tests.FacebookLogin;
import com.automation.facebook.Tests.VerifyPost;
import com.automation.facebook.common.CommonMethods;

public class TestBase {
	Logger log = Logger.getLogger("devpinoylogger");
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
		driver = CommonMethods.initializeDriver(driver, browser);
		log.debug("Browser initialized");
		Reporter.log("Browser initialized");
	}

	@Parameters({ "url", "userID", "password" })
	@Test(retryAnalyzer = com.automation.facebook.Utils.RetryAnalyzer.class)
	public void RunTests(@Optional("") String url, @Optional("") String userID, @Optional("") String password)
			throws Exception {
		fbl.Login(driver, url, userID, password);
		Reporter.log("User logged in");
		cp.CreateNewPost(driver, "New post :: @" + CommonMethods.newFileNameEverytime());
		log.debug("New post created");
		vp.VerifyPosts(driver);
		log.debug("Posts retrieved");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		// extent.flush();
	}
}
