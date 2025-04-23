package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage {
	
	//declaration
	@FindBy(id="add-to-cart") private WebElement addCartBtn;
	
	//initialization
	public InventoryItemPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getAddCartBtn() {
		return addCartBtn;
	}
	
	/**
	 * this method will click on add to cart button
	 * 
	 */
	public void addToCartBtn() {
		addCartBtn.click();
	}
}
