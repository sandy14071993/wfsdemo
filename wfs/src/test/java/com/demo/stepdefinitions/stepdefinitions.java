package com.demo.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.demo.pages.LoginPage;
import com.demo.pages.ProductPage;
import com.demo.testBase.TestContextSetup;
import com.demo.testBase.baseClass;
import com.demo.utils.utility_class;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdefinitions{
	
	public WebDriver driver;
	LoginPage loginpage;
	ProductPage productpage;
	TestContextSetup testcontextsetup;
	//LoginPage Login=new LoginPage(driver);
	//ProductPage productPage=new ProductPage(driver);
	
	public stepdefinitions(TestContextSetup testcontextsetup) {
		
		this.testcontextsetup=testcontextsetup;
		this.loginpage=testcontextsetup.pageobjectmanager.getLoginPage();
		this.productpage=testcontextsetup.pageobjectmanager.getProductPage();
		
	}
	
	
	@Given("user is on Swag Labs  login page")
	public void user_is_on_swag_labs_login_page() {
		
	Assert.assertEquals(loginpage.verifyLogo(), true);
	    
	}
	
	//@DataProvider()
	@When("user enters the {string} and {string} and click on login")
	public void user_enters_the_and_and_click_on_login(String username, String password) {
	    
		loginpage.enterCredentials(username, password);
		
	}
	
	
	
	@Then("user is on product page and verify the page title should be {string}")
	public void user_is_on_product_page_and_verify_the_page_title_should_be(String Expected) {
	   // productpage.AcceptAlert();
		String Actual=productpage.getApplogo();
	    
	    Assert.assertEquals(Actual, Expected);
	}
	
	
	@When("^user select for Sorting by click on (.+)$")
	public void Sorting(String Value) {
		 
		 productpage.setSort( Value);
		
	    
	}
	@Then("^Verify sorting in (.+)$")
	public void verify_sorting_is_successful(String order) {
	  Assert.assertEquals(productpage.getAfterFilterPrices(),productpage.sortedBeforeFilterPrices(order));
	  
	}

}
