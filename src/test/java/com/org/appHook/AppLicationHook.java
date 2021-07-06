package com.org.appHook;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.org.driverFactory.DriverFactory;
import com.org.utility.ConfigPropertyReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class AppLicationHook {
	ConfigPropertyReader config;
	Properties prop;
	DriverFactory driverfactory;
	WebDriver driver;
	
	@Before(order=0)
	public void setUpConfig()
	{
		config=new ConfigPropertyReader();
		 prop=config.getProperty();
	}
	@Before(order=1)
	public void setUpWebDriver()
	{
		 driverfactory=new DriverFactory();
		 driver=driverfactory.init_Driver(prop);
	}
	@After(order=0)
	public void tearDown()
	{
		
	}

}
