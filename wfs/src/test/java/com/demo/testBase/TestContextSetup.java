package com.demo.testBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.demo.pages.pageObjectManager;
import com.demo.utils.utility_class;

public class TestContextSetup {
	
	public WebDriver driver;
	public baseClass baseclass;
	public pageObjectManager pageobjectmanager;
	public utility_class utilityclass;
	
	public TestContextSetup() throws IOException {
		baseclass=new baseClass();
		pageobjectmanager=new pageObjectManager(baseclass.WebDriverManager());
		utilityclass=new utility_class(baseclass.WebDriverManager());
		
		
	}
	

}
