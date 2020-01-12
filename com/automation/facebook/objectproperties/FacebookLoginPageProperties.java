package facebook.objectproperties;

import org.openqa.selenium.By;

public class FacebookLoginPageProperties
{
	public static By imgFacebookLogo=By.xpath("//i[@class='fb_logo img sp_qtp6H98Uhz5 sx_d0e21d']");
	public static By imgfacebookGotoHomeImage=By.xpath("//span[@class='_2md']");
	
	public By eleEmailID=By.id("email");
	public By elePassword=By.id("pass");
	
	
	public By btnLogin=By.id("u_0_2");
	
	public static By txtEnterPost=By.xpath("//div//textarea[contains(@class,'navigationFocus')]");
	
	public static By txtPostWindow=By.xpath("//div[contains(@aria-label,'on your mind')]");
	public static By btnPostWindow=By.xpath("//button[@data-testid='react-composer-post-button' and @type='submit']");
	
	
	

}
