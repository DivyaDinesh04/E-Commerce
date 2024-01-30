package com.TestScript_POM;

import static org.testng.Assert.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import com.ObjectRepository.AdminHomePage;
import com.ObjectRepository.ManageProductPage;
import com.genericUtility.BaseClass;

//@Listeners(com.genericUtility.ListnerImplementClass.class)
public class SmokeManageProductPOMTest extends BaseClass{

	@Test
	public void SmokeManageProductTest() throws IOException 
	{

		//click on manage product
	  	AdminHomePage ahp = new AdminHomePage(driver);
	  	ahp.clickManageProductLink();
	  	String expData = "Manage Products";
	  	
	  	ManageProductPage mpp = new ManageProductPage(driver);
	  	String actualData = mpp.ManageProductPageTitle();
		
		assertEquals(actualData, expData, "Manage Products page not loaded properly");
        System.out.println("manage product page displayed");
	}
	
	
}
