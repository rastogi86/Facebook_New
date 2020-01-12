package facebook.Tests;

import org.openqa.selenium.By;
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
		driver.findElement(By.xpath("//div[contains(@aria-label,'on your mind')]")).sendKeys(post);
		driver.findElement(By.xpath("//button[@data-testid='react-composer-post-button' and @type='submit']")).click();
		Thread.sleep(4000);
		TestBase.TakesScreenshot();

	}
	}
