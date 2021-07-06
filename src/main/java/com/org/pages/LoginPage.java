package com.org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.org.utility.ElementUtility;

public class LoginPage {
	WebDriver driver;
	ElementUtility elementutil;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		elementutil=new ElementUtility(driver);
	}
	
	
	By usernameloc=By.id("user-name");
	By passwordloc=By.id("password");
	By loginbtnloc=By.id("login-button");
	
	public void launchURL(String appurl)
	{
		elementutil.launchAppURL(appurl);
	}
	
	public  boolean validaeLoginPageDetails()
	{
		
		if(elementutil.isDisplayed(usernameloc) && elementutil.isDisplayed(passwordloc) && elementutil.isDisplayed(loginbtnloc)) {
			return true;
		}else {
			return false;
		}
	}
}
