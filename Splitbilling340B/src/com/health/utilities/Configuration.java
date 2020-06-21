package com.health.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
	Properties pro;
	public Configuration()
	{
		File configf=new File("./Configuration/configuration.properties");
		try {
			FileInputStream fis=new FileInputStream(configf);
			 pro=new Properties();
			 pro.load(fis);
		} catch (IOException e) {
			System.out.println("try catch exception raised"+e.getMessage());
		}
	}
	public String browserfromconfig()
	{
		return pro.getProperty("Browser");
		
	}
	public String URLfromconfig()
	{
		return pro.getProperty("Preprod");
	}
}
