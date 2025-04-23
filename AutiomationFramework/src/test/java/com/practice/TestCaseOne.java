package com.practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.genericUtilities.FileUtility;
import com.genericUtilities.JavaUtility;
import com.genericUtilities.SeleUtility;
import com.objectRepository.LoginPage;

public class TestCaseOne {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		FileUtility fUtil= new FileUtility();
		JavaUtility jUtil= new JavaUtility();
		SeleUtility sUtil= new SeleUtility();
		
		WebDriver driver = new ChromeDriver();
		sUtil.maxWindow(driver);
		sUtil.implictWait(driver, 20);
		
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		String URL = fUtil.readDataFromPropertyFile("url");
		
		driver.get(URL);
		
		LoginPage lp=new LoginPage(driver);
		lp.getUsernameEDT().sendKeys(USERNAME);
		lp.getPasswordEDT().sendKeys(PASSWORD);
		lp.getLoginBTN().click();
		
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		
		driver.findElement(By.id("checkout")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("first-name")).sendKeys("pritesh");
		driver.findElement(By.id("last-name")).sendKeys("agrawal");
		driver.findElement(By.id("postal-code")).sendKeys("425001");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("back-to-products")).click();
	}

}
