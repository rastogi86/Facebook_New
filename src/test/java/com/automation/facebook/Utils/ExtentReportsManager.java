package com.automation.facebook.Utils;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;


public class ExtentReportsManager {

	private static ExtentReports extent;
	
	public ExtentReports getInstance()
	{
		if(extent==null)
		{
		extent = new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extent.html",true,DisplayOrder.OLDEST_FIRST);
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\com\\automation\\resources\\extentconfig\\ReportsConfig.xml"));
		}
		return extent;
	}
}
