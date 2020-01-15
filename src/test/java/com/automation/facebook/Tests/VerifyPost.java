package com.automation.facebook.Tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyPost {
	
	public void VerifyPosts(WebDriver driver) throws InterruptedException {
		List<WebElement> elelist=new ArrayList<WebElement>();
		By actualPosts = By.xpath("//div[@id='stream_pagelet']//p");
		elelist = driver.findElements(actualPosts);
		
		String[] list=new String[elelist.size()];
		int i=0;
		for (WebElement x:elelist)
		{
			Thread.sleep(1000);
			list[i]=x.getText();
			System.out.println(list[i]);
			i++;
		}
		
		
	}


}
