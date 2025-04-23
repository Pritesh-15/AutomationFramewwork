package com.genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListner interface of testNG
 * 
 */

public class ListenersImplementation implements ITestListener{

	
	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+" @test execution started");
		
		//intimate extent report for test
		test = report.createTest(methodname);
		
	}


	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+" @test execution success");
		
		//Log the Test result as PASS in Extent Report
		test.log(Status.PASS, methodname + " -> @Test is pass");
	
	}

	
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+" @test execution fail");
		
		//Log the status as FAIL in extent report
		test.log(Status.FAIL, methodname+" @test execution fail");
			
		//capture exception
		System.out.println(result.getThrowable());
		
		//Log the exception in extent report
		test.log(Status.WARNING, result.getThrowable());
		
		//capture screenshot
		SeleUtility s=new SeleUtility();
		JavaUtility j=new JavaUtility();
		
		String ssName= methodname+"-"+j.getSystemDateInFormat();
		
		try 
		{
			String path = s.captureScreenShot(BaseClass.sdriver, ssName);
			
			//Attach the screenshot to extent reports
			test.addScreenCaptureFromPath(path);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}		
	
	}


	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+" @test execution skip");
		
		//Log the status as Skip in extent report
		test.log(Status.SKIP, methodname + " -> @Test is skip");

		// Capture the exception
		System.out.println(result.getThrowable());
				
		//Log the exception in extent report
		test.log(Status.WARNING, result.getThrowable());
		
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}


	public void onStart(ITestContext context) {
		
		System.out.println("Suite Execution Started");
		
		//Configure the extent reports
        ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReports\\Report - "+new JavaUtility().getSystemDateInFormat()+".html");
		esr.config().setDocumentTitle("Swag labs Execution report");
		esr.config().setReportName("Execution Report");
		esr.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Env", "Testing");
		report.setSystemInfo("Reporter name", "Pritesh");
		
	}


	public void onFinish(ITestContext context) {
		
		System.out.println("Suite Execution Finished");
		
		//Generate extent reports
		report.flush();
		
	}
	
}
