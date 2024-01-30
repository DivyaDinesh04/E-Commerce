package com.TestNG;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.genericUtility.ExcelUtils;
import com.genericUtility.IPathConstants;

public class DataProviderTest {

	@Test(dataProvider = "data")
	public void displayTest(String src,String dest)
	{
		System.out.println(src+" -----> "+dest);
	}
	
	@Test(dataProvider = "product")
	public void productTest(String productName, int Price)
	{
		System.out.println(productName+" -----> "+Price);
	
	}
	
	
	@DataProvider
	public Object[][] data()
	{
		Object[][] obj = new Object[3][2];
		obj[0][0] = "bangalore";
		obj[0][1] = "mysore";
		
		obj[1][0] = "pune";
		obj[1][1] = "hyd";
		
		obj[2][0] = "delhi";
		obj[2][1] = "bangalore";
		
		return obj;
		
	}
	
	@DataProvider
	public Object[][] product()
	{
		Object[][] obj = new Object[3][2];
		obj[0][0] = "samsung";
		obj[0][1] = 1000;
		
		obj[1][0] = "nokia";
		obj[1][1] = 5000;
		
		obj[2][0] = "poco";
		obj[2][1] = 8000;
		
		return obj;
	}
	
	@DataProvider
	public Object[][] readDataExcel() throws IOException
	{
		FileInputStream f = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(f);
		Sheet sh = wb.getSheet("Insert Product");
		int lastRow = sh.getLastRowNum()+1;
		short lastCel = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastRow][lastCel];
		
		for (int i = 0; i < lastRow; i++) 
		{
			for (int j = 0; j < lastCel; j++) 
			{
			obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			
			}
			
		}
		
		return obj;
		
	}
	
	@DataProvider
	public Object[][] readDataExcelGeneric() throws IOException
	{
		ExcelUtils eLib = new ExcelUtils();
		Object[][] result = eLib.readMultipleDataExcel("Insert Product");
		return result;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
