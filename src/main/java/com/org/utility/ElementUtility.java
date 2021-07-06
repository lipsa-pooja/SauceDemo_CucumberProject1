package com.org.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtility {
	WebDriver driver;
	public ElementUtility(WebDriver driver)
	{
	this.driver=driver;	
	}


public void launchAppURL(String url)
{
	driver.get(url);
}


public String getTitle()
{
	return driver.getTitle();
}

public WebElement findElement(By locator)
{
	return driver.findElement(locator);
}


public boolean isDisplayed(By locator)
{
	waitTillDisplay(locator);
	WebElement wb = findElement(locator);
	return wb.isDisplayed();
}


public void waitTillDisplay(By locator)
{
	WebDriverWait wait=new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
}
}