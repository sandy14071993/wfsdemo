package com.demo.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="@target/failed-scenarios.txt",
		glue="com.demo.stepdefinitions",
		monochrome=true,
		plugin= {"html:target/cucumber.html",
				  "json:target/cucumber.json",
				  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				 }
		
		)

public class failedtestNg_Runner extends AbstractTestNGCucumberTests {
	
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
	
	
	
	
	
	
	
	
}
