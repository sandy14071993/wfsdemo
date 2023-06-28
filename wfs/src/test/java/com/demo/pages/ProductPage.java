package com.demo.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.demo.utils.utility_class;

public class ProductPage extends BasePage {
	
	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[text()=\"Swag Labs\"]")
	WebElement appLogo;
	
	@FindBy(xpath="//button[text()=\"Add to cart\"]")
	List<WebElement> AddToCart_Buttons;
	
	@FindBy(xpath="//span[@class=\"shopping_cart_badge\"]")
	WebElement cartBadge;
	
	@FindBy(xpath="//Select[@class=\"product_sort_container\"]")
	WebElement productSort;
	
	@FindBy(xpath="//div[@class=\"inventory_item_price\"]")
	List<WebElement> priceBeforeFilter;
	
	@FindBy(xpath="//div[@class=\"inventory_item_price\"]")
	List<WebElement> priceAfterFilter;
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	WebElement backpackAddcart;
	
	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	WebElement bikelightAddcart;
	
	@FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
	WebElement bolt_tshirtAddcart;
	
	@FindBy(id="add-to-cart-sauce-labs-fleece-jacket")
	WebElement fleecejacketAddcart;
	
	@FindBy(id="add-to-cart-sauce-labs-onesie")
	WebElement onesieAddcart;
	
	@FindBy(id="add-to-cart-test.allthethings()-t-shirt-(red)")
	WebElement allthingstshirtAddcart;
	
	
	
	
	
	
	
	
	public String getApplogo() {
		try {
			return (appLogo.getText());
		}
		catch(Exception e) {
			return (e.getMessage());
		}
		
	}
	
	public void backpackAddcart() {
		backpackAddcart.click();
	}
	
	public void bikelightAddcart() {
		bikelightAddcart.click();
	}
	
	public void bolt_tshirtAddcart() {
		bolt_tshirtAddcart.click();
	}
	public void fleecejacketAddcart() {
		fleecejacketAddcart.click();
	}
	
	public void allthingstshirtAddcart() {
		allthingstshirtAddcart.click();
	}
	
	public void onesieAddcart() {
		onesieAddcart.click();
	}
	
	public void setSort(String value) {
		Select sort=new Select(productSort);
		sort.selectByVisibleText(value);
	}
	
	
	
	public List<Double> sortedBeforeFilterPrices(String order) {
		
		try {
		List<Double> beforeFilterList=new ArrayList<Double>();
		
		for(WebElement p:priceBeforeFilter)
		{
			beforeFilterList.add(Double.valueOf(p.getText().replace("$", "")));
		}
		if(order.equalsIgnoreCase("ascending")) {
			Collections.sort(beforeFilterList);
	
		}
		else if(order.equalsIgnoreCase("descending")) {
			Collections.sort(beforeFilterList);
			Collections.reverse(beforeFilterList);
		}
		return beforeFilterList;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Double> getAfterFilterPrices() {
		
		try {
		List<Double> AfterFilterList=new ArrayList<Double>();
		for(WebElement p:priceAfterFilter)
		{
			AfterFilterList.add(Double.valueOf(p.getText().replace("$", "")));
		}
		
		return AfterFilterList;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void AcceptAlert() {
        try {
        	utility_class.getExplicitWait(driver).until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
}
