package com.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationTest {

	@BeforeSuite
	public void dbconnectionTest()
	{
		System.out.println("--BeforeSuite--");
	}
	@BeforeTest
	public void openBrowserTest()
	{
		System.out.println("-- BeforeTest--");
	}
	@BeforeClass
	public void openbTest()
	{
		System.out.println("-- BeforeClass--");
	}
	@BeforeMethod
	public void loginTest()
	{
		System.out.println("-- BeforeMethod--");
	}
	@AfterMethod
	public void logoutTest()
	{
		System.out.println("-- AfterMethod--");
	}
	@AfterMethod
	
	
	@AfterClass
	public void closebTest()
	{
		System.out.println("-- AfterClass--");
	}
	@AfterTest
	public void closeBrowserTest()
	{
		System.out.println("-- AfterTest--");
	}
	@AfterSuite
	public void closedbconnectionTest()
	{
		System.out.println("--AfterSuite--");
	}
	@Test
	public void test1Test()
	{
		System.out.println("--test1--");
	}
	
	@Test
	public void test2Test()
	{
		System.out.println("--test 2--");
	}
	
	@Test
	public void test3Test()
	{
		System.out.println("--test 3--");
	}
	
}
