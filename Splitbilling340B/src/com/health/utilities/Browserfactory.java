package com.health.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browserfactory {
	
	public static WebDriver startapplicatio(WebDriver driver, String browserName, String Appurl)
	{
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("ie"))
		{
			System.setProperty("webdriver.IE.driver", "./Drivers/IEDriverserver.exe");
			//driver=new InternetExplorerDriver();
		}
		else
		{
			System.out.println("doenst not support browsers");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Appurl);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return driver;
	}
	public static void QuitBrowser(WebDriver driver)
	{
		driver.quit();
	}

}
