package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	//declaration
	@FindBy(id="checkout") private WebElement checkOutBtn;
	
	@FindBy(className ="inventory_item_name") private WebElement itemInfo;
	
	@FindBy(id="remove-sauce-labs-backpack") private WebElement removeBtn;
	
	//initialization
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization using getter methods
	public WebElement getCheckOutBtn() {
		return checkOutBtn;
	}
	
	public WebElement getItemInfo() {
		return itemInfo;
	}
	
	public WebElement getremoveBtn() {
		return removeBtn;
	}
	
	//business library
	/**
	 * 
	 * this method will capture the product name 
	 * @return
	 */
	public String getProductName() {
		return itemInfo.getText();
	}
	
	
	

}
