package com.TestNG;

import org.testng.annotations.Test;

public class DPExecutionTest {

	@Test(dataProviderClass = DataProviderTest.class,dataProvider = "product")
	public void executeDPTest(String productName, int Price)
	{
		System.out.println(productName+" -----> "+Price);
	}
	
	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "readDataExcel")
	public void readDataFromExcel(String path, String value)
	{
		System.out.println(path+" ----> "+value);
	}
	
	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "readDataExcelGeneric")
	public void readDataFromExcelGeneric(String path, String value)
	{
		System.out.println(path+" ----> "+value);
	}
}
