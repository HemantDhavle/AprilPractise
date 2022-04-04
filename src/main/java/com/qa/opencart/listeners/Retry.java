package com.qa.opencart.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	private int count = 0;
	private static int maxTry = 3;
	@Override
	public boolean retry(ITestResult iTestResult) {
		//check if the test is not success
		if(!iTestResult.isSuccess())
		{
			//check if max count which is 3 reached
			if(count<maxTry)
			{
				//increment the count by 1 whenever test is failed
				count++;
				//mark the test as failed
				iTestResult.setStatus(ITestResult.FAILURE);
				//test TestNG to re-run the test
				return true;
			}
			else
			{
				//if the max count reached failed the test case
				iTestResult.setStatus(ITestResult.FAILURE);
			}
			}
		else
		{
			//if the test passed, TestNG marks it as passed
			iTestResult.setStatus(ITestResult.SUCCESS);
		}
		return false;
	}

}
