package com.inventoryTest;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericUtilities.BaseClass;
import com.genericUtilities.FileUtility;
import com.genericUtilities.JavaUtility;
import com.genericUtilities.SeleUtility;
import com.objectRepository.CartPage;
import com.objectRepository.InventoryItemPage;
import com.objectRepository.InventoryaPage;
import com.objectRepository.LoginPage;


//@Listeners(com.genericUtilities.ListenersImplementation.class)
public class AddtoCartTest extends BaseClass{
	
	@Test
	public void tc_001_AddtoCartTest() throws IOException {

		//read data from excel file
		String PRODUCTNAME = futil.readDataFromExcelFile("Sheet1", 1, 2);
		
		//click on a product
		InventoryaPage ip=new InventoryaPage(driver);
		String pInCart = ip.ClickOnProduct(driver, PRODUCTNAME);
		
		//add product to cart
		InventoryItemPage iip=new InventoryItemPage(driver);
		iip.addToCartBtn();
		
		//navigate to cart
		ip.clickOnCartContainer();
		
		//validate product in cart
		CartPage cp=new CartPage(driver);
		String addedProduct = cp.getProductName();
		
		
		Assert.assertEquals(addedProduct, pInCart);
		
		//other option if contains a contains b
		Assert.assertTrue(pInCart.equals(addedProduct));
		System.out.println(addedProduct);
		System.out.println("PASS");
		
		
//		if (addedProduct.equals(pInCart)) {
//			System.out.println("PASS");
//			System.out.println(addedProduct);
//		} else {
//			System.out.println("FAIL");
//		}
		
	}
}
