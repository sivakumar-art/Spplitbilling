package com.health.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class login {
WebDriver driver;
	public login(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}
public void loginapplication(String uname, String Pword) throws Exception
{
	Thread.sleep(100);
	driver.findElement(By.xpath("//input[@id='Input_Username']")).sendKeys(uname);
	driver.findElement(By.xpath("//input[@id='Input_Password']")).sendKeys(Pword);
	driver.findElement(By.xpath("//button[text()='Login']")).click();
}
}