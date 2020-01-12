package facebook.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import facebook.main.TestBase;
import facebook.objectproperties.FacebookLoginPageProperties;

public class FacebookLogin extends FacebookLoginPageProperties
{
	public void Login(WebDriver driver, String url, String userID, String password) throws Exception 
	{
		driver.get(url);
		driver.findElement(eleEmailID).sendKeys(userID);
		driver.findElement(elePassword).sendKeys(password);
		driver.findElement(btnLogin).click();
	}
	
	public void CreatePost(WebDriver driver, String post) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(imgfacebookGotoHomeImage));
		driver.findElement(txtEnterPost).click();
		driver.findElement(txtPostWindow).sendKeys(post);
		driver.findElement(btnPostWindow).click();
		Thread.sleep(3000);
		TestBase.TakesScreenshot();
		
		//p[contains(text(),'WhatIsThis')]

	}
	}
