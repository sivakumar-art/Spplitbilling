package com.health.screens;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.health.utilities.Browserfactory;
import com.health.utilities.Configuration;
import com.health.utilities.UtilitiesPro;
import com.health.utilities.datafromexcel;


public class Baseclass {

	
	public static WebDriver driver;
	public datafromexcel excel;
	public 	Configuration config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public  void setdatafromexcel() throws Exception
	{
		excel=new datafromexcel();
	config=new Configuration();
	ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports and logs/340B"+UtilitiesPro.currentdate()+".html"));
	report=new ExtentReports();
	report.attachReporter(extent);
	}
	
	@BeforeClass
	public void setup()
	{
		driver=Browserfactory.startapplicatio(driver, config.browserfromconfig(),config.URLfromconfig());	
	}
@AfterClass
	
	public void quit()
	{
		Browserfactory.QuitBrowser(driver);
	}
	@AfterMethod
	public  void screenshot(ITestResult results) throws Exception
	{
		Thread.sleep(8000);
			if(results.getStatus()==ITestResult.FAILURE)
		{
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(UtilitiesPro.capturescreenshot(driver)).build());
		}
			
			else if(results.getStatus()==ITestResult.SUCCESS)
			{
				//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				
				logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(UtilitiesPro.capturescreenshot(driver)).build());
			}
		report.flush();
	}
}
