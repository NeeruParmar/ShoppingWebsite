package com.automationWebsite.retryLogic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.automationWesiteBasePackage.TestBase;

public class RetryFailedTestCases extends TestBase implements IRetryAnalyzer{
	
	//Intial value when count start
	int counter=1; 
	
	//max retry attempts
	int maxCount=3; 

	@Override
	public boolean retry(ITestResult result) {
logger.info("Trying failed Test Case " + counter +" times");
		
		if(counter<maxCount) {
			counter++;
			return true;
		}
		
		
		return false;
	}

}
