package com.MyCart_Module;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ObjectRepository.MyCartPage;
import com.ObjectRepository.UserHomePage;
import com.ObjectRepository.UserLoginPage;
import com.genericUtility.ExcelUtils;
import com.genericUtility.FileUtils;
import com.genericUtility.WebDriverUtils;

public class WishlistToMyCartPOMTest {
public static void main(String[] args) throws IOException {
	
	FileUtils fLib = new FileUtils();
	ExcelUtils eLib = new ExcelUtils();
	WebDriverUtils wLib = new WebDriverUtils();
	
	// get common data from property file
	String UURL = fLib.readDataFromPropertyFile("uurl");
	String UUSERNAME = fLib.readDataFromPropertyFile("uusername");
    String UPASSWORD = fLib.readDataFromPropertyFile("upassword");

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
  	
  	//login to application
  	UserLoginPage ulp = new UserLoginPage(driver);
  	ulp.userLoginToApp(UUSERNAME, UPASSWORD);
  	
  	//search product
  	UserHomePage uhp = new UserHomePage(driver);
  	uhp.searchProduct(searchPro);
  	uhp.addProductToWishlist(pro_name, driver);
  	
    //add product to my cart
  	MyCartPage mcp = new MyCartPage(driver);
  	mcp.addProductToMyCart(driver, pro_name);
  	mcp.placeOrder(driver, pro_name);
  	
  	uhp.logoutApp();
  
  	//close driver
  	driver.quit();
}
}
