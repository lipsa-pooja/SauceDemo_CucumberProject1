package com.org.stepDefination;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.org.driverFactory.DriverFactory;
import com.org.pages.LoginPage;
import com.org.pages.ProductPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination {
	LoginPage loginpage=new LoginPage(DriverFactory.getDriver());
	ProductPage productpage;
	
	
	@Given("Launch appURL {string}")
	public void launch_app_url(String url) {
		loginpage.launchURL(url);
	    
	}



	@Then("Validate Login Page")
	public void validate_login_page() {
		//method to validate login page
		Assert.assertTrue("Login page details are not appearing correctly", loginpage.validaeLoginPageDetails());
	
	}
	@When("Enter UserName and Password")
	public void enter_user_name_and_password(DataTable datatable) {
	List<Map<String,String>> userList=datatable.asMaps();
	String user = userList.get(0).get("username");
	String pswd = userList.get(0).get("password");
	loginpage.addCredentials(user, pswd);

	}
	
	@When("Click on Submit Button")
	public void click_on_submit_button() {
		productpage= loginpage.clickOnLoginbtn();   
	}
	@Then("Validate Product Page Title is {string}")
	public void validate_product_page_title(String expTitle) {
		Assert.assertTrue("Product page Title is not as Expected.", productpage.validateProductPageTitle(expTitle));
		
		Assert.assertEquals("Product Page titles are not matching", expTitle, productpage.getProductPageTitle());
	   
	}
	@When("Click on Log out option")
	public void click_on_log_out_option() {
		productpage.clickOnLogoutBtn();
	}


@Then("Validate locked out user error message appeared is {string}")
public void validate_locked_out_user_error_message_appeared_is(String EXpectedErrorMsg) {
   Assert.assertTrue("Required error msg is not appearing.", loginpage.validateErrorMsg(EXpectedErrorMsg));
}

@Then("Verify Product page appear")
public void verify_product_page_appear() {
   Assert.assertTrue("verify product page is not appearing", productpage.validateProductPageAppear());
}

@Then("Verify Prodcut Sort Conatiner appears on the page")
public void verify_prodcut_sort_conatiner_appears_on_the_page() {
	 Assert.assertTrue("Prodcut Sort Conatiner is not appearing on the page", productpage.VerifyProduutSortConatinerAppears());
}

@Then("Validate By Default {string} selected in Prodcut Sort Conatiner")
public void validate_by_default_selected_in_prodcut_sort_conatiner(String actdefaultselectednameinsortcontainer) {
 Assert.assertEquals("Actual Ddefault selected name in sort_container is not matched with Expected.", productpage.defaultSelectedNameInSortContainer(), actdefaultselectednameinsortcontainer);   
}

@When("Select {string} option in Prodcut Sort Conatiner")
public void select_option_in_prodcut_sort_conatiner(String sortOption) {
   productpage.selectOptionInSortContainerDropDown(sortOption);
}

@Then("Validate all the Products are appearing as per low to high price")
public void validate_all_the_products_are_appearing_as_sorted() {
   
   Assert.assertTrue("Required item price are not sorted order", productpage.validateSortingOfItemPriceINProductPage());
}


}
