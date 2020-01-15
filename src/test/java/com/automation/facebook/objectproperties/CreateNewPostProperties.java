package com.automation.facebook.objectproperties;

import org.openqa.selenium.By;

public class CreateNewPostProperties {

	public static By imgfacebookGotoHomeImage=By.xpath("//span[@class='_2md']");
	public static By txtEnterPost = By.xpath("//div//textarea[contains(@class,'navigationFocus')]");

	public static By txtPostWindow = By.xpath("//div[contains(@aria-label,'on your mind')]");
	public static By btnPostWindow = By.xpath("//button[@data-testid='react-composer-post-button' and @type='submit']");

}
