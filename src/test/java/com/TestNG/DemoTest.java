package com.TestNG;

import org.testng.annotations.Test;

import com.genericUtility.BaseClass;

public class DemoTest extends BaseClass{

	@Test(groups = "smoke")
	public void demo1Test()
	{
		System.out.println(" -- demo1Test --");
	}
	
	@Test(groups = {"smoke","regression"})
	public void demo2Test()
	{
		System.out.println(" -- demo2Test --");
	}
}
