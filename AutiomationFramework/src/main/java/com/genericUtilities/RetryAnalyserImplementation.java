package com.genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation implements IRetryAnalyzer {
	
	int count =0;
	int rtry=3; //manual analysis
	
	public boolean retry(ITestResult result) {
		
		while(count<rtry) {
			count ++;
			return true;
		}
		
		return false;
	}

}
