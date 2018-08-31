package com.hcm.vbts.listeners;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListener implements ITestListener, ISuiteListener, IInvokedMethodListener {

	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
	
		
	}

	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		
		
	}

	public void onStart(ISuite arg0) {
		Reporter.log("Execution Begining Suite: < " + arg0.getName()+ " >" , true);
		
	}

	public void onFinish(ISuite arg0) {
		Reporter.log("Execution Ending Suite: < " + arg0.getName()+ " >" , true);
		
	}

	public void onTestStart(ITestResult result) {
		

		Reporter.log("\n", true);
		Reporter.log("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++", true);
		Reporter.log("TEST----------->>::::|| " + result.getName() + " ||:::: " + DateandTime(), true);
		Reporter.log("-------------------------------------------------------------------------------", true);
		
	}

	public void onTestSuccess(ITestResult result) {
		printTestResults(result);
		
	}

	public void onTestFailure(ITestResult result) {
		printTestResults(result);
		
	}

	public void onTestSkipped(ITestResult result) {
		printTestResults(result);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		printTestResults(result);
		
	}

	public void onStart(ITestContext arg0) {
		Reporter.log("Execution Begining Test: < " + arg0.getName()+ " >" , true);
		
	}

	public void onFinish(ITestContext arg0) {
		Reporter.log("Completed Executing Test:< " + arg0.getName()+ " >", true);
		
	}
	
	private void printTestResults(ITestResult result) {

		Reporter.log("Test Method Resides in " + result.getTestClass().getName(), true);
		
	

		if (result.getParameters().length != 0) {

			String params = null;

			for (Object parameter : result.getParameters()) {

				params += parameter.toString() + ",";

			}

			Reporter.log("Test Method had the following parameters : " + params, true);

		}

		String status = null;

		switch (result.getStatus()) {

		case ITestResult.SUCCESS:

			status = "PASSED";

			break;

		case ITestResult.FAILURE:

			status = "FAILED";

			break;

		case ITestResult.SKIP:

			status = "SKIPPED";

		}
		

		Reporter.log("-------------------------------------------------------------------------------",true);
		Reporter.log("DONE==>>----<< "+result.getName()+" >>",true);
		Reporter.log("R E S U L T--->>::::::::TEST "+status+" ::::::::: "+DateandTime(),true);
		Reporter.log("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++",true);

	}
	
	public String DateandTime() {
		Date d = new Date();
		DateFormat dformat = new SimpleDateFormat("dd-MM-yyyy-hh:mm:ss ");
		String date = dformat.format(d);
		return date;
	}

}
