package com.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementationClass implements IRetryAnalyzer {

	int count = 0;
	int retryCount = 4;
	@Override
	public boolean retry(ITestResult result) {
		
		if(count<retryCount) 
		{
			count++;
			return true;
		}
		return false;
	}
	
	

}
