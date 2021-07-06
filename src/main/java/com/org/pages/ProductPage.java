package com.org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.org.utility.ElementUtility;

public class ProductPage {

	WebDriver driver;
	ElementUtility elementutil;
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
		elementutil=new ElementUtility(driver);
	}
	By sidemenubtnloc=By.id("react-burger-menu-btn");
	By logoutbtnloc=By.id("logout_sidebar_link");
	
	
	public boolean validateProductPageTitle(String expTilte)
	{
		String actTitle = elementutil.getTitle();
		System.out.println(actTitle);
		if(actTitle.equalsIgnoreCase(expTilte))
			return true;
		else
			return false;
	}
	
	public String getProductPageTitle() {
		return elementutil.getTitle();
	}
	
	public void clickOnLogoutBtn()
	{
		elementutil.OnClick(sidemenubtnloc);
		elementutil.OnClick(logoutbtnloc);
		
	}
}
