package com.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	

    /**
     * This method is used to 
     * @param SheetName
     * @param rowNo
     * @param cellno
     * @return
     * @throws EncryptedDocumentException
     * @throws IOException
     */
	public String readDataFromExcel(String SheetName,int rowNo, int cellno) throws EncryptedDocumentException, IOException
	{	
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb =WorkbookFactory.create(fis);
		String data = wb.getSheet(SheetName).getRow(rowNo).getCell(cellno).getStringCellValue();
		return data;
	}
	
	/**
	 * This method is used to return last row number
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getLastRowNumber(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb =WorkbookFactory.create(fis);
		int lastRowCount = wb.getSheet(sheetName).getLastRowNum();
		return lastRowCount;
	}
	
	/**
	 * This method is used to get the data from excel file as key and value pair i.e,Hashmap
	 * @param sheetName
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public HashMap<String, String> HashMapData(String sheetName, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb =WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRowCount = sh.getLastRowNum();
		
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0; i<lastRowCount;i++) 
		{
			String key = sh.getRow(i).getCell(cell).getStringCellValue();
			String value = sh.getRow(i).getCell(cell+1).getStringCellValue();
			map.put(key, value);
		}
		
		return map;
	}
	
	/**
	 * This method is used to Write data into excel file
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetName,int rowNo,int cellNo, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb =WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		sh.createRow(rowNo).createCell(cellNo).setCellValue(data);
		FileOutputStream fo = new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fo);
		wb.close();
		
	}
	
	public static void wrireDataintoExcel(String SheetName, int row, int cell, String data,String value) throws Throwable {
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		sh.createRow(row).createCell(cell).setCellValue(data);
		sh.getRow(row).createCell(cell+1).setCellValue(value);
		FileOutputStream fos = new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fos);
		wb.close();
	}
	
	public Object[][] readMultipleDataExcel(String SheetName) throws EncryptedDocumentException, IOException
	{	
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb =WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
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
	
	

}
