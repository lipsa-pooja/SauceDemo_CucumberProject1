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

}
