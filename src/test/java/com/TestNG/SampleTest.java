package com.TestNG;

import org.testng.annotations.Test;

import com.genericUtility.BaseClass;

public class SampleTest extends BaseClass{

	@Test(groups = "smoke")
	public void sample1Test()
	{
		System.out.println(" -- sample1Test --");
	}
	
	@Test(groups = "regression")
	public void sample2Test()
	{
		System.out.println(" -- sample2Test--");
	}
}
