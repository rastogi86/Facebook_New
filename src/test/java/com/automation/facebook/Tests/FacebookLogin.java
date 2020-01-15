package com.automation.facebook.Tests;

import org.openqa.selenium.WebDriver;

/*import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
*/
import com.automation.facebook.objectproperties.FacebookLoginPageProperties;

public class FacebookLogin extends FacebookLoginPageProperties {

	/*
	 * public ExtentHtmlReporter htmlReporter; public ExtentReports extent; public
	 * ExtentTest test;
	 */

	/*
	 * public ExtentReports htmlReportersetup() { htmlReporter = new
	 * ExtentHtmlReporter(System.getProperty("user.dir") +
	 * ".//results/ExtentReport.html"); htmlReporter.config().setEncoding("UTF-8");
	 * htmlReporter.config().setDocumentTitle("Facebook tests");
	 * htmlReporter.config().setReportName("Creating a post");
	 * htmlReporter.config().setTheme(Theme.DARK); extent = new ExtentReports();
	 * extent.attachReporter(htmlReporter); return extent; }
	 */
	public void Login(WebDriver driver, String url, String userID, String password) throws Exception {
		System.out.println("Inside login method");
		driver.get(url);
		driver.findElement(eleEmailID).sendKeys(userID);
		driver.findElement(elePassword).sendKeys(password);
		driver.findElement(btnLogin).click();
	}

}