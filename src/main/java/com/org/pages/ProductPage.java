package com.org.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	By productpageTitleloc=By.xpath("//span[@class='title']");
	By productsortcontainerloc=By.xpath("//select[@class='product_sort_container']");
	By defaultselectnameIncontainerloc=By.xpath("//span[text()='Name (A to Z)']");
	By sortContainerDropdownloc=By.xpath("//select[@class='product_sort_container']/option");
	By itemPriceloc=By.xpath("//div[@class='inventory_item_price']");
	
	
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
	public boolean validateProductPageAppear()
	{
		return elementutil.isDisplayed(productpageTitleloc);
		
	}
	public boolean VerifyProduutSortConatinerAppears()
	{
		return elementutil.isDisplayed(productsortcontainerloc);
	}
	public String defaultSelectedNameInSortContainer()
	{
		return elementutil.getText(defaultselectnameIncontainerloc);
	}
	public void selectOptionInSortContainerDropDown(String sortOption)
	{
		elementutil.ClickselectedOptionFromDropdown(sortOption, sortContainerDropdownloc);
	}
	
	public boolean validateSortingOfItemPriceINProductPage()
	{
		List<Double> tempList=new ArrayList<Double>();
		List<Double> actuallist = elementutil.getItemsInList(itemPriceloc);
		tempList = actuallist;
		
		//Collections.sort(tempList); //Ascending sorting---low to high
		Collections.sort(tempList, Collections.reverseOrder()); //descenading sorting---high to low
		
		System.out.println(tempList);//after sorting
		
		if(actuallist.equals(tempList)) {
			return true;
		}else {
			return false;
		}
	}
}
