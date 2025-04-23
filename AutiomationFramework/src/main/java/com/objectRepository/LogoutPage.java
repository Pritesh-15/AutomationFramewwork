package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	@FindBy(id ="react-burger-menu-btn") private WebElement burgerButtonBTN;
	
	@FindBy(id="inventory_sidebar_link") private WebElement allItemsLNK;
	
	@FindBy(id="about_sidebar_link") private WebElement aboutLNK;
	
	@FindBy(id="logout_sidebar_link") private WebElement logOutLNK;
	
	@FindBy(id="reset_sidebar_link") private WebElement resetAppStateLNK;
	
	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this); //mtd to initialize elements
	}
	
	public WebElement getBurgerButton() {
		return burgerButtonBTN;
	}
	public WebElement getAllItems() {
		return allItemsLNK;
	}
	public WebElement getAbout() {
		return aboutLNK;
	}
	public WebElement getLogOutLink() {
		return logOutLNK;
	}
	public WebElement getResetAppState() {
		return resetAppStateLNK;
	}
	
}
