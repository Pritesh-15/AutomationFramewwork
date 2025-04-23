package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseSix {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		WebElement product = driver.findElement(By.xpath("//div[.='Sauce Labs Bolt T-Shirt']"));
		String addedp = product.getText();
		product.click();
		Thread.sleep(2000);
		
		
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		Thread.sleep(2000);
		
		WebElement productcart = driver.findElement(By.xpath("//div[.='Sauce Labs Bolt T-Shirt']"));
		String cartp = productcart.getText();
		
		Thread.sleep(2000);
		
		if(addedp.equals(cartp)) {
			System.out.println("test case pass");
			System.out.println(cartp);
		}
			else {
				System.out.println("test case fail");
		}
		
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("logout_sidebar_link")).click();
	}
}


