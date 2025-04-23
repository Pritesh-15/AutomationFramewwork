package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//rule 1 create separate class for each page in application
	
	/**
	 * 
	 * rule 2 identify all web elements on that page using annotations @findby, @findbys, @findall
	 * for single webelement use only WebElement 
	 * for multiple webelements use LIST<WebElement>
	 *
	 *///declaration
	@FindBy(id="user-name") 
	private WebElement usernameEDT;
	
	@FindBy(id="password") 
	private WebElement passwordEDT;
	
	@FindBy(id="login-button") 
	private WebElement loginBTN;
	
	
	//rule 3 create a constructor to initialize webelements //initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this); //mtd to initialize elements
	}

	
	//rule 4 provide getters to access the webelements //utilization
	public WebElement getUsernameEDT() {
		return usernameEDT;
	}


	public WebElement getPasswordEDT() {
		return passwordEDT;
	}


	public WebElement getLoginBTN() {
		return loginBTN;
	}
	
	/**
	 * This method will perform login operation
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username, String password )
	{
		usernameEDT.sendKeys(username);
		passwordEDT.sendKeys(password);
		loginBTN.click();
	}
}











