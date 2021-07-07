package com.org.utility;

import java.util.ArrayList;
import java.util.List;

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

public void senkeys(By locator,String input)
{
	WebElement wb=findElement(locator);
	wb.sendKeys(input);
}

public void OnClick(By locator)
{
WebElement wb=findElement(locator);
wb.click();
}

public String getText(By locator)
{
	WebElement wb=findElement(locator);
	return wb.getText();
}

public List<WebElement> findElements(By locator)
{
	return driver.findElements(locator);
}
public void ClickselectedOptionFromDropdown(String sortOption,By locator)
{
	List<WebElement> list=findElements(locator);

	for(WebElement wb:list)
	{
		String dropdowntext=wb.getText();
		if(dropdowntext.equalsIgnoreCase(sortOption))
		{
			wb.click();
			break;
		}
		
	}
}

public List<Double> getItemsInList(By locator)
{
	List<Double> actuallist=new ArrayList<Double>();
	List<WebElement> list=findElements(locator);
	for(WebElement wb:list)
	{
		String itemPricelist=wb.getText();
		String itemprice=itemPricelist.replace("$","");
		Double dprice=Double.parseDouble(itemprice);
		actuallist.add(dprice);
		//System.out.println(dprice);	
	}
	System.out.println(actuallist);//without sorting
	return actuallist;
}



}