package com.automation.facebook.Tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.facebook.common.CommonMethods;
import com.automation.facebook.objectproperties.VerifyPostPage;

public class VerifyPostTest extends VerifyPostPage{

	public void VerifyPosts(WebDriver driver) throws InterruptedException {
		int i=0;
		CommonMethods cm=new CommonMethods();
		cm.ScrollTheWholePage(driver); // scroll to the bottom of the DOM
		List<WebElement> listofPosts = new ArrayList<WebElement>();
		listofPosts = driver.findElements(txtPost); //find all the posts
		String[] posts = new String[listofPosts.size()];
		
		for (WebElement x : listofPosts) //for each iteration, get the post name 
		{ 
			posts[i] = x.getAttribute("innerText");
			i++;
		}
		for (String a: posts)
		System.out.println(a);
	}

}
