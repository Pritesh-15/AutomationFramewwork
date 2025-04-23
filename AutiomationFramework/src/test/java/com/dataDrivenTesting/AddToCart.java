package com.dataDrivenTesting;



import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.genericUtilities.FileUtility;
import com.genericUtilities.JavaUtility;
import com.genericUtilities.SeleUtility;
import com.objectRepository.LoginPage;
import com.objectRepository.LogoutPage;

//using all utility files
public class AddToCart {

	@Test
	public static void main(String[] args) throws IOException {
		//create object of all utility class
		FileUtility fUtil= new FileUtility();
		JavaUtility jUtil= new JavaUtility();
		SeleUtility sUtil= new SeleUtility();
		
		//read common data from property file
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		//read data from excel file
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Sheet1", 1, 2);
		
		//launch the browser
		WebDriver driver=new EdgeDriver();
		sUtil.maxWindow(driver);
		sUtil.implictWait(driver, 20);
		
		
		//load the application 
		driver.get(URL);
		
		//login to application
		//driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		//driver.findElement(By.id("password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("login-button")).click();
		
		
		//login by using POM class
		LoginPage lginp=new LoginPage(driver);
		lginp.getUsernameEDT().sendKeys(USERNAME);
		lginp.getPasswordEDT().sendKeys(PASSWORD);
		lginp.getLoginBTN().click();
		
		
		//selecting the product 
		WebElement product = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
		String addedp = product.getText();
		product.click();
		
		//add product to cart
		driver.findElement(By.id("add-to-cart")).click();
		
		//move to cart
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		
		
		//screenshot for reference
		String screenshotname = "TC_001"+jUtil.getSystemDateInFormat();
		String path = sUtil.captureScreenShot(driver, screenshotname);
		
		
		//validate the product
		WebElement productcart = driver.findElement(By.xpath("//div[.='Sauce Labs Backpack']"));
		String cartp = productcart.getText();
		
		if(addedp.equals(cartp)) {
			System.out.println("test case pass");
			System.out.println(cartp);
		}
		else {
			System.out.println("test case fail");
		}
		
		//logout from application
		//driver.findElement(By.id("react-burger-menu-btn")).click();
		//driver.findElement(By.id("logout_sidebar_link")).click();
		
		LogoutPage lgotp=new LogoutPage(driver);
		lgotp.getBurgerButton().click();
		lgotp.getLogOutLink().click();
		
	}

}
