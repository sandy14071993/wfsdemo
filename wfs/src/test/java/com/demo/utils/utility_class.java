package com.demo.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

public class utility_class {
	
	public WebDriver driver;
	
	public utility_class(WebDriver driver) {
		this.driver=driver;
	}
	
	
	
	public static String UserProperty(String PropertyName) throws IOException {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
			Properties prop=new Properties();
			prop.load(fis);
			return prop.getProperty(PropertyName);
		}
	@DataProvider(name="credentials")
	public static Object[][] getData() throws IOException{
		excel_utility excel=new excel_utility(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\TestData.xlsx");
		Object[][] data=excel.array("loginCredentials");
		return data;
	}
	
	public static WebDriverWait getExplicitWait(WebDriver driver) {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait;
	}

	public static byte[] getScreenShot(WebDriver driver) {
		
		byte[] screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		return screenshotFile;
	}
}
