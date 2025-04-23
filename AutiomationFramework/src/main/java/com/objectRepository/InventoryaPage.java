package com.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtilities.SeleUtility;

public class InventoryaPage extends SeleUtility{
	
	
	//declaration
	@FindBy(className = "product_sort_container") private WebElement dropDownBtn;
	
	@FindBy(id="react-burger-menu-btn") private WebElement MenuBtn;
	
	@FindBy(id="logout_sidebar_link") private WebElement LogoutBtn;
	
	@FindBy(id="shopping_cart_container") private WebElement CartBtn;
	
	
	//initialization
	public InventoryaPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	//utilization using getter methods
	public WebElement getCartBtn() {
		return CartBtn;
	}

	public WebElement getMenuBtn() {
		return MenuBtn;
	}

	public WebElement getLogoutLnk() {
		return LogoutBtn;
	}

	public WebElement getDropDownBtn() {
		return dropDownBtn;
	}
	
	//Business Library
	/**
	 * this method will click on the product and return the product
	 * @param driver
	 * @param productName
	 * @return
	 */
	public String ClickOnProduct(WebDriver driver, String productName) {
		WebElement ele=driver.findElement(By.xpath("//div[.='"+productName+"']"));
		String prdDetails=ele.getText();
		ele.click();
		
		return prdDetails;
		
	}
	
	/**
	 * this method will click on lowest priced product and return the product details to caller
	 * @param driver
	 * @param ProductName
	 * @param SortName
	 * @return
	 */
	public String ClickOnLowestPriceProduct(WebDriver driver, String ProductName, String SortName) {
		
		dropDown(dropDownBtn, SortName);
		WebElement ele=driver.findElement(By.xpath("//div[text()='"+ProductName+"']"));//"//div[.='"+PRODUCT+"']"
		String prdDetails=ele.getText();
		ele.click();
		return prdDetails;
	}
	
	/**
	 * this method will perform logout operation
	 */
	public void logoutOfApp() {
		
		MenuBtn.click();
		LogoutBtn.click();
		
	}
	
	/**
	 * this method will click on cart option
	 */
	public void clickOnCartContainer() {
		
		CartBtn.click();
	}
	

}
