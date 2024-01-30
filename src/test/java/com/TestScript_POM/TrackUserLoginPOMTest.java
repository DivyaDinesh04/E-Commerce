package com.TestScript_POM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepository.AdminHomePage;
import com.ObjectRepository.AdminLoginPage;
import com.ObjectRepository.MyCartPage;
import com.ObjectRepository.OrderHistoryPage;
import com.ObjectRepository.OrderTrackingCWPage;
import com.ObjectRepository.PendingOrderPage;
import com.ObjectRepository.UserHomePage;
import com.ObjectRepository.UserLoginLogPage;
import com.ObjectRepository.UserLoginPage;
import com.genericUtility.ExcelUtils;
import com.genericUtility.FileUtils;
import com.genericUtility.JavaUtils;
import com.genericUtility.WebDriverUtils;

//@Listeners(com.genericUtility.ListnerImplementClass.class)
public class TrackUserLoginPOMTest {

	@Test(groups = {"smoke","regression"})
	public void TrackUserLoginTest() throws IOException, InterruptedException {

		FileUtils fLib = new FileUtils();
		ExcelUtils eLib = new ExcelUtils();
		WebDriverUtils wLib = new WebDriverUtils();
		JavaUtils jLib = new JavaUtils();
		
		//Get common data from property file
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
		String UURL = fLib.readDataFromPropertyFile("uurl");
	    String NUSERNAME = fLib.readDataFromPropertyFile("newusername");
	    String NPASSWORD = fLib.readDataFromPropertyFile("newpassword");
	    
	    //get Testdata from excel file
	    String searchPro = eLib.readDataFromExcel("search", 0, 0);
	    String pro_name = eLib.readDataFromExcel("search", 0, 1);
	    
	    //launch browser
	    WebDriver driver = new ChromeDriver();
	 
	    //maximize the browser
	  	wLib.windowMax(driver);
	 
	  	//enter User url
	  	driver.get(UURL);
	  	
	  	//wait pageload statement
	    wLib.waitPageLoad(driver, 20);
	  	
	  	//login to application
	    UserLoginPage ulp = new UserLoginPage(driver);
	    ulp.userLoginToApp(NUSERNAME, NPASSWORD);
	
	  	String date = jLib.getSystemDate();
	  	System.out.println(date);
	  	
	    //search product
	  	UserHomePage uhp = new UserHomePage(driver);
	  	uhp.searchProduct(searchPro);
	  	uhp.addProductToWishlist(pro_name, driver);
	  	
	    //add product to my cart
	  	MyCartPage mcp = new MyCartPage(driver);
	  	mcp.addProductToMyCart(driver, pro_name);
	  	mcp.placeOrder(driver, pro_name);
	  			
	    //click on order history
	  	uhp.clickMyAccountLink();
	  	OrderHistoryPage ohp = new OrderHistoryPage(driver);
	  	ohp.OrderHistoryPageTitle();
	  	
	  	ohp.getLastPlacedOrder(pro_name, driver);
	  	
	  	//handle child popup window
	  	OrderTrackingCWPage otp = new OrderTrackingCWPage(driver);
	  	otp.switchToChildWindow(driver);
	  	String pOrderNum = otp.getOrderNumber();
	  	otp.closeAndSwitchToParentWin(driver);
	  	
	    //logout application
	  	uhp.logoutApp();
	
	  	//open new tab
	  	wLib.openNewTab(driver);
	  	
	  	//enter admin url
	  	driver.get(URL);
	  	
		//login to application as admin
	  	AdminLoginPage alp = new AdminLoginPage(driver);
	  	alp.adminLoginToApp(USERNAME, PASSWORD);
		
	    //track user placed order in pending order
	  	AdminHomePage ahp = new AdminHomePage(driver);
	  	ahp.clickorderManagementLink();
	    
	  	ahp.clickpendingOrderLink(driver);
	  	PendingOrderPage pop = new PendingOrderPage(driver);
	  	pop.showEntries100();
	  	pop.searchProduct(NUSERNAME);
	  	String aOrderNum = pop.getLastOrderNum(driver, NUSERNAME);
	  	Assert.assertEquals(aOrderNum, pOrderNum, "order not placed");
	    System.out.println("user order is displaed in admin's pending order. order number: "+aOrderNum);
		
		//click on user login log link
		UserLoginLogPage ull = new UserLoginLogPage(driver);
		ull.clickUserLoginLogLink();
		String login_time = ull.lastUserLoginTime(driver, NUSERNAME);
		System.out.println("user login time: "+ login_time);
	
	    //logout application
		ahp.adminLogout();
	  	
	  	//close driver
	  	driver.quit();
	}

}
