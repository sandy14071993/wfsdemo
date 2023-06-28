package com.demo.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.demo.utils.utility_class;

import io.cucumber.messages.types.Duration;

public class baseClass {
	
	
	public WebDriver driver;
	
	
	
	public WebDriver WebDriverManager() throws IOException
	{
		
		
		String url=utility_class.UserProperty("url");
		String browser=utility_class.UserProperty("browser");
		
		
		if(driver == null)
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//test//resources//drivers//chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		 options.addArguments("--remote-allow-origins=*");
		 driver=new ChromeDriver(options);
		//driver = new ChromeDriver();// driver gets the life
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//src//test//resources//drivers//geckodriver.exe");
				//FirefoxOptions options=new FirefoxOptions();
				// options.addArguments("--remote-allow-origins=*");
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("edge"))
			{
				System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"//src//test//resources//drivers//msedgedriver.exe");
				EdgeOptions options=new EdgeOptions();
				 options.addArguments("--remote-allow-origins=*");
				driver = new EdgeDriver(options);
			}
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
		}
		
		return driver;
		
	}
	
	
	/*@BeforeClass
	//@Parameters({"Browser"})
	public void setUp() throws IOException {
		
		//String url=utility_class.UserProperty("url");
		
				 ChromeOptions options=new ChromeOptions();
				 options.addArguments("--remote-allow-origins=*");
				 driver=new ChromeDriver(options);	
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driver.get("https://www.saucedemo.com/");
				
				driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}*/

	

}
