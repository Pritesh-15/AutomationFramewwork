package com.genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.objectRepository.InventoryaPage;
import com.objectRepository.LoginPage;

/**
 * this class consists of basic configuration annotation of testNG
 */

public class BaseClass {
	
	public FileUtility futil=new FileUtility();
	public JavaUtility jutil=new JavaUtility();
	public SeleUtility sutil=new SeleUtility();
	
	
	public WebDriver driver;
	
	//for listeners
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig() {
		
		System.out.println("----DB Connection Successfull----");
		
	}
	
	
	//@Parameters("Browser")
	//@BeforeTest(alwaysRun = true)  //beforetest for parallel execution one browser will open at test level and 
									//under that classes will run
	@BeforeClass(alwaysRun = true)
	public void bcConfig() throws IOException {
		
		String URL = futil.readDataFromPropertyFile("url");
		
		driver=new ChromeDriver();
		
		
		//for cross browser execution S 
//		if(vPara.equals("edge")) {
//			driver=new EdgeDriver();
//			
//		}
//		else if (vPara.equals("chrome")) {
//			driver=new ChromeDriver();
//			
//		}
//		else {
//			driver=new ChromeDriver();
//		}
		
		
		sutil.maxWindow(driver);
		sutil.implictWait(driver, 20);
		
		driver.get(URL);
		
		System.out.println("----Browser launch Successfull----");
		
		//for listeners
		sdriver=driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException {
		
		String USERNAME = futil.readDataFromPropertyFile("username");
		String PASSWORD=futil.readDataFromPropertyFile("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("----login to App Successfull----");
		
		//sutil.handleAcceptAlert(driver);
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() {
		
		InventoryaPage ip=new InventoryaPage(driver);
		ip.logoutOfApp();
		
		System.out.println("----logout from App Successfull----");
		
	}
	
	//@AfterTest(alwaysRun = true)
	@AfterClass(alwaysRun = true)
	public void acConfig() {
		
		driver.quit();
		
		System.out.println("----Browser closed Successfull----");
		
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig() {
		
		System.out.println("----DB Connection closed Successfull----");
		
	}
	
}
