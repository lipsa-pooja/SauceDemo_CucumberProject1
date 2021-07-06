package com.org.stepDefination;

import org.junit.Assert;

import com.org.driverFactory.DriverFactory;
import com.org.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination {
	LoginPage loginpage=new LoginPage(DriverFactory.getDriver());
	
	
	@Given("Launch appURL {string}")
	public void launch_app_url(String url) {
		loginpage.launchURL(url);
	    
	}



	@Then("Validate Login Page")
	public void validate_login_page() {
		//method to validate login page
		Assert.assertTrue("Login page details are not appearing correctly", loginpage.validaeLoginPageDetails());
	
	}
	@When("Enter User Name and Password")
	public void enter_user_name_and_password() {
	   
	}
	@When("Click on Submit Button")
	public void click_on_submit_button() {
	    
	}
	@Then("Validate Product Page Title")
	public void validate_product_page_title() {
	   
	}
	@When("Click on Log out option")
	public void click_on_log_out_option() {
	 
	}
	@Then("Validate Login page appear")
	public void validate_login_page_appear() {
	 
	}

}
