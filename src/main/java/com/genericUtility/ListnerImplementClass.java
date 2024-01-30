package com.genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementClass implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		//Test Script execution starts here
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		Reporter.log(methodName+" Execution Started", true);
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+" Pass ");
		Reporter.log(methodName+" Executed Successfully ");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		try 
		{
			String path = WebDriverUtils.takeScreenshot(BaseClass.sdriver, methodName);
			test.addScreenCaptureFromPath(path);
			test.log(Status.FAIL, methodName+" Failed ");
			test.log(Status.FAIL, result.getThrowable());
			Reporter.log(methodName+"--->failed");
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
	}

	
	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+" Skipped ");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+" --> Skipped");
	
	}

	@Override
	public void onStart(ITestContext context) 
	{
		//configure report
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\extentReport\\report.html");
		htmlReport.config().setDocumentTitle("Shopping Application");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setReportName("ZeelShopee");
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Platform", "OS");
		report.setSystemInfo("Base Browser", "chrome");
		report.setSystemInfo("Base-URL", "http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
		report.setSystemInfo("ReporterName", "Divya");
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		report.flush();
	 
	}

	
	
	
	
	
}
