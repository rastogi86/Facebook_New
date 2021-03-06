package facebook.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import facebook.common.CommonMethods;
import facebook.objectproperties.CreateNewPostProperties;

public class CreatePost extends CreateNewPostProperties 
{
	@Test
	public void CreateNewPost(WebDriver driver, String post) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(imgfacebookGotoHomeImage)); // wait for facebook home page to load
		CommonMethods.waitandclick(wait, driver, txtEnterPost); // click to create a new post and wait for the pop-up to load
		driver.findElement(txtPostWindow).sendKeys(post); // Enter a post
		driver.findElement(btnPostWindow).click(); // Click on Post to submit creating a post
		CommonMethods.screenshot(driver);

		// p[contains(text(),'WhatIsThis')]
	}


}
