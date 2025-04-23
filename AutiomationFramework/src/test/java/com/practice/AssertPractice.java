package com.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertPractice {
	
	
	@Test
	public void sample190(){
		
		System.out.println("step 1");
		System.out.println("step 2");
		
		Assert.assertEquals(0, 1);
		
		System.out.println("step 3");
		System.out.println("step 4");
		
	}
	
	@Test
	public void sample2() {
		
		 SoftAssert sa= new SoftAssert();
		System.out.println("step 1");
		System.out.println("step 2");
		
		sa.assertEquals(0, 1);
		
		System.out.println("step 3");
		System.out.println("step 4");
		
		sa.assertAll();//to know the reason of failure it gives log of failure
		
		
	}

}
