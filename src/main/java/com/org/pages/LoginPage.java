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
	By errormsg=By.xpath("//h3[@data-test='error']");
	
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
	
	public void addCredentials(String username,String password)
	{
		elementutil.senkeys(usernameloc, username);
		elementutil.senkeys(passwordloc, password);
	}
	public ProductPage clickOnLoginbtn()
	{
		elementutil.OnClick(loginbtnloc);	
		return new ProductPage(driver);
	}
	
	public boolean validateErrorMsg(String expectedErrormsg)
	{
		System.out.println(elementutil.getText(errormsg)); 
	String actErrorMsg=elementutil.getText(errormsg);
	if(expectedErrormsg.equalsIgnoreCase(actErrorMsg))
	{
		return true;
	}
	return false;
	}
}
