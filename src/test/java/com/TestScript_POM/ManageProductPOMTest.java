package com.TestScript_POM;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepository.AdminHomePage;
import com.ObjectRepository.CreateCategoryPage;
import com.ObjectRepository.InsertProductPage;
import com.ObjectRepository.ManageProductPage;
import com.ObjectRepository.SubCategoryPage;
import com.genericUtility.BaseClass;


//@Listeners(com.genericUtility.ListnerImplementClass.class)
public class ManageProductPOMTest extends BaseClass {
	
	@Test
	public void ManageProductTest() throws IOException, InterruptedException {
	  
		int random = jLib.getRandomNo();
		String imgpath = fLib.readDataFromPropertyFile("imgpath");
	
		//get Testdata from excel file
		String catName = eLib.readDataFromExcel("Category", 0, 1)+random;
		String catDescription = eLib.readDataFromExcel("Category", 1, 1);
		String subname = eLib.readDataFromExcel("Category", 2, 1);
		String psp = eLib.readDataFromExcel("Insert Product", 5, 1);
		String productAvailability = eLib.readDataFromExcel("search", 2, 1);
	  	
		//Click on create category
	  	AdminHomePage ahp = new AdminHomePage(driver);
	  	ahp.clickCreateCategoryLink();
		
		//enter details and create category
	  	CreateCategoryPage ccp = new CreateCategoryPage(driver);
	  	ccp.CreateCategory(catName, catDescription);

	  	eLib.writeDataIntoExcel("created category", 0, 0, catName);
	  	
		//click subcategory
		ahp.clickSubCategoryLink();
		
		//create sub category
		SubCategoryPage scp = new SubCategoryPage(driver);
		scp.createSubCategory(catName, subname);
		
		eLib.writeDataIntoExcel("created category", 1, 0, subname);
		
		//click on Insert Product
		ahp.clickInsertProductLink();
		InsertProductPage ipp = new InsertProductPage(driver);
		ipp.insertProduct(catName, subname, eLib.HashMapData("Insert Product", 0), driver, psp,productAvailability, imgpath, imgpath, imgpath);
		
        //click on manage product
		ahp.clickManageProductLink();
		ManageProductPage mcp = new ManageProductPage(driver);
		mcp.manageCategorySearchAndDeleteProduct(driver, catName);
		
}
}
