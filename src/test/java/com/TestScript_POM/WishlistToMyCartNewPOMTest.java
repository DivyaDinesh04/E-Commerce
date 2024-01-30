package com.TestScript_POM;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.ObjectRepository.CreateNewAccountPage;
import com.ObjectRepository.MyCartPage;
import com.ObjectRepository.ShippingBillingAddPage;
import com.ObjectRepository.UserHomePage;
import com.ObjectRepository.UserLoginPage;
import com.genericUtility.ExcelUtils;
import com.genericUtility.FileUtils;
import com.genericUtility.JavaUtils;
import com.genericUtility.WebDriverUtils;

public class WishlistToMyCartNewPOMTest {

	@Test(groups = "regression")
	public void WishlistToMyCartTest() throws IOException {

		FileUtils fLib = new FileUtils();
		ExcelUtils eLib = new ExcelUtils();
		WebDriverUtils wLib = new WebDriverUtils();
		JavaUtils jLib = new JavaUtils();
		
		int random = jLib.getRandomNo();
		
		// get common data from property file
		String UURL = fLib.readDataFromPropertyFile("uurl");
		String CNUser = "createNewUser";
		//get data from excel file
		String FullName = eLib.readDataFromExcel(CNUser, 0, 1)+random;
		String email = eLib.readDataFromExcel(CNUser, 1, 1)+random;
		String contactNo = eLib.readDataFromExcel(CNUser, 2, 1);
		String password = eLib.readDataFromExcel(CNUser, 3, 1);
		String confirmPass = eLib.readDataFromExcel(CNUser, 4, 1);
		 //get Testdata from excel file
	    String searchPro = eLib.readDataFromExcel("search", 0, 0);
	    String pro_name = eLib.readDataFromExcel("search", 0, 1);

	    //launch browser
	    WebDriver driver = new ChromeDriver();
	 
	    //maximize the browser
	  	wLib.windowMax(driver);
	  		
	  	//enter url
	  	driver.get(UURL);
	  	
	  	//wait pageload statement
	  	wLib.waitPageLoad(driver, 10);
	  	
	  	//create new user account
	  	CreateNewAccountPage cna = new CreateNewAccountPage(driver);
	  	cna.createNewUser(FullName, email, contactNo, password, confirmPass, driver);
	  
	  	eLib.writeDataIntoExcel(CNUser, 7, 0, FullName);
	  	eLib.writeDataIntoExcel(CNUser, 8, 0, email);
	  	
	  	//login application with new user credential
	  	UserLoginPage ulp = new UserLoginPage(driver);
	  	ulp.userLoginToApp(email, password);
	  	
	  	//search product
	  	UserHomePage uhp = new UserHomePage(driver);
	  	uhp.searchProduct(searchPro);
	  	uhp.addProductToWishlist(pro_name, driver);
	  	
	    //add product to my cart
	  	MyCartPage mcp = new MyCartPage(driver);
	  	mcp.addProductToMyCart(driver, pro_name);
	  	
	  	//shipping and billing address
	  	ShippingBillingAddPage sba = new ShippingBillingAddPage(driver);
	  	sba.hashmapBAddress(driver, eLib.HashMapData("BAddress", 0));
	  	sba.hashmapSAddress(driver, eLib.HashMapData("SAddress", 0));
	  	
	  	//place order
	  	mcp.placeOrder(driver, pro_name);
	  	
	  	//logout application
	  	uhp.logoutApp();
	  
	  	//close driver
	  	driver.quit();
	}

}
