package com.health.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilitiesPro {

	
	public static String capturescreenshot(WebDriver driver)
	{
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String Screenshotpath= System.getProperty("user.dir")+"/Screenshots/340B_"+currentdate()+".png";
		try {
			FileHandler.copy(src, new File(Screenshotpath));
		} catch (IOException e) {
	      System.out.println("screenshot exception"+e.getMessage( ));
		}
		return Screenshotpath;
	}
	public static String currentdate()
	{
		DateFormat customformat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentdate=new Date();
		return customformat.format(currentdate);
	}
}
