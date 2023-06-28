package com.demo.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/resources/features",
		glue="com.demo.stepdefinitions",
		monochrome=true,
		dryRun=false,
		tags="",
		plugin= {"html:target/cucumber.html",
				  "json:target/cucumber.json",
				  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				  "rerun:target/failed-scenarios.txt"}
		
		)

public class testNg_Runner extends AbstractTestNGCucumberTests {
	
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
	
	
	
	
	
	
	
	
}
