package com.org.driverFactory;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	WebDriver driver;
	static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	public WebDriver init_Driver(Properties prop) {
		if (prop.getProperty("broswerName").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
		}
		if (prop.getProperty("browserName").equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new FirefoxDriver());
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return getDriver();

	}

	public static WebDriver getDriver() {
		return tldriver.get();
	}

}
