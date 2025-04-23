package com.genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.FileHandler;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of generic method related to selenium tool
 */

public class SeleUtility {
	
	public void maxWindow(WebDriver driver) 
	{
		driver.manage().window().maximize();
	}
	
	public void minWindow(WebDriver driver) 
	{
		driver.manage().window().minimize();
	}
	
	public void implictWait(WebDriver driver, int time) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	
	/**
	 * wait for particular element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForEmlementTobeVisible(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	
	/**
	 * wait for particular element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForEmlementTobeClickable(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	
	
	/**
	 * these method will handle dropdowns
	 * @param element
	 * @param selvalue
	 */
	//dropdown for visible text
	public void dropDown(WebElement element, String visibletext) 
	{
		Select select=new Select(element);
		select.selectByVisibleText(visibletext);
	}
	//dropdown from value
	public void dropDown(String selvalue, WebElement element) 
	{
		Select select=new Select(element);
		select.selectByValue(selvalue);
	}
	//dropdown for index
	public void dropDown(WebElement element, int index) 
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	
	/**
	 * these methods will used for actions
	 * @param driver
	 * @param element
	 */
	//for click on element
	public void actionClick(WebDriver driver, WebElement element) {
		Actions action=new Actions(driver);
		action.click(element).perform();
	}
	//for doubleclicking
	public void actionDoubleClick(WebElement element, WebDriver driver) {
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
		
	}
	//for move to target element
	public void actionMoveToTargetElement(WebDriver driver, WebElement targetEle) {
		Actions action=new Actions(driver);
		action.moveToElement(targetEle);
		
	}
	//for context click
	public void actionContextClick(WebDriver driver, WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element);
		
	}
	//for drag and drop
	public void actionDragDrop(WebDriver driver, WebElement sourcetEle, WebElement targetEle) {
		Actions action=new Actions(driver);
		action.dragAndDrop(sourcetEle, targetEle);
		
	}
    //for scrolling
	public void actionScroll(WebDriver driver, WebElement element) {
		Actions action=new Actions(driver);
		action.scrollToElement(element);
		
	}
	
	
	/**
	 * these methods will used for handling frames
	 * @param driver
	 * @param index
	 */
	public void handlingFrame(WebDriver driver,  int index) {
		driver.switchTo().frame(index);
	}
	
	public void handlingFrame(String name, WebDriver driver) {
		driver.switchTo().frame(name);
	}
	
	public void handlingFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
		
	}
	// this method will switch to immediate parent
	public void switchToParent(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	//this method will switch to main page ignoring all parent
	public void switchToDefault(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	
	/**
	 * this method will be used to move to another window
	 * @param driver
	 */
	public void moveToWindow(WebDriver driver) {
		String windowid = driver.getWindowHandle();
		driver.switchTo().window(windowid);
	}
	
	
	/**
	 * These methods will handle alerts
	 * @param driver
	 */
	public void handleAlert(WebDriver driver) {
		driver.switchTo().alert();
	}
	
	public void handleAcceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void handleDismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	//this method will return alert text to caller
	public String getTextFromAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	public void sendTextToAlert(WebDriver driver, String keys) {
		driver.switchTo().alert().sendKeys(keys);
	}
	
	
	
	/**
	 * these method will be used for scrolling by javascript executer
	 * @param driver
	 */
	public void scrollDown(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500);","");
	}
	
	public void scrollUp(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-500);","");
	}
	public void scrollRight(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(500,0);","");
	}
	public void scrollLeft(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(-500,0);","");
	}
	
	
	/**
	 * this method is used to take screenshot
	 * @param driver
	 * @param screenShotName
	 * @return 
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver, String screenShotName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshots\\"+screenShotName+".png"); //tsname_date_name --> as per company standards
		org.openqa.selenium.io.FileHandler.copy(scr, dst);
		return screenShotName;
		
		
	}
	
	
}
















