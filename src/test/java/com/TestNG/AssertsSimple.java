package com.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertsSimple {

	@Test
	public void hardTest()
	{
		int x = 5;
		if(x==0) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
		Assert.assertNotNull(x); //x should not be null true
		System.out.println(" -- line-1 --");
		System.out.println(" -- line-2 --");
		
		Assert.assertNull(x);//error
		System.out.println(" -- line-3 --"); //not executed
		System.out.println(" -- line-4 --"); //not executed
	}
	
	@Test
	public void softTest()
	{
		int x = 5;
		SoftAssert sa = new SoftAssert();
		sa.assertNotNull(x);
		System.out.println(" -- line-5 --");
		System.out.println(" -- line-6 --");
		
		sa.assertNull(x);//error
		System.out.println(" -- line-7 --");
		System.out.println(" -- line-8 --");
		sa.assertAll();
		
	}


}
