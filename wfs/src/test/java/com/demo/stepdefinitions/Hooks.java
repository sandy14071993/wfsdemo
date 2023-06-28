package com.demo.stepdefinitions;

import java.io.IOException;

import com.demo.testBase.TestContextSetup;
import com.demo.utils.utility_class;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {
	
	TestContextSetup testcontextsetup;
	
	public Hooks(TestContextSetup testcontextsetup) {
		this.testcontextsetup=testcontextsetup;
	}
	
	@After
	public void AfterScenario() throws IOException {
		testcontextsetup.baseclass.WebDriverManager().quit();
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException {
		
		if(scenario.isFailed()) {
			scenario.attach(utility_class.getScreenShot(testcontextsetup.baseclass.WebDriverManager()), "image/png", "image");
		}
		
	}
	
	
	

}
