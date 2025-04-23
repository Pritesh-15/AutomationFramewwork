package com.dataDrivenTesting;

import java.time.Duration;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;

import com.genericUtilities.FileUtility;

import java.util.*;

//Reading common Data from property file
public class TestOne extends FileUtility{

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//read data from properties files
		//FileInputStream file=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		//Properties p=new Properties();
		//p.load(file);
		//String URL=p.getProperty("url");
		//String USERNAME= p.getProperty("username");
		//String PASSWORD= p.getProperty("password");

		//calling from parent class
		String URL= readDataFromPropertyFile("url");
		String USERNAME= readDataFromPropertyFile("username");
		String PASSWORD= readDataFromPropertyFile("password");
		
		
		
		
		//reading testdata from excel file
		//FileInputStream excelfile=new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
		//Workbook wb=WorkbookFactory.create(excelfile);	
		//String PRODUCT = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		//String FIRSTNAME = wb.getSheet("Sheet1").getRow(7).getCell(3).getStringCellValue();
		//String LASTNAME = wb.getSheet("Sheet1").getRow(7).getCell(4).getStringCellValue();
		//double POSTALCODE = wb.getSheet("Sheet1").getRow(7).getCell(5).getNumericCellValue();
		//int POSTALCODE_STRING = String.valueOf((int)POSTALCODE);
		
		//calling from parent class
		String PRODUCT = readDataFromExcelFile("Sheet1",1,2);
		String FIRSTNAME = readDataFromExcelFile("Sheet1",7,3);
		String LASTNAME = readDataFromExcelFile("Sheet1",7,4);
		
			
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		
	
		
		Thread.sleep(1000);
		WebElement product = driver.findElement(By.xpath("//div[.='"+PRODUCT+"']"));
		String addedp = product.getText();
		product.click();
		Thread.sleep(1000);
		
		
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		Thread.sleep(1000);
		
		WebElement productcart = driver.findElement(By.xpath("//div[.='Sauce Labs Backpack']"));
		String cartp = productcart.getText();
		
		Thread.sleep(1000);
		
		if(addedp.equals(cartp)) {
			System.out.println("test case pass");
			System.out.println(cartp);
		}
		else {
			System.out.println("test case fail");
		}
		
		
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys(FIRSTNAME);
		driver.findElement(By.id("last-name")).sendKeys(LASTNAME);
		//driver.findElement(By.id("postal-code")).sendKeys(POSTALCODE);
		Thread.sleep(1000);
		
		
		driver.findElement(By.id("finish")).click();
		driver.findElement(By.id("back-to-products")).click();
		Thread.sleep(1000);
		
		
		
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("logout_sidebar_link")).click();
	}
}


