package com.demo.pages;

import org.openqa.selenium.WebDriver;

public class pageObjectManager {
	
	public WebDriver driver;
	public LoginPage loginpage;
	public ProductPage productpage;
	public CartPage cartpage;
	
	
	public pageObjectManager( WebDriver driver) {
		this.driver=driver;
	}
	
	public LoginPage getLoginPage(){
		loginpage=new LoginPage(driver);
		return loginpage;
	}
	
	public ProductPage getProductPage(){
		productpage=new ProductPage(driver);
		return productpage;
	}
	
	public CartPage getCartPage(){
		cartpage=new CartPage(driver);
		return cartpage;
	}
	

}
