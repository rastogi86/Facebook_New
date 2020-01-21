package com.automation.facebook.main;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automation.facebook.Tests.CreatePostTest;
import com.automation.facebook.Tests.FacebookLoginTest;
import com.automation.facebook.Tests.VerifyPostTest;
import com.automation.facebook.Utils.ExtentReportsManager;
import com.automation.facebook.common.CommonMethods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {
	// public static Logger log = Logger.getLogger("devpinoylogger");
	public static Logger log = Logger.getLogger(TestBase.class);
	public WebDriver driver;
	public WebDriverWait wait;
	FacebookLoginTest fbl = new FacebookLoginTest();
	CreatePostTest cp = new CreatePostTest();
	VerifyPostTest vp = new VerifyPostTest();
	public static ExtentReports rep = new ExtentReportsManager().getInstance();
	public static ExtentTest test = rep.startTest("Test has begunnnnn");

	@Parameters({ "browser" })
	@BeforeTest
	public void setUp(@Optional("") String browser) {
		browser = browser.toLowerCase();
		driver = CommonMethods.initializeDriver(driver, browser);

	}

	@Parameters({ "url", "userID", "password" })
	@Test(retryAnalyzer = com.automation.facebook.Utils.RetryAnalyzer.class)
	public void RunTests(@Optional("") String url, @Optional("") String userID, @Optional("") String password)
			throws Exception {
		fbl.Login(driver, url, userID, password);
		cp.CreateNewPost(driver, "New post :: @" + CommonMethods.newFileNameEverytime());
		vp.VerifyPosts(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		
	}
}
