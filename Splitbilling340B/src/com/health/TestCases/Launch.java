package com.health.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.health.screens.Baseclass;
import com.health.screens.login;
import com.health.utilities.datafromexcel;

public class Launch extends Baseclass {

	@Test
	public void loginapp() throws Exception 
	{
		logger=report.createTest("login to 340B");
		 login login=PageFactory.initElements(driver, login.class); 
		 logger.info("launch success");
		 login.loginapplication(excel.datainstring(0, 0, 0), excel.datainstring(0, 0, 1));
		 logger.pass("login success");
	}
}
