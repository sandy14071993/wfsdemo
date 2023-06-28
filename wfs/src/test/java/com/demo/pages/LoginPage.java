package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
    @FindBy(xpath="//div[@class=\"login_logo\"]")
    private WebElement loginLogo;
	
	@FindBy(id="user-name") 
	WebElement username;
	
	@FindBy(id="password") 
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement login;
	
	
	
	@FindBy(xpath="//div[@class=\"error-message-container error\"]")
	WebElement errorMSG;
	
	public boolean verifyLogo() {
	try {		
		return (loginLogo.isDisplayed());
	}
	catch(Exception e) {
		e.printStackTrace();
		return false;
	}
		
	}
	
	public void enterCredentials(String name, String pwd) {
		username.sendKeys(name);
		password.sendKeys(pwd);
		login.click();
	}
	
	public String geterrorMessege() {
		return errorMSG.getText();
	}
	
	
	
	
	
}
